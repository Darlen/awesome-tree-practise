package com.tree.util;

import ch.qos.logback.classic.PatternLayout;

/**
 * @ClassName com.tree.util
 * Description: <类功能描述>. <br>
 * <p>
 * <使用说明>
 * </p>
 * @Author tree
 * @Date 2018/4/8 00:21
 * @Version 1.0
 */
public class MyPatternLayout extends PatternLayout {
    static {
        defaultConverterMap.put("ip",IpConvert.class.getName());
    }
}
