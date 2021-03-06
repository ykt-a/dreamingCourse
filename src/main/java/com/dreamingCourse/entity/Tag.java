package com.dreamingCourse.entity;

import java.util.Date;

public class Tag {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ykt_tag.id
     *
     * @mbggenerated Tue Jul 30 17:00:31 CST 2019
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ykt_tag.course_id
     *
     * @mbggenerated Tue Jul 30 17:00:31 CST 2019
     */
    private Integer courseId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ykt_tag.parent_id
     *
     * @mbggenerated Tue Jul 30 17:00:31 CST 2019
     */
    private Integer parentId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ykt_tag.name
     *
     * @mbggenerated Tue Jul 30 17:00:31 CST 2019
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ykt_tag.is_hot
     *
     * @mbggenerated Tue Jul 30 17:00:31 CST 2019
     */
    private Integer isHot;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ykt_tag.create_time
     *
     * @mbggenerated Tue Jul 30 17:00:31 CST 2019
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ykt_tag.update_time
     *
     * @mbggenerated Tue Jul 30 17:00:31 CST 2019
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ykt_tag.is_alive
     *
     * @mbggenerated Tue Jul 30 17:00:31 CST 2019
     */
    private Integer isAlive;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ykt_tag.id
     *
     * @return the value of ykt_tag.id
     *
     * @mbggenerated Tue Jul 30 17:00:31 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ykt_tag.id
     *
     * @param id the value for ykt_tag.id
     *
     * @mbggenerated Tue Jul 30 17:00:31 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ykt_tag.course_id
     *
     * @return the value of ykt_tag.course_id
     *
     * @mbggenerated Tue Jul 30 17:00:31 CST 2019
     */
    public Integer getCourseId() {
        return courseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ykt_tag.course_id
     *
     * @param courseId the value for ykt_tag.course_id
     *
     * @mbggenerated Tue Jul 30 17:00:31 CST 2019
     */
    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ykt_tag.parent_id
     *
     * @return the value of ykt_tag.parent_id
     *
     * @mbggenerated Tue Jul 30 17:00:31 CST 2019
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ykt_tag.parent_id
     *
     * @param parentId the value for ykt_tag.parent_id
     *
     * @mbggenerated Tue Jul 30 17:00:31 CST 2019
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ykt_tag.name
     *
     * @return the value of ykt_tag.name
     *
     * @mbggenerated Tue Jul 30 17:00:31 CST 2019
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ykt_tag.name
     *
     * @param name the value for ykt_tag.name
     *
     * @mbggenerated Tue Jul 30 17:00:31 CST 2019
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ykt_tag.is_hot
     *
     * @return the value of ykt_tag.is_hot
     *
     * @mbggenerated Tue Jul 30 17:00:31 CST 2019
     */
    public Integer getIsHot() {
        return isHot;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ykt_tag.is_hot
     *
     * @param isHot the value for ykt_tag.is_hot
     *
     * @mbggenerated Tue Jul 30 17:00:31 CST 2019
     */
    public void setIsHot(Integer isHot) {
        this.isHot = isHot;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ykt_tag.create_time
     *
     * @return the value of ykt_tag.create_time
     *
     * @mbggenerated Tue Jul 30 17:00:31 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ykt_tag.create_time
     *
     * @param createTime the value for ykt_tag.create_time
     *
     * @mbggenerated Tue Jul 30 17:00:31 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ykt_tag.update_time
     *
     * @return the value of ykt_tag.update_time
     *
     * @mbggenerated Tue Jul 30 17:00:31 CST 2019
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ykt_tag.update_time
     *
     * @param updateTime the value for ykt_tag.update_time
     *
     * @mbggenerated Tue Jul 30 17:00:31 CST 2019
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ykt_tag.is_alive
     *
     * @return the value of ykt_tag.is_alive
     *
     * @mbggenerated Tue Jul 30 17:00:31 CST 2019
     */
    public Integer getIsAlive() {
        return isAlive;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ykt_tag.is_alive
     *
     * @param isAlive the value for ykt_tag.is_alive
     *
     * @mbggenerated Tue Jul 30 17:00:31 CST 2019
     */
    public void setIsAlive(Integer isAlive) {
        this.isAlive = isAlive;
    }
}