package dev.hoskovec.entities;

import javax.persistence.*;

@Entity
@Table(name = "reimbursement_request")
public class ReimbursementRequest {

    //expense fields

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "request_id")
    private int reqId;

    @Column(name = "amount")
    private double amount;

    @Column(name = "reason")
    private String reason;

    @Column(name = "review_reason")
    private String reviewReason;

    @Column(name = "submit_date")
    private long submitDate;

    @Column(name = "review_date")
    private long approvalDate;

    @Column(name = "reviewer_id")
    @JoinColumn(name = "reviewer_id")
    private int reviewId;

    @Column(name = "employee_id")
    @JoinColumn(name = "employee_id")
    private int employeeId;
    enum approvalEnum{
        PENDING,
        APPROVED,
        DENIED
    }
    @Enumerated(EnumType.STRING)
    @Column(name = "current_status")
    private approvalEnum approvalStatus;

    public ReimbursementRequest() {
        this.setApprovalStatus(approvalEnum.PENDING);
    }

    //constructor
    public ReimbursementRequest(int reqId, double amount, String reason, long submitDate, int employeeId) {
        this.reqId = reqId;
        this.amount = amount;
        this.reason = reason;
        this.submitDate = submitDate;
        this.approvalDate = -1;
        this.employeeId = employeeId;
        this.approvalStatus = approvalEnum.PENDING;
        this.reviewReason = "";
        this.reviewId = 0;
    }

    //getters and setters

    public double getAmount() {
        return amount;
    }

    public String getReason() {
        return reason;
    }

    public long getSubmitDate() {
        return submitDate;
    }

    public long getApprovalDate() {
        return approvalDate;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public approvalEnum getApprovalStatus() {
        return approvalStatus;
    }

    public String getReviewReason() {
        return reviewReason;
    }

    public int getReqId() {
        return reqId;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setApprovalDate(long approvalDate) {
        this.approvalDate = approvalDate;
    }

    public void setApprovalStatus(approvalEnum approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public void setReviewReason(String reviewReason) {
        this.reviewReason = reviewReason;
    }

    public void setReqId(int reqId) {
        this.reqId = reqId;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setSubmitDate(long submitDate) {
        this.submitDate = submitDate;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    //reimbursementReq toString


    @Override
    public String toString() {
        return "ReimbursementRequest{" +
                "amount=" + amount +
                ", reason='" + reason + '\'' +
                ", reviewReason='" + reviewReason + '\'' +
                ", submitDate=" + submitDate +
                ", approvalDate=" + approvalDate +
                ", employeeId=" + employeeId +
                ", approvalStatus=" + approvalStatus +
                '}';
    }
}
