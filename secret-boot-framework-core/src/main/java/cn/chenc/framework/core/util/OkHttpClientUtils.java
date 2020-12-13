package cn.chenc.framework.core.util;

import okhttp3.*;

import java.io.IOException;

/**
 * 　@description: okHttpClient封装工具类
 * 　@author 陈_C
 * 　@date 2020/8/21 14:27
 *
 */
public class OkHttpClientUtils {
    public static final MediaType type= MediaType.parse("application/x-www-form-urlencoded;charset=utf-8");
    public static final OkHttpClient httpClient= new OkHttpClient();

    /**
     * @description: get请求
     * @param url
     * @return java.lang.String
     * @throws
     * @author secret
     * @date 2020/12/12 secret
     */
    public static String httpGet(HttpUrl url) throws IOException{
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response=httpClient.newCall(request).execute();
        return response.body().string();
    }

    /**
     * @description: post请求
     * @param url
     * @param content
     * @return java.lang.String
     * @throws
     * @author secret
     * @date 2020/12/12 secret
     */
    public static String httpPost(HttpUrl url,String content) throws IOException{
        RequestBody requestBody= RequestBody.create(type,content);
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        Response response=httpClient.newCall(request).execute();
        return response.body().string();
    }

}
