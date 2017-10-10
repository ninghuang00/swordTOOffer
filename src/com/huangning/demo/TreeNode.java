package com.huangning.demo;

/**
 * Created by huangning on 2017/9/16.
 * Definition for a binary tree node.
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode parent;
    TreeNode(int x){
        val = x;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }
}
