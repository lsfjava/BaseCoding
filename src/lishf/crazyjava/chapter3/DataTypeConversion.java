package lishf.crazyjava.chapter3;

/**
 * 数据类型转换
 * Created by Administrator on 2017\8\15
 */
public class DataTypeConversion {

    public static void main(String[] args){

        // 自动类型转换
        autoConversion();
        // 强制类型转换
        narrowConversion();
        // 生成随机小写字母6位字符串
        generateStr();
        // String转换为基本数据类型需要借助包装类(chapter6详细介绍)
        int intInstance = Integer.parseInt("1");
        // 算数表达式中的自动提升
        autoPromotion();
    }

    private static void autoConversion(){
        // 自动类型转换：
        // 1、表数范围小 → 表数范围大
        //            char↘
        //                 int → long → float → double
        // byte → short ↗

        int a = 6;
        float f = a;
        System.out.println("float:"+ f);
        byte b = 9;
        double d = b;
        System.out.println("double:"+ d);

        // 2、基本类型都可自动转换为字符串 +"" 操作即可
        System.out.println(""+ 3 + 4);
        System.out.println(3 + 4 + "");
    }

    private static void narrowConversion(){
        // 强制类型转换：表数范围大 → 表数范围小
        int a = 233;
        byte b = (byte)a;
        System.out.println("byte:"+ b);// 导致了信息丢失
        double c = 10.99;
        int d = (int)c;
        System.out.println("int:"+ d);// 截取了整数部分
    }

    private static void generateStr(){
        String result = "";
        for( int i = 0 ; i < 6 ; i ++ ) {
            int num = (int)(Math.random() * 26 + 97);// 97~122的int强制转换为char可对应26个小写字母
            result += (char)num;
        }
        System.out.println("随机码:" + result);
    }

    private static void autoPromotion(){
        // 算数表达式中byte、short、char自动提升为int
        // 整个算术表达式的数据类型自动提升到最高等级操作数同样的类型
        short s = 1;
        s = (short)(s + 1);// 表达式右面自动提成为int，需要强制类型转换
        s += 1;// 这样可以直接执行
        int i = 3;
        int r = 23/i; // 表达式右面都是int，表达式整体为int
        // 将+放在字符串和基本类型之间时，表示连接运算
        System.out.println("" + 'a' + 7);
        System.out.println('a' + 7 + "");
    }

}
