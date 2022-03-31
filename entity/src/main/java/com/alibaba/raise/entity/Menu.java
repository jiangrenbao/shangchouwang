package com.alibaba.raise.entity;

import java.io.PipedReader;
import java.util.ArrayList;
import java.util.List;

/**
 * parkerJ
 * 2021/10/26
 * description：
 * function：
 */
public class Menu {

    private Integer id;
    private Integer pid;
    private String name;
    private String url;
    // 图标样式
    private String icon;
    // 控制节点是否默认打开
    private boolean open = true;
    // 子节点集合
    private List<Menu> children = new ArrayList<>();


    public Menu() {
    }

    public Menu(Integer id, Integer pid, String name, String url, String icon, boolean open, List<Menu> children) {
        this.id = id;
        this.pid = pid;
        this.name = name;
        this.url = url;
        this.icon = icon;
        this.open = open;
        this.children = children;
    }

    public Integer getId() {
        return id;
    }

    public Menu setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getPid() {
        return pid;
    }

    public Menu setPid(Integer pid) {
        this.pid = pid;
        return this;
    }

    public String getName() {
        return name;
    }

    public Menu setName(String name) {
        this.name = name;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Menu setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getIcon() {
        return icon;
    }

    public Menu setIcon(String icon) {
        this.icon = icon;
        return this;
    }

    public boolean isOpen() {
        return open;
    }

    public Menu setOpen(boolean open) {
        this.open = open;
        return this;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public Menu setChildren(List<Menu> children) {
        this.children = children;
        return this;
    }
}


