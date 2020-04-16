package ru.asu.pdn.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.sql.Date;

@Entity
@Table(name = "violation")
public class Violation {
    private final Date DEFAULT_DATE = new Date(2400, 01, 01);

    private long id;
    private int numProtocol;
    private Date dateProtocol;
    private String articleViolation;
    private Date reviewDate = DEFAULT_DATE;
    private String punishmentType;
    private String collected;
    private int notificationsCount;
    private String judgementDecision;
    private Date dateOfDecision = DEFAULT_DATE;
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

    @Min(value = 100)
    @Max(value = 999_999_999)
    @Column(name = "num_protocol")
    public int getNumProtocol() {
        return numProtocol;
    }

    public void setNumProtocol(int numProt) {
        this.numProtocol = numProt;
    }

    @Column(name = "date_protocol")
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    public Date getDateProtocol() {
        return dateProtocol;
    }

    public void setDateProtocol(Date dateProt) {
        this.dateProtocol = dateProt;
    }

    @NotBlank
    @Column(name = "article_violation")
    public String getArticleViolation() {
        return articleViolation;
    }

    public void setArticleViolation(String articleViolation) {
        this.articleViolation = articleViolation;
    }

    @Column(name = "review_date")
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate.equals("") ? DEFAULT_DATE : reviewDate;
    }

    @NotBlank
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

    @Max(value = 50)
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
        this.dateOfDecision = dateOfDecision.equals("") ? null : dateOfDecision;
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
    @NotBlank
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
