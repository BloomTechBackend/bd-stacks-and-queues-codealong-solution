# Amazon Java Compiler

## Introduction
Amazon has decided to internally distribute its own version of Java. Your team now owns writing the compiler
for the new Amazon Java version. Before the Java code is translated into machine code, the compiler does many syntax
checks. Today we will be implementing the first syntax check!

Valid Java files must have balanced curly braces and parenthesis, meaning there need to be the same number of left curly braces, '{'
as right curly braces, '}', similar with the '(' and ')', and each must correctly be ended by the corresponding right brace. The `AmazonJavaFileCompiler` first parses a file and then applies different
checks.

### Before Starting
We'll be using other Java files as *resources* to test our compiler. To make sure we can run and
debug our tests in IntelliJ, verify the directories `src/resources` and `tst/resources` are marked as
*Resources Root* and *Test Resources Root* respectively. You can do so by looking at the directories in IntelliJ's
project panel and looking for a small yellow icon on the folders.

If you don't see an icon, right click the directories and select 'Mark Directory as -> Resources Root' and 'Mark
Directory as -> Test Resources Root' from the context menu, depending on whether it's in the `src/main` or `src/test`
directory. Do **not** select 'unmark as...' since that means they already are marked as resource roots, and IntelliJ
should be able to access files within those folders.

### Implementing the Amazon Java Compiler Check
You will be implementing the `check` method in the `BalancedBraceValidator` class. The method is provided with a
list of characters from the file that is being compiled. The method should return `true` if the curly braces and parenthesis in the file
are balanced, and false otherwise.

Your check method does not need to handle the case of a `String` literal containing an escaped curly brace or parenthesis.

### Automatic Unit Testing your Validator
Unit tests have been provided in the `BalancedBraceValidatorTest` class for the check method.

### Applying the Brace Check to Amazon's Java files
 `AmazonJavaFileCompiler` is responsible for parsing a provided Amazon Java file, and then applying compilation
 checks in its `compile` method. Currently, whether a file compiles or not will be based only on this check. Your
 teammates will be adding new checks soon!

The  `AmazonJavaFileCompiler` contains a main method that you can run to interact with your compiler. 

You can verify that your compiler is working as expected by running the `AmazonJavaFileCompilerIntegrationTest` tests. 
The valid files should say they are valid and the invalid files should say they are invalid.
