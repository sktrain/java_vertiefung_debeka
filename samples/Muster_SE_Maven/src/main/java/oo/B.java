package oo;

class A {
    A() {
        foo();
    }
    private void foo() {
        System.out.println( "A" );
    }
}
public class B extends A {
    private String s;
    public B(String s){

        this.s = s;

    }
    void foo() {
        System.out.println( "B" + s );
    }

    public static void main(String[] args) {
        new B("!Hallo").foo();
    }
}