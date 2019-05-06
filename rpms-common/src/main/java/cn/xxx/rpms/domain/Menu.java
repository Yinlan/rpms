package cn.xxx.rpms.domain;

import java.util.ArrayList;
import java.util.List;

//菜单表
public class Menu {
    private Long id;

    private String sn;

    private String name;

    private Long parent;

    private String icon;

    private String url;

    private String intro;

    public Long getId() {
        return id;
    }
    //配置自连接查询
    private List<Menu> children=new ArrayList<>();

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getParent() {
        return parent;
    }

    public void setParent(Long parent) {
        this.parent = parent;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", sn='" + sn + '\'' +
                ", name='" + name + '\'' +
                ", parent=" + parent +
                ", icon='" + icon + '\'' +
                ", url='" + url + '\'' +
                ", intro='" + intro + '\'' +
                ", children=" + children +
                '}';
    }
}