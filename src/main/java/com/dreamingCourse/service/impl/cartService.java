package com.dreamingCourse.service.impl;

import com.dreamingCourse.entity.*;
import com.dreamingCourse.mapper.CartMapper;
import com.dreamingCourse.service.cartservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class cartService implements cartservice {
    @Autowired
    private CartMapper ma;
    @Override
    public List<Cart> findOrderByUserIdsubmissionStatus(Integer userid) {
        return ma.findOrderByUserIdsubmissionStatus(userid);
    }

    @Override
    public List<sendCart> findSome(int b) {
        return ma.findSome(b);
    }

    @Override
    public Cart findOne(Map map) {
        return ma.findOne(map);
    }

    @Override
    public void insert1(Cart yktCart) {
       ma.insert(yktCart);
    }

    @Override
    public Course findCourse(int b) {
        return ma.findCourse(b);
    }

    @Override
    public User findUser(int b) {
        return ma.findUser(b);
    }

    @Override
    public void updatequantity(Cart yktCart) {
          ma.updatequantity(yktCart);
    }

    @Override
    public void deletesubmited(Map map) {
        ma.deletesubmited(map);
    }

    @Override
    public void updatesAlive(Cart yktCart) {
        ma.updatesAlive(yktCart);

    }

    @Override
    public void updatstatus(Map map) {
         ma.updatstatus(map);
    }

    @Override
    public String selectcourseId(Integer id) {
        return ma.selectcourseId(id);
    }

    @Override
    public void updatesubmissionStatus(Map map) {
          ma.updatesubmissionStatus(map);
    }

    @Override
    public void insertOeder(Order order) {
       ma.insertOeder(order);
    }

    @Override
    public void insertOrderItem(OrderItem yktOrderItem) {
          ma.insertOrderItem( yktOrderItem);
    }

    @Override
    public List<Cart> selectByuserId(int userId) {
        return ma.selectByuserId(userId);
    }

    @Override
    public int fingOrderId(Date date) {
        return ma.fingOrderId(date);
    }

    @Override
    public void updateordertotal(Order order) {
        ma.updateordertotal(order);
    }
}
