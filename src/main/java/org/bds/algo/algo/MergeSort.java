package org.bds.algo.algo;

import java.util.*;

/**
 * Created by bdomokos on 05/03/16.
 */
public class MergeSort {
    public Object[] sort(int input[]) {
        List<Object> trace = new ArrayList<>();
        int n = input.length;
        int temp[] = new int[n];
        snapshot(input, temp, -1, -1, -1, "init", trace);
        sortRec(input, temp, 0, n, trace);
        return trace.toArray();
    }

    public void sortRec(int input[], int temp[], int i, int j, List<Object>trace) {
        if(j-i<2) return;
        snapshot(input, temp, i, -1, j, "sort", trace);
        int middle = (i+j)/2;
        sortRec(input, temp, i, middle, trace);
        sortRec(input, temp, middle, j, trace);
        merge(input, temp, i, middle, j, trace);
    }
    public void merge(int input[], int temp[], int i, int middle, int j, List<Object>trace) {
        int i0 = i, j0 = middle;
        snapshot(input, temp, i, middle, j, "merge", trace);
        for(int k = i; k<j; k++) {
            if(i0<middle && (j0>= j || input[i0]<=input[j0])) {
                temp[k] =input[i0];
                i0 +=1;
            } else {
                temp[k] =input[j0];
                j0+=1;
            }
            snapshot(input, temp, i, middle, j, "merge", trace);
        }
        System.arraycopy(temp, i, input, i, j-i);
        snapshot(input, temp, i, middle, j, "merge", trace);
    }

    private void snapshot(int input[], int temp[], int i, int middle, int j, String phase, List<Object> trace) {
        Map<String, Object> ret = new HashMap<>();
        int saved[];
        saved = new int[input.length];
        if(!phase.equals("sort")) {
            System.arraycopy(input, 0, saved, 0, input.length);
            ret.put("input", saved);
            saved = new int[input.length];
            System.arraycopy(temp, 0, saved, 0, input.length);
            ret.put("temp", saved);
        }
        ret.put("phase", phase);
        ret.put("i", i);
        if( phase.equals("merge")) {
            ret.put("middle", middle);
        }
        ret.put("j", j);
        trace.add(ret);
    }
}
