package com.dreamingCourse.service;

import com.dreamingCourse.common.ServerResponse;
import com.dreamingCourse.entity.Order;

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

}
