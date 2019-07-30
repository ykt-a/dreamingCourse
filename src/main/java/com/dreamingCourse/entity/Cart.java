package com.dreamingCourse.entity;

import java.util.Date;

public class Cart {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ykt_cart.id
     *
     * @mbggenerated Tue Jul 30 17:00:31 CST 2019
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ykt_cart.user_id
     *
     * @mbggenerated Tue Jul 30 17:00:31 CST 2019
     */
    private Integer userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ykt_cart.course_id
     *
     * @mbggenerated Tue Jul 30 17:00:31 CST 2019
     */
    private Integer courseId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ykt_cart.quantity
     *
     * @mbggenerated Tue Jul 30 17:00:31 CST 2019
     */
    private Integer quantity;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ykt_cart.create_time
     *
     * @mbggenerated Tue Jul 30 17:00:31 CST 2019
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ykt_cart.status
     *
     * @mbggenerated Tue Jul 30 17:00:31 CST 2019
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ykt_cart.is_alive
     *
     * @mbggenerated Tue Jul 30 17:00:31 CST 2019
     */
    private Integer isAlive;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ykt_cart.id
     *
     * @return the value of ykt_cart.id
     *
     * @mbggenerated Tue Jul 30 17:00:31 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ykt_cart.id
     *
     * @param id the value for ykt_cart.id
     *
     * @mbggenerated Tue Jul 30 17:00:31 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ykt_cart.user_id
     *
     * @return the value of ykt_cart.user_id
     *
     * @mbggenerated Tue Jul 30 17:00:31 CST 2019
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ykt_cart.user_id
     *
     * @param userId the value for ykt_cart.user_id
     *
     * @mbggenerated Tue Jul 30 17:00:31 CST 2019
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ykt_cart.course_id
     *
     * @return the value of ykt_cart.course_id
     *
     * @mbggenerated Tue Jul 30 17:00:31 CST 2019
     */
    public Integer getCourseId() {
        return courseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ykt_cart.course_id
     *
     * @param courseId the value for ykt_cart.course_id
     *
     * @mbggenerated Tue Jul 30 17:00:31 CST 2019
     */
    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ykt_cart.quantity
     *
     * @return the value of ykt_cart.quantity
     *
     * @mbggenerated Tue Jul 30 17:00:31 CST 2019
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ykt_cart.quantity
     *
     * @param quantity the value for ykt_cart.quantity
     *
     * @mbggenerated Tue Jul 30 17:00:31 CST 2019
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ykt_cart.create_time
     *
     * @return the value of ykt_cart.create_time
     *
     * @mbggenerated Tue Jul 30 17:00:31 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ykt_cart.create_time
     *
     * @param createTime the value for ykt_cart.create_time
     *
     * @mbggenerated Tue Jul 30 17:00:31 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ykt_cart.status
     *
     * @return the value of ykt_cart.status
     *
     * @mbggenerated Tue Jul 30 17:00:31 CST 2019
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ykt_cart.status
     *
     * @param status the value for ykt_cart.status
     *
     * @mbggenerated Tue Jul 30 17:00:31 CST 2019
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ykt_cart.is_alive
     *
     * @return the value of ykt_cart.is_alive
     *
     * @mbggenerated Tue Jul 30 17:00:31 CST 2019
     */
    public Integer getIsAlive() {
        return isAlive;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ykt_cart.is_alive
     *
     * @param isAlive the value for ykt_cart.is_alive
     *
     * @mbggenerated Tue Jul 30 17:00:31 CST 2019
     */
    public void setIsAlive(Integer isAlive) {
        this.isAlive = isAlive;
    }
}