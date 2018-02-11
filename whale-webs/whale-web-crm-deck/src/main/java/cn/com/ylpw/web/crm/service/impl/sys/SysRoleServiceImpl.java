package cn.com.ylpw.web.crm.service.impl.sys;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.ListUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import cn.com.ylpw.web.crm.base.constants.RolePermEnum;
import cn.com.ylpw.web.crm.entity.sys.SysRole;
import cn.com.ylpw.web.crm.mapper.sys.SysRoleMapper;
import cn.com.ylpw.web.crm.model.SysRolePermForm;
import cn.com.ylpw.web.crm.model.sys.SysRoleGrid;
import cn.com.ylpw.web.crm.service.sys.SysRoleService;
import cn.com.ylpw.web.crm.util.LruCacheUtils;
import cn.com.ylpw.web.crm.util.Page;

@Transactional
@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {
  
    //临时缓存方案
    private LruCacheUtils<List<Map<String, Object>>> lruCache = new LruCacheUtils<List<Map<String, Object>>>(100, 60000); //默认：缓存有效时间为1分钟，100项缓存记录
    
	@Autowired
	private SysRoleMapper sysRoleMapper;

	@Override
	public void save(SysRole sysRole) {
	  sysRoleMapper.save(sysRole);
	}

    @Override
    public void update(SysRole sysRole) {
      if (null != this.findById(sysRole.getId())) {
        sysRoleMapper.update(sysRole);
      }
    }

	@Override
	public void delete(SysRole sysRole) {
	  sysRoleMapper.delete(sysRole);
	}

	@Override
	public SysRole findById(Long id) {
	  return sysRoleMapper.findById(id);
	}
	
	@Override
	public List<SysRoleGrid> findAll(SysRole sysRole) {
	  return sysRoleMapper.findAll(sysRole);
	}

    @Override
    public Page<SysRoleGrid> findAll(SysRole sysRole, Page<SysRoleGrid> page) {
      com.github.pagehelper.Page<Object> pageHelper = PageHelper.startPage(page.getPageNo(), page.getPageSize());
      page.setData(sysRoleMapper.findAll(sysRole));
      page.setTotal(pageHelper.getTotal());
      return page;
    }
    

    @Override
    public Integer countRoleByName(String name) {
      return sysRoleMapper.countRoleByName(name);
    }

    @Override
    public List<Map<String, Object>> findAllTFconfig() {
      final String ckey = "ALLTFCONFIG";
      if(null == lruCache.get(ckey)){
        lruCache.put(ckey, sysRoleMapper.findAllTFconfig());
      }
      return lruCache.get(ckey);
    }

    @Override
    public boolean savePerm(SysRolePermForm sysRolePermForm) {
      this.saveRolePerm(RolePermEnum.SYS_ROLE_MENU, sysRolePermForm.getId(), sysRolePermForm.getMenuIds());//4.菜单权限-授权
      return false;
    }

    private void saveRolePerm(RolePermEnum rolePermEnum, Long sysRoleId, String permIds) {
    	//将当前角色的所有权限删除
        sysRoleMapper.deletePermsByRoleId(rolePermEnum, sysRoleId);
      if (StringUtils.isNotEmpty(permIds)) {
        List<String> newPerms =  Arrays.asList(permIds.split(","));
        //重新插入当前角色 的权限
        for (String perm : newPerms) {
          sysRoleMapper.saveNewPerm(rolePermEnum, sysRoleId, Long.parseLong(perm), 1);
        }
      }
    }

    @Override
    public SysRolePermForm findBasePerm(SysRole sysRole) {
      SysRolePermForm sysRolePermForm = new SysRolePermForm();
      return sysRolePermForm;
    }

    @Override
    public List<Object> findPerm(RolePermEnum rolePermEnum, Long sysRoleId) {
      return sysRoleMapper.findRolePerm(rolePermEnum, sysRoleId, 1);
    }
}
