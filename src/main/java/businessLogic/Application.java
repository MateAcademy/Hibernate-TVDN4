package businessLogic;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Application {

    private static Class<Application> CLAZZ = Application.class;
    private final static Logger logger = Logger.getLogger(CLAZZ);

    public static void main(String[] args) {
//        String log4jConfPath = "/home/user/dev/Hibernate-many-to-many/src/main/resources/log4j.xml";
        String log4jConfPath = "/home/user/dev/Hibernate-many-to-many/src/main/resources/log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);



        logger.debug("start main() in Application.class");
        Reader reader = new FileReader();

        String message = reader.read();
        System.out.println(message);
        logger.debug("finish main() in Application.class");
    }
}
