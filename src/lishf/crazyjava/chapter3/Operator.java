package lishf.crazyjava.chapter3;

/**
 * 运算符
 * Created by Administrator on 2017\8\16
 */
public class Operator {

    public static void main(String[] args){

        // 算数运算符
        arithmeticOperator();
        // 赋值运算符
        assignmentOperator();
        // 比较运算符
        comparisonOperator();
        // 逻辑运算符
        logicalOperator();
        // 位运算符
        bitOperator();
        // 其他
        other();

    }

    private static void arithmeticOperator(){

        // +
        double sum = 1 + 2;
        System.out.println("sum:" + sum);

        // -
        double sub = 2 - 3;
        System.out.println("sub:" + sub);

        // *
        double multiply = 3 * 4;
        System.out.println("multiply:" + multiply);

        // /
        double div = 4 / 5;
        System.out.println("div:" + div);
        // double正实例/0 得到正无穷大
        double positive = 5.0/0.0;
        System.out.println("positive:" + positive);
        // double负实例/0 得到正无穷大
        double negative = -5.0/0.0;
        System.out.println("negative:" + negative);
        //double e = 5/0; 除以零异常

        // %
        double mod = 5.6 % 2.3;
        System.out.println("mod:" + mod);
        System.out.println("5 % 0.0 = " + 5 % 0.0);// NaN
        System.out.println("-5.0 % 0 = " + -5.0 % 0);// NaN
        System.out.println("0 % 5.0 = " + 0 % 5.0);// 0.0
        System.out.println("0 % 0.0 = " + 0 % 0.0);// NaN
        //System.out.println("-5 % 0 = " + -5 % 0); 除以零异常

        // +可作为字符串连接运算符，-可作为求负运算法
        double x = 5;
        x = -x;
        System.out.println("x:" + x);

    }

    private static void assignmentOperator(){

        // 赋值运算就是将=右面的值装入左面的变量，变量可看做一个容器，=左面必须是变量
        // 赋值运算符由右向左执行，赋值表达式整体是有值的，为=右面的值
        // 综合以上两点可理解如下连续赋值语句，连续赋值不建议使用，易读性不高
        int a;
        int b;
        int c;
        a = b = c = 2;
        System.out.println("a-b-c:" + a + "-" + b + "-" + c);

        // 扩展赋值运算符
        // +=  -=  *=  /=  %=
        // &=  |=  ^=  <<=  >>=  >>>=
        byte byteInstance = 5;
        // byteInstance = byteInstance + 5;  5默认为int类型，这样操作会出错，使用扩展赋值运算符不会出错
        byteInstance += 5;

            // a = a + 5; 和 a += 5 运行结果相同，但是底层运行机制有差异，推荐使用后者

    }

    private static void comparisonOperator(){

        // > >= < <=
        // ==

            // boolean不能使用==进行比较
            // 如果是数值类型比较，只要值相等就返回true
            // 如果是引用类型，前后者必须是同一引用类型或有父子继承关系，指向同一个对象，返回true

        // !=

            // 数值类型，只要值不相等就返回true
            // 引用类型，指向的不是同一个对象返回true

        System.out.println(97 == 'a');// true
        Operator o1 = new Operator();
        Operator o2 = new Operator();
        Operator o3 = o1;
        System.out.println(o1 == o2);// false
        System.out.println(o1 == o3);// true
        System.out.println(o1 != o2);// true

    }

    private static void logicalOperator(){

        // && 与 前后两个操作数必须都是true才返回true，否则返回false
        // & 不短路与 同&&但不短路
        // || 或 前后两个操作数有一个true就返回true，否则返回false
        // | 不短路或 同||但不短路
        // ! 非 只需要一个操作数，true返回false，false返回true
        // ^ 异或 两个操作数相同返回false，不同返回true
        int a = 5;
        int b = 6;
        int c = 6;
        if (a > 4 | b++ > 6){
            System.out.println("b:" + b);
        }
        if (a > 4 || c++ > 6){
            System.out.println("c:" + c);
        }

    }

    private static void bitOperator(){

        // & 按位与 两位同时为1时为1
        System.out.println(5 & 9);
        // | 按位或 两位有一位为1则为1
        System.out.println(5 | 9);
        // ~ 按位非 按位取反
        System.out.println(~ 5);
        // ^ 按位异或 两位相同返回0，不同返回1
        System.out.println(5 ^ 9);
        // << 左移 二进制码整体左移指定位数，右面0填充
        System.out.println(5 << 2);
        // >> 右移 二进制码整体右移指定位数，左面按符号位填充
        System.out.println(5 >> 2);
        // >>> 无符号右移 二进制码整体右移指定位数，左面0填充
        System.out.println(5 >>> 2);

            // 1、对于低于int类型（byte、short、char），先自动转换为int在进行移位运算
            // 2、对于int类型，当移动位数>32时，先对位数进行求余，在进行移位运算 int a = 2; a >> 33和a>>1相同
            // 3、对于long类型，移动位数>64时，同上理论
            // 4、移位运算得到了新的运算结果，但原操作数不会改变
            // 5、二进制码没有发生有效位丢失的时候，即对于正数，被移出的为都为0时，左移n位相当于*2^n，右移n位相当于/2^n;

    }

    private static void other(){
        // 三目运算符
        int a = 11;
        int b = 12;
        System.out.println(a > b ? "a>b" : (a < b ? "a<b" : "a=b"));
        //
    }


}
