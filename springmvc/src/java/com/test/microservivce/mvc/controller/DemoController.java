package com.test.microservivce.mvc.controller;

import com.test.microservivce.mvc.bean.Demo;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.synchronoss.cloud.nio.multipart.Multipart;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/anno")
public class DemoController {
    //方法不声明路径  就是使用  类上声明的路径
    //produces 定制返回的response 的媒体类型和字符集
    @RequestMapping(produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String index(HttpServletRequest request){
        return "url:"+request.getRequestURL()+"can access";
    }
//演示从路径中获取参数
    @RequestMapping(value="/pathvar/{str}",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String demoPathVar(@PathVariable  String str, HttpServletRequest request){
        return "url:"+request.getRequestURL()+"can access  ，str="+str;
    }
    //演示将 参数封装成对象
    @RequestMapping(value="/obj" ,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Demo passObj(Demo demo, HttpServletRequest request ){
        return demo;
    }


    //演示将 参数封装成对象
    @RequestMapping(value="/exception")
    @ResponseBody
    public Demo except(Demo demo, HttpServletRequest request, @ModelAttribute("msg") String msg){
        System.out.println(demo);
        System.out.println("msg："+msg);
         throw new RuntimeException("钉钉一异常"+msg);

    }


    @RequestMapping(value="/upload" )
    public  @ResponseBody String upload(MultipartFile file, HttpServletRequest request ){
        System.out.println("--------------------"+file.getName()+"===="+file.getSize());
        return "ok";
    }


}
