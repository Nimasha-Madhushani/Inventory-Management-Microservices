package com.example.order.dto;


import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO
{
  @Id
  private int id;
  private String orderName;
  private String orderDescription;

}
