## How to measure branch coverage 

1. Go to _Run -> Edit Configurations ..._
1. Click the plus sign in the top left to add a new configuration
1. Select JUnit in the drop down menu
1. Under _Build and run_, find the drop down menu that says "_Class_" and change it to "_All in directory_"
1. In the text field directly to the right of the "_All in directory_" drop down, enter the path to the `test` folder of the project.
1. Click the blue "_Modify options_" link to the right of the _Build and run_ header.
1. In the drop down, under _Code Coverage_, click _Use tracing_.
1. Open the same drop down again, and this time click _Specify classes and packages_.
1. There should pop up a box with the text "_No class patterns configured._" Click the plus sign with the downward triangle inside that box.
1. Select _Add a package..._
1. Select the correct package, e.g. `com.thealgorithms`, so that the entire project is covered without cluttering the output with packages from `com.sun` etc.
1. Press _OK_ to exit the _Run/Debug Configurations_ window.
1. Select the newly created configuration in the drop down menu in the top right of IntelliJ, and run it.
