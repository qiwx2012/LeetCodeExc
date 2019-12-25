package com.qiwx.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//按递增顺序显示卡牌
public class DeckRevealedIncreasing {
    public static void main(String[] args) {
        deckRevealedIncreasing(new int[]{17, 13, 11, 2, 3, 5, 7});
    }

    public static int[] deckRevealedIncreasing(int[] deck) {
        //先排序
        Arrays.sort(deck);
        if (deck.length == 1)
            return new int[]{deck[0]};
        if (deck.length == 2)
            return new int[]{deck[0], deck[1]};
        LinkedList<Integer> list = new LinkedList<>();
        list.add(deck[deck.length - 2]);
        list.add(deck[deck.length - 1]);
        //采用倒序先将最大的两个排序，然后每加一个数之前，先将最后一个
        //数移首位，再加上新数
        for (int i = deck.length - 3; i >= 0; i--) {
            int end = list.pollLast();
            list.addFirst(end);
            list.addFirst(deck[i]);
        }
        int result[] = new int[deck.length];
        int index = 0;
        for (int i : list) {
            result[index++] = i;
        }
        return result;

    }
}
