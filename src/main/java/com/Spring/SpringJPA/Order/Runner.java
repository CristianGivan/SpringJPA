package com.Spring.SpringJPA.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class Runner implements CommandLineRunner {
    private OrderRepository orderRepository;

    public Runner(@Autowired OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Order order1 = new Order("tip1", LocalDate.of(2022, 10, 21), OrderStatus.PENDING);
        Order order2 = new Order("tip2", LocalDate.of(2022, 10, 22), OrderStatus.RECEIVED);
        Order order3 = new Order("tip3", LocalDate.of(2022, 10, 23), OrderStatus.SHIPPED);
        Order order4 = new Order("tip4", LocalDate.of(2022, 10, 24), OrderStatus.RECEIVED);
        Order order5 = new Order("tip5", LocalDate.of(2022, 10, 25), OrderStatus.PENDING);
        orderRepository.save(order1);
        orderRepository.save(order2);
        orderRepository.save(order3);
        orderRepository.save(order4);
        orderRepository.save(order5);

        Order order = orderRepository.findById(1L).get();
        System.out.println(order);
        List<Order> orders = (List<Order>) orderRepository.findAll();
        //System.out.println(orders);
        order1.setOrderStatus(OrderStatus.RECEIVED);
        System.out.println(order1);
        orderRepository.save(order1);
        order=orderRepository.findById(1L).get();
        System.out.println(order);
        orderRepository.delete(order2);
        orderRepository.deleteById(4L);
        System.out.println(orderRepository.findAll());



    }
}
