package com.alibaba.raise.mapper;

import com.alibaba.raise.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * parkerJ
 * 2021/10/25
 * description：
 * function：
 */
public interface RoleMapper {

    /**
     * role分页查询
     */
    List<Role> getPageInfo(@Param("keyword") String keyword);

    /**
     * 新增admin
     * @param roleName
     * @return
     */
    int saveRole(@Param("roleName") String roleName);

    int queryNameByName(@Param("roleName") String roleName);

    /**
     * 根据id更新role
     * @param id
     * @param name
     * @return
     */
    int updateRoleByid(@Param("id") String id, @Param("name") String name);

    int deleteRoles(List<Integer> roleIdList);
}
