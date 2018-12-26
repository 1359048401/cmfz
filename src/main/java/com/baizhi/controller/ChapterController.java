package com.baizhi.controller;

import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.TagException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.text.DecimalFormat;
import java.util.UUID;

@RestController
@RequestMapping("chapter")
public class ChapterController {

    @Autowired
    private ChapterService chapterService;

    @RequestMapping("insert")
    public void insertChapter(Chapter chapter, MultipartFile file3, HttpSession session) throws IOException, TagException, ReadOnlyFileException, CannotReadException, InvalidAudioFrameException {
        ServletContext ctx = session.getServletContext();
        String realPath = ctx.getRealPath("/chapter");

        //目标文件
        File descFile = new File(realPath + "/" + file3.getOriginalFilename());
        //上传文件
        file3.transferTo(descFile);

        //设置文件主键
        String c_id = UUID.randomUUID().toString().replace("-", "");
        chapter.setId(c_id);

        //设置文件名称
        chapter.setUrl("/chapter/" + file3.getOriginalFilename());

        //判断文件大小
        long size = file3.getSize();//获取大小
        Double dou = Double.valueOf(Long.toString(size));
        DecimalFormat format = new DecimalFormat("#0.00");
        String s = format.format(dou / 1024 / 1024);
        chapter.setSize(s + "MB");

        //设置文件的时长
        File mp3File = new File(realPath + "/" + file3.getOriginalFilename());
        MP3File f = (MP3File) AudioFileIO.read(mp3File);
        MP3AudioHeader audioHeader = f.getMP3AudioHeader();
        String trackLength = audioHeader.getTrackLengthAsString();
        chapter.setDuration(trackLength);
        //System.out.println(chapter);
        chapterService.insertChapter(chapter);
    }

    @RequestMapping("download")
    public void download(String filePath, HttpSession session, HttpServletResponse response, String title) {
        //获取下载文件的绝对路径
        String realPath = session.getServletContext().getRealPath(filePath);
        //“/chapter/xxxx.mp3”获取文件的名字   fileName[]
        String[] fileName = filePath.split("/");
        //设置相应头控制浏览器以下载的形式打开文件
        response.setContentType("application/force-download");
        response.setHeader("content-disposition", "attachment;filename=" + fileName[2]);

        //根据文件路径获取要下载的文件输入流
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        //创建数据缓冲区
        byte[] buffer = new byte[1024];

        try {
            fis = new FileInputStream(realPath);
            bis = new BufferedInputStream(fis);
            OutputStream os = response.getOutputStream();
            int i = bis.read(buffer);
            //通过response对象获取OutputStream流
            //将FileInputStream流写入到buffer缓冲区
            while (i != -1) {
                os.write(buffer, 0, i);
                i = bis.read(buffer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
