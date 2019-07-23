package com.nofetel.msn.dev.player.output.service;

import java.io.OutputStream;

public interface FileOutputService {


    /**
     * 输出流
     * @param fileName
     * @param start
     * @param length
     * @return
     */
    void output(String fileName, Long start , Long length, OutputStream outputStream);
}
