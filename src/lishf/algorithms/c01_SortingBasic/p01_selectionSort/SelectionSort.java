package lishf.algorithms.c01_SortingBasic.p01_selectionSort;

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
        int array[] = new int[]{4,2,7,1,3,8};
        sort(array);
        for( int i = 0 ; i < array.length ; i ++ )
            System.out.print(" " + array[i]);
    }

    /**
     * 数组排序
     * @param array
     */
    public static void sort(int[] array){
        for( int i = 0 ; i < array.length ; i ++ ){
            // 找到[i,n)区间内的最小值的索引
            int minIndex = i;
            for( int j = i + 1 ; j < array.length ; j ++ )
                if( array[j] < array[minIndex] ) minIndex = j;
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
    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

}