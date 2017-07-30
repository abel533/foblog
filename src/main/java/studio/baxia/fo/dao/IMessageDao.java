package studio.baxia.fo.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import studio.baxia.fo.pojo.Message;
import studio.baxia.fo.vo.ArticleMessageVo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by Pan on 2016/10/15.
 */
@Repository("iMessageDao")
public interface IMessageDao extends Mapper<Message> {

    /**
     * 删除某条评论并一并删除其子评论
     * @param messageIds 某条评论及其子评论的id集合
     * @return 受影响的行数
     */
    public Integer deleteByIds(@Param("ids") List<Integer> messageIds);

    /**
     * 根据文章id和评论的父id所有的评论记录
     *
     * @param messageArticleId 评论的文章id
     * @param messageParentId  评论的父评论id（null:查出该文章的所有评论，为0+:查出对应父评论id的所有评论）
     * @param messageBlockId 评论所在的文章中的评论区的位置，属于第几块（null：表示查出所有）
     * @return List<Message>
     */
    public List<Message> selectByArticleId(@Param("articleId") Integer messageArticleId, @Param("parentId") Integer messageParentId,@Param("blockId")Integer messageBlockId,@Param("reverseOrder")Integer reverseOrder);

    public List<ArticleMessageVo> selectArticleMessageVo(@Param("articleId") Integer messageArticleId,@Param("reverseOrder")Integer reverseOrder);
}
