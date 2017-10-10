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

}
