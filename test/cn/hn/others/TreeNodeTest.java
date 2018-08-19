package cn.hn.others;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by huangning on 2018/6/11.
 */
public class TreeNodeTest {
    TreeNode head;

    @Before
    public void createTree() {
        head = TreeNode.createBinaryTree();
    }


    @Test
    public void morrisPre(){
        TreeNode.printTree(head);
        TreeNode.morris(head);
    }

    @Test
    public void morrisPost(){
        TreeNode.printTree(head);
        TreeNode.morrisPos(head);
    }

    @Test
    public void isCBT() {
        TreeNode.printTree(head);

        System.out.println(TreeNode.isCBT(head));

    }

    @Test
    public void isBST() {
        System.out.println(TreeNode.isBST(TreeNode.createBinarySearchTree()));
        System.out.println(TreeNode.isBST(TreeNode.createBinaryTree()));
    }

    @Test
    public void preOrderRecu() {

        System.out.println("pre");
        List<Integer> list = TreeNode.preOrderRecu(head);
        System.out.println(list);
        System.out.println(TreeNode.preOrder(head));

    }

    @Test
    public void inOrderRecu() {
        System.out.println("in");

        System.out.println(TreeNode.inOrder(head));
        System.out.println(TreeNode.inOrderRecu(head));
    }

    @Test
    public void postOrderRecu() {
        System.out.println("post");
        System.out.println(TreeNode.postOrder(head));
        System.out.println(TreeNode.postOrderRecu(head));
    }

    @Test
    public void serialization() {
        TreeNode.printTree(head);
        System.out.println(TreeNode.serializationPreOrder(head));


    }

    @Test
    public void deserialization() {
        String string = "5_3_#_10_#_#_4_6_#_#_8_#_#_";
//        char[] chars = string.toCharArray();
//        for (char c : chars) {
//            System.out.println((c-'0')==5);
//        }
        TreeNode.printTree(TreeNode.deserializationPreOrder(string));


    }

    @Test
    public void isContainTree() {
        TreeNode root = new TreeNode(4);
//        root.left = new TreeNode(6);
        root.right = new TreeNode(8);
        TreeNode.printTree(root);
        TreeNode.printTree(head);

        System.out.println("is tree head contains tree root?" + TreeNode.isContainTree(head, root));
//        System.out.println("is tree head contains tree root?" + TreeNode.isContainTree(root,head));


    }



    public void printTree() throws Exception {

        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(-222222222);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(Integer.MIN_VALUE);
        head.right.left = new TreeNode(55555555);
        head.right.right = new TreeNode(66);
        head.left.left.right = new TreeNode(777);
        TreeNode.printTree(head);

        head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.right.left = new TreeNode(5);
        head.left.right = new TreeNode(9);
        head.right.right = new TreeNode(6);
        head.left.left.right = new TreeNode(7);
        TreeNode.printTree(head);
    }

}