package dev.hoskovec.controllers;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.google.gson.Gson;
import dev.hoskovec.daos.ReimbursementDAOHibernate;
import dev.hoskovec.entities.Manager;
import dev.hoskovec.entities.ReimbursementRequest;
import dev.hoskovec.services.ReimbursementService;
import dev.hoskovec.services.ReimbursementServiceImpl;
import dev.hoskovec.utils.JwtUtil;
import io.javalin.http.Handler;

import java.util.Set;

public class ReimbursementController {

    private ReimbursementService reimbursementService = new ReimbursementServiceImpl(new ReimbursementDAOHibernate());

    public Handler getAllReimbursementsHandler = (ctx) -> {
        Set<ReimbursementRequest> allRequests = this.reimbursementService.getAllRequests();
        Gson gson = new Gson();
        String requestJSON = gson.toJson(allRequests);
        ctx.result(requestJSON);
    };

    public Handler getReimbursementByIdHandler = (ctx) -> {
        int id  = Integer.parseInt(ctx.pathParam("id"));
        ReimbursementRequest reimbursementRequest = this.reimbursementService.getRequestById(id);

        if (reimbursementRequest== null){
            ctx.result("Reimbursement not found");
            ctx.status(404);
        }else{
            Gson gson = new Gson();
            String requestJSON = gson.toJson(reimbursementRequest);
            ctx.result(requestJSON);
            ctx.status(200);
        }
    };

    public Handler createReimbursementHandler = (ctx) -> {
        String body = ctx.body();
        Gson gson = new Gson();
        ReimbursementRequest reimbursementRequest = gson.fromJson(body, ReimbursementRequest.class);
        reimbursementRequest.setApprovalDate(-1);
        reimbursementRequest.setReviewId(0);
        reimbursementRequest.setReviewReason("");
        ReimbursementRequest dummyRequest = new ReimbursementRequest();
        reimbursementRequest.setApprovalStatus(dummyRequest.getApprovalStatus());
        this.reimbursementService.createRequest(reimbursementRequest);
        String json = gson.toJson(reimbursementRequest);
        ctx.result(json);
        ctx.status(201);
    };

    public Handler updateReimbursementHandler = (ctx) ->{
        String jwt = ctx.header("Authorization");
        DecodedJWT decodedJWT = JwtUtil.isValidJWT(jwt);
        if (decodedJWT.getClaim("role").asString().equals("Manager")) {
            int id = Integer.parseInt(ctx.pathParam("id"));
            String body = ctx.body();
            Gson gson = new Gson();
            ReimbursementRequest reimbursementRequest = gson.fromJson(body, ReimbursementRequest.class);
            reimbursementRequest.setReqId(id);
            this.reimbursementService.updateRequest(reimbursementRequest);
            ctx.status(201);
        }else{
           ctx.result("Invalid permisions");
           ctx.status(418);
        }
    };

    public Handler deleteReimbursementHandler = (ctx) -> {
        int id = Integer.parseInt(ctx.pathParam("id"));
        boolean deleted = this.reimbursementService.deleteRequest(id);
        if(deleted){
            ctx.result("Request deleted");
        }else{
            ctx.result("Request not found");
        }
    };

}
