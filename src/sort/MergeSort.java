package sort;

//归并排序
public class MergeSort {
    public static void main(String[] args) {
        int[] a = { 49, 38, 65, 97, 76, 13, 27, 50 };
        mergeSort(a, 0, a.length-1);
        System.out.println("排好序的数组：");
        for (int e : a)
            System.out.print(e+" ");
    }

    //将两个拍好序的子序列合并为一个子序列
    public static void merge(int[] a, int left, int mid, int right) {
        int p1 = left;
        int p2 = right;
        int k = left;
        int[] temp = new int[a.length];//辅助存储
        while (p1 <= mid && p2 <= right) {
            if (a[p1] < a[p2]) {//相当于两个数组比较，谁小先取谁
                temp[k++] = a[p1++];
            } else {
                temp[k++] = a[p2++];
            }
        }
        //遍历完之后查看哪边数组没有遍历完继续遍历，最多有一边没遍历完
        while (p1 <= mid) {
            temp[k++] = a[p1++];
        }
        while (p2 <= right) {
            temp[k++] = a[p2++];
        }
        //复制回原素组
        for (int i = left; i <=right; i++){
            a[i]=temp[i];
            System.out.println("temp的item"+temp[i]);
        }

    }
    public static void mergeSort(int [] a,int start,int end){
        if(start<end){//当子序列中只有一个元素时结束递归
            int mid=(start+end)/2;//划分子序列
            mergeSort(a, start, mid);//对左侧子序列进行递归排序
            mergeSort(a, mid+1, end);//对右侧子序列进行递归排序
            merge(a, start, mid, end);//合并
        }
    }

}
