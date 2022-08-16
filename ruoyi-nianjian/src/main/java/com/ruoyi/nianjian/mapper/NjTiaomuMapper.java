package com.ruoyi.nianjian.mapper;

import java.util.List;
import com.ruoyi.nianjian.domain.NjTiaomu;

/**
 * 年鉴条目信息Mapper接口
 * 
 * @author wz
 * @date 2022-07-06
 */
public interface NjTiaomuMapper 
{
    /**
     * 查询年鉴条目信息
     * 
     * @param tiaomuId 年鉴条目信息主键
     * @return 年鉴条目信息
     */
    public NjTiaomu selectNjTiaomuByTiaomuId(Long tiaomuId);

    /**
     * 查询年鉴条目信息列表
     * 
     * @param njTiaomu 年鉴条目信息
     * @return 年鉴条目信息集合
     */
    public List<NjTiaomu> selectNjTiaomuList(NjTiaomu njTiaomu);

    /**
     * 新增年鉴条目信息
     * 
     * @param njTiaomu 年鉴条目信息
     * @return 结果
     */
    public int insertNjTiaomu(NjTiaomu njTiaomu);

    /**
     * 修改年鉴条目信息
     * 
     * @param njTiaomu 年鉴条目信息
     * @return 结果
     */
    public int updateNjTiaomu(NjTiaomu njTiaomu);

    /**
     * 删除年鉴条目信息
     * 
     * @param tiaomuId 年鉴条目信息主键
     * @return 结果
     */
    public int deleteNjTiaomuByTiaomuId(Long tiaomuId);

    /**
     * 批量删除年鉴条目信息
     * 
     * @param tiaomuIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteNjTiaomuByTiaomuIds(String[] tiaomuIds);
}
