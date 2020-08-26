import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        System.out.println("---------------------------------------");
        System.out.println("Hello! Welcome to yellow-fellow bot :>");
        System.out.println("What can I do for you?");
        System.out.println("---------------------------------------");
        boolean echo = true;
        while (echo){
            Scanner userInput = new Scanner(System.in);
            System.out.println("Enter a word: ");
            String userInputString = userInput.nextLine();
            if (userInputString.equals("bye")){
                echo = false;
                System.out.println("---------------------------------------");
                System.out.println("What a shame :( See you again soon!");
                System.out.println("---------------------------------------");
            }
            else{
                System.out.println("---------------------------------------");
                System.out.println("You typed " + userInputString);
                System.out.println("---------------------------------------");
            }
        }
    }
}
