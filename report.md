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
| 17  | [`BinaryTree::remove`](https://github.com/Fundamentals-KTH-CSC-2022-P3/code-complexity/blob/main/Java/src/main/java/com/thealgorithms/datastructures/trees/BinaryTree.java#L135)                                            | Delete a node from a binary search tree (BST).                                                                          | Several checks have to be performed to ensure correct removal of a node. For example, we have to check how many children the node has and act accordingly. The high CCN may be reasonable due to the complexity of the algorithm. |
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

The function `calculateMaxOfMin` finds the maximum of minimum for every window size in a given array with time complexity _O(n)_. Comparing to the naive approach with a nested triple for loop that takes _O(n^3)_, the implemented approach in this function is more efficient; it has several single for loops, where which takes linear time. The CC could be reduced by implementing the naive approach, but the time complexity would get higher. Here we have a trade-off between CC and time complexity.

> Is the documentation of the function clear [...]

The documentation of the function `calculateMaxOfMin` explains what it does on a high level. But the documentation does not
cover the different possible outcomes when executing different branches.

## Refactoring

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




#### MaximumMinimumWindow::calculateMaxOfMin

> Plan for refactoring complex code:

As mentioned in section CCN of MaximumMinimumWindow::calculateMaxOfMin, the function `MaximumMinimumWindow::calculateMaxOfMin` implements several for-loops to reduce the time complexity of the algorithm at the expense of the cyclomatic complexity. However, it is however possible to reduce the CC by dividing the function into several smaller functions.

In `MaximumMinimumWindow::calculateMaxOfMin`, two arrays are created to store the indexes of the first smaller elements on the _left_ side of each element, and the first smaller elements on the _right_ side of each element. These two arrays could be created in two separate private functions: `smallerOnLeft` and `smallerOnRight`. The function `calculateMaxOfMin` will call these two functions and find the final answer.

> Estimated impact of refactoring (lower CC, but other drawbacks?).

The CC will essentially be reduced by splitting the function into several smaller functions. The program will also be more readable.

> Carried out refactoring (optional, P+):

After refactoring, with 4 for-loops and 1 exit point, the function `calculateMaxOfMin` has a new CC of _M_ = 4 - 1 + 2 = 5, which is a reduction of 67% (CC before was 15). Both of the newly implemented functions `smallerOnLeft` and `smallerOnRight` has a CC of _M_ = 4 - 1 + 2 = 5.

> git diff ...

The refactoring diff can be found [here](https://github.com/Fundamentals-KTH-CSC-2022-P3/code-complexity/commit/21eacbae9165cff80c1364c6532ab1b62e1428fd).


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
