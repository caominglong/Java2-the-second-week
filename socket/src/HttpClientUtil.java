

import org.apache.commons.io.IOUtils;
        import org.apache.hc.client5.http.classic.methods.HttpGet;
        import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
        import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
        import org.apache.hc.client5.http.impl.classic.HttpClients;

        import java.io.IOException;
        import java.io.InputStream;

public class HttpClientUtil {
    // 声明GET/POST静态常量

    public static void main(String[] args) {
        // 创建HttpClient对象
        CloseableHttpClient client = HttpClients.createDefault();
        // 声明请求的url，并构造HttpGet请求
        String url = "http://localhost:8801";
        HttpGet get = new HttpGet(url);
        // 用HttpClient去发送get请求，得到响应。
        try {
            CloseableHttpResponse response = client.execute(get);
            // 提取响应正文，并打印到控制台
            InputStream is = response.getEntity().getContent();
            String ret = IOUtils.toString(is, "GBK");
            System.out.println(ret);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}