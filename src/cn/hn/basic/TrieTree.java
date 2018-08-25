package cn.hn.basic;

import java.util.HashMap;

/*
 * title:前缀树
 * explanation:
 * tip:
 * example:
 */
public class TrieTree {

	public static class TrieNode {
		public int path; //表示当前节点被经过几次
		public int end; //表示有多少个字符串是以当前节点结尾的
		//代表一种选择,这里可以是某一个字符,经典实现就只将选择放在边上,放在节点上实现繁琐
		//如果其中一个元素指向null,说明这种选择不存在
		public TrieNode[] nexts;
//		public HashMap<Character,TrieNode> nexts; //也可以用map实现

		public TrieNode() {
			path = 0;
			end = 0;
			nexts = new TrieNode[26];//以26个字母为例
		}
	}

	public static class Trie {
		private TrieNode root;//root节点不代表任何选择,所以path和end始终为0

		public Trie() {
			root = new TrieNode();
		}

		//插入字符串
		public void insert(String word) {
			if (word == null) {
				return;
			}
			char[] chs = word.toCharArray();
			TrieNode node = root;
			int index = 0;
			for (int i = 0; i < chs.length; i++) {
				//计算字符应该放在哪个位置
				index = chs[i] - 'a';
				//如果选择不存在,创建
				if (node.nexts[index] == null) {
					node.nexts[index] = new TrieNode();
				}
				//选择存在,将node指向这个选择,然后path++,说明经过这种选择
				node = node.nexts[index];
				node.path++;
			}
			//字符串遍历完,end++,说明以这种选择结尾
			node.end++;
		}
		//删除一个字符创
		public void delete(String word) {
			if (search(word) != 0) {
				char[] chs = word.toCharArray();
				TrieNode node = root;
				int index = 0;
				for (int i = 0; i < chs.length; i++) {
					index = chs[i] - 'a';
					//如果删除途中path变为0,说明后面的可以直接置为null
					if (--node.nexts[index].path == 0) {
						node.nexts[index] = null;
						return;
					}
					node = node.nexts[index];
				}
				node.end--;
			}
		}
		//查找一个字符串插入的次数
		public int search(String word) {
			if (word == null) {
				return 0;
			}
			char[] chs = word.toCharArray();
			TrieNode node = root;
			int index = 0;
			for (int i = 0; i < chs.length; i++) {
				index = chs[i] - 'a';
				if (node.nexts[index] == null) {
					return 0;
				}
				node = node.nexts[index];
			}
			return node.end;
		}
		//查找某种前缀的数量
		public int prefixNumber(String pre) {
			if (pre == null) {
				return 0;
			}
			char[] chs = pre.toCharArray();
			TrieNode node = root;
			int index = 0;
			for (int i = 0; i < chs.length; i++) {
				index = chs[i] - 'a';
				if (node.nexts[index] == null) {
					return 0;
				}
				node = node.nexts[index];
			}
			return node.path;
		}
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		System.out.println(trie.search("zuo"));
		trie.insert("zuo");
		System.out.println(trie.search("zuo"));
		trie.delete("zuo");
		System.out.println(trie.search("zuo"));
		trie.insert("zuo");
		trie.insert("zuo");
		trie.delete("zuo");
		System.out.println(trie.search("zuo"));
		trie.delete("zuo");
		System.out.println(trie.search("zuo"));
		trie.insert("zuoa");
		trie.insert("zuoac");
		trie.insert("zuoab");
		trie.insert("zuoad");
		trie.delete("zuoa");
		System.out.println(trie.search("zuoa"));
		System.out.println(trie.prefixNumber("zuo"));

	}

}
