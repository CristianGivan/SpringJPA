package com.Spring.SpringJPA.Order;

import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@RestController
public class OrderController {
    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders")

    public List<Order> findAll() {
        List<Order> orders=orderService.findAll();
        System.out.println(orders);
        return orders;
    }

    @GetMapping("/orders/{id}")
    public Order findOrderById(@PathVariable Long id) {
        try {
            return orderService.findById(id);
        } catch (OrderNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Order not found", e
            );
        }
    }

    /*    @GetMapping("/orders/LocalDateBetween")
        public List<Order> findOrdersBetweenDates(@RequestParam String after,
                                                  @RequestParam String before) {
            DateTimeFormatter dateTimeFormatter =DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate afterDate=LocalDate.parse(after,dateTimeFormatter);
            LocalDate beforeDate=LocalDate.parse(before,dateTimeFormatter);
            return orderService.findOrdersBetweenDates(afterDate, beforeDate);
        }*/
    @GetMapping("/orders/LocalDateBetween")
    public List<Order> findOrdersBetweenDates(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate after,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate before) {
        return orderService.findOrdersBetweenDates(after, before);
    }
    @PostMapping("/orders")
    public Order saveOrder(@RequestBody Order order){
        System.out.println(order);
        return orderService.saveOrder(order);
    }
    @PutMapping("/orders/{id}")
    public Order updateOrder(@RequestBody Order updatedOrder, @PathVariable Long id){
        try {
            return orderService.updateOrder(updatedOrder,id);
        } catch (OrderNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Order not found", e
            );
        }
    }
    @DeleteMapping("/orders/{id}")
    public void deleteOrder(@PathVariable Long id){
        orderService.deleteOrder(id);
    }
}
