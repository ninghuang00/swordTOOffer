package cn.hn.algoriththm;

import cn.hn.utils.Log;
import cn.hn.utils.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;


/**
 * Created by huangning on 2017/9/8.
 */
public class ToOffer {

    Logger logger = Logger.getLogger("hnlog");
    public int count = 0;

    /*===================================================================================================*/

    /*
     * title:合并两个排序的链表
     * explanation:合并两个递增的链表,合并之后也是递增
     * tip:
     * example:
     * param:
     * return:
     */
    public ListNode mergeList(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        }
        ListNode mergeHead = null;
        if (head1.val < head2.val) {
            mergeHead = head1;
            mergeHead.nextNode = mergeList(head1.nextNode, head2);
        }else{
            mergeHead = head2;
            mergeHead.nextNode = mergeList(head1, head2.nextNode);
        }

        return mergeHead;
    }

    /*
     * title:反转链表
     * explanation:给定一个单向链表头节点,反转整个链表
     * tip:记录当前节点的前一个节点,当前节点的后面一个节点
     * example:
     * param:
     * return:
     */
    public ListNode reverseList(ListNode head) {
        ListNode reverseHead = null;
        ListNode curNode = head;
        ListNode preNode = null;
        while (curNode != null) {
            ListNode nextNode = curNode.nextNode;

            if (nextNode == null) {
                reverseHead = curNode;
            }

            curNode.nextNode = preNode; //将当前节点的下一个节点指向前当前节点的前一个节点
            preNode = curNode;  //当前节点变成前一个节点
            curNode = nextNode; //下一个节点变成当前节点

        }

        return reverseHead;
    }
    /*
     * title:链表中的环的入口
     * explanation:判断链表中是否存在环,如果存在,返回环的入口
     * tip: 还是用两个指针,快的指针是慢的指针的指针的速度的两倍速度,当指针相遇的时候,说明存在环
     *      然后从相遇的节点开始计数就能得到环的大小,
     *      从头指针开始,快指针先走环的大小的距离,然后慢指针开始走,相遇的节点就是入口
     * example:
     * param:
     * return:
     */
    public ListNode entryNodeOfLoop(ListNode head){
        if(head == null){
            return null;
        }
        ListNode meetNode = findMeetNode(head);
        if (meetNode == null) {
            return null;
        }
        int count = 1;  //根据观察得
        ListNode startNode = meetNode.nextNode;
        while(startNode != meetNode){
            startNode = startNode.nextNode;
            count ++;
        }
        startNode = head;
        for(int i = 0; i < count; ++ i) {
            startNode = startNode.nextNode;
        }
        ListNode behindNode = head;
        while (startNode != behindNode) {
            startNode = startNode.nextNode;
            behindNode = behindNode.nextNode;
        }
        return startNode;

    }
    private ListNode findMeetNode(ListNode head){
        if (head == null) {
            return null;
        }
        ListNode slowNode = head.nextNode;
        if (slowNode == null) {
            return null;
        }
        ListNode fastNode = slowNode.nextNode;
        while (fastNode != null) {
            if (fastNode == slowNode) {
                return fastNode;
            }

            slowNode = slowNode.nextNode;
            fastNode = fastNode.nextNode;
            if (fastNode != null) {
                fastNode = fastNode.nextNode;
            }
        }
        return null;

    }
    /*
     * title:查找链表中倒数第k个节点
     * explanation:
     * tip:可以定义两个指针,前面的指针先走k步,要注意边界问题还有空指针
     * example:
     * param:
     * return:
     */
    public ListNode findKthToTail(ListNode head, int k){
        if(head == null || k == 0){
            return null;
        }
//        int ahead = 0;
//        int behind = 0;
        ListNode ahead = head;
        ListNode behind = null;
        //当i=0的时候,ahead指针指向的是1节点,所以当i=k-2的时候,ahead指针指向的就是k-1节点
        for(int i = 0; i < k - 1; ++i){
            //判断是不是k有没有超出链表的最大长度
            if(ahead.nextNode != null){
                ahead = ahead.nextNode;
            }else{
                return null;
            }
        }
        //这时候behind指针指向0节点,和ahead指针正好相差k个节点
        behind = head;
        while(ahead.nextNode != null){
            ahead = ahead.nextNode;
            behind = behind.nextNode;
        }

        return behind;
    }

    /*
     * title:调整数组的顺序是的所有的奇数在前面所有的偶数在后面
     * explanation:
     * tip:定义两个指针一个从前往后，一个从后往前
     * example:
     * param:
     * return:
     */
    public void reorderOddEven(int[] nums){
        if(nums == null || nums.length == 0){
            return;
        }
        int begin = 0;
        int end = nums.length - 1;
        while(begin < end){
            while(begin < end && condition(nums[begin])){
                begin ++;
            }
            while(begin < end && !condition(nums[end])){
                end --;
            }
            int temp = nums[begin];
            nums[begin] = nums[end];
            nums[end] = temp;
        }

    }
    //判断分组条件，分在前面的返回ture，后面的返回false
    //增强代码的重用性能，可以改变条件
    public boolean condition(int num){
        return ((num & 0x01) == 1) ? true : false;
    }
    /*
     * title:表示数值的字符串
     * explanation:判断一个字符串是否是数字,可以是小数,整数,科学计数法
     * tip:分成两种情况有整数部分和没有整数部分，首先‘.’的前面可以没有数字，后面要有，‘e’或者‘E’的前后都要有数字
     * example:
     * param:
     * return:
     */
    public boolean isNumeric(String string){
        if(StringUtils.isEmpty(string))
            return false;
        char[] chars = string.toCharArray();
        int[] index = {0};//指向当前所在字符位置的指针
        //先判断字符串中小数点之前的字符情况,如果存在的话
        /*
        * true 说明遇到不是数字的字符之前有若干个数字
        * false 说明没有数字
        * */
        boolean numeric = scanInteger(chars,index);
        //然后判断小数点之后的情况
        if(chars[index[0]] == '.'){
            index[0] ++;
            /*
            * false | false 说明小数点之前没有数字，后面也没有数字
            * true 说明前后有一方有数字
            *
            * */
            //如果.后面直接是指数，直接返回false
            if(chars[index[0]] == 'e' || chars[index[0]] == 'E')
                return false;
            numeric = numeric | scanUnsignedInteger(chars,index);
        }
        //然后判断字符 e或E 前后的数字情况，前后都要有数字才行
        if(chars[index[0]] == 'e' || chars[index[0]] == 'E'){
            ++ index[0];
            numeric = numeric && scanInteger(chars,index);
        }
        //此时index应该已经到了结尾
        return numeric && index[0] == chars.length;

    }
    //判断一个字符从传进来的index开始是不是有若干个数字
    public boolean scanUnsignedInteger(char[] chars,int[] index){
        int lastIndex =  index[0];
        while(index[0] < chars.length && chars[index[0]] >= '0' && chars[index[0]] <= '9'){
            ++ index[0];
        }

        return index[0] > lastIndex;

    }
    //字符串可能会带有 + -
    public boolean scanInteger(char[] chars,int [] index){
        if(chars[index[0]] == '+' || chars[index[0]] == '-'){
            ++ index[0];
        }
        return scanUnsignedInteger(chars,index);
    }



    /*
     * title:正则表达式匹配
     * explanation:实现一个函数来匹配包含'.'和'*'的正则表达式
     * tip:'.'代表任意字符,'*'代表任意个或者0个前一个字符
     * example:aba与a.a匹配
     * param:
     * return:匹配则返回true
     */
    public boolean match(String str,String pattern){
        if(str == null || pattern == null){
            return false;
        }

        char[] strs = str.toCharArray();
        char[] patterns = pattern.toCharArray();
        return matchCoere(strs,0,patterns,0);
    }

    public boolean matchCoere(char[] str,int indexOfStr,char[] pattern,int indexOfPattern){
        //如果两者都到达了结尾
        if(indexOfPattern == pattern.length && indexOfStr == str.length){
            return true;
        }
        //如果正则到达了结尾,字符串没有到
        if(indexOfPattern == pattern.length && indexOfStr != str.length){
            return false;
        }
        //如果传进来的正则的第二个字符是'*'
        if(indexOfPattern + 1 < pattern.length && pattern[indexOfPattern + 1] == '*'){
            //如果正则的第一个字符和字符串的匹配 或者 正则的第一个字符是'.'且字符串没有到结尾
            if(pattern[indexOfPattern] == str[indexOfStr] || (pattern[indexOfPattern] == '.' && indexOfStr != str.length)){
                //假设*代表0个
                return matchCoere(str,indexOfStr ,pattern,indexOfPattern + 2)
                        //假设*代表1个
                        || matchCoere(str,indexOfStr + 1,pattern,indexOfPattern + 2)
                        //假设*代表若干个
                        || matchCoere(str,indexOfStr + 1,pattern,indexOfPattern );
            }else{
                //说明*只能代表0个
                matchCoere(str,indexOfStr ,pattern,indexOfPattern + 2);
            }
        }
        //传进来的正则的第二个字符不是'*',且第一个字符匹配,
        if(pattern[indexOfPattern] == str[indexOfStr] || (pattern[indexOfPattern] == '.' && indexOfStr != str.length)){
            return matchCoere(str,indexOfStr + 1,pattern,indexOfPattern + 1);
        }
        return false;
    }
    /*
     * title:删除链表中重复的节点
     * explanation:在已经排序的链表中删除重复的节点
     * tip:要注意重复节点之前的节点要始终和重复节点的后一个节点相连
     * example:
     * param:
     * return:
     */
    public ListNode deleteDuplicatedNode(ListNode headNode){
        if(headNode == null ){
            logger.info("illegal input ");
            return null;
        }
        ListNode curNode = headNode;    //当前节点
        ListNode preNode = null;    //当前节点的前一个节点
        while(curNode != null){ //当前节点不为空
            ListNode nextNode = curNode.nextNode;   //当前节点的下一个节点
            if(nextNode != null && curNode.val == nextNode.val){    //下一个节点不为空且与当前节点重复
                int value = curNode.val;
                ListNode nodeToBeDel = curNode;    //定义要删除的节点
                while(nodeToBeDel.nextNode != null && nodeToBeDel.nextNode.val == value){   //比较节点值,直到找到不相同的值
                    nextNode = nextNode.nextNode;   //保存下一个节点的下一个节点
                    nodeToBeDel.nextNode = null;    //删除当前要删除节点的下一个重复节点
                    nodeToBeDel.nextNode = nextNode;    //将当前要删除的节点连接到之前保存的nextNode
                }
                if(nodeToBeDel == headNode){    //当前要删除的节点,也就是当前节点如果是头结点的话
                    headNode = nextNode;
                    curNode = nextNode;
                }else {
                    //将当前要删除的节点的前一个节点指向下一个节点
                    preNode.nextNode = nextNode;
                    curNode = nextNode;
                }

            }else{
                preNode = curNode;
                curNode = nextNode;
            }


        }
        return headNode;
    }
    /*
     * title:删除链表的节点
     * explanation:在O(1)时间内删除指定节点
     * example:
     * param:
     * return:
     */
    public void deleteNode(ListNode headNode,ListNode nodeToBeDeleted){
        if(headNode == null || nodeToBeDeleted == null){
            logger.info("illegal input ");
            return;
        }

        //要删除的节点不是尾节点,将要删除的节点的下一个节点的值复制过来
        if(nodeToBeDeleted.nextNode != null){
            ListNode node = nodeToBeDeleted.nextNode;
            nodeToBeDeleted.val = node.val;
            nodeToBeDeleted.nextNode = node.nextNode;
        }
        //链表只有一个节点,即尾节点,或者要删除的节点就是头结点
        else if(headNode == nodeToBeDeleted){
            headNode = null;
        }
        //链表有多个节点,需要遍历,删除尾节点
        else{
            ListNode node = headNode;
            while(node.nextNode != nodeToBeDeleted){
                node = node.nextNode;
            }
            node.nextNode = null;
        }

    }

    /*
     * title:打印1到最大的n位数的递归方法
     * explanation:其实就是n位数字的全排列,
     * example:
     * param:
     * return:
     */
    public void print1ToMaxNDigitsRecu(int n) {
        if (n <= 0) {
            logger.info("please input a integer number");
            return;
        }
        char[] number = new char[n];
        for (int i = 0; i < n; ++i) {
            number[i] = '0';
        }
        for (int i = 0; i < 10; ++i) {
            number[0] = (char) (i + '0');
            print1ToMaxOfNDigitsHelper(number, 0);
        }

    }

    private void print1ToMaxOfNDigitsHelper(char[] number, int index) {
        ++ count;
        int length = number.length;
        if (index == length - 1) {  //移动到最后一位的时候就打印
            printNumber(number);
            return;
        }
        for (int i = 0; i < 10; ++i) {
            number[index + 1] = (char) (i + '0');
            print1ToMaxOfNDigitsHelper(number, index + 1);
        }
    }

    /*
     * title:打印从1到最大的n为数
     * explanation:输入正整数n,打印1到最大的n位数
     * example:输入3,打印1到999
     * param:
     * return:
     */
    public void print1ToMaxOfNDigits(int n) {
        if (n <= 0) {
            logger.info("请输入正整数");
            return;
        }
        char[] number = new char[n];
        for (int i = 0; i < n; ++i) {
            number[i] = '0';
        }
        while (!increament(number)) {
            printNumber(number);
            System.out.println();
        }


    }

    //打印数字,高位的0不打印
    private void printNumber(char[] number) {
        boolean is0 = true;
        for (int i = 0; i < number.length; ++i) {
            if (is0 && number[i] != '0') {
                is0 = false;
            }
            if (!is0) {
                System.out.printf("" + number[i]);
            }
        }
        System.out.println();
    }

    //模拟十进制整数自加的过程,没有最高位没有溢出返回false
    private boolean increament(char[] number) {
        int length = number.length;
        boolean isOverflow = false; //是否溢出,用来判断是不是达到最大的数位
        int takeover = 0; //进位标志
        for (int i = length - 1; i >= 0; --i) {
            int sumN = number[i] - '0' + takeover;  // 字符数字转换成数字,代表这个位置上的数字和进位相加的结果,一开始没有进位
            if (i == length - 1) {
                sumN++;    //是最后一位数字的时候,自加1
            }
            if (sumN >= 10) { //大于10进位
                if (i == 0) { //当最高位大于10的时候
                    isOverflow = true;
                } else {
                    sumN -= 10; //满10清零
                    takeover = 1;   //进位标志置1
                    number[i] = (char) ('0' + sumN); //数字转换成数字字符保存
                }
            } else {
                number[i] = (char) ('0' + sumN);
                break;
            }

        }

        return isOverflow;
    }

    /*
     * title:位运算 二进制中的1的个数
     * explanation:要考虑正负数
     * example:
     * param:
     * return:
     */
    //常规解法一,当整数不为0,不断右移,同时&1,循环次数等于输入整数的位数,仅限于正整数
    //常规解法二,设flag为1,不断左移flag,并且和n进行&操作,但是要求flag为正整数
    //解法三,发现规律,把一个整数减去1,然后与原来的数相与,就会是这个整数最右边的1变成0.
    public int numberOf1(int n) {
        //**********************解法二************************//
        /*int count = 0;
        int flag = 1;
        while(flag != 0){
            //logger.info("flag is " + flag);
            if((flag & n) != 0){
                ++ count;
            }
            flag = flag << 1;
        }
        return count;*/
        //**********************解法3************************//
        int count = 0;
        while (n != 0) {
            ++count;
            n = n & (n - 1);
        }
        return count;
    }

    /*
     * title:割绳子(贪婪算法)
     * explanation:给一根长度为n的绳子,要求切成若干段,使得每一段的长度乘积最大
     * example:
     * param:
     * return:
     */
    public int maxProductAfterCut(int length) {
        //当绳子的长度小于4的时候直接返回结果
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }

        //定义products数组存放每一个长度绳子的最后结果,自下而上,求结果
        int[] products = new int[length + 1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;

        int max = 0;
        for (int i = 4; i <= length; ++i) {
            for (int j = 1; j <= i / 2; ++j) {
                max = 0;
                int result = products[j] * products[i - j]; //比较每一种可能,得到最大
                if (max < result) {
                    max = result;
                }
                logger.info("length is " + i + "cut length is " + j + " max is " + max);
                products[i] = max;
            }

        }
        max = products[length];
        return max;

    }

    /*
    * title:机器人的运动范围
    * explanation:从坐标(0,0)开始移动,给定一个阈值,机器人不能进入横纵坐标各个位置上的数字之和加起来大于阈值的格子,
    * example:比如当阈值为10的时候,机器人不能进入坐标(0,11)的格子
    * param:
    * return:
    */
    public int robotMoving(int thread, boolean[][] visited) {
        if (thread == 0 || visited == null) {
            return 0;
        }
        //初始化矩阵
        for (int i = 0; i < visited.length; ++i) {
            for (int j = 0; j < visited[0].length; ++j) {
                visited[i][j] = false;
            }
        }
        //最后返回的活动范围
        int count = moveHelper(visited, thread, 0, 0);

        return count;

    }

    //上下左右移动的递归函数
    private int moveHelper(boolean[][] visited, int thread, int row, int col) {
        int count = 0;
        //如果通过验证发现该坐标符合要求,向该坐标的周围继续寻找,找到了就加一
        if (cheched(visited, thread, row, col)) {
            //标记该坐标是符合要求的
            visited[row][col] = true;
            //向该坐标的上下左右移动
            count = 1 + moveHelper(visited, thread, row + 1, col)
                    + moveHelper(visited, thread, row, col + 1)
                    + moveHelper(visited, thread, row - 1, col)
                    + moveHelper(visited, thread, row, col - 1);
        }

        return count;
    }

    //验证坐标点是否符合要求
    private boolean cheched(boolean[][] visited, int thread, int row, int col) {
        //没有超过边界,没有走过,没有超过阈值
        if (row >= 0 && row < visited.length && col >= 0 && col < visited[0].length &&
                !visited[row][col] && (getDigitSum(row) + getDigitSum(col)) <= thread) {
            return true;
        }
        return false;
    }

    //得到一个数字每一位的数值之和
    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    /*
     * title:寻找矩阵中的路径,
     * explanation:在二位矩阵中寻找给定字符串的路径,存在返回true,否则返回false
     * example:
     * param:
     * return:
     */
    public boolean hasPath(char[][] matrix, String str) {
        if (matrix == null || str == null) {
            return false;
        }
        int height = matrix.length; //数组的高度
        int width = matrix[0].length;   //数组的宽度
        char[] chars = str.toCharArray();   //将字符串转换成字符数组
        boolean visited[][] = new boolean[height][width];   //存放二维数组的遍历情况
        for (int i = 0; i < height; ++i) {  //初始化
            for (int j = 0; j < width; ++j) {
                visited[i][j] = false;
            }

        }
        Depth depth = new Depth();  //存储递归的深度,也就是字符数组的第几个字符
        depth.depth = 0;
        depth.count = 0;
        //遍历二维数组,
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                if (findPath(matrix, i, j, chars, depth, visited)) {
                    logger.info("invoke time is " + depth.count);
                    return true;
                }
            }
        }

        logger.info("invoke time is " + depth.count);
        return false;
    }

    private boolean findPath(char[][] matrix, int row, int col, char[] chars, Depth depth, boolean[][] visited) {
        if (depth.depth == chars.length) {
            return true;
        }
        depth.count++;
        int width = matrix[0].length;
        int height = matrix.length;
        boolean hasParh = false;    //最后的放回结果,找到对应的字符就返回true
        if (row >= 0 && row < height && col < width && col >= 0 //判断边界
                && matrix[row][col] == chars[depth.depth]   //字符是否相等
                && !visited[row][col]) {    //第一次经过
            depth.depth++;
            visited[row][col] = true;
            // 查找当前字符的上下左右
            hasParh = findPath(matrix, row, col + 1, chars, depth, visited) ||
                    findPath(matrix, row + 1, col, chars, depth, visited) ||
                    findPath(matrix, row, col - 1, chars, depth, visited) ||
                    findPath(matrix, row - 1, col, chars, depth, visited);
            //如果当前字符的上下左右没有找到对应的字符,则返回到上一个位置在查找
            if (!hasParh) {
                depth.depth--;
                visited[row][col] = false;
            }
        }

        return hasParh;
    }


    class Depth {
        int depth;
        long count;
    }

    /*
     * title:旋转数组中最小的数字,旋转前的数组是递增的
     * explanation:旋转数组是指将数组中最前面若干个元素移动到最后
     * example:数组:3 4 5 1 2是数组:1 2 3 4 5的一个旋转
     * param:
     * return:
     */
    public int minNumInReverseArray(int[] nums) {
        if (nums == null || nums.length < 3 || nums[0] < nums[nums.length - 1]) {
            throw new RuntimeException("illegal input ");
        }
        int indexMid = 0;   //二分法,指向中间
        int start = 0;  //指向前面
        int end = nums.length - 1;  //指向尾部
        while (nums[end] <= nums[start]) {    //数组前面部分的序列必定大于后面的递增序列
            if (end - start == 1) {   //当到达分界点的时候
                indexMid = end; //最小的数就是右边的指针指向的数
                break;
            }
            indexMid = (start + end) / 2;

            if (nums[start] == nums[indexMid] && nums[indexMid] == nums[end]) {   //如果出现三个指针指向的值相等的情况,则只能
                //通过遍历查找的方法
                return minInOrder(start, end, nums);

            }
            if (nums[indexMid] >= nums[start]) {  //当中间指针指向的值大于头指针指向的值,说明之间指针还在前面的递增序列中
                start = indexMid;
            } else if (nums[indexMid] <= nums[end]) { //与上述情况类似
                end = indexMid;
            }
        }

        return indexMid;
    }

    private int minInOrder(int start, int end, int[] nums) {
        int result = nums[start];
        for (int i = start; i <= end; ++i) {
            if (result > nums[i]) {
                result = nums[i];
            }
        }
        return result;
    }

    /*
    斐波那契数列的递归实现,效率很差
     */
    public long fibonacci_recursive(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci_recursive(n - 1) + fibonacci_recursive(n - 2);
    }

    /*
    斐波那契数列的循环实现
     */
    public long fibonacci_iterative(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        long num1 = 0;
        long num2 = 1;
        long sum = 0;
        for (int i = 2; i <= n; ++i) {
            sum = num1 + num2;
            num1 = num2;
            num2 = sum;
        }
        return sum;

    }

    /*
    合并数组
    将排序数组a1和a2合并,要求合并之后还是有序的
     */
    public int[] mergeNums(int[] a1, int[] a2) {
        int[] ret = new int[a1.length + a2.length];
        int indexOfRet = ret.length;
        int indexOfa1 = a1.length - 1;
        int indexOfa2 = a2.length - 1;
        while (indexOfa1 >= 0 && indexOfa2 >= 0) {
            if (a1[indexOfa1] <= a2[indexOfa2]) {
                ret[--indexOfRet] = a2[indexOfa2--];
            } else {
                ret[--indexOfRet] = a1[indexOfa1--];
            }
        }
        while (indexOfa1 >= 0) {
            ret[--indexOfRet] = a1[indexOfa1--];
        }
        while (indexOfa2 >= 0) {
            ret[--indexOfRet] = a2[indexOfa1--];
        }

        return ret;
    }

    /*
    替换字符串中的空格
     */
    public String replaceBlank(String string, String replacement) {
        char[] origin = string.toCharArray();
        char[] rep = replacement.toCharArray();
        int length = replacement.length();
        int count = 0;
        for (char c : origin) {
            if (c == ' ') {
                count++;
            }
        }
        char[] result = new char[origin.length + count * (length - 1)];
        int indexOfResult = result.length - 1;
        int indexOfOrigin = origin.length - 1;
        while (indexOfOrigin >= 0 && indexOfResult >= 0) { //&& indexOfResult > indexOfOrigin) {
            if (origin[indexOfOrigin] == ' ') {
                for (int i = rep.length - 1; i >= 0; i--) {
                    result[indexOfResult--] = rep[i];
                }


            } else {
                result[indexOfResult--] = origin[indexOfOrigin];
            }
            --indexOfOrigin;
        }

        return new String(result);
    }

    /*
    在二维数组中查找数字是否存在，二维数组横向纵向递增。
    时间复杂度O(n)
     */
    public boolean findNum(int[][] nums, int num) {
        if (nums == null) {
            return false;
        }
        //坐标从右上角开始
        int rows = 0;
        int cols = nums[0].length - 1;
        //当横坐标大于等于0，纵坐标小于总的行数
        while (rows < nums.length && cols >= 0) {
            if (nums[rows][cols] == num) {    //若果找到数字则返回
                return true;
            }
            if (nums[rows][cols] > num) { //如果右上角的数字大于要找的数字，说明该列的数字都大于要找的数，可以直接剔除该列
                --cols;
            } else {  //否则说明这一行的数字都小于要找的数字，剔除该行
                ++rows;
            }
        }
        return false;

    }


    /*
    查找字符串中第一个只出现一次的字符
    时间复杂度O(n)
     */
    public Character firstNotRepeatingChar(String string) {
        if (string == null) {
            return null;
        }

        char[] chars = string.toCharArray();    //先将字符串转成字符数组
        Map<Character, Integer> map = new HashMap<>();   //key为字符，value是字符出现的次数
        for (char c : chars) {
            if (map.containsKey(c)) { //如果map中已经存在字符
                int i = map.get(c) + 1; //取出字符对应的value并加1
                map.replace(c, i); //替换原来的value
            } else {
                map.put(c, 1);   //map中没有则将value置为1
            }
        }
        for (char c : chars) {
            if (map.get(c) == 1) //遍历字符数组，在map中对应的value值大于1的就是重复的字符
                return c;
        }

        return null;
    }

    /*
    查找字符串中第一个只出现一次的字符，
    使用自制hash表,意思就是将每个字符映射成一个数字，字符作为下标，值作为出现的次数
    空间复杂度:O(1)
    时间复杂度:O(n)
     */
    public Character firstNotRepeatingChar2(String string) {
        if (string == null) return null;
        char[] chars = string.toCharArray();
        int[] hashtable = new int[256]; //因char是8位，最多有256种可能
        for (char c : chars) {  //
            hashtable[c]++;
        }
        for (char c : chars) {
            if (hashtable[c] == 1) return c;
        }

        return null;
    }

    /*
    数组中重复的数字,数组长度为n，数字范围是0~n-1
    使用额外的空间版
     */
    public Integer duplicateNUm(int[] nums) {
        if (nums == null) return null;
        int[] hashtable = new int[nums.length];
        for (int i = 0; i < hashtable.length; i++) {
            hashtable[i] = 0;
        }

        for (int i : nums) {
            hashtable[i]++;
        }

        for (int i : nums) {
            if (hashtable[i] > 1) return i;
        }

        return null;
    }

    /*
    数组中重复的数字,数组长度为n，数字范围是0~n-1
    不适用额外的空间
     */
    public Integer duplicateNUm2(int[] nums) {
        if (nums == null) return null;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums.length - 1 || nums[i] < 0) {
                Log.loggerInfo("数组中有数字超过给定范围");
                return null;
            }
        }
        for (int i = 0; i < nums.length; i++) {  //从第一位开始遍历数组
            while (i != nums[i]) {    //当下标i不等于该位置上的数字nums[i]
                if (nums[i] == nums[nums[i]]) {   //如果下标i上的数字nums[i]，和以下标上的数字nums[i]为下标的数字nums[nums[i]]相等，说明nums[i]重复
                    return nums[i];
                }
                //否则交换下标i和下标nums[i]上的数字
                int temp = nums[nums[i]];  //先把下标nums[i]上的数字给temp比较直观
                nums[nums[i]] = nums[i];
                nums[i] = temp;

            }
        }
        return null;
    }

    /*
    查找数组中任意一个重复的数字，数组长度为n+1，数组元素范围1~n,可见至少有一个数字重复
    要求不修改原来的数组
     */
    public Integer duplicateNUm3(int[] nums) {
        if (nums == null) {
            Log.loggerInfo("the array is null");
            return null;
        }
        for (int n : nums) {
            if (n < 1 || n > nums.length) {
                Log.loggerInfo("there is a number out of range in the array");
                return null;
            }
        }
        int start = 1;  //数组中数字的最小范围
        int end = nums.length - 1;  //数组中数字的最大范围
        while (end >= start) {  //当取值范围没有相遇时
            int mid = ((end - start) >> 1) + start; //取数字范围中间的数作为分界线
            int count = countRange(nums, start, mid);   //遍历数组，得到前半部分范围的数字在数组中出现的次数
            if (end == start) { //当最后范围只有两个数的时候
                if (count > 1) {    //如果统计次数大于1，
                    return start;   //返回
                } else {
                    Log.loggerInfo("not found duplicate number");
                    break;
                }
            }
            if (count > mid - start + 1) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return null;
    }

    /*
    统计某个范围的数字在数组中一共出现几次
     */
    public int countRange(int[] nums, int start, int end) {
        if (nums == null) {
            return 0;
        }
        int count = 0;
        for (int n : nums) {
            if (n >= start && n <= end) {
                ++count;
            }
        }
        return count;
    }


}
