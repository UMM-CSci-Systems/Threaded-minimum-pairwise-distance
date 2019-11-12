package mpd;

import java.util.Random;

public class ThreadedMain {

    public static void main(String[] args) {
        int numValues = Integer.parseInt(args[0]);
        MinimumPairwiseDistance mpd = new ThreadedMinimumPairwiseDistance();

        Random random = new Random();
        long[] values = new long[numValues];
        for (int i = 0; i < numValues; ++i) {
            values[i] = random.nextInt();
            //We use random.nextInt here otherwise the code will not function properly
            //See https://github.com/UMM-CSci-Systems/Threaded-minimum-pairwise-distance/issues/3
            //for more details
        }
        
        long result = mpd.minimumPairwiseDistance(values);
        System.out.println("The minimum distance was " + result);
    }

}
