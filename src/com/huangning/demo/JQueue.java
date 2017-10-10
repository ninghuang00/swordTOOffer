package com.huangning.demo;

import java.util.Stack;

/**
 * Created by huangning on 2017/9/23.
 */
/*
 * title:用两个栈实现队列
 */
public class JQueue {
    private Stack stack1;
    private Stack stack2;

    public JQueue(){
        stack2 = new Stack();
        stack1 = new Stack();
    }

    public <T> void appendTail(T node){
        this.stack1.push(node);
    }

    public <T> T deleteHead(){
        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }

        if(stack2.empty()){
            throw new RuntimeException("Queue is empty");
        }

        return (T) stack2.pop();
    }
}
