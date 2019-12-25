package sort;

//插入排序
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{67, 22, 8, 89, 12, 6, 7, 7, 7, 9};
        insertionSort(arr);
        for (int a : arr) {
            System.out.println(a);
        }
    }

    private static void insertionSort(int[] arr) {
        int current;
        for (int i = 0; i < arr.length - 1; i++) {
            current = arr[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current < arr[preIndex]) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
        }
    }
}
