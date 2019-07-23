package com.nofetel.msn.dev.player.output.service.impl;

import com.nofetel.msn.dev.player.output.service.FileOutputService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.channels.FileChannel;

@Slf4j
@Service
public class FileOutputServiceImpl implements FileOutputService {

    @Override
    public void output(String fileName, Long start, Long length, OutputStream outputStream) {
        File file = new File(fileName);
        if (!file.exists() || !file.isFile()) {
            log.warn("not found file");
            return;
        }
        if (length == null) {
            //1MB
            length = 1 * 1024 * 1024L;
        }
        if (start >= file.length()) {
            return;
        }
        if (start + length >= file.length()) {
            length = file.length() - start;
        }
        if (length == 0L) {
            return;
        }
        RandomAccessFile randomAccessFile = null;
        try {
            byte[] buffer = new byte[4 * 1024];
            int nowLen = 0;
            long allLen = 0L;
            randomAccessFile = new RandomAccessFile(file, "r");
            randomAccessFile.seek(start);
            while ((nowLen = randomAccessFile.read(buffer)) != 0 && allLen < length) {
                allLen += nowLen;
                outputStream.write(buffer, 0, nowLen);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
