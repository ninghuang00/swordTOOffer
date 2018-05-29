package cn.hn.algoriththm;

import java.util.Stack;

/**
 * Created by huangning on 2018/5/28.
 */
public class QueueByStack {
    private Stack<Integer> pushStack = new Stack<>();
    private Stack<Integer> popStack = new Stack<>();

    public void add(Integer integer) {
        pushStack.push(integer);
    }

    public Integer poll() {
        //如果popStack中有元素,那么直接从这里面弹出元素
        if (popStack.size() > 0) {
            return popStack.pop();
        } else {
            //popStack中没有元素了,看看pushStack中有没有元素,有的话全部倒到popStack中,弹出popStack返回
            if (pushStack.size() > 0) {
                while (pushStack.size() > 0) {
                    popStack.push(pushStack.pop());
                }
                return popStack.pop();
            } else {
                return null;
            }
        }

    }

    public int size() {
        return (popStack.size() + pushStack.size());
    }

}
