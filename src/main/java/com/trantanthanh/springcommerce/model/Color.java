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
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "color_value")
    private String colorValue;

    @Column(name = "color_code")
    private String colorCode;

    @OneToMany(mappedBy = "color", cascade = CascadeType.ALL)
    private List<ShoesColor> shoesColorList;
}
