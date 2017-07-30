package studio.baxia.fo.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import studio.baxia.fo.pojo.Tag;
import studio.baxia.fo.vo.TagVo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by Pan on 2016/10/16.
 */
@Repository("iTagDao")
public interface ITagDao extends Mapper<Tag> {
    /**
     * 通过name查找标签
     * @param tagName 标签名
     * @return Tag
     */
	Tag selectByName(@Param("name")String tagName);

	List<TagVo> selectVoBy(@Param("articleStatus")Integer articleStatus);

	List<Tag> selectByIds(@Param("ids")List<Integer> tagIdList);
}
