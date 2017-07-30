package studio.baxia.fo.pojo;

import javax.persistence.OrderBy;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Pan on 2016/12/20.
 */
@Table(name = "t_recommend")
public class Recommend extends BaseId {
    private String title;
    private String articleUrl;
    private String summary;
    @OrderBy("desc")
    private Date   pubTime;;
    private Integer hits;

    @Override
    public String toString() {
        return "RecommendVo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", articleUrl='" + articleUrl + '\'' +
                ", summary='" + summary + '\'' +
                ", pubTime=" + pubTime +
                ", hits=" + hits +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArticleUrl() {
        return articleUrl;
    }

    public void setArticleUrl(String articleUrl) {
        this.articleUrl = articleUrl;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Date getPubTime() {
        return pubTime;
    }

    public void setPubTime(Date pubTime) {
        this.pubTime = pubTime;
    }

    public Integer getHits() {
        return hits;
    }

    public void setHits(Integer hits) {
        this.hits = hits;
    }
}