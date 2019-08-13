package com.controller;
import com.entiy.*;
import com.service.cartservice;
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
        cart a=myservice.findOne(map);
        if(a==null){
            user user=myservice.findUser(Integer.parseInt(userid));
            System.out.println(user);
            course course=myservice.findCourse(Integer.parseInt(courseid));
            System.out.println(course);
            Date insertTime=new Date();
            cart b=new cart();
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
            myservice.insert(b);
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
    //加入购物车
    @ResponseBody
    @RequestMapping("/insertOeder")
    public  int  insertOeder(String userid,String c[]){
        int orderStaus=0;
        Date createTime=new Date();
        Calendar closeTime= Calendar.getInstance();
        closeTime.add(Calendar.DATE, 7);
        Date b=closeTime.getTime();
        order order=new order();
        order.setUserId(Integer.parseInt(userid));
        order.setPayment(null);
        order.setCreateTime(createTime);
        order.setOrderNumber(1);
        order.setCloseTime(b);
        myservice.insertOeder(order);
        HashMap<String,Integer> ma=new HashMap<String, Integer>();
        BigDecimal total=new BigDecimal(0.00);
        for (int j=0;j<c.length;j++){
            ma.put("user_id",Integer.parseInt(userid));
            ma.put("course_id",Integer.parseInt(c[j]));
            cart  valuee=myservice.findOne(ma);
            orderItem yktOrderItem=new orderItem();
            yktOrderItem.setCourseId(valuee.getCourseId());
            yktOrderItem.setCurrentUnitPrice(valuee.getPrice());
            yktOrderItem.setIsAlive(1);
            yktOrderItem.setOrderId(myservice.fingOrderId(createTime));
            yktOrderItem.setQuantity(valuee.getQuantity());
            myservice.insertOrderItem(yktOrderItem);
            HashMap<String,Integer> mapp=new HashMap<String, Integer>();
            mapp.put("user_id",order.getUserId());
            mapp.put("course_id",yktOrderItem.getCourseId());
            myservice.deletesubmited(mapp);
            total=total.add(valuee.getPrice());
    }
        System.out.println(total);
        order o=new order();
        o.setPayment(total);
        o.setId(myservice.fingOrderId(createTime));
        myservice.updateordertotal(o);

//        HashMap<Integer,Object> map=new HashMap<Integer,Object>();
//        List<cart>  list=myservice.selectByuserId(Integer.parseInt(userid));
//
//        int i=1;
//        for (cart yktcart: list) {
//            map.put(i,yktcart);
//            i++;
//        }
//        int bbbb=1;
//        for ( Integer key:map.keySet()){
//            cart value= (cart) map.get(bbbb);
//            bbbb++;
//            System.out.println( value);
//            orderItem yktOrderItem=new orderItem();
//            yktOrderItem.setCourseId(value.getCourseId());
//            yktOrderItem.setCurrentUnitPrice(value.getPrice());
//            yktOrderItem.setIsAlive(1);
//            yktOrderItem.setOrderId(myservice.fingOrderId(createTime));
//            yktOrderItem.setQuantity(value.getQuantity());
//            myservice.insertOrderItem(yktOrderItem);
//            HashMap<String,Integer> mapp=new HashMap<String, Integer>();
//            mapp.put("user_id",order.getUserId());
//            mapp.put("course_id",yktOrderItem.getCourseId());
//            myservice.deletesubmited(mapp);
//        }
        return 1;
    }

}
