package cn.hn.utils;

/**
 * Created by huangning on 2017/10/21.
 */
public class StringUtils {
    public static boolean isEmpty(String string){
        if(string == null || string == ""){
            return true;
        }

        return false;
    }
}
