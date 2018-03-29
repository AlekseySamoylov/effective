package com.alekseysamoylov.effective.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

public class Anagrams {
    public static void oldApproach(List<String> words) {
        Map<String, Set<String>> groups = new HashMap<>();
        for (String word : words) {
            groups.computeIfAbsent(alphabetize(word), (unused) -> new HashSet<>()).add(word);
        }
        groups.values().forEach(System.out::println);
    }

    public static void newApproach(Path dictionary) throws IOException {
        try (Stream<String> words = Files.lines(dictionary)) {
            words.collect(groupingBy(Anagrams::alphabetize))
                    .values().forEach(System.out::println);
        }

    }

    private static String alphabetize(String word) {
        char[] a = word.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }
}
