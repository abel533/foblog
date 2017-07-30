package studio.baxia.fo.pojo;

import javax.persistence.Table;

/**
 * Created by FirePan on 2016/10/11.
 * 访客实体信息.
 */
@Table(name = "t_guest")
public class Guest extends BaseId {
    private String email;//通讯邮箱
    private String nickname;//昵称
    private String personalWebsite;//个人网址
    private String accessIp;//访问IP

    @Override
    public String toString() {
        return "Guest{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", nickname='" + nickname + '\'' +
                ", personalWebsite='" + personalWebsite + '\'' +
                ", accessIp='" + accessIp + '\'' +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPersonalWebsite() {
        return personalWebsite;
    }

    public void setPersonalWebsite(String personalWebsite) {
        this.personalWebsite = personalWebsite;
    }

    public String getAccessIp() {
        return accessIp;
    }

    public void setAccessIp(String accessIp) {
        this.accessIp = accessIp;
    }
}
