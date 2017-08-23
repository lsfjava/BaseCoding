package lishf.algorithms.c01_SortingBasic.p02_selectionSortUsingComparable;

/**
 * 学生实体
 */
public class Student implements Comparable<Student>{

    private String name;
    private int score;

    public Student(){}

    public Student(String name, int score){
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Student that) {
        if( this.score == that.score )
            return  this.name.compareTo(that.name);
        if( this.score > that.score )
            return -1;
        else if ( this.score < that.score )
            return 1;
        else
            return 0;
    }

    @Override
    public String toString() {
        return "Student:" + name + ' ' + score;
    }
}