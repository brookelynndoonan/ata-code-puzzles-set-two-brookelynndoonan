package com.kenzie.twopointer.threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Contains a problem that can be solved using the Two-Pointer Technique.
 */
public class ThreeSumUnique {
    /**
     * Given an unsorted integer array nums, where each element is unique, return all the triplets
     * [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
     * <p>
     * Example:
     * nums = [-1,0,1,3,2,-4]
     * result = [[-4,1,3],[-1,0,1]]
     *
     * @param numbers an unsorted integer array where each element is unique.
     * @return all triplets that sum to 0
     */
    public static List<List<Integer>> threeSum(int[] numbers) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(numbers);

        for (int i = 0; i < numbers.length - 2; i++) {

            if (i == 0 || (i > 0 && numbers[i] != numbers[i - 1])) {
                int wantedTotal = -numbers[i];
                int left = i + 1;
                int right = numbers.length - 1;

                while (left < right) {
                    int currentTotal = numbers[left] + numbers[right];

                    if (currentTotal == wantedTotal) {
                        result.add(Arrays.asList(numbers[i], numbers[left], numbers[right]));

                        while (left < right && numbers[left] == numbers[left + 1]) left++;
                        while (left < right && numbers[right] == numbers[right - 1]) right--;

                        left++;
                        right--;
                    } else if (currentTotal < wantedTotal) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return result;
    }
}
