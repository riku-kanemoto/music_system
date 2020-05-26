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
class Member {
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
    private String admin_flag;

    @Column(name="delete_flag",nullable=false)
    private Integer delete_flag;

    @Column(name="created_at" ,nullable=false)
    private Timestamp created_at;
}
