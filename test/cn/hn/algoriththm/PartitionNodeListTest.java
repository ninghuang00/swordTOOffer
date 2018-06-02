package cn.hn.algoriththm;

import cn.hn.others.Node;
import org.junit.Test;

/**
 * Created by huangning on 2018/6/2.
 */
public class PartitionNodeListTest {
    private PartitionNodeList partitionNodeList = new PartitionNodeList();
    private int[] arr = {9, 0, 4, 5, 1};
    private Node head = Node.createNodeList(arr);
    private int pivot = 0;

    @Test
    public void normalWay() throws Exception {
        System.out.println("normal way");

        Node.printNodeList(head);
        Node.printNodeList(partitionNodeList.normalWay(head, pivot));

    }

    @Test
    public void betterWay() throws Exception {
        System.out.println("better way");

        Node.printNodeList(head);
        Node.printNodeList(partitionNodeList.betterWay(head, pivot));
    }

}