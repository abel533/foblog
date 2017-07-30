package studio.baxia.fo.dao;

import org.springframework.stereotype.Repository;
import studio.baxia.fo.pojo.Recommend;
import tk.mybatis.mapper.common.Mapper;

/**
 * Created by Pan on 2016/12/20.
 */
@Repository("iRecommendDao")
public interface IRecommendDao extends Mapper<Recommend> {

    Integer updateHits(Long id);

}
