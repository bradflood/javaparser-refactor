import junit.framework.TestCase;
import org.junit.Test;

public class MyTest extends TestCase {
	@Override
	protected void setUp() {
		//...
	}

	public void testIWillFail() {
		assertEquals(1, 2);
	}
	
	public void notATest() {
		
	}
	
	@Test
	public void testAlreadyHasTestAnnotation() {
		assertEquals(1, 2);
	}
	
	@Override
	void tearDown() {
		//...
	}
}
