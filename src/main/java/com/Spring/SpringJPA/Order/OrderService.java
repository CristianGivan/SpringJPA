package com.Spring.SpringJPA.Order;

import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> findAll(){
        return orderRepository.findAll();
    }
    public Order findById(Long id){
        return orderRepository.findById(id).orElseThrow(()->new OrderNotFoundException("Order not found!"));
/*
        Optional<Order> orderOptional=orderRepository.findById(id);
        if (orderOptional.isEmpty()){
            throw new OrderNotFoundException("Order not found!");
        }
        return orderOptional.get();
      */
    }
    public List<Order> findOrdersBetweenDates(LocalDate after, LocalDate before){
        return orderRepository.findOrdersByLocalDateAfterAndLocalDateBefore(after,before);
    }
    public Order saveOrder (Order order){

        return orderRepository.save(order);
    }
}
