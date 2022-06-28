package manyTOmany;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
//import org.apache.logging.log4j.Level;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;


public class HibernateUtil {

//    static final Logger userLogger = LogManager.getLogger(HibernateUtil.class);
//    static final Logger rootLogger = LogManager.getRootLogger();
    private static SessionFactory factory;

    static {
        try {
            factory = new Configuration()
                    .configure("manytomany.cfg.xml")
                    .buildSessionFactory();

//            rootLogger.info("Root logger !!!!!!!!!!!!!!!!!!!!!111");
//            userLogger.info("User logger !!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public static SessionFactory getSessionFactory () {
        return factory;
    }
}
