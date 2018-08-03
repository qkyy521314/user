package com.baizhi.controller;

import com.baizhi.entity.ObjectPage;
import com.baizhi.entity.Picture;
import com.baizhi.service.PictureService;
import org.apache.commons.io.FilenameUtils;
import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * Created by DELL on 2018/1/11.
 */
@Controller
@RequestMapping("picture")
public class PictureController {
    @Resource
    private PictureService pictureService;
    @RequestMapping("queryAll")
    @ResponseBody
    public ObjectPage<Picture> queryAll(Integer page,Integer rows){

        List<Picture> list = pictureService.selectAll(page,rows);
        ObjectPage<Picture> picturePage = new ObjectPage<Picture>(list,pictureService.selectTotalCount());
        System.out.println(picturePage);
        return picturePage;
    }

    private String conf_filename="fastdfs.conf";
    //MultipartFile  接受传来的文件
    @RequestMapping("/up")
    @ResponseBody
    public String up(MultipartFile source) throws IllegalStateException, IOException {
        byte[] bytes =source.getBytes();

        //获取文件名
        String fileName = source.getOriginalFilename();
        System.out.println(fileName);
        //获取文件后缀
        String ext = FilenameUtils.getExtension(fileName);

        try {
            ClientGlobal.init(conf_filename);
            TrackerClient client = new TrackerClient();
            TrackerServer server = client.getConnection();
            StorageClient storageClient = new StorageClient(server, null);
            NameValuePair[] nameValuePairs = new NameValuePair[]{
                    new NameValuePair("id","100"),
                    new NameValuePair("name",fileName)};
            String[] file = storageClient.upload_file(bytes, ext, nameValuePairs);
            for (String s : file) {
                System.out.println(s);
            }
            Picture picture =new Picture(UUID.randomUUID().toString(),fileName,file[1],true,null);
            pictureService.addPicture(picture);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
        return "ok";
    }

    @RequestMapping("delete")
    @ResponseBody
    public String delete(String  p_id){
        System.out.println(p_id);
        pictureService.dropPicture(p_id);
        return "ok";
    }

    @RequestMapping("/down")
    @ResponseBody
    public String down(String p_id,HttpServletResponse response) {

        Picture picture = pictureService.selectOne(p_id);
        try {
            ClientGlobal.init(conf_filename);TrackerServer trackerServer = new TrackerClient().getConnection();
            StorageClient storageClient = new StorageClient(trackerServer, null);
            byte[] bytes = storageClient.download_file("group1", picture.getP_url());
            FileOutputStream stream = new FileOutputStream("f:\\download\\"+picture.getP_name());
            stream.write(bytes);
            stream.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
        return "ok";
    }


}
