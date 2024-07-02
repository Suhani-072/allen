package com.suhani.demo.repository.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@DynamicUpdate
@Table(name = "deals_config")
@Entity
public class Deal  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Version
    private Long version;

    @ManyToOne
    @JoinColumn(name = "seller_id", nullable = false)
    @ToString.Exclude
    private Seller seller;

    @Column(name = "deal_start_time", nullable = false)
    private LocalDateTime dealStartTime;

    @Column(name = "deal_end_time", nullable = false)
    private LocalDateTime dealEndTime;

    @Column(name = "deal_banner")
    private String dealBanner;

    @ManyToOne
    @JoinColumn(name = "product_id_on_sale", nullable = false)
    @ToString.Exclude
    private Products product;

    private Double discount;

    private Integer maxQuantityPerOrder;

    private Integer totalSaleQuantity;

    private Integer saleQuantityRemaining;

    private Boolean status = Boolean.TRUE;
}
