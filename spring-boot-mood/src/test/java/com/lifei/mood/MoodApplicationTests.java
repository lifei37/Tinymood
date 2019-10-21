package com.lifei.mood;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class MoodApplicationTests {

    @Test
    public void contextLoads() throws ParseException {
        String vueDate = "2019-10-10T16:00:00.000Z";
        String a = vueDate.substring(0,10);
        System.out.println(a);
    }

}
