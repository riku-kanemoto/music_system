package models;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name="members")
@NamedQueries({
    @NamedQuery(
            name="getAllMembers",
            query="select m from Member as m order by m.id desc"
            ),
    @NamedQuery(
            name="checkRegisteredAdress",
            query="select count(m) from Member as m where m.adress=:adress"
            ),
    @NamedQuery(
            name="checkLoginAdressAndPassword",
            query="select m from Member as m where m.delete_flag=0 and m.adress=:adress and m.password=:password"
            )
})
@Entity
public class Member {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name" ,nullable=false)
    private String name;

    @Column(name="adress",nullable=false,unique=true)
    private String adress;

    @Column(name="password",length=64,nullable=false)
    private String password;

    @Column(name="admin_flag",nullable=false)
    private Integer admin_flag;

    @Column(name="delete_flag",nullable=false)
    private Integer delete_flag;

    @Column(name="created_at" ,nullable=false)
    private Timestamp created_at;

    @Column(name = "updated_at", nullable = false)
    private Timestamp updated_at;



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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAdmin_flag() {
        return admin_flag;
    }

    public void setAdmin_flag(Integer admin_flag) {
        this.admin_flag = admin_flag;
    }

    public Integer getDelete_flag() {
        return delete_flag;
    }

    public void setDelete_flag(Integer delete_flag) {
        this.delete_flag = delete_flag;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }
    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

}
