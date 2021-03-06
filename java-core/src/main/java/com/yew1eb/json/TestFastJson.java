package com.yew1eb.json;

import com.alibaba.fastjson.JSON;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhouhai
 * @createTime 16/6/28
 * @description
 */
public class TestFastJson {

    public static void main(String [] args) {
        //testUserGroup();
        testInvokerBean();
    }

    public static void testInvokerBean() {
        InvokerBean invoker = new InvokerBean();
        invoker.setSecret("1dfas134dafsfasda");
        invoker.setType("invoker");
        invoker.setProcessUnitName("com.xx.yy.zz");

        Param arg0 = new Param("arg0", "WARN");
        Param arg1 = new Param("arg1", "ERROR");

        invoker.addParam(arg0);
        invoker.addParam(arg1);
        String jsonString = JSON.toJSONString(invoker);

        System.out.println(jsonString);
        InvokerBean g = JSON.parseObject(jsonString, InvokerBean.class);
        System.out.println(g);
    }

    public static void testUserGroup() {
        UserGroup group = new UserGroup();
        group.setName("admin");

        User guestUser = new User();
        guestUser.setAge(21);
        guestUser.setName("guest");

        User rootUser = new User();
        rootUser.setAge(25);
        rootUser.setName("root");

        group.addUser(guestUser);
        group.addUser(rootUser);

        String jsonString = JSON.toJSONString(group);

        System.out.println(jsonString);
        UserGroup g = JSON.parseObject(jsonString, UserGroup.class);
        System.out.println(g);
    }
}
/*
{
"secret": "dfasdfas134eqewrqw",
"type": "changeloglevel",
"processUnitName": "className",
"data": [{"arg0": "WARN"}, {"arg1": "ERROR"}]
}
*/