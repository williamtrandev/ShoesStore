package com.trantanthanh.springcommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "shoes_variation")
public class ShoesVariation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shoes_color_id")
    private ShoesColor shoesColor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "size_id")
    private Size size;

    private int stock;

    @OneToMany(mappedBy = "shoesVariation", cascade = CascadeType.ALL)
    private List<OrderLine> orderLineList;

    @OneToMany(mappedBy = "shoesVariation", cascade = CascadeType.ALL)
    private List<CartItem> cartItemList;


}
