package cn.hn.algoriththm;

import cn.hn.utils.Log;
import cn.hn.utils.TestUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by huangning on 2017/9/8.
 */
public class ToOfferTest {
    @Test
    public void demo() throws Exception {
        int i = 9;
        char a = (char)(i + '0');

        logger.info(a + "");
        logger.info('0' + 10 + "");
        logger.info(10 - '0' + "");
        logger.info('0' + "");

    }

    Logger logger = Logger.getLogger("hnlog");
    ToOffer to = new ToOffer();

    //******************* 以下是测试用例  ******************//


    @Test
    public void mergeList() throws Exception {
        int[] nums1 = {1,3,5,7,9};
        int[] nums2 = {2,3,4,6,8};
        ListNode head1 = ListNode.createList(nums1);
        ListNode head2 = ListNode.createList(nums2);
        ListNode.printList(to.mergeList(head1,head2));
        ListNode.printList(to.mergeList(null,null));
    }

    @Test
    public void reverseList() throws Exception {
        int[] nums = {1,2,3,4,5,6};
        ListNode head = ListNode.createList(nums);
        ListNode.printList(head);
        ListNode.printList(to.reverseList(head));
    }

    @Test
    public void entryNodeOfLoop() throws Exception {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        ListNode head = ListNode.createList(nums);
        ListNode entryNode = null;
        ListNode tailNode = head;
        int count = 1;
        while (tailNode.nextNode != null) {
            if(count == 4){
                entryNode = tailNode;
            }
            count ++;
            tailNode = tailNode.nextNode;
        }
        tailNode.nextNode = entryNode;

        ListNode entryNodeFound = to.entryNodeOfLoop(head);
        logger.info("hahh");

    }

    @Test
    public void findKthToTail() throws Exception {
        int[] nums = {8,7,6,5,4,3,2,1};
        int[] ks = {0,1,6,8,9};
        ListNode head = ListNode.createList(nums);
        for(int k:ks){
            ListNode kNode = to.findKthToTail(head,k);
            if(kNode != null){
                logger.info("the kth node to tail is " + kNode.val);
            }else{
                logger.info("is null");
            }
        }
    }

    @Test
    public void reorderOddEven() throws Exception {
        int[] nums = {1,3,4,6,8,5,3,4,2,9,8,0,12,3};
        int[] nums2 = {4,2,6,8,1,3,9,5};
        int[] nums3 = {3};
        logger.info(Arrays.toString(nums3));
        to.reorderOddEven(nums3);
        logger.info(Arrays.toString(nums3 ));
    }

    @Test
    public void isNumeric() throws Exception {

        String[] nums = {"12.e2",".201E12","-123.12e-12","123.123e10","12.12e12.22"};
        for(String s : nums){
            logger.info(s + " is a num : " + to.isNumeric(s));
        }
    }

    @Test
    public void match() throws Exception {
        String string1 = "huangning";//代表一个
        String string2 = "huangning";//代表0个
        String string3 = "huangggning";//代表若干个
        String pattern1 = "huang*ning";

        boolean bool ;
        System.out.println("ca");
        bool = to.match(string1,pattern1);
        bool = to.match(string2,pattern1);
        bool = to.match(string3,pattern1);


    }

    @Test
    public void deleteDuplicatedNode() throws Exception {
        int nums[] = {1,1,2,3,4,5,5};
        ListNode headNode = ListNode.createList(nums);
        ListNode.printList(headNode);
        System.out.println();

        ListNode.printList(to.deleteDuplicatedNode(headNode));

    }

    @Test
    public void deleteNode() throws Exception {
        ListNode node1 = new ListNode();
        ListNode node2 = new ListNode();
        ListNode node3 = new ListNode();
        ListNode node4 = new ListNode();
        ListNode node5 = new ListNode();
        node1.val = 1;
        node1.nextNode = node2;
        node2.val = 2;
        node2.nextNode = node3;
        node3.val = 3;
        node3.nextNode = node4;
        node4.val = 4;
        node4.nextNode = node5;
        node5.val = 5;
        node5.nextNode = null;

        ListNode node = node1;
        while(node != null ){
            System.out.println(node.val);
            node = node.nextNode;
        }

        System.out.println();
        to.deleteNode(node1,node5);

        node = node1;
        while(node != null ){
            System.out.println(node.val);
            node = node.nextNode;
        }


    }

    @Test
    public void print1ToMaxOfNDigits() throws Exception {
        to.print1ToMaxNDigitsRecu(3);
        logger.info("times is " + to.count);
    }

    @Test
    public void maxProductAfterCut() throws Exception {
        int res = to.maxProductAfterCut(16);
        logger.info("最大乘积是:" + res);
    }

    @Test
    public void numberOf1() throws Exception {
        //int n = 0x80000000;
        int n = -1;
        int count = to.numberOf1(n);
        logger.info("1的个数是" + count);
    }

    @Test
    public void rootMoving() throws Exception {
        boolean[][] matrix = new boolean[10][10];

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (matrix[i][j]) {
                    System.out.printf("o");
                }
                System.out.printf("x");
            }
            System.out.println();
        }

        System.out.println();

        int count = to.robotMoving(8, matrix);
        //logger.info("the number of points that robot can move around is " + count + "width is " + cols + "height is " + rows);
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (matrix[i][j]) {
                    System.out.printf("o");
                } else {
                    System.out.printf("x");
                }
            }
            System.out.println();
        }
    }

    @Test
    public void hasPath() throws Exception {
        char[][] matrix = {
                {'a', 's', 'd', 'f', 'g'},
                {'h', 'j', 'k', 'l', 'a'},
                {'q', 'w', 'e', 'r', 't'},
                {'y', 'u', 'i', 'o', 'p'}};
        String str = "iekdfg";
        System.out.println(to.hasPath(matrix, str));
    }


    @Test
    public void minNum() throws Exception {
        int[] nums = {15, 17, 21, 0, 1, 3, 5, 6, 8, 12};
        int[] nums1 = {0, 1, 2, 3};
        int[] nums2 = {2, 3, 1};
        System.out.println(to.minNumInReverseArray(nums));
        //System.out.println(to.minNumInReverseArray(nums1));
        System.out.println(to.minNumInReverseArray(nums2));
    }

    @Test
    public void fibonacci() throws Exception {
        int n = 45;
        long sum = 0;
        long t1 = System.currentTimeMillis();
        sum = to.fibonacci_iterative(n);
        long t2 = System.currentTimeMillis();
        System.out.println("sum is " + sum + "the time of iterative is " + (t2 - t1));

        sum = to.fibonacci_recursive(n);
        long t3 = System.currentTimeMillis();

        System.out.println("sum is " + sum + "the time of recursive is " + (t3 - t2));
    }

    @Test
    public void mergeNums() throws Exception {
        int[] a1 = {1, 3, 4, 5, 7, 8};
        int[] a2 = {1, 2, 2, 3, 5, 5, 9, 11};
        int ret[] = to.mergeNums(a1, a2);
        System.out.println(Arrays.toString(ret));
    }

    @Test
    public void replaceBlank() throws Exception {
        String string = "hello world.";
        String newstring = to.replaceBlank(string, "$$");
        Log.loggerInfo("new string is " + newstring);

    }

    @Test
    public void findNum() throws Exception {
        int nums[][] = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        int num[] = {7, 1, 15, 14};
        for (int i : num) {
            Log.loggerInfo("result is " + to.findNum(nums, i));
        }
    }

    @Test
    public void modifyString() {

    }


    @Test
    public void duplicateNUm3() throws Exception {
        int nums[] = {2, 3, 5, 4, 3, 2, 6, 7};
        String result = to.duplicateNUm3(nums).toString();
        Log.loggerInfo(result);
    }

    @Test
    public void firstNotRepeatingChar() throws Exception {
        String s = "zabnmjshadzb";
        Log.loggerInfo(to.firstNotRepeatingChar(s).toString());


    }

    @Test
    public void firstNoRepeatingChar2() throws Exception {
        String s = "a=hfalhf;afd220-";
        System.out.println(to.firstNotRepeatingChar(s));
    }

    @Test
    public void duplicateNUm2() throws Exception {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(to.duplicateNUm2(nums));

    }

    @Test
    public void duplicateNUm() throws Exception {
        int[] nums = {0, 3, 1, 2, 2, 5, 4};
        System.out.println(to.duplicateNUm(nums));
    }
}