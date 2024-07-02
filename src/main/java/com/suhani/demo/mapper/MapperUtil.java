package com.suhani.demo.mapper;

import com.suhani.demo.dto.request.*;
import com.suhani.demo.repository.model.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MapperUtil {
    public Customer toCustomer(BoardCustomerRequestDto requestDto) {
        Customer customer = new Customer();
        customer.setName(requestDto.getName());
        customer.setContact(requestDto.getContact());
        return customer;
    }

    public Deal toDealsConfig(AddDealRequestDto requestDto, Products product) {
        Deal deal = new Deal();
        deal.setDealBanner(requestDto.getDealBanner());
        deal.setDealEndTime(requestDto.getDealEndTime());
        deal.setDealStartTime(requestDto.getDealStartTime());
        deal.setProduct(product);
       // deal.setSaleQuantityRemaining();
        return null;
    }

    public Seller toSeller(OnboardSellerRequestDto requestDto) {
        Seller seller = new Seller();
        seller.setName(requestDto.getName());
        seller.setContact(requestDto.getContact());
        seller.setEmail(requestDto.getEmail());
        seller.setAadharNumber(requestDto.getAadharNumber());
        seller.setGstin(requestDto.getGstin());
        seller.setPanNumber(requestDto.getPanNumber());
        return seller;
    }

    public Products toProduct(AddProductRequestDto requestDto, Seller seller) {
        Products products = new Products();
        products.setName(requestDto.getName());
        products.setSeller(seller);
        products.setRemainingStock(requestDto.getTotalStock());
        products.setTotalStock(requestDto.getTotalStock());
        products.setUom(requestDto.getUom());
        products.setMaxSellingPrice(requestDto.getMaxSellingPrice());
        products.setUnitValue(requestDto.getUnitValue());
        return products;
    }

    public Order toOrders(PlaceOrderRequestDto requestDto, Customer customer, LocalDateTime now) {
        Order  order = new Order();
        order.setCustomer(customer);
        order.setAmountCollected(requestDto.getAmountCollected());
        order.setOrderProcessingTime(now);
        //
        return order;
    }

    public OrderItems toOrderItems(Deal dealsConfig, Products product, Order orders, OrderItemsRequest orderItemsRequest) {
        OrderItems orderItems = new OrderItems();
        orderItems.setOrders(orders);
        orderItems.setProduct(product);
        orderItems.setQuantity(orderItemsRequest.getQuantity());

        //more object to be set
        return orderItems;
    }
}
