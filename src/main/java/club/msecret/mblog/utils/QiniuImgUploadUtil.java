package club.msecret.mblog.utils;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

import java.io.InputStream;

public class QiniuImgUploadUtil {

    /*
    * 对应项可以查看 https://blog.csdn.net/weixin_37264997/article/details/82285343
    * */

    private String accessKey = "your access key";
    private String secretKey = "your secret key";
    private String bucket = "your bucket name";
    private static final String DOMAIN = "your default domain";


    public String imgUpload(InputStream file, String filename) {
        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration();
        //...其他参数参考类注释

        UploadManager uploadManager = new UploadManager(cfg);
        //...生成上传凭证，然后准备上传


        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = filename;

        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);

        try {
            Response response = uploadManager.put(file, key, upToken, null, null);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            if (response.isOK()) {
                return DOMAIN + "/" + filename ;
            }
            System.out.println(putRet.key);
            System.out.println(putRet.hash);
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }
        return "error";
    }
}
