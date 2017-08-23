package lishf.crazyjava.chapter4;

import java.util.Arrays;

/**
 * Java Arrays工具类
 * Created by Administrator on 2017\8\18
 */
public class ArraysUtils {

    public static void main(String[] args){

        // binarySearch使用二分法查找4在arr1中的索引位置,前提是arr1已经升序排列,返回负数表示不包含
        int[] arr1 = {0, 1, 4, 8};
        System.out.println(Arrays.binarySearch(arr1,4));
        System.out.println(Arrays.binarySearch(arr1,0,1,4));// 仅从arr1中0~1索引的元素中查找

        // toString
        System.out.println(Arrays.toString(arr1));

        // copyOf复制数组
        int[] arr2 = {2, 4, 6};
        System.out.println(Arrays.toString(Arrays.copyOf(arr2,3)));// 3表是复制的长度
        System.out.println(Arrays.toString(Arrays.copyOf(arr2,1)));// 长度小于arr2长度,取前1个
        System.out.println(Arrays.toString(Arrays.copyOf(arr2,4)));// 长度大于arr2长度,后面由系统自动赋值
        System.out.println(Arrays.toString(Arrays.copyOfRange(arr2,1,2)));//  仅复制[1,2)索引的元素

        // equals长度相同,元素一一相同时(位置也要相同),返回true
        int[] arr3 = {1, 2, 3};
        int[] arr4 = {2, 1, 3};
        System.out.println(Arrays.equals(arr3, arr4));// false

        // fill填充
        int[] arr5 = new int[4];
        Arrays.fill(arr5, 1);//填充左右元素为1
        Arrays.fill(arr5, 2, 4, 3);// 填充[2,4)区间为3
        System.out.println(Arrays.toString(arr5));

        // sort排序
        int[] arr6 = {4, 3, 2, 1};
        Arrays.sort(arr6, 1, 3);// 对区间[1,3)元素排序
        System.out.println(Arrays.toString(arr6));
        Arrays.sort(arr6);// 对arr6整体排序
        System.out.println(Arrays.toString(arr6));

        //-----JAVA8新增---------------------------------

        //略,主要是利用多核处理器并发处理,提高性能

    }

}
