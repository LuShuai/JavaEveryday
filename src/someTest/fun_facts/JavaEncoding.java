package someTest.fun_facts;

import java.nio.charset.Charset;

/**
 * Created by shuailu on 3/26/15.
 */
public class JavaEncoding {
    public static void main (String[] args) {
        String ch = "a";

        for (int index = 0; index < ch.length(); index++) {
            char c = ch.charAt(index);
            System.out.println(Character.isSurrogate(c));
            System.out.println(String.format("%04x", (int) c));

            /*
            The first letter takes 2 bytes so its hex expression would be 8 hex numbers, the first 4-group should be larger than 1100(d), and second 4-group should be larger than 1000(8),
            bu smaller than 1100(d)
            * */
        }
    }

    public static String getUTF8(String str) {
        byte[] bytes = str.getBytes(Charset.forName("UTF-8"));
        StringBuilder sb = new StringBuilder();
        for (int index = 0; index < bytes.length; index++) {
            sb.append(String.format("%02x", bytes[index]));
        }
        return new String(sb);
    }
}
