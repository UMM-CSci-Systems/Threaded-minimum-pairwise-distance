package mpd;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SerialMinimumPairwiseDistanceTest {

	private MinimumPairwiseDistance mpd;

	@Before
	public void setUp() throws Exception {
		mpd = new SerialMinimumPairwiseDistance();
	}

	@Test
	public void testEmpty() {
		int[] values = new int[0];
		int minimum = mpd.minimumPairwiseDistance(values);
		assertEquals(Integer.MAX_VALUE, minimum);
	}

}
