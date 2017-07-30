package studio.baxia.fo.dao;

import org.springframework.stereotype.Repository;
import studio.baxia.fo.pojo.Project;
import tk.mybatis.mapper.common.Mapper;

/**
 * Created by Pan on 2016/12/27.
 */
@Repository("iProjectDao")
public interface IProjectDao extends Mapper<Project> {

    Integer updateHits(Long id);

}
