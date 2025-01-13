package com.example.inventory.service;

import java.util.List;

import javax.transaction.Transactional;

import com.example.inventory.dto.InventoryDTO;
import com.example.inventory.model.Inventory;
import com.example.inventory.repo.InventoryRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class InventoryService
{
  @Autowired
  private InventoryRepo inventoryRepo;

  @Autowired
  private ModelMapper modelMapper;

  public List<InventoryDTO> getAllInventory()
  {
    List<Inventory> inventoryList = inventoryRepo.findAll();
    return modelMapper.map(inventoryList, new TypeToken<List<InventoryDTO>>()
    {
    }.getType());
  }

  public InventoryDTO getInventoryById(Integer inventoryId)
  {
    Inventory inventory = inventoryRepo.findInventoryById(inventoryId);
    return modelMapper.map(inventory, InventoryDTO.class);
  }


  public InventoryDTO saveInventory(InventoryDTO inventoryDTO)
  {
    inventoryRepo.save(modelMapper.map(inventoryDTO, Inventory.class));
    return inventoryDTO;
  }

  public InventoryDTO updateInventory(InventoryDTO inventoryDTO)
  {
    inventoryRepo.save(modelMapper.map(inventoryDTO, Inventory.class));
    return inventoryDTO;//upsert concept, same as saving the user if user doesn't exist new user will be created
  }


  //  public String deleteUser(UserDTO userDTO){
  //    userRepo.delete(modelMapper.map(userDTO,User.class));
  //    return "User Deleted";
  //  }

  public String deleteInventory(Integer inventoryId)
  {
    inventoryRepo.deleteById(inventoryId);
    return "Inventory Deleted";
  }


}
