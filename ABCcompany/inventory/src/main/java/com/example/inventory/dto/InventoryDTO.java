package com.example.inventory.dto;


import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryDTO
{
  @Id
  private int id;
  private String inventoryName;
  private String inventoryDescription;
}
