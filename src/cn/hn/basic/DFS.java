package cn.hn.basic;

import java.util.HashSet;
import java.util.Stack;
//深度优先搜索
public class DFS {

	public static void dfs(Node node) {
		if (node == null) {
			return;
		}
		Stack<Node> stack = new Stack<>();
		HashSet<Node> set = new HashSet<>();
		stack.add(node);
		set.add(node);
		System.out.println(node.value);
		//只要栈不空,弹出最上面的进行处理,
		while (!stack.isEmpty()) {
			Node cur = stack.pop();
			for (Node next : cur.nexts) {
				//之前搜索过的节点排除
				if (!set.contains(next)) {
					stack.push(cur);
					stack.push(next);
					set.add(next);
					System.out.println(next.value);
					break;
				}
			}
		}
	}

}
