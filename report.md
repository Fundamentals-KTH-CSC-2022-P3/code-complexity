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

### CCN of WordBoggle::getNeighbors

> What are your results? 

Lizard counts the CCN of the method
[`WordBoggle::getNeighbors`](https://github.com/Fundamentals-KTH-CSC-2022-P3/code-complexity/blob/3ff9b0fa6302aa1ccfaf2dbb55f60d60b074cf8c/Java/src/main/java/com/thealgorithms/misc/WordBoggle.java#L86)
as 13.
A manual count confirms this.

The CCN _M_ is defined as _M_ = _π_ - _s_ + 2, where _π_ is the number of
decisions in the method and _s_ is the number of exit point.

Counting the number of decisions by hand gives us that _π_ = 12, and there
is only one exit point, so the CCN _M_ = 13, which is the same result as was
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
