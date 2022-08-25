package ata.usingstacksandqueues.rollingmean;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class RollingMeanCalculatorTest {

    @Test
    public void rollingMean_windowOne_returnsCorrect() {
        // GIVEN
        Queue<Double> queue = new LinkedList<>(Arrays.asList(new Double[]{2.0, 4.0, 6.0, 4.0}));
        int window = 1;

        //WHEN
        List<Double> result = RollingMeanCalculator.rollingMean(queue, window);

        //THEN
        assertEquals(Arrays.asList(new Double[]{2.0, 4.0, 6.0, 4.0}), result, "Window size 1 should generate same values.");
    }

    @Test
    public void rollingMean_windowTwo_returnsCorrect() {
        // GIVEN
        Queue<Double> queue = new LinkedList<>(Arrays.asList(new Double[]{2.0, 4.0, 6.0, 4.0}));
        int window = 2;

        //WHEN
        List<Double> result = RollingMeanCalculator.rollingMean(queue, window);

        //THEN
        assertEquals(Arrays.asList(new Double[]{3.0, 5.0, 5.0}), result, "Window size 2 should generate means of pairs.");
    }

    @Test
    public void rollingMean_windowFull_returnsCorrect() {
        // GIVEN
        Queue<Double> queue = new LinkedList<>(Arrays.asList(new Double[]{2.0, 4.0, 6.0, 4.0}));
        int window = 4;

        //WHEN
        List<Double> result = RollingMeanCalculator.rollingMean(queue, window);

        //THEN
        assertEquals(Arrays.asList(new Double[]{4.0}), result, "Window size equal to length of data should generate mean of data.");
    }

    @Test
    public void rollingMean_windowTooLarge_returnsEmpty() {
        // GIVEN
        Queue<Double> queue = new LinkedList<>(Arrays.asList(new Double[]{2.0, 4.0, 6.0, 4.0}));
        int window = 5;

        //WHEN
        List<Double> result = RollingMeanCalculator.rollingMean(queue, window);

        //THEN
        assertEquals(Arrays.asList(new Double[]{}), result, "Window size greater than data size should generate empty list");
    }

    @Test
    public void rollingMean_windowNegative_returnsEmpty() {
        // GIVEN
        Queue<Double> queue = new LinkedList<>(Arrays.asList(new Double[]{2.0, 4.0, 6.0, 4.0}));
        int window = -1;

        //WHEN
        List<Double> result = RollingMeanCalculator.rollingMean(queue, window);

        //THEN
        assertEquals(Arrays.asList(new Double[]{}), result, "Negative window size should generate empty list.");
    }

    @Test
    public void rollingMean_windowZero_returnsEmpty() {
        // GIVEN
        Queue<Double> queue = new LinkedList<>(Arrays.asList(new Double[]{2.0, 4.0, 6.0, 4.0}));
        int window = 0;

        //WHEN
        List<Double> result = RollingMeanCalculator.rollingMean(queue, window);

        //THEN
        assertEquals(Arrays.asList(new Double[]{}), result, "Zero window size should generate empty list.");
    }

    @Test
    public void rollingMean_emptyFile_returnsEmpty() {
        // GIVEN
        Queue<Double> queue = new LinkedList<>(Arrays.asList(new Double[]{}));
        int window = 0;

        //WHEN
        List<Double> result = RollingMeanCalculator.rollingMean(queue, window);

        //THEN
        assertEquals(Arrays.asList(new Double[]{}), result, "Incoming empty queue of data should generate empty list.");
    }


    @Test
    public void rollingMean_windowFiveLargeSet_returnsCorrect() {
        // GIVEN
        Queue<Double> queue = new LinkedList<>(Arrays.asList(new Double[]{ 13.0, 90.0, 43.0, 68.0, 17.0, 67.0, 76.0, 32.0, 74.0, 99.0, 86.0, 29.0, 2.0, 80.0, 84.0, 51.0, 81.0, 71.0, 48.0, 89.0, 78.0, 35.0, 3.0, 50.0, 65.0, 66.0, 49.0, 24.0, 37.0, 57.0, 93.0, 96.0, 34.0, 98.0, 10.0, 11.0, 59.0, 26.0, 95.0, 83.0, 30.0, 94.0, 100.0, 56.0, 61.0, 58.0, 16.0, 12.0, 40.0, 91.0, 79.0, 21.0, 18.0, 38.0, 64.0, 52.0, 55.0, 62.0, 27.0, 14.0, 85.0, 1.0, 63.0, 6.0, 54.0, 88.0, 72.0, 19.0, 69.0, 15.0, 82.0, 4.0, 31.0, 36.0, 28.0, 8.0, 41.0, 7.0, 39.0, 42.0, 46.0, 9.0, 22.0, 97.0, 45.0, 70.0, 75.0, 5.0, 92.0, 47.0, 23.0, 87.0, 77.0, 25.0, 33.0, 44.0, 53.0, 20.0, 73.0, 60.0}));
        int window = 5;

        //WHEN
        List<Double> result = RollingMeanCalculator.rollingMean(queue, window);

        //THEN
        List<Double> expected = Arrays.asList(new Double[]{46.2, 57.0, 54.2, 52.0, 53.2, 69.6, 73.4, 64.0, 58.0, 59.2, 56.2, 49.2, 59.6, 73.4, 67.0, 68.0, 73.4, 64.2, 50.6, 51.0, 46.2, 43.8, 46.6, 50.8, 48.2, 46.6, 52.0, 61.4, 63.4, 75.6, 66.2, 49.8, 42.4, 40.8, 40.2, 54.8, 58.6, 65.6, 80.4, 72.6, 68.2, 73.8, 58.2, 40.6, 37.4, 43.4, 47.6, 48.6, 49.8, 49.4, 44.0, 38.6, 45.4, 54.2, 52.0, 42.0, 48.6, 37.8, 38.0, 33.8, 41.8, 42.4, 56.6, 47.8, 60.4, 52.6, 51.4, 37.8, 40.2, 33.6, 36.2, 21.4, 28.8, 24.0, 24.6, 27.4, 35.0, 28.6, 31.6, 43.2, 43.8, 48.6, 61.8, 58.4, 57.4, 57.8, 48.4, 50.8, 65.2, 51.8, 49.0, 53.2, 46.4, 35.0, 44.6, 50.0});

        assertEquals(expected.size(), result.size());

        for (int i = 0; i < result.size(); i++) {
            assertEquals(expected.get(i), result.get(i), 0.0000001);
        }
    }
}
