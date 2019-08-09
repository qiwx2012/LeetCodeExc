package sort;
//选择排序
public class SelectionSort {
    public static void main(String[] args) {
        int[]arr=new int[]{67,22,8,89,12,6,7,7,7,9};
        selectionSort(arr);
        for(int a:arr){
            System.out.println(a);
        }
    }
    private static void selectionSort(int[] arr){

        for(int i=0;i<arr.length;i++){
            int minIndex=i;
            for(int j=i;j<arr.length;j++){
                if(arr[minIndex]>arr[j]){
                    minIndex=j;
                }
            }
            if(arr[i]>arr[minIndex]){
                arr[i]=arr[minIndex]^arr[i];
                arr[minIndex]=arr[minIndex]^arr[i];
                arr[i]=arr[minIndex]^arr[i];
            }


        }


    }
}
