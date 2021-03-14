package dev.hoskovec.daos;

import dev.hoskovec.entities.ReimbursementRequest;
import dev.hoskovec.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReimbursementDAOHibernate implements ReimbursementDAO{

    private SessionFactory sf = HibernateUtil.getSessionFactory();

    @Override
    public ReimbursementRequest createRequest(ReimbursementRequest reimbursementRequest) {
        Session sess = sf.openSession();
        sess.getTransaction().begin();
        sess.save(reimbursementRequest);
        sess.getTransaction().commit();
        sess.close();
        return reimbursementRequest;
    }

    @Override
    public Set<ReimbursementRequest> getAllRequests() {
        Session sess = sf.openSession();
        CriteriaBuilder criteriaBuilder = sess.getCriteriaBuilder();
        CriteriaQuery<ReimbursementRequest> query = criteriaBuilder.createQuery(ReimbursementRequest.class);
        Root<ReimbursementRequest> root = query.from(ReimbursementRequest.class);
        query.select(root);
        Query query1 = sess.createQuery(query);
        List<ReimbursementRequest> rs = query1.getResultList();
        Set<ReimbursementRequest> allReimbursementRequests = new HashSet<>(rs);
        sess.close();
        return allReimbursementRequests;
    }

    @Override
    public ReimbursementRequest getRequestById(int id) {
        Session sess = sf.openSession();
        ReimbursementRequest reimbursementRequest = sess.get(ReimbursementRequest.class, id);
        sess.close();
        return reimbursementRequest;
    }

    @Override
    public ReimbursementRequest updateRequest(ReimbursementRequest reimbursementRequest) {
        Session sess = sf.openSession();
        sess.getTransaction().begin();
        sess.update(reimbursementRequest);
        sess.getTransaction().commit();
        sess.close();
        return reimbursementRequest;
    }

    @Override
    public boolean deleteRequest(int id) {
        try{
            Session sess = sf.openSession();
            sess.getTransaction().begin();
            sess.delete(this.getRequestById(id));
            sess.getTransaction().commit();
            sess.close();
            return true;
        }catch(HibernateException he){
            he.printStackTrace();
            return false;
        }
    }
}
