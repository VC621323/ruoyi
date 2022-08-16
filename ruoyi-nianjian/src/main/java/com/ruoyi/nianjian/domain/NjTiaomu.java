package com.ruoyi.nianjian.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 年鉴条目信息对象 nj_tiaomu
 * 
 * @author wz
 * @date 2022-07-06
 */
public class NjTiaomu extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 条目ID */
    private Long tiaomuId;

    /** 栏目ID */
    @Excel(name = "栏目ID")
    private Long lanmuId;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** 登录账号 */
    @Excel(name = "登录账号")
    private String loginName;

    /** 条目名称 */
    @Excel(name = "条目名称")
    private String tiaomuName;

    /** 条目内容 */
    @Excel(name = "条目内容")
    private String tiaomuContent;

    /** 大事记标志（0是 1不是） */
    @Excel(name = "大事记标志", readConverterExp = "0=是,1=不是")
    private String isDsj;

    /** 删除标志（0存在 2删除） */
    private String delFlag;

    public void setTiaomuId(Long tiaomuId) 
    {
        this.tiaomuId = tiaomuId;
    }

    public Long getTiaomuId() 
    {
        return tiaomuId;
    }
    public void setLanmuId(Long lanmuId) 
    {
        this.lanmuId = lanmuId;
    }

    public Long getLanmuId() 
    {
        return lanmuId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setLoginName(String loginName) 
    {
        this.loginName = loginName;
    }

    public String getLoginName() 
    {
        return loginName;
    }
    public void setTiaomuName(String tiaomuName) 
    {
        this.tiaomuName = tiaomuName;
    }

    public String getTiaomuName() 
    {
        return tiaomuName;
    }
    public void setTiaomuContent(String tiaomuContent) 
    {
        this.tiaomuContent = tiaomuContent;
    }

    public String getTiaomuContent() 
    {
        return tiaomuContent;
    }
    public void setIsDsj(String isDsj) 
    {
        this.isDsj = isDsj;
    }

    public String getIsDsj() 
    {
        return isDsj;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("tiaomuId", getTiaomuId())
            .append("lanmuId", getLanmuId())
            .append("userId", getUserId())
            .append("loginName", getLoginName())
            .append("tiaomuName", getTiaomuName())
            .append("tiaomuContent", getTiaomuContent())
            .append("isDsj", getIsDsj())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
