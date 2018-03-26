package com.alekseysamoylov.effective.annotation;

public class Sample2 {
    @ExceptionTest(ArithmeticException.class)
    public static void m1() { // Should pass
        int i = 0;
        i = i / i;
    }


    @ExceptionTest(ArithmeticException.class)
    public static void m2() { // Should fail (wrong exception)
        int[] i = new int[0];
        int a = i[1];
    }

    @ExceptionTest(ArithmeticException.class)
    public static void m3() { // Should fail (no exception)
    }

    @ExceptionTest({ArithmeticException.class, NullPointerException.class})
    public static void m4() { // Should pass
        throw new NullPointerException();
    }

}
