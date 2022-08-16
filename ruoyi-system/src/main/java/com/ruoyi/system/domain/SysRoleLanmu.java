package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 角色和栏目关联对象 sys_role_lanmu
 *
 * @author wz
 * @date 2022-07-12
 */
public class SysRoleLanmu extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 角色ID */
    private Long roleId;

    /** 栏目ID */
    private Long lanmuId;

    public void setRoleId(Long roleId)
    {
        this.roleId = roleId;
    }

    public Long getRoleId()
    {
        return roleId;
    }
    public void setLanmuId(Long lanmuId)
    {
        this.lanmuId = lanmuId;
    }

    public Long getLanmuId()
    {
        return lanmuId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("roleId", getRoleId())
                .append("lanmuId", getLanmuId())
                .toString();
    }
}
