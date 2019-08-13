package com.mapper;

import com.entiy.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;
@Repository
public interface cartMapper {
    List<cart> findOrderByUserIdsubmissionStatus(Integer userid);
    List<sendCart> findSome(int b);
    cart findOne(Map map);
    void insert(cart yktCart);
    course findCourse(int b);
    user findUser(int b);
    void updatequantity(cart yktCart);
    void deletesubmited(Map map);
    void updatesAlive(cart yktCart);
    void  updatstatus(Map map);
    String selectcourseId(Integer  id);
    void updatesubmissionStatus(Map map);
    void  insertOeder(order order);
    void  insertOrderItem(orderItem yktOrderItem);
    List<cart> selectByuserId(int userId);
    int fingOrderId(Date date);
    void updateordertotal(order order);
}
