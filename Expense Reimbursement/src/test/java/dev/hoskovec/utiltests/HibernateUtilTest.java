package dev.hoskovec.utiltests;

import dev.hoskovec.utils.HibernateUtil;
import org.hibernate.SessionFactory;

import org.junit.jupiter.api.Test;

public class HibernateUtilTest {
    @Test
    public void creates_sessionfactory(){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        System.out.println(sf);
    }
}
