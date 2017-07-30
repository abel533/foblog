package studio.baxia.fo.common;

import studio.baxia.fo.pojo.BaseId;

import javax.persistence.Transient;

/**
 * Created by Pan on 2016/10/15.
 * 实现类向TreeInfoResult类转换需要继承此类
 */
public class TreeInfo extends BaseId {
    @Transient
    private Integer parentId;

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}
