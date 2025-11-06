package es.upm.grise.profunduzacion.cruiseController;

import es.upm.grise.profundizacion.cruiseControl.CruiseControl;
import es.upm.grise.profundizacion.cruiseControl.Speedometer;
import es.upm.grise.profundizacion.cruiseControl.IncorrectSpeedSetException;
import es.upm.grise.profundizacion.cruiseControl.SpeedSetAboveSpeedLimitException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;


public class CruiseControlTest {

    private Speedometer speedometer;
    private CruiseControl cruise;

    @Before
    public void setUp() {
        speedometer = Mockito.mock(Speedometer.class);
        cruise = new CruiseControl(speedometer);
        cruise.setSpeedLimit(2);
    }

    @Test(expected = IncorrectSpeedSetException.class)
    public void testSetSpeedSetThrowsExceptionWhenSpeedIsZero() {
        cruise.setSpeedSet(0);
    }

    @Test
    public void testSetSpeedSetThrowsExceptionWhenSpeedIsNegative() {
        cruise.setSpeedSet(-3);

    }

    @Test(expected= SpeedSetAboveSpeedLimitException.class)
    public void testSetSpeedSetThrowsExceptionWhenSpeedLimitIsNull() {
        cruise.setSpeedLimit(null);
    	cruise.setSpeedLimit(6);
    }

    @Test(expected= SpeedSetAboveSpeedLimitException.class)
    public void testSetSpeedSetThrowsExceptionWhenSpeedSetAboveLimit() {
        cruise.setSpeedLimit(6);

    }

    @Test
    public void testSetSpeedSetOkWhenSpeedSetBelowLimit() throws Exception {
        try {
            cruise.setSpeedSet(1);
        }catch(Exception e) {
        	fail("Ocurrió una excepción inesperada");
        }
    }
}
