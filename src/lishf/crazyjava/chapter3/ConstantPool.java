package lishf.crazyjava.chapter3;

/**
 * 常量池
 * Created by Administrator on 2017\8\15
 */
public class ConstantPool {

    public static void main(String[] args){
        // 常量池指的是编译期被确定，并被保存到.class文件中的一些数据
        // 包含：类、方法、接口中的常量、也包含字符串直接量

        // 程序第一次使用某个字符串直接量时，Java会将字符串直接量缓存到常量池中，如果程序后面的部分使用到该直接量，java会直接使用常量池中的直接量
        String s0 = "abc";
        String s1 = "abc";
        String s2 = "a" + "bc";
        System.out.println(s0 == s1);
        System.out.println(s0 == s2);

    }

}
