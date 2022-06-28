package businessLogic;

import org.apache.log4j.Logger;

public class Application {

    private final static Logger logger = Logger.getLogger(Application.class);

    public static void main(String[] args) {
        logger.info("start main() in Application.class");
        Reader reader = new FileReader();

        String message = reader.read();
        System.out.println(message);
    }
}
