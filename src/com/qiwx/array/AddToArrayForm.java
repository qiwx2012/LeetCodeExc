package com.qiwx.array;

import java.util.LinkedList;
import java.util.List;

public class AddToArrayForm {
    public static void main(String[] args) {

    }

    public List<Integer> addToArrayForm(int[] A, int K) {
        LinkedList<Integer> nums = new LinkedList<>();
        LinkedList<Integer> result = new LinkedList<>();
        for (int i = 0; i < A.length; i++) {
            nums.addLast(A[i]);
        }
        int carry = 0;
        while (K > 0 || !nums.isEmpty()) {
            int addNum = 0;
            if (K > 0) {
                addNum = K % 10;
                K = K / 10;
            }
            addNum += carry;
            if (!nums.isEmpty()) {
                addNum += nums.pollLast();
            }
            if (addNum > 9) {
                addNum = addNum % 10;
                carry = 1;
            } else {
                carry = 0;
            }
            result.addFirst(addNum);
        }
        if (carry > 0) {
            result.addFirst(carry);
        }
        return result;
    }

}
