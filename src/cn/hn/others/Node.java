package cn.hn.others;

/**
 * Created by huangning on 2018/5/30.
 */
public class Node {
    private int val;
    private Node nextNode;

    public Node() {

    }

    //
    public Node(Node node) {
        this.val = node.getVal();
        this.nextNode = new Node(null, node.getNextNode().getVal());
    }

    public Node(Node nextNode, int val) {
        this.nextNode = nextNode;
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

    public static Node createNodeList(int[] arr) {
        Node head = new Node();
        Node currentNode = head;
        int i = 0;
        for (; i < arr.length - 1; i++) {
            currentNode.setNextNode(new Node());
            currentNode.setVal(arr[i]);
            currentNode = currentNode.getNextNode();
        }
        currentNode.setVal(arr[i]);
        currentNode.setNextNode(null);

        return head;
    }

    public static Node reverseNodeList(Node head) {
        if (head.getNextNode() == null) {
            return head;
        }
        Node currentNode = head;
        Node nextNode = head.getNextNode();
        Node nnextNode = nextNode.getNextNode();
        head.setNextNode(null);

        while (nnextNode != null) {
            nextNode.setNextNode(currentNode);
            currentNode = nextNode;
            nextNode = nnextNode;
            nnextNode = nnextNode.getNextNode();
        }
        nextNode.setNextNode(currentNode);

        return nextNode;
    }

    public static void printNodeList(Node head) {
        while (head != null) {
            System.out.print(head.getVal() + ", ");
            head = head.getNextNode();
        }
        System.out.println();
    }
}
