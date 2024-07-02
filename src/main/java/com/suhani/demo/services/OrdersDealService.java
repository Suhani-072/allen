package com.suhani.demo.services;


import com.suhani.demo.dto.request.AddDealRequestDto;
import com.suhani.demo.dto.request.PlaceOrderRequestDto;
import com.suhani.demo.mapper.MapperUtil;
import com.suhani.demo.repository.model.*;
import com.suhani.demo.repository.service.CustomerRepositoryService;
import com.suhani.demo.repository.service.DealsConfigRepositoryService;
import com.suhani.demo.repository.service.OrderItemsRepositoryService;
import com.suhani.demo.repository.service.OrdersRepositoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Service
public class OrdersDealService {

    @Autowired
    private SellerService sellerService;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderItemsRepositoryService orderItemsRepositoryService;

    @Autowired
    private OrdersRepositoryService ordersRepositoryService;

    @Autowired
    private CustomerRepositoryService customerRepositoryService;

    @Autowired
    private DealsConfigRepositoryService dealsConfigRepositoryService;

    @Autowired
    private MapperUtil mapperUtil;

    public void addDeal(AddDealRequestDto requestDto) throws Exception {
        Seller seller = sellerService.validateAndGetSellerById(requestDto.getSellerId());
        Products product = productService.validateAndGetProductById(requestDto.getProductId());
        dealsConfigRepositoryService.save(mapperUtil.toDealsConfig(requestDto, product));
    }

    public void placeOrder(PlaceOrderRequestDto requestDto) {
        Customer customer = customerRepositoryService.validateAndGetCustomerById(requestDto.getCustomerId());
        Map<Integer, Deal> productDealsConfigMap = new HashMap<>();
        requestDto.getPlacedItems()
                .forEach(
                        orderItemsRequest -> {
                            Products product = productService.validateAndGetProductById(orderItemsRequest.getProductId());
                            Deal dealsConfig = dealsConfigRepositoryService.findByAvailableDealByProduct(product);
                                if(orderItemsRequest.getQuantity() > dealsConfig.getMaxQuantityPerOrder()){
                                    log.error("Max quantity limit per order breached!");
                                }
                                if(product.getRemainingStock() <= 0){
                                    log.error("Inventory out of stock!");
                                }
                            productDealsConfigMap.put(product.getId(), dealsConfig);
                        }
                );

        Order orders = ordersRepositoryService.save(mapperUtil.toOrders(requestDto, customer, LocalDateTime.now()));
        List<OrderItems> list = requestDto.getPlacedItems()
                .stream()
                .map(
                        orderItemsRequest -> {
                            Deal dealsConfig = productDealsConfigMap.get(orderItemsRequest.getProductId());
                            dealsConfig.setSaleQuantityRemaining(dealsConfig.getSaleQuantityRemaining() - orderItemsRequest.getQuantity());
                            dealsConfig = dealsConfigRepositoryService.save(dealsConfig);
                            dealsConfig.getProduct().setRemainingStock(dealsConfig.getProduct().getRemainingStock() - orderItemsRequest.getQuantity());
                            productService.save(dealsConfig.getProduct());
                            return mapperUtil.toOrderItems(dealsConfig, dealsConfig.getProduct(), orders, orderItemsRequest);
                        }
                ).toList();
        orderItemsRepositoryService.save(list);
    }
}
