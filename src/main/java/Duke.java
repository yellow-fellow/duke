import java.util.*;

public class Duke {
    static class task{
        private Boolean completion = false;
        private String taskName;

        task(){
            this.completion = completion;
            this.taskName = taskName;
        }

        void completeTask(){
            this.completion = true;
        }

        boolean getTaskStatus(){
            return this.completion;
        }

        String getTaskName(){
            return this.taskName;
        }

        void setTaskName(String input){
            this.taskName = input;
        }
    }
    public static void main(String[] args) {
        System.out.println("---------------------------------------");
        System.out.println("Hello! Welcome to yellow-fellow bot :>");
        System.out.println("What can I do for you?");
        System.out.println("---------------------------------------");
        task[] items = new task[100];
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter a word: ");
        String userInputString = userInput.nextLine();
        int itemCount = 0;
        int noOfTasksCompleted = 0;
        while(!(userInputString.equals("exit") || userInputString.equals("quit"))){
            task temp = new task();
            temp.setTaskName(userInputString);
            items[itemCount] = temp;
            itemCount += 1;
            userInput = new Scanner(System.in);
            System.out.println("Enter a word: ");
            userInputString = userInput.nextLine();
            if (userInputString.equals("done")){
                Scanner userInputCompleteTask = new Scanner(System.in);
                System.out.println("Please key in the number of the task you have completed: ");
                String userInputCompleteTaskString = userInput.nextLine();
                int userInputCompleteTaskInt = Integer.parseInt(userInputCompleteTaskString);
                items[userInputCompleteTaskInt-1].completeTask();
                noOfTasksCompleted += 1;
                userInput = new Scanner(System.in);
                System.out.println("Enter a word: ");
                userInputString = userInput.nextLine();
            }
        }
        System.out.println("---------------------------------------");
        System.out.println("You have " + itemCount + " tasks and completed " + noOfTasksCompleted + " in total. Congratulations! :>");
        for (int i=1;i<itemCount+1;i++){
            System.out.print(i + ".");
            if (items[i-1].getTaskStatus() == false){
                System.out.print("[✗] ");
            }
            else{
                System.out.print("[✓] ");
            }
            System.out.println(items[i-1].getTaskName());
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