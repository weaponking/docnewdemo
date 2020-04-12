package com.mine.docdemo;

import com.mine.docdemo.entity.User;
import com.mine.docdemo.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.List;

@SpringBootApplication
@MapperScan("com.mine.docdemo")
@Slf4j
public class App implements CommandLineRunner {

    public static void main( String[] args) {

        SpringApplication.run(App.class);
    }

    @Autowired
    private UserMapper userMapper;

    @Override
    public void run(String... args) throws Exception {
        List<User> userList = userMapper.selectAllUser();
        log.info(userList.toString());
    }
}
/**
 * At least one base package must be specified
 *
 */