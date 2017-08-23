package lishf.algorithms.c01_SortingBasic.p03_selectionSortGenerateTestCase;

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
        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 1, 100000);
        SelectionSort.sort( arr );
        SortTestHelper.printArray(arr);
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