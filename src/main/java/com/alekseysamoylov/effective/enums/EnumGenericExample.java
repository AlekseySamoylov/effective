package com.alekseysamoylov.effective.enums;

import java.util.EnumSet;

public class EnumGenericExample {

    private static class LocalType {}

    interface Operation {
        int doSomething(int i);
    }

    enum Choices implements Operation {
        GOOD, NOT_GOOD;

        public int doSomething(int i) {
            return this.ordinal() + i;
        }
    }

    enum ExtraChoices implements Operation {
        WEIRD, STRANGE, ERRATIC;

        public int doSomething(int i) {
            return this.ordinal() * i;
        }
    }

    public static void main(String[] args) {
        var choices = EnumSet.allOf(Choices.class);
        test(ExtraChoices.class, 5);

    }

    private static <T extends Enum<T> & Operation> void test(Class<T> opEnumType, int i) {
        for (var operation : opEnumType.getEnumConstants()) {
            System.out.printf("%d apply %s = %d%n", i, operation, operation.doSomething(i));
        }
    }
}
