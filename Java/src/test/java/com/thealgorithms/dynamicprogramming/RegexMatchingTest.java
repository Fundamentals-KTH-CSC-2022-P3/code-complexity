package com.thealgorithms.dynamicprogramming;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

class RegexMatchingTest {

    private static final String[] TEST_STRINGS = new String[]{
            "racecar is a palindrome",
            "rar is a programme",
            "reaper is a pie"
    };
    private static final String WORKING_TEST_PATTERN = "r*r is ? p*e";
    private static final String BAD_TEST_PATTERN = "r*r? is a? p*me";

    private static final List<Triple<String, String, Boolean>> BRANCH_COVERING_INPUTS = Arrays.asList(
            new Triple<>("hello", "", false),
            new Triple<>("", "hello", false),
            new Triple<>("", "*", true),
            new Triple<>("h", "h", true),
            new Triple<>("h", "h?", false),
            new Triple<>("h ello", "h* e*o", true)
    );


    @TestFactory
    List<DynamicTest> testAllRegexRecursionsWithAccurateWildcardPattern() {
        List<DynamicTest> dynamicTestList = new ArrayList<>();

        addMethod1ToList(dynamicTestList, WORKING_TEST_PATTERN, "Working pattern", Assertions::assertTrue);
        addMethod1ToList(dynamicTestList, BAD_TEST_PATTERN, "Bad pattern", Assertions::assertFalse);

        BRANCH_COVERING_INPUTS.forEach(testInput -> addMethod1ToList(
                dynamicTestList,
                testInput,
                testInput.first + ":" + testInput.second,
                testInput.third ? Assertions::assertTrue : Assertions::assertFalse)
        );

        addMethod2ToList(dynamicTestList, WORKING_TEST_PATTERN, "Working pattern", Assertions::assertTrue);
        addMethod2ToList(dynamicTestList, BAD_TEST_PATTERN, "Bad pattern", Assertions::assertFalse);

        addMethod3ToList(dynamicTestList, WORKING_TEST_PATTERN, "Working pattern", Assertions::assertTrue);
        addMethod3ToList(dynamicTestList, BAD_TEST_PATTERN, "Bad pattern", Assertions::assertFalse);

        return dynamicTestList;
    }

    void addMethod1ToList(List<DynamicTest> list, String wildcardPattern, String patternName, Consumer<Boolean> assertMethod) {
        Arrays.stream(TEST_STRINGS).forEach(inputString -> {
            var inputPrefix = inputString.split(" ")[0];
            list.add(DynamicTest.dynamicTest(
                    "RegexRecursion Method 1 - " + patternName + ": " + inputPrefix,
                    () -> assertMethod.accept(RegexMatching.regexRecursion(inputString, wildcardPattern))));
        });
    }

    void addMethod2ToList(List<DynamicTest> list, String wildcardPattern, String patternName, Consumer<Boolean> assertMethod) {
        Arrays.stream(TEST_STRINGS).forEach(inputString -> {
            var inputPrefix = inputString.split(" ")[0];
            list.add(DynamicTest.dynamicTest(
                    "RegexRecursion Method 2 - " + patternName + ": " + inputPrefix,
                    () -> assertMethod.accept(RegexMatching.regexRecursion(inputString, wildcardPattern, 0, 0))));
        });
    }

    void addMethod3ToList(List<DynamicTest> list, String wildcardPattern, String patternName, Consumer<Boolean> assertMethod) {
        Arrays.stream(TEST_STRINGS).forEach(inputString -> {
            var inputPrefix = inputString.split(" ")[0];
            list.add(DynamicTest.dynamicTest(
                    "RegexRecursion Method 3 - " + patternName + ": " + inputPrefix,
                    () -> assertMethod.accept(RegexMatching.regexRecursion(
                            inputString,
                            wildcardPattern,
                            0,
                            0,
                            new int[inputString.length()][wildcardPattern.length()])
                    )
            ));});
    }

    void addMethod1ToList(List<DynamicTest> list, Triple<String, String, Boolean> input, String patternName, Consumer<Boolean> assertMethod) {
        list.add(DynamicTest.dynamicTest(
                    "RegexRecursion Method 1: " + patternName,
                    () -> assertMethod.accept(RegexMatching.regexRecursion(input.first, input.second))
                )
        );
    }

    void addMethod2ToList(List<DynamicTest> list, Triple<String, String, Boolean> input, String patternName, Consumer<Boolean> assertMethod) {
            list.add(DynamicTest.dynamicTest(
                    "RegexRecursion Method 2: " + patternName,
                    () -> assertMethod.accept(RegexMatching.regexRecursion(input.first, input.second, 0, 0))));
    }

    void addMethod3ToList(List<DynamicTest> list, Triple<String, String, Boolean> input, String patternName, Consumer<Boolean> assertMethod) {
        list.add(DynamicTest.dynamicTest(
                "RegexRecursion Method 3: " + patternName,
                () -> assertMethod.accept(RegexMatching.regexRecursion(
                        input.first,
                        input.second,
                        0,
                        0,
                        new int[input.first.length()][input.second.length()])
                )
        ));
    }

    record Triple<T, Y, U>(T first, Y second, U third) {}
}