import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import tirePressureMonitoringSystem.Alarm;
import tirePressureMonitoringSystem.Sensor;

public class TirePressureMonitoringSystemTests {

    private Alarm alarm;
    private Sensor mockedSensor;

    @Before
    public void initializeObjects() {
        this.alarm = new Alarm();
        this.mockedSensor = Mockito.mock(Sensor.class);
    }

    @Test
    public void checkIfAlarmActivatesWithPressureOutsideTheThreshold() {
        Mockito.when(this.mockedSensor.popNextPressurePsiValue()).thenReturn(14d);
        this.alarm.check(this.mockedSensor);

        Assert.assertTrue(this.alarm.getAlarmOn());
    }

    @Test
    public void checkIfAlarmActivatesWithPressureInsideTheThreshold() {
        Mockito.when(this.mockedSensor.popNextPressurePsiValue()).thenReturn(18d);
        this.alarm.check(this.mockedSensor);

        Assert.assertFalse(this.alarm.getAlarmOn());
    }
}