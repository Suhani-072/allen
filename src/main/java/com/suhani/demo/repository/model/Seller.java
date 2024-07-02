package com.suhani.demo.repository.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@DynamicUpdate
@Table(name = "seller")
@Entity
public class Seller  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String name;

    private String aadharNumber;

    private String panNumber;

    private Long contact;

    private String email;

    private String gstin;

    private Boolean status = Boolean.TRUE;
}
