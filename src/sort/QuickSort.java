package sort;
//快速排序
public class QuickSort {
    public static void quickSort(int[] arr,int low,int high){
        int i,j,temp;
        if(low>high)
            return;
        i=low;
        j=high;
        //设置基准位
        temp=arr[low];
        while (i<j){
            //先从右侧开始查找
            while (temp<=arr[j]&&i<j){
                j--;
            }
            //查找左侧
            while (temp>=arr[i]&&i<j){
                i++;
            }
            //如果满足交换条件
            if(i<j){
                arr[i]^=arr[j];
                arr[j]^=arr[i];
                arr[i]^=arr[j];
            }

        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        quickSort(arr,low,j-1);
        quickSort(arr,j+1,high);

    }

    public static void main(String[] args) {
        int[] nums=new int[]{7,12,4,88,23,11,78,53,12};
        quickSort(nums,0,nums.length-1);
        for (int a:nums
             ) {
            System.out.println("num:"+a);

        }
    }
}
