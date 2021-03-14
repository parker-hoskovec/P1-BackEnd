package dev.hoskovec.services;

import dev.hoskovec.daos.ReimbursementDAO;
import dev.hoskovec.entities.ReimbursementRequest;

import java.util.Set;

public class ReimbursementServiceImpl implements ReimbursementService{

    private ReimbursementDAO reimbursementDAO;

    public ReimbursementServiceImpl(ReimbursementDAO reimbursementDAO){
        this.reimbursementDAO = reimbursementDAO;
    }

    @Override
    public ReimbursementRequest createRequest(ReimbursementRequest reimbursementRequest) {
        return this.reimbursementDAO.createRequest(reimbursementRequest);
    }

    @Override
    public Set<ReimbursementRequest> getAllRequests() {
        return this.reimbursementDAO.getAllRequests();
    }

    @Override
    public ReimbursementRequest getRequestById(int id) {
        return this.reimbursementDAO.getRequestById(id);
    }

    @Override
    public ReimbursementRequest updateRequest(ReimbursementRequest reimbursementRequest) {
        return this.reimbursementDAO.updateRequest(reimbursementRequest);
    }

    @Override
    public boolean deleteRequest(int id) {
        return this.reimbursementDAO.deleteRequest(id);
    }
}
