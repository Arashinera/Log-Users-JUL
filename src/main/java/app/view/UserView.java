package app.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserView {

    Scanner input = new Scanner(System.in);

    public Map<String, String> getCreateData() {
        System.out.println("\nCREATE FORM");
        Map<String, String> data = new HashMap<>();

        System.out.print("Enter name: ");
        data.put("name", input.nextLine().trim());

        System.out.print("Enter email in format user@mail.com: ");
        data.put("email", input.nextLine().trim());

        return data;
    }

    public Map<String, String> getByIDData() {
        System.out.println("\nREAD BY ID FORM");
        Map<String, String> data = new HashMap<>();

        System.out.print("Input id: ");
        data.put("id", input.nextLine().trim());

        return data;
    }

    public Map<String, String> getUpdateData() {
        System.out.println("\nUPDATE FORM");
        Map<String, String> data = new HashMap<>();

        System.out.print("Input id: ");
        data.put("id", input.nextLine().trim());

        System.out.print("Input name: ");
        data.put("name", input.nextLine().trim());

        System.out.print("Input email in format user@mail.com: ");
        data.put("email", input.nextLine().trim());
        return data;
    }

    public Map<String, String> getDeleteData() {
        System.out.println("\nDELETE FORM");
        Map<String, String> data = new HashMap<>();

        System.out.print("Input id: ");
        data.put("id", input.nextLine().trim());

        return data;
    }

    public void getOutput(String output) {
        System.out.println(output);
    }
}
