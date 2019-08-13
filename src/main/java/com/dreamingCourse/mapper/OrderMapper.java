package com.dreamingCourse.mapper;

import com.dreamingCourse.entity.Course;
import com.dreamingCourse.entity.Order;
import com.dreamingCourse.entity.OrderVo;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface OrderMapper {


    Order findByUserIdAndOrderNum(@Param("userId") Integer userId, @Param("orderNumber") Long orderNumber);

    OrderVo selectByOrderNo(Long orderNum);

    OrderVo selectByOrderNo2(Long orderNum);

    OrderVo findDetailsByUserIdAndorderNumber(@Param("userId") Integer userId, @Param("orderNumber") Long orderNumber);

    Course getCourseName(Integer id);

    void updateByOrderNo(Long orderNum);

    void insertOrder(Order order);

    void closeFailureOrders(Long orderNum);

    List<Order> findAllOrder();

    List<Order> findOrdersByUid(Integer uid);

    List<Order> findUpaidOrderByUId(Integer uid);

    List<Order> findUAssessOrderByUId(Integer uid);

    //订单完成后删除
    void deleteOrder(Integer id);

    //================================yb==========================/
    Order deleteByPrimaryKey(Integer id);

    Order insert(Order record);

    Order selectByPrimaryKey(Integer id);

    List<Order> selectAll();

    Order updateByPrimaryKey(Order record);


}