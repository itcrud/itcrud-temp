package com.itcurd.temp.util;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.pattern.color.ANSIConstants;
import ch.qos.logback.core.pattern.color.ForegroundCompositeConverterBase;

/**
 * @Author: YANGBAO352
 * @Date: 2018/12/13
 * @Desc: 自定义logback颜色
 */
public class CustomLogColor extends ForegroundCompositeConverterBase<ILoggingEvent> {

    @Override
    protected String getForegroundColorCode(ILoggingEvent iLoggingEvent) {
        Level level = iLoggingEvent.getLevel();
        switch (level.toInt()) {
            case Level.INFO_INT:
                return ANSIConstants.GREEN_FG;
            case Level.WARN_INT:
                return ANSIConstants.YELLOW_FG;
            case Level.ERROR_INT:
                return ANSIConstants.RED_FG;
            default:
                return ANSIConstants.DEFAULT_FG;
        }
    }
}