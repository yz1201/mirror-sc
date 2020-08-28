package cn.dbdj1201.nio;

import cn.dbdj1201.entity.Bookmark;
import cn.hutool.core.lang.Assert;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.*;

/**
 * @Author: dbdj1201
 * @Date: 2020-08-17 10:51
 */
public class Base {

    public static void main(String[] args) throws IOException {
        InputStream bookmarks = Base.class.getClassLoader().getResourceAsStream("Bookmarks");

//        new BufferedReader(new FileReader(new File("")));
        byte[] bs = new byte[1024];

        int len;
        StringBuilder sb = new StringBuilder();
//        assert bookmarks != null;
//        Assert.notNull(bookmarks, "ttt");
        assert bookmarks != null;
        Assert.notNull(bookmarks);
        while ((len = bookmarks.read(bs)) != -1) {
            sb.append(new String(bs, 0, len));
        }

//        System.out.println(sb);

        JSONObject js = JSON.parseObject(sb.toString());

//        System.out.println(js.get("roots"));
        JSONObject roots = js.getJSONObject("roots");
        JSONObject bookmark_bar = roots.getJSONObject("bookmark_bar");
        JSONObject other = roots.getJSONObject("other");
        System.out.println(bookmark_bar);
        System.out.println(other);

        Bookmark bookmark = other.toJavaObject(Bookmark.class);
        System.out.println(bookmark);
        Bookmark x = bookmark_bar.toJavaObject(Bookmark.class);
        x.getChildren().forEach(System.out::println);
        System.out.println(x);

        System.out.println();
//        Object roots = js.get("roots");
//        System.out.println(roots);
//        System.out.println(JSON.toJSONString(roots));
//        System.out.println(js.get("roots"));

//        Object parse = JSON.parse(sb.toString());
//        System.out.println(parse);
    }
}
