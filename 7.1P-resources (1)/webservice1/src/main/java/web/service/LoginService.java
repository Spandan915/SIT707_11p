package web.service;

/**
 * Business logic to handle login functions.
 * 
 * @author Ahsan.
 */
public class LoginService {

    /**
     * Static method returns true for successful login, false otherwise.
     * 
     * @param username
     * @param password
     * @param dob
     * @return
     */
    public static boolean login(String username, String password, String dob) {
        // Match a fixed user name and password.
        //
        if ("spandan".equals(username) && "spandan_abc".equals(password) && "2000-08-12".equals(dob)) {
            return true;
        }
        return false;
    }

}