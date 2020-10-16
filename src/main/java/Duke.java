import task.*;

import java.io.IOException;
import java.util.*;
import java.io.FileWriter;

public class Duke {

    public static String askUserInput(Scanner userInput) {
        System.out.println("Enter an instruction: \nPlease select either todo / deadline / event / done / delete / find / list / quit.");
        String userInputString = userInput.nextLine();
        return userInputString;
    }

    public static Todo askTodoTask() {
        System.out.println("Please enter your todo task. :)");
        Scanner userInput = new Scanner(System.in);
        String userInputString = userInput.nextLine();
        Todo temp = new Todo(userInputString);
        return temp;
    }

    public static Deadline askDeadlineTask() {
        Scanner userInput1 = new Scanner(System.in);
        System.out.println("Please enter your deadline task. :)");
        String userInputString1 = userInput1.nextLine();
        Scanner userInput2 = new Scanner(System.in);
        System.out.println("Please enter your deadline. :)");
        String userInputString2 = userInput2.nextLine();
        Deadline temp = new Deadline(userInputString1, userInputString2);
        return temp;
    }

    public static Event askEventTask() {
        Scanner userInput1 = new Scanner(System.in);
        System.out.println("Please enter your event task. :)");
        String userInputString1 = userInput1.nextLine();
        Scanner userInput2 = new Scanner(System.in);
        System.out.println("Please enter your event duration. :)");
        String userInputString2 = userInput2.nextLine();
        Event temp = new Event(userInputString1, userInputString2);
        return temp;
    }

    public static void saveFile(ArrayList<Task> items) throws IOException {
        FileWriter writer = new FileWriter("duke.txt");
        for (Task task : items) {
            if ((task.getClassName()).equals("todo")) {
                writer.write("[T] | ");
            }
            if ((task.getClassName()).equals("deadline")) {
                writer.write("[D] | ");
            }
            if ((task.getClassName()).equals("event")) {
                writer.write("[E] | ");
            }
            if ((task.getTaskStatus()) == false) {
                writer.write("[✗] | ");
            } else {
                writer.write("[✓] | ");
            }

            if ((task.getClassName()).equals("deadline") || (task.getClassName()).equals("event")) {
                writer.write(task.getTaskName() + " | " + task.returnDate() + System.lineSeparator());
            } else {
                writer.write(task.getTaskName() + System.lineSeparator());
            }

        }
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        System.out.println("---------------------------------------");
        System.out.println("Hello! Welcome to yellow-fellow bot :>");
        System.out.println("What can I do for you?");
        System.out.println("---------------------------------------");
        ArrayList<Task> items = new ArrayList<>();
        Scanner userInput = new Scanner(System.in);
        String userInputString = askUserInput(userInput);
        int itemCount = 0;
        int noOfTasksCompleted = 0;
        while (!(userInputString.equals("exit") || userInputString.equals("quit"))) {
            if (userInputString.equals("find")) {
                System.out.println("Please enter your search name. :)");
                userInput = new Scanner(System.in);
                userInputString = userInput.nextLine();
                int temp_i = 1;
                System.out.println("-----------------------------------");
                for (int i = 0; i < items.size(); i++) {
                    if (items.get(i).getTaskName().contains(userInputString)) {
                        System.out.print(temp_i + ".");
                        if (items.get(i).getClassName().equals("todo")) {
                            System.out.print("[T]");
                        } else if (items.get(i).getClassName().equals("deadline")) {
                            System.out.print("[D]");
                        } else {
                            System.out.print("[E]");
                        }
                        if (items.get(i).getTaskStatus()) {
                            System.out.print("[✓] ");
                        } else {
                            System.out.print("[✗] ");
                        }
                        System.out.print(items.get(i).getTaskName() + "\n");
                        temp_i += 1;
                    }
                }
                System.out.println("-----------------------------------");
                userInputString = askUserInput(userInput);
            }
            if (userInputString.equals("todo")) {
                Todo input = askTodoTask();
                items.add(input);
                itemCount += 1;
                saveFile(items);
                userInputString = askUserInput(userInput);
            } else if (userInputString.equals("deadline")) {
                items.add(askDeadlineTask());
                itemCount += 1;
                saveFile(items);
                userInputString = askUserInput(userInput);
            } else if (userInputString.equals("event")) {
                items.add(askEventTask());
                itemCount += 1;
                saveFile(items);
                userInputString = askUserInput(userInput);
            } else if (userInputString.equals("list")) {
                System.out.println("---------------------------------------");
                System.out.println("You have " + itemCount + " tasks and completed " + noOfTasksCompleted + " in total. Congratulations! :>");
                for (int i = 1; i < itemCount + 1; i++) {
                    System.out.print(i + ".");
                    if (((items.get(i - 1)).getClassName()).equals("todo")) {
                        System.out.print("[T] ");
                    }
                    if (((items.get(i - 1)).getClassName()).equals("deadline")) {
                        System.out.print("[D] ");
                    }
                    if (((items.get(i - 1)).getClassName()).equals("event")) {
                        System.out.print("[E] ");
                    }
                    if (items.get(i - 1).getTaskStatus() == false) {
                        System.out.print("[✗] ");
                    } else {
                        System.out.print("[✓] ");
                    }
                    System.out.print((items.get(i - 1)).getTaskName());
                    if (((items.get(i - 1)).getClassName()).equals("todo")) {
                        System.out.println(" ");
                    }
                    if (((items.get(i - 1)).getClassName()).equals("deadline") || ((items.get(i - 1)).getClassName()).equals("event")) {
                        System.out.println(" " + (items.get(i - 1)).returnDate());
                    }
                }
                System.out.println("---------------------------------------");
                userInputString = userInput.nextLine();
            } else if (userInputString.equals("delete")) {
                userInput = new Scanner(System.in);
                System.out.println("Please enter the index of the task you would like to delete. :)");
                int indexTaskToDelete = Integer.parseInt(userInput.nextLine()) - 1;
                if (indexTaskToDelete > itemCount || itemCount == 0) {
                    System.out.println("Fail to delete! You don't have any task in the list now.");
                } else {
                    items.remove(indexTaskToDelete);
                    itemCount -= 1;
                    saveFile(items);
                    int temp_index = indexTaskToDelete + 1;
                    System.out.println("Congratulations! You have successfully removed task " + temp_index + " from your list. :)");
                    System.out.println("Enter an instruction: \nPlease select either todo / deadline / event / done / delete / find / list / quit.");
                }
                userInputString = userInput.nextLine();
            } else {
                System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                userInputString = userInput.nextLine();
            }
            if (userInputString.equals("done")) {
                Scanner userInputCompleteTask = new Scanner(System.in);
                System.out.println("Please key in the number of the task you have completed: ");
                String userInputCompleteTaskString = userInput.nextLine();
                int userInputCompleteTaskInt = Integer.parseInt(userInputCompleteTaskString);
                items.get(userInputCompleteTaskInt - 1).completeTask();
                noOfTasksCompleted += 1;
                saveFile(items);
                userInput = new Scanner(System.in);
                System.out.println("Enter an instruction: \nPlease select either todo / deadline / event / done / delete / find / list / quit.");
                userInputString = userInput.nextLine();
            }
        }
        System.out.println("---------------------------------------");
        System.out.println("You have " + itemCount + " tasks and completed " + noOfTasksCompleted + " in total. Congratulations! :>");
        for (int i = 1; i < itemCount + 1; i++) {
            System.out.print(i + ".");
            if (((items.get(i - 1)).getClassName()).equals("todo")) {
                System.out.print("[T] ");
            }
            if (((items.get(i - 1)).getClassName()).equals("deadline")) {
                System.out.print("[D] ");
            }
            if (((items.get(i - 1)).getClassName()).equals("event")) {
                System.out.print("[E] ");
            }
            if ((items.get(i - 1)).getTaskStatus() == false) {
                System.out.print("[✗] ");
            } else {
                System.out.print("[✓] ");
            }
            System.out.print((items.get(i - 1)).getTaskName());
            if (((items.get(i - 1)).getClassName()).equals("todo")) {
                System.out.println(" ");
            }
            if (((items.get(i - 1)).getClassName()).equals("deadline") || ((items.get(i - 1)).getClassName()).equals("event")) {
                System.out.println(" " + (items.get(i - 1)).returnDate());
            }

        }
    }
}
