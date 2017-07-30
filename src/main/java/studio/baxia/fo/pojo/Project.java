package studio.baxia.fo.pojo;

import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Pan on 2016/12/27.
 */
@Table(name = "t_project")
public class Project extends BaseId {
    private String  name;
    private String  introduction;
    private Date    pubTime;
    private Integer hits;
    private String  downUrl;
    private String  articleUrl;
    private Boolean status;

    public Project() {
    }
    public Project(boolean status) {
        this.status = status;
    }
    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", introduction='" + introduction + '\'' +
                ", pubTime=" + pubTime +
                ", hits=" + hits +
                ", downUrl='" + downUrl + '\'' +
                ", articleUrl='" + articleUrl + '\'' +
                ", status=" + status +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
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

    public String getDownUrl() {
        return downUrl;
    }

    public void setDownUrl(String downUrl) {
        this.downUrl = downUrl;
    }

    public String getArticleUrl() {
        return articleUrl;
    }

    public void setArticleUrl(String articleUrl) {
        this.articleUrl = articleUrl;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
