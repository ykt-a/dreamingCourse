package com.dreamingCourse.mapper;

import com.dreamingCourse.entity.Cart;

import java.util.List;

public interface CartMapper {


    //从购物车获取信息
    List<Cart> selectByUid(Integer id);

    Cart deleteByPrimaryKey(Integer id);

    Cart insert(Cart record);

    Cart selectByPrimaryKey(Integer id);

    List<Cart> selectAll();

    Cart updateByPrimaryKey(Cart record);
}