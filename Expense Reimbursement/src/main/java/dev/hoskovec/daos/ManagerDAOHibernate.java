package dev.hoskovec.daos;

import dev.hoskovec.entities.Manager;
import dev.hoskovec.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ManagerDAOHibernate implements ManagerDAO{

    SessionFactory sf = HibernateUtil.getSessionFactory();


    @Override
    public Set<Manager> getAllManagers() {
        Session sess = sf.openSession();
        CriteriaBuilder criteriaBuilder = sess.getCriteriaBuilder();
        CriteriaQuery<Manager> query = criteriaBuilder.createQuery(Manager.class);
        Root<Manager> root = query.from(Manager.class);
        query.select(root);
        Query query1 = sess.createQuery(query);
        List<Manager> rs = query1.getResultList();
        Set<Manager> allManagers = new HashSet<>(rs);
        sess.close();
        return allManagers;
    }

    @Override
    public Manager getManagerById(int id) {
        Session sess = sf.openSession();
        Manager manager = sess.get(Manager.class, id);
        sess.close();
        return manager;
    }
}
