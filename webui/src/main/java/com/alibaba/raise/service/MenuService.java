package com.alibaba.raise.service;

import com.alibaba.raise.entity.Menu;
import com.alibaba.raise.util.JsonResult;

import java.util.List;

/**
 * parkerJ
 * 2021/10/31
 * description：
 * function：
 */
public interface MenuService {


    /**
     * 查询menu所有数据
     * @return
     */
    JsonResult getAll();
}
