package cn.hn.basic;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
//广度优先搜索
public class BFS {

	public static void bfs(Node node) {
		if (node == null) {
			return;
		}
		Queue<Node> queue = new LinkedList<>();
		HashSet<Node> map = new HashSet<>();
		queue.add(node);
		map.add(node);
		//队列不空,则将队列中最前面的取出进行处理,类似于按层遍历二叉树
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			System.out.println(cur.value);
			for (Node next : cur.nexts) {
				if (!map.contains(next)) {
					map.add(next);
					queue.add(next);
				}
			}
		}
	}

}
