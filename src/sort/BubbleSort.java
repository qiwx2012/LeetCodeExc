package sort;

//冒泡排序
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{67, 22, 8, 89, 12, 6, 7, 7, 7, 9};
        bubbleSort(arr);
        for (int a : arr) {
            System.out.println(a);
        }
    }

    private static void bubbleSort(int[] arr) {
        boolean isSwap;//一次遍历后有没有交换行为，
        // 如果没有交换说明数组已经是有序的，不需要再继续遍历
        ///int count=0;
        for (int i = 0; i < arr.length; i++) {
            isSwap = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                //count++;
                if (arr[j] > arr[j + 1]) {
                    isSwap = true;
                    arr[j] = arr[j] ^ arr[j + 1];
                    arr[j + 1] = arr[j] ^ arr[j + 1];
                    arr[j] = arr[j] ^ arr[j + 1];
                }
            }
            if (!isSwap) {
                break;
            }
        }
        //System.out.println("执行了多少次"+count);
    }
}
