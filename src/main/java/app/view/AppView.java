package app.view;

import app.utils.AppStarter;
import app.utils.Constants;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class AppView {

    public int getOption() {

        Scanner input = new Scanner(System.in);
        input.useLocale(Locale.ENGLISH);

        int option = 0;

        getMenu();
        try {
            option = input.nextInt();
        } catch (InputMismatchException exception) {
            System.out.println(Constants.INCORRECT_VALUE_MSG);
            AppStarter.startApp();
        }

        return option;
    }

    private void getMenu() {
        System.out.print("""                
                
                OPTIONS:
                1 - Create user.
                2 - Read users.
                3 - Update user.
                4 - Delete user.
                5 - Read user by id.
                0 - Close the App.
                """);
        System.out.print("Input your option: ");
    }

    public void getOutput(String output) {
        if (output.equals("0")) {
            System.out.println(Constants.APP_CLOSE_MSG);
            System.exit(0);
        } else System.out.println(output);
    }
}
