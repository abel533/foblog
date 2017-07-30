package studio.baxia.fo.dao;

import org.springframework.stereotype.Repository;
import studio.baxia.fo.pojo.Friendlink;
import tk.mybatis.mapper.common.Mapper;

/**
 * Created by Pan on 2016/12/1.
 */
@Repository("iFriendDao")
public interface IFriendDao extends Mapper<Friendlink> {

    int updateHits(Integer id);
}
