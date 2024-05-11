package app.controller;

import app.service.UserService;
import app.utils.AppStarter;
import app.utils.Constants;
import app.view.UserView;

import java.util.Map;

public class UserController {

    UserView view;
    UserService service;

    public UserController(UserService service, UserView view) {
        this.service = service;
        this.view = view;
    }

    public void createUser() {

        Map<String, String> data = view.getCreateData();
        String res = service.create(data);

        if (res.equals(Constants.DB_ABSENT_MSG)) {
            view.getOutput(res);
            System.exit(0);
        } else {
            view.getOutput(res);
            AppStarter.startApp();
        }
    }

    public void readUsers() {

        String res = service.read();

        if (res.equals(Constants.DB_ABSENT_MSG)) {
            view.getOutput(res);
            System.exit(0);
        } else {
            view.getOutput("\nCONTACTS:\n" + res);
            AppStarter.startApp();
        }
    }

    public void readUsersById() {

        Map<String, String> data = view.getByIDData();
        String res = service.readById(data);

        if (res.equals(Constants.DB_ABSENT_MSG)) {
            view.getOutput(res);
            System.exit(0);
        } else {
            view.getOutput("\nUSER BY ID:\n" + res);
            AppStarter.startApp();
        }
    }

    public void updateUser() {

        Map<String, String> data = view.getUpdateData();
        String res = service.update(data);

        if (res.equals(Constants.DB_ABSENT_MSG)) {
            view.getOutput(res);
            System.exit(0);
        } else {
            view.getOutput(res);
            AppStarter.startApp();
        }
    }

    public void deleteUser() {

        Map<String, String> data = view.getDeleteData();
        String res = service.delete(data);

        if (res.equals(Constants.DB_ABSENT_MSG)) {
            view.getOutput(res);
            System.exit(0);
        } else {
            view.getOutput(res);
            AppStarter.startApp();
        }
    }
}
