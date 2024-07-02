package com.suhani.demo.services.executor;

import com.suhani.demo.dto.request.AddDealRequestDto;
import com.suhani.demo.dto.request.PlaceOrderRequestDto;
import com.suhani.demo.dto.response.Response;
import com.suhani.demo.services.OrdersDealService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrdersDealExecutorService {

    @Autowired
    private OrdersDealService ordersDealService;

    public Response<?> placeOrder(PlaceOrderRequestDto requestDto) {
        if(requestDto.getPlacedItems().isEmpty()) {
        log.error("Order must contain items");
        }else {
            requestDto.getPlacedItems()
                    .forEach(orderItemsRequest -> {
                        if(orderItemsRequest.getQuantity()==0){
                            log.error("Product quantity  must be greater then zero");
                        }
                    });
            ordersDealService.placeOrder(requestDto);
            return new Response<>();
        }
        return null;
    }

    public Response<?> addDeal(AddDealRequestDto requestDto) throws Exception {
        ordersDealService.addDeal(requestDto);
        return new Response<>();
    }
}
