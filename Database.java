import java.util.*;

public class Database {
    private Map<String, User> users;

    public Database() {
        users = new HashMap<>();
        // Add a test user
        this.createUser("testUser", "testPassword");
   }

    public boolean createUser(String username, String password) {
        if (users.containsKey(username)) {
            return false;
        }

        users.put(username, new User(username, password));
        return true;
    }

    public User getUser(String username) {
        return users.get(username);
    }

    public User authenticateUser(String username, String password) {
        User user = users.get(username);
    
        if (user == null) {
            return null;
        }
    
        return user.getPassword().equals(password) ? user : null;
    }
}
