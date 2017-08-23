package lishf.crazyjava.chapter4;

/**
 * java数组
 * Created by Administrator on 2017\8\18
 */
public class ArrayTest {

    public static void main(String[] args){

        // 在同一数组中，只能存储一种数据类型的数据，因java继承特性，可能出现数组中有多个数据类型的假象
        // 数组是一种引用数据类型
        // 数组初始化后，所占内存空间将固定，数组长度不可变，即使元素清空，所占空间依然不变

        // 定义数组，建议使用前者，int[]理解为一种引用类型，这样易读性高
        // 如下两种方式仅仅定义了数组的引用变量，没有指向任何有效内存，因此不能指定数组长度
        // 也不能使用没有初始化的数组
        int[] a;
        int b[];

        // 初始化数组
        // 静态初始化：指定每个元素的值，系统决定数组长度
        // 动态初始化：指定数组长度，系统为元素分配初始值
        // 系统分配初始值:byte/short/int/long=0, float/double=0.0, char='\u0000', boolean=false, 引用类型=null
        int[] intArray = new int[]{1, 2, 3};
        Object[] objArray = new String[]{"lsf", "ys"};
        Object[] objArray2 = {"lsf", "ys"};// 简化静态初始化方式
        int[] intArray2 = new int[5];// 动态初始化

        // 访问数组元素,下标<0或者>=数组长度,将抛出数组索引越界异常
        //System.out.println(intArray[-1]);

        // 可通过length访问数组长度
        for ( int i = 0 ; i < intArray.length ; i++ ){
            System.out.println("instance:" + intArray[i]);
        }

        // Java5后提供foreach
        for ( int instance : intArray) {
            System.out.println("instance:" + instance);
        }

        // foreach可以理解为用一个临时变量接数组中每一个元素的值,因此不要使用foreach对数组元素进行赋值
        String[] strArray = {"lsf", "ys" ,"hs"};
        for ( String instance : strArray ) {
            instance = "new";
            System.out.println(instance);
        }
        System.out.println(strArray[1]);

        // 内存中的数组
        memTest();

        // 没有多维数组,实际都是一维数组
        int[][] arr = new int[4][];

    }

    private static void memTest(){

        // 每个方法执行时,会建立自己的内存栈,方法内定义的变量会逐个放入这块内存中,随着方法执行结束,栈自然销毁
        // 所有方法定义的局部变量都是存在栈内存中的
        // 程序创建一个对象时,对象被保存到运行时数据区,即堆内存,这里的对象不会随着方法的结束而销毁,也可能被另一个引用变量引用
        // 当一个对象没有任何引用变量引用时,才会被系统的垃圾回收器在某一时刻回收

        // 如果数组引用变量是一个局部变量,则存储在栈stack内存中
        // 数组对象存储在堆heap内存中
        int[] a = {1,2,3};// 堆栈中各开辟一个口案件
        int[] b = new int[4];
        b = a;// 此时b的引用指向了a对应的数组,b之前指向的数组将被回收,而此时造成了数组长度可变的假象

        // 数组元素为引用类型时,数组对象中存如新对象的引用

    }

}
