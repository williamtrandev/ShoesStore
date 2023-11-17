package com.trantanthanh.springcommerce.utils;

import com.trantanthanh.springcommerce.dto.*;
import com.trantanthanh.springcommerce.model.*;

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
        shoesVariationDTO.setSizeId(cartItem.getShoesVariation().getSize().getId());
        shoesVariationDTO.setSizeValue(cartItem.getShoesVariation().getSize().getSizeValue());
        shoesVariationDTO.setShoesColorId(cartItem.getShoesVariation().getShoesColor().getId());

        cartItemDTO.setShoesVariationDTO(shoesVariationDTO);
        cartItemDTO.setQuantity(cartItem.getQuantity());
        cartItemDTO.setPrice(cartItem.getPrice());
        return cartItemDTO;
    }

    public static List<CartItemDTO> convertToListCartItemDTO(List<CartItem> cartItemList) {
        List<CartItemDTO> cartItemDTOList = new ArrayList<>();
        for(CartItem cartItem : cartItemList) {
            cartItemDTOList.add(convertToCartItemDTO(cartItem));
        }
        return cartItemDTOList;
    }

    public static CustomerDTO convertToCustomerDTO(User customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setPhone(customer.getPhone());
        customerDTO.setId(customer.getId());
        customerDTO.setName(customer.getName());
        customerDTO.setAddress(customer.getAddress());
        return customerDTO;
    }

    public static OrderDTO convertToOrderDTO(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setDateOrder(order.getDateOrder());
        orderDTO.setStatus(order.getStatus());
        orderDTO.setCustomerId(order.getCustomer().getId());
        orderDTO.setTotal(order.getTotal());
        orderDTO.setOrderLineDTOList(Mapping.convertToListOrderLineDTO(order.getOrderLineList()));
        return orderDTO;
    }
    public static List<OrderDTO> convertToListOrderDTO(List<Order> orderList) {
        List<OrderDTO> orderDTOList = new ArrayList<>();
        for(Order order : orderList) {
            orderDTOList.add(convertToOrderDTO(order));
        }
        return orderDTOList;
    }

    public static OrderLineDTO convertToOrderLineDTO(OrderLine orderLine) {
        OrderLineDTO orderLineDTO = new OrderLineDTO();
        orderLineDTO.setId(orderLine.getId());
        orderLineDTO.setPrice(orderLine.getPrice());
        orderLineDTO.setQuantity(orderLine.getQuantity());
        orderLineDTO.setShoesOrderId(orderLine.getOrder().getId());
        orderLineDTO.setShoesVariationId(orderLine.getShoesVariation().getId());
        orderLineDTO.setShoesVariationDTO(Mapping.convertToShoesVariationDTO(orderLine.getShoesVariation()));
        orderLineDTO.setImagePath(orderLine.getShoesVariation().getShoesColor().getImagePath());
        orderLineDTO.setShoesName(orderLine.getShoesVariation().getShoesColor().getShoes().getName());
        return orderLineDTO;
    }
    public static List<OrderLineDTO> convertToListOrderLineDTO(List<OrderLine> orderLineList) {
        List<OrderLineDTO> orderLineDTOList = new ArrayList<>();
        for(OrderLine orderLine : orderLineList) {
            orderLineDTOList.add(convertToOrderLineDTO(orderLine));
        }
        return orderLineDTOList;
    }
}
