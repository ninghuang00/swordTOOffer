package cn.hn.pinduoduo;

import cn.hn.pinduoduo.impl.PaintBlue;
import cn.hn.pinduoduo.impl.PaintRed;

/**
 * Created by huangning on 2018/8/19.
 */
public enum Color {
    RED(new PaintRed()),
    Blue(new PaintBlue());


    Paint paint;


    Color(Paint paint) {
        this.paint = paint;
    }

    public Paint getPaint(){
        return paint;
    }

}
