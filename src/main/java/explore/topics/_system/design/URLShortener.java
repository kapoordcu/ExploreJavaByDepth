package explore.topics._system.design;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class URLShortener {

    public static void main(String[] args) {
        URLShortener url = new URLShortener();
        url.createTinyURL();
        System.out.println(URLShortener.ipToHash("127.0.0.1"));
        System.out.println(URLShortener.getMd5("127.0.0.1"));
    }

    public String createTinyURL() {
        return null;
    }

    public static String base62(Integer decimal) {
        char[] s = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        String hash_str = "";
        while (decimal>0) {
            hash_str = s[decimal%62] + hash_str;
            decimal /= 62;
        }
        return hash_str;
    }

    //127.0.0.1
    public static String ipToHash(String ip) {
        String ipHash = Arrays.stream(ip.split("\\."))
                .map(Integer::parseInt)
                .map(nibble -> String.format("%02X", nibble))
                .collect(Collectors.joining());
        return ipHash;
    }

    public static String hashToIp(String hash) {
        return Stream.of(hash)
                .map( Base64.getDecoder()::decode )
                .flatMapToInt( bytes -> IntStream.range( 0, bytes.length )
                        .map( index -> bytes[index] & 0xFF ) )
                .mapToObj( String::valueOf )
                .collect( Collectors.joining( "." ) );
    }

    public static String getMd5(String input) {
        try {

            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // digest() method is called to calculate message digest
            //  of an input digest() return array of byte
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }

        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
//7F000001
//f528764d624db129b32c21fbca0cb8d6