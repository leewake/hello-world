package com.pangpang.mvnbook.service;

import com.pangpang.mvnbook.util.XwpfUtil;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by leewake on 2017/7/27 0027.
 */
public class WordService {

    static String filePath = "template/confirmation.doc";

    static InputStream is;

    XWPFDocument doc;

    Map<String, Object> params = new HashMap<String, Object>();

    {
        params.put("${supplierName}", "张三");
        params.put("${visitTimeStart}", "2017-07-01");
        params.put("${visitTimeEnd}", "2017-07-10");
        params.put("${settlement_Amount}", "一百二十元");
        params.put("${settlementAmount}", "3102");
        params.put("${userName}", "李四");
        params.put("${date}", "2017-07-27");

        try {
            File file = new File(WordService.class.getClassLoader().getResource("").getPath() + filePath);
            System.out.println(file.getPath());
            System.out.println(file.getAbsolutePath());
            System.out.println(WordService.class.getClassLoader().getResource("com/pangpang/mvnbook/generic").getPath());
            System.out.println(WordService.class.getClassLoader().getResource("template").getPath());
            //is = new FileInputStream(file);
            is = WordService.class.getClassLoader().getResourceAsStream(filePath);
            doc = new XWPFDocument(is);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * 用一个docx文档作为模板，然后替换其中的内容，再写入目标文档中。
     *
     * @throws Exception*/
    public void testTemplateWrite() throws Exception {
        //替换段落里面的变量
        XwpfUtil.replaceInPara(doc, params);
        OutputStream os = new FileOutputStream("E:\\confirmation.doc");
        doc.write(os);
        XwpfUtil.close(os);
        XwpfUtil.close(is);
    }

    public static void main(String[] args){
        System.out.println("开始导出");
        System.out.println(WordService.class.getClassLoader().getResource("").getPath());
        try {
            new WordService().testTemplateWrite();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("结束导出");
    }

}
