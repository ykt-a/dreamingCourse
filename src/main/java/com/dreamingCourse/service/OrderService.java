package com.dreamingCourse.service;

import com.dreamingCourse.common.ServerResponse;
import com.dreamingCourse.entity.Order;

import java.util.List;
import java.util.Map;

public interface OrderService {

    ServerResponse aliCallback(Map<String, String> params);

    ServerResponse createOrder(Integer userId);

    ServerResponse createOrderDirectly(Integer userId, Integer courseId);

    ServerResponse createOrderSecKill(Integer userId, Integer seckillGoodsId);

    ServerResponse findAllOrder();

    ServerResponse getOrderByUId(Integer uid);

    ServerResponse findUpaidOrderByUId(Integer uid);

    ServerResponse findUAssessOrderByUId(Integer uid);

    ServerResponse findDetailsByUserIdAndorderNumber(Integer userId, Long orderNumber);

    ServerResponse findOrdersByOrderNo(Long orderNumber);

    ServerResponse queryOrderPayStatus(Integer userId, Long orderNumber);

    void closeFailureOrders(Long orderNumber);

    void updateOrder(Order user);

    void deleteOrder(Integer id);

    //=================yb=================//
    Order deleteByPrimaryKey(Integer id);

    Order insert(Order record);

    Order selectByPrimaryKey(Integer id);

    List<Order> selectAll();

    Order updateByPrimaryKey(Order record);

}
