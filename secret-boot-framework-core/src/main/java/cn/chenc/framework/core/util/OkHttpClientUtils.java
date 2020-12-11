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

    //get方法调用
    public static String httpGet(HttpUrl url) throws IOException{
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response=httpClient.newCall(request).execute();
        return response.body().string();
    }

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
