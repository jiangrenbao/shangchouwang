package com.alibaba.raise.controller;

import com.alibaba.raise.entity.Menu;
import com.alibaba.raise.service.MenuService;
import com.alibaba.raise.util.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * parkerJ
 * 2021/10/31
 * description：
 * function：
 */
@Controller
public class MenuController {

    @Resource
    private MenuService menuService;

    /**
     * 返回menu-page页面
     * @return
     */
    @RequestMapping("/menu/to/page.html")
    public String toMenuPage(){
        return "menu-page";
    }

    /**
     * 返回menu所有数据
     * @return
     */
    @RequestMapping("menu/get/whole/tree.json")
    @ResponseBody
    public JsonResult getAll(){
       return menuService.getAll();
    }
}
