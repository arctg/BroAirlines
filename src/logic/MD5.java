package logic;

/**
 * Created by dennis on 24.05.2015.
 */
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {


    public static String getHash(String str) {

        MessageDigest md5 ;
        StringBuffer  hexString = new StringBuffer();

        try {
            md5 = MessageDigest.getInstance("md5");
            md5.reset();
            md5.update(str.getBytes());
            byte messageDigest[] = md5.digest();

            for (int i = 0; i < messageDigest.length; i++) {
                hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
            }
        }
        catch (NoSuchAlgorithmException e) {
            return e.toString();
        }

        return hexString.toString();
    }

}