package com.bjpowernode.dao;

import com.bjpowernode.daomain.OrderDetail;
import com.bjpowernode.daomain.OrderMessage;

import java.util.List;

public interface OrderDao {
    //增加订单信息
    int insertOrderMessage(OrderMessage orderMessage);

    //增加商品信息
    int insertOrderDetail(OrderDetail orderDetail);

    //删除订单信息
    int deleteOrderMessage(int id);
    //删除商品信息
    int deleteOrderDetail(int id);

    //查询
    List<OrderMessage> selectOrderMessage(String customerName);

    //查询
    List<OrderDetail> selectOrderDetail(String productName);

}
