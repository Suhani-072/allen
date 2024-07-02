package com.suhani.demo.services;

import com.suhani.demo.dto.request.OnboardSellerRequestDto;
import com.suhani.demo.mapper.MapperUtil;
import com.suhani.demo.repository.model.Seller;
import com.suhani.demo.repository.service.SellerRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {

    @Autowired
    private SellerRepositoryService sellerRepoService;

    @Autowired
    private MapperUtil mapper;

    public void onboardSeller(OnboardSellerRequestDto requestDto) {
        sellerRepoService.save(mapper.toSeller(requestDto));
    }

    public Seller validateAndGetSellerById(Integer sellerId) {
        return sellerRepoService.validateAndGetSellerById(sellerId);
    }
}
