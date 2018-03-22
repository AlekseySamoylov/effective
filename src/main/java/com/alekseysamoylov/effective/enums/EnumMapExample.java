package com.alekseysamoylov.effective.enums;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Stream;

import static com.alekseysamoylov.effective.enums.EnumMapExample.Phase.GAS;
import static com.alekseysamoylov.effective.enums.EnumMapExample.Phase.LIQUID;
import static com.alekseysamoylov.effective.enums.EnumMapExample.Phase.SOLID;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

public class EnumMapExample {

    public enum Phase {
        SOLID, LIQUID, GAS;
    }

    private enum Transition {
        MELT(SOLID, LIQUID), FREEZE(LIQUID, SOLID),
        BOIL(LIQUID, GAS);

        private final Phase from;
        private final Phase to;

        Transition(Phase from, Phase to) {
            this.from = from;
            this.to = to;
        }

        private static final Map<Phase, Map<Phase, Transition>> m =
                Stream.of(values()).collect(groupingBy(t -> t.from,
                        () -> new EnumMap<>(Phase.class),
                        toMap(t -> t.to, t -> t,
                                (x, y) -> y, () -> new EnumMap<>(Phase.class))));

        public static Transition from(Phase from, Phase to) {
            return m.get(from).get(to);
        }
    }
}
