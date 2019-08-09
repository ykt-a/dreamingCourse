package com.dreamingCourse.controller;


import com.dreamingCourse.common.ExceptionUtil;
import com.dreamingCourse.common.YktResult;
import com.dreamingCourse.entity.Course;
import com.dreamingCourse.entity.Notice;

import com.dreamingCourse.entity.SecKill;
import com.dreamingCourse.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.text.SimpleDateFormat;
import java.util.List;


@Controller //声明Rest风格的控制器
@EnableAutoConfiguration

public class IndexController {
    @Autowired
    private IndexService indexService;
/*    @RequestMapping("/itemcat/list")
    @ResponseBody
    public String getitemCatList(String callback){
       CatResult catResult =indexService.getItemCatList();
       String json= JSONUtils.toJSONString(catResult);
       String result=callback+"("+json+");";
       return result;
    }*/
 /*   @RequestMapping("/before")
    public String before(Model model,String mykey) {
       model.addAttribute("salelist",indexService.gethotCourse());
       model.addAttribute("lastlist",indexService.getlastCourse());
       model.addAttribute("Seckillist",indexService.getSeckill());
       model.addAttribute("notice",indexService.selectNotice());
       model.addAttribute("serach",indexService.search(mykey));

       List list=indexService.gethotCourse();

        for (Iterator it = list.iterator(); it.hasNext();)
        {
            System.out.println(it.next());
        }
        return "index";
    }*/
    /**
     * 转到商品详情页
     */
 /*   @RequestMapping("/yktCourseDetail")
    public String goodsDetail(Model model,Integer id) {
        return indexService.goodsDetail(model, id);
    }*/
    /**
     * 转到公告页面
     */
  /*  @RequestMapping("/selectANotice")
    public String selectANotice(Model model) {
        return indexService.selectNotice(model);
    }*/
    /**
     * 首页搜索
     */
/*    @RequestMapping("/search")
    public String search(Model model,String mykey) {
        return indexService.search(model, mykey);
    }*/

    @RequestMapping("search/{mykey}")
    @ResponseBody
    public YktResult search(@PathVariable String mykey) {
        try {
          //  mykey="ja";
            List<Course> list=indexService.search(mykey);
            return  YktResult.ok(list);

        } catch (Exception e) {
            e.printStackTrace();
            return YktResult.build(500, ExceptionUtil.getStackTrace(e));

        }



}
    @RequestMapping("getshi")
    @ResponseBody
    public YktResult getshiCourse() {
        try {
            List<Course> list=indexService.getshiCourse();
            return YktResult.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
            return YktResult.build(500,ExceptionUtil.getStackTrace(e));
        }
    }
    @RequestMapping("gethot")
    @ResponseBody
    public List<Course> gethotCourse() {
        return indexService.gethotCourse();

    }
    @RequestMapping("gettag")
    @ResponseBody
    public List<Course> gettag() {
        return indexService.gettag();

    }


    @RequestMapping("getlast")
    @ResponseBody
    public List<Course> getlastCourse() {
        return indexService.getlastCourse();

    }
    @RequestMapping("notice")
    @ResponseBody
    public List<Notice> selectNotice() {
        return indexService.selectNotice();

    }
/*    @RequestMapping("sekill")
    @ResponseBody
    public List<YktSeckill> getSeckill() {
        return indexService.getSeckill();

    }*/
    @RequestMapping("sekil/{pageNo}")
    @ResponseBody
    public List<SecKill> getSeckil(@PathVariable Integer pageNo) {

        java.util.Date t=new java.util.Date();
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        String data=df.format(t);

   if(pageNo==1) {
       String data1 = " " + "10:00:00";
       String data2 = data + data1;
       return indexService.getSeckil(data2);
   }else if (pageNo==2){
       String data1 = " " + "16:00:00";
       String data2 = data + data1;
       return indexService.getSeckil(data2);
   }else{
       String data1 = " " + "20:00:00";
       String data2 = data + data1;
       return indexService.getSeckil(data2);
   }

    }
    /*    @RequestMapping("course/{id}")
    @ResponseBody
    public YktResult getcourse(@PathVariable int id){
        try {
            List<Course> list=indexService.getCourselist(id);
            return YktResult.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
            return YktResult.build(500,ExceptionUtil.getStackTrace(e));
        }

    }*/

}
