package tracker.controller.input;

import tracker.MenuOutException;
import java.util.Scanner;

public class ConsoleInput implements Input {
    /**
     * Waiting a user activity.
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * Method shows a message in the console, then reads the whole sequence of inserted symbols.
     * @param question String for printing on the console.
     * @return Whole sequence of inserted symbols.
     */
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    public String ask(String question, String[] range) {
        String key = this.ask(question);
        boolean exist = false;

        for (String value : range) {
            if (value.equals(key)) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Out of the range.");
        }
    }

}
