package com.imooc.wx.Controller;

import com.imooc.wx.service.SysEmployService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController("/SysEmploy")
public class EmployController {
        @Autowired
        private SysEmployService sysEmployService;

        public String index( Map map){


            return "";
        }
    }
