/**
 * Create with IntelliJ IDEA
 * Project name : user-center
 * Package name :
 * Author : Wukunmeng
 * User : wukm
 * Date : 16-12-13
 * Time : 上午11:36
 * ---------------------------------
 * To change this template use File | Settings | File and Code Templates.
 */

import ch.qos.logback.core.ConsoleAppender
import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.core.rolling.RollingFileAppender
import ch.qos.logback.core.rolling.TimeBasedRollingPolicy

import static ch.qos.logback.classic.Level.INFO
import static ch.qos.logback.classic.Level.DEBUG

StringBuilder p = new StringBuilder();
//%clr(%d{yyyy-MM-dd HH:mm:ss.SSS}){faint} %clr(${LOG_LEVEL_PATTERN:-%5p}) %clr(${PID:- }){magenta} %clr(---){faint} %clr([%15.15t]){faint} %clr(%-40.40logger{39}){cyan} %clr(:){faint} %m%n${LOG_EXCEPTION_CONVERSION_WORD:-%wEx}
p.append("Commons %d{yyyy-MM-dd/HH:mm:ss}");
p.append(" %-5p ");
if(System.getProperty("PID")){
    p.append("pid-" + System.getProperty("PID"))
} else {
    p.append("pid-")
}
p.append(" --- [%X] ")
p.append(" --- [%15.15t] ")
p.append(" %-40.40logger{39} ")
p.append("%-40.40class{39} %-5.5line ");
p.append("%m%n");
def USER_DIR = System.getProperty("user.dir");
def product = System.getProperty("product","false");
Boolean isLog = Boolean.parseBoolean(product);
appender("CONSOLE", ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        pattern = p.toString();
    }
}

if(isLog) {
    appender("FILE", RollingFileAppender) {
        file = "${USER_DIR}/log/user_center.log"
        rollingPolicy(TimeBasedRollingPolicy){
            fileNamePattern = "${USER_DIR}/log/user_center_%d{yyyy_MM_dd}.log"
            maxHistory = 60
        }
        //append = true
        //prudent = true
        encoder(PatternLayoutEncoder) {
            pattern = p.toString();
        }
    }
}
logger("org.springframework", INFO,["CONSOLE"])
if(isLog) {
    logger("com.vmovier.user.center.mapper", DEBUG, ["CONSOLE","FILE"])
    root(INFO, ["CONSOLE","FILE"])
} else {
    logger("com.vmovier.user.center.mapper", DEBUG, ["CONSOLE"])
    root(INFO, ["CONSOLE"])
}