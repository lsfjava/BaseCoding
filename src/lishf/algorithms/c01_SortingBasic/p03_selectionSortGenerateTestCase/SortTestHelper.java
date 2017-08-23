package lishf.algorithms.c01_SortingBasic.p03_selectionSortGenerateTestCase;

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
        assert rangeL <= rangeR : "区间临界值顺序有误！";
        Integer[] array = new Integer[n];
        for( int i = 0 ; i < array.length ; i ++ )
            array[i] =  new Integer((int)(Math.random() * (rangeR - rangeL + 1) + rangeL));
        return  array;
    }

    public static void printArray(Object[] array){
        for( int i = 0 ; i < array.length ; i ++ ){
                System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}