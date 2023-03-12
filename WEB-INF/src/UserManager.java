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

    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        User user = new User("e@gmail.com", "ye", "L", "Donny");
        userManager.registerUser(user);

        User copy = userManager.loginUser(user);
        System.out.println(copy);
    }

    public Map<String, User> getUsers() {
        return users;
    }

    public void registerUser(User userToRegister) {
        if (!isValidUser(userToRegister)) {
            throw new InvalidParameterException("User has a field with missing values");
        } else if (users.containsKey(userToRegister.getEmail())) {
            throw new IllegalStateException("User is already registered");
        } else {
            users.put(userToRegister.getEmail(), userToRegister);
        }
    }

    public User loginUser(User userToLogin) {
        if (!isValidUser(userToLogin)) {
            throw new InvalidParameterException("User does not have all required fields");
        } else if (!users.containsKey(userToLogin.getEmail())) {
            throw new IllegalArgumentException("No accounts is associated with this email");
        } else if (!users.get(userToLogin.getEmail()).getPassword().matches(userToLogin.getPassword())) {//if the passwords do not match
            throw new IllegalStateException("Wrong password");
        } else {
            return userToLogin;
        }
    }

    private boolean isValidUser(User user) {
        return user != null
                && user.getEmail() != null && user.getPassword() != null && user.getFirstName() != null && user.getLastName() != null
                && !user.getEmail().isBlank() && !user.getPassword().isBlank() && !user.getFirstName().isBlank() && !user.getLastName().isBlank();
    }
}
