package org.bs.common.net.cache;

import org.apache.commons.lang.StringUtils;

import javax.net.ssl.SSLContext;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public final class SslContextCache
{
    private static final Map<String, SSLContext> sslContextMap = new ConcurrentHashMap<>();

    /**
     * 获取接口的sslContext
     */
    public static SSLContext getSslContext(String interfaceName)
    {
        if (StringUtils.isEmpty(interfaceName))
        {
            // err log
        }
        return sslContextMap.get(interfaceName);
    }

    /**
     * 新增或者刷新接口的ssl缓存
     */
    public static void putSslContext(String interfaceName, SSLContext sslContext)
    {
        sslContextMap.put(interfaceName, sslContext);
    }

    /**
     * 接口的ssl缓存是否存在
     */
    public static boolean containInterfaceName(String interfaceName)
    {
        return sslContextMap.containsKey(interfaceName);
    }
}
