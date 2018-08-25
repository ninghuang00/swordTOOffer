package cn.hn.algoriththm;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by huangning on 2018/6/2.
 */
public class CopyRandomNodeList {
    public Node normalWay(Node head) {
        Map<Node, Node> nodeMap = new HashMap<>();
        Node currentNode = head;
        while (currentNode != null) {//当前节点作为key,当前节点的复制节点作为value
            //如果不做映射的话无法确定复制节点的指向
            nodeMap.put(currentNode, new Node(currentNode.getVal()));
            currentNode = currentNode.getNextNode();
        }
        currentNode = head;
        Node copyOfNextNode;//当前节点的下一个节点
        Node copyOfRandomNode;//当前节点的随机节点
        Node copyOfCurrentNode;//当前节点
        while (currentNode != null) {
            //根据源节点的指向,设置复制节点的指向
            copyOfNextNode = nodeMap.get(currentNode.getNextNode());
            copyOfRandomNode = nodeMap.get(currentNode.getRandomNode());
            copyOfCurrentNode = nodeMap.get(currentNode);
            copyOfCurrentNode.setNextNode(copyOfNextNode);
            copyOfCurrentNode.setRandomNode(copyOfRandomNode);
            currentNode = currentNode.getNextNode();
        }
        return nodeMap.get(head);
    }

    public Node betterWay(Node head) {

        Node currentNode = head;

        Node copyNode;
        Node tempNode;
        //将1 -> 2 -> 3 转换成 1 -> 1' -> 2 -> 2' -> 3 -> 3' -> null
        while (currentNode != null) {
            copyNode = new Node(currentNode.getVal());
            tempNode = currentNode.getNextNode();
            currentNode.setNextNode(copyNode);
            copyNode.setNextNode(tempNode);

            currentNode = currentNode.getNextNode();
        }
        //回到头结点
        currentNode = head;
        //复制节点的randomNode就是当前节点的randomNode的下一个节点(即它的复制节点)
        while (currentNode != null) {
            copyNode = currentNode.getNextNode();
            copyNode.setRandomNode(currentNode.getRandomNode().getNextNode());
            currentNode = copyNode.getNextNode();

        }

        Node ret = head.getNextNode();

        //分离复制链表和原链表
        currentNode = head;
        while (currentNode != null) {
            //当前节点的下一个节点
            copyNode = currentNode.getNextNode();
            //拷贝节点的下一个节点
            tempNode = copyNode.getNextNode();

            //当前节点指向拷贝节点的下一个节点
            currentNode.setNextNode(tempNode);
            //如果拷贝节点的下一个节点为空,说明到头了
            copyNode.setNextNode(tempNode == null ? null : tempNode.getNextNode());
            //当前节点移动到拷贝节点的下一个节点
            currentNode = tempNode;
        }

        return ret;
    }


    public static void main(String[] args) {
        CopyRandomNodeList instance = new CopyRandomNodeList();
        CopyRandomNodeList.Node node1 = instance.new Node(1);
        CopyRandomNodeList.Node node2 = instance.new Node(2);
        CopyRandomNodeList.Node node3 = instance.new Node(3);
        CopyRandomNodeList.Node node4 = instance.new Node(4);

        node1.setNextNode(node2);
        node1.setRandomNode(node3);

        node2.setNextNode(node3);
        node2.setRandomNode(null);

        node3.setNextNode(node4);
        node3.setRandomNode(node2);

        node4.setNextNode(null);
        node4.setRandomNode(node1);

        instance.printRandomNodeList(node1);

//        instance.printRandomNodeList(instance.normalWay(node1));

        instance.printRandomNodeList(instance.betterWay(node1));



    }

    public void printRandomNodeList(Node head) {
        Node node = head;
        System.out.print("node list :   ");
        while (node != null) {
            System.out.print(node.getVal() + ",");
            node = node.getNextNode();
        }

        System.out.println();

        node = head;
        System.out.print("random node : ");
        while (node != null) {
            if (node.getRandomNode() != null) {
                System.out.print(node.getRandomNode().getVal() + ",");
            } else {
                System.out.print("null,");
            }
            node = node.getNextNode();
        }

        System.out.println();
    }

    class Node {
        private int val;
        private Node nextNode;
        private Node randomNode;

        public Node() {

        }

        public Node(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }

        public Node getRandomNode() {
            return randomNode;
        }

        public void setRandomNode(Node randomNode) {
            this.randomNode = randomNode;
        }
    }
}
