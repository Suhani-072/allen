package com.suhani.demo.repository.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

@Data
@NoArgsConstructor
@DynamicUpdate
@Table(name = "order_items")
@Entity
public class OrderItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    @ToString.Exclude
    private Order orders;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    @ToString.Exclude
    private Products product;

    private String name;

    private Integer quantity;

    private Double pricePerUnit;

    private String uom;

    private String unitValue;
}
