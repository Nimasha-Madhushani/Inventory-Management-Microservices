package com.example.order.controller;

import java.util.List;

import com.example.order.dto.OrderDTO;
import com.example.order.service.OrderService;
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
public class OrderController
{
  @Autowired
  private OrderService orderService;

  @GetMapping("/getorders")
  public List<OrderDTO> getOrders()
  {
    return orderService.getAllOrders();
  }

  @GetMapping("/getorder/{orderId}")
  public OrderDTO getOrders(@PathVariable Integer orderId)
  {
    return orderService.getOrderById(orderId);
  }

  @PostMapping("/addorder")
  public OrderDTO addOrder(@RequestBody OrderDTO orderDTO)
  {
    return orderService.saveOrder(orderDTO);
  }

  @PutMapping("/updateorder")
  public OrderDTO updateOrder(@RequestBody OrderDTO orderDTO)
  {
    return orderService.updateOrder(orderDTO);
  }

  //  @DeleteMapping("/deleteuser")
  //  public String deleteUser(@RequestBody UserDTO userDTO)
  //  {
  //    return userService.deleteUser(userDTO);
  //
  //  }

  @DeleteMapping("/deleteorder/{orderId}")
  public String deleteOrder(@PathVariable int orderId)
  {
    OrderDTO orderDTO = new OrderDTO();
    return orderService.deleteOrder(orderId);

  }

}