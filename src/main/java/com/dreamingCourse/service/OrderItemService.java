package com.dreamingCourse.service;

import com.dreamingCourse.entity.OrderItem;

import java.util.List;

public interface OrderItemService {

    List<OrderItem> findItemByUserIdAndOrderNum(Integer userId, Long orderNumber);

    OrderItem deleteByPrimaryKey(Integer id);

    OrderItem insert(OrderItem record);

    OrderItem selectByPrimaryKey(Integer id);

    List<OrderItem> selectAll();

    OrderItem updateByPrimaryKey(OrderItem record);
}



 /*int insert(OrderItem record);

    int deleteByPrimaryKey(Integer id);

    OrderItem selectByPrimaryKey(Integer id);

*/