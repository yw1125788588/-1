package com.imooc.wx.Controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imooc.wx.entity.SysDrug;
import com.imooc.wx.mapper.SysDrugMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/SysDrug")

public class DrugController {

    @Autowired
    private SysDrugMapper sysDrugMapper;

    //药品分页
    @GetMapping("/SysDrug/{pageNum}")
    public String list(@PathVariable("pageNum") int pageNum, Model model) {
        PageHelper.startPage(pageNum,10);
        List<SysDrug> Drugs= SysDrugMapper.getDrugs();
        PageInfo<SysDrug> pageInfo = new PageInfo<SysDrug>(Drugs);
        pageInfo.setPageNum(pageNum);
        model.addAttribute("Drugs", pageInfo.getList());
        model.addAttribute("pageInfo",pageInfo);
        return "Druglist";
    }
    //药品列表
    @RequestMapping("/DrugList")
    public String drugList(Model model){
        List<SysDrug> drugs = SysDrugMapper.getDrugs();
        model.addAttribute("SysDrug",drugs);
        return"Drug/DurgList";
    }
    //药品添加
    @RequestMapping("/toadd")
    public String toAdd(){
        return "Durg/drugAdd";
    }
    //添加完成返回药品表
    @RequestMapping("/add")
    public String add(SysDrug sysDrug){
        sysDrugMapper.insert(sysDrug);
        return "redirect:/DrugList";
    }
    //药品更新
    @RequestMapping("/toUpdate")
    public String toUpdate(Model model,Integer id){
      SysDrug sysDrug = sysDrugMapper.queryById(id);
        model.addAttribute("sysDrug", sysDrug);
        return "Drug/DrugUpdate";
    }
    //药品返回药品表
    @RequestMapping("/update")
    public String update(SysDrug sysDrug){
      SysDrugMapper.update(sysDrug);
        return "redirect:/DrugList";
    }

    @RequestMapping("/delete")
    public String delete(Integer id){
        SysDrugMapper.deleteById(id);
        return "redirect:/DrugList";
    }
}
