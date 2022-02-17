# Report for assignment 3

This is a template for your report. You are free to modify it as needed.
It is not required to use markdown for your report either, but the report
has to be delivered in a standard, cross-platform format.

## Project

Name: TheAlgorithms/Java

URL: https://github.com/TheAlgorithms/Java

The repository contains the implementation of different algorithms within sorting, searching, etc. 
In addition, the implementation of different data structures such as stacks and heaps.

## Onboarding experience

We initially meant to examine the [phishman3579/java-algorithms-implementation](https://github.com/phishman3579/java-algorithms-implementation)
repository for this assignment, but due to a lacking onboarding experience we
decided to change projects. The main reason for this was that the test suite
took more than two hours to run in full on a six core Intel i5-8400 CPU. This
would have made the project very painful to work with. We could have chosen to
limit the testing and not run the entire suite in full, but we decided that the
easier option was to simply switch projects.

Instead we chose [TheAlgorithms/Java](https://github.com/TheAlgorithms/Java)
as the repo to study. We have onboarded successfully and aim to keep working
with this project.

### Ease of building

We can build the project easily. It is a Maven repository, so it is as simple as
`mvn compile`.

> Did you have to install a lot of additional tools to build the software?

No, we all had Maven installed from the last assignment.

> Were those tools well documented?

There were no instructions on how to compile, run, build, et.c., the project,
but since Maven is such a standard and widespread tool, there was no need for
any such instructions. A single line in the README declaring that the project
utilizes Maven could perhaps be of use for people not already familiar with
Maven.

> Were other components installed automatically by the build script?

Yes, for instance JUnit was listed as a dependency. Maven handled all this
automatically.

> Did the build conclude automatically without errors?

Yes.

> How well do examples and tests run on your system(s)?

The tests run quickly, on the order of tens of seconds. However, one test file
is misnamed and therefore not executed when running the `test` target. That
file contains a couple of failing tests.

All tests that are formatted correctly pass without error.

## Complexity

1. What are your results for ten complex functions?
   * Did all methods (tools vs. manual count) get the same result?
   * Are the results clear?
2. Are the functions just complex, or also long?
3. What is the purpose of the functions?
4. Are exceptions taken into account in the given measurements?
5. Is the documentation clear w.r.t. all the possible outcomes?

Using the `lizard` tool we retrieved the following ten functions with the highest cyclomatic complexity numbers (CCNs): 

| CCN | Function             | File                                                                            | Lines   |
|-----|----------------------|---------------------------------------------------------------------------------|---------|
| 13  | `calc`               | src/main/java/com/thealgorithms/others/PageRank.java                            | 28-96   |
| 13  | `regexRecursion`     | src/main/java/com/thealgorithms/dynamicprogramming/RegexMatching.java           | 19-51   |
| 13  | `regexRecursion`     | src/main/java/com/thealgorithms/dynamicprogramming/RegexMatching.java           | 55-84   |
| 13  | `getNeighbors`       | src/main/java/com/thealgorithms/misc/WordBoggle.java                            | 86-121  |
| 14  | `deleteFixup`        | src/main/java/com/thealgorithms/datastructures/trees/RedBlackBST.java           | 241-296 |
| 15  | `calculateMaxOfMin`  | src/main/java/com/thealgorithms/datastructures/stacks/MaximumMinimumWindow.java | 40-97   |
| 16  | `isSorted`           | src/main/java/com/thealgorithms/sorts/LinkList_Sort.java                        | 10-121  |
| 16  | `regexRecursion`     | src/main/java/com/thealgorithms/dynamicprogramming/RegexMatching.java           | 88-121  |
| 17  | `remove`             | src/main/java/com/thealgorithms/datastructures/trees/BinaryTree.java            | 135-229 |
| 18  | `divideMessageWithP` | src/main/java/com/thealgorithms/others/CRCAlgorithm.java                        | 133-173 |

## Refactoring

Plan for refactoring complex code:

Estimated impact of refactoring (lower CC, but other drawbacks?).

Carried out refactoring (optional, P+):

git diff ...

## Coverage

### Tools

Document your experience in using a "new"/different coverage tool.

How well was the tool documented? Was it possible/easy/difficult to
integrate it with your build environment?

### Your own coverage tool

Show a patch (or link to a branch) that shows the instrumented code to
gather coverage measurements.

The patch is probably too long to be copied here, so please add
the git command that is used to obtain the patch instead:

git diff ...

What kinds of constructs does your tool support, and how accurate is
its output?

### Evaluation

1. How detailed is your coverage measurement?

2. What are the limitations of your own tool?

3. Are the results of your tool consistent with existing coverage tools?

## Coverage improvement

Show the comments that describe the requirements for the coverage.

Report of old coverage: [link]

Report of new coverage: [link]

Test cases added:

git diff ...

Number of test cases added: two per team member (P) or at least four (P+).

## Self-assessment: Way of working

Current state according to the Essence standard: ...

Was the self-assessment unanimous? Any doubts about certain items?

How have you improved so far?

Where is potential for improvement?

## Overall experience

What are your main take-aways from this project? What did you learn?

Is there something special you want to mention here?
