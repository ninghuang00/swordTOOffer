package cn.hn.algoriththm;

import cn.hn.others.Node;

import java.util.Stack;

/**
 * Created by huangning on 2018/5/30.
 */
public class IsPalindrome {

    public boolean normalWay(Node head) {
        if (head.getNextNode() == null) {
            return true;
        }
        if (head == null) {
            return false;
        }

        Stack<Integer> stack = new Stack<>();
        Node currentNode = head;

        while (currentNode != null) {
            stack.push(currentNode.getVal());
            currentNode = currentNode.getNextNode();
        }
        currentNode = head;
        while (currentNode != null) {
            if (stack.pop() != currentNode.getVal()) {
                return false;
            }
            currentNode = currentNode.getNextNode();
        }
        return true;
    }

    public boolean betterWay(Node head) {
        if (head == null) {
            return false;
        }
        if (head.getNextNode() == null) {
            return true;
        }

        Node fastNode = head;
        Node slowNode = head;
        //while结束之后slow节点指向中间,fast节点指向末尾
        while (fastNode.getNextNode() != null) {
            fastNode = fastNode.getNextNode();
            if (fastNode.getNextNode() != null) {
                fastNode = fastNode.getNextNode();
            } else {
                break;
            }
            slowNode = slowNode.getNextNode();
        }


        Node nextOfSlowNode = slowNode.getNextNode();

        //断开左右链表
        slowNode.setNextNode(null);
        Node rightNode = Node.reverseNodeList(nextOfSlowNode);

        Node leftNode = head;
        //这里一定要用右边的链表作判断,因为右边的链表可能会比左边少一个,奇数个节点的时候
        while (rightNode != null) {
            if (rightNode.getVal() != leftNode.getVal()) {
                slowNode.setNextNode(Node.reverseNodeList(fastNode));
                return false;
            }
            leftNode = leftNode.getNextNode();
            rightNode = rightNode.getNextNode();
        }


        slowNode.setNextNode(Node.reverseNodeList(fastNode));

        return true;

    }

}
