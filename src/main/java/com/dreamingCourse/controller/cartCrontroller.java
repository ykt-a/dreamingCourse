package com.dreamingCourse.controller;

import com.dreamingCourse.entity.*;
import com.dreamingCourse.service.cartservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
@Controller
public class cartCrontroller {

    @Autowired
    private  cartservice myservice;
    //查有效信息
    @ResponseBody
    @RequestMapping("/findSome")
    public List<sendCart> findSome(String userid){
        List<sendCart> list = myservice.findSome(Integer.parseInt(userid));
        return list;
    }
    //加入购物车
    @ResponseBody
    @RequestMapping(value = "/insert")
    public int insert(String userid,String courseid){
        int status=0;
        HashMap<String,Integer> map=new HashMap<String,Integer>();
        map.put("user_id",Integer.parseInt(userid));
        map.put("course_id",Integer.parseInt(courseid));
        Cart a=myservice.findOne(map);
        if(a==null){
            User user=myservice.findUser(Integer.parseInt(userid));
            System.out.println(user);
            Course course=myservice.findCourse(Integer.parseInt(courseid));
            System.out.println(course);
            Date insertTime=new Date();
            Cart b=new Cart();
            b.setUserId(user.getId());
            b.setCourseId(course.getId());
            b.setQuantity(1);
            b.setActivityPrice(course.getActivityPrice());
            b.setTotal( new BigDecimal(course.getActivityPrice()));
            b.setPrice(course.getPrice());
            b.setCreateTime(insertTime);
            b.setStatus(1);
            b.setSubmissionStatus(0);
            b.setIsAlive(1);
            myservice.insert1(b);
            status=1;
        }
        else{
           status=0;
        }
        return status;
    }
    //用户删除
    @ResponseBody
    @RequestMapping("/updatestatus")
    public int updatestatus(String userid,String courseid){
        HashMap<String,Integer> map=new HashMap<String,Integer>();
        map.put("user_id",Integer.parseInt(userid));
        map.put("course_id",Integer.parseInt(courseid));
        myservice.updatstatus(map);
        return 1;
    }

    @ResponseBody
    @RequestMapping("/insertOeder")
    public  int  insertOeder(String userid,String c[]){
        int orderStaus=0;
        Date createTime=new Date();
        Calendar closeTime= Calendar.getInstance();
        closeTime.add(Calendar.DATE, 7);
        Date b=closeTime.getTime();
        Order order=new Order();
        order.setUserId(Integer.parseInt(userid));
        order.setPayment(null);
        order.setCreateTime(createTime);

        order.setCloseTime(b);
        myservice.insertOeder(order);
        HashMap<String,Integer> ma=new HashMap<String, Integer>();
        BigDecimal total=new BigDecimal(0.00);
        for (int j=0;j<c.length;j++){
            ma.put("user_id",Integer.parseInt(userid));
            ma.put("course_id",Integer.parseInt(c[j]));
            Cart valuee=myservice.findOne(ma);
            OrderItem yktOrderItem=new OrderItem();
            yktOrderItem.setCourseId(valuee.getCourseId());
            yktOrderItem.setCurrentUnitPrice(valuee.getPrice());
            yktOrderItem.setIsAlive(1);
            yktOrderItem.setQuantity(valuee.getQuantity());
            myservice.insertOrderItem(yktOrderItem);
            HashMap<String,Integer> mapp=new HashMap<String, Integer>();
            mapp.put("user_id",order.getUserId());
            mapp.put("course_id",yktOrderItem.getCourseId());
            myservice.deletesubmited(mapp);
            total=total.add(valuee.getPrice());
    }
        System.out.println(total);
        Order o=new Order();
        o.setPayment(total);
        o.setId(myservice.fingOrderId(createTime));
        myservice.updateordertotal(o);


        return 1;
    }

}
