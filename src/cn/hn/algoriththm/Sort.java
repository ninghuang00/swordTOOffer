package cn.hn.algoriththm;

import java.util.Random;

/**
 * Created by huangning on 2017/9/25.
 */
public class Sort {
    /*
    快速排序
    平均时间复杂度:O(nlogn)
    最坏时间复杂度:O(n^2)
    空间复杂度:O(nlogn)
     */
    public void quickSort(int[] nums,int start, int end){
        if(nums == null || start < 0 || end >= nums.length){
            throw new RuntimeException("illegal input");
        }

        if(start == end) return ;

        int index = partition(nums,start,end);
        if(index > start ){
            quickSort(nums,start,index - 1);
        }
        if(index < end){
            quickSort(nums,index + 1,end);
        }
    }
    /*
    在数组中选定一个数,将大于这个数的放右边,小的放左边
     */
    public int partition(int[] nums,int start,int end){
        if(nums == null || end >= nums.length || start < 0){
            throw new RuntimeException("illegal input ");
        }
        int smaller = start - 1;    //用于指向比基数小的数字
        int index = randomInRange(start,end);   //生成给定范围的随机数,确定基数
        swap(nums,index,end);   //将选定的基数换到数组最后

        for(index = start;index < end; ++index){
            if(nums[index] < nums[end]){
                //元素小于基数时,两指针正常向前移动,当发现大于基数的元素时,index前移,smaller不动,此时smaller的下一个元素大于基数,
                ++ smaller;
                //当index指针发现下一个小于基数的元素时,此时index和smaller必定不相等,与smaller的下一个元素交换
                if(smaller != index){
                    swap(nums,smaller,index);
                }
            }
        }

        ++ smaller;
        swap(nums,smaller,end);
        return smaller;
    }
    public int randomInRange(int start,int end){
        if(start > end){
            int temp = start;
            start = end;
            end = temp;
        }
        Random random = new Random();
        return random.nextInt(end - start + 1) + start;
    }

    public void swap(int[] nums, int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

}
