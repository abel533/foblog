package studio.baxia.fo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import studio.baxia.fo.common.PageConfig;
import studio.baxia.fo.common.PageInfoResult;
import studio.baxia.fo.dao.IProjectDao;
import studio.baxia.fo.pojo.Project;
import studio.baxia.fo.service.IProjectService;
import studio.baxia.fo.util.ReturnUtil;

import java.util.Date;
import java.util.List;

/**
 * Created by Pan on 2016/12/27.
 */
@Transactional
@Service("projectService")
public class ProjectServiceImpl implements IProjectService {

    @Autowired
    private IProjectDao iProjectDao;

    @Override
    public long add(Project project) {
        project.setHits(0);
        project.setPubTime(new Date());
        Integer result = iProjectDao.insert(project);
        if (ReturnUtil.returnResult(result)) {
            return project.getId();
        }
        return 0;
    }

    @Override
    public long edit(Project project) {
        Integer result = iProjectDao.updateByPrimaryKey(project);
        if (ReturnUtil.returnResult(result)) {
            return project.getId();
        }
        return 0;
    }

    @Override
    public boolean remove(long id) {
        Integer result = iProjectDao.deleteByPrimaryKey(id);
        return ReturnUtil.returnResult(result);
    }

    @Override
    public List<Project> list(boolean status) {
        Project project = new Project(status);
        return iProjectDao.select(project);
    }

    @Override
    public PageInfoResult<Project> list(PageConfig pageConfig, Project project) {
        PageHelper.startPage(pageConfig);
        List<Project> list = iProjectDao.select(project);
        PageInfoResult<Project> pageInfoResult = new PageInfoResult<>(list, pageConfig, (int) ((Page) list).getTotal());
        return pageInfoResult;
    }

    @Override
    public boolean hits(Long id) {
        iProjectDao.updateHits(id);
        return false;
    }

    @Override
    public Project get(long id, boolean status) {
        Project selectBy = new Project();
        selectBy.setId((int) id);
        selectBy.setStatus(status);
        return iProjectDao.selectOne(selectBy);
    }
}
