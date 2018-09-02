package cn.hn.leetCode;

/**
 * Created by huangning on 2018/9/1.
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode node1, ListNode node2) {
        ListNode curNode = new ListNode(0);
        ListNode lastNode = null;
        ListNode ret = curNode;

        while(node1 != null && node2 != null){
            //计算当前节点的和,求出进位和余数
            int sum = node1.val + node2.val + curNode.val;
            int up = sum >= 10 ? 1 : 0;
            sum %= 10;
            //当前节点的值为上一次计算的得到的进位和当前计算得到的余数
            curNode.val = sum;
            //当前节点计算得到的进位作为下一个节点初始值
            curNode.next = new ListNode(up);
            //保留当前节点的记录,在处理结尾的时候用
            lastNode = curNode;
            curNode = curNode.next;

            node1 = node1.next;
            node2 = node2.next;

        }

        if(node1 == null && node2 == null){
            lastNode.next = curNode.val == 0 ? null : curNode;
            return ret;
        }


        if(node1 == null){
            //当前节点如果有进位,则进入递归,计算当前节点和node2剩下节点的结果
            lastNode.next = curNode.val == 0 ? node2 : addTwoNumbers(node2,curNode);
        }else{
            lastNode.next = curNode.val == 0 ? node1 : addTwoNumbers(node1,curNode);
        }

        return ret;

    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}