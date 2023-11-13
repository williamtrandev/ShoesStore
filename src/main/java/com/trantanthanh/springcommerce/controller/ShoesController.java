package com.trantanthanh.springcommerce.controller;

import com.trantanthanh.springcommerce.model.*;
import com.trantanthanh.springcommerce.service.impl.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        model.addAttribute("title", "Sản phẩm");

        // List of brands
        List<Brand> brandList = brandService.getAll();

        // List of categories
        List<Category> categoryList = categoryService.getAll();


        // List of colors
        List<Color> colorList = colorService.getAll();

        // List of shoes with color
        List<Shoes> shoesList = shoesService.getAllWithColor();

        model.addAttribute("brandList", brandList);
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("colorList", colorList);
        model.addAttribute("shoesList", shoesList);
        return "shoes";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable("id") Long id, Model model) {
        Shoes shoes = shoesService.getOne(id);
        model.addAttribute("shoes", shoes);
        model.addAttribute("title", shoes.getName());
        return "detail";
    }

    @GetMapping("/search")
    public String search(@RequestParam(name = "keyword") String name, Model model) {
        List<Shoes> shoesList = shoesService.searchByName(name);
        model.addAttribute("shoesList", shoesList);
        model.addAttribute("title", "Tìm kiếm");
        return "search";
    }
}
