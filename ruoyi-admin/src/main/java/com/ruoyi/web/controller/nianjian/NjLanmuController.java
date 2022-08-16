package com.ruoyi.web.controller.nianjian;

import java.util.List;

import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.core.domain.entity.SysRole;
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
import com.ruoyi.nianjian.domain.NjLanmu;
import com.ruoyi.nianjian.service.INjLanmuService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 年鉴栏目信息Controller
 * 
 * @author wz
 * @date 2022-07-06
 */
@Controller
@RequestMapping("/nianjian/lanmu")
public class NjLanmuController extends BaseController
{
    private String prefix = "nianjian/lanmu";

    @Autowired
    private INjLanmuService njLanmuService;

    @RequiresPermissions("nianjian:lanmu:view")
    @GetMapping()
    public String lanmu()
    {
        return prefix + "/lanmu";
    }

    /**
     * 查询年鉴栏目信息列表
     */
    @RequiresPermissions("nianjian:lanmu:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(NjLanmu njLanmu)
    {
        startPage();
        List<NjLanmu> list = njLanmuService.selectNjLanmuList(njLanmu);
        return getDataTable(list);
    }

    /**
     * 导出年鉴栏目信息列表
     */
    @RequiresPermissions("nianjian:lanmu:export")
    @Log(title = "年鉴栏目信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(NjLanmu njLanmu)
    {
        List<NjLanmu> list = njLanmuService.selectNjLanmuList(njLanmu);
        ExcelUtil<NjLanmu> util = new ExcelUtil<NjLanmu>(NjLanmu.class);
        return util.exportExcel(list, "年鉴栏目信息数据");
    }

    /**
     * 新增年鉴栏目信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存年鉴栏目信息
     */
    @RequiresPermissions("nianjian:lanmu:add")
    @Log(title = "年鉴栏目信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(NjLanmu njLanmu)
    {
        return toAjax(njLanmuService.insertNjLanmu(njLanmu));
    }

    /**
     * 修改年鉴栏目信息
     */
    @RequiresPermissions("nianjian:lanmu:edit")
    @GetMapping("/edit/{lanmuId}")
    public String edit(@PathVariable("lanmuId") Long lanmuId, ModelMap mmap)
    {
        NjLanmu njLanmu = njLanmuService.selectNjLanmuByLanmuId(lanmuId);
        mmap.put("njLanmu", njLanmu);
        return prefix + "/edit";
    }

    /**
     * 修改保存年鉴栏目信息
     */
    @RequiresPermissions("nianjian:lanmu:edit")
    @Log(title = "年鉴栏目信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(NjLanmu njLanmu)
    {
        return toAjax(njLanmuService.updateNjLanmu(njLanmu));
    }

    /**
     * 删除年鉴栏目信息
     */
    @RequiresPermissions("nianjian:lanmu:remove")
    @Log(title = "年鉴栏目信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(njLanmuService.deleteNjLanmuByLanmuIds(ids));
    }


    /**
     * 选择栏目树
     *
     * @param lanmuId 栏目ID
     * @param excludeId 排除ID
     */
    @GetMapping(value = { "/selectLanmuTree/{lanmuId}", "/selectLanmuTree/{lanmuId}/{excludeId}" })
    public String selectDeptTree(@PathVariable("lanmuId") Long lanmuId,
                                 @PathVariable(value = "excludeId", required = false) String excludeId, ModelMap mmap)
    {
        mmap.put("lanmu", njLanmuService.selectNjLanmuByLanmuId(lanmuId));
        mmap.put("excludeId", excludeId);
        return prefix + "/tree";
    }

    /**
     * 加载栏目列表树
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData()
    {
        List<Ztree> ztrees = njLanmuService.selectNjLanmuTree(new NjLanmu());
        return ztrees;
    }
    /**
     * 加载部门列表树（排除下级）
     */
    @GetMapping("/treeData/{excludeId}")
    @ResponseBody
    public List<Ztree> treeDataExcludeChild(@PathVariable(value = "excludeId", required = false) Long excludeId)
    {
        NjLanmu lanmu = new NjLanmu();
        lanmu.setExcludeId(excludeId);
        List<Ztree> ztrees = njLanmuService.selectNjLanmuExcludeChild(lanmu);
        return ztrees;
    }

    /**
     * 加载角色部门（数据权限）列表树
     */
    @GetMapping("/roleLanmuTreeData")
    @ResponseBody
    public List<Ztree> lanmuTreeData(SysRole role)
    {
        List<Ztree> ztrees = njLanmuService.roleNjLanmuTreeData(role);
        return ztrees;
    }

}
