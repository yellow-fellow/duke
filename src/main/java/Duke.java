import java.util.*;

public class Duke {
    public static void main(String[] args) {
        System.out.println("---------------------------------------");
        System.out.println("Hello! Welcome to yellow-fellow bot :>");
        System.out.println("What can I do for you?");
        System.out.println("---------------------------------------");
        String[] items = new String[100];
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter a word: ");
        String userInputString = userInput.nextLine();
        int itemCount = 0;
        while(!(userInputString.equals("list"))){
            items[itemCount] = userInputString;
            itemCount += 1;
            userInput = new Scanner(System.in);
            System.out.println("Enter a word: ");
            userInputString = userInput.nextLine();
        }
        System.out.println("---------------------------------------");
        for (int i=1;i<itemCount+1;i++){
            System.out.println(i + "." + items[i-1]);
        }
        System.out.println("---------------------------------------\n\n");

        System.out.println("---------------------------------------");
        System.out.println("That's all boys. See you soon!");
        System.out.println("---------------------------------------");


        //Level 1
        /*boolean echo = true;
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
        }*/
    }

}