package studio.baxia.fo.dao;

import studio.baxia.fo.pojo.Guest;
import tk.mybatis.mapper.common.Mapper;

import java.util.Map;

/*@Repository*/
public interface IGuestDao extends Mapper<Guest> {

    /**
     *
     *通过给定条件查询
     */
    Guest queryOneByCondition(Map<String, Object> condition);
}