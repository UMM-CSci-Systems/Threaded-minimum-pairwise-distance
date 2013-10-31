package mpd;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class ThreadTimingTest {
	
	public static final int NUM_VALUES = 100000;

	@Test
    public void testSortingTiming() {
        Random random = new Random();
        MinimumPairwiseDistance serialMPD = new SerialMinimumPairwiseDistance();
        int[] serialValues = new int[NUM_VALUES];
        MinimumPairwiseDistance threadedMPD = new ThreadedMinimumPairwiseDistance();
        int[] threadedValues = new int[NUM_VALUES];
        for (int i=0; i<NUM_VALUES; ++i) {
            serialValues[i] = random.nextInt();
            threadedValues[i] = serialValues[i];
        }

        long startTime = System.currentTimeMillis();
        serialMPD.minimumPairwiseDistance(serialValues);
        long endTime = System.currentTimeMillis();
        long serialTime = endTime - startTime;
        
        startTime = System.currentTimeMillis();
        threadedMPD.minimumPairwiseDistance(threadedValues);
        endTime = System.currentTimeMillis();
        long threadedTime = endTime - startTime;
        
        System.out.println(serialTime);
        System.out.println(threadedTime);

        assertArrayEquals(serialValues, threadedValues);
        assertTrue(serialTime / 1.5 >  threadedTime);
    }
	
}
