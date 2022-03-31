package com.alibaba.raise.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.raise.entity.Menu;
import com.alibaba.raise.mapper.MenuMapper;
import com.alibaba.raise.service.MenuService;
import com.alibaba.raise.util.JsonResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * parkerJ
 * 2021/10/31
 * description：
 * function：
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuMapper menuMapper;


    /**
     * 查询menu所有数据
     * @return
     */
    @Override
    public JsonResult getAll() {
        List<Menu> menuList = menuMapper.getAll();
        Menu root = null;
        for (Menu menu : menuList) {
            if (menu.getPid() == null){
                root = menu;
                continue;
            }
            // 查找该节点可能存在的父节点,并将该节点存在父节点的children属性中
            for (Menu findFatherMenu  : menuList) {
                Integer pid = menu.getPid();
                Integer mayFatherMenu = findFatherMenu.getId();
                if (Objects.equals(pid, mayFatherMenu)){
                    findFatherMenu.getChildren().add(menu);
                }
                break;
            }
        }
        if (root == null){
            return JsonResult.fail("fail");
        }else{
            return JsonResult.success(root);
        }
    }
}
