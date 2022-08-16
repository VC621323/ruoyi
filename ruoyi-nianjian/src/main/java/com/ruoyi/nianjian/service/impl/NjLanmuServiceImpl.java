package com.ruoyi.nianjian.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.core.domain.entity.SysRole;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.nianjian.mapper.NjLanmuMapper;
import com.ruoyi.nianjian.domain.NjLanmu;
import com.ruoyi.nianjian.service.INjLanmuService;
import com.ruoyi.common.core.text.Convert;

/**
 * 年鉴栏目信息Service业务层处理
 * 
 * @author wz
 * @date 2022-07-06
 */
@Service
public class NjLanmuServiceImpl implements INjLanmuService 
{
    @Autowired
    private NjLanmuMapper njLanmuMapper;

    /**
     * 查询年鉴栏目信息
     * 
     * @param lanmuId 年鉴栏目信息主键
     * @return 年鉴栏目信息
     */
    @Override
    public NjLanmu selectNjLanmuByLanmuId(Long lanmuId)
    {
        return njLanmuMapper.selectNjLanmuByLanmuId(lanmuId);
    }

    /**
     * 查询年鉴栏目信息列表
     * 
     * @param njLanmu 年鉴栏目信息
     * @return 年鉴栏目信息
     */
    @Override
    public List<NjLanmu> selectNjLanmuList(NjLanmu njLanmu)
    {
        return njLanmuMapper.selectNjLanmuList(njLanmu);
    }

    /**
     * 新增年鉴栏目信息
     * 
     * @param njLanmu 年鉴栏目信息
     * @return 结果
     */
    @Override
    public int insertNjLanmu(NjLanmu njLanmu)
    {
        njLanmu.setCreateTime(DateUtils.getNowDate());
        return njLanmuMapper.insertNjLanmu(njLanmu);
    }

    /**
     * 修改年鉴栏目信息
     * 
     * @param njLanmu 年鉴栏目信息
     * @return 结果
     */
    @Override
    public int updateNjLanmu(NjLanmu njLanmu)
    {
        njLanmu.setUpdateTime(DateUtils.getNowDate());
        return njLanmuMapper.updateNjLanmu(njLanmu);
    }

    /**
     * 批量删除年鉴栏目信息
     * 
     * @param lanmuIds 需要删除的年鉴栏目信息主键
     * @return 结果
     */
    @Override
    public int deleteNjLanmuByLanmuIds(String lanmuIds)
    {
        return njLanmuMapper.deleteNjLanmuByLanmuIds(Convert.toStrArray(lanmuIds));
    }

    /**
     * 删除年鉴栏目信息信息
     * 
     * @param lanmuId 年鉴栏目信息主键
     * @return 结果
     */
    @Override
    public int deleteNjLanmuByLanmuId(Long lanmuId)
    {
        return njLanmuMapper.deleteNjLanmuByLanmuId(lanmuId);
    }

    /**
     * 查询栏目管理树
     * @param njLanmu 栏目信息
     * @return
     */
    @Override
    public List<Ztree> selectNjLanmuTree(NjLanmu njLanmu) {
        List<NjLanmu> lanmuList = njLanmuMapper.selectNjLanmuList(njLanmu);
        List<Ztree> ztrees = initZtree(lanmuList);
        return ztrees;
    }

    /**
     * 查询栏目管理树（排除下级）
     * @param njLanmu 栏目信息
     * @return 所有栏目信息
     */
    @Override
    public List<Ztree> selectNjLanmuExcludeChild(NjLanmu njLanmu) {
        Long excludeId = njLanmu.getExcludeId();
        List<NjLanmu> lanmuList = njLanmuMapper.selectNjLanmuList(njLanmu);
        Iterator<NjLanmu> it = lanmuList.iterator();
        while (it.hasNext())
        {
            NjLanmu d = (NjLanmu) it.next();
            if (d.getLanmuId().intValue() == excludeId
                    || ArrayUtils.contains(StringUtils.split(d.getAncestors(), ","), excludeId + ""))
            {
                it.remove();
            }
        }
        List<Ztree> ztrees = initZtree(lanmuList);
        return ztrees;
    }

    /**
     * 根据角色ID查询栏目（数据权限）
     * @param role 角色对象
     * @return 栏目列表（数据权限）
     */
    @Override
    public List<Ztree> roleNjLanmuTreeData(SysRole role) {
        Long roleId = role.getRoleId();
        List<Ztree> ztrees = new ArrayList<Ztree>();
        List<NjLanmu> lanmuList = selectNjLanmuList(new NjLanmu());
        if (StringUtils.isNotNull(roleId))
        {
            List<String> roleLanmuList = njLanmuMapper.selectRoleLanmuTree(roleId);
            ztrees = initZtree(lanmuList, roleLanmuList);
        }
        else
        {
            ztrees = initZtree(lanmuList);
        }
        return ztrees;
    }

    /**
     * 查询栏目人数
     * @param parentId 父部门ID
     * @return
     */
    @Override
    public int selectNjLanmuCount(Long parentId) {
        NjLanmu lanmu = new NjLanmu();
        lanmu.setParentId(parentId);
        return njLanmuMapper.selectLanmuCount(lanmu);
    }

    /**
     * 查询栏目是否存在用户
     * @param lanmuId 栏目ID
     * @return 结果 true 存在 false 不存在
     */
    @Override
    public boolean checkNjLanmuExistUser(Long lanmuId) {
        int result = njLanmuMapper.checkLanmuExistUser(lanmuId);
        return result > 0;
    }

    /**
     * 对象转部门树
     *
     * @param lanmuList 部门列表
     * @return 树结构列表
     */
    public List<Ztree> initZtree(List<NjLanmu> lanmuList)
    {
        return initZtree(lanmuList, null);
    }

    /**
     * 对象转部门树
     *
     * @param lanmuList 部门列表
     * @param roleLanmuList 角色已存在菜单列表
     * @return 树结构列表
     */
    public List<Ztree> initZtree(List<NjLanmu> lanmuList, List<String> roleLanmuList)
    {
        List<Ztree> ztrees = new ArrayList<Ztree>();
        boolean isCheck = StringUtils.isNotNull(roleLanmuList);
        for (NjLanmu lanmu : lanmuList)
        {
            if (UserConstants.DEPT_NORMAL.equals(lanmu.getStatus()))
            {
                Ztree ztree = new Ztree();
                ztree.setId(lanmu.getLanmuId());
                ztree.setpId(lanmu.getParentId());
                ztree.setName(lanmu.getLanmuName());
                ztree.setTitle(lanmu.getLanmuName());
                if (isCheck)
                {
                    ztree.setChecked(roleLanmuList.contains(lanmu.getLanmuId() + lanmu.getLanmuName()));
                }
                ztrees.add(ztree);
            }
        }
        return ztrees;
    }

}
