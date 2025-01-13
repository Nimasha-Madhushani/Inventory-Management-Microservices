package com.example.order.service;

import java.util.List;

import com.example.order.dto.OrderDTO;
import com.example.order.model.Order;
import com.example.order.repo.OrderRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class OrderService
{
  @Autowired
  private OrderRepo orderRepo;
  @Autowired
  private ModelMapper modelMapper;

  public List<OrderDTO> getAllOrders()
  {
    List<Order> orderList = orderRepo.findAll();
    return modelMapper.map(orderList, new TypeToken<List<OrderDTO>>()
    {
    }.getType());
  }

  //  public UserDTO getUserById(Integer userId)
  //  {
  //    User user = userRepo.findById(userId).get();
  //    return modelMapper.map(user, UserDTO.class);
  //  }

  //using query
  public OrderDTO getOrderById(Integer orderId)
  {
    Order user = orderRepo.findOrderById(orderId);
    return modelMapper.map(user, OrderDTO.class);
  }

  public OrderDTO saveOrder(OrderDTO orderDTO)
  {
    orderRepo.save(modelMapper.map(orderDTO, Order.class));
    return orderDTO;
  }

  public OrderDTO updateOrder(OrderDTO orderDTO)
  {
    orderRepo.save(modelMapper.map(orderDTO, Order.class));
    return orderDTO;//upsert concept, same as saving the user if user doesn't exist new user will be created
  }

  //  public String deleteUser(UserDTO userDTO){
  //    userRepo.delete(modelMapper.map(userDTO,User.class));
  //    return "User Deleted";
  //  }

  public String deleteOrder(Integer orderId)
  {
    orderRepo.deleteById(orderId);
    return "Order Deleted";
  }
}
