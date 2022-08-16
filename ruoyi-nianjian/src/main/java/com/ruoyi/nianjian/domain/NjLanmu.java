package com.ruoyi.nianjian.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 年鉴栏目信息对象 nj_lanmu
 * 
 * @author wz
 * @date 2022-07-06
 */
public class NjLanmu extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 栏目ID */
    private Long lanmuId;

    /** 父部门ID */
    @Excel(name = "父部门ID")
    private Long parentId;

    /** 祖级列表 */
    @Excel(name = "祖级列表")
    private String ancestors;

    /** 栏目名称 */
    @Excel(name = "栏目名称")
    private String lanmuName;

    /** 显示顺序 */
    @Excel(name = "显示顺序")
    private Integer orderNum;

    /** 负责人 */
    @Excel(name = "负责人")
    private String leader;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String phone;

    /** 部门状态（0正常 1停用） */
    @Excel(name = "部门状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 删除标志（0代表存在2代表删除） */
    private String delFlag;

    /** 创建者 */
    @Excel(name = "创建者")
    private String creatBy;

    /** 父部门名称 */
    private String parentName;

    /** 排除编号 */
    private Long excludeId;

    public void setLanmuId(Long lanmuId) 
    {
        this.lanmuId = lanmuId;
    }

    public Long getLanmuId() 
    {
        return lanmuId;
    }
    public void setParentId(Long parentId) 
    {
        this.parentId = parentId;
    }

    public Long getParentId() 
    {
        return parentId;
    }
    public void setAncestors(String ancestors) 
    {
        this.ancestors = ancestors;
    }

    public String getAncestors() 
    {
        return ancestors;
    }
    public void setLanmuName(String lanmuName) 
    {
        this.lanmuName = lanmuName;
    }

    public String getLanmuName() 
    {
        return lanmuName;
    }
    public void setOrderNum(Integer orderNum) 
    {
        this.orderNum = orderNum;
    }

    public Integer getOrderNum() 
    {
        return orderNum;
    }
    public void setLeader(String leader) 
    {
        this.leader = leader;
    }

    public String getLeader() 
    {
        return leader;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }
    public void setCreatBy(String creatBy) 
    {
        this.creatBy = creatBy;
    }

    public String getCreatBy() 
    {
        return creatBy;
    }

    public String getParentName()
    {
        return parentName;
    }

    public void setParentName(String parentName)
    {
        this.parentName = parentName;
    }

    @JsonIgnore
    public Long getExcludeId()
    {
        return excludeId;
    }

    public void setExcludeId(Long excludeId)
    {
        this.excludeId = excludeId;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("lanmuId", getLanmuId())
            .append("parentId", getParentId())
            .append("ancestors", getAncestors())
            .append("lanmuName", getLanmuName())
            .append("orderNum", getOrderNum())
            .append("leader", getLeader())
            .append("phone", getPhone())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("creatBy", getCreatBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
