package mpd;

public class SerialMinimumPairwiseDistance implements MinimumPairwiseDistance {

    @Override
    public long minimumPairwiseDistance(long[] values) {
        long result = Long.MAX_VALUE;
        for (int i = 0; i < values.length; ++i) {
            for (int j = 0; j < i; ++j) {
                // Gives us all the pairs (i, j) where 0 <= j < i < values.length
                long diff = Math.abs(values[i] - values[j]);
                if (diff < result) {
                    result = diff;
                }
            }
        }
        return result;
    }

}
