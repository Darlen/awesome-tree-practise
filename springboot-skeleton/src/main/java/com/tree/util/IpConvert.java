package com.tree.util;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

/**
 * @ClassName com.tree.util
 * Description: <类功能描述>. <br>
 * <p>
 * <使用说明>
 * </p>
 * @Author tree
 * @Date 2018/4/8 00:18
 * @Version 1.0
 */
public class IpConvert extends ClassicConverter {
    @Override
    public String convert(ILoggingEvent event) {
        String ip = "10.10.10.10";
        return ip;
    }
}
