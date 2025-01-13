package com.example.product.service;

import java.util.List;

import javax.transaction.Transactional;

import com.example.product.dto.ProductDTO;
import com.example.product.model.Product;
import com.example.product.repo.ProductRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductService
{
  @Autowired
  private ProductRepo productRepo;
  @Autowired
  private ModelMapper modelMapper;

  public List<ProductDTO> getAllProducts()
  {
    List<Product> userList = productRepo.findAll();
    return modelMapper.map(userList, new TypeToken<List<ProductDTO>>()
    {
    }.getType());
  }

//  public UserDTO getUserById(Integer userId)
//  {
//    User user = userRepo.findById(userId).get();
//    return modelMapper.map(user, UserDTO.class);
//  }

  //using query
  public ProductDTO getProductById(Integer productId)
  {
    Product user = productRepo.findProductById(productId);
    return modelMapper.map(user, ProductDTO.class);
  }

  public ProductDTO saveProduct(ProductDTO productDTO)
  {
    productRepo.save(modelMapper.map(productDTO, Product.class));
    return productDTO;
  }

  public ProductDTO updateProduct(ProductDTO productDTO)
  {
    productRepo.save(modelMapper.map(productDTO, Product.class));
    return productDTO;//upsert concept, same as saving the user if user doesn't exist new user will be created
  }

  //  public String deleteUser(UserDTO userDTO){
  //    userRepo.delete(modelMapper.map(userDTO,User.class));
  //    return "User Deleted";
  //  }

  public String deleteProduct(Integer userId)
  {
    productRepo.deleteById(userId);
    return "User Deleted";
  }
}
