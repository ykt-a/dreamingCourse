package com.dreamingCourse.mapper;

import com.dreamingCourse.entity.ReceiveInfo;

import java.util.List;

public interface ReceiveInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ykt_receive_info
     *
     * @mbggenerated Mon Aug 12 20:20:16 CST 2019
     */
    ReceiveInfo deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ykt_receive_info
     *
     * @mbggenerated Mon Aug 12 20:20:16 CST 2019
     */
    ReceiveInfo insert(ReceiveInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ykt_receive_info
     *
     * @mbggenerated Mon Aug 12 20:20:16 CST 2019
     */
    ReceiveInfo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ykt_receive_info
     *
     * @mbggenerated Mon Aug 12 20:20:16 CST 2019
     */
    List<ReceiveInfo> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ykt_receive_info
     *
     * @mbggenerated Mon Aug 12 20:20:16 CST 2019
     */
    ReceiveInfo updateByPrimaryKey(ReceiveInfo record);
}