package com.ruoyi.web.controller.nianjian;

import java.util.List;
import java.util.stream.Collectors;

import com.ruoyi.system.service.ISysPostService;
import com.ruoyi.system.service.ISysRoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.nianjian.domain.NjTiaomu;
import com.ruoyi.nianjian.service.INjTiaomuService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 年鉴条目信息Controller
 * 
 * @author wz
 * @date 2022-07-06
 */
@Controller
@RequestMapping("/nianjian/tiaomu")
public class NjTiaomuController extends BaseController
{
    private String prefix = "nianjian/tiaomu";

    @Autowired
    private INjTiaomuService njTiaomuService;

    @Autowired
    private ISysRoleService roleService;

    @Autowired
    private ISysPostService postService;

    @RequiresPermissions("nianjian:tiaomu:view")
    @GetMapping()
    public String tiaomu()
    {
        return prefix + "/tiaomu";
    }

    /**
     * 查询年鉴条目信息列表
     */
    @RequiresPermissions("nianjian:tiaomu:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(NjTiaomu njTiaomu)
    {
        startPage();
        List<NjTiaomu> list = njTiaomuService.selectNjTiaomuList(njTiaomu);
        return getDataTable(list);
    }

    /**
     * 导出年鉴条目信息列表
     */
    @RequiresPermissions("nianjian:tiaomu:export")
    @Log(title = "年鉴条目信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(NjTiaomu njTiaomu)
    {
        List<NjTiaomu> list = njTiaomuService.selectNjTiaomuList(njTiaomu);
        ExcelUtil<NjTiaomu> util = new ExcelUtil<NjTiaomu>(NjTiaomu.class);
        return util.exportExcel(list, "年鉴条目信息数据");
    }

    /**
     * 新增年鉴条目信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存年鉴条目信息
     */
    @RequiresPermissions("nianjian:tiaomu:add")
    @Log(title = "年鉴条目信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(NjTiaomu njTiaomu)
    {
        return toAjax(njTiaomuService.insertNjTiaomu(njTiaomu));
    }

    /**
     * 修改年鉴条目信息
     */
    @RequiresPermissions("nianjian:tiaomu:edit")
    @GetMapping("/edit/{tiaomuId}")
    public String edit(@PathVariable("tiaomuId") Long tiaomuId, ModelMap mmap)
    {
        NjTiaomu njTiaomu = njTiaomuService.selectNjTiaomuByTiaomuId(tiaomuId);
        mmap.put("njTiaomu", njTiaomu);
        return prefix + "/edit";
    }

    /**
     * 修改保存年鉴条目信息
     */
    @RequiresPermissions("nianjian:tiaomu:edit")
    @Log(title = "年鉴条目信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(NjTiaomu njTiaomu)
    {
        return toAjax(njTiaomuService.updateNjTiaomu(njTiaomu));
    }

    /**
     * 删除年鉴条目信息
     */
    @RequiresPermissions("nianjian:tiaomu:remove")
    @Log(title = "年鉴条目信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(njTiaomuService.deleteNjTiaomuByTiaomuIds(ids));
    }
}
