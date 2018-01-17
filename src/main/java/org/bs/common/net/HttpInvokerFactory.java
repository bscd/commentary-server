package org.bs.common.net;

public final class HttpInvokerFactory
{
    /**
     * 创建一个http客户端
     */
    public static HttpInvoker createHttpInvoker(String interfaceName)
    {
        return new HttpInvoker(interfaceName, false);
    }

    /**
     * 创建一个https客户端（不认证）
     */
    public static HttpInvoker createNoAuthHttpsInvoker(String interfaceName)
    {
        return new HttpInvoker(interfaceName, true);
    }

    /**
     * 创建一个https客户端（单向认证）
     */
    public static HttpInvoker createOneWayAuthHttpsInvoker(String interfaceName, byte[] cerFile)
    {
        return new HttpInvoker(interfaceName, cerFile, false);
    }

    /**
     * 创建一个https客户端（双向认证）
     */
    public static HttpInvoker createTwoWayAuthHttpsInvoker(String interfaceName, byte[] keyStoreFile,
                                                           String keyStoreType, String passwd)
    {
        return new HttpInvoker(interfaceName, keyStoreFile, keyStoreType, passwd, false);
    }
}
