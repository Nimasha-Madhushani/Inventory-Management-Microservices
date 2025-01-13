package com.example.product.dto;


import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO
{
  @Id
  private int id;
  private String productName;
  private String productDescription;

}
