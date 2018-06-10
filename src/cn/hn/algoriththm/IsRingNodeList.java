package cn.hn.algoriththm;

import cn.hn.others.Node;
import cn.hn.utils.ArrayUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by huangning on 2018/6/4.
 */
public class IsRingNodeList {
    public static Node normalWay(Node head) {
        Node currentNode = head;
        Set<Node> set = new HashSet<>();

        //如果set中已经包含了node,add方法返回false
        while (currentNode != null && set.add(currentNode)) {
            currentNode = currentNode.getNextNode();
        }
        //如果没有重复的节点,那么最后currentNode为null
        return currentNode;
    }

    public static Node betterWay(Node head) {
//        Node currentNode = head

        Node slowNode = head;
        Node fastNode = head;
        boolean isRing = false;

        //确定是不是环
        while (fastNode != null) {
            fastNode = fastNode.getNextNode();
            if (fastNode != null) {
                fastNode = fastNode.getNextNode();
            } else {
                return null;
            }
            slowNode = slowNode.getNextNode();

            if (slowNode == fastNode) {
                break;
            }

        }

        //确定环的入口
        fastNode = head;
        while (fastNode != slowNode) {
            fastNode = fastNode.getNextNode();
            slowNode = slowNode.getNextNode();
        }

        return fastNode;

    }

    public static void main(String[] args) {
        int[] arr = ArrayUtils.generateRandomArray(10,10);
        Node head = Node.createNodeList(arr);

        if (head != null) {
            Node.printNodeList(head);

            Node lastNode = head;
            while (lastNode.getNextNode() != null) {
                lastNode = lastNode.getNextNode();
            }

            int index = (int) (Math.random() * arr.length);
            Node targetNode = head;
            while (--index > 0) {
                targetNode = targetNode.getNextNode();
            }
            System.out.println(targetNode);

            lastNode.setNextNode(targetNode);

            IsRingNodeList instance = new IsRingNodeList();
            Node normalNode = instance.normalWay(head);
            Node betterNode = instance.betterWay(head);
            if (normalNode != betterNode) {
                System.out.println("normal node" + normalNode);
                System.out.println("better node" + betterNode);
                System.out.println("fuck!");
            } else {
                System.out.println(normalNode);
                System.out.println("nice!");
            }
        }

    }
}
