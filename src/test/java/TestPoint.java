import com.example.web.Point;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestPoint {
    @Test
    public void test1() {
        assertFalse(Point.check("1", "2", "1"));
    }

    @Test
    public void test2() {
        assertFalse(Point.check("2", "1", "2"));
    }

    @Test
    public void test3() {
        assertTrue(Point.check("0", "0", "0"));
    }
}
