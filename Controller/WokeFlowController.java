package com.imooc.wx.Controller;

import com.imooc.wx.service.WokeFlowService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("com/imooc/wx/wokeflow")
public class WokeFlowController {

    private WokeFlowService wokeFlowService;
}
