package com.Spring.SpringJPA.Order;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
    //List<Order> findAllByOrderStatusOrderStatusIn(List<OrderStatus> orderStatuses);
/*    Order findOrderByLocalDateBetween(LocalDate after,LocalDate before);
    Order findOrderByProductTypeContainsAndLocalDateAfter(String productType, LocalDate before);*/
    List<Order> findTopByOrderByProductType();

    List<Order> findOrdersByOrderStatus(OrderStatus orderStatus);

    @Query(value = "select o from Order o where o.orderStatus=:status",nativeQuery = false)
    List<Order> findAllOrdersByStatusQuery(@Param("status") OrderStatus orderStatus);

}
