package com.baizhi;

import io.goeasy.GoEasy;
import org.junit.Test;


public class TestGoEasy {

    @Test
    public void testGoEasy() {
        GoEasy goEasy = new GoEasy("http://rest-hangzhou.goeasy.io", "BC-2b66fbf505a54de1a1ca0b060dc1be20");
        goEasy.publish("testSendMessage", "This is test Message");
    }
}
