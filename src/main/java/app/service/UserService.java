package app.service;


import app.database.DBCheck;
import app.entity.User;
import app.entity.UserMapper;
import app.exceptions.UserException;
import app.exceptions.DBException;
import app.repository.impl.UserRepository;
import app.utils.Constants;
import app.utils.UserValidator;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserService {

    UserRepository repository;
    private static final Logger LOGGER = Logger.getLogger(UserService.class.getName());

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public String create(Map<String, String> data) {

        if (DBCheck.isDBExists()) {
            try {
                throw new DBException(Constants.DB_ABSENT_MSG);
            } catch (DBException exception) {
                LOGGER.log(Level.SEVERE, Constants.LOG_DB_ABSENT_MSG);
                return exception.getMessage();
            }
        }

        Map<String, String> errors = new UserValidator().validateContactData(data);

        if (!errors.isEmpty()) {
            try {
                throw new UserException("Check inputs", errors);
            } catch (UserException exception) {
                LOGGER.log(Level.WARNING, Constants.LOG_DATA_INPUTS_WRONG_MSG);
                return exception.getErrors(errors);
            }
        }

        return repository.create(new UserMapper().mapUserData(data));
    }

    public String read() {

        if (DBCheck.isDBExists()) {
            try {
                throw new DBException(Constants.DB_ABSENT_MSG);
            } catch (DBException exception) {
                LOGGER.log(Level.SEVERE, Constants.LOG_DB_ABSENT_MSG);
                return exception.getMessage();
            }
        }

        Optional<List<User>> optional = repository.read();

        if (optional.isPresent()) {

            List<User> list = optional.get();

            if (!list.isEmpty()) {
                AtomicInteger count = new AtomicInteger(0);
                StringBuilder sb = new StringBuilder();
                list.forEach((user) ->
                        sb.append(count.incrementAndGet()).append(") ").append(user.toString())
                );
                return sb.toString();
            } else {
                LOGGER.log(Level.WARNING, Constants.LOG_DATA_ABSENT_MSG);
                return Constants.DATA_ABSENT_MSG;
            }
        } else {
            LOGGER.log(Level.WARNING, Constants.LOG_DATA_ABSENT_MSG);
            return Constants.DATA_ABSENT_MSG;
        }
    }

    public String readById(Map<String, String> data) {

        if (DBCheck.isDBExists()) {
            try {
                throw new DBException(Constants.DB_ABSENT_MSG);
            } catch (DBException exception) {
                LOGGER.log(Level.SEVERE, Constants.LOG_DB_ABSENT_MSG);
                return exception.getMessage();
            }
        }

        Map<String, String> errors = new UserValidator().validateContactData(data);

        if (!errors.isEmpty()) {
            try {
                throw new UserException("Check inputs", errors);
            } catch (UserException exception) {
                LOGGER.log(Level.WARNING, Constants.LOG_DATA_INPUTS_WRONG_MSG);
                return exception.getErrors(errors);
            }
        }

        Optional<User> optional = repository.readById(Long.parseLong(data.get("id")));

        if (optional.isPresent()) {
            User user = optional.get();
            return user.toString();
        } else {
            LOGGER.log(Level.WARNING, Constants.LOG_DATA_ABSENT_MSG);
            return Constants.DATA_ABSENT_MSG;
        }
    }

    public String update(Map<String, String> data) {

        if (DBCheck.isDBExists()) {
            try {
                throw new DBException(Constants.DB_ABSENT_MSG);
            } catch (DBException exception) {
                LOGGER.log(Level.SEVERE, Constants.LOG_DB_ABSENT_MSG);
                return exception.getMessage();
            }
        }

        Map<String, String> errors = new UserValidator().validateContactData(data);

        if (!errors.isEmpty()) {
            try {
                throw new UserException("Check inputs", errors);
            } catch (UserException exception) {
                LOGGER.log(Level.WARNING, Constants.LOG_DATA_INPUTS_WRONG_MSG);
                return exception.getErrors(errors);
            }
        }

        User user = new UserMapper().mapUserData(data);

        if (repository.readById(user.getId()).isEmpty()) {
            return Constants.DATA_ABSENT_MSG;
        } else {
            return repository.update(user);
        }
    }

    public String delete(Map<String, String> data) {

        if (DBCheck.isDBExists()) {
            try {
                throw new DBException(Constants.DB_ABSENT_MSG);
            } catch (DBException exception) {
                LOGGER.log(Level.SEVERE, Constants.LOG_DB_ABSENT_MSG);
                return exception.getMessage();
            }
        }

        Map<String, String> errors = new UserValidator().validateContactData(data);

        if (!errors.isEmpty()) {
            try {
                throw new UserException("Check inputs", errors);
            } catch (UserException exception) {
                LOGGER.log(Level.WARNING, Constants.LOG_DATA_INPUTS_WRONG_MSG);
                return exception.getErrors(errors);
            }
        }

        Long id = new UserMapper().mapUserData(data).getId();

        if (!repository.isIdExists(id)) {
            return Constants.DATA_ABSENT_MSG;
        } else {
            return repository.delete(id);
        }
    }
}
