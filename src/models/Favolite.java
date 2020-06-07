package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
@Table(name="favolite")
@NamedQueries({
    @NamedQuery(
            name="getAllFavoliteSite",
            query="select f.site_id from Favolite as f where f.member_id=:member_id and f.favolite_flag=1 order by f.id desc"
            ),
    @NamedQuery(
            name="getFavoliteCheck",
            query="select f from Favolite as f where f.member_id=:member_id and f.site_id=:site_id"
            )
})
@Entity
public class Favolite {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name="member_id", nullable=false)
    private Member member_id;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Member getMember_id() {
        return member_id;
    }
    public void setMember_id(Member member_id) {
        this.member_id = member_id;
    }
    public MusicSite getSite_id() {
        return site_id;
    }
    public void setSite_id(MusicSite site_id) {
        this.site_id = site_id;
    }
    public Integer getFavolite_flag() {
        return favolite_flag;
    }
    public void setFavolite_flag(Integer favolite_flag) {
        this.favolite_flag = favolite_flag;
    }
    @ManyToOne
    @JoinColumn(name="site_id",nullable=false)
    private MusicSite site_id;
    @Column(name="favolite_flag",nullable=false)
    private Integer favolite_flag;
}
