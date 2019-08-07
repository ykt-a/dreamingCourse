package com.dreamingCourse.service;

import com.dreamingCourse.entity.OrderItem;

import java.util.List;

public interface OrderItemService {

     List<OrderItem> findItemByUserIdAndOrderNum(Integer userId, Long orderNumber);
}



 /*int insert(OrderItem record);

    int deleteByPrimaryKey(Integer id);

    OrderItem selectByPrimaryKey(Integer id);

*/