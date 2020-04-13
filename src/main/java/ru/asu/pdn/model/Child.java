package ru.asu.pdn.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "child")
public class Child {
    private Integer id;
    private String fio;
    private Date birthDate;
    private String serialNumPass;
    private Date giftDatePass;
    private String whoGivePass;
    private String phone;
    private String school;
    private String address;
    private Set<Parent> parents;
    private PublicEducator publicEducator;
    private Set<Violation> violations;

    public Child() {
    }

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

    @Column(name = "school")
    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
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
            name = "childs_parents",
            joinColumns = {@JoinColumn(name = "family_id")},
            inverseJoinColumns = {@JoinColumn(name = "offense_id")}
    )
    public Set<Parent> getParents() {
        return parents;
    }

    public void setParents(Set<Parent> parents) {
        this.parents = parents;
    }

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id")
    public PublicEducator getPublicEducator() {
        return publicEducator;
    }

    public void setPublicEducator(PublicEducator publicEducator) {
        this.publicEducator = publicEducator;
    }

    @OneToMany(mappedBy = "child", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Set<Violation> getViolations() {
        return violations;
    }

    public void setViolations(Set<Violation> violations) {
        this.violations = violations;
    }

    @Override
    public String toString() {
        return fio;
    }
}
