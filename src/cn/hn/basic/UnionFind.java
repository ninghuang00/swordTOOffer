package cn.hn.basic;

import java.util.HashMap;
import java.util.List;

public class UnionFind {

	public static class Node {
		// whatever you like
	}

	/*
	 * title:并查集
	 * explanation:
	 * tip:
	 * example:
	 */
	public static class UnionFindSet {
		public HashMap<Node, Node> fatherMap; //当前节点作为key,父节点作为value
		public HashMap<Node, Integer> sizeMap; //记录一个集合代表代表的集合的大小

		//初始化的时候要求提供所有的节点数据
		public UnionFindSet(List<Node> nodes) {
			fatherMap = new HashMap<>();
			sizeMap = new HashMap<>();
			for (Node node : nodes) {
				fatherMap.put(node, node);
				sizeMap.put(node, 1);
			}
		}


		//查找当前节点的集合代表,并进行扁平优化
		private Node findHead(Node node) {
			Node father = fatherMap.get(node);
			if (father != node) {
				father = findHead(father);
			}
			//将当前节点直接挂在集合代表上
			fatherMap.put(node, father);
			return father;
		}
		
		public boolean isSameSet(Node a, Node b) {
			return findHead(a) == findHead(b);
		}

		public void union(Node a, Node b) {
			if (a == null || b == null) {
				return;
			}
			Node aHead = findHead(a);
			Node bHead = findHead(b);
			if (aHead != bHead) {
				int aSetSize= sizeMap.get(aHead);
				int bSetSize = sizeMap.get(bHead);
				if (aSetSize <= bSetSize) {
					fatherMap.put(aHead, bHead);
					sizeMap.put(bHead, aSetSize + bSetSize);
				} else {
					fatherMap.put(bHead, aHead);
					sizeMap.put(aHead, aSetSize + bSetSize);
				}
			}
		}

	}

	public static void main(String[] args) {

	}

}
