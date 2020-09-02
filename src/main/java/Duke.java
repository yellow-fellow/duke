import java.util.*;

public class Duke {
    static class task{
        private Boolean completion = false;
        private String taskName;
        private String date;

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

        public String returnDate(){ return this.date; }

        String getClassName(){ String className = this.getClass().getSimpleName(); return className;}
    }
    public static class todo extends task{
        private String taskName;
        public todo(String taskName){
            this.taskName = taskName;
        }
        String getTaskName(){
            return this.taskName;
        }

        public String getClassName(){ String className = this.getClass().getSimpleName(); return className;}
    }

    public static class deadline extends task{
        private String taskName;
        private String date;

        public deadline (String taskName, String date){
            this.taskName = taskName;
            this.date = date;
        }

        String getTaskName(){
            return this.taskName;
        }

        public String returnDate(){ return this.date; }

        public String getClassName(){ String className = this.getClass().getSimpleName(); return className;}

    }
    public static class event extends task{
        private String taskName;
        private String date;

        public event (String taskName, String date){
            this.taskName = taskName;
            this.date = date;
        }

        String getTaskName(){
            return this.taskName;
        }

        public String returnDate(){ return this.date; }

        public String getClassName(){ String className = this.getClass().getSimpleName(); return className;}

    }

    public static void main(String[] args) {
        System.out.println("---------------------------------------");
        System.out.println("Hello! Welcome to yellow-fellow bot :>");
        System.out.println("What can I do for you?");
        System.out.println("---------------------------------------");
        task[] items = new task[100];
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter an instruction: \nPlease select either todo / deadline / event / list / quit.");
        String userInputString = userInput.nextLine();
        int itemCount = 0;
        int noOfTasksCompleted = 0;
        while(!(userInputString.equals("exit") || userInputString.equals("quit"))){
            if (userInputString.equals("todo")){
                userInput = new Scanner(System.in);
                System.out.println("Please enter your todo task. :)");
                userInputString = userInput.nextLine();
                todo temp = new todo(userInputString);
                items[itemCount] = temp;
                itemCount += 1;
            }
            if (userInputString.equals("deadline")){
                Scanner userInput1 = new Scanner(System.in);
                System.out.println("Please enter your deadline task. :)");
                String userInputString1 = userInput.nextLine();
                Scanner userInput2 = new Scanner(System.in);
                System.out.println("Please enter your deadline. :)");
                String userInputString2 = userInput.nextLine();
                deadline temp = new deadline(userInputString1,userInputString2);
                items[itemCount] = temp;
                itemCount += 1;
            }

            if (userInputString.equals("event")){
                Scanner userInput1 = new Scanner(System.in);
                System.out.println("Please enter your event task. :)");
                String userInputString1 = userInput.nextLine();
                Scanner userInput2 = new Scanner(System.in);
                System.out.println("Please enter your event duration. :)");
                String userInputString2 = userInput.nextLine();
                event temp = new event(userInputString1,userInputString2);
                items[itemCount] = temp;
                itemCount += 1;
            }
            userInput = new Scanner(System.in);
            System.out.println("Enter an instruction: \nPlease select either todo / deadline / event / list / quit.");
            userInputString = userInput.nextLine();
            if (userInputString.equals("done")){
                Scanner userInputCompleteTask = new Scanner(System.in);
                System.out.println("Please key in the number of the task you have completed: ");
                String userInputCompleteTaskString = userInput.nextLine();
                int userInputCompleteTaskInt = Integer.parseInt(userInputCompleteTaskString);
                items[userInputCompleteTaskInt-1].completeTask();
                noOfTasksCompleted += 1;
                userInput = new Scanner(System.in);
                System.out.println("Enter an instruction: \nPlease select either todo / deadline / event / list / quit.");
                userInputString = userInput.nextLine();
            }
        }
        System.out.println("---------------------------------------");
        System.out.println("You have " + itemCount + " tasks and completed " + noOfTasksCompleted + " in total. Congratulations! :>");
        for (int i=1;i<itemCount+1;i++){
            System.out.print(i + ".");
            if (((items[i-1]).getClassName()).equals("todo")){
                System.out.print("[T] ");
            }
            if (((items[i-1]).getClassName()).equals("deadline")){
                System.out.print("[D] ");
            }
            if (((items[i-1]).getClassName()).equals("event")){
                System.out.print("[E] ");
            }
            if (items[i-1].getTaskStatus() == false){
                System.out.print("[✗] ");
            }
            else{
                System.out.print("[✓] ");
            }
            System.out.print(items[i-1].getTaskName());
            if (((items[i-1]).getClassName()).equals("todo")){
                System.out.println(" ");
            }
            if (((items[i-1]).getClassName()).equals("deadline")||((items[i-1]).getClassName()).equals("event")){
                System.out.println(" " + (items[i-1]).returnDate());
            }

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