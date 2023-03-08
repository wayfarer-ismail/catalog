import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

public class UserManager {

    private Map<String, User> users;

    public UserManager(Map<String, User> users) {
        this.users = users;
    }

    public UserManager() {
        this.users = new HashMap<>();
    }


    public Map<String, User> getUsers() {
        return users;
    }

    public void registerUser(User userToRegister) {
        if (!isValidUser(userToRegister)) {
            throw new InvalidParameterException("User has a field with missing values");
        }
    }

    private boolean isValidUser(User user) {
        return user != null
                && user.getEmail() != null && user.getPassword() != null && user.getFirstName() != null && user.getLastName() != null
                && !user.getEmail().isBlank() && !user.getPassword().isBlank() && !user.getFirstName().isBlank() && !user.getLastName().isBlank();
    }
}
