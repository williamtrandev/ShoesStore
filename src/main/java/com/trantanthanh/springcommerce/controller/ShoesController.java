package com.trantanthanh.springcommerce.controller;

import com.trantanthanh.springcommerce.model.*;
import com.trantanthanh.springcommerce.service.impl.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/shoes")
public class ShoesController {
    private final BrandService brandService;
    private final CategoryService categoryService;
    private final SizeService sizeService;
    private final ColorService colorService;
    private final ShoesService shoesService;
    @GetMapping({"", "/"})
    public String index(Model model) {
        model.addAttribute("title", "Giày");

        // List of brands
        List<Brand> brandList = brandService.getAll();

        // List of categories
        List<Category> categoryList = categoryService.getAll();

        // List of sizes
        List<Size> sizeList =  sizeService.getAll();

        // List of colors
        List<Color> colorList = colorService.getAll();

        // List of shoes with color
        List<Shoes> shoesList = shoesService.getAllWithColor();

        model.addAttribute("brandList", brandList);
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("sizeList", sizeList);
        model.addAttribute("colorList", colorList);
        model.addAttribute("shoesList", shoesList);
        return "shoes";
    }
}
