package cn.com.ylpw.web.crm.service.impl.other;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.ylpw.web.crm.entity.usable.TFiles;
import cn.com.ylpw.web.crm.service.impl.BaseServiceImpl;
import cn.com.ylpw.web.crm.service.other.FileService;

@Transactional
@Service("fileServiceImpl")
public class FileServiceImpl extends BaseServiceImpl<TFiles> implements FileService{

	@Override
	protected Class setClass() {
		return TFiles.class;
	}

}
