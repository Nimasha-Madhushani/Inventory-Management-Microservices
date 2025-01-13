package com.example.inventory.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Inventory
{
  @Id
  private int id;
  private String inventoryName;
  private String inventoryDescription;
}
