package someTest;

/**
 * Created by shuailu on 5/8/15.
 */
public class SurrodateTest {

   public static void main(String[] args) {
       //int codepoint = 0x24B62;
       int codepoint = 0x1F484;
       if (((codepoint >= 0x20) && (codepoint <= 0xD7FF)) ||
           ((codepoint >= 0xE000) && (codepoint <= 0xFFFD)) ||
           ((codepoint >= 0x10000) && (codepoint <= 0x10FFFF))) {
           System.out.println("legal");
       }

       String str = new String(Character.toChars(codepoint));
       for (int n = 0; n < str.length(); n++) {
           if (Character.isSurrogate(str.charAt(n))) {
               System.out.println("is surrogate");
               if (Character.isHighSurrogate(str.charAt(n))) {
                   System.out.println("is high surrogate");
               }

               if (Character.isLowSurrogate(str.charAt(n))) {
                   System.out.println("is low surrogate");
               }

           }
       }

   }


}
