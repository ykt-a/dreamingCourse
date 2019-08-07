package com.dreamingCourse.service.impl;

import com.dreamingCourse.entity.OrderItem;
import com.dreamingCourse.mapper.OrderItemMapper;
import com.dreamingCourse.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class OrderItemServiceImp implements OrderItemService, Serializable {

    @Autowired
    OrderItemMapper OrderItemMapper;


    @Override
    public List<OrderItem> findItemByUserIdAndOrderNum(Integer userId, Long orderNumber) {
        return OrderItemMapper.findItemByUserIdAndOrderNum(userId,orderNumber);

    }

    /*@Override
    public OrderItem findItemByUserIdAndCourseId(Integer userId, Integer courseId,Long orderNumber) {
        return OrderItemMapper.findItemByUserIdAndCourseId(userId,courseId,orderNumber);
    }*/

}
 /*@Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(OrderItem record) {
        return 0;
    }


    @Override
    public OrderItem selectByPrimaryKey(Integer id) {
        return null;
    }
    */



