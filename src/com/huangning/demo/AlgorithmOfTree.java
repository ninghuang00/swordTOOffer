package com.huangning.demo;

import java.util.*;

/**
 * Created by huangning on 2017/9/16.
 * 关于树的算法
 * Definition for a binary tree node.
 * <p>
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x){
 * val = x;
 * }
 * }
 */


public class AlgorithmOfTree {


    /*
     * title:树的子结构
     * explanation:判断树1是否包含树2
     * tip:
     * example:
     * param:
     * return:
     */
    public boolean hasSubTree(TreeNode root1, TreeNode root2) {
        boolean result = false;

        if (root1 != null && root2 != null) {
            if (isNodeEqual(root1, root2)) {    //判断当前节点是否相等,相等则可以进行下一步树结构判断
                result = doesTree1ContainsTree2(root1, root2);
            }

            //如果当前节点不相等,继续遍历树,寻找相等的根节点
            if (!result) {
                result = hasSubTree(root1.left, root2);
            }
            if (!result) {
                result = hasSubTree(root1.right, root2);
            }
        }
        return result;
    }

    public boolean doesTree1ContainsTree2(TreeNode node1, TreeNode node2) {
        //树2的节点为空,说明之前的节点都匹配
        if (node2 == null) {
            return true;
        }
        //树1的节点为空,而树2的节点不空,说明不匹配
        if (node1 == null) {
            return false;
        }

        if (!isNodeEqual(node1, node2)) {
            return false;
        }
        //当前节点匹配则进入子节点进行判断
        return doesTree1ContainsTree2(node1.left, node2.left) && doesTree1ContainsTree2(node1.right, node2.right);
    }

    public boolean isNodeEqual(TreeNode node1, TreeNode node2) {

        if (node1 != null && node2 != null && node1.val == node2.val) {
            return true;
        }

        return false;
    }

    /*
     * title:二叉树的下一个节点
     * explanation:寻找二叉树中序遍历中给定节点的下一个节点
     * example:
     * param:二叉树中的任意节点
     * return:给定节点的下一个节点
     */
    public TreeNode getNext(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode nextNode = null;   //最后返回的节点
        //首先判断该节点有没有y右子树
        if (node.right != null) {
            TreeNode rightNode = node.right;
            //寻找右子树最左边的叶节点
            while (rightNode.left != null) {
                rightNode = rightNode.left;
            }
            nextNode = rightNode;
        } else if (node.parent != null) {
            //首先看看当前接待是不是父节点的左子节点
            //一直往上寻找当前节点是父节点左子节点的节点
            TreeNode curNode = node;
            TreeNode parentNode = node.parent;
            //当父节点不为空,且当前节点是父节点的右子节点时,循环
            while (parentNode != null && curNode == parentNode.right) {
                curNode = parentNode;
                parentNode = parentNode.parent;
            }
            nextNode = parentNode;

        }
        return nextNode;
    }

    /*
    从上到下从左到右打印二叉树
     */
    public List printBinaryTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        List list = new ArrayList();    //存放节点value的序列
        Queue<TreeNode> queue = new LinkedList<>(); //按照打印顺序存放节点的队列
        queue.offer(root);  //先将第一个根节点放入
        TreeNode curNode = null;    //记录当前节点
        while ((curNode = queue.poll()) != null) {
            list.add(curNode.val);  //存入当前节点的value
            //判断当前节点的左右子节点是否为空,不空则按顺序存入队列
            if (curNode.left != null) {
                queue.offer(curNode.left);
            }
            if (curNode.right != null) {
                queue.offer(curNode.right);
            }
        }
        return list;
    }


    /*
     * title:根据前序遍历和中序遍历的结果重建二叉树
     * explanation:
     * tip:
     * example:
     * param:
     * return:
     */
    /*public TreeNode rebuildBinaryTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || (preorder.length != inorder.length)){
            return null;
        }
        int prestart = 0; //起始坐标
        int preend = preorder.length - 1;   //重点坐标
        int instart = 0;
        int inend = inorder.length - 1;
        return rebuildHelper(preorder,prestart,preend,inorder,instart,inend);

    }

    private TreeNode rebuildHelper(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend) {
        int rootValue = preorder[prestart];
        TreeNode root = new TreeNode(rootValue);
        root.left = null;
        root.right = null;

        //子树中的最后一个,即叶节点
        if(prestart == preend){
            if(instart == inend && preorder[prestart] == inorder[instart]){
                return root;
            }else{
                //Log.loggerInfo("invalid input");
                throw new RuntimeException("invalid input ");
            }
        }

        //在中序子序列中遍历查找根节点,注意要子序列
        int rootInorder = instart;
        while(rootInorder <= inend && inorder[rootInorder] != rootValue){
            ++rootInorder;
        }
        //没找到
        if(rootInorder > inend){
            throw new RuntimeException("invalid input");
        }
        //根据中序遍历中的根节点坐标重构左右子树
        int leftLength = rootInorder - instart;//左子树的长度

        *//*Log.loggerInfo("root value is " + rootValue + "\n" +
                "prestart is  " + prestart + "\n" +
                "leftLength is " + leftLength + "\n" +
                "rootInorder is " + rootInorder + "\n" +
                "preend is " + preend
        );*//*


        //左子树长度大于0
        if(leftLength > 0){
            root.left = rebuildHelper(preorder, prestart + 1, prestart + leftLength,
                                            inorder, instart, rootInorder - 1);
        }
        //右子树长度大于0
        if(preend - prestart > leftLength){
            root.right = rebuildHelper(preorder, prestart + leftLength + 1, preend,
                    inorder, rootInorder + 1, inend);
        }

        return root;
    }*/

}
