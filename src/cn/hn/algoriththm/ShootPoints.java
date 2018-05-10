package cn.hn.algoriththm;


import java.util.HashMap;
import java.util.Map;

public class ShootPoints{
    public static void main(String [] args) {

//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        String stringForX = in.nextLine();
//        String stringForY = in.nextLine();
//
        int n = 50;
        String stringForX = "-1000000 1000000 -1000000 1000000 559207 551955 432768 -290103 -166745 -567532 -572722 -845187 47839 998769 494597 119717 -139142 620183 -403443 874225 -644444 -995886 -305110 -257754 -264533 -70033 984175 -835702 229443 -636536 -451901 -903998 125168 -353969 -701730 -893016 318057 -892351 152945 39886 -889372 -2773 -553253 -88633 -65488 764260 721269 -949974 -368557 -80176";
        String stringForY = "999999 1000000 -999999 -1000000 15520 655814 332224 -668340 -697479 674804 -764397 -266297 -471222 -118868 -134201 643745 100215 -373448 690941 477028 -308064 -200567 -9706 -550271 19852 -317050 -437959 -53049 -829572 816570 -395103 587437 284732 322344 213886 -313419 439278 -695295 -745400 -942659 898260 -369283 -525997 -469593 335157 -672090 -718547 -34248 923139 466116";

        int[] intForX = new int[n];
        int[] intForY = new int[n];
        int index = 0;
        for (String s :
                stringForX.split(" ")) {
            if (!s.equals("")) {
                intForX[index++] = Integer.parseInt(s);
            }
        }
        index = 0;
        for (String s :
                stringForY.split(" ")) {
            if (!s.equals("")) {
                intForY[index++] = Integer.parseInt(s);
            }
        }

        int max = 0;
        for(int i = 0; i < n; i++) {
            int[] tempX = new int[n];
            int[] tempY = new int[n];
            //将原点移到点(intForX[i],intForY[i])
            for (int j = 0;j < n; j++) {
                tempX[j] = intForX[j] - intForX[i];
                tempY[j] = intForY[j] - intForY[i];
            }
            int newMax = maxPointsHelper(n, tempX, tempY);
            max = max > newMax ? max : newMax;

        }
        System.out.println(max);


    }

    private static int maxPointsHelper(int n, int[] intForX, int[] intForY) {
        Map<Double, Helper> mapOfK = new HashMap<>();

        int countOf00 = 0;
        int countOfXY = 0;
        //统计所有点的斜率
        for (int i = 0;i < n; i++) {
            //原点的点
            if (intForX[i] == 0 && intForY[i] == 0) {
                countOf00 ++;
                continue;
            }
            //除了原点的xy轴上的点
            if ((intForX[i] == 0 && intForY[i] != 0) || (intForY[i] == 0 && intForX[i] != 0)) {
                countOfXY++;
                continue;
            }
            double k = intForY[i] * 1.0 / intForX[i];
            if (mapOfK.containsKey(k)) {
                mapOfK.get(k).addOne();

            } else {
                mapOfK.put(k, new Helper(intForX[i] ,intForY[i]));
            }

        }

        //找出斜率互为负倒数的合并
        int max = countOfXY;
        for (double d :
                mapOfK.keySet()) {
            Helper helper = mapOfK.get(d);
            if (helper.count != 0) {
                double another = -helper.x/helper.y;
                if (mapOfK.keySet().contains(another)) {
                    helper.count += mapOfK.get(another).count;
                    mapOfK.get(another).count = 0;//标记为已经读取过
                }
                if (helper.count > max) {
                    max = helper.count;
                }

            }

        }

//        System.out.println(max + countOf00);
        return max+countOf00;
    }

    static class Helper {
        int x;
        int y;
        int count;

        public Helper(int x, int y) {
            this.x = x;
            this.y = y;
            this.count = 1;
        }

        void addOne() {
            this.count++;
        }
    }

}