package com.dreamingCourse.mapper;

import com.dreamingCourse.entity.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;
@Repository
public interface CartMapper {
    List<Cart> findOrderByUserIdsubmissionStatus(Integer userid);
    List<sendCart> findSome(int b);
    Cart findOne(Map map);
    void insert1(Cart yktCart);
    Course findCourse(int b);
    User findUser(int b);
    void updatequantity(Cart yktCart);
    void deletesubmited(Map map);
    void updatesAlive(Cart yktCart);
    void  updatstatus(Map map);
    String selectcourseId(Integer  id);
    void updatesubmissionStatus(Map map);
    void  insertOeder(Order order);
    void  insertOrderItem(OrderItem yktOrderItem);
    List<Cart> selectByuserId(int userId);
    int fingOrderId(Date date);
    void updateordertotal(Order order);


    //从购物车获取信息
    List<Cart> selectByUid(Integer id);

    Cart deleteByPrimaryKey(Integer id);

    Cart insert(Cart record);

    Cart selectByPrimaryKey(Integer id);

    List<Cart> selectAll();

    Cart updateByPrimaryKey(Cart record);
}