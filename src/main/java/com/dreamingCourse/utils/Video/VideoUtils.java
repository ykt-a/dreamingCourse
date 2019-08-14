package com.dreamingCourse.utils.Video;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

//import static com.dreamingCourse.util.Contants.targetfolder;

public class VideoUtils {

    /**
     * @author wuad
     */
        private String sourceVideoPath;							//源视频路径
        private String filerealname;				 			//文件名不包括后缀名
        private String filename; 								//包括后缀名
        private  String ffmpegpath;                           // ffmpeg.exe的目录

        public static  String targetfolder;


    //重构构造方法，传入源视频
        public VideoUtils(String path) {
            sourceVideoPath = path;
        }

        //set和get方法传递path
        public String getPATH() {
            return sourceVideoPath;
        }

        public void setPATH(String path) {
            sourceVideoPath = path;
        }

        /**
         * 转换视频格式
         * @param  targetExtension 目标视频后缀名 .xxx
         * @return
         */
        public boolean beginConver(String targetExtension, boolean isDelSourseFile) {
            File fi = new File(sourceVideoPath);
            //获取视频名+后缀名
            filename = fi.getName();

            //获取不带后缀的文件名-后面加.toLowerCase()小写（filerealname：视频名称）
            filerealname = filename.substring(0, filename.lastIndexOf("."));

            //System.out.println("----接收到文件("+filerealname+")需要转换-------");

            //执行转码机制
           if (process(targetExtension,isDelSourseFile)) {

             //   System.out.println("视频转码结束=============== ");

                sourceVideoPath = null;
                return true;
            } else {
                sourceVideoPath = null;
                return false;
            }
        }





        /**
         * 实际转换视频格式的方法
         * @param targetExtension 目标视频后缀名
         * @param isDelSourseFile 转换完成后是否删除源文件
         * @return
         */
        private boolean process(String targetExtension, boolean isDelSourseFile) {

            //先判断视频的类型-返回状态码
            int type = checkContentType();
            boolean status = false;

            // 根据状态码处理
            if (type == 0) {
                System.out.println("ffmpeg可以转换,统一转为mp4文件");
                // 可以指定转换为什么格式的视频
                status = processVideoFormat(sourceVideoPath,targetExtension,isDelSourseFile);
            }
            return status;   //执行完成返回布尔类型true
        }

        /**
         * 检查文件类型，判断ffmpeg能否转换
         * @return
         */
        private int checkContentType() {

            //取得视频后缀-
            String type = sourceVideoPath.substring(sourceVideoPath.lastIndexOf(".") + 1, sourceVideoPath.length()).toLowerCase();
            //System.out.println("源视频类型为:"+type);

            // 如果是ffmpeg能解析的格式:(asx，asf，mpg，wmv，3gp，mp4，mov，avi，flv等)
            if (type.equals("avi")) {
                return 0;
            } else if (type.equals("mpg")) {
                return 0;
            } else if (type.equals("wmv")) {
                return 0;
            } else if (type.equals("3gp")) {
                return 0;
            } else if (type.equals("mov")) {
                return 0;
            } else if (type.equals("mp4")) {
                return 0;
            } else if (type.equals("asf")) {
                return 0;
            } else if (type.equals("asx")) {
                return 0;
            } else if (type.equals("flv")) {
                return 0;
            }else if (type.equals("mkv")) {
                return 0;
            }
            System.out.println("上传视频格式异常");
            return 9;
        }


        /**
         * 转换为指定格式
         * ffmpeg能解析的格式：（asx，asf，mpg，wmv，3gp，mp4，mov，avi，flv等）
         * @param oldfilepath
         * @param targetExtension 目标格式后缀名 .xxx
         * @return
         */
        private boolean processVideoFormat(String oldfilepath, String targetExtension, boolean isDelSourceFile) {



            // ffmpeg.exe的目录
            ClassLoader classLoader = Thread.currentThread()
                    .getContextClassLoader();
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
            String path = SERVLET_CONTEXT_PATH + "/" + "WebRoot\\tools\\ffmpeg.exe";
            path = path.replaceAll("%20", " ");

            ffmpegpath=path;
             targetfolder = SERVLET_CONTEXT_PATH + "/" + "WebRoot\\video\\";
            targetfolder = targetfolder.replaceAll("%20", " ");


            //System.out.println("这里调用了ffmpeg.exe工具");
            //System.out.println("----开始转文件(" + sourceVideoPath + ")-------------------------- ");

            List<String> commend = new ArrayList<String>();

            commend.add(ffmpegpath);		 //ffmpeg.exe工具地址
            commend.add("-i");
            commend.add(oldfilepath);			//源视频路径

            commend.add("-vcodec");
            commend.add("h263");  //
            commend.add("-ab");		//新增4条
            commend.add("128");      //高品质:128 低品质:64
            commend.add("-acodec");
            commend.add("mp3");      //音频编码器：原libmp3lame
            commend.add("-ac");
            commend.add("2");       //原1
            commend.add("-ar");
            commend.add("22050");   //音频采样率22.05kHz
            commend.add("-r");
            commend.add("29.97");  //高品质:29.97 低品质:15
            commend.add("-c:v");
            commend.add("libx264");	//视频编码器：视频是h.264编码格式
            commend.add("-strict");
            commend.add("-2");
            commend.add(targetfolder + filerealname + targetExtension);  // //转码后的路径+名称，是指定后缀的视频

            System.out.println("--------------------------------------------------------------"+targetfolder + filerealname + targetExtension);

            //打印命令
            StringBuffer test = new StringBuffer();
            for (int i = 0; i < commend.size(); i++) {
                test.append(commend.get(i) + " ");
            }
            //System.out.println("ffmpeg输入的命令:"+test);

            try {
                //多线程处理加快速度-解决rmvb数据丢失builder名称要相同
                ProcessBuilder builder = new ProcessBuilder();
                builder.command(commend);
                Process p = builder.start();   //多线程处理加快速度-解决数据丢失

                final InputStream is1 = p.getInputStream();
                final InputStream is2 = p.getErrorStream();
                new Thread() {
                    public void run() {
                        BufferedReader br = new BufferedReader(
                                new InputStreamReader(is1));
                        try {
                            String lineB = null;
                            while ((lineB = br.readLine()) != null) {
                                if (lineB != null)
                                    System.out.println(lineB);    //必须取走线程信息避免堵塞
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
                new Thread() {
                    public void run() {
                        BufferedReader br2 = new BufferedReader(
                                new InputStreamReader(is2));
                        try {
                            String lineC = null;
                            while ((lineC = br2.readLine()) != null) {
                                if (lineC != null)
                                    System.out.println(lineC);    //必须取走线程信息避免堵塞
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }.start();

                p.waitFor();		//进程等待机制，必须要有，否则不生成mp4！！！
              //  System.out.println("生成mp4视频为:"+ filerealname + ".mp4");
                return true;
            }
            catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }



}
