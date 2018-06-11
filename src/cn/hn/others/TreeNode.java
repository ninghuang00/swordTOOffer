package cn.hn.others;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by huangning on 2018/6/11.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

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
