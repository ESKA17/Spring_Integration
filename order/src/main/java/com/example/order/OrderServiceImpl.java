package com.example.order;

public class OrderServiceImpl implements OrderService {
    @Override
    public void createOrder(OrderRequest orderRequest) {
        OrderModel order = OrderModel.builder()
                .amount(orderRequest.getAmount())
                .email(orderRequest.getEmail())
                .payed(false)
                .build();
    }
}
