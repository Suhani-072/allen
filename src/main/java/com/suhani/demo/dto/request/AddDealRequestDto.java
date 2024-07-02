package com.suhani.demo.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddDealRequestDto implements Serializable {

    private Integer sellerId;
    private Integer productId;
    private String dealBanner;
    private Double discount;
    private LocalDateTime dealStartTime;
    private LocalDateTime dealEndTime;
    private Integer maxQuantityPerOrder;
    private Integer totalSaleQuantity;
    private String triggeredBy;
}
