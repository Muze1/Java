package election;

import java.util.Scanner;
// The scanner class allows us to accept user input into our program
import java.util.ArrayList;
// This class allows us to add Array Lists into our code.
import java.util.Collections;
/* This class allows us to manipulate a collection of objects. In our case,
    it will help us find the max number of votes using less lines of code
    than a standard 'for' loop would require to give the same result.
*/


// Umair Mehmood & Anaah MohamedFarook
// Dr Ikram Ur Rehman
// 10/12/20
/* A programme to simulate an election ballot that accepts user votes, 
    prints the results at the end and declares the winner of the election.
*/


public class Election {

    public static void main(String[] args) {
    // We define our main class.

        Scanner scan = new Scanner(System.in);
        // Declaring our scanner object to accept user input.

        ArrayList<String> names = new ArrayList<String>();
        ArrayList<Integer> count = new ArrayList<Integer>();
        /* Our two empty ArrayLists are created, a String arraylist called 'names',
            and an Integer arraylist called 'count'. The 'names' arraylist will 
            store the names of the candidates that the user enters, and the 'count'
            arraylist will store the number of times that a specific candidate's
            name appears in the votes.
        */

        System.out.println("Please enter your votes (one vote per line, type 'quit' "
            + "when you are finished): ");
        // Our prompt for the user.

        while (true) {
        /* This is an infinite while loop, it will continue to run unless
            exited by a break statement.
        */
        String input = scan.nextLine();
        /* Here, we've created our scanner variable that stores the user's input.
            This variable will be tested for its input by the succeeding if
            statements. The prompt for the user will not repeat, since it is
            outside of the while loop, but the user can still add votes since
            this variable is declared within the loop.
        */
            if (input.equals("quit")) {
                break;
                /* Any time the loop runs, if the user enters 'quit', the while
                    loop will exit. We use the .equals method to compare strings
                    instead of using the == and != operators.
                */
            }
            else if (names.indexOf(input) == -1) {
                /* The .indexOf method checks an arraylist for the value within
                    the brackets (which, in our case, is the name that our user
                    has input) and returns the location (or index) of that object
                    within the list. If the object is not in the arraylist, the
                    returned value is -1 by default. We will be using this method
                    throughout our code.
                */
                names.add(input);
                count.add(1);
                /* This else if statement checks if the returned value of the 
                    method is -1. If true, it creates a new object in each of our
                    arraylists with the respective values.
                
                */
            }
            else if (names.indexOf(input) != -1) {
                /* If the returned value is anything other than -1, it means that
                    there is already an identical object it our arraylist. Instead
                    of creating a new object, we retrieve the value of the object
                    in our 'count' arraylist (which is relative to the one in our
                    'names' arraylist) using the index of 'names', and we store
                    this value in a newly declared variable after adding 1 to it.
                    Then we replace our existing value with the incremented number
                    stored in our variable.
                */
                int addVote = count.get(names.indexOf(input)) + 1;
                count.set(names.indexOf(input), addVote);
                /* Integer values in arraylists are immutable (they can't be
                    changed), which is why we need to do this rather than simply
                    adding 1 to our existing value.        
                */
            }
        }

        for (int i = 0; i < names.size(); i++) {
            /* This for loop cycles through both the arraylists using the variable
                we declared in its statement and prints out their values with each
                iteration.
            */
            System.out.println(names.get(i) + " had " + count.get(i) + " votes");
        }

        int winnerIndex = count.indexOf(Collections.max(count));
        /* We imported the Collections class at the start of our code and we use
            it here to find the largest value of counts, and then retrieve its
            location to be stored in our new variable.
        */
        String winnerFinal = names.get(winnerIndex);
        /* Then, we simply use the .get method to retrieve the value of the object
            in 'names' with the same location, and we have our winner!
        */

        System.out.println("The winner of the election is...");
        System.out.println("...");
        System.out.println("...");
        System.out.println("* * *   " + winnerFinal + "!!!   * * *");

        // Thank you for marking sir!
    }

}
