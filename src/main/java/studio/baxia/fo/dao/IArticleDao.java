package studio.baxia.fo.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import studio.baxia.fo.pojo.Article;
import studio.baxia.fo.vo.ArchiveVo;
import studio.baxia.fo.vo.ArticleVo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by Pan on 2016/10/13.
 */
@Repository(value = "iArticleDao")
public interface IArticleDao extends Mapper<Article> {

	Integer updateStatus(Article article);

	/**
	 * 通过id查找
	 * 
	 * @param articleId
	 *            文章id
	 * @return Article
	 */
	ArticleVo selectVoById(@Param("id") Integer articleId);

    ArticleVo selectVoByCode(@Param("code") String code,
                             @Param("status") Integer articleStatus);

	/**
	 * 通过标题、类别id、标签id进行模糊查找
	 * 注意：categoryId和tagId的值用"id,"表示，比如"1,"，因为规定数据库中存储的格式为id1,id2,id3方式存储
	 * 
	 * @param article
	 *            文章信息（此处可选包括：title、categoryIds、tagIds、status）
	 * @return
	 */
    List<Article> selectBy(Article article);

	/**
	 * 通过标题、类别id、标签id进行模糊查找
	 * 注意：categoryId和tagId的值用"id,"表示，比如"1,"，因为规定数据库中存储的格式为id1,id2,id3/方式存储
	 * 
	 * @param article
	 *            文章信息（此处可选包括：title、categoryIds、tagIds、status）
	 * @return
	 */
    List<ArticleVo> selectVoBy(Article article);

	/**
	 * 通过标题精确取得文章
	 * 
	 * @param articleTitle
	 * @return
	 */
	ArticleVo selectVoByTitle(@Param("title") String articleTitle,
			@Param("status") Integer articleStatus);

	Article selectNextOrPreVoBy(@Param("article") Article article,
			@Param("nextOrPreVo") Boolean nextOrPreVo);

	Integer updateCategoryId(@Param("oldCategoryId") Integer oldCategoryId,
			@Param("newCategoryId") Integer newCategoryId);

	/**
	 * 获取所有归档，即获取每年或者每月的归档
	 *
	 * @param articleStatus
	 *            文章状态，传值设定为blog状态 . CommonConstant类中有对应的常量
	 * @param archiveTypeYear
	 *            归档类型：%Y年 . CommonConstant类中有对应的常量
	 * @param archiveTypeYearMonth 归档类型：%Y年%m月 . CommonConstant类中有对应的常量
	 * @return
	 */
	List<ArchiveVo> selectAllArchives(@Param("status") Integer articleStatus,
			@Param("archive_type_year") String archiveTypeYear,
			@Param("archive_type_year_month") String archiveTypeYearMonth);

	/**
	 * 获取某归档对应的所有文章
	 *
	 * @param articleStatus
	 *            文章状态，传值设定为blog状态 . CommonConstant类中有对应的常量
	 * @param archiveType
	 *            归档类型：%Y年 %Y年%m月 . CommonConstant类中有对应的常量
	 * @param monthName
	 *            归档中的具体信息，如：2016年10月
	 * @return
	 */
	List<Article> selectArchiveArticles(@Param("status") Integer articleStatus,
			@Param("archive_type") String archiveType,
			@Param("month_name") String monthName);

    int updateHits(Article article);
}
