package cn.hn.algoriththm;

/**
 * Created by huangning on 2018/4/7.
 */
/*
 * title:使用数组实现队列
 * explanation:
 * tip:
 * example:
 * param:
 * return:
 */
public class ArrayQueue {

    int[] nums ;
    int size;//判断队列是否满了
    int start;//指向取数字的位置
    int end;//指向添加数字的位置

    public ArrayQueue(int size) {
        this.nums = new int[size];
        this.start = 0;
        this.end = 0;
        this.size = 0;
    }

    public void push(int num) throws Exception {
        if (size == nums.length) {
            throw new Exception("队列满了");
        }
        nums[end] = num;
        size++;
        end = (end + 1 == nums.length) ? 0 : end + 1;

    }

    public int peek() throws Exception {
        if (size == 0) {
            throw new Exception("队列为空");
        }

        return nums[start];
    }

    public int poll() throws Exception {
        if (size == 0) {
            throw new Exception("队列为空");
        }
        int temp = start;
        start = (start + 1 == nums.length) ? 0 : start + 1;
        size--;
        return nums[temp];
    }

    public static void main(String[] args) throws Exception {
        ArrayQueue queue = new ArrayQueue(6);
        for (int i = 0; i < 5;i++) {
            queue.push(i);
        }
        queue.push(0);

        for (int i = 0; i < 6;i++) {
            System.out.println(queue.poll());
        }



    }
}
