package dev.hoskovec.daos;

import dev.hoskovec.entities.ReimbursementRequest;

import java.util.Set;

public interface ReimbursementDAO {

        ReimbursementRequest createRequest(ReimbursementRequest reimbursementRequest);

        Set<ReimbursementRequest> getAllRequests();

        ReimbursementRequest getRequestById(int id);

        ReimbursementRequest updateRequest(ReimbursementRequest reimbursementRequest);

        boolean deleteRequest(int id);

}
