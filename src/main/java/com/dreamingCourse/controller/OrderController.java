package com.dreamingCourse.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.config.AlipayConfig;
import com.dreamingCourse.common.Const;
import com.dreamingCourse.common.ServerResponse;
import com.dreamingCourse.entity.OrderVo;
import com.dreamingCourse.mapper.OrderItemMapper;
import com.dreamingCourse.mapper.OrderMapper;
import com.dreamingCourse.service.OrderService;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.Map;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    public OrderService orderService;

    @Autowired
    public OrderItemMapper orderItemService;

    @Autowired
    private OrderMapper orderMapper;


    private static  final Logger logger = LoggerFactory.getLogger(OrderController.class);

    //购物车点结算--》创建订单
    @RequestMapping("/addOrder")
    @ResponseBody
    public ServerResponse addOrder(Integer uID){

        return  this.orderService.createOrder(uID);
    }

    //立即购买--》创建订单
    @RequestMapping("/addOrderDirectly")
    @ResponseBody
    public ServerResponse addOrderDirectly(Integer uID,Integer courseId){

        return  this.orderService.createOrderDirectly(uID, courseId);
    }


    //秒杀--》创建订单
    @RequestMapping("/addOrderSecKill")
    @ResponseBody
    public ServerResponse addOrderSecKill(Integer uID,Integer seckillGoodsId){

        return  this.orderService.createOrderSecKill(uID,seckillGoodsId);
    }

    // 全部---》根据uid查询全部订单
    @RequestMapping("/findOrdersByUId")
    @ResponseBody
    public ServerResponse findOrderByUId( Integer userId){

        return this.orderService.getOrderByUId(userId);
    }

    //未付款--》根据uid查询未支付订单
    @RequestMapping("/findUpaidOrdersByUId")
    @ResponseBody
    public ServerResponse findUpaidOrderByUId(Integer userId){

        return this.orderService.findUpaidOrderByUId(userId);
    }

   //待评价--》根据id查询未评价订单
    @RequestMapping("/findUAssessOrderByUId")
    @ResponseBody
    public ServerResponse findUAssessOrderByUId( Integer userId){

        return this.orderService.findUAssessOrderByUId(userId);
    }


    // 全部---》根据uid和订单编号查询指定订单详情
    @RequestMapping("/findDetailsByUserIdAndOrderNumber")
    @ResponseBody
    public ServerResponse findDetailsByUserIdAndOrderNumber( Integer userId,Long orderNumber){

        return this.orderService.findDetailsByUserIdAndorderNumber(userId,orderNumber);
    }


    //1.关闭失效订单， 2用户取消订单
    @RequestMapping("/findFailureOrders")
    @ResponseBody
    public void findFailureOrders(Long orderNumber){

         this.orderService.closeFailureOrders(orderNumber);
    }


    @RequestMapping("/findOrdersByOrderNo")
    @ResponseBody
    public ServerResponse findOrdersByOrderNo(Long orderNumber){

        return this.orderService.findOrdersByOrderNo(orderNumber);
    }

    /**
     * 支付模块 传参路径为：.../pay/orderNo/67689879
     * @param orderNo
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/pay/{orderNo}")
    @ResponseBody
    public String payController(@PathVariable Long orderNo, HttpServletResponse response) throws Exception {

        OrderVo order = this.orderMapper.selectByOrderNo(orderNo);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        String  out_trade_no = order.getOrderNumber().toString();
        //付款金额，必填
        String total_amount ="66";
        //订单名称，必填
        String subject = new StringBuffer().append("筑梦云课堂").toString();
       // List<OrderItem> items=order.getOrderItemList();

        //商品描述，可空
        String body = "云课堂购买课程";


        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

        alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\","
                + "\"total_amount\":\"" + total_amount + "\","
                + "\"subject\":\"" + subject + "\","
                + "\"body\":\"" + body + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        String form = alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单

        return form;

    }

    @RequestMapping("/alipay_callback.do")
    @ResponseBody
    public Object alipayCallback(HttpServletRequest request){
        Map<String,String> params = Maps.newHashMap();

        Map requestParams = request.getParameterMap();
        for(Iterator iter = requestParams.keySet().iterator(); iter.hasNext();){
            String name = (String)iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for(int i = 0 ; i <values.length;i++){

                valueStr = (i == values.length -1)?valueStr + values[i]:valueStr + values[i]+",";
            }
            params.put(name,valueStr);
        }
        logger.info("支付宝回调,sign:{},trade_status:{},参数:{}",params.get("sign"),params.get("trade_status"),params.toString());

        //非常重要,验证回调的正确性,是不是支付宝发的.并且呢还要避免重复通知.

        params.remove("sign_type");
        try {
            boolean alipayRSACheckedV2 = AlipaySignature.rsaCheckV2(params,AlipayConfig.alipay_public_key,"utf-8",AlipayConfig.sign_type);

            if(!alipayRSACheckedV2){
                return ServerResponse.createByErrorMessage("非法请求,验证不通过,再恶意请求我就报警找网警了");
            }
        } catch (AlipayApiException e) {
            logger.error("支付宝验证回调异常",e);
        }

        ServerResponse serverResponse = orderService.aliCallback(params);
        if(serverResponse.isSuccess()){
            return Const.AlipayCallback.RESPONSE_SUCCESS;
        }
        return Const.AlipayCallback.RESPONSE_FAILED;
    }

}
