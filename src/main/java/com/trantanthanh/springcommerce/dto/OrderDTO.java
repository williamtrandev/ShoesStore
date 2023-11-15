package com.trantanthanh.springcommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Long id;
    private Date dateOrder;
    private String status;
    private double total;
    private Long customerId;
    private List<OrderLineDTO> orderLineDTOList;
}
