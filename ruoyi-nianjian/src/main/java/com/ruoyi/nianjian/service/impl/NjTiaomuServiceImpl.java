package com.ruoyi.nianjian.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.nianjian.mapper.NjTiaomuMapper;
import com.ruoyi.nianjian.domain.NjTiaomu;
import com.ruoyi.nianjian.service.INjTiaomuService;
import com.ruoyi.common.core.text.Convert;

/**
 * 年鉴条目信息Service业务层处理
 * 
 * @author wz
 * @date 2022-07-06
 */
@Service
public class NjTiaomuServiceImpl implements INjTiaomuService 
{
    @Autowired
    private NjTiaomuMapper njTiaomuMapper;

    /**
     * 查询年鉴条目信息
     * 
     * @param tiaomuId 年鉴条目信息主键
     * @return 年鉴条目信息
     */
    @Override
    public NjTiaomu selectNjTiaomuByTiaomuId(Long tiaomuId)
    {
        return njTiaomuMapper.selectNjTiaomuByTiaomuId(tiaomuId);
    }

    /**
     * 查询年鉴条目信息列表
     * 
     * @param njTiaomu 年鉴条目信息
     * @return 年鉴条目信息
     */
    @Override
    public List<NjTiaomu> selectNjTiaomuList(NjTiaomu njTiaomu)
    {

        return njTiaomuMapper.selectNjTiaomuList(njTiaomu);
    }

    /**
     * 新增年鉴条目信息
     * 
     * @param njTiaomu 年鉴条目信息
     * @return 结果
     */
    @Override
    public int insertNjTiaomu(NjTiaomu njTiaomu)
    {
        njTiaomu.setCreateTime(DateUtils.getNowDate());
        return njTiaomuMapper.insertNjTiaomu(njTiaomu);
    }

    /**
     * 修改年鉴条目信息
     * 
     * @param njTiaomu 年鉴条目信息
     * @return 结果
     */
    @Override
    public int updateNjTiaomu(NjTiaomu njTiaomu)
    {
        njTiaomu.setUpdateTime(DateUtils.getNowDate());
        return njTiaomuMapper.updateNjTiaomu(njTiaomu);
    }

    /**
     * 批量删除年鉴条目信息
     * 
     * @param tiaomuIds 需要删除的年鉴条目信息主键
     * @return 结果
     */
    @Override
    public int deleteNjTiaomuByTiaomuIds(String tiaomuIds)
    {
        return njTiaomuMapper.deleteNjTiaomuByTiaomuIds(Convert.toStrArray(tiaomuIds));
    }

    /**
     * 删除年鉴条目信息信息
     * 
     * @param tiaomuId 年鉴条目信息主键
     * @return 结果
     */
    @Override
    public int deleteNjTiaomuByTiaomuId(Long tiaomuId)
    {
        return njTiaomuMapper.deleteNjTiaomuByTiaomuId(tiaomuId);
    }
}
