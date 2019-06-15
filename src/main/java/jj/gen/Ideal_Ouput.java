package jj.gen;

public class Ideal_Ouput {

    public void fun()
    {
        for (int i=1;i<=10;i++)
        {
            System.out.print(i);
        }
    }

    public int sum(int a, int b) {
        return a + b;
    }

    public static void main( String[] args ){
        Ideal_Ouput myClass=new Ideal_Ouput();
        myClass.fun();
        myClass.sum(1,2);
    }
}


//public class Shape {
//    private Object x;
//    private Object y;
//
//    Shape(Object x, Object y) {
//        this.x = x;
//        this.y = y;
//    }
//
//    public void area() {
//        System.out.print("Hello area");
//    }
//}
