package com.trantanthanh.springcommerce.utils;

import com.trantanthanh.springcommerce.dto.*;
import com.trantanthanh.springcommerce.model.CartItem;
import com.trantanthanh.springcommerce.model.Shoes;
import com.trantanthanh.springcommerce.model.ShoesColor;
import com.trantanthanh.springcommerce.model.ShoesVariation;

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

    public static ShoesVariationDTO convertToShoesVariationDTO(ShoesVariation shoesVariation) {
        ShoesVariationDTO shoesVariationDTO = new ShoesVariationDTO();
        shoesVariationDTO.setId(shoesVariation.getId());
        shoesVariationDTO.setShoesColorId(shoesVariation.getShoesColor().getId());
        shoesVariationDTO.setSizeId(shoesVariation.getSize().getId());
        shoesVariationDTO.setSizeValue(shoesVariation.getSize().getSizeValue());
        shoesVariationDTO.setStock(shoesVariation.getStock());
        return shoesVariationDTO;
    }

    public static List<ShoesVariationDTO> convertToListShoesVariationDTO(List<ShoesVariation> shoesVariationList) {
        List<ShoesVariationDTO> shoesVariationDTOList = new ArrayList<>();
        for(ShoesVariation shoesVariation : shoesVariationList) {
            shoesVariationDTOList.add(convertToShoesVariationDTO(shoesVariation));
        }
        return shoesVariationDTOList;
    }

    public static CartItemDTO convertToCartItemDTO(CartItem cartItem) {
        CartItemDTO cartItemDTO = new CartItemDTO();
        // CustomerDTO
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(cartItem.getCustomer().getId());
        customerDTO.setName(cartItem.getCustomer().getName());
        customerDTO.setAddress(cartItem.getCustomer().getAddress());
        customerDTO.setPhone(cartItem.getCustomer().getPhone());

        cartItemDTO.setCustomerDTO(customerDTO);

        // ShoesVariationDTO
        ShoesVariationDTO shoesVariationDTO = new ShoesVariationDTO();
        shoesVariationDTO.setId(cartItem.getShoesVariation().getId());
        shoesVariationDTO.setStock(cartItem.getShoesVariation().getStock());
        shoesVariationDTO.setSizeId(cartItem.getShoesVariation().getSize().getId());
        shoesVariationDTO.setSizeValue(cartItem.getShoesVariation().getSize().getSizeValue());
        shoesVariationDTO.setShoesColorId(cartItem.getShoesVariation().getShoesColor().getId());

        cartItemDTO.setShoesVariationDTO(shoesVariationDTO);
        cartItemDTO.setQuantity(cartItem.getQuantity());
        cartItemDTO.setPrice(cartItem.getPrice());
        return cartItemDTO;
    }
}
