package com.juanlumn.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTest {
    @Test
    public void main() throws Exception {
        Application.main(new String[]{
                "--spring.main.web-environment=false",
                "--spring.autoconfigure.exclude=nothingToExclude",
        });
    }

}