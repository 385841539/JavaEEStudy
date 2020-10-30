package com.itheima.springboot_quick2;

import com.itheima.springboot_quick2.utils.JsonRead;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootQuick2ApplicationTests {

    @Test
    void contextLoads() {
        String s = JsonRead.readJsonFile(getClass().getClassLoader().getResource("home.json").getPath());
        System.out.println(s);
    }

}
