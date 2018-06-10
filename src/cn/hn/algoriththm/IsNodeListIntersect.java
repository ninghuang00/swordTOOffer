package cn.hn.algoriththm;

import cn.hn.others.Node;

/**
 * Created by huangning on 2018/6/10.
 */
public class IsNodeListIntersect {
    public static Node normalWay(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node entranceOfNode1 = IsRingNodeList.betterWay(head1);
        Node entranceOfNode2 = IsRingNodeList.betterWay(head2);

        // type1 如果只有其中一个是无环链表 不可能相交
        if ((entranceOfNode1 == null && entranceOfNode2 != null) || (entranceOfNode1 != null && entranceOfNode2 == null)) {
            return null;
        }

        /*if (entranceOfNode1 == null) {
            if (entranceOfNode2 != null) {
                return null;
            }
        } else {
            if (entranceOfNode2 == null) {
                return null;
            }
        } */

        // type2  如果两个都是无环链表
        Node currentNode1 = head1;
        Node currentNode2 = head2;
        int length1 = 1;
        int length2 = 1;
        if (entranceOfNode1 == null && entranceOfNode2 == null) {
            //得到哦两个链表的长度和最后一个节点
            while (currentNode1.getNextNode() != null) {
                currentNode1 = currentNode1.getNextNode();
                length1++;
            }
            while (currentNode2.getNextNode() != null) {
                currentNode2 = currentNode2.getNextNode();
                length2++;
            }
            //最后一个节点不同肯定不相交
            if (currentNode1 != currentNode2) {
                return null;
            }

            //长度大的先走
            Node firstToGo;
            Node lateToGo;
            if (length1 > length2) {
                firstToGo = head1;
                lateToGo = head2;
            } else {
                firstToGo = head2;
                lateToGo = head1;
            }

            int delta = Math.abs(length1 - length2);
            while (delta-- > 0) {
                firstToGo = firstToGo.getNextNode();
            }

            while (firstToGo != lateToGo ) {
                firstToGo = firstToGo.getNextNode();
                lateToGo = lateToGo.getNextNode();
            }

            return firstToGo;
        }


        // 如果两个都是有环链表
        if (entranceOfNode1 != null && entranceOfNode2 != null) {
            //情况一 相交节点在入环节点之前 入环节点作为最后一个节点
            if (entranceOfNode1 == entranceOfNode2) {
                currentNode1 = head1;
                currentNode2 = head2;
                length1 = 0;
                length2 = 0;
                while (currentNode1 != entranceOfNode1) {
                    length1++;
                    currentNode1 = currentNode1.getNextNode();
                }

                while (currentNode2 != entranceOfNode2) {
                    length2++;
                    currentNode2 = currentNode2.getNextNode();
                }

                //长度大的先走
                Node firstToGo;
                Node lateToGo;
                if (length1 > length2) {
                    firstToGo = head1;
                    lateToGo = head2;
                } else {
                    firstToGo = head2;
                    lateToGo = head1;
                }

                int delta = Math.abs(length1 - length2);
                while (delta-- > 0) {
                    firstToGo = firstToGo.getNextNode();
                }

                while (firstToGo != lateToGo ) {
                    firstToGo = firstToGo.getNextNode();
                    lateToGo = lateToGo.getNextNode();
                }

                return firstToGo;

            }

            //情况二 相交节点为其中一个入环节点
            if (entranceOfNode1 != entranceOfNode2) {
                return entranceOfNode1;
            }

        }
        return null;
    }
}
