package com.dreamingCourse.mapper;

import com.dreamingCourse.entity.Lists;

import java.util.List;

public interface ListsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ykt_list
     *
     * @mbggenerated Mon Aug 12 21:15:46 CST 2019
     */
    Lists deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ykt_list
     *
     * @mbggenerated Mon Aug 12 21:15:46 CST 2019
     */
    Lists insert(Lists record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ykt_list
     *
     * @mbggenerated Mon Aug 12 21:15:46 CST 2019
     */
    Lists selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ykt_list
     *
     * @mbggenerated Mon Aug 12 21:15:46 CST 2019
     */
    List<Lists> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ykt_list
     *
     * @mbggenerated Mon Aug 12 21:15:46 CST 2019
     */
    Lists updateByPrimaryKey(Lists record);
}