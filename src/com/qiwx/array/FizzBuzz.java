package com.qiwx.array;

import java.util.LinkedList;
import java.util.List;

//Fizz Buzz
public class FizzBuzz {
    public static void main(String[] args) {

    }

    public static List<String> fizzBuzz(int n) {
        List<String> result = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 != 0) {
                result.add("Fizz");
            } else if (i % 3 != 0 && i % 5 == 0) {
                result.add("Buzz");
            } else if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            } else {
                result.add(String.valueOf(i));
            }
        }
        return result;
    }
}
