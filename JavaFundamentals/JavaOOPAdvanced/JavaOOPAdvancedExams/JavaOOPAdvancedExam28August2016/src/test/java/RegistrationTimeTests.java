import bg.softuni.utils.RegistrationTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RegistrationTimeTests {

    private static final String TEST_REGISTRATION_TIME_AS_STRING = "12:24 25/02/2016";
    private static final Integer EXPECTED_HOUR = 12;
    private static final Integer EXPECTED_MINUTE = 24;
    private static final Integer EXPECTED_DAY = 25;
    private static final Integer EXPECTED_MONTH = 2;
    private static final Integer EXPECTED_YEAR = 2016;
    private static final String EXPECTED_TOSTRING = "12:24 25/02/2016";

    private RegistrationTime registrationTime;

    @Before
    public void initializeObject() {
        this.registrationTime = new RegistrationTime(TEST_REGISTRATION_TIME_AS_STRING);
    }

    @Test
    public void testObjectInitialization() {

    }

    @Test
    public void testGetHour() {
        Assert.assertEquals("The hour returned is wrong!", EXPECTED_HOUR, this.registrationTime.getHour());
    }

    @Test
    public void testGetMinute() {
        Assert.assertEquals("The minute returned is wrong!", EXPECTED_MINUTE, this.registrationTime.getMinutes());
    }

    @Test
    public void testGetDay() {
        Assert.assertEquals("The day returned is wrong!", EXPECTED_DAY, this.registrationTime.getDay());
    }

    @Test
    public void testGetMonth() {
        Assert.assertEquals("The month returned is wrong!", EXPECTED_MONTH, this.registrationTime.getMonth());
    }

    @Test
    public void testGetYear() {
        Assert.assertEquals("The year returned is wrong!", EXPECTED_YEAR, this.registrationTime.getYear());
    }

    @Test
    public void testToString() {
        Assert.assertEquals("The toString method returns wrong value!", EXPECTED_TOSTRING, this.registrationTime.toString());
    }
}