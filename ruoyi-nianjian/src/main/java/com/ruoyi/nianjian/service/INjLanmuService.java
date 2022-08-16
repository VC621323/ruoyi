package com.ruoyi.nianjian.service;

import java.util.List;

import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.core.domain.entity.SysRole;
import com.ruoyi.nianjian.domain.NjLanmu;

/**
 * 年鉴栏目信息Service接口
 * 
 * @author wz
 * @date 2022-07-06
 */
public interface INjLanmuService 
{
    /**
     * 查询年鉴栏目信息
     * 
     * @param lanmuId 年鉴栏目信息主键
     * @return 年鉴栏目信息
     */
    public NjLanmu selectNjLanmuByLanmuId(Long lanmuId);

    /**
     * 查询年鉴栏目信息列表
     * 
     * @param njLanmu 年鉴栏目信息
     * @return 年鉴栏目信息集合
     */
    public List<NjLanmu> selectNjLanmuList(NjLanmu njLanmu);

    /**
     * 新增年鉴栏目信息
     * 
     * @param njLanmu 年鉴栏目信息
     * @return 结果
     */
    public int insertNjLanmu(NjLanmu njLanmu);

    /**
     * 修改年鉴栏目信息
     * 
     * @param njLanmu 年鉴栏目信息
     * @return 结果
     */
    public int updateNjLanmu(NjLanmu njLanmu);

    /**
     * 批量删除年鉴栏目信息
     * 
     * @param lanmuIds 需要删除的年鉴栏目信息主键集合
     * @return 结果
     */
    public int deleteNjLanmuByLanmuIds(String lanmuIds);

    /**
     * 删除年鉴栏目信息信息
     * 
     * @param lanmuId 年鉴栏目信息主键
     * @return 结果
     */
    public int deleteNjLanmuByLanmuId(Long lanmuId);

    /**
     *查询栏目管理树
     * @param njLanmu 栏目信息
     * @return 返回所有栏目
     */
    public List<Ztree> selectNjLanmuTree(NjLanmu njLanmu);

    /**
     * 查询部门管理树（排除下级）
     *
     * @param njLanmu 栏目信息
     * @return 所有栏目信息
     */
    public List<Ztree> selectNjLanmuExcludeChild(NjLanmu njLanmu);

    /**
     * 根据角色ID查询菜单
     *
     * @param role 角色对象
     * @return 菜单列表
     */
    public List<Ztree> roleNjLanmuTreeData(SysRole role);

    /**
     * 查询栏目人数
     *
     * @param parentId 父部门ID
     * @return 结果
     */
    public int selectNjLanmuCount(Long parentId);

    /**
     * 查询栏目是否存在用户
     *
     * @param lanmuId 栏目ID
     * @return 结果 true 存在 false 不存在
     */
    public boolean checkNjLanmuExistUser(Long lanmuId);

}
