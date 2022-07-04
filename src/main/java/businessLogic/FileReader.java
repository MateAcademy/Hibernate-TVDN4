package businessLogic;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.*;


public class FileReader implements Reader {

    private final static Logger logger = Logger.getLogger(FileReader.class);

    @Override
    public String read() {
        String message = "";
        try {
            URI url = ClassLoader.getSystemResource("message.txt").toURI();
            logger.debug("File URL have been gotten");

            byte[] fileBytes = Files.readAllBytes(Paths.get(url));
            logger.debug("Bete array from file have been gotten");

            message = new String(fileBytes);
            logger.info("Message from file have been gotten");
        } catch (URISyntaxException | NullPointerException | IOException e) {
            logger.error(e);
        }
        return message;
    }
}
