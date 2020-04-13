package ru.asu.pdn.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "violation")
public class Violation {

    private long id;
    private int numProtocol;
    private Date dateProtocol;
    private String articleViolation;
    private Date reviewDate;
    private String punishmentType;
    private String collected;
    private int notificationsCount;
    private String judgementDecision;
    private Date dateOfDecision;
    private boolean returnToModify;
    private boolean terminationBecauseDate;
    private String violationAddress;
    private Child child;

    public Violation() {
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "num_protocol")
    public int getNumProtocol() {
        return numProtocol;
    }

    public void setNumProtocol(int numProt) {
        this.numProtocol = numProt;
    }

    @Column(name = "date_protocol")
    public Date getDateProtocol() {
        return dateProtocol;
    }

    public void setDateProtocol(Date dateProt) {
        this.dateProtocol = dateProt;
    }

    @Column(name = "article_violation")
    public String getArticleViolation() {
        return articleViolation;
    }

    public void setArticleViolation(String articleViolation) {
        this.articleViolation = articleViolation;
    }

    @Column(name = "review_date")
    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    @Column(name = "punishment_type")
    public String getPunishmentType() {
        return punishmentType;
    }

    public void setPunishmentType(String punichmentType) {
        this.punishmentType = punichmentType;
    }

    @Column(name = "collected")
    public String getCollected() {
        return collected;
    }

    public void setCollected(String collected) {
        this.collected = collected;
    }

    @Column(name = "notifications_count")
    public int getNotificationsCount() {
        return notificationsCount;
    }

    public void setNotificationsCount(int notificationsCount) {
        this.notificationsCount = notificationsCount;
    }

    @Column(name = "judgement_decision")
    public String getJudgementDecision() {
        return judgementDecision;
    }


    public void setJudgementDecision(String judgementDecision) {
        this.judgementDecision = judgementDecision;
    }

    @Column(name = "date_of_decision")
    public Date getDateOfDecision() {
        return dateOfDecision;
    }

    public void setDateOfDecision(Date dateOfDecision) {
        this.dateOfDecision = dateOfDecision;
    }

    @Column(name = "return_to_modify")
    public boolean isReturnToModify() {
        return returnToModify;
    }

    public void setReturnToModify(boolean returnToModify) {
        this.returnToModify = returnToModify;
    }

    @Column(name = "termination_because_date")
    public boolean isTerminationBecauseDate() {
        return terminationBecauseDate;
    }

    public void setTerminationBecauseDate(boolean terminationBecauseDate) {
        this.terminationBecauseDate = terminationBecauseDate;
    }

    @Column(name = "violation_address")
    public String getViolationAddress() {
        return violationAddress;
    }

    public void setViolationAddress(String violationAddress) {
        this.violationAddress = violationAddress;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "child_id")
    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    @Override
    public String toString() {
        return "Violation{" +
                "id=" + id +
                ", numProtocol=" + numProtocol +
                ", dateProtocol=" + dateProtocol +
                ", articleViolation='" + articleViolation + '\'' +
                ", reviewDate=" + reviewDate +
                ", punishmentType='" + punishmentType + '\'' +
                ", collected='" + collected + '\'' +
                ", notificationsCount=" + notificationsCount +
                ", judgementDecision='" + judgementDecision + '\'' +
                ", dateOfDecision=" + dateOfDecision +
                ", returnToModify=" + returnToModify +
                ", terminationBecauseDate=" + terminationBecauseDate +
                ", violationAddress='" + violationAddress + '\'' +
                ", child=" + child +
                '}';
    }
}
