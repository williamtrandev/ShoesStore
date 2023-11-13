package com.trantanthanh.springcommerce.utils;

import com.trantanthanh.springcommerce.dto.ColorDTO;
import com.trantanthanh.springcommerce.dto.ShoesColorDTO;
import com.trantanthanh.springcommerce.dto.ShoesDTO;
import com.trantanthanh.springcommerce.model.Shoes;
import com.trantanthanh.springcommerce.model.ShoesColor;

import java.util.ArrayList;
import java.util.List;

public class Mapping {
    public static ShoesDTO convertToShoesDTO(Shoes shoes) {
        ShoesDTO shoesDTO = new ShoesDTO();
        shoesDTO.setId(shoes.getId());
        shoesDTO.setName(shoes.getName());
        shoesDTO.setCategoryId(shoes.getCategory().getId());
        shoesDTO.setPrice(shoes.getPrice());
        shoesDTO.setBrandId(shoes.getBrand().getId());
        shoesDTO.setDescription(shoes.getDescription());
        shoesDTO.setShoesColorDTOList(convertToListShoesColorDTO(shoes.getShoesColorList()));
        return shoesDTO;
    }

    public static List<ShoesDTO> convertToListShoesDTO(List<Shoes> shoesList) {
        List<ShoesDTO> shoesDTOList = new ArrayList<>();
        for(Shoes shoes : shoesList) {
            shoesDTOList.add(convertToShoesDTO(shoes));
        }
        return shoesDTOList;
    }

    public static ShoesColorDTO convertToShoesColorDTO(ShoesColor shoesColor) {
        ShoesColorDTO shoesColorDTO = new ShoesColorDTO();
        shoesColorDTO.setId(shoesColor.getId());
        shoesColorDTO.setShoesId(shoesColor.getShoes().getId());
        ColorDTO colorDTO = new ColorDTO(shoesColor.getColor().getId(),
                shoesColor.getColor().getColorCode(), shoesColor.getColor().getColorValue());
        shoesColorDTO.setColorDTO(colorDTO);
        shoesColorDTO.setImagePath(shoesColor.getImagePath());
        return shoesColorDTO;
    }

    public static List<ShoesColorDTO> convertToListShoesColorDTO(List<ShoesColor> shoesColorList) {
        List<ShoesColorDTO> shoesColorDTOList = new ArrayList<>();
        for(ShoesColor shoesColor : shoesColorList) {
            shoesColorDTOList.add(convertToShoesColorDTO(shoesColor));
        }
        return shoesColorDTOList;
    }
}
