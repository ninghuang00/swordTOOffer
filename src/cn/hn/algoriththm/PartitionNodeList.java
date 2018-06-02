package cn.hn.algoriththm;

import cn.hn.others.Node;
import cn.hn.utils.SwapUtil;

/**
 * Created by huangning on 2018/6/2.
 */
public class PartitionNodeList {
    public Node normalWay(Node head, int num) {
        int length = 0;
        Node currentNOode = head;
        while (currentNOode != null) {
            currentNOode = currentNOode.getNextNode();
            length++;
        }
        int[] arr = new int[length];
        currentNOode  = head;
        length = 0;
        while (currentNOode != null) {
            arr[length++] = currentNOode.getVal();
            currentNOode = currentNOode.getNextNode();
        }
        partition(arr, num);

        return Node.createNodeList(arr);
    }

    private void partition(int[] arr, int pivot) {
        int start = 0;
        int smaller = start -1;
        int bigger = arr.length;
        while (start < bigger) {
            if (arr[start] < pivot) {
                SwapUtil.swapInt(arr, start++, ++smaller);
            } else if (arr[start] > pivot) {
                SwapUtil.swapInt(arr, start, --bigger);
            }else {
                start++;
            }
        }

    }

    public Node betterWay(Node head, int num) {
        Node lessNode = null;
        Node equalNode = null;
        Node moreNode = null;
        Node currentNode = head;
        while (currentNode != null) {
            if (lessNode == null && currentNode.getVal() < num) {
                lessNode = currentNode;
            }else if (equalNode == null && currentNode.getVal() == num) {
                equalNode = currentNode;
            } else if (moreNode == null && currentNode.getVal() > num) {
                moreNode = currentNode;
            }
            currentNode = currentNode.getNextNode();
        }

        Node endOfLess = lessNode;
        Node endOfEqual = equalNode;
        Node endOfMore = moreNode;

        currentNode = head;
        while (currentNode != null) {
            if (currentNode.getVal() < num && currentNode != lessNode) {
                endOfLess.setNextNode(currentNode);
                endOfLess = endOfLess.getNextNode();
            } else if (currentNode.getVal() == num && currentNode != equalNode) {
                endOfEqual.setNextNode(currentNode);
                endOfEqual = endOfEqual.getNextNode();
            } else if (currentNode.getVal() > num && currentNode != moreNode) {
                endOfMore.setNextNode(currentNode);
                endOfMore = endOfMore.getNextNode();
            }
            currentNode = currentNode.getNextNode();
        }

        //将每一段的结尾的下一个节点设置为null,防止拼接之后形成环
        if (endOfLess != null) {
            endOfLess.setNextNode(null);
        }
        if (endOfEqual != null) {
            endOfEqual.setNextNode(null);
        }
        if (endOfMore != null) {
            endOfMore.setNextNode(null);
        }

        //如果小于的节点不为空
        if (lessNode != null) {
            //如果等于的节点不为空
            if (equalNode != null) {
                //不管大于的节点是不是null,直接接在等于的节点之后
                endOfLess.setNextNode(equalNode);
                endOfEqual.setNextNode(moreNode);
            }else{
                //如果等于的节点为null,则直接在小于的节点之后接大于的节点
                endOfLess.setNextNode(moreNode);
            }

            //返回小于的节点头
            return lessNode;
        }else {
            //如果等于的节点不为null
            if (equalNode != null) {
                //直接把大于的节点拼上去,然后返回等于的节点头
                endOfEqual.setNextNode(moreNode);
                return equalNode;
            }else {
                //如果等于的节点为null,直接返回大于的节点
                return moreNode;
            }
        }

    }


}
