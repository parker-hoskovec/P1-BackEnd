package dev.hoskovec.daotests;

import dev.hoskovec.daos.ReimbursementDAO;
import dev.hoskovec.daos.ReimbursementDAOHibernate;
import dev.hoskovec.entities.ReimbursementRequest;
import org.junit.jupiter.api.*;

import java.util.Set;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ReimbursementDAOTest {

    private static ReimbursementDAO reimbursementDAO = new ReimbursementDAOHibernate();


    @Test
    @Order(1)
    void get_all_requests_test(){
        Set<ReimbursementRequest> allRequests = this.reimbursementDAO.getAllRequests();
        Assertions.assertEquals(allRequests.size(), 1);
    }

    @Test
    @Order(2)
    void get_request_by_Id_test(){
        ReimbursementRequest req1 = this.reimbursementDAO.getRequestById(3);
        Assertions.assertEquals(req1.getAmount(), 299);
    }

    @Test
    @Order(3)
    void create_request_test(){
        ReimbursementRequest req2 = new ReimbursementRequest();
        req2.setAmount(500);
        req2.setReason("Plane Ticket");
        req2.setEmployeeId(1);
        req2.setSubmitDate(16503040);
        this.reimbursementDAO.createRequest(req2);
        Assertions.assertFalse(req2.getReqId() == 0);
    }

    @Test
    @Order(4)
    void update_request_test(){
        ReimbursementRequest req3 = this.reimbursementDAO.getRequestById(4);
        req3.setReqId(4);
        req3.setReviewReason("Good work agent");
        req3.setReviewId(2);
        req3.setApprovalDate(16511111);
        this.reimbursementDAO.updateRequest(req3);
        Assertions.assertEquals(req3.getReviewId(), 2);
    }

    @Test
    @Order(5)
    void delete_request_test(){
        ReimbursementRequest testRequest = this.reimbursementDAO.getRequestById(4);
        this.reimbursementDAO.deleteRequest(testRequest.getReqId());
    }
}
