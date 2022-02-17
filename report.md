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

Did it build and run as documented?
    
See the assignment for details; if everything works out of the box,
there is no need to write much here. If the first project(s) you picked
ended up being unsuitable, you can describe the "onboarding experience"
for each project, along with reason(s) why you changed to a different one.

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

### Method for calculation of the cyclomatic complexity numbers

There are several equivalent definitions of the CCN. We decided to go with the
one described in lecture 4 of this course, where the CCN _M_ is defined as:

_M_ = _π_ - _s_ + 2,

where _π_ is the number of decisions in the method and _s_ is the number of exit
points. A decision is either a branching keyword (e.g. `if`, `while`, ...) or
a boolean operator evaluated by the branching keyword. For example,
`if (a && b)` counts as two decisions, since we have one keyword (`if`) and one
boolean operator (`&&`).

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
