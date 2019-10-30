package com.imooc.wx.Controller;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.logging.Logger;

@Controller
public class FileController {
    private static final Logger log = (Logger) LoggerFactory.getLogger(FileController.class);

    @RequestMapping(value = "/load",method = RequestMethod.POST)
    @ResponseBody
    public String uploadFile(MultipartFile file) {
        if (file.isEmpty()) {
            return "文件为空，上传失败 ";
        }
        try {
            //获取文件名
            String filename = file.getOriginalFilename();
            log.info("文件的上传名" + filename);
            //获取文件后缀名
            String suffixName = filename.substring(filename.lastIndexOf("."));
            log.info("文件后缀名"+ suffixName);
            // 设置文件存储路径
            String filePath = "wx/src/mian/java/com/imooc/web/upload/";
            String path = filePath + filename + suffixName;
            File web = new File(path);
           //判断目录
            if (!web.getParentFile().exists()) {
                web.getParentFile().mkdirs();// 新建文件夹
            }
            file.transferTo(web);// 文件写入
            return "文件上传成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "文件上传失败";
        }
    }

  @PostMapping("/upload/batch")
    public String handleFiles(HttpServletRequest request ){
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        MultipartFile file = null;
        BufferedOutputStream stream =null;
        for(int i=0;i<files.size();i++){
            file =files.get(i);
            String filePath="wx/src/mian/java/com/imooc/web/upload/batch";
            if (!file.isEmpty()){
                try{
                    byte[] bytes =file.getBytes();
                    stream = new BufferedOutputStream(new FileOutputStream(
                            new File(filePath+file.getOriginalFilename())));
                    stream.write(bytes);
                    stream.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    return "第 " + i + " 个文件上传失败 ==> "
                            + e.getMessage();
                } catch (IOException e) {
                    e.printStackTrace();
                    return "第 " + i
                            + " 个文件上传失败因为文件为空";
                }
            }
        }
        return "上传成功";
    }

    @GetMapping("/download")
    public String downloadFile(HttpServletRequest request , HttpServletResponse response) {
        String fileName = "web_text.txt";//文件名
        if (fileName !=null){
            //设置文件路径
            String realPath ="wx/src/mian/java/com/imooc/web/download";
            File file = new File(realPath,fileName);
            if (file.exists()){
                response.setContentType("application/force-download");
                response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try{
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1){
                        os.write(buffer,0,i);
                        i = bis.read(buffer);
                    }
                    return "下载成功";
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if(bis!=null){
                        try{
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis !=null){
                        try{
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return "下载失败";
    }
}