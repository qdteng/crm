package cn.com.ylpw.web.crm.service.impl.sys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.ylpw.web.crm.entity.sys.SysMenu;
import cn.com.ylpw.web.crm.mapper.sys.SysMenuMapper;
import cn.com.ylpw.web.crm.model.sys.SysMenuGrid;
import cn.com.ylpw.web.crm.service.sys.SysMenuService;
import cn.com.ylpw.web.crm.util.Page;

import com.github.pagehelper.PageHelper;

@Transactional
@Service("sysMenuService")
public class SysMenuServiceImpl implements SysMenuService {
    
	@Autowired
	private SysMenuMapper sysMenuMapper;

	@Override
	public void save(SysMenu sysMenu) {
	  sysMenuMapper.save(sysMenu);
	}

    @Override
    public void update(SysMenu sysMenu) {
      if (null != this.findById(sysMenu.getId())) {
        sysMenuMapper.update(sysMenu);
      }
    }

	@Override
	public void delete(SysMenu sysMenu) {
	  sysMenuMapper.delete(sysMenu);
	}

	@Override
	public SysMenu findById(Long id) {
	  return sysMenuMapper.findById(id);
	}

    @Override
    public List<SysMenuGrid> findAll(SysMenu sysMenu) {
      return sysMenuMapper.findAll(sysMenu);
    }

    @Override
    public Page<SysMenuGrid> findAll(SysMenu sysMenu, Page<SysMenuGrid> page) {
      com.github.pagehelper.Page<Object> pageHelper = PageHelper.startPage(page.getPageNo(), page.getPageSize());
      page.setData(sysMenuMapper.findAll(sysMenu));
      page.setTotal(pageHelper.getTotal());
      return page;
    }

    @Override
    public List<SysMenu> findByRoleId(Long roleId) {
      return sysMenuMapper.findByRoleId(roleId);
    }

    @Override
    public List<String> findAllMenusUrl() {
      return sysMenuMapper.findAllMenusUrl();
    }
	
}
