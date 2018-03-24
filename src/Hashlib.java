import java.security.MessageDigest;

public class Hashlib {
    /* this is a helper class
    that implements a helper method that allows
    SHA256 encryption
     */

    public static String hash256Encryption(String feed) {
        try {
            // MessageDigest is an abstract class
            MessageDigest digestedMsg = MessageDigest.getInstance("SHA-256");
            // convert feed into byte and update digest (like Python digest.update())
            byte[] hash = digestedMsg.digest(feed.getBytes("UTF-8"));
            StringBuffer hexHash = new StringBuffer();
            for(int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) {
                    hexHash.append('0');
                }
                hexHash.append(hex);
            }
            return hexHash.toString();
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}
