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
public class Size {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "size_value")
    private int sizeValue;

    @OneToMany(mappedBy = "size", cascade = CascadeType.ALL)
    private List<ShoesVariation> shoesVariationList;
}

