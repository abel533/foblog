package studio.baxia.fo.dao;

import org.springframework.stereotype.Repository;
import studio.baxia.fo.pojo.Authors;
import tk.mybatis.mapper.common.Mapper;

/**
 * Created by FirePan on 2016/10/11.
 */
@Repository(value = "iAuthorsDao")
public interface IAuthorsDao extends Mapper<Authors> {

}
