package lishf.crazyjava.chapter15;

import java.io.File;
import java.io.IOException;

/**
 * file类:代表与平台无关的文件和目录，用于新建、删除、重命名文件和目录
 * file无法访问文件内容，需要使用IO流
 * Created by Administrator on 2017\8\23
 */
public class FileTest {

    public static void main(String[] args) throws IOException{

        File file = new File("123");
        System.out.println(file.getName());
        System.out.println(file.getParent());
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getAbsoluteFile().getParent());

    }

}
