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

| CCN | Function                                                                                                                                                                                                                    | Purpose                                                                                                                 | Necessity of the high CCN                                                                                                                                                                                                         |
|-----|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 13  | [`PageRank::calc`](https://github.com/Fundamentals-KTH-CSC-2022-P3/code-complexity/blob/3ff9b0fa6302aa1ccfaf2dbb55f60d60b074cf8c/Java/src/main/java/com/thealgorithms/others/PageRank.java#L28)                             | Calculate PageRank (PR) for a set of nodes.                                                                             | The Algorithm is complex. However, can reduce CCN by removing unnecessary for-loops.                                                                                                                                              |
| 13  | [`RegexMatching::regexRecursion`](https://github.com/Fundamentals-KTH-CSC-2022-P3/code-complexity/blob/main/Java/src/main/java/com/thealgorithms/dynamicprogramming/RegexMatching.java#L19)                                 | Check if a wildcard pattern that can include ´*´ and ´?´ matches with a given text.                                     | The function is of high CCN because it needs to perform many checks on the input. CCN could be reduced by splitting the code into smaller functions.                                                                              |
| 13  | [`RegexMatching::regexRecursion`](https://github.com/Fundamentals-KTH-CSC-2022-P3/code-complexity/blob/main/Java/src/main/java/com/thealgorithms/dynamicprogramming/RegexMatching.java#L55)                                 | Check if a wildcard pattern that can include ´*´ and ´?´ matches with a given text.                                     | The function is of high CCN because it needs to perform many checks on the input. CCN could be reduced by splitting the code into smaller functions.                                                                              |
| 13  | [`WordBoggle::getNeighbors`](https://github.com/Fundamentals-KTH-CSC-2022-P3/code-complexity/blob/3ff9b0fa6302aa1ccfaf2dbb55f60d60b074cf8c/Java/src/main/java/com/thealgorithms/misc/WordBoggle.java#L86)                   | Gather all neighbors to a 2-dimensional point on a grid, such that no neighbor is out of bounds.                        | Hard to implement this without doing an if-check for each possible neighbor, hence the high CCN may be reasonable.                                                                                                                |
| 14  | [`RedBlackBST::deleteFixup`](https://github.com/Fundamentals-KTH-CSC-2022-P3/code-complexity/blob/3ff9b0fa6302aa1ccfaf2dbb55f60d60b074cf8c/Java/src/main/java/com/thealgorithms/datastructures/trees/RedBlackBST.java#L241) | Restore the colouring on the nodes that remain in the Red-Black tree, after one node has been deleted.                  | The function requires many checks on the input to ensure correct rotations and color changes, hence the high CCN may be reasonable.                                                                                               |
| 15  | [`MaximumMinimumWindow::calculateMaxOfMin`](https://github.com/Fundamentals-KTH-CSC-2022-P3/code-complexity/blob/main/Java/src/main/java/com/thealgorithms/datastructures/stacks/MaximumMinimumWindow.java#L40)             | Find maximum of minimum for every window size in a given array.                                                         | The function has many single for-loops and can thereby solve the problem in time O(n). A naive implementation would result in lower CCN but take time O(n^2) instead.                                                             |
| 16  | [`LinkList_Sort::isSorted`](https://github.com/Fundamentals-KTH-CSC-2022-P3/code-complexity/blob/main/Java/src/main/java/com/thealgorithms/sorts/LinkList_Sort.java#L10)                                                    | An example program to sort a linked list with mergesort, insertionsort or heapsort and check that the list is sorted.   | Poorly written code with a lot of repetition leads to high CCN. The CCN could easily be reduced by dividing the code into several smaller functions.                                                                              |
| 16  | [`RegexMatching::regexRecursion`](https://github.com/Fundamentals-KTH-CSC-2022-P3/code-complexity/blob/main/Java/src/main/java/com/thealgorithms/dynamicprogramming/RegexMatching.java#L88)                                 | Check if a wildcard pattern that can include ´*´ and ´?´ matches with a given text.                                     | The function is of high CCN because it needs to perform many checks on the input. CCN could be reduced by splitting the code into smaller functions.                                                                              |
| 17  | [`BinaryTree::remove`](https://github.com/Fundamentals-KTH-CSC-2022-P3/code-complexity/blob/main/Java/src/main/java/com/thealgorithms/datastructures/trees/BinaryTree.java#L135)                                            | Delete a node from a binary search tree (BST).                                                                          | Several checks have to be performed to ensure correct removal of a node. For example, we have to check how many children the node has and act accordingly. The high CCN may be reasonable due to the complexity of the algorithm. However, it is possible to reduce the CCN by switching to a recursive design. On the other hand, then we introduce other risks such as stack overflow exceptions. |
| 18  | [`CRCAlgorithm::divideMessageWithP`](https://github.com/Fundamentals-KTH-CSC-2022-P3/code-complexity/blob/main/Java/src/main/java/com/thealgorithms/others/CRCAlgorithm.java#L133)                                          | The heart of the cyclic redundancy check (CRC) algorithm and will check if the message has changed during transmission. | CCN could be reduced by not considering the `boolean check` parameter and instead always check for bit errors. We don't know why the author wanted this parameter, it makes the code less readable and increases CCN.             |

### Method for calculation of the cyclomatic complexity numbers

There are several equivalent definitions of the CCN. We decided to go with the
one described in lecture 4 of this course, where the CCN _M_ is defined as:

_M_ = _π_ - _s_ + 2,

where _π_ is the number of decisions in the method and _s_ is the number of exit
points. A decision is either a branching keyword (e.g. `if`, `while`, ...) or
a boolean operator evaluated by the branching keyword. For example,
`if (a && b)` counts as two decisions, since we have one keyword (`if`) and one
boolean operator (`&&`).

### CCN of RegexMatching::regexRecursion

#### CCN of RegexMatching::regexRecursion (lines 19-51)

> What are your results?

Lizard counts the CCN of the method
[`RegexMatching::regexRecursion (19-51)`](https://github.com/Fundamentals-KTH-CSC-2022-P3/code-complexity/blob/feaffd9ee121376ba15f0cd408449df5f37a42f6/Java/src/main/java/com/thealgorithms/dynamicprogramming/RegexMatching.java)
as 13.
A manual count reaches the CCN of 8 instead. 

Counting the number of decisions by hand gives us that _π_ = 11, since there are 6 `if` 
statements in the method, 4 of which contains an `&&` or `||` operator, and 2 of which 
contain only a single boolean expression. There is only a single for loop. Furthermore, 
the method 5 exit points, so the CCN _M_ = 8. It can be concluded that the method used 
to calculate CCN in Lizard isn't extended for multiple exit points.

> Is this method with high CC also very long in terms of LOC?

No, the LOC is small but the CC is still high because of the amount of decisions taken in
the same method. 

> What is the purpose of this method? Is it related to the high CC?

The method matches a string with a regular expression, as well as checking if recursion 
on a substring of the string and the pattern is needed to run as well. Thus it correlates
to the high CC, as such a process will always need many decisions. 

> If your programming language uses exceptions: Are they taken into account by the tool?

Since multiple exit points in general aren't being supported, there's a high likelihood 
that exceptions would be treated the same way. 

> Is the documentation of the function clear [...]

The method lacks java documentation, though the comments gives a shallow explanation of 
the reason of the method's existence. The class is barely documented at all.

#### CCN of RegexMatching::regexRecursion (lines 55-84)

> What are your results?

Lizard counts the CCN of the method
[`RegexMatching::regexRecursion (55-84)`](https://github.com/Fundamentals-KTH-CSC-2022-P3/code-complexity/blob/feaffd9ee121376ba15f0cd408449df5f37a42f6/Java/src/main/java/com/thealgorithms/dynamicprogramming/RegexMatching.java)
as 13.
A manual count reaches the CCN of 8 instead.

The structure of the code is identical to the code in [the earlier regexRecursion method](#ccn-of-regexmatchingregexrecursion-lines-19-51)
. It also has the same purpose and documentation, etc, as the earlier method. 

#### CCN of RegexMatching::regexRecursion (lines 88-121)

> What are your results?

Lizard counts the CCN of the method
[`RegexMatching::regexRecursion (88-121)`](https://github.com/Fundamentals-KTH-CSC-2022-P3/code-complexity/blob/feaffd9ee121376ba15f0cd408449df5f37a42f6/Java/src/main/java/com/thealgorithms/dynamicprogramming/RegexMatching.java)
as 16.
A manual count reaches the CCN of 10 instead.

The structure of the code is almost identical to the code in [the earlier regexRecursion method](#ccn-of-regexmatchingregexrecursion-lines-19-51)
. It also has the same purpose and documentation, etc, as the earlier methods mentioned.

### CCN of WordBoggle::getNeighbors

> What are your results?

Lizard counts the CCN of the method
[`WordBoggle::getNeighbors`](https://github.com/Fundamentals-KTH-CSC-2022-P3/code-complexity/blob/3ff9b0fa6302aa1ccfaf2dbb55f60d60b074cf8c/Java/src/main/java/com/thealgorithms/misc/WordBoggle.java#L86)
as 13.
A manual count confirms this.

Counting the number of decisions by hand gives us that _π_ = 12, since there are 8
`if` statements in the method, 4 of which contains an `&&` operator, and 4 of
which contain only a single boolean expression. Furthermore, the method contains
only a single exit point, so the CCN _M_ = 13, which is the same result as was
given to us by lizard.

> Are the functions/methods with high CC also very long in terms of LOC?

The method is definitely on the longer side, but not terribly so, since each
`if`-statment has a body of only one line.

> What is the purpose of these functions? Is it related to the high CC?

The purpose is to gather all neighbors to a 2-dimensional point on a grid,
such that no neighbor is out of bounds. It is hard to do this in a readable
and easily understandable way that does not entail high CC. The most
straightforward way is to do one `if`-check for each possible neighbor,
which is what is done in the method.

> If your programming language uses exceptions: Are they taken into account by the tool?

Not applicable.

> Is the documentation of the function clear [...]

The method has no documentation at all, and the whole surrounding class is
barely documented at all.

### CCN of PageRank::calc

Lizard counts the CCN of the method
[`PageRank::calc`](https://github.com/Fundamentals-KTH-CSC-2022-P3/code-complexity/blob/3ff9b0fa6302aa1ccfaf2dbb55f60d60b074cf8c/Java/src/main/java/com/thealgorithms/others/PageRank.java#L28)
as 13.
A manual count confirms this.

Counting the number of decisions by hand gives us that _π_ = 12. There are 8 for-loops, 2 while-loops, and 2 if-statements,
and each of them only contains one boolean expression which explains the _π_ we get.
Furthermore, there is only one exit point, so the CCN _M_ = 13, which is the same result as was given to us by lizard.

> Are the functions/methods with high CC also very long in terms of LOC?

Yes, the `calc` function is 68 lines long which can be considered a long function.

> What is the purpose of these functions? Is it related to the high CC?

The purpose of the function is to calculate the PageRank value of a set of nodes in a graph.
They do this iteratively which explains why they need many loops. However, some loops are just
for printing the PageRank of each node, which may not be needed to have a working algorithm.
Consequentelly, they could reduce the CC by not printing the PageRank values, and move some parts
of the code to another function.

> Is the documentation of the function clear [...]

There are some comments inside the `calc` function which give an explanation to some parts of the code.
However, the method itself has no documentation and it is, therefore, hard to understand what the `calc` function is supposed to do.
The name of the function is not the best either `calc` can mean many different things.

### CCN of RedBlackBST::deleteFixup

Lizard counts the CCN of the method

[`RedBlackBST::deleteFixup`](https://github.com/Fundamentals-KTH-CSC-2022-P3/code-complexity/blob/3ff9b0fa6302aa1ccfaf2dbb55f60d60b074cf8c/Java/src/main/java/com/thealgorithms/datastructures/trees/RedBlackBST.java#L241)
as 14. A manual count confirms this.

Counting the number of decisions by hand gives us that _π_ = 13.

- there is 1 while loop
- 9 if statements
- and 3 `&&` operators

There is only one exit point.

_M_ = 13 - 1 + 2 = 14.

> Are the functions/methods with high CC also very long in terms of LOC?

The method `deleteFixup` is `55` lines long, without any whitespace, so it should be considered a long function

> What is the purpose of these functions? Is it related to the high CC?

The class `RedBlackBST` is an implementation of a [RedBlack tree](https://en.wikipedia.org/wiki/Red%E2%80%93black_tree), which is a self balancing binary search tree.

The function `deleteFixup` is called within the `delete` function. A `RBBST` is meant to have a specific coloring scheme. The purpose of this function is to restore the colouring on the nodes that remain, after one node has been deleted.

> Is the documentation of the function clear [...]

There is no documentation.

To understand what this class and function did, we had to use wikipedia. There should be proper documentation added, also the name `deleteFixup` is pretty bad, `ensureTreeHasCorrectColouring` would have been easier to understand.

### CCN of MaximumMinimumWindow::calculateMaxOfMin
Lizard counts the CCN of the method
[`MaximumMinimumWindow::calculateMaxOfMin`](https://github.com/Fundamentals-KTH-CSC-2022-P3/code-complexity/blob/main/Java/src/main/java/com/thealgorithms/datastructures/stacks/MaximumMinimumWindow.java#L40)
as 15.

A manual count confirms this:
With 3 while loops, 7 for loops, 2 if statements, and 2 `&&` operators, we have _π_ = 14. There is only one exit point, so _s_ = 1. This implies _M_ = 14 - 1 + 2 = 15.

> Are the functions/methods with high CC also very long in terms of LOC?

The function `calculateMaxOfMin` has `58` physical lines of code (LOC), which can be considered as a long function.

> What is the purpose of these functions? Is it related to the high CC?

The function `calculateMaxOfMin` finds the maximum of minimum for every window size in a given array with time complexity _O(n)_. Comparing to the naive approach with a nested for loop that takes _O(n^2)_, the implemented approach in this function is more efficient; it has several single for loops, where which takes linear time. The CC could be reduced by implementing the naive approach, but the time complexity would get higher. Here we have a trade-off between CC and time complexity.

> Is the documentation of the function clear [...]

The documentation of the function `calculateMaxOfMin` explains what it does on a high level. But the documentation does not
cover the different possible outcomes when executing different branches.

## Refactoring

#### RegexMatcher::regexRecursion (19-51)
> Plan for refactoring complex code:

The code is quite verbose, with choices of using multiple if statements with _&&_ additions instead of writing nested
if statements, leading to a higher complexity. Moving towards using nested if statements would thus decrease the
complexity. There's also a lot of code copied between other methods in this class, all of which are on the top 10 list
of classes with high complexity. Breaking this code out into methods would be preferred to decrease complexity further.
And lastly, instead of setting a variable to different values in an if statement and then returning it, doing a quick
return inside the if else statements would increase the number of exit nodes, thus lowering the CC even more.

> Estimated impact of refactoring (lower CC, but other drawbacks?).

The refactoring will, through use of better naming as well as decreasing the CC, make the code more readable as well as
decrease overall class size, as the splitting up of the method into smaller methods will allow the other methods in the
same class to use those as well.
But if we're singlehandedly focusing on reducing CC, the code will become messier,
since we'll be waning to introduce as many return-statements as possible to reduce the impact of the necessary CC
created by the if statements.

> Carried out refactoring (optional, P+):

The refactor was succesful, with the CC being lowered by 37.5% when using the CC count with multiple end nodes. With the
introduction of a helper method, as well as an increase in return statements, the CC was lowered at a cost of readability.

> git diff ...

The refactoring diff can be seen [here](https://github.com/Fundamentals-KTH-CSC-2022-P3/code-complexity/commit/6a0bbb4036f2eb9e8cce4f9086f474000e04acff).

#### WordBoggle::getNeighbors

> Plan for refactoring complex code:

The method WordBoggle::getNeighbors returns a list of points. This is done currently with a long chain of checking that
the first part of the coordinate is not smaller than zero, and the second part is not smaller than zero, and if the
first is not smaller than zero, and the second is not greater than max, and ... In short, it is very verbose.

This could be rewritten by letting two variables loop from -1 ..  1 in nested loops, and adding these onto the
coordinate, and then checking if it is valid. A helper method for checking validity of a coordinate could further
offload CC from the bit method.

> Estimated impact of refactoring (lower CC, but other drawbacks?).

The CC of the method should, of course, be lowered. The getNeighbors method has to check for a lot of edge cases
depending on whether the provided coordinates lie on a  top, bottom, left or right edge of the board, whether they lie
in a corner, et.c. Thus, it is our opinion that the  current, relatively high, complexity "makes sense". Rewriting the
method with a loop could hurt readability somewhat, but it will probably make the method a bit shorter. Nested loops
could also be harder to reason about than loop free code, even if the CCN is lower.

> Carried out refactoring (optional, P+):

The refactoring was successful, and passes our test suite. It was done more or less exactly as stated above. Without
the helper method the CC was reduced by less than 35%, so it was necessary to add it.

In the end, `getNeighbors` had its CCN reduced from 13 to 6, and a helper method `isInBounds` with a CCN of 4 was added.
A reduction from 13 to 6 is a reduction by 54%.

> git diff ...

The refactoring diff can be seen [here](https://github.com/Fundamentals-KTH-CSC-2022-P3/code-complexity/commit/dee6088a9dd0044cf92e1c219787758c2c640efe).

#### BinaryTree::remove

> Plan for refactoring complex code:

Right now the `BinaryTree::remove` function is written iteratively and contains many if-statements and loops.
One way to lower the CC substantially would be to implement the `BinaryTree::remove` function as a recursive function. 
This will result in lower CC because recursive function calls do not increase CC and we can remove many loops and if-statements. 

> Estimated impact of refactoring (lower CC, but other drawbacks?).

We will lower the CC substantially and most probably also reduce the number of lines of code (LOC), this might lead to a more readable solution.
However, there are some downsides with a recursive implementation that needs to be considered. For example, recursive functions have more overhead 
due to the call stack which then can harm performance. In addition, a recursive solution might run out of stack space and throw 
a stack-overflow exception.

> Carried out refactoring (optional, P+):

The refactoring was successful and passes our test suite. The method `BinaryTree::remove` was divided into two different methods, one private 
highly recursive method that the class calls internally, and another public method that the user of the interface can call. We lowered the CC 
from 17 to 8 by doing the refactoring, which is a reduction of 53%.

> git diff ...

The refactoring diff can be seen [here](https://github.com/Fundamentals-KTH-CSC-2022-P3/code-complexity/commit/491f4bec3ac84dd9355703c9514917e5bab28429).

#### RedBlackBST::deleteFixup

> Plan for refactoring complex code:

As the question states _Is the high complexity you identified really necessary?_, I'd argue that it is in this case. Well, not neccessarily for a single function. Everything is a bit nested in a lot of conditionals and it's tricky to get a handle on what's going on. But the function is very simple, it only repaints the tree, following the tree down, left or right. It performs the opposite actions if the direction is left than if it's right. So the high Cyclomatic complexity is somewhat justified, but we can hide it behind smaller functions.

> Estimated impact of refactoring (lower CC, but other drawbacks?).

The aim is to lower CC and increase readability. This will however increase the number of lines in the class.

> Carried out refactoring (optional, P+):

The refactoring was successful. In the function in the diff below has a clearly lower cyclomatic complexity.

## Coverage

### Tools

We tried to integrate several different branch coverage tools including Cobertura and OpenClover but could not make them work with our Maven environment. After many trials, we finally got Jacoco working. Once the tool was in place, it was straightforward to use.
To get a Jacoco report with different metrics including branch coverage we execute the command `mvn jacoco:prepare-agent test jacoco:report`.
Jacoco generates a navigable website where it is easy to see the branch coverage for each package, class, and function. Having this website with all the metrics gives a nice overview of the codebase and it becomes easy to identify the functions that need additional tests. 

### Your own coverage tool

Show a patch (or link to a branch) that shows the instrumented code to
gather coverage measurements.

The patch is probably too long to be copied here, so please add
the git command that is used to obtain the patch instead:

> git diff ...

We instrumented the source code manually for five methods. The five methods are as follows,
with links to their diffs:

1. [WordBoggle::getNeighbors](https://github.com/Fundamentals-KTH-CSC-2022-P3/code-complexity/commit/46e474c3461864e4e914269023cc574a05f946e8)
1. [BinaryTree::remove](https://github.com/Fundamentals-KTH-CSC-2022-P3/code-complexity/commit/5aa576d0a666313b27b1747e81513e9f702036f7)
1. [Placeholder2](your-link-here)
1. [Placeholder3](your-link-here)
1. [Placeholder4](your-link-here)

> What kinds of constructs does your tool support, and how accurate is
its output?

Our tool supports measuring coverage of any branch made by any branching construct, as long as
the human who instruments the code is capable of rewriting the code in a correct manner. The 
output should be completely accurate as long as no errors are introduced by the manual
instrumentation.

### Evaluation

1. How detailed is your coverage measurement?

Our coverage measurements measures the branch coverage of whatever code we decide to manually
instrument. The output given by our tool is both a branch-by-branch log of whichever branches
went uncovered, and the total branch coverage as a percentage.

2. What are the limitations of your own tool?

Our own coverage tool is quite limited. To measure coverage first every branch has to be
made explicit, by appending an `else` to every `if`, and splitting conjunctions and disjunctions
of boolean expressions to their atomic parts.

There is no support for ternary operators or exceptions. However, any code with these constructs
could be rewritten to allow for instrumentation without great effort.

The main drawback of our tool is that a great deal of repetitive and manual work is required, which
is both boring and a major potential source of errors. Each branch has to be labeled manually, and
when one is dealing with dozens of branches, it is inevitable that sooner or later one is mislabeled.

> 3. Are the results of your tool consistent with existing coverage tools?

We use Jacoco to measure branch coverage. Our own tool's results matches those given by Jacoco.

## Coverage improvement

> Generated jacoco reports

- Report of old coverage: [Link](https://fundamentals-kth-csc-2022-p3.github.io/jacoco/index.html)
- Report of new improved coverage: [Link](https://fundamentals-kth-csc-2022-p3.github.io/jacoco/index.html)

#### WordBoggle::getNeighbors:

> Show the comments that describe the requirements for the coverage.

```java
/**
 * This method lacked tests entirely.
 *
 * Returns all valid neighbor coordinates in a 2d array. Invalid coordinates are exactly the same as
 * out of bounds coordinates. Neighbors are coordinates on the form (i ± 1, j ± 1).
 *
 * This means that "corner" coordinates should result in three neighbors, "edge" coordinates five neighbors, and
 * "inner" coordinates eight neighbors.
 *
 * N.B. I *think* that you are only ever meant to call this method with 0 ≤ i < board.length and 0 ≤ j < board[0].length
 * and board[n].length = board[m].length for all n, m. However, no bounds checking is done in the original
 * implementation, and no documentation was written, so this is guesswork from me. //Arvid
 */
public static List<Integer[]> getNeighbors(int i, int j, char[][] board)
```

> Test cases added:

There were no tests for the entire WordBoggle class. The new tests can be seen [here](https://github.com/Fundamentals-KTH-CSC-2022-P3/code-complexity/blob/improved-coverage/Java/src/test/java/com/thealgorithms/misc/WordBoggleTest.java).
They provide 100% branch coverage. In total five test cases were added for total branch coverage. (By Arvid.)

#### BinaryTree::remove:

> Show the comments that describe the requirements for the coverage.

The method lacked tests entirerly. But down below are the comments that describe 
the requirements for coverage that we wrote.

```java
/**
 * To ensure that the remove function has been properly implemented we have
 * to test at least the following five cases:
 * 1) It is possible to remove the root node.
 * 2) It is possible to remove a node that does not have children.
 * 3) It is possible to remove a node with one child. The child node should then replace the removed node.
 * 4) It is possible to remove a node with two children. This is the most difficult case to implement.
 *    We have two different allowed outcomes which depend on the implementation,
 *    either the min node in the right subtree should replace the removed node,
 *    or the max node in the left subtree should replace the removed node (both options work).
 * 5) If the remove function is called with a key that does not exist in the tree, then we should not remove any node in the tree.
 */
```

> Test cases added:

The new tests can be seen [here](https://github.com/Fundamentals-KTH-CSC-2022-P3/code-complexity/blob/9b17c2f20554bd7ff8b51aec57162463e230e661/Java/src/test/java/com/thealgorithms/datastructures/BinaryTreeTest.java). 
In total five unit-tests were added to increase the branch coverage of the `BinaryTree::remove` function from 0% to 53%.

## Self-assessment: Way of working

We would say that we are in the state *In place*. We all use the same practices and tools to conduct our work. Furthermore, all team members have access to the same practices and tools that we use. There are some inconsistencies with how we do some parts of the work. For example, when it comes to reviewing pull requests some of our group members adapted a new practice for writing comments. They begin each comment with SD (should do), CD (could do), or MD (must do) to indicate how important the comment is. This is probably a good practice and suits our context, but all group members are not adapting to this way-of-working. Consequently, we do not fulfill the first criteria from the *Working well* state which is “Team members are making progress as planned by using and adapting the way-of-working to suit their current context.” To reach this state we should work on adapting our way-of-working to better suit our context, and ensure that everyone is on board with new practices such as writing SD, CD, or MD at the beginning of each pull request comment.

## Overall experience

Working with different metrics such as cyclomatic complexity (CC) and branch coverage was a new experience for many of us. We believe that these metrics can assist the programmer when it comes to writing high-quality and correct software. Especially interesting was the branch coverage report that we could generate using Jacoco. The Jacoco report was an easy-to-read overview that made it possible to identify if important branches are not being covered by the unit tests. It would be very hard to identify lacking test coverage without an automated tool such as Jacoco. 

## Statement of Contributions

The following is a list of each group member's main responsibilities. There were some overlap
and collaboration in several parts, so this is not exhaustive.

- Katrina Liang
  - Calculating the CCN of MaximumMinimumWindow::calculateMaxOfMin
  - Measure the branch coverage of MaximumMinimumWindow::calculateMaxOfMin
  - Add tests improving the branch coverage of MaximumMinimumWindow::calculateMaxOfMin
  - Refactor MaximumMinimumWindow::calculateMaxOfMin  to reduce CC
- Ludwig Kristoffersson
  - Calculating the CCN of RedBlackBST::deleteFixup
  - Measure the branch coverage of RedBlackBST::deleteFixup
  - Add tests improving the branch coverage of RedBlackBST::deleteFixup
  - Refactor RedBlackBST::deleteFixup to reduce CC
- Marcus Alevärn
   - Document the CCN of ten functions
   - Creation of automated branch coverage report with Jacoco
   - Writeup on our way of working
   - Writeup on our overall experience
   - Calculating the CCN of PageRank::calc
   - Measure the branch coverage of PageRank::calc
   - Add tests improving the branch coverage of PageRank::calc
   - Refactor PageRank::calc to reduce CC
- Samuel Philipson
   - Calculating the CCN of RegexMatching::regexRecursion
   - Measure the branch coverage of RegexMatching::regexRecursion
   - Add tests improving the branch coverage of RegexMatching::regexRecursion
   - Refactor RegexMatching::regexRecursion to reduce CC
- Arvid Siberov
   - Documentation of the onboarding experience
   - Documentation of our own coverage tool
   - Compile the statment of contributions
   - Calculating the CCN of WordBoggle::getNeighbors
   - Measure the branch coverage of WordBoggle::getNeighbors
   - Add tests improving the branch coverage of WordBoggle::getNeighbors
   - Refactor WordBoggle::getNeighbors to reduce CC
