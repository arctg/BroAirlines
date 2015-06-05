package logic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by dennis on 26.05.2015.
 */
public class LoginChecker {
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean check(String email){
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return matcher.find();
    }
}
