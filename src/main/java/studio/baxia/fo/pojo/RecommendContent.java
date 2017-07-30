package studio.baxia.fo.pojo;

/**
 * Created by Pan on 2016/12/20.
 */
public class RecommendContent {
    private Integer id;
    private String  content;

    public RecommendContent() {
    }

    public RecommendContent(String content) {
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
