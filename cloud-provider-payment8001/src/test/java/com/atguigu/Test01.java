package com.atguigu;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * TODO
 *
 * @author yds
 * @version 1.0
 * @date 2020/10/28 17:34
 * @description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class Test01 {

    @Test
    public void Test001(){
        ClassPathResource classPathResource = new ClassPathResource("html\\host\\10.192.32.130.html");
        String path = classPathResource.getPath();
        File file = new File("src/main/resources/html\\host\\10.192.32.130.html");
        try {
            Document doc = Jsoup.parse(file,"utf-8","");
            Elements tables = doc.getElementsByTag("table");
            for (Element table : tables){
                Elements children = table.children();
                if(!children.isEmpty()){

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
