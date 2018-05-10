package cn.hn.utils;

import cn.hn.algoriththm.ListNode;

/**
 * Created by huangning on 2017/10/10.
 */
public class TestUtils {
    /*// 根据传入的数组生成单向链表
    public static ListNode createList(int[] nums){
        *//*ListNode headNode = new ListNode();
        headNode.val = nums[0];
        headNode.nextNode = null;
        ListNode curNode = headNode;
        for(int i = 1; i < nums.length;++ i){
            ListNode nextNode = new ListNode();
            nextNode.val = nums[i];
            nextNode.nextNode = null;
            curNode.nextNode = nextNode;
            curNode = nextNode;

        }

        return headNode;*//*
        return createListHelper(nums,0);
    }
    private static ListNode createListHelper(int[] nums,int index){
        if(index == nums.length){
            return null;
        }
        ListNode curNode = new ListNode();
        curNode.val = nums[index];
        curNode.nextNode = createListHelper(nums,index + 1);
        return curNode;
    }
    //打印链表
    public static void printList(ListNode headNode){
        ListNode node = headNode;
        while(node != null ){
            System.out.println(node.val);
            node = node.nextNode;
        }
    }*/
}
