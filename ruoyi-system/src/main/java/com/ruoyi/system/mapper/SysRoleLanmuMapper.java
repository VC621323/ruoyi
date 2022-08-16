package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysRoleLanmu;

/**
 * 角色和栏目关联Mapper接口
 *
 * @author wz
 * @date 2022-07-12
 */
public interface SysRoleLanmuMapper
{
    /**
     * 查询角色和栏目关联
     *
     * @param roleId 角色和栏目关联主键
     * @return 角色和栏目关联
     */
    public SysRoleLanmu selectSysRoleLanmuByRoleId(Long roleId);

    /**
     * 查询角色和栏目关联列表
     *
     * @param sysRoleLanmu 角色和栏目关联
     * @return 角色和栏目关联集合
     */
    public List<SysRoleLanmu> selectSysRoleLanmuList(SysRoleLanmu sysRoleLanmu);

    /**
     * 新增角色和栏目关联
     *
     * @param sysRoleLanmu 角色和栏目关联
     * @return 结果
     */
    public int insertSysRoleLanmu(SysRoleLanmu sysRoleLanmu);

    /**
     * 修改角色和栏目关联
     *
     * @param sysRoleLanmu 角色和栏目关联
     * @return 结果
     */
    public int updateSysRoleLanmu(SysRoleLanmu sysRoleLanmu);

    /**
     * 删除角色和栏目关联
     *
     * @param roleId 角色和栏目关联主键
     * @return 结果
     */
    public int deleteSysRoleLanmuByRoleId(Long roleId);

    /**
     * 批量删除角色和栏目关联
     *
     * @param roleIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysRoleLanmuByRoleIds(String[] roleIds);
}
