package sit707_week4;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests functions in LoginForm.
 * @author Ahsan Habib
 */
public class LoginFormTest 
{

	@Test
	public void testStudentIdentity() {
		String studentId = "s224047344";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Spandan";
		Assert.assertNotNull("Student name is null", studentName);
	}
	
	@Test
    public void testFailEmptyUsernameAndEmptyPasswordAndDontCareValCode()
    {
		LoginStatus status = LoginForm.login(null, null);
		Assert.assertTrue( status.isLoginSuccess() == false );
    }
	
	@Test  
	public void testFailUsernameAndEmptyPasswordAndDontCareValCode()  
	{  
	LoginStatus status = LoginForm.login("Spandan", null);  
	Assert.assertTrue( status.isLoginSuccess() == false );  
	}  
	@Test  
	public void testFailEmptyUsernameAndPasswordAndDontCareValCode()  
	{  
	LoginStatus status = LoginForm.login(null, "spandan_pass");  
	Assert.assertTrue( status.isLoginSuccess() == false );  
	}  
	@Test  
	public void testFailWrongUsernameAndPasswordAndDontCareValCode()  
	{  
	LoginStatus status = LoginForm.login("Spandan", "spandan123");  
	Assert.assertTrue( status.isLoginSuccess() == false );  
	}  
	@Test  
	public void testFailUsernameAndWrongPasswordAndDontCareValCode()  
	{  
	LoginStatus status = LoginForm.login("Spandan", "spandan123");  
	Assert.assertTrue( status.isLoginSuccess() == false );  
	}  
	@Test  
	public void testPassUsernameAndPasswordAndDontCareValCode()  
	{  
	LoginStatus status = LoginForm.login("SpandanDas", "spandan_pass");  
	Assert.assertTrue( status.isLoginSuccess() == true );  
	}  
	@Test  
	public void testPassUsernameAndPasswordAndValCode()  
	{  
	LoginStatus status = LoginForm.login("SpandanDas", "spandan_pass");  
	Boolean valCode = LoginForm.validateCode(status.getErrorMsg());  
	Assert.assertTrue( valCode == true );  
	}  
	@Test  
	public void testFailWrongUsernameAndPasswordAndValCode()  
	{  
	LoginStatus status = LoginForm.login("null", "spandan_pass");  
	Boolean valCode = LoginForm.validateCode(status.getErrorMsg());  
	Assert.assertTrue( valCode == false );  
	}  
} 

