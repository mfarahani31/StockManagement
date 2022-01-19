package com.hoom.stockmanagement.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PRODUCTS")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product extends AuditModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "COLOR")
    private String color;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "STOCK")
    private Long stock = 100L;
}
