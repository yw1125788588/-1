package com.imooc.wx;

        import org.mybatis.spring.annotation.MapperScan;
        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;
        import org.springframework.web.bind.annotation.ResponseBody;

@MapperScan("com.imooc.wx.mapper")
@SpringBootApplication
public class WxApplication {
    @ResponseBody
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String hello() {
        //返回Hello SpringBoot!
        return "index";
    }

    public static void main(String[] args) {
        SpringApplication.run(WxApplication.class, args);
    }

}
