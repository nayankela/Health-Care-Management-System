package utility;

public class ValidateAdmin {

	public boolean validate(String id, String password) {

		if (id.equals("admin") && password.equals("admin"))
			return true;
		else
			return false;
	}

}
