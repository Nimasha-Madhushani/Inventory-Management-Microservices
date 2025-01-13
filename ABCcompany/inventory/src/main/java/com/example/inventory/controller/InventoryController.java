package com.example.inventory.controller;

import java.util.List;

import com.example.inventory.dto.InventoryDTO;
import com.example.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/")
public class InventoryController
{
  @Autowired
  private InventoryService inventoryService;

  @GetMapping("/getinventory")
  public List<InventoryDTO> getInventory()
  {
    return inventoryService.getAllInventory();
  }

  @GetMapping("/getinventory/{inventoryId}")
  public InventoryDTO getInventory(@PathVariable Integer inventoryId)
  {
    return inventoryService.getInventoryById(inventoryId);
  }

  @PostMapping("/addinventory")
  public InventoryDTO addInventory(@RequestBody InventoryDTO inventoryDTO)
  {
    return inventoryService.saveInventory(inventoryDTO);
  }

  @PutMapping("/updateinventory")
  public InventoryDTO updateInventory(@RequestBody InventoryDTO inventoryDTO)
  {
    return inventoryService.updateInventory(inventoryDTO);
  }

  //  @DeleteMapping("/deleteuser")
  //  public String deleteUser(@RequestBody UserDTO userDTO)
  //  {
  //    return userService.deleteUser(userDTO);
  //
  //  }

  @DeleteMapping("/deleteinventory/{inventoryId}")
  public String deleteInventory(@PathVariable int inventoryId)
  {
    InventoryDTO inventoryDTO = new InventoryDTO();
    return inventoryService.deleteInventory(inventoryId);

  }
}
