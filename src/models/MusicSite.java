package models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
@Entity
@NamedQueries({
    @NamedQuery(
            name="getAllMusicSites",
            query="select m from MusicSite as m order by m.id desc"
            )
})
@Table(name="music_site")

public class MusicSite {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name", nullable=false)
    private String name;

    @Column(name="url",nullable=false)
    private String url;
    @Column(name="color_flag", nullable=false)
    private Integer color_flag;


    @Column(name="delete_flag",nullable=false)
    private Integer delete_flag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public Integer getColor_flag() {
        return color_flag;
    }

    public void setColor_flag(Integer color_flag) {
        this.color_flag = color_flag;
    }



    public Integer getDelete_flag() {
        return delete_flag;
    }

    public void setDelete_flag(Integer delete_flag) {
        this.delete_flag = delete_flag;
    }
}