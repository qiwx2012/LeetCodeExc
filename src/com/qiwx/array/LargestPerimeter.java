package com.qiwx.array;

import java.util.Stack;

//三角形的最大周长
public class LargestPerimeter {
    public static void main(String[] args) {
        //System.out.println(largestPerimeter(new int[]{3,6,2,3}));
        System.out.println(largestPerimeter(new int[]{1, 2, 1}));
        //System.out.println(largestPerimeter(new int[]{3,2,3,4}));
    }

    public static int largestPerimeter(int[] A) {
        int len = A.length;
        Stack<Integer> stacks = new Stack<>();
        //先取出最大的三条边
        for (int i = 0; i < len; i++) {
            if (stacks.size() == 3) {
                int x = stacks.pop();
                int y = stacks.pop();
                int z = stacks.pop();
                if (x + y > z) {
                    return x + y + z;
                } else {
                    stacks.push(y);
                    stacks.push(x);
                }

            }
            for (int j = i; j < len; j++) {
                if (A[i] < A[j]) {
                    A[i] = A[i] ^ A[j];
                    A[j] = A[i] ^ A[j];
                    A[i] = A[i] ^ A[j];
                }
            }
            stacks.push(A[i]);
        }
        if (stacks.size() == 3) {
            int x = stacks.pop();
            int y = stacks.pop();
            int z = stacks.pop();
            if (x + y > z) {
                return x + y + z;
            } else {
                return 0;
            }
        }


        return 0;


    }
}
