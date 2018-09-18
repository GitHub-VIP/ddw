package com.dd.shop.manager.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ManagerIndexAction {

    //http://localhost:8080/cyt/index(访问)
    //login.jsp http://localhost:8080/cyt/login
    //test.jsp  http://localhost:8080/cyt/test
    @RequestMapping(value = "/{page}",method = RequestMethod.GET)
    public String index(@PathVariable String page){

        return page;
    }

    //welcome.jsp http://localhost:8080/cyt/welcome
    @RequestMapping(value = "/pages/{pageName1}",method = RequestMethod.GET)
    public String index2(@PathVariable String pageName1){

        return "pages/" + pageName1;
    }

    //welcome.jsp http://localhost:8080/cyt/welcome
    @RequestMapping(value = "/pages/{pageName1}/{pageName2}",method = RequestMethod.GET)
    public String index3(@PathVariable String pageName1,@PathVariable String pageName2){

        return "pages/"+pageName1+"/"+pageName2;
    }












}
