package com.dev;

import com.dev.messagequeen.model.UserModel;
import com.dev.messagequeen.producer.MsgProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class AppTest {
    @Autowired
    private MsgProducer msgProducer;
    @Test
    public void testSend(){
        for(int i=0; i<10; i++){
            UserModel userModel = new UserModel();
            userModel.setName("这是用户姓名"+i);
            userModel.setAddr("中国云南");
            userModel.setAge((i+1)*10);
            userModel.setNickName("NickName");

            msgProducer.sendMsg(userModel);
        }
    }
}
