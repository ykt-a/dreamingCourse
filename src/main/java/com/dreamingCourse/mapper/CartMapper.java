package com.dreamingCourse.mapper;

import com.dreamingCourse.entity.Cart;

import java.util.List;

public interface CartMapper {


//从购物车获取信息
    List<Cart> selectByUid(Integer id);


    /*生成订单后，从购物车移除商品
    int updateByUid(Cart record);*/

}