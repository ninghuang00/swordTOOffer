package cn.hn.basic;

import java.util.Comparator;
import java.util.PriorityQueue;
//求项目最大收益
public class IPO {
	public static class Node {
		public int p;//代表项目的收益
		public int c;//代表项目的花费

		public Node(int p, int c) {
			this.p = p;
			this.c = c;
		}
	}

	public static class MinCostComparator implements Comparator<Node> {

		@Override
		public int compare(Node o1, Node o2) {
			return o1.c - o2.c;
		}

	}

	public static class MaxProfitComparator implements Comparator<Node> {

		@Override
		public int compare(Node o1, Node o2) {
			return o2.p - o1.p;
		}

	}

	public static int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
		Node[] nodes = new Node[Profits.length];
		for (int i = 0; i < Profits.length; i++) {
			nodes[i] = new Node(Profits[i], Capital[i]);
		}

		//根据项目的花费创建小根堆
		PriorityQueue<Node> minCostQ = new PriorityQueue<>(new MinCostComparator());
		//根据项目的收益创建大根堆
		PriorityQueue<Node> maxProfitQ = new PriorityQueue<>(new MaxProfitComparator());

		for (int i = 0; i < nodes.length; i++) {
			minCostQ.add(nodes[i]);
		}

		for (int i = 0; i < k; i++) {
			//只要小根堆中还有项目,并且花费最小的项目小于启动资金,将项目加入大根堆
			while (!minCostQ.isEmpty() && minCostQ.peek().c <= W) {
				maxProfitQ.add(minCostQ.poll());
			}
			//如果大根堆是空的,说明没有项目可做,返回
			if (maxProfitQ.isEmpty()) {
				return W;
			}
			//本金加上项目的收益
			W += maxProfitQ.poll().p;
		}
		return W;
	}

}
