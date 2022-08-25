package ata.usingstacksandqueues.rollingmean;

import java.awt.*;
import java.util.*;
import java.util.List;

public class RollingMeanCalculator {

    /**
     * Calculates the rolling means of the given data with a given window size.
     * A rolling mean, also called a moving average, is a series of calculated means based on subsets of the original data.
     *
     * See examples below to see how the rolling means are calculated.
     *
     * These means are used in statistics, often for time-series, to help give a better picture of averages and smooth out anomalies.
     * An example would be the historical averages of housing prices, with a 90-day window.
     * Another example would be the historical averages of stocks, with a 30-day window.
     *
     * Example of a rolling mean with window size = 3:
     * Original data: (first) 9 4 3 2 5 2 7 2 (last)
     * Window size: 3
     * Windows:      (9, 4, 3), (4, 3, 2), (3, 2, 5), (2, 5, 2), (5, 2, 7), (2, 7, 2)
     * Rolling means: 5.333,        3,       3.333,       3,        4.667,    3.667
     *
     * Example of a rolling mean with window size = 5:
     * Original data: (first) 9 4 3 2 5 2 7 2 (last)
     * Window size: 5
     * Windows:       (9, 4, 3, 2, 5), (4, 3, 2, 5, 2), (3, 2, 5, 2, 7), (2, 5, 2, 7, 2)
     * Rolling means:       4.6,            3.2,              3.8,              3.6
     *
     * Example of a rolling mean with window size = 10:
     * Original data: (first) 9 4 3 2 5 2 7 2 (last)
     * Window size: 10
     * Windows:        no valid windows
     * Rolling means:  empty list
     *
     * @param numberQueue the original data to calculate the rolling means of
     * @param windowSize the number of consecutive pieces of data to calculate the means of
     * @return a List of doubles containing the means of the data, in first-to-last order,
     * of each window of the given windowSize. If the windowSize is non-positive, returns an empty list.
     */
     public static List<Double> rollingMean(Queue<Double> numberQueue, int windowSize) {
        // TODO 2 Implement the rollingMean method

        if (windowSize > numberQueue.size() || windowSize <= 0) {
            return Collections.emptyList();
        }

        List<Double> rollingMeans = new ArrayList<>(numberQueue.size() - windowSize + 1);

        Queue<Double> windowQueue = new LinkedList<>();
        double windowSum = 0.0;

        for (int i = 0; i < windowSize; i++) {
            double currentValue = numberQueue.poll();
            windowQueue.add(currentValue);
            windowSum += currentValue;
        }

        rollingMeans.add(windowSum / windowSize);

        while (!numberQueue.isEmpty()) {
            double currentValue = numberQueue.poll();
            windowQueue.add(currentValue);

            windowSum -= windowQueue.remove();
            windowSum += currentValue;

            rollingMeans.add(windowSum / windowSize);
        }

        return rollingMeans;
    }
}
