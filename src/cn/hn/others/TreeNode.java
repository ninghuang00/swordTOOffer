package cn.hn.others;

import cn.hn.algoriththm.KMP;

import java.util.*;

/**
 * Created by huangning on 2018/6/11.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {

    }
    public TreeNode(int val) {
        this.val = val;
    }

    public static String serializationPreOrder(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializationHelp(root, sb);
        return sb.toString();
    }

    public static void serializationHelp(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("#_");
            return;
        }
        sb.append(node.val + "_");
        serializationHelp(node.left, sb);
        serializationHelp(node.right, sb);

    }

    public static TreeNode deserializationPreOrder(String string) {
        String[] strs = string.split("_");
        Queue<String> queue = new LinkedList<>();
        for (String s : strs) {
            queue.offer(s);
        }
        return deserializationHelper(queue);

    }

    public static TreeNode deserializationHelper(Queue<String> queue) {
        String val = queue.poll();
        if (val.equals("#")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(val));
        node.left = deserializationHelper(queue);
        node.right = deserializationHelper(queue);
        return node;
    }

    //树root1是否包含树root2
    public static boolean isContainTree(TreeNode root1,TreeNode root2) {
        String str1 = serializationPreOrder(root1);
        String str2 = serializationPreOrder(root2);
        if (KMP.isContain(str1, str2) != -1) {
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {

        System.out.println(Integer.valueOf("66"));

    }


    //是否是完全二叉树
    public static boolean isCBT(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        boolean allNullFlag = false;
        while (node != null || !queue.isEmpty()) {
            node = queue.poll();
            if (node.right != null && node.left == null) {
                return false;
            }

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }

            if ((node.left == null && node.right == null) || (node.left != null && node.right == null)) {
                allNullFlag = true;
                break;
            }

        }

        while (allNullFlag && !queue.isEmpty()) {
            node = queue.poll();
            if (!(node.left == null && node.right == null)) {
                return false;
            }

        }

        return true;
    }


    //判断是否是二叉搜索树
    public static boolean isBST(TreeNode node) {
        if (node == null) {
            return false;
        }

        TreeNode lastNode = null;
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                if (lastNode != null) {
                    if (lastNode.val > node.val) {
                        return false;
                    }
                }
                lastNode = node;
                node = node.right;

            }
        }

        return true;
    }

    public static TreeNode createBinarySearchTree() {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(3);
        node.right = new TreeNode(7);
        node.left.left = new TreeNode(2);
        node.left.right = new TreeNode(4);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(8);

        return node;
    }

    public static TreeNode createBinaryTree() {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(3);
        node.right = new TreeNode(4);
//        node.left.left = new TreeNode(2);
        node.left.right = new TreeNode(10);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(8);

        return node;
    }

    //前序遍历 非递归
    public static List<Integer> preOrder(TreeNode root) {
        if (root == null) {
            return null;
        }

        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.val);
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }

        return list;

    }

    //中序遍历 非递归
    public static List<Integer> inOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }

        return list;

    }

    //后序遍历 非递归
    public static List<Integer> postOrder(TreeNode root) {
        if (root == null) {
            return null;
        }

        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            root = stack1.pop();
            stack2.push(root);
            if (root.left != null) {
                stack1.push(root.left);
            }
            if (root.right != null) {
                stack1.push(root.right);
            }
        }
        while (!stack2.isEmpty()) {
            list.add(stack2.pop().val);
        }

        return list;
    }

    //前序遍历 递归
    public static List<Integer> preOrderRecu(TreeNode root) {
        if (root == null) {
            return null;
        }

        List<Integer> list = new ArrayList<>();
        preOrderRecuHelper(root, list);

        return list;
    }

    private static void preOrderRecuHelper(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        preOrderRecuHelper(node.left, list);
        preOrderRecuHelper(node.right, list);

    }

    //中序遍历 递归
    public static List<Integer> inOrderRecu(TreeNode root) {
        if (root == null) {
            return null;
        }

        List<Integer> list = new ArrayList<>();
        inOrderRecuHelper(root, list);

        return list;
    }

    private static void inOrderRecuHelper(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inOrderRecuHelper(node.left, list);
        list.add(node.val);
        inOrderRecuHelper(node.right, list);

    }

    //后序遍历 递归
    public static List<Integer> postOrderRecu(TreeNode root) {
        if (root == null) {
            return null;
        }

        List<Integer> list = new ArrayList<>();
        postOrderRecuHelper(root, list);

        return list;
    }

    private static void postOrderRecuHelper(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        postOrderRecuHelper(node.left, list);
        postOrderRecuHelper(node.right, list);
        list.add(node.val);

    }



    public static void printTree(TreeNode root) {
        System.out.println("===============  print tree start  ===============");
        printInOrder(root, 0, "|", 16);
        System.out.println("======================  end  ======================");

    }

    //打印二叉树
    private static void printInOrder(TreeNode node, int height, String pointTo, int gap) {
        if (node == null) {
            return;
        }
        printInOrder(node.right, height + 1, "/", gap);
        String string = fillVal("" + node.val, gap);
        int lenM = string.length();
        int lenL = (gap - lenM)/2;
        int lenR = gap - lenL - lenM;
        string += getSign(lenR, "-");
        System.out.println(getSign(height * gap, " ") + pointTo + string);
        printInOrder(node.left,height +1,"\\",gap);

    }

    private static String fillVal(String string, int len) {
        if (string.length() < len / 2) {
            return string + getSign(len/2 - string.length()," ");
        }
        return string;

    }

    private static String getSign(int num, String sign) {
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(sign);
        }
        return buf.toString();
    }



}
