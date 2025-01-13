package com.example.order.repo;

import com.example.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer>
{
  @Query(value = "SELECT * FROM Orders WHERE id=?1", nativeQuery = true)
  Order findOrderById(Integer orderId);


  //  @Query(value = "SELECT * FROM User WHERE id=?1 AND name=?2", nativeQuery = true)
  //  User findUserById(Integer userId, String name);
}
