package com.qiwx.array;
//甲板上的战舰
public class CountBattleships {
    public static void main(String[] args) {

    }
    public static int countBattleships(char[][] board) {
        //对甲板进行一次遍历，当前位置为'X'时，检测该位置的上方和左方是否为'X'。若是，
        // 则该位置并非为一个新战舰的头部，不予处理，否则，战舰数量加1
        int result=0;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                 if(board[i][j]=='X'){
                     if((i==0||board[i-1][j]=='.')&&(j==0||board[i][j-1]=='.')){
                         result++;
                     }
                 }
            }
        }
        return result;

    }
}
