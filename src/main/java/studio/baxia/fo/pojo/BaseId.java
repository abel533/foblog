package studio.baxia.fo.pojo;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author liuzh
 * @since 2017/7/30.
 */
public class BaseId {
    @Id
    @GeneratedValue(generator = "JDBC")
    protected Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
