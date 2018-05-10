package com.huangning.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangning on 2017/9/22.
 */
public class BinaryTree {
    private TreeNode root;  //存放树的根节点

    public BinaryTree(TreeNode root){
        this.root = root;
        if(this.root != null){
            setParents(this.root);
        }
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
        if(this.root != null){
            setParents(this.root);
        }
    }

    /*
    传入根节点,设置所有节点的父节点
     */
    public void setParents(TreeNode root) {
        TreeNode curNode = root;
        if(curNode.left != null){
            curNode.left.setParent(curNode);
            setParents(curNode.left);
        }
        if(curNode.right != null){
            curNode.right.setParent(curNode);
            setParents(curNode.right);
        }
    }

    /*
    前序遍历,返回遍历结果的list
     */
    public List preOrder(){
        List list = new ArrayList();    //存最后输出的遍历序列
        preHelper(root, list);
        return list;
    }

    public void preHelper(TreeNode node, List list){
        if(node != null){
            list.add(node.val);
            preHelper(node.left,list);
            preHelper(node.right,list);
        }
    }

    /*
    中序遍历
     */
    public List inOrder(){
        List list = new ArrayList();    //存最后输出的遍历序列
        inHelper(root, list);
        return list;
    }

    private void inHelper(TreeNode node, List list) {
        if(node != null){
            inHelper(node.left,list);
            list.add(node.val);
            inHelper(node.right,list);

        }
    }




    /*
    后序遍历
     */
    public List postOrder(){
        List list = new ArrayList();    //存最后输出的遍历序列
        postHelper(root, list);
        return list;
    }

    private void postHelper(TreeNode node, List list) {
        if(node != null){
            postHelper(node.left,list);
            postHelper(node.right,list);
            list.add(node.val);

        }
    }

    /*
    根据前序遍历和中序遍历的结果重建二叉树
     */
    public static TreeNode rebuildBinaryTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || (preorder.length != inorder.length)){
            return null;
        }
        int prestart = 0; //起始坐标
        int preend = preorder.length - 1;   //重点坐标
        int instart = 0;
        int inend = inorder.length - 1;
        return rebuildHelper(preorder,prestart,preend,inorder,instart,inend);

    }

    private static TreeNode rebuildHelper(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend) {
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

        /*Log.loggerInfo("root value is " + rootValue + "\n" +
                "prestart is  " + prestart + "\n" +
                "leftLength is " + leftLength + "\n" +
                "rootInorder is " + rootInorder + "\n" +
                "preend is " + preend
        );*/


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
    }

}
