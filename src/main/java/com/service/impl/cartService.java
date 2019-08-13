package com.service.impl;

import com.entiy.*;
import com.mapper.cartMapper;
import com.service.cartservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class cartService implements cartservice {
    @Autowired
    private cartMapper ma;
    @Override
    public List<cart> findOrderByUserIdsubmissionStatus(Integer userid) {
        return ma.findOrderByUserIdsubmissionStatus(userid);
    }

    @Override
    public List<sendCart> findSome(int b) {
        return ma.findSome(b);
    }

    @Override
    public cart findOne(Map map) {
        return ma.findOne(map);
    }

    @Override
    public void insert(cart yktCart) {
       ma.insert(yktCart);
    }

    @Override
    public course findCourse(int b) {
        return ma.findCourse(b);
    }

    @Override
    public user findUser(int b) {
        return ma.findUser(b);
    }

    @Override
    public void updatequantity(cart yktCart) {
          ma.updatequantity(yktCart);
    }

    @Override
    public void deletesubmited(Map map) {
        ma.deletesubmited(map);
    }

    @Override
    public void updatesAlive(cart yktCart) {
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
    public void insertOeder(order order) {
       ma.insertOeder(order);
    }

    @Override
    public void insertOrderItem(orderItem yktOrderItem) {
          ma.insertOrderItem( yktOrderItem);
    }

    @Override
    public List<cart> selectByuserId(int userId) {
        return ma.selectByuserId(userId);
    }

    @Override
    public int fingOrderId(Date date) {
        return ma.fingOrderId(date);
    }

    @Override
    public void updateordertotal(order order) {
        ma.updateordertotal(order);
    }
}
