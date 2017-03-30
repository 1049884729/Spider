package com.gobeike.run;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by xuff on 17-3-30.
 */
public class WeixinSougouSpider {

    public void getHostInfo(){
        String url = "http://weixin.sogou.com/";
        try {
            Document doc = Jsoup.connect(url).get();
            System.out.println("微信热点搜索部分：");
            Elements elements = doc.getElementsByClass("hot-news");
            for (Element element:elements){
                Elements hots=element.getElementsByTag("a");
                for (Element element1:hots){
                    System.out.println(element1.text()+":"+element1.attr("href"));
                }
            }
            System.out.println("微信热门部分：");

            Elements txtboxs = doc.getElementsByClass("txt-box");
            for (Element element:txtboxs){
                Elements hots=element.getElementsByTag("a");
                for (Element element1:hots){
                    System.out.println(element1.text()+":"+element1.attr("href"));
                }
            }
            System.out.println(doc);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
