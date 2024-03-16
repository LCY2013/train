package org.fufeng.train.common.util;

import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;

/**
 * 雪花ID生成器
 *
 * @author fufeng
 * @Date 2024-03-16 17:11
 */
public class SnowUtil {

    private static long dataCenterId = 1;  //数据中心
    private static long workerId = 1;     //机器标识

    static {
        String ip = NetUtil.localIpv4s().stream().
                filter(ipAddress ->
                        !NetUtil.isInnerIP(ipAddress)).findFirst().orElse("192.168.0.1");
        workerId = NetUtil.ipv4ToLong(ip)%32;
    }

    public static long getSnowflakeNextId() {
        return IdUtil.getSnowflake(workerId, dataCenterId).nextId();
    }

    public static String getSnowflakeNextIdStr() {
        return IdUtil.getSnowflake(workerId, dataCenterId).nextIdStr();
    }

}
