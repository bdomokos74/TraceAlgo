package org.bds.algo.controller;

import org.bds.algo.algo.MergeSort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by bdomokos on 05/03/16.
 */
@RestController
public class MergeSortController {

    @RequestMapping("/mergesort")
    public Object[] trace(@RequestParam(value="input") String input) {
        int in[] = Arrays.asList(input.split(",")).stream().mapToInt((s) -> Integer.valueOf(s)).toArray();
        Object ret[] = new MergeSort().sort(in);
        return ret;
    }
}
