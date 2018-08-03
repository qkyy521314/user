package com.baizhi.test;


import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by DELL on 2018/1/12.
 */
public class TestDFS extends BaseTest{
    private String conf_filename="fastdfs.conf";
    @Test
    public void testUpload() throws MyException {
        try {
            ClientGlobal.init(conf_filename);
            TrackerClient client = new TrackerClient();
            TrackerServer server = client.getConnection();
            StorageClient storageClient = new StorageClient(server, null);
            NameValuePair[] nameValuePairs = new NameValuePair[]{
                    new NameValuePair("id","101"),
                    new NameValuePair("name","小红")};
            String[] file = storageClient.upload_file("f:\\A1.jpg", "jpg", nameValuePairs);
            System.out.println(file[0]);
            for (String s : file) {
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDownLoad(){
        try {
            ClientGlobal.init(conf_filename);TrackerServer trackerServer = new TrackerClient().getConnection();
            StorageClient storageClient = new StorageClient(trackerServer, null);
            byte[] bytes = storageClient.download_file("group1", "M00/00/00/wKhLgFpbN_GAEPoQAABE6CX64_E672.jpg");
            FileOutputStream stream = new FileOutputStream("f:\\PWio678.zip");
            stream.write(bytes);
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

}
