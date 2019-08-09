package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {
    //↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016101100658497";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCxcfeQXFOhDpiWrNrfFhGh0Qb2cgEPnriTADJxFFM0hW9vtynY88nlrg2iYg2teW+VLGSfTj3DeNFabBZrGfHUl4agAROnRmznh30PZpG2GT5TTz6yQltWRtOMUojHMa0saQQhoEHpaGhc+WTuAYXAaY1LZ/CKCSAeBfgBYVgovPeMIyiGrlTUHEsC4XChQmQBnSSHbK6P0DMaH+nvULlfdw5mX88hee1uEDqbrTIx0hPhpdzsWUsVjgCQj1UdEmeVyE1EO2cBHB5J+VBJFOAbFS6eWWX1EnYLCa7IP+SM+lEF8gszxpURoWYMc8TVndCfuyEZ9bGnAShyepI2DgDZAgMBAAECggEBAIB3KStLnIQyxAf6Fu+B07waT/cmLFx5pdlPQDWb6G1S2Y3Axrw6K4ZsT5SrdomMLFuMa0DmbVLSaocTT9u0Sd+G4EGA5hCprPimn8UBliaG+hdofNSjs+qvlkK2Ei5caaqIUSRjGLT6EOyW5hpl4cae5FueYYgd+TGjUpz1M9UxXSGlEpdRIWVdRmr9h0nzb7tmwF5dROGWuy3ldoFqre2x9fEzlCNZM5fg2j4AIgZCXcp+Ac0Ule7js5+aYdtewnia/vInsItzBfkfNwy2d6FWzW6NXW+CIViFTIB8nyCyaSyKo3+TIai5EMCUWDX3PNvzeMJ2GP4k+AZ7vOww33ECgYEA3HR1j8tF51VO3dyHdHcVEbwngR7mfW1By0SmDrni7/9dBJ2jrYf7Bq7NML63bAF+pgNDLZGLWpCDeKyHONmz4Q4O5Cn6lSAa9iM2pTG9SDiQq4Mh5E0k6qOI6c+oToombK3tUWjap+vmbgU66UJumVyoD9RqgpPunwONXsfnfTUCgYEAzg46wJNf9rdcGyGoX+ieLNwe5W1LttjNTVgSChc+1qxbWORYoZCeSCgswoe0Llddlq+1zQ0QaBNsv2R+Mvf/CtTDlV8r++t8IlFur8DWvHvHmddMqCitcmXoaU2C2mnUhiDCQimhdNxsWpx3Yb+XosQmK0igEqIwJtxPiXeavZUCgYAiU+weePuomwsN1xIsm4JnYZIRNBuV+lZdbZIiBuYEkxIL7vQWyG7ZSozfA0OSiOUMusNSLDCz6H7gYpUn0BaHe+Xrt3GymO4515/ht04PGefFHUVAxJZ0BwUBy3kcybxT/f1PSPGLZltaVGwo+FQ6g0gUNvJi5OAqWKZB1QUB5QKBgQCztglbx60cehLkvtggvbqmmVyA8G/mivOTj0o8bsWpaS1KO+1pC75gZFmVV9G30Q6Yy6qdqdUzUC26RyUhwtU3VxU1g4nS7zCWpbsJogAm5zXQYMxEpSWQ7nxiyu1jHIX0bUG/fpuIVm5SIMCmCflwRe6cNX0Wg0nHusHLvPrCeQKBgGrQl+kHilPKX3QPnwtkC0Z8UNbSsP8ScuQ+RzNBchQmQ0mz4/CqU2lnsy7awiUcxei5og7OFyque83+G1L/OC8CTv4lCWedHJIYr8PtpdoJs59gpC9POQJfu4xKWHmnSdZZ55jCgUALZ4X64Fopgc7wlUYdDNCd7doZ56GL1B4e";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key ="\n" +
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAoqwoxtndpZnCBTkFqRyb3ZZb7QemrkEKtgLst/amA3L+3jBB04vugsx+8ikx5Ad+0aVXoMEYGF7zhtmX9TcAxXzUdQ4N9dIsDdPDy1vpmJFpQhrVs1tQEBMpPaM1jLLYyBDQYSLviYmn07/VUr8dROkp57ynOMRsXkHbQn0/ph4AL7UtLQ1I0FCkMTyBM85m8BhZkmQ+yFcC8I34RUHnNEz94pbCvz/gFmK+t6kFL1jq0PaY1d5pZBwvtlc7+h+DQpvQ5xAWeaUhlKdDCA21gHV0RtapvweM9MZnm0htZ3e+/vzE2D1/HR5qr5iBnbW7SLiOZi6yFpvyEKd24n8HCwIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://zjgj6h.natappfree.cc/order/alipay_callback.do";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://zjgj6h.natappfree.cc/order/alipay_callback.do";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String getApp_id() {
        return app_id;
    }

    public static void setApp_id(String app_id) {
        AlipayConfig.app_id = app_id;
    }

    public static String getMerchant_private_key() {
        return merchant_private_key;
    }

    public static void setMerchant_private_key(String merchant_private_key) {
        AlipayConfig.merchant_private_key = merchant_private_key;
    }

    public static String getAlipay_public_key() {
        return alipay_public_key;
    }

    public static void setAlipay_public_key(String alipay_public_key) {
        AlipayConfig.alipay_public_key = alipay_public_key;
    }

    public static String getNotify_url() {
        return notify_url;
    }

    public static void setNotify_url(String notify_url) {
        AlipayConfig.notify_url = notify_url;
    }

    public static String getReturn_url() {
        return return_url;
    }

    public static void setReturn_url(String return_url) {
        AlipayConfig.return_url = return_url;
    }

    public static String getSign_type() {
        return sign_type;
    }

    public static void setSign_type(String sign_type) {
        AlipayConfig.sign_type = sign_type;
    }

    public static String getCharset() {
        return charset;
    }

    public static void setCharset(String charset) {
        AlipayConfig.charset = charset;
    }

    public static String getGatewayUrl() {
        return gatewayUrl;
    }

    public static void setGatewayUrl(String gatewayUrl) {
        AlipayConfig.gatewayUrl = gatewayUrl;
    }

    public static String getLog_path() {
        return log_path;
    }

    public static void setLog_path(String log_path) {
        AlipayConfig.log_path = log_path;
    }
}
