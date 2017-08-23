package lishf.algorithms.c01_SortingBasic.p04_selectionSortDetectPerformance;

import java.lang.reflect.Method;

/**
 * 测试工具类
 */
public class SortTestHelper{

    // SortTestHelper不允许产生任何实例
    private SortTestHelper(){}

    /**
     * 生成有n个元素的随机数组,每个元素的随机范围为[rangeL, rangeR]
     * @param n
     * @param rangeL
     * @param rangeR
     * @return
     */
    public static Integer[] generateRandomArray(int n, int rangeL, int rangeR){
        assert rangeL < rangeR : "左右临界值顺序有误!";
        Integer[] array = new Integer[n];
        for( int i = 0 ; i < array.length ; i ++ )
            array[i] =  new Integer((int)(Math.random() * (rangeR - rangeL + 1) + rangeL));
        return  array;
    }

    /**
     * 打印数组
     * @param array
     */
    public static void printArray(Object[] array){
        for( int i = 0 ; i < array.length ; i ++ ){
                System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    /**
     * 判断数组是否从小到大排序
     * @param array
     * @return
     */
    public static boolean isSorted(Comparable[] array){
        for( int i = 0 ; i < array.length ; i ++ )
            if ( array[i].compareTo(array[i+1]) > 0 )
                return false;
        return true;
    }

    // 测试sortClassName所对应的排序算法排序arr数组所得到结果的正确性和算法运行时间
    public static void testSort(String sortClassName, Comparable[] arr){

        // 通过Java的反射机制，通过排序的类名，运行排序函数
        // * 依然是，使用反射机制并不是这个课程的重点, 大家也完全可以使用自己的方式书写代码, 最终只要能够测试出自己书写的算法的效率即可
        // * 推荐大家阅读我在问答区向大家分享的一个学习心得: 【学习心得分享】请大家抓大放小，不要纠结于C++语言的语法细节
        // * 链接: http://coding.imooc.com/learn/questiondetail/4100.html
        try{
            // 通过sortClassName获得排序函数的Class对象
            Class sortClass = Class.forName(sortClassName);
            // 通过排序函数的Class对象获得排序方法
            Method sortMethod = sortClass.getMethod("sort",new Class[]{Comparable[].class});
            // 排序参数只有一个，是可比较数组arr
            Object[] params = new Object[]{arr};

            long startTime = System.currentTimeMillis();
            // 调用排序函数
            sortMethod.invoke(null,params);
            long endTime = System.currentTimeMillis();

            assert isSorted( arr );

            System.out.println( sortClass.getSimpleName()+ " : " + (endTime-startTime) + "ms" );
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}