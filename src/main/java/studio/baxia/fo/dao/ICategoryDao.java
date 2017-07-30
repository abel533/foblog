package studio.baxia.fo.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import studio.baxia.fo.pojo.Category;
import studio.baxia.fo.vo.CategoryVo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by Pan on 2016/10/16.
 */
@Repository("iCategoryDao")
public interface ICategoryDao extends Mapper<Category> {

    /**
     * 删除类别
     *
     * @param categoryIds 类别id集合
     * @return 受影响的行数
     */
    Integer delete(@Param("ids") List<Integer> categoryIds);

    Category selectByCode(@Param("code") String categoryCode,@Param("status")Boolean status);

    Category selectByName(@Param("name") String categoryName,@Param("status")Boolean status);

    List<CategoryVo> selectVoBy(@Param("articleStatus") Integer articleStatus, @Param("status") Boolean status);

}
