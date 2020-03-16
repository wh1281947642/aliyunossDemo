package com.itheima.demo;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * <p>
 * <code>TestFileUpload</code>
 * </p>
 * 阿里云oos文件上传
 * @author huiwang45@iflytek.com
 * @description
 * @date 2020/03/16 16:49
 */
public class TestFileUpload {
    
    /**
     * 上传文件流
     * @description
     * @author huiwang45@iflytek.com
     * @date 2020/03/16 16:53
     * @param
     * @return 
     */
    public static void  uploadFileByInputStream(){

        //上传文件的路径
        String filePath = "F:\\heima\\upload\\spring.jpg";
        //存储地址名称
        String bucketName="wh-qingchengdianshang";
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://oss-cn-beijing.aliyuncs.com";
        // 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。
        String accessKeyId = "LTAI4FeY7Wtfht4dz38HL5Nw";
        String accessKeySecret = "DvLkqsEmGI4zMXr9bzW20dWD5UqFls";

        // 创建OSSClient实例。
        OSS ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

        // 上传文件流。
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(filePath);
            ossClient.putObject(bucketName, "spring.jpg", inputStream);
            System.out.println("文件上传成功！");
        } catch (FileNotFoundException e) {
            System.out.println("文件上传失败!");
            e.printStackTrace();
        }finally {
            if(inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            // 关闭OSSClient。
            ossClient.shutdown();
        }
    }

    public static void main(String[] args) {
        uploadFileByInputStream();
    }
}
