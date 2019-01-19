package com.zn.sitegroup.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import okhttp3.CacheControl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * 上传文件到指定站点
 * Created by zn on 2018/12/21.
 */
@Slf4j
public class UploadFileService {
    /**
     *
     * @param url
     * @param filePath
     * @param fileName
     * @formdatas: 表单数据，这里暂时未 站点数据库服务器ip和端口
     * @return
     */
    public ResponseBody upload(String url, String filePath, String fileName,String siteDbIp,String siteDbPort) {
        OkHttpClient client = new OkHttpClient().newBuilder().connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(5,TimeUnit.MINUTES).build();

        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("upload_sql","upload_sql")
                .addFormDataPart("db_ip",siteDbIp)
                .addFormDataPart("db_port",siteDbPort)
                .addFormDataPart("file", fileName,
                        RequestBody.create(MediaType.parse("multipart/form-data"), new File(filePath)))
                .build();
        Request request = new Request.Builder()
                .header("Authorization", "Client-ID " + UUID.randomUUID())
                .cacheControl(new CacheControl.Builder().noStore().build())
                .url(url)
                .post(requestBody)
                .build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            return response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
