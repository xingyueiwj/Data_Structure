package test.sort;

import test.queue.LinQueue;

/**
 * Created by Administrator on 2017/3/12 0012.
 */
public class Sort {
    //直接插入排序(稳定的排序算法)
    public static void insertSort(int[]a){
         int i,j,temp;
        int n = a.length;
        for (i =0;i<n-1;i++){
            temp = a[i+1];
            j = i;
            while (j>-1&&temp<=a[j]){
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = temp;
        }
    }
    //希尔排序,缩小增量排序(不稳定的排序算法)
    public static void shellSort(int[]a,int[]d,int numOfD){
        int i,j,k,m,span;
        int temp;
        int n = a.length;
        for (m=0;m<numOfD;m++){
            span = d[m];
            for (k=0;k<span;k++){
                for (i=k;i<n-span;i=i+span){
                    temp = a[i+span];
                    j = i;
                    while (j>-1&&temp<=a[j]){
                        a[j+span] = a[j];
                        j = j-span;
                    }
                    a[j+span] = temp;
                }
            }
        }
    }
    //不稳定的直接选择排序算法
    public static void selectSort(int[]a){
        int i,j,small;
        int temp;
        int n = a.length;
        for (i=0;i<n-1;i++){
            small = i;
            for (j=i;j<n-1;j++){
                if (a[j]<a[small])small=j;
            }
            if (small!=i){
                temp = a[i];
                a[i] = a[small];
                a[small] = temp;
            }
        }
    }
    //稳定的直接选择排序算法
    public static void selectSort2(int[]a){
        int i,j,small;
        int temp;
        int n = a.length;
        for (i=0;i<n-1;i++){
            small = i;
            for (j=i+1;j<n;j++){//寻找最小的数据元素
                if (a[j]<a[small])small = j;//记住最小元素的下标
            }
            if (small!=i){
                temp = a[small];
                for (j=small;j>i;j--){//把该区段尚未排序元素依次后移
                    a[j] = a[j-1];
                }
                a[i] = temp;//插入找出的最小元素
            }
        }
    }
    //创建堆(不稳定的排序算法)
    public static void createHeap(int[]a,int n,int h){
        int i,j,flag;
        int temp;
        i = h;
        j = 2 * i + 1;
        temp = a[i];
        flag = 0;
        //沿着左右孩子中值较大者重复向下筛选
        while (j<n&&flag!=1){
            //寻找左右孩子结点中的较大者,j为其下标
            if (j<n-1&&a[j]<a[j+1])j++;
            if (temp>a[j])
                flag = 1;
            else {
                a[i] = a[j];
                i = j;
                j = 2 * i +1;
            }
        }
        a[i] = temp;
    }
    //初始化最大堆
    public static void initCreateHeap(int[]a){
        int n = a.length;
        for (int i = (n-1)/2;i>=0;i--)
            createHeap(a,n,i);
    }
    //堆排序算法
    public static void heapSort(int[]a){
        int temp;
        int n = a.length;
        initCreateHeap(a);
        for (int i = n-1;i>0;i++){//当前最大堆个数每次递减1
            temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            createHeap(a,i,0);
        }
    }
    //冒泡算法(稳定的排序算法)
    public static void bubbleSort(int[]a){
        int i,j,flag = 1;
        int temp;
        int n = a.length;
        for (i = 1;i<n&&flag==1;i++){
            flag = 0;
            for (j=0;j<n-1;j++){
                if (a[j]>a[j+1]){
                    flag = 1;
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }
    //快速排序(不稳定的排序算法)
    public static void quickSort(int[]a,int low,int high){
        int i,j;
        int temp;
        i = low;
        j = high;
        temp = a[low];
        while (i<j){
            //数组的右端扫描
            while (i<j&&temp<=a[j])j--;
            if (i<j){
                a[i] = a[j];
                i++;
            }
            //在数组的右端扫描
            while (i<j&&a[i]<temp)i++;
            if (i<j){
                a[j] = a[i];
                j--;
            }
        }
        a[i] = temp;
        if (low<i)quickSort(a,low,i-1);//对左端子集合递归
        if (i<high)quickSort(a,j+1,high);//对右端子集合递归
    }
    //一次二路归并排序算法如下(稳定的排序算法)
    public static void merge(int[]a,int[]swap,int k){
        int n = a.length;
        int m = 0,u1,l2,i,j,u2;
        int l1 = 0;
        while (l1+k<=n-1){
            l2 = l1 + k;
            u1 = l2 - 1;
            u2 = (l2 + k - 1 <= n-1)?l2+k-1:n-1;
            for (i=l1,j=l2;i<=u1&&j<=u2;m++){
                if (a[i]<=a[i]){
                    swap[m] = a[j];
                    i++;
                }else {
                    swap[m] = a[j];
                    j++;
                }
            }
            //子数组2已归并完,将子数组1中剩余的元素存放在数组swap中
            while (i<=u1){
                swap[m] = a[i];
                m++;
                i++;
            }
            //子数组1已归并完,将子数组2中剩余的元素存放到数组swap中
            while (j<=u2){
                swap[m] = a[j];
                m++;
                j++;
            }
            l1 = u2 + 1;
        }
        //将原始数组中只够一组的数据元素顺序存放到数组swap中
        for(i = 11;i<n;i++){
            swap[m] = a[i];
        }
    }
    //二路归并排序算法如下(稳定的排序算法)
    public static void mergeSort(int[]a){
        int i;
        int n = a.length;
        int k = 1;
        int[]swap = new int[n];
        while (k<n){
            merge(a,swap,k);
            for (i=0;i<n;i++){
                a[i] = swap[i];
            }
            k = 2 * k;
        }
    }
    //使用链式队列的基数排序算法(稳定的排序算法)
    public static void radixSort(int[]a,int m,int d)throws Exception{
        //a为要排序的数据元素,d为进制的基数,m为数据元素的最大位数
        int n = a.length;
        int i,j,k,l,power = 1;
        LinQueue[] myQueue = new LinQueue[d];
        //创建链式队列数组对象
        for (i = 0;i<d;i++){
            LinQueue temp = new LinQueue();
            myQueue[i] = temp;
        }
        //进行m次排序
        for (i=0;i<m;i++){
            if (i==0)power = 1;
            else power = power *d;
            //依次将n个数据元素按第k为的大小放到相应的队列中
            for (j=0;j<n;j++){
                k = a[j]/power-(a[j]/(power*d)*d);//计算k值
                myQueue[k].append(new Integer(a[j]));
            }
            //顺序回收各队列中数据元素到数组a中
            l=0;
            for (j = 0;j<d;j++){
                while (myQueue[j].notEmpty()){
                    a[l] = ((Integer)myQueue[j].delete()).intValue();
                }
            }
        }
    }
    public static void main(String[]args){
        int[]test = {64,5,7,89,6,24};
        int n = test.length;
        insertSort(test);
        for (int i = 0;i<n;i++){
            System.out.print(test[i]+" ");
        }
    }
}
