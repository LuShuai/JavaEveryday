package someTest;

/**
 * Created by shuailu on 8/26/15.
 */
public class CurrencyCal {

    private static final String INPUT = "UPDATE currency_settings\n"
                                        + "SET max_custom_charge_threshold=100\n"
                                        + "WHERE id=1 AND currency='AED';\n"
                                        + "\n"
                                        + "UPDATE currency_settings\n"
                                        + "SET max_custom_charge_threshold=200\n"
                                        + "WHERE id=2 AND currency='ARS';\n"
                                        + "\n"
                                        + "UPDATE currency_settings\n"
                                        + "SET max_custom_charge_threshold=30\n"
                                        + "WHERE id=3 AND currency='AUD';\n"
                                        + "\n"
                                        + "UPDATE currency_settings\n"
                                        + "SET max_custom_charge_threshold=60\n"
                                        + "WHERE id=4 AND currency='BRL';\n"
                                        + "\n"
                                        + "UPDATE currency_settings\n"
                                        + "SET max_custom_charge_threshold=30\n"
                                        + "WHERE id=5 AND currency='CAD';\n"
                                        + "\n"
                                        + "UPDATE currency_settings\n"
                                        + "SET max_custom_charge_threshold=25\n"
                                        + "WHERE id=6 AND currency='CHF';\n"
                                        + "\n"
                                        + "UPDATE currency_settings\n"
                                        + "SET max_custom_charge_threshold=15000\n"
                                        + "WHERE id=7 AND currency='CLP';\n"
                                        + "\n"
                                        + "UPDATE currency_settings\n"
                                        + "SET max_custom_charge_threshold=55000\n"
                                        + "WHERE id=8 AND currency='COP';\n"
                                        + "\n"
                                        + "UPDATE currency_settings\n"
                                        + "SET max_custom_charge_threshold=175\n"
                                        + "WHERE id=9 AND currency='EGP';\n"
                                        + "\n"
                                        + "UPDATE currency_settings\n"
                                        + "SET max_custom_charge_threshold=20\n"
                                        + "WHERE id=10 AND currency='EUR';\n"
                                        + "\n"
                                        + "UPDATE currency_settings\n"
                                        + "SET max_custom_charge_threshold=15\n"
                                        + "WHERE id=11 AND currency='GBP';\n"
                                        + "\n"
                                        + "UPDATE currency_settings\n"
                                        + "SET max_custom_charge_threshold=200\n"
                                        + "WHERE id=12 AND currency='HKD';\n"
                                        + "\n"
                                        + "UPDATE currency_settings\n"
                                        + "SET max_custom_charge_threshold=30000\n"
                                        + "WHERE id=13 AND currency='IDR';\n"
                                        + "\n"
                                        + "UPDATE currency_settings\n"
                                        + "SET max_custom_charge_threshold=100\n"
                                        + "WHERE id=14 AND currency='ILS';\n"
                                        + "\n"
                                        + "UPDATE currency_settings\n"
                                        + "SET max_custom_charge_threshold=1545\n"
                                        + "WHERE id=15 AND currency='INR';\n"
                                        + "\n"
                                        + "UPDATE currency_settings\n"
                                        + "SET max_custom_charge_threshold=2550\n"
                                        + "WHERE id=16 AND currency='JPY';\n"
                                        + "\n"
                                        + "UPDATE currency_settings\n"
                                        + "SET max_custom_charge_threshold=37500\n"
                                        + "WHERE id=17 AND currency='LBP';\n"
                                        + "\n"
                                        + "UPDATE currency_settings\n"
                                        + "SET max_custom_charge_threshold=350\n"
                                        + "WHERE id=18 AND currency='MXN';\n"
                                        + "\n"
                                        + "UPDATE currency_settings\n"
                                        + "SET max_custom_charge_threshold=100\n"
                                        + "WHERE id=19 AND currency='MYR';\n"
                                        + "\n"
                                        + "UPDATE currency_settings\n"
                                        + "SET max_custom_charge_threshold=30\n"
                                        + "WHERE id=20 AND currency='NZD';\n"
                                        + "\n"
                                        + "UPDATE currency_settings\n"
                                        + "SET max_custom_charge_threshold=75\n"
                                        + "WHERE id=21 AND currency='PEN';\n"
                                        + "\n"
                                        + "UPDATE currency_settings\n"
                                        + "SET max_custom_charge_threshold=1200\n"
                                        + "WHERE id=22 AND currency='PHP';\n"
                                        + "\n"
                                        + "UPDATE currency_settings\n"
                                        + "SET max_custom_charge_threshold=100\n"
                                        + "WHERE id=23 AND currency='QAR';\n"
                                        + "\n"
                                        + "UPDATE currency_settings\n"
                                        + "SET max_custom_charge_threshold=100\n"
                                        + "WHERE id=24 AND currency='RON';\n"
                                        + "\n"
                                        + "UPDATE currency_settings\n"
                                        + "SET max_custom_charge_threshold=100\n"
                                        + "WHERE id=25 AND currency='SAR';\n"
                                        + "\n"
                                        + "UPDATE currency_settings\n"
                                        + "SET max_custom_charge_threshold=175\n"
                                        + "WHERE id=26 AND currency='SEK';\n"
                                        + "\n"
                                        + "UPDATE currency_settings\n"
                                        + "SET max_custom_charge_threshold=35\n"
                                        + "WHERE id=27 AND currency='SGD';\n"
                                        + "\n"
                                        + "UPDATE currency_settings\n"
                                        + "SET max_custom_charge_threshold=60\n"
                                        + "WHERE id=28 AND currency='TRY';\n"
                                        + "\n"
                                        + "UPDATE currency_settings\n"
                                        + "SET max_custom_charge_threshold=775\n"
                                        + "WHERE id=29 AND currency='TWD';\n"
                                        + "\n"
                                        + "UPDATE currency_settings\n"
                                        + "SET max_custom_charge_threshold=25\n"
                                        + "WHERE id=30 AND currency='USD';\n"
                                        + "\n"
                                        + "UPDATE currency_settings\n"
                                        + "SET max_custom_charge_threshold=175\n"
                                        + "WHERE id=31 AND currency='VEF';\n"
                                        + "\n"
                                        + "UPDATE currency_settings\n"
                                        + "SET max_custom_charge_threshold=527500\n"
                                        + "WHERE id=32 AND currency='VND';\n"
                                        + "\n"
                                        + "UPDATE currency_settings\n"
                                        + "SET max_custom_charge_threshold=275\n"
                                        + "WHERE id=33 AND currency='ZAR';\n";

//    public static void main(String[] args) {
//        String[] tokens = INPUT.split(";");
//
//        for (int n = 0; n < tokens.length; n++) {
//            String pre = tokens[n].trim().split("threshold=")[1];
//            String[] subToken = pre.trim().split("\n");
//            String numString = subToken[0];
//            String sur = subToken[1];
//            System.out.println("UPDATE currency_settings");
//            System.out.println("SET max_custom_charge_threshold=" + Integer.parseInt(numString) * 400);
//            System.out.println(sur + ";");
//            System.out.println();
//        }
//    }

    public static void main(String[] args) {
        String[] tokens = INPUT.split(";");
        int i = 0;
        for (int n = 0; n < tokens.length; n++) {
            String[] sub = tokens[n].trim().split("=");
            if (sub.length >= 4) {
                String pre = sub[3].substring(1, 4);
                String res = "data.add(new Object[]{Currency."+ pre + "});";
                System.out.println(res);

                i++;
            }

        }
        System.out.println(i);

    }
}
