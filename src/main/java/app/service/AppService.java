package app.service;

import app.controller.UserController;
import app.exceptions.OptionException;
import app.repository.impl.UserRepository;
import app.utils.AppStarter;
import app.utils.Constants;
import app.view.AppView;
import app.view.UserView;

public class AppService {

    UserRepository repository = new UserRepository();
    UserService service = new UserService(repository);
    UserView view = new UserView();
    UserController controller = new UserController(service, view);

    public void handleOption(int option) {
        switch (option) {
            case 1 -> controller.createUser();
            case 2 -> controller.readUsers();
            case 3 -> controller.updateUser();
            case 4 -> controller.deleteUser();
            case 5 -> controller.readUsersById();
            case 0 -> new AppView().getOutput(Integer.toString(option));
            default -> {
                try {
                    throw new OptionException(Constants.INCORRECT_OPTION_MSG);
                } catch (OptionException exception) {
                    new AppView().getOutput(exception.getMessage());
                    AppStarter.startApp();
                }
            }
        }
    }
}
