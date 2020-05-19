package com.mine.docdemo.elk.mock;

import com.alibaba.fastjson.JSON;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author weapon
 * @date 20-5-10 14:55
 */
public class MockData {

    private static final Executor excutor = Executors.newFixedThreadPool(5);

    private static AtomicLong ID = new AtomicLong(0L);

    public static void runTask() throws IOException {
        int index = 0;
        do {
            File file = new File("/home/weapon/tmp/logs/"+index+".log");
            if(!file.exists()) {
                file.createNewFile();
            }
            excutor.execute(new Runnable() {
                @Override
                public void run() {
                    User user = new User();
                    user.setId(ID.getAndIncrement());
                    user.setName(UUID.randomUUID().toString());
                    try {
                        FileUtils.writeStringToFile(file, JSON.toJSONString(user)+"\n", "UTF-8",true);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            index++;
        }while (index<5);
    }

    public static void main(String[] args) {
        try {
            while(true) {
                runTask();
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
