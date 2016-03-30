package org.bds.algo.algo;

import junit.framework.TestCase;

import java.util.Arrays;

/**
 * Created by bdomokos on 05/03/16.
 */
public class MergeSortTest extends TestCase {

    public void testSort1() throws Exception {
        int[] input = {3,2};
        new MergeSort().sort(input);
        assertEquals("[2, 3]", Arrays.toString(input));
    }
    public void testSort2() throws Exception {
        int[] input = {3, 1, 2};
        new MergeSort().sort(input);
        assertEquals("[1, 2, 3]", Arrays.toString(input));
    }
}