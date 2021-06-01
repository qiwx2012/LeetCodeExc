package sort;

import java.util.LinkedList;

/**
 * @description
 * @Author qiwx
 * @Date 2021-06-01 09:31
 * 栈排序
 * 给定一个乱序的栈，设计算法将其升序排列。
 * ps: 允许额外使用一个栈来辅助操作
 * 输入
 * [4, 2, 1, 3]
 * 输出
 * [1, 2, 3, 4]
 **/
public class StackSort {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.push(4);
        list.push(2);
        list.push(2);
        list.push(6);
        list.push(9);
        list.push(2);
        list.push(1);
        list.push(3);
        LinkedList<Integer> temp = new LinkedList<>();

        while (!list.isEmpty()) {
            int pop = list.pop();
            if (temp.isEmpty()) {
                temp.push(pop);
            } else {
                while (!temp.isEmpty()) {
                    int peek = temp.pop();
                    if (pop > peek) {
                        list.push(peek);
                    } else {
                        temp.push(peek);
                        temp.push(pop);
                        break;
                    }
                }
                if(temp.isEmpty()){
                    temp.push(pop);
                }

            }

        }


        while (!temp.isEmpty()) {
            System.out.println(temp.pop());
        }
    }
}
