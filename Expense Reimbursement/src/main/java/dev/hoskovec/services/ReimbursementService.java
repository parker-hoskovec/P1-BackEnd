package dev.hoskovec.services;

import dev.hoskovec.entities.ReimbursementRequest;

import java.util.Set;

public interface ReimbursementService {

    ReimbursementRequest createRequest(ReimbursementRequest reimbursementRequest);

    Set<ReimbursementRequest> getAllRequests();

    ReimbursementRequest getRequestById(int id);

    ReimbursementRequest updateRequest(ReimbursementRequest reimbursementRequest);

    boolean deleteRequest(int id);

}
