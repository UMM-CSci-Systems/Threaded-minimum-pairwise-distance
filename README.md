# Minimum pairwise distance

This is the starter code for the Minimum Pairwise Distance (sub)lab. The goal of this lab is to use threading to parallize an expensive (in this case O(N^2)) computation and see that this indeed yields performance gains.

## The problem

Given an array ```values``` of ```N``` integers, the task is to find the smallest absolute distance between any two elements, i.e., minimize ```abs(values[i] - values[j])``` over ```0 ≤ i < j < N```. 

## The simple serial solution

In its simple form this is an O(N^2) task because we must compare each of the N^2 pairs of values, or half of that if we take advantage of symmetry and only only check pairs ```(i, j)``` where ```i<j```. There are ways to speed this up in the specific case of just integers (e.g., sort the list in O(N log(N)) and then compute pairwise differences in O(N) time), but if we generalize the contents of the arrays and the notion of distance we can create versions where there's no way to improve on the basic O(N^2) approach, so we're going to stick with that for now.

The file ```src/mpd/SerialMinimumPairwiseDistance.java``` in the starter code includes a serial (non-threaded) O(N^2) solution:
```java
    public int minimumPairwiseDistance(int[] values) {
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < values.length; ++i) {
            for (int j = 0; j < i; ++j) {
                // Gives us all the pairs (i, j) where 0 ≤ j < i < values.length
                int diff = Math.abs(values[i] - values[j]);
                if (diff < result) {
                    result = diff;
                }
            }
        }
        return result;
    }
```

Note that we initialize ```result``` with ```Integer.MAX_VALUE```, which is essentially Java's best effort at saying "positive infinity". Positive infinity is the identity of minimum (i.e., ```min(x, infinity) = x``` for all x), making this a useful starting value and a reasonable default value to return in the case that the array is empty.

## The threaded solution

The goal here is to implement a threaded solution that can run in parallel on hardware with multiple cores. The stub for this solution is in ```src/mpd/ThreadedMinimumPairwiseDistance.java``` and there are various failing JUnit tests waiting for you to implement this class.

The question with this and most parallel problems is how to divide the problem up into chunks that can be processed at least semi-independently. In this case there are N^2/2 pairs (i, j) that need to be processed, as illustrated in the gray triangular section below ![Diagram illustrating all pairs (i, j) such that 0 ≤ j < i < N](https://docs.google.com/drawings/d/1I8xiDTwlbkKTPaRdcMK7PWtZbfLFHTkDI7QZr_OUPlI/pub?w=960&h=720).
