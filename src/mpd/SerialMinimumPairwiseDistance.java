package mpd;

public class SerialMinimumPairwiseDistance implements MinimumPairwiseDistance {

    @Override
    public int minimumPairwiseDistance(int[] values) {
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < values.length; ++i) {
            for (int j = i + 1; j < values.length; ++j) {
                int diff = Math.abs(values[i] - values[j]);
                if (diff < result) {
                    result = diff;
                }
            }
        }
        return result;
    }

}
