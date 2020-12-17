package com.qiwx.array;

import java.util.LinkedList;
import java.util.Stack;

//接雨水
public class Trap {
    public static void main(String[] args) {

    }
    public int trap(int[] height) {
        int sum=0;//总共可以盛多少水
        int size=height.length;
        for (int i = 1; i <size-1 ; i++) {

            int max_left=0,max_right=0;
            for(int j=i;j>=0;j--){
                max_left=Math.max(max_left,height[j]);
            }
            for(int j=i;j<size;j++){
                max_right=Math.max(max_right,height[j]);
            }
            sum+=Math.min(max_left,max_right)-height[i];
        }
       return sum;
    }
    public int trap1(int[] height){
        int ans=0,current=0;
        Stack<Integer> stack=new Stack<>();
        while (current<height.length){
            while (!stack.isEmpty()&&height[current]>height[stack.peek()]){
                int top=stack.peek();
              stack.pop();
              if(stack.isEmpty())
                  break;
              int distance=current-stack.peek()-1;
              int bounded_height=Math.min(height[current],height[stack.peek()])-height[top];
              ans+=distance*bounded_height;
            }
            stack.push(current++);
        }
        return ans;
    }
}
