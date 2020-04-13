package ru.asu.pdn.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "parent")
public class Parent {
    private Integer id;
    private String fio;
    private Date birthDate;
    private String serialNumPass;
    private Date giftDatePass;
    private String whoGivePass;
    private String phone;
    private String work;
    private String address;
    private Set<Child> childSet;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "fio")
    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    @Column(name = "birth_date")
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Column(name = "serial_num_pass")
    public String getSerialNumPass() {
        return serialNumPass;
    }

    public void setSerialNumPass(String serialNumPass) {
        this.serialNumPass = serialNumPass;
    }

    @Column(name = "gift_date_pass")
    public Date getGiftDatePass() {
        return giftDatePass;
    }

    public void setGiftDatePass(Date giftDatePass) {
        this.giftDatePass = giftDatePass;
    }

    @Column(name = "who_give_pass")
    public String getWhoGivePass() {
        return whoGivePass;
    }

    public void setWhoGivePass(String whoGivePass) {
        this.whoGivePass = whoGivePass;
    }

    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "work")
    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @ManyToMany
    @JoinTable(
            name = "parents_childs",
            joinColumns = {@JoinColumn(name = "kids_id")},
            inverseJoinColumns = {@JoinColumn(name = "family_id")}
    )
    public Set<Child> getChildSet() {
        return childSet;
    }

    public void setChildSet(Set<Child> childSet) {
        this.childSet = childSet;
    }
}
