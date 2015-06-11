package logic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by dennis on 26.05.2015.
 */

/**
 * Checking email fo correct pattern
 *  @see LoginChecker
 */
public class LoginChecker {

    /**
     * @value VALID_EMAIL_ADDRESS_REGEX - valid email by pattern
     *  @see Pattern
     */

    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
            //checks email pattern

    /**
     * checking email for correct pattern
     * @param email - client's imail
     * @return boolean
     */

    public static boolean check(String email){
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return matcher.find();
    }
}
