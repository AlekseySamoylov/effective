package com.alekseysamoylov.effective.annotation;

public class Sample {
    @Test
    public static void m1() {
    }

    @Test
    public static void m2() {
        throw new RuntimeException("Boom");
    }

    public static void m3() {
    }

    @Test
    public void m5() {
    }

    public static void m6() {
    }

    @Test
    public static void m7() {
        throw new RuntimeException("Crash");
    }
}
