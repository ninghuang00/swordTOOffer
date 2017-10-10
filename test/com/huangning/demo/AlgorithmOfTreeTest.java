package com.huangning.demo;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by huangning on 2017/9/20.
 */
public class AlgorithmOfTreeTest {
    private AlgorithmOfTree aot = new AlgorithmOfTree();

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
        TreeNode root = aot.rebuildBinaryTree(preorder, inorder);
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
        TreeNode root = aot.rebuildBinaryTree(preorder, inorder);
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

}