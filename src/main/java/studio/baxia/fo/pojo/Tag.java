package studio.baxia.fo.pojo;

import javax.persistence.Table;

/**
 * Created by FirePan on 2016/10/11. 文章标签实体信息.
 */
@Table(name = "t_tag")
public class Tag extends BaseId {
    private String name; // 标签名称

	public Tag() {
		super();
	}

	public Tag(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Tag [id=" + id + ", name=" + name + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
