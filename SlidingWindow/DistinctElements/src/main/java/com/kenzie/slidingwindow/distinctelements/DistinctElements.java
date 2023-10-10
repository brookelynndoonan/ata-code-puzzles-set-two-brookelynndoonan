package com.kenzie.slidingwindow.distinctelements;

import java.util.*;

/**
 * Contains a problem that can be solved using the Sliding Window Technique.
 */
public class DistinctElements {

    /**
     * Given a list of integers, find the number of distinct elements in every subset of size k.
     * <p>
     * Example:
     * input = [1, 3, 4, 2, 2, 5, 2]
     * k = 3
     * <p>
     * result = [3, 3, 2, 2, 2]
     *
     * @param input - the list of integers from which to identify the distinct counts, size >= k
     * @param k     - the size of sublists that should be considered when calculating the distinct counts, k >= 1
     * @return a list of distinct counts ordered by the sublist they relate to - the count of distinct
     * elements for the sublist with items 0, 1, 2 should be first in the list followed by the
     * count for items 1, 2, 3
     */
    // https://www.geeksforgeeks.org/count-distinct-elements-in-every-window-of-size-k/
    // Used this website and a combination of the reading examples as reference to utilize the
    // Hashmaps and better understand the .put or .getOrDefault when iterating through a list of windows.
    public static List<Integer> countDistinctElements(List<Integer> input, int k) {

        List<Integer> distinctCounts = new ArrayList<>();

        Map<Integer, Integer> count = new HashMap<>();

        for (int i = 0; i < k; i++) {
            count.put(input.get(i), count.getOrDefault(input.get(i), 0) + 1);
        }
        distinctCounts.add(count.size());

        for (int i = k; i < input.size(); i++) {
            int remove = input.get(i - k);
            int add = input.get(i);

            count.put(remove, count.get(remove) - 1);
            if (count.get(remove) == 0) {
                count.remove(remove);
            }
            count.put(add, count.getOrDefault(add, 0) + 1);

            distinctCounts.add(count.size());
        }

        return distinctCounts;
    }

}
