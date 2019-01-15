package com.zn.sitegroup.utils;

/**
 * Created by zn on 2019/1/15.
 * 序列相关的工具类，目前只封装了SnowFlake的调用
 */
public class SequenceUtil {
    private static final SnowFlake snowFlake = new SnowFlake(1,2);

    /**
     * 得到一个唯一序列
     * @return 返回一个long类型的唯一序列，改序列采用SnowFlake算法。
     */
    public static long sequence() {
        return snowFlake.nextId();
    }
}
