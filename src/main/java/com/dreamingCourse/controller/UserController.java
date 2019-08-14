package com.dreamingCourse.controller;

import com.alibaba.fastjson.JSONObject;
import com.dreamingCourse.entity.yktUser;
import com.dreamingCourse.service.Ykt_UserService;
import com.zhenzi.sms.ZhenziSmsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
@Controller
@RequestMapping(value = {"/hello"})

public class UserController {
    @Autowired
    private Ykt_UserService yktUserService;
    //********************************************************
    private static final long serialVersionUID = 1L;
    //短信平台相关参数
//这个不用改
    private String apiUrl = "https://sms_developer.zhenzikj.com";
    //榛子云系统上获取
    private String appId = "100862";
    //登陆页面显示
    private String appSecret = "62358d10-bc0e-4152-a52c-578a8debc9b9";

    //*********************************************************
    //登陆
    @ResponseBody
    @RequestMapping(value = {"/denglu"})

    public boolean selectByUsername(@RequestParam("username") String username, @RequestParam("password") String password,
                                   HttpServletRequest request, HttpServletResponse response) {
            yktUser user = yktUserService.selectByUsername(username, password);
        if (user != null) {
            //session里面
            request.getSession().setAttribute("user_id", user.getId());
            String src=String.valueOf(user.getId());
            //cookie里面
            Cookie cookie=new Cookie("user_id",src);
            response.addCookie(cookie);
            return true;
        } else {
            return false;
        }
    }
    @ResponseBody
    @RequestMapping(value = {"/istrue"})
    public boolean insert(@RequestParam("username") String username, @RequestParam("password") String password,
                         @RequestParam("email") String email, @RequestParam("phone") String phone, @RequestParam("question") String question,
                         @RequestParam("answer") String answer, @RequestParam("image") String image,
                         @RequestParam("code") String code) {
        System.out.println(username + ":" + password + ":" + email + "**********");
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");    // 这里填写的是想要进行转换的时间格式
        Date date = new Date();      // 获取当前时间
        String src = format.format(date);
        System.out.println(src);

        Date time = null;
        try {
            time = format.parse(src);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int ss = 0;
        if (phone != null && username != null) {

            yktUser username1 = yktUserService.selectUsername(username);
            yktUser phone1 = yktUserService.selectPhone(phone);
            if (phone1 == null && username1 == null) {
                ss = yktUserService.insert(username, password,
                        email, phone, question,
                        answer, 1, image,
                        code, time, time);
            }
        }
        if (ss != 0) {
            return true;
        } else {
            return false;
        }
    }
    @ResponseBody
    @RequestMapping(value = {"/yrename"})
    public String yremame(@RequestParam("username") String username) {
        System.out.println("进入修改密码界面");

        yktUser question = yktUserService.selectQuestion(username);
        if (question != null) {
            System.out.println(question.getQuestion() + "***************");
            return  question.getQuestion() ;
        } else {
            return "用户不存在";
        }
    }
    @ResponseBody
    @RequestMapping(value = {"/input"})
    public String input(@RequestParam("username") String username, @RequestParam("answer") String answer) {
        yktUser answer1 = yktUserService.selectAnswer(username);
        if (answer.equals(answer1.getAnswer())) {
            return "input";
        } else {
            return "rename";
        }
    }
    @ResponseBody
    @RequestMapping(value = {"/yanzheng"})
    public String yanzheng(@RequestParam("password") String password, @RequestParam("username") String username) {

        System.out.println("输入答案界面");
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");    // 这里填写的是想要进行转换的时间格式
        Date date = new Date();      // 获取当前时间
        String src = format.format(date);
        System.out.println(src);

        Date time = null;
        try {
            time = format.parse(src);
        } catch (Exception e) {
            e.printStackTrace();
        }
        yktUserService.updateByUsername(username, password, time);
        return "hello";
    }
    @ResponseBody
    @RequestMapping(value = {"/phone"})
    public String phone() {
        System.out.println("手机登陆界面");
            return "tel";
    }

    //**************************************************
    @ResponseBody
    @RequestMapping(value = "/code")
    public boolean getCode(@RequestParam("phone") String phone, HttpSession httpSession,HttpServletRequest request, HttpServletResponse response) {
        yktUser member = yktUserService.selectByCode(phone);
        Boolean b = false;
        if (member != null) {
            try {
                JSONObject json = null;
                //随机生成验证码
                String code = String.valueOf(new Random().nextInt(999999));
                //将验证码通过榛子云接口发送至手机
                ZhenziSmsClient client = new ZhenziSmsClient(apiUrl, appId, appSecret);
                String result = client.send(phone, "您的验证码为:" + code + "，该码有效期为5分钟，该码只能使用一次!");

                json = JSONObject.parseObject(result);
                if (json.getIntValue("code") != 0) {//发送短信失败
                    return b;
                }
                //将验证码存到session中,同时存入创建时间
                //以json存放，这里使用的是阿里的fastjson
                json = new JSONObject();
                json.put("memPhone", phone);
                json.put("code", code);
                json.put("createTime", System.currentTimeMillis());
                // 将认证码存入SESSION
                httpSession.setAttribute("code", json);
                b = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return b;
    }
    //**************************************************
}