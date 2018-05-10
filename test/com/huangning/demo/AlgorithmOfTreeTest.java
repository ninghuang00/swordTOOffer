package com.huangning.demo;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by huangning on 2017/9/20.
 */
public class AlgorithmOfTreeTest {
    private AlgorithmOfTree aot = new AlgorithmOfTree();

    @Test
    public void hasSubTree() throws Exception {
        //树1的前序遍历
        int[] preOrder = {8, 8, 9, 2, 4, 7, 7};
        //树1的中序遍历
        int[] inOrder = {9, 8, 4, 2, 7, 8, 7};
        //树1的根节点
        TreeNode root1 = BinaryTree.rebuildBinaryTree(preOrder, inOrder);
        //树2的根节点
        TreeNode root2 = new TreeNode(8);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(2);

        boolean result = aot.hasSubTree(root1, root2);
        System.out.println();

    }

    @Test
    public void printBinaryTree() throws Exception {
        Queue<Integer> list = new LinkedList<>();
        list.offer(2);
        list.offer(3);
        list.offer(5);
        int i = list.poll();
        list.add(10);
        int c = 0;
    }

    /*
                    1
                   /  \
                  2    3
                 /    / \
                4    5   6
                 \      /
                  7    8

     前序遍历: 1 2 4 7 3 5 6 8
     中序遍历: 4 7 2 1 5 3 8 6
     */
    @Test
    public void searchBinaryTree() throws Exception {
        int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inorder = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode root = BinaryTree.rebuildBinaryTree(preorder, inorder);
        //设置父节点
        System.out.println(aot.printBinaryTree(root));

        BinaryTree bt = new BinaryTree(root);

       // System.out.println(bt.preOrder());
        //System.out.println(bt.inOrder());
        System.out.println(bt.postOrder());

        //System.out.println(node.parent.val == root.right.val);
    }

    @Test
    public void rebuildBinaryTree() throws Exception {
        int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inorder = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode root = BinaryTree.rebuildBinaryTree(preorder, inorder);
        //树2的根节点
        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(8);

        boolean result = aot.hasSubTree(root,root2);


        //设置父节点
        setParents(root);
        TreeNode node = root.right.right;
        TreeNode nextNode = aot.getNext(node);

        System.out.println(nextNode);


        //System.out.println(node.parent.val == root.right.val);
    }

    /*
    传入根节点,设置所有节点的父节点
     */
    private void setParents(TreeNode root) {
        TreeNode curNode = root;
        if (curNode.left != null) {
            curNode.left.setParent(curNode);
            setParents(curNode.left);
        }
        if (curNode.right != null) {
            curNode.right.setParent(curNode);
            setParents(curNode.right);
        }
    }

    @Test
    public void dateCom() throws Exception {
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = simpleDateFormat.format(date);
        String dateString = "2017-9-1";
        String dateString2 = "2017-12-1";
        Date datepre = simpleDateFormat.parse(dateString);
        Date dateafter = simpleDateFormat.parse(dateString2);
        int result = date.compareTo(datepre);
        int result2 = date.compareTo(dateafter);
        System.out.println();

    }
}