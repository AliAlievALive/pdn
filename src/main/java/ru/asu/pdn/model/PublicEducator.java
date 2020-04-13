package ru.asu.pdn.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "public_educator")
public class PublicEducator {
    private Integer id;
    private String fio;
    private Date setDate;
    private String phone;
    private String work;
    private String address;
    private Child child;

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

    @Column(name = "set_date")
    public Date getSetDate() {
        return setDate;
    }

    public void setSetDate(Date setDate) {
        this.setDate = setDate;
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

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id")
    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }
}
