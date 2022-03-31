package com.alibaba.raise.mapper;

import com.alibaba.raise.entity.Menu;

import java.util.List;

/**
 * parkerJ
 * 2021/10/31
 * description：
 * function：
 */
public interface MenuMapper {

    /**
     * 返回所有menu
     * @return
     */
    List<Menu> getAll();
}
