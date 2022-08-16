package com.ruoyi.nianjian.mapper;

import java.util.List;

import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.nianjian.domain.NjLanmu;

/**
 * 年鉴栏目信息Mapper接口
 * 
 * @author wz
 * @date 2022-07-06
 */
public interface NjLanmuMapper 
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
     * 删除年鉴栏目信息
     * 
     * @param lanmuId 年鉴栏目信息主键
     * @return 结果
     */
    public int deleteNjLanmuByLanmuId(Long lanmuId);

    /**
     * 批量删除年鉴栏目信息
     * 
     * @param lanmuIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteNjLanmuByLanmuIds(String[] lanmuIds);

    /**
     * 根据角色ID查询栏目
     * @param roleId 角色ID
     * @return 栏目列表
     */
    public List<String> selectRoleLanmuTree(Long roleId);
    /**
     * 查询栏目人数
     *
     * @param njLanmu 栏目信息
     * @return 结果
     */
    public int selectLanmuCount(NjLanmu njLanmu);
    /**
     * 查询栏目是否存在用户
     *
     * @param lanmuId 栏目ID
     * @return 结果
     */
    public int checkLanmuExistUser(Long lanmuId);
}
