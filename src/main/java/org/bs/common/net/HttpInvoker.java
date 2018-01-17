package org.bs.common.net;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContexts;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManagerFactory;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.Map;

public class HttpInvoker
{
    private static final String LINE = System.getProperty("line.separator");

    private static final String CHARSET_NAME = "UTF-8";

    private HostnameVerifier hostnameVerifier;

    private String interfaceName;

    private boolean isHttps = false;

    /**
     * 创建HTTP/HTTPS客户端（单向不认证）
     */
    HttpInvoker(String interfaceName, boolean isHttps)
    {
        hostnameVerifier = new NoAuthHostnameVerifier();
        this.interfaceName = interfaceName;
        this.isHttps = isHttps;

        if (isHttps && !org.bs.common.net.cache.SslContextCache.containInterfaceName(interfaceName))
        {
            // trust all CA that self signed
            SSLContext sslContext = null;
            try
            {
                sslContext = SSLContexts.custom().loadTrustMaterial(null, new TrustSelfSignedStrategy()).build();
                org.bs.common.net.cache.SslContextCache.putSslContext(interfaceName, sslContext);
            } catch (Exception e)
            {
                // err log
                e.printStackTrace();
            }
        }
    }

    /**
     * 创建单向的
     *
     * @return
     */
    HttpInvoker(String interfaceName, byte[] cerFile, boolean forceUpdate)
    {
        hostnameVerifier = new NoAuthHostnameVerifier();
        this.interfaceName = interfaceName;
        this.isHttps = true;

        // 如果强制更新则直接更新context，否则判断不存在才更新
        if (forceUpdate || !org.bs.common.net.cache.SslContextCache.containInterfaceName(interfaceName))
        {
            // trust all self signed CA
            SSLContext sslContext = null;
            try
            {
                sslContext = getOneWayAuthSSLContext(cerFile);
                org.bs.common.net.cache.SslContextCache.putSslContext(interfaceName, sslContext);
            } catch (Exception e)
            {
                // err log
                e.printStackTrace();
            }
        }
    }

    /**
     * 创建双向的
     */
    HttpInvoker(String interfaceName, byte[] keystoreFile, String fileType, String passwd, boolean forceUpdate)
    {
        hostnameVerifier = new NoAuthHostnameVerifier();
        this.interfaceName = interfaceName;
        this.isHttps = true;

        // 如果强制更新则直接更新context，否则判断不存在才更新
        if (forceUpdate || !org.bs.common.net.cache.SslContextCache.containInterfaceName(interfaceName))
        {
            // trust all self signed CA
            SSLContext sslContext = null;
            try
            {
                sslContext = getTwoWayAuthSSLContext(keystoreFile, fileType, passwd);
                org.bs.common.net.cache.SslContextCache.putSslContext(interfaceName, sslContext);
            } catch (Exception e)
            {
                // err log
                e.printStackTrace();
            }
        }
    }

    private SSLContext getOneWayAuthSSLContext(byte[] cerFile)
            throws Exception
    {
        SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
        TrustManagerFactory trustManagerFactory =
                TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());

        trustManagerFactory.init(getOneWayAuthKeyStore(cerFile));
        sslContext.init(null, trustManagerFactory.getTrustManagers(), new SecureRandom());

        return sslContext;
    }

    private KeyStore getOneWayAuthKeyStore(byte[] cerFile)
            throws Exception
    {
        InputStream ins = null;

        try
        {
            ins = new ByteArrayInputStream(cerFile);

            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            Certificate cer = certificateFactory.generateCertificate(ins);

            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null);
            keyStore.setCertificateEntry("trust", cer);
            return keyStore;
        } finally
        {
            IOUtils.closeQuietly(ins);
        }
    }

    private SSLContext getTwoWayAuthSSLContext(byte[] file, String fileType, String passwd)
            throws Exception
    {
        InputStream ins = null;
        KeyStore keyStore = null;

        try
        {
            keyStore = KeyStore.getInstance(fileType);
            ins = new ByteArrayInputStream(file);
            keyStore.load(ins, passwd.toCharArray());
            return SSLContexts.custom().loadKeyMaterial(keyStore, passwd.toCharArray()).build();
        } finally
        {
            IOUtils.closeQuietly(ins);
        }
    }

    private CloseableHttpClient getHttpClient()
    {
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        Registry<ConnectionSocketFactory> registry =
                RegistryBuilder.<ConnectionSocketFactory>create()
                        .register("http", PlainConnectionSocketFactory.INSTANCE)
                        .build();

        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager(registry);

        // max connection
        cm.setMaxTotal(2000);
        httpClientBuilder.setConnectionManager(cm);

        return httpClientBuilder.build();
    }

    private CloseableHttpClient getHttpsClient()
    {
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();

        SSLContext sslContext = org.bs.common.net.cache.SslContextCache.getSslContext(interfaceName);

        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext,
                new String[]{"TLSv1", "TLSv1.1", "TLSv1.2"},
                null,
                hostnameVerifier);

        Registry<ConnectionSocketFactory> registry =
                RegistryBuilder.<ConnectionSocketFactory>create()
                        .register("https", PlainConnectionSocketFactory.INSTANCE)
                        .build();

        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager(registry);

        // max connection
        cm.setMaxTotal(2000);
        httpClientBuilder.setConnectionManager(cm);

        return httpClientBuilder.build();
    }

    private CloseableHttpClient getClient()
    {
        return (isHttps) ? getHttpsClient() : getHttpClient();
    }

    /**
     * 发送POST
     */
    public HttpResponse doPost(String url, Map<String, String> headers, String body)
            throws IOException
    {
        HttpPost post = new HttpPost(url);

        if (null != headers && headers.size() > 0)
        {
            for (Map.Entry<String, String> header : headers.entrySet())
            {
                post.addHeader(header.getKey(), header.getValue());
            }
        }

        post.setEntity(new ByteArrayEntity(body.getBytes(CHARSET_NAME)));

        return doPost(post);
    }

    /**
     * 发送POST
     */
    public HttpResponse doPost(HttpPost post)
            throws IOException
    {
        CloseableHttpClient client = getClient();

        return client.execute(post);
    }

    /**
     * 双向认证的keystore的类型
     */
    public interface KeyStoreType
    {
        String KEY_STORE_P12 = "PCKS12";
        String KEY_STORE = "JKS";
    }

    /**
     * 不校验服务端的HostnameVerifier
     */
    private static class NoAuthHostnameVerifier implements HostnameVerifier
    {
        @Override
        public boolean verify(String s, SSLSession sslSession)
        {
            return true;
        }
    }


}
