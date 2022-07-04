import org.junit.Assume;
import org.junit.Test;

import java.util.List;

public class InputFieldsTest {

    @Test
    //@DisplayName("Check driver license number for active (with events) drivers for the last week")
    public void driverLicenseNumberBlankOrTooLongTest() throws Exception {
        //List<List<String>> rs = c.executeQuery("SELECT q.driver_id, q.org_id, q.first_name, q.last_name, q.license_number, q.create_date, q.ref_key FROM fleet.driver_profile q WHERE (license_number is null OR length(license_number) > 20) AND q.org_id not in ("+orgIdTestersBlackList+") AND q.driver_id in (select distinct driver_id_1 FROM eld.eld_event w WHERE w.create_date > now() - '1 week'::interval);");

        boolean ver = false;
        Assume.assumeFalse("Driver License Number is empty or length more then 20 symbols " , ver);
    }
}
