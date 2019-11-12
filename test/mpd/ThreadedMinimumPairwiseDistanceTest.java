package mpd;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ThreadedMinimumPairwiseDistanceTest {

    public static final int NUM_VALUES = 100000;
    private MinimumPairwiseDistance mpd;

    @Before
    public void setUp() {
        mpd = new ThreadedMinimumPairwiseDistance();
    }

    @Test
    public void testEmptyArray() {
        long[] values = new long[0];
        long minimum = mpd.minimumPairwiseDistance(values);
        assertEquals(Long.MAX_VALUE, minimum);
    }

    @Test
    public void testSmallArrayWithDuplicates() {
        long[] values = new long[] { 3, 2, 0, 5, 8, 9, 6, 3, 2, 0 };
        long minimum = mpd.minimumPairwiseDistance(values);
        assertEquals(0, minimum);
    }

    @Test
    public void testSmallSequence() {
        long[] values = new long[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        long minimum = mpd.minimumPairwiseDistance(values);
        assertEquals(1, minimum);
    }

    @Test
    public void testSmallRandomArray() {
        long[] values = new long[] { 742428, 320304, 479193, 412922, 567421,
                442073, 425546, 393948, 505578, 660888 };
        long minimum = mpd.minimumPairwiseDistance(values);
        assertEquals(12624, minimum);
    }

    @Test
    public void testLargeSequence() {
        long[] values = new long[NUM_VALUES];
        for (int i = 0; i < NUM_VALUES; ++i) {
            values[i] = i;
        }
        long minimum = mpd.minimumPairwiseDistance(values);
        assertEquals(1, minimum);
    }

}
