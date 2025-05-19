package web.service;

/**
 * Business logic to handle login functions.
 * 
 * @author Ahsan.
 */
public class LoginService {

	/**
	 * Static method returns true for successful login, false otherwise.
	 * @param username
	 * @param password
	 * @return
	 */
	public static boolean login(String username, String password, String dob) {
		System.out.println(dob);
		System.out.println(username);
		System.out.println(password);
		
        // Match fixed username, password, and date of birth.
        if ("ahsan".equals(username)
                && "ahsan_pass".equals(password)
                && "1995-08-30".equals(dob)) {
            return true;
        }
        return false;
    }
    
}
