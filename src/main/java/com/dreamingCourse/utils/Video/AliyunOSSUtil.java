package com.dreamingCourse.utils.Video;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.CreateBucketRequest;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Component
public class AliyunOSSUtil {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(AliyunOSSUtil.class);
    private String filerealname;				 			//文件名不包括后缀名
    private String filename; 								//包括后缀名

    public static String URL;                           //获取URL


    /** 上传文件*/
    public  String upLoad(File file){



        //获取视频名+后缀名
        filename = file.getName();
        //获取不带后缀的文件名-后面加.toLowerCase()小写（filerealname：视频名称）
        filerealname = filename.substring(0, filename.lastIndexOf("."));

        //进行转码
        VideoUtils zout=new VideoUtils(file.getPath());       //传入path
        System.out.println("=================1111111111111111111111111111111111111111============================="+file.getPath());
        String targetExtension = ".mp4";  				//设置转换的格式
        boolean isDelSourseFile = true;
        boolean beginConver = zout.beginConver(targetExtension,isDelSourseFile);

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        if (classLoader == null) {
            classLoader = ClassLoader.getSystemClassLoader();
        }
        /**
         * 获取到webroot里面的数据
         */
        java.net.URL url2 = classLoader.getResource("");
        String ROOT_CLASS_PATH = url2.getPath() + "/";
        File rootFile = new File(ROOT_CLASS_PATH);
        String WEB_INFO_DIRECTORY_PATH = rootFile.getParent() + "/";
        File webInfoDir = new File(WEB_INFO_DIRECTORY_PATH);
        String SERVLET_CONTEXT_PATH = webInfoDir.getParent() + "/";
        // 这里 SERVLET_CONTEXT_PATH 就是WebRoot的路径
        String path = SERVLET_CONTEXT_PATH + "/" + "WebRoot\\video\\";
        path = path.replaceAll("%20", " ");



        file=new File(path+filerealname+".mp4");
        System.out.println("------------------------------000000000000000000000000000000000000000000000----------------------------------------------"+path);
        logger.info("------OSS文件上传开始--------"+file.getName());


       String endpoint="oss-cn-shanghai.aliyuncs.com";
        System.out.println("获取到的Point为:"+endpoint);
        String accessKeyId="LTAIr6hTcdBA0slE";
        String accessKeySecret="YepUOJIs0Kq4Q5FAtPCifcrcANTGIP";
        String bucketName="szpba";
        String fileHost="file";
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        String dateStr=format.format(new Date());

        // 判断文件
        if(file==null){
            return null;
        }
        OSSClient client=new OSSClient(endpoint, accessKeyId, accessKeySecret);
        try {
            // 判断容器是否存在,不存在就创建
            if (!client.doesBucketExist(bucketName)) {
                client.createBucket(bucketName);
                CreateBucketRequest createBucketRequest = new CreateBucketRequest(bucketName);
                createBucketRequest.setCannedACL(CannedAccessControlList.PublicRead);
                client.createBucket(createBucketRequest);
            }
            // 设置文件路径和名称
            String fileUrl = fileHost + "/" + (dateStr + "/" + UUID.randomUUID().toString().replace("-", "") + "-" + file.getName());
            // 上传文件
            PutObjectResult result = client.putObject(new PutObjectRequest(bucketName, fileUrl, file));
            // 设置权限(公开读)
            client.setBucketAcl(bucketName, CannedAccessControlList.PublicRead);
            if (result != null) {
                logger.info("------OSS文件上传成功------" + fileUrl);
            }

            //删除文件
            file.delete();
            System.out.println("----------------------删除文件-------------------------"+file.delete());


            Date expiration = new Date(new Date().getTime() + 3600l * 1000 * 24 * 365 * 10);
            URL = client.generatePresignedUrl(bucketName, fileUrl,expiration).toString();
            System.out.println("-------------------------------------------------------------"+URL);
        }catch (OSSException oe){
            logger.error(oe.getMessage());
        }catch (ClientException ce){
            logger.error(ce.getErrorMessage());
        }finally{
            if(client!=null){
                client.shutdown();
            }
        }
        return null;
    }
}