package com.dreamingCourse.mapper;



import com.dreamingCourse.entity.OrderItem;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrderItemMapper {

    /**
     * 支付模块
     * @param userId
     * @param orderNumber
     * @return
     */

    List<OrderItem> findItemByUserIdAndOrderNum(@Param("userId") Integer userId, @Param("orderNumber") Long orderNumber);
    OrderItem findItemByUserIdAndCourseId(@Param("userId") Integer userId, @Param("courseId") Integer courseId, @Param("orderNumber") Long orderNumber);
    int insertSelective(OrderItem record);
    //增加一个item对象
    void batchInsert(@Param("orderItemList") List<OrderItem> orderItemList);
}


/**
 * 订单模块
 */
    /*//通过订单编号查找

   //生成订单后对item状态进行软删除
    int deleteByPrimaryKey(Integer id);

    //通过订单id去查找对应的items
    OrderItem selectByPrimaryKey(Integer id);*/


