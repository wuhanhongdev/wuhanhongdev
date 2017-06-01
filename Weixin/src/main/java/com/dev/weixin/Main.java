package com.dev.weixin;

import com.alibaba.fastjson.JSON;
import com.dev.weixin.model.AccessToken;
import com.dev.weixin.utils.HttpUtils;
import org.junit.Test;

public class Main {
     @Test
    public void testGet(){
         String shopInfoUrl = "https://api.weixin.qq.com/scan/product/create?access_token=";
         String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx7ca954539c5d886f&secret=3b16ec451288c309ddff52d0e6cd3f19";
         String content = HttpUtils.get(url);
         AccessToken token = JSON.parseObject(content, AccessToken.class);
         shopInfoUrl += token.getAccess_token();
         String shopInfoResponse = HttpUtils.get(shopInfoUrl);
         System.out.println(shopInfoResponse);
    }
}
