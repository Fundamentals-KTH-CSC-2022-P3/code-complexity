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

    //        System.out.println("Method 1: " + regexRecursion("", ""));
    private static final List<Pair<String, String>> BRANCH_COVERING_INPUTS = Arrays.asList(
            new Pair<String, String>("hello", ""),
            new Pair<String, String>("", "hello"),
            new Pair<String, String>("", "*"),
            new Pair<String, String>("h", "h"),
            new Pair<String, String>("h", "h?"),
            new Pair<String, String>("h ello", "h* e*o")
    );
    

//    private static List<String>

    @TestFactory
    List<DynamicTest> testAllRegexRecursionsWithAccurateWildcardPattern() {
        List<DynamicTest> dynamicTestList = new ArrayList<>();

        addMethod1ToList(dynamicTestList, WORKING_TEST_PATTERN, "Working pattern", Assertions::assertTrue);
        addMethod1ToList(dynamicTestList, BAD_TEST_PATTERN, "Bad pattern", Assertions::assertFalse);

        BRANCH_COVERING_INPUTS.forEach(testInput -> addMethod1ToList(
                dynamicTestList,
                testInput,
                testInput.first + ":" + testInput.second,
                Assertions::assertNotNull)
        );

        addMethod2ToList(dynamicTestList, WORKING_TEST_PATTERN, "Working pattern", Assertions::assertTrue);
        addMethod2ToList(dynamicTestList, BAD_TEST_PATTERN, "Bad pattern", Assertions::assertFalse);

        addMethod3ToList(dynamicTestList, WORKING_TEST_PATTERN, "Working pattern", Assertions::assertTrue);
        addMethod3ToList(dynamicTestList, BAD_TEST_PATTERN, "Bad pattern", Assertions::assertFalse);

        return dynamicTestList;
    }

    @AfterAll
    static void printEverything() {
        if (RegexMatching.passedBranches.size() == RegexMatching.numberOfBranches) {
            System.out.println("Full branch coverage achieved in RegexMatching::regexRecursive");
        } else {
            for(int i = 0; i < RegexMatching.numberOfBranches; i++) {
                if (!RegexMatching.passedBranches.contains(i)) {
                    System.err.println("Branch " + i + " not covered by tests");
                }
            }
        }
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

    void addMethod1ToList(List<DynamicTest> list, Pair<String, String> input, String patternName, Consumer<Boolean> assertMethod) {
        list.add(DynamicTest.dynamicTest(
                    "RegexRecursion Method 1: " + patternName,
                    () -> assertMethod.accept(RegexMatching.regexRecursion(input.first, input.second))
                )
        );
    }

    void addMethod2ToList(List<DynamicTest> list, Pair<String, String> input, String patternName, Consumer<Boolean> assertMethod) {
            list.add(DynamicTest.dynamicTest(
                    "RegexRecursion Method 2: " + patternName,
                    () -> assertMethod.accept(RegexMatching.regexRecursion(input.first, input.second, 0, 0))));
    }

    void addMethod3ToList(List<DynamicTest> list, Pair<String, String> input, String patternName, Consumer<Boolean> assertMethod) {
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

    record Pair<T, Y>(T first, Y second) {}
}