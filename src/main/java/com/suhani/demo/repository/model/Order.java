package com.suhani.demo.repository.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Table(name = "orders")
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    @ToString.Exclude
    private Customer customer;

    private String storeId;

    private Boolean status = Boolean.TRUE;

    private LocalDateTime orderProcessingTime;

    private String paymentType;

    private String paymentStatus;

    private String txnId;

    private Double amountToBeCollected = 0D;

    private Double amountCollected = 0D;
}
