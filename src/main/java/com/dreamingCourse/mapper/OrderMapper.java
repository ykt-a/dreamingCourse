package com.dreamingCourse.mapper;

import com.dreamingCourse.entity.Order;

import java.util.List;

public interface OrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ykt_order
     *
     * @mbggenerated Tue Jul 30 17:00:31 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ykt_order
     *
     * @mbggenerated Tue Jul 30 17:00:31 CST 2019
     */
    int insert(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ykt_order
     *
     * @mbggenerated Tue Jul 30 17:00:31 CST 2019
     */
    Order selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ykt_order
     *
     * @mbggenerated Tue Jul 30 17:00:31 CST 2019
     */
    List<Order> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ykt_order
     *
     * @mbggenerated Tue Jul 30 17:00:31 CST 2019
     */
    int updateByPrimaryKey(Order record);
}