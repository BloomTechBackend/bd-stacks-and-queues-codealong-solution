# Rolling Mean Calculator

## Introduction

A rolling mean is used in data analysis to provide a way to understand trends in data over time. A rolling mean does not average the entire set of data at once, instead it averages 'windows' of data, which are consecutive blocks of values. These windows can be set to a specified length and then each consecutive group of that length will be averaged. This helps smooth out data which would otherwise have strong changes in a single time period.

Example: A single stock can have wild swings from day to day. If graphed, this would have jagged up/downs which are harder to identify the overall trend. Rolling means can be used to look at averages over 10 days time, which will better give a representation of the trend of the stock without each individual day's change being seen so strongly.


### Implementing the RollingMeanCalculator
You will be implementing the `rollingMean` method in the [RollingMeanCalculator](./RollingMeanCalculator.java) class.

The method is provided with an open Scanner with numeric (double) values it will be scanning. You are also provided a window size to calculate the rolling means.

The method should return a List of doubles, with the first value of the list being the first rolling mean, the second being the second, etc.

Check the JavaDoc for the `rollingMean` method for examples of rolling mean calculations.



### Automatic Unit Testing your Validator

Unit tests have been provided in the `RollingMeanCalculatorTest` class.



