package cn.hn.algoriththm;

import cn.hn.utils.SwapUtil;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by huangning on 2017/9/25.
 */
public class Sort {

    /*
     * title:堆排序
     * explanation:时间复杂度O(N*logN) 额外空间复杂度O(1)
     * tip:先将数组排成大根堆,然后交换首尾两个数字,然后从第一个数字到倒数第二个数字排成大根堆,再交换,直到排完序
     *      将一个数组编程大根堆的时间复杂度是log1 + log2 + log3 + ... + log(N-1) = O(N),
     *      然后调整一个大根堆的时间复杂度是O(logN)
     * example:
     * param:
     * return:
     */
    public static void heapSort(int[] arr) {
        if (arr == null) {
            throw new RuntimeException("illegal input");
        }
        int start = 0;
        int end = arr.length - 1;
        buildMaxHeap(arr);
        while (end > 0) {
            SwapUtil.swapInt(arr, start, end);
            //end位置现在是最大值,要从调整堆的范围中排除
            heapIfY(arr, start, --end);
//            heapIfIndex(arr, start, --end);
        }

    }

    //如果大根堆中start位置的数字变小了,重新调整成大根堆
    public static void heapIfY(int[] arr, int index, int size) {
        int left = index * 2 + 1;
        while (left <= size) {
            int largest = left + 1 <= size && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            SwapUtil.swapInt(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    //大根堆中从0位置开始,到end位置结束,index位置的数字变化了,重新调整大根堆
    private static void heapIfIndex(int[] arr, int index, int end) {
        int father = (index - 1) / 2;
        if (father >= 0 && arr[index] > arr[father]) {  //变大且大于父节点的情况
            while (father >= 0 && arr[index] > arr[father]) {
                SwapUtil.swapInt(arr, index, father);
                index = father;
                father = (index - 1) / 2;
            }
        } else {    //变小或者不变
            int sonLeft = index * 2 + 1;
            while (sonLeft <= end) {
                //比较左右儿子
                int maxIndex = sonLeft + 1 <= end && arr[sonLeft + 1] > arr[sonLeft] ? sonLeft + 1 : sonLeft;
                //比较儿子中大的和父亲
                maxIndex = arr[maxIndex] > arr[index] ? maxIndex : index;
                if (maxIndex == index) {
                    break;
                }
                SwapUtil.swapInt(arr, index, maxIndex);
                index = maxIndex;
                sonLeft = 2 * index + 1;

            }
        }
    }

    //当前节点i的父节点是(i-1)/2
    //tip 从下往上,从右往左,从最后一个非叶子节点开始向下比较,尝试和儿子节点交换
    //时间复杂度O(N)
    private static void buildMaxHeap(int[] arr) {
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            int j = i;
            int sonLeft = (j * 2) + 1;
            while (sonLeft < arr.length) {
                int maxIndex = sonLeft + 1 < arr.length && arr[sonLeft + 1] > arr[sonLeft] ? sonLeft + 1 : sonLeft;
                maxIndex = arr[maxIndex] > arr[j] ? maxIndex : j;
                if (maxIndex == j) {
                    break;
                }
                SwapUtil.swapInt(arr, j, maxIndex);
                j = maxIndex;
                sonLeft = j * 2 + 1;
            }
        }

    }

    //时间复杂度O(N*logN))
    public static void buildMaxHeap2(int[] arr) {
        //从上往下遍历每一个节点,并不断往上比较,尝试和父节点进行交换
        for (int i = 0; i < arr.length; i++) {
            maxHeapInsert(arr, i);
        }
    }

    //这种构建大根堆的方式实际上应用于堆的大小没有确定时,需要一边插入节点一边调整
    public static void maxHeapInsert(int[] arr, int j) {
        while (arr[j] > arr[(j - 1) / 2]) {
            SwapUtil.swapInt(arr, j, (j - 1) / 2);
            j = (j - 1) / 2;
        }
    }

    /*
     * title:归并排序
     * explanation:时间复杂度O(N*logN) 额外空间复杂度O(N)
     * tip:
     * example:
     * param:
     * return:
     */
    public static void mergeSort(int[] arr, int start, int end) {
        if (arr == null || start < 0 || end >= arr.length || start > end) {
            throw new RuntimeException("illegal input");
        }
        mergeProcessor(arr, start, end);

    }

    public static void mergeProcessor(int[] arr, int start, int end) {
        if (start == end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeProcessor(arr, start, mid);
        mergeProcessor(arr, mid + 1, end);
        merge(arr, start, mid, end);

    }

    public static void merge(int[] arr, int start, int mid, int end) {
        int[] helper = new int[end - start + 1];
        int count = 0;
        int left = start;
        int right = mid + 1;
        //要合并的两个数组依次从第一个数开始比较,小的放在helper先放进
        while (left <= mid && right <= end) {
            if (arr[left] <= arr[right]) {
                helper[count++] = arr[left++];
            } else {
                helper[count++] = arr[right++];
            }

        }
        //将剩下的数字放进helper数组
        if (left > mid) {
            while (right <= end) {
                helper[count++] = arr[right++];
            }
        } else {
            while (left <= mid) {
                helper[count++] = arr[left++];
            }
        }
        //将helper数组拷贝回arr数组
        for (int i = 0; i < helper.length; i++) {
            arr[start + i] = helper[i];
        }
    }


    /*
     * title:插入排序
     * explanation:时间复杂度最好O(N) 最差O(N^2) 额外空间复杂度O(1)
     * tip: 从第二个数字开始,循环到最后一个数字,每次循环将当前数字和前面的数字比较,符合条件就交换,直到不满足条件
     * example:
     * param:
     * return:
     */
    public static void insertionSort(int[] arr, int start, int end) {
        if (arr == null || start < 0 || end >= arr.length || start > end) {
            throw new RuntimeException("illegal input");
        }

        for (int i = start + 1; i <= end; i++) {
            for (int j = i; j > start; j--) {
                if (arr[j] < arr[j - 1]) {
                    SwapUtil.swapInt(arr, j, j - 1);
                } else {
                    break;
                }
            }

        }

    }

    /*
     * title:冒泡排序
     * explanation:遍历交换 时间复杂度O(N^2) 额外空间复杂度O(1)
     * tip:
     * example:
     * param:
     * return:
     */
    public static void bubbleSort(int[] arr, int start, int end) {
        if (arr == null || start < 0 || end >= arr.length || start > end) {
            throw new RuntimeException("illegal input");
        }

        while (start < end) {//当遍历范围大于0
            for (int j = start; j + 1 < end; j++) {
                if (arr[j] > arr[j + 1]) {
                    SwapUtil.swapInt(arr, j, j + 1);
                }
            }
            end--;//每次遍历完减少下次遍历的范围
        }
    }

    /*
     * title:选择排序
     * explanation:时间复杂度O(N^2) 额外空间复杂度O(1)
     * tip:遍历数组长度次数 每次遍历选择最大或者最小的数字放在遍历的开头
     * example:
     * param:
     * return:
     */
    public static void selectionSort(int[] arr, int start, int end) {
        if (arr == null || start < 0 || end >= arr.length || start > end) {
            throw new RuntimeException("illegal input");
        }
        while (start < end) {//当遍历范围大于0
            int indexOfMax = end;//记录这次遍历中最大值的下标
            for (int i = start; i <= end; i++) {
                indexOfMax = arr[indexOfMax] > arr[i] ? indexOfMax : i;
            }
            SwapUtil.swapInt(arr, end, indexOfMax);//将遍历得到的最大值交换到数组最后
            end--;//缩小范围
        }


    }

    /*
     * title:优化后的快排
     * explanation:优化partition函数,找出等于区域
     * tip:
     * example:
     * param:
     * return:
     */
    public static void quickSort2(int[] arr, int start, int end) {
        if (start < end && start >= 0 && end < arr.length) {
            SwapUtil.swapInt(arr, start + (int) (Math.random() * (end - start + 1)), end);//随机选择数组中的一个数放到数组最后作为基准
            int[] pivot = partition2(arr, start, end);//返回的处理后基准两侧的下标
            quickSort2(arr, start, pivot[0] - 1);
            quickSort2(arr, pivot[1] + 1, end);
        } else {
            throw new RuntimeException("illegal");
        }
    }

    public static int[] partition2(int[] arr, int start, int end) {
        //某一状态下,smaller指针代表小于基准的数字的范围,bigger代表大于基准的数字的范围
        int smaller = start - 1;//smaller代表小于的范围
        int bigger = end;//bigger代表大于的范围
        while (start < bigger) {
            if (arr[start] < arr[end]) {//当start指针发现小于基准的数字,交换到smaller指针处,向前移动smaller指针和start指针
                SwapUtil.swapInt(arr, ++smaller, start++);
            } else if (arr[start] > arr[end]) {//当start指针发现大于基准的数字,和bigger交换,往回移动bigger指针,因为不确定bigger指针指向的数字,所以start指针不移动,接着判断
                SwapUtil.swapInt(arr, --bigger, start);
            } else {//当start指针发现相等的数字,直接移动start指针
                start++;
            }
        }
        SwapUtil.swapInt(arr, bigger, end);//因为用最后一个数作比较,所以要和bigger中最小的数字交换
        return new int[]{smaller + 1, bigger};//返回的是最后基准的下标
    }


    /*
    快速排序
    平均时间复杂度:O(nlogn)
    最坏时间复杂度:O(n^2)
    空间复杂度:O(nlogn)
     */
    public static void quickSort(int[] nums, int start, int end) {
        if (nums == null || start < 0 || end >= nums.length || start > end) {
            throw new RuntimeException("illegal input");
        }

        if (start == end) return;

        int index = partition(nums, start, end);
        if (index > start) {
            quickSort(nums, start, index - 1);
        }
        if (index < end) {
            quickSort(nums, index + 1, end);
        }
    }

    /*
    在数组中选定一个数,将大于这个数的放右边,小的放左边
     */
    private static int partition(int[] nums, int start, int end) {
        if (nums == null || end >= nums.length || start < 0 || start > end) {
            throw new RuntimeException("illegal input ");
        }
        int smaller = start - 1;    //用于指向比基数小的数字
        int index = randomInRange(start, end);   //生成给定范围的随机数,确定基数
        SwapUtil.swapInt(nums, index, end);   //将选定的基数换到数组最后

        for (index = start; index < end; ++index) {
            if (nums[index] < nums[end]) {//当index发现小于基数的数字时
                //此时的++smaller要么是大于基数的数,要么就是index发现的数字
                ++smaller;
                //正常情况下smaller==index
                //不相等时smaller和index之间的数是大于基数的,所以就是把smaller后面index发现的小于基数的数字换上来
                if (smaller != index) {
                    SwapUtil.swapInt(nums, smaller, index);
                }
            }
        }

        ++smaller;
        SwapUtil.swapInt(nums, smaller, end);
        return smaller;
    }

    private static int randomInRange(int start, int end) {
        if (start > end) {
            int temp = start;
            start = end;
            end = temp;
        }
        Random random = new Random();
        return random.nextInt(end - start + 1) + start;
    }


    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 3, 9, 5, 8, 6, 7};
        Sort.quickSort2(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

}
