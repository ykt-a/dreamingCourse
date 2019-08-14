package com.dreamingCourse.service.impl;

import com.dreamingCourse.common.Const;
import com.dreamingCourse.common.ServerResponse;
import com.dreamingCourse.entity.*;
import com.dreamingCourse.mapper.*;
import com.dreamingCourse.service.OrderService;
import com.dreamingCourse.utils.convert.DateTimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;

@Service
@Transactional
public class OrderServiceImp implements OrderService, Serializable {
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderItemMapper orderItemMapper;
    @Autowired
    private PayInfoMapper payInfoMapper;

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private SeckillGoodsMapper seckillGoodsMapper;


    private static final Logger log = LoggerFactory.getLogger(OrderServiceImp.class);


    @Override
    public ServerResponse createOrder(Integer userId) {

        Order order = new Order();
        List<Cart> cartList = cartMapper.selectByUid(userId);

        Date currentTime = new Date();
        Random random = new Random();
        order.setOrderNumber(currentTime.getTime() + random.nextInt(1000));
        order.setUserId(userId);
        // order.setPayment("购物车调方法");
        if (order == null) {
            return ServerResponse.createByErrorMessage("生成订单错误");
        }
        orderMapper.insertOrder(order);


        List<OrderItem> orderItemList = new ArrayList();

        for (Cart cart : cartList) {
            //插入 OrderItem
            OrderItem orderItem = new OrderItem();
            orderItem.setCourseId(cart.getCourseId());
            orderItem.setCurrentUnitPrice(cart.getPrice());
            orderItem.setQuantity(cart.getQuantity());
            orderItem.setUserId(userId);
            orderItem.setOrderNumber(order.getOrderNumber());
            order.setTotalPrice(cart.getTotal());
            orderItemList.add(orderItem);
        }
        //  orderItem.setOrderNumber(order.getOrderNumber());

        orderItemMapper.batchInsert(orderItemList);
        OrderVo orderVo = orderMapper.selectByOrderNo2(order.getOrderNumber());
        //4.新增订单状态
        //5.减库存

        return ServerResponse.createBySuccess(orderVo);
    }


    /**
     * 立即购买
     * @param userId
     * @param courseId
     * @return
     */
    @Override
    public ServerResponse createOrderDirectly(Integer userId, Integer courseId) {

        Order order = new Order();
        Course course = orderMapper.getCourseName(courseId);
        Date currentTime = new Date();
        Random random = new Random();
        order.setOrderNumber(currentTime.getTime() + random.nextInt(1000));
        order.setUserId(userId);
        // order.setPayment("购物车调方法");
        if (order == null) {
            return ServerResponse.createByErrorMessage("生成订单错误");
        }
        orderMapper.insertOrder(order);

        //插入 OrderItem
        OrderItem orderItem = new OrderItem();
        orderItem.setCourseId(courseId);
        orderItem.setCurrentUnitPrice(course.getPrice());
        orderItem.setQuantity(1);
        orderItem.setUserId(userId);
        orderItem.setOrderNumber(order.getOrderNumber());

        orderItemMapper.insertSelective(orderItem);

        OrderVo orderVo = orderMapper.selectByOrderNo2(order.getOrderNumber());
        //4.新增订单状态


        return ServerResponse.createBySuccess(orderVo);
    }

    @Override
    public ServerResponse createOrderSecKill(Integer userId, Integer seckillGoodsId) {
        Order order = new Order();

        Integer courseId = seckillGoodsMapper.getCourseID(seckillGoodsId);
        Course course = orderMapper.getCourseName(courseId);


        Date currentTime = new Date();
        Random random = new Random();
        order.setOrderNumber(currentTime.getTime() + random.nextInt(1000));
        order.setUserId(userId);
        BigDecimal price = seckillGoodsMapper.getCoursePrice(seckillGoodsId);
        order.setPayment(price);
        if (order == null) {
            return ServerResponse.createByErrorMessage("生成订单错误");
        }
        orderMapper.insertOrder(order);

        //插入 OrderItem
        OrderItem orderItem = new OrderItem();
        orderItem.setCourseId(courseId);
        orderItem.setCurrentUnitPrice(price);
        orderItem.setCourseName(course.getName());
        orderItem.setQuantity(1);
        orderItem.setUserId(userId);
        orderItem.setOrderNumber(order.getOrderNumber());

        orderItemMapper.insertSelective(orderItem);

        OrderVo orderVo = orderMapper.selectByOrderNo2(order.getOrderNumber());
        //4.新增订单状态


        return ServerResponse.createBySuccess(orderVo);
    }


    @Override
    public void closeFailureOrders(Long orderNumber) {
        this.orderMapper.closeFailureOrders(orderNumber);
    }


    @Override
    public ServerResponse getOrderByUId(Integer uid) {
        List<Order> orders = this.orderMapper.findOrdersByUid(uid);
        return ServerResponse.createBySuccess(orders);
    }

    @Override
    public ServerResponse findUpaidOrderByUId(Integer uid) {
        List<Order> orders = this.orderMapper.findUpaidOrderByUId(uid);
        return ServerResponse.createBySuccess(orders);
    }

    @Override
    public ServerResponse findUAssessOrderByUId(Integer uid) {
        List<Order> orders = this.orderMapper.findUAssessOrderByUId(uid);
        return ServerResponse.createBySuccess(orders);
    }

    @Override
    public ServerResponse findDetailsByUserIdAndorderNumber(Integer userId, Long orderNumber) {
        OrderVo orderVo = this.orderMapper.findDetailsByUserIdAndorderNumber(userId, orderNumber);
        return ServerResponse.createBySuccess(orderVo);
    }

    @Override
    public ServerResponse findOrdersByOrderNo(Long orderNumber) {
        OrderVo orderVo = this.orderMapper.selectByOrderNo(orderNumber);
        return ServerResponse.createBySuccess(orderVo);
    }

    @Override
    public ServerResponse findAllOrder() {
        List<Order> list = this.orderMapper.findAllOrder();
        return ServerResponse.createBySuccess(list);
    }

    @Override
    public void updateOrder(Order user) {

    }

    @Override
    public void deleteOrder(Integer id) {

        this.orderMapper.deleteOrder(id);
    }

    @Override
    public Order deleteByPrimaryKey(Integer id) {
        return orderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Order insert(Order record) {
        return orderMapper.insert(record);
    }

    @Override
    public Order selectByPrimaryKey(Integer id) {
        return orderMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Order> selectAll() {
        return orderMapper.selectAll();
    }

    @Override
    public Order updateByPrimaryKey(Order record) {
        return orderMapper.updateByPrimaryKey(record);
    }


    /**
     * 支付宝回调函数
     */
    public ServerResponse aliCallback(Map<String, String> params) {
        Long orderNo = Long.parseLong(params.get("out_trade_no"));
        String tradeNo = params.get("trade_no");
        String tradeStatus = params.get("trade_status");
        OrderVo order = orderMapper.selectByOrderNo(orderNo);
        if (order == null) {
            return ServerResponse.createByErrorMessage("非筑梦云课堂的订单,回调忽略");
        }
        if (order.getStatus() >= Const.OrderStatusEnum.PAID.getCode()) {
            return ServerResponse.createBySuccess("支付宝重复调用");
        }
        if (Const.AlipayCallback.TRADE_STATUS_TRADE_SUCCESS.equals(tradeStatus)) {
            order.setPayTime(DateTimeUtil.strToDate(params.get("gmt_payment")));
            order.setStatus(Const.OrderStatusEnum.PAID.getCode());

            PayInfo payInfo = new PayInfo();
            payInfo.setOrderNumber(order.getOrderNumber());
            payInfo.setPayPlatform(Const.PayPlatformEnum.ALIPAY.getCode());
            payInfo.setPlatformNumber(tradeNo);
            payInfo.setPayStatus(tradeStatus);

            System.out.println("更改asnkavajvnajvj");
            orderMapper.updateByOrderNo(orderNo);

            payInfoMapper.insert(payInfo);


            //cartMapper .清空购物车订单商品

        }


        return ServerResponse.createBySuccess();
    }


    public ServerResponse queryOrderPayStatus(Integer userId, Long orderNo) {
        Order order = orderMapper.findByUserIdAndOrderNum(userId, orderNo);
        if (order == null) {
            return ServerResponse.createByErrorMessage("用户没有该订单");
        }
        if (order.getStatus() >= Const.OrderStatusEnum.PAID.getCode()) {
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }


}
