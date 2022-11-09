package com.Spring.SpringJPA.Order;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "id_order")
    private Long idOrder;
    @Column(name = "product_type")
    private String productType;
    @Column(name = "date")
    private LocalDate localDate;
    @Enumerated(EnumType.STRING)
    @Column(name = "order_status")
    private OrderStatus orderStatus;
    @Transient
    private String orderProgress;

    public Order() {
    }

    public Order(Long idOrder, String productType, LocalDate localDate, OrderStatus orderStatus, String orderProgress) {
        this.idOrder = idOrder;
        this.productType = productType;
        this.localDate  = localDate;
        this.orderStatus = orderStatus;
        this.orderProgress = orderProgress;
    }

    public Order(String productType, LocalDate localDate, OrderStatus orderStatus) {
        this.productType = productType;
        this.localDate = localDate;
        this.orderStatus = orderStatus;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate LocalDate) {
        this.localDate = localDate;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
    }

    public String getOrderProgress() {
        return orderProgress;
    }

    public void setOrderProgress(String orderProgress) {
        this.orderProgress = orderProgress;
    }

    @Override
    public String toString() {
        return "Order{" +
                "idOrder=" + idOrder +
                ", productType='" + productType + '\'' +
                ", localDate=" + localDate +
                ", orderStatus=" + orderStatus +
                ", orderProgress='" + orderProgress + '\'' +
                '}';
    }
}
