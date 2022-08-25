package ata.usingstacksandqueues.amazonjava;

import java.util.List;
import java.util.Stack;

/**
 * Compiler check that ensures the curly braces and parenthesis in a file are evenly matched. The file must contain an even number of
 * opening and closing curly braces and parenthesis. This check does not perform any validation that the braces are in legal
 * locations in the file.
 *
 * The correct type of left brace needs to match the correct right brace. {(}) may have the correct amount of braces,
 * but a ( cannot be ended with a }.
 *
 * [NOTE] Your implementation does not need to handle escaped braces within strings
 * literals.
 */
public class BalancedBraceValidator {

    /**
     * Validates that the braces in the list of provided file characters are balanced.
     * @param fileCharacters all characters in a java file
     * @return true if the braces are balanced, false otherwise
     */
    public boolean check(List<Character> fileCharacters) {
        // TODO 1 Implement the check method

        // Build a Stack of Characters
        // Iterate over the fileCharacters
        //     If current character is { or (, add it to the stack
        //     If current character is } or )
        //           Check if the stack is empty or if the top is the wrong } or )
        //                 if so, return false
        // Return true after iteration over all fileCharacters

        Stack<Character> stack = new Stack<>();
        for (char c : fileCharacters) {
            if(c == '{' || c == '(') {
                stack.push(c);
            } else if (c == '}' || c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }

                char popped = stack.pop();
                if (popped == '{' && c != '}' ||
                    popped == '(' && c != ')') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
