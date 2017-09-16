package com.huangning.demo;

import java.util.*;
import java.util.stream.Stream;

/**
 * Created by huangning on 2017/5/6.
 */
public class MyAlgorithmTraining {

    public static void main(String[] args) {
        MyAlgorithmTraining my = new MyAlgorithmTraining();

        String paths[] = {
                "root/a 1.txt(abcd) 2.txt(efgh)",
                "root/c 3.txt(abcd)",
                "root/c/d 4.txt(efgh)",
                "root 4.txt(efgh)"};
        List<List<String>> ret = my.findDuplicate(paths);
        for(List<String> list:ret){
            System.out.print("[");
            for(String s:list){
                System.out.println(s);
            }
            System.out.println("]");
        }


    }

    /*
     * title:Find Duplicate File in System
     * explanation:找出不同的路径下相同内容的文件
     * example:Input:
                ["root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"]
                Output:
                [["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt","root/c/3.txt"]]
     * param:
     * return:
     */
    public List<List<String>> findDuplicate(String[] paths){

        List<List<String>> ret = new ArrayList<>();
        //内容作为key，路径的集合作为value
        Map<String, List<String>> contentToPathList = new HashMap<>();

        for(String path:paths){
            String[] strs = path.split("\\s+");
            for(int i = 1; i < strs.length; i ++){
                int index = strs[i].indexOf("(");
                //以左括号为标志取出内容
                String content = strs[i].substring(index);
                //拼接完整路径
                String pathOfFile = strs[0] + "/" + strs[i].substring(0, index);
                if(contentToPathList.containsKey(content)){
                    contentToPathList.get(content).add(pathOfFile);
                }else{
                    contentToPathList.put(content, new ArrayList<>(Arrays.asList(pathOfFile)));
                }
                /*List<String> pathList = contentToPathList.getOrDefault(content, new ArrayList<>());
                pathList.add(pathOfFile);
                contentToPathList.put(content, pathList);*/
            }
        }

        for(String k:contentToPathList.keySet()){
            if(contentToPathList.get(k).size() > 1){
                ret.add(contentToPathList.get(k));
            }
        }


        return ret;
    }

    public char findTheDifference(String s, String t) {
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        char ret = 0;



        for(char c:ss) ret ^= c;
        for(char c:tt) ret ^= c;
        return ret;

    }

    public boolean detectCapitalUse(String word) {
        if(word == null || word.length() == 0) return false;
        char[] letters = word.toCharArray();
        //只有一个字母的情况
        //if(letters.length == 1 && Character.isUpperCase(letters[0]))return false;
        if(Character.isUpperCase(letters[0])){
            if(Character.isUpperCase(letters[1])){
                for(int i = 2; i < letters.length; i ++){
                    if(Character.isLowerCase(letters[i]))
                        return false;
                }
            }else{
                for(int i = 2; i < letters.length; i ++){
                    if(Character.isUpperCase(letters[i]))
                        return false;
                }
            }


        }else{
            for(char c:letters){
                if(Character.isUpperCase(c))
                    return false;
            }
        }
        return true;

    }
    /*
     * title:Beautiful Arrangement
     * explanation:给定一个不大于15的整数N，从1到N的排列组合中，下标可以被此位置的数整除或者此位置的数可以被下标整除的排列组合的个数。
     * example:
     * param:
     * return:
     */
    private int countArr_count = 0;
    public int countArrangement(int N) {
        if(N < 1)return 0;
        countArrHelper(N, N, new int[N + 1]);//从N开始递减速度快十倍
        return countArr_count;

    }
    //N代表传入的整数，index代表下标，used代表1到N中的数字是否已经用过
    public void countArrHelper(int N, int index, int[] used){
        if(index < 1){
            countArr_count ++;
            for(int i = 1; i < N + 1; i ++){
                System.out.print(i + ":" + used[i] + " , ");
            }
            System.out.println();
            return;
        }
        //从数字1开始，在当前下标上找到符合条件的数字后，标记该数字已经用过，进入下一个下标查找，
        for(int i = 1; i < N + 1; i ++){
            if(used[i] == 0 && (i % index == 0 || index % i == 0)){
                used[i] = index;
                countArrHelper(N,index - 1, used);
                used[i] = 0;
            }
        }
    }

    /*
     * title:Queue Reconstruction by Height
     * explanation:Suppose you have a random list of people standing in a queue. Each person is described by a pair of
     *              integers (h, k), where h is the height of the person and k is the number of people in front of this
     *              person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.
     * example:
        Input:
        [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
        Output:
        [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
     * param:
     * return:
     */
    public int[][] reconstructQueue(int[][] people) {
        //将people从高到低排序，一样高的看k，小的在千前面
        //用lambda表达式好像效率很低
        //Arrays.sort(people, (p1, p2) -> p1[0] == p2[0] ? p1[1] - p2[1] : -p1[0] + p2[0]);
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1]-o2[1] : o2[0]-o1[0];
            }
        });
        List<int[]> list = new ArrayList<>();
        //从最高的开始插入，插入位置就是k
        for (int[] p : people) {
            list.add(p[1], p);
        }

        return list.toArray(new int[people.length][]);
    }

    public String fun(int[] nums) {
        StringBuilder ret = new StringBuilder(nums[0] + "/(" + nums[1]);
        System.out.println(ret);
        double res = nums[1];
        for (int i = 2; i < nums.length; i++) {
            res /= nums[i];
            ret.append("/" + nums[i]);
        }
        res = nums[0] / res;
        return ret.append(")=" + res).toString();

    }

    /*
     * title:find next greater element
     * explanation:数组1为数组2的子集，找到数组1在数组2中对应位置右边比自己大的数，没有则输出-1.数组中没有重复的元素
     * example:Input: nums1 = [4,1,2], nums2 = [1,3,4,2]. Output: [-1,3,-1]
     * param:
     * return:
     */
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();//存放每一段降序序列中的数和出现的第一个比他们大的数
        Stack<Integer> stack = new Stack<>();//存放每一段降序序列，碰到比栈顶大的数字时pop出小的数字，
        // 这个大的数字就是这些小的数字对应的next greater element
        for (int n : nums) {
            while (!stack.empty() && n > stack.peek()) {
                map.put(stack.pop(), n);
            }
            stack.push(n);
        }

        for (int i = 0; i < findNums.length; i++) {
            findNums[i] = map.getOrDefault(findNums[i], -1);
        }
        return findNums;

    }

    /*
     * title:distribute candies
     * explanation:
     * example:
     * param:
     * return:
     */
    public int distributeCandies(int[] candies) {

        Set<Integer> kinds = new HashSet<>();
        for (int i : candies) kinds.add(i);
        return kinds.size() >= candies.length ? candies.length / 2 : kinds.size();

       /* int n = candies.length;//sister能收到的最多种类数为n/2

        if(0 == n){
            return 0;
        }
        int count = 1;//实际获得种类计数
        Arrays.sort(candies);
        for(int i:candies){
            System.out.print(i + " ");
        }
        for(int i = 1; i < n; i++){
            if(candies[i] != candies[i-1])count++;
            if(i > n/2) return n/2;
        }
        return count;*/

    }

    /**
     * title:reverse String
     * explain:
     * example:
     *
     * @param s
     * @return
     */
    public String reverseString(String s) {
        char[] word = s.toCharArray();
        char temp = ' ';
        for (int i = 0; i < word.length / 2; i++) {
            int j = word.length - i - 1;
            temp = word[i];
            word[i] = word[j];
            word[j] = temp;
        }
        return new String(word);
    }


    /**
     * title:reverse words in a string III
     * explain:
     * example:input: let's take leetcode contest
     * output: s'tel ekat edocteel teetnoc
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        String in[] = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < in.length; i++) {
            result.append(new StringBuffer(in[i]).reverse() + " ");
        }

        return result.toString();
    }

    /**
     * title:counting bits
     * explanation:计算从0到num的非负整数的‘1’的个数，返回数组
     * example:
     *
     * @param
     * @return
     */
    public int[] countBits(int num) {
        if (0 == num) {
            int a[] = {0};
            return a;
        }
        int a[] = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            if (0 == i % 2) {
                int index = i / 2;
                a[i] = a[index];
            } else {
                int index = i / 2;
                a[i] = a[index] + 1;
            }
        }
        return a;
    }

    /**
     * title:Keyboard Row
     * explanation:判断一个单词中的所有字母是不是在键盘的同一行
     * example:
     *
     * @param
     * @return
     */
    public String[] findWords(String[] words) {
        //String []result = {};
        String[] rowsOfKeyboard = {
                "qwertyuiop", "asdfghjkl", "zxcvbnm"
        };

        Map<Character, Integer> map = new HashMap<>();
        //将键盘上每一行的字母和对应的行号作为键值对存进map
        for (int i = 0; i < rowsOfKeyboard.length; i++) {
            for (char c : rowsOfKeyboard[i].toCharArray()) {
                map.put(c, i);
            }
        }
        List<String> list = new ArrayList<String>();
        //比较单词的第一个字母（键），和后面几个字母（键）的值是否相等，都相等就说明是在同一行的
        for (String w : words) {
            if (w.equals("")) {
                continue;
            }
            int index = map.get(w.toLowerCase().charAt(0));
            for (char c : w.toLowerCase().toCharArray()) {
                if (map.get(c) != index) {
                    index = -1;
                    break;
                }
            }
            if (index != -1) {
                list.add(w);
            }
        }
        String[] stemp = list.toArray(new String[list.size()]);

        return stemp;
    }

    /**
     * title:battleships in board
     * explanation:count the number of ships in the board
     * example:
     *
     * @param
     * @return
     */
    public int countBattleships(char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                //find the head of each battleship
                if (board[i][j] == 'X' && (i == 0 || board[i - 1][j] == '.') && (j == 0 || board[i][j - 1] == '.')) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * title:hamming distance
     * explanation:比较并返回两个整数的二进制形式的不同的对应bit的个数
     * example:
     *
     * @param
     * @return
     */

    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    /**
     * title:twosum
     * explanation:返回数组中和为目标值的两个数的下标
     * example:
     *
     * @param
     * @return
     */

    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                result[1] = i;
                result[0] = map.get(target - numbers[i]);
                return result;
            }
            map.put(numbers[i], i);
        }
        return result;
    }

    /**
     * title:Complex Number Multiplication
     * explanation:输入两个字符串形式的复数，计算乘积，以特定的格式输出。
     * example:
     * Input: "1+-1i", "1+-1i"
     * Output: "0+-2i"
     * Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i,
     * and you need convert it to the form of 0+-2i.
     *
     * @param
     * @return
     */
    public String complexNumberMultiply(String aa, String bb) {
        String result = "";
        String aSeparate[] = complexSeparate(aa);
        String bSeparate[] = complexSeparate(bb);
        //a + bi, c + di
        int a = Integer.parseInt(aSeparate[0]);
        int b = Integer.parseInt(aSeparate[1].substring(0, aSeparate[1].length() - 1));
        int c = Integer.parseInt(bSeparate[0]);
        int d = Integer.parseInt(bSeparate[1].substring(0, bSeparate[1].length() - 1));

        result = a * c - b * d + "+" + (a * d + b * c) + "i";

        return result;
    }

    public String[] complexSeparate(String a) {
        a = a.trim();
        String[] result = {"", ""};

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == '+') {
                result[1] = a.substring(i + 1);
                break;
            }
            result[0] += a.charAt(i);

        }

        return result;
    }

    /**
     * split解法
     */
    public String complexNumberMultiply2(String aaa, String bbb) {
        String[] aa = aaa.split("\\+|i");
        String[] bb = bbb.split("\\+|i");
        //System.out.println(aa[0] + "    " + aa[1]);
        //System.out.println(bb[0] + "    " + bb[1]);
        int a = Integer.parseInt(aa[0]);
        int b = Integer.parseInt(aa[1]);
        int c = Integer.parseInt(bb[0]);
        int d = Integer.parseInt(bb[1]);

        return a * c - b * d + "+" + (a * d + b * c) + "i";

    }

    /**
     * Stream解法
     */
    public String complexNumberMultiply3(String a, String b) {
        int[] coefs1 = Stream.of(a.split("\\+|i")).mapToInt(Integer::parseInt).toArray(),
                coefs2 = Stream.of(b.split("\\+|i")).mapToInt(Integer::parseInt).toArray();
        return (coefs1[0] * coefs2[0] - coefs1[1] * coefs2[1]) + "+" + (coefs1[0] * coefs2[1] + coefs1[1] * coefs2[0]) + "i";
    }

    /**
     * title:Number Complement
     * explanation:求互补的数字
     * example:
     * input:5 ->101
     * output:2->010
     *
     * @param num
     * @return
     */

    public int findComplement(int num) {
        String binary = Integer.toBinaryString(num);
        /*binary = binary.replaceAll("1", "2");
        System.out.println(binary);
        binary = binary.replaceAll("0", "1");
        System.out.println(binary);
        binary = binary.replaceAll("2", "0");
        System.out.println(binary);*/
        //String temp = binary;
        char[] temp = new char[binary.length()];
        for (int i = 0; i < binary.length(); i++) {
            if ('1' == binary.charAt(i)) {
                temp[i] = '0';
            } else {
                temp[i] = '1';
            }
        }

        binary = String.valueOf(temp);

        return num = Integer.parseInt(binary, 2);

    }


}
