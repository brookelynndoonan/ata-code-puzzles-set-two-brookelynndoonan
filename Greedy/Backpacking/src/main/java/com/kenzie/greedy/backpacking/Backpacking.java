package com.kenzie.greedy.backpacking;

import javax.lang.model.element.Name;
import java.util.*;

/**
 * Contains a problem that can be solved using the Greedy Technique.
 */
public class Backpacking {

    /**
     * Given a list of snacks with their weight, and a given weight limit, return the maximum number
     * of snacks that you could pack without exceeding the weight limit. Assume you only have one of each snack.
     * <p>
     * Example: [(snackName, weight)]
     * snacks = [(peanuts, 8), (chips, 3), (protein bar, 9), (berries, 7), (banana, 4), (cookies, 10)]
     * weightLimit = 20
     * <p>
     * result = [(chips, 3), (banana, 4), (berries, 7)] -> 3 snacks
     *
     * @param snacks      - the list of snacks from which to identify the maximum snacks to pack
     * @param weightLimit - the maximum weight of snacks we can pack
     * @return the maximum number of snacks we can pack
     */
    public static int getMaximumSnacks(List<Snack> snacks, int weightLimit) {
        List<Snack> results = new ArrayList<>();
        int remainingWeight = weightLimit;

        snacks.sort(Comparator.comparingInt(Snack::getWeight));

        for (Snack snack : snacks) {
            if (snack.getWeight() <= remainingWeight) {
                results.add(snack);
                remainingWeight -= snack.getWeight();
            } else {
                break;
            }
        }
        return results.size();
    }
}
