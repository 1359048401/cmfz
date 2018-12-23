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
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
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
        chapter.setSize(s);

        //设置文件的时长
        File mp3File = new File(realPath + "/" + file3.getOriginalFilename());
        MP3File f = (MP3File) AudioFileIO.read(mp3File);
        MP3AudioHeader audioHeader = f.getMP3AudioHeader();
        String trackLength = audioHeader.getTrackLengthAsString();
        String[] times = trackLength.split(":");
        System.out.println(times.toString());
        System.out.println(chapter);

    }


}
