package cn.hn.algoriththm;

import cn.hn.others.Node;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by huangning on 2018/5/30.
 */
public class IsPalindromeTest {

    private IsPalindrome isPalindrome = new IsPalindrome();

    @Test
    public void normalWay() throws Exception {
        int[] arr = {1, 2, 3, 2, 1, 2};
        Node head = Node.createNodeList(arr);
        System.out.println(isPalindrome.normalWay(head));

    }

    @Test
    public void betterWay() throws Exception {

        int[] arr = {1};
//        int[] arr = {1, 2, 3, 3, 4, 2, 1};

        Node head = Node.createNodeList(arr);
        Node.printNodeList(head);

        System.out.println(isPalindrome.betterWay(head));


//        head = Node.reverseNodeList(head);
        Node.printNodeList(head);

    }

}