package dev.hoskovec.daos;

import dev.hoskovec.entities.Employee;
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

public class EmployeeDAOHibernate implements EmployeeDAO{

    SessionFactory sf = HibernateUtil.getSessionFactory();

    @Override
    public Set<Employee> getAllEmployees() {
        Session sess = sf.openSession();
        CriteriaBuilder criteriaBuilder = sess.getCriteriaBuilder();
        CriteriaQuery<Employee> query = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> root = query.from(Employee.class);
        query.select(root);
        Query query1 = sess.createQuery(query);
        List<Employee> rs = query1.getResultList();
        Set<Employee> allEmployees = new HashSet<>(rs);
        sess.close();
        return allEmployees;
    }

    @Override
    public Employee getEmployeeById(int id) {
        Session sess = sf.openSession();
        Employee employee = sess.get(Employee.class, id);
        return employee;
    }
}
