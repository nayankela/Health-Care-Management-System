package utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationValidation {

	public boolean validPassword(String password) {

		boolean result = false;
		String REGEX = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,20}$";

		Pattern p = Pattern.compile(REGEX);

		Matcher m = p.matcher(password);
		if (m.matches()) {
			result = true;
		}

		return result;
	}

	public boolean validEmail(String email) {
		String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		boolean result = false;
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(email);
		if (matcher.matches()) {
			result = true;
		}
		return result;
	}

	public boolean bloodGroup(String bloodGroup) {
		String BLOOD_GROUP_PATTERN = "(A|B|AB|O)[+-]";
		boolean result = false;
		Pattern pattern = Pattern.compile(BLOOD_GROUP_PATTERN);
		Matcher matcher = pattern.matcher(bloodGroup);
		if (matcher.matches()) {
			result = true;
		}
		return result;
	}

	// VALIDATE MOBILE NUMBER.
	// 1) Begins with 0 or 91
	// 2) Then contains 6,7 or 8 or 9.
	// 3) Then contains 9 digits
	public boolean phoneNumber(String phoneNumber) {
		String MOBILE_PATTERN = "(0/91)?[7-9][0-9]{9}";
		Pattern pattern = Pattern.compile(MOBILE_PATTERN);

		boolean result = false;
		Matcher matcher = pattern.matcher(phoneNumber);
		if (matcher.matches()) {
			result = true;
		}
		return result;

	}

	// VALIDATE NAME
	public boolean name(String name) {

		String NAME = "[A-Z][a-z]*";

		Pattern pattern = Pattern.compile(NAME);

		boolean result = false;
		Matcher matcher = pattern.matcher(name);
		if (matcher.matches()) {
			result = true;
		}
		return result;
	}

	public boolean id(String id) {
		// validate ID
		String ID = "[A-Z]{2}-\\d{2,5}";

		Pattern pattern = Pattern.compile(ID);

		boolean result = false;
		Matcher matcher = pattern.matcher(id);
		if (matcher.matches()) {
			result = true;
		}
		return result;
	}
}
