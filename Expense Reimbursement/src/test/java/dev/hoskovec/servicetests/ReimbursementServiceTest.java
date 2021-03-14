package dev.hoskovec.servicetests;

import dev.hoskovec.daos.ReimbursementDAO;
import dev.hoskovec.daos.ReimbursementDAOHibernate;
import dev.hoskovec.entities.ReimbursementRequest;
import dev.hoskovec.services.ReimbursementService;
import dev.hoskovec.services.ReimbursementServiceImpl;
import org.junit.jupiter.api.*;

import java.util.Set;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ReimbursementServiceTest {

    private static ReimbursementService reimbursementServ = new ReimbursementServiceImpl(new ReimbursementDAOHibernate());


    @Test
    @Order(1)
    void get_all_requests_test(){
        Set<ReimbursementRequest> allRequests = this.reimbursementServ.getAllRequests();
        Assertions.assertEquals(allRequests.size(), 1);
    }

    @Test
    @Order(2)
    void get_request_by_Id_test(){
        ReimbursementRequest req1 = this.reimbursementServ.getRequestById(3);
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
        this.reimbursementServ.createRequest(req2);
        Assertions.assertFalse(req2.getReqId() == 0);
    }

    @Test
    @Order(4)
    void update_request_test(){
        ReimbursementRequest req3 = this.reimbursementServ.getRequestById(5);
        req3.setReqId(5);
        req3.setReviewReason("Good work agent");
        req3.setReviewId(2);
        req3.setApprovalDate(16511111);
        this.reimbursementServ.updateRequest(req3);
        Assertions.assertEquals(req3.getReviewId(), 2);
    }

    @Test
    @Order(5)
    void delete_request_test(){
        ReimbursementRequest testRequest = this.reimbursementServ.getRequestById(5);
        this.reimbursementServ.deleteRequest(testRequest.getReqId());
    }
}