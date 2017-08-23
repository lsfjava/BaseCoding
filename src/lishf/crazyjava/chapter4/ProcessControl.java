package lishf.crazyjava.chapter4;

/**
 * java流程控制
 * Created by Administrator on 2017\8\15
 */
public class ProcessControl {

    public static void main(String[] args){

        // 分支结构if
        ifTest();
        // 分支结构switch(java7后的switch)
        switchTest();
        // 循环结构while
        whileTest();
        // 循环结构do while
        dowhileTest();
        // 循环结构for
        forTest();
        // 控制循环结构break
        breakTest();
        // 控制循环结构continue
        continueTest();
        // 结束方法体return
        returnTest();

    }

    private static void ifTest(){

        int intInstance = 2;
        if( intInstance < 3 ) {
            System.out.println("intInstance < 3");
        } else if ( intInstance > 3 ) {
            System.out.println("intInstance > 3");
        } else {
            System.out.println("intInstance = 3");
        }
        if ( intInstance == 2 )
            System.out.println("intInstance = 2");
        // if没有{}时候,仅仅可以控制到紧跟条件语句的第一个分号处

    }

    private static void switchTest(){

        // switch后控制表达式的数据类型:byte,short,char,int,枚举,String,不能是boolean
        // 先对表达式进行求值,然后依次匹配case,如果没有匹配到,则执行default中的代码块
        // case后的{}可省略
        char scoreLevel = 'A';
        switch ( scoreLevel ) {
            case 'A':
                System.out.println("优");
                break;
            case 'B':
                System.out.println("良");
                break;
            case 'C':
                System.out.println("及");
                break;
            default:
                System.out.println("输入错误");
        }

            // 注意,如果将break全都去掉,程序会打印所有的输出语句,当case匹配后,程序就会开始执行之后的代码,不再判断之后的case是否匹配,所以这里个break十分重要

        // java7后支持String
        String name = "lsf";
        switch ( name ) {
            case "lsf":
                System.out.println("是本人");
                break;
            case "ys":
                System.out.println("不是本人");
                break;
            default:
                System.out.println("输入错误");
        }

    }

    private static void whileTest(){

        // 先对循环条件进行求值,如果为true,则执行循环体
        // while没有{}时候,仅仅可以控制到紧跟条件语句的第一个分号处
        int count = 10;
        while( count > 0 ){
            System.out.println("count:" + count);
            count --;
        }

    }

    private static void dowhileTest(){

        // 先执行循环体,再对循环条件进行求值,如果为true,则继续执行循环体
        int count = 10;
        do {
            System.out.println("count:" + count);
            count --;
        }while( count > 0 );

    }

    private static void forTest(){

        // 可以将声明语句、迭代语句提取出来，可用来扩大i的作用域,但是会影响之后的循环语句使用i
        int i = 0;
        for ( ; i < 3 ; ){
            System.out.println("i:" + i);
            i ++;
        }
        // 支持声明多个变量,但是类型要一致
        for ( int a = 1, b = 2, c = 3 ; a < 10 && b < 10 && c < 10 ; b ++, c ++){
            System.out.println("a:" + a++);
        }

        //嵌套循环(略)

    }

    private static void breakTest(){

        // break完全结束循环，跳出循环体
        for ( int i = 0 ; i < 3 ; i ++ ) {
            System.out.println("i" + i);
            break;
        }
        // 使用标签标记循环，并使用break结束外层循环
        outter:
        for ( int i = 0 ; i < 3 ; i ++ ){
            for ( int j = 0 ; j < 3 ; j ++ ){
                System.out.println("i>j:" + i + ">" + j);
                break outter;
            }
        }

    }

    private static void continueTest(){

        // continue忽略本次循环剩余语句
        for ( int i = 0 ; i < 3 ; i ++ ) {
            System.out.println("i" + i);
            if (i == 1) continue;
            System.out.println("continue1");
        }
        // 使用标签标记循环，并使用continue忽略本次循环剩余语句以及外层剩余语句
        outter:
        for ( int i = 0 ; i < 3 ; i ++ ){
            for ( int j = 0 ; j < 3 ; j ++ ){
                System.out.println("i>j:" + i + ">" + j);
                if(j==1)continue outter;
                System.out.println("continue2");
            }
        }

    }

    private static void returnTest(){

        for ( int i = 0 ; i < 3 ; i ++ ){
            for ( int j = 0 ; j < 3 ; j ++ ){
                System.out.println("i>j:" + i + ">" + j);
                if(j==1) return;
                System.out.println("return");
            }
            System.out.println("return");
        }
        System.out.println("return");

    }

}
