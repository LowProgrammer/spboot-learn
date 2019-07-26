package com.demo.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @Classname PaseHtml
 * @Description TODO
 * @Date 2019/6/25 14:46
 * @Created by ChenS
 */
public class PaseHtml {
    public static void parseGetImage(String Html) {
        Document docu = Jsoup.parse(Html);

        Element body = docu.body();
        System.out.println("整体情况");


        Elements rows = docu.body().select("img");

        for (Element e : rows) {
            System.out.println("1------" + e.toString());
            System.out.println(e.attr("src").toString());
            System.out.println(e.getElementsByAttribute("src").text());
        }

        getWholeSource(body);

    }

    public static void getWholeSource(Element element) {
        System.out.println("<><><><><><><><><><><>");
        if (element.children().size() == 0 && element.is("img")) {
            System.out.println(element.toString());
        } else {
            for (Element e : element.children()) {
                getWholeSource(e);
            }
        }
    }

    public void pri(Elements elements) {

    }
}
