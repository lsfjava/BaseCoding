package lishf.crazyjava.chapter3;

/**
 * 数据类型分类
 * 基本数据类型 Primitive Type
 * 引用数据类型 Reference Type
 * Created by Administrator on 2017\8\14
 */
public class DataType {

    public static void main(String[] args){

        // boolean类型
        boolean booleanInstance = false;
        System.out.println("booleanInstance:" + booleanInstance);

            // 字符串"true""false"不能直接转换为boolean，boolean值和字符串连接运算可转换成字符串
            // boolean类型变量只需要1位即可保存，但多数计算机分配内存的最小单位是字节8位

        // 数值类型

            // 数值类型分为整型和浮点型
            // 整型分为byte、short、int、long、char
            // 浮点型分为float、double

        byte byteInstance = -128;// byte在内存中占8位，表数范围是-128(-2^7)~127(2^7-1)
        System.out.println("byteInstance:" + byteInstance);
        byteInstance --;
        System.out.println("byteInstance--:" + byteInstance);

        short shortInstance = 32767;// short在内存中占16位，表数范围是-32768(-2^15)~32767(2^15-1)
        System.out.println("shortInstance:" + shortInstance);
        shortInstance ++;
        System.out.println("shortInstance++:" + shortInstance);

        int intInstance = 2147_4836_47; // int在内存中占32位，表数范围是-2147483648(-2^31)~2147483647(2^31-1)
        System.out.println("intInstance:" + intInstance);
        intInstance ++;
        System.out.println("intInstance++:" + intInstance);

        long longInstance = 9999999999L;// long在内存中占64位，表数范围是(-2^63)~(2^63-1)
        System.out.println("longInstance:" + longInstance);

            // 1、方便程序易读,数值中间可出先写划线用于分割
            // 2、直接将超出范围的数值赋值给整型实例，会报错，而复制为最大值/最小值，然后进行++/--操作不会报错，数值会循环
            // 3、int是最常用的整数类型，数值类型的声明语句=右面默认为int
            //    JVM可以将符合数值范围的整数可以当做byte、short处理,因此将-128赋值给byteInstance、将32767赋值给shortInstance没有问题
            //    JVM无法将超出int范围的数值当做long来处理，因此声明longInstance时，若=右数字超出int的范围，需要添加L后缀
            //    没有超出int范围的数值，将当做int处理，然后会自动类型转换为long

            // 整型的表示方式:十进制、二进制、八进制、十六进制

        int octalValue = 013;// 八进制以0开头
        System.out.println("octalValue:" + octalValue);
        int hexValue = 0x1f;// 十六进制0x或0X开头，10~15用a~f表示
        System.out.println("hexValue:" + hexValue);
        int binValue = 0b11;// 二进制0b或0B开头
        System.out.println("binValue:" + binValue);
        int binValue32 = 0b10000000000000000000000000000011; // 定义一个32位的二进制整数时,最高为时符号位，符号位1表示负数
        System.out.println("binValue32:" + binValue32);
        byte byteBinValue = (byte)0b1111_00000001;//由于强制类型转换导致溢出,前四位忽略，第五位为符号位
        System.out.println("byteBinValue:" + byteBinValue);
        long longBinValue = 0b00000000000000000000000000000001L; // 添加L后缀，实际占用64位，第一位不再是符号位
        System.out.println("longBinValue:" + longBinValue);

            // 数字在计算机底层以二进制形式存在，计算机以补码形式保存所有整数
            // 原码：直接将一个数值换算成2进制数
            // 反码：原码，最高位符号位不变，其他按位取反
            // 补码：正数补码与原码相同，负数补码是其反码加1

        char charInstance1 = '1';// 通过单个字符指定字符型值，如'A','9'
        char charInstance2 = '\t';// 通过转移字符表示特殊字符型值，如'\n','\t'
        char charInstance3 = '\u9999';// 通过转移字符表示特殊字符型值，如'\u9999'
        System.out.println("charInstance1:" + charInstance1);
        System.out.println("charInstance2:" + charInstance2);
        System.out.println("charInstance3:" + charInstance3);
        char charInstance4 = 257;// 可以将0~65535的int值赋值给char
        System.out.println("charInstance4:" + charInstance4);

            // 注释中出现无效的unicode编码将不能运行
            // java中的单引号、双引号、反斜杠都有特殊用途，一个字符串中包含这些特殊字符时，应使用转义字符的表示形式

        float floatInstance = 1.2f;// 浮点类型默认为double，声明float需要F/f结尾，float占4字节 32位
        double doubleInstance = 11.23;// double占8字节 64位 结尾添加D/d后缀强制指定double
        System.out.println("floatInstance:" + floatInstance);
        System.out.println("doubleInstance:" + doubleInstance);
        double doubleVue = 512e2;// 只有浮点数可以使用科学计数法形式
        System.out.println("doubleVue:" + doubleVue);

            // double比float更加精确，如果需要确保精确，应使用BigDecimal类

        double a = Double.POSITIVE_INFINITY; // 正无穷大通过Double或Float的POSITIVE_INFINITY表示，所有的正无穷大是相等的
        float  b = Float.NEGATIVE_INFINITY; // 负无穷大通过Double或Float的NEGATIVE_INFINITY表示，所有的负无穷大是不等的
        double c = Double.NaN;// 非数通过Double或Float的NaN表示，NaN与任何数值不等，与NaN也不等
        double a1 = 1.0/0; // 通过正浮点数除以0得到正无穷大，整数除以0将抛出异常
        double b1 = -1.0/0;// 通过负浮点数除以0得到负无穷大，整数除以0将抛出异常
        double c1 = 0.0/0;// 0.0/0.0或对一个负数开方得到非数
        System.out.println("a:" + a);
        System.out.println("b:" + b);
        System.out.println("c:" + c);
        System.out.println("a==a1:" + (a==a1));
        System.out.println("b==b1:" + (b==b1));
        System.out.println("c==c1:" + (c==c1));

    }

}
