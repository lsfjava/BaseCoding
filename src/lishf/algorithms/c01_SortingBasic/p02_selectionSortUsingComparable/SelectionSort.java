package lishf.algorithms.c01_SortingBasic.p02_selectionSortUsingComparable;

/**
 * 选择排序:遍历出数组的最小值，放到数组第一位，遍历剩余值的最小值，放到剩余值第一位，以此类推
 */
public class SelectionSort {

    // 算法类不允许产生任何实例
    private SelectionSort(){}

    /**
     * 测试排序算法
     * @param args
     */
    public static void main(String[] args){
        // 测试Integer
        Integer array1[] = new Integer[]{4,2,7,1,3,8};
        sort(array1);
        System.out.print("测试Integer:");
        for( int i = 0 ; i < array1.length ; i ++ )
            System.out.print(" " + array1[i]);
        System.out.println(" ");

        // 测试Double
        Double array2[] = new Double[]{4.1,2.6,3.3,1.9,1.8,4.0};
        sort(array2);
        System.out.print("测试Double:");
        for( int i = 0 ; i < array2.length ; i ++ )
            System.out.print(" " + array2[i]);
        System.out.println(" ");

        // 测试String
        String array3[] = new String[]{"lishaofei","yangshuang","B","A"};
        sort(array3);
        System.out.print("测试Stirng:");
        for( int i = 0 ; i < array3.length ; i ++ )
            System.out.print(" " + array3[i]);
        System.out.println(" ");

        // 测试Student
        Student array4[] = new Student[]{new Student("L",80), new Student("Y", 90), new Student("A", 20), new Student("B", 80)};
        sort(array4);
        System.out.print("测试Student:");
        for( int i = 0 ; i < array4.length ; i ++ )
            System.out.print(" " + array4[i]);
        System.out.println(" ");
    }

    /**
     * 数组排序
     * @param array
     */
    public static void sort(Comparable[] array){
        for( int i = 0 ; i < array.length ; i ++ ){
            // 找到[i,n)区间内的最小值的索引
            int minIndex = i;
            for( int j = i + 1 ; j < array.length ; j ++ )
                if( array[j].compareTo(array[minIndex]) < 0 ) minIndex = j;
            // 交换位置
            swap(array, i ,minIndex);
        }
    }

    /**
     * 交换数组array下标为i,j两元素的位置
     * @param array
     * @param i
     * @param j
     */
    public static void swap(Object[] array, int i, int j) {
        Object tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

}