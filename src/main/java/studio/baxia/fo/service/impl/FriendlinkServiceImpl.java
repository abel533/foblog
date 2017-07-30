package studio.baxia.fo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studio.baxia.fo.common.PageConfig;
import studio.baxia.fo.common.PageInfoResult;
import studio.baxia.fo.dao.IFriendDao;
import studio.baxia.fo.pojo.Friendlink;
import studio.baxia.fo.service.IFriendlinkService;
import studio.baxia.fo.util.ReturnUtil;

import java.util.Date;
import java.util.List;

/**
 * Created by Pan on 2016/12/1.
 */
@Service("iFriendlinkService")
public class FriendlinkServiceImpl implements IFriendlinkService {

    @Autowired
    private IFriendDao iFriendDao;

    /**
     * 添加
     *
     * @param friendlink
     * @return 操作结果
     */
    @Override
    public boolean add(Friendlink friendlink) {
        if(friendlink==null){
            return false;
        }
        friendlink.setAddTime(new Date());
        friendlink.setHits(0);
        int result = iFriendDao.insert(friendlink);
        return ReturnUtil.returnResult(result);
    }

    /**
     * 分页获取
     *
     * @param pageConfig
     * @return 分页结果
     */
    @Override
    public PageInfoResult<Friendlink> pagingList(PageConfig pageConfig) {
        PageHelper.startPage(pageConfig);
        List<Friendlink> list = iFriendDao.selectAll();
        PageInfoResult<Friendlink> pageInfoResult = new PageInfoResult<>(list, pageConfig, (int) ((Page) list).getTotal());
        return pageInfoResult;
    }

    /**
     * 获取所有
     *
     * @return 所有记录
     */
    @Override
    public List<Friendlink> list() {
        List<Friendlink> list = iFriendDao.selectAll();
        return list;
    }

    @Override
    public Friendlink get(int fId) {
        Friendlink friendlink = iFriendDao.selectByPrimaryKey(fId);
        return friendlink;
    }

    @Override
    public boolean delete(int fId) {
        int result = iFriendDao.deleteByPrimaryKey(fId);
        return ReturnUtil.returnResult(result);
    }

    @Override
    public boolean update(Friendlink friendlink) {
        int result = iFriendDao.updateByPrimaryKey(friendlink);
        return ReturnUtil.returnResult(result);
    }

    @Override
    public boolean hits(int id) {
        iFriendDao.updateHits(id);
        return true;
    }
}
