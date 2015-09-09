package math;

/**
 * Created by shuailu on 8/13/15.
 */
public class CurrencyList {

    public static String getCurrencyList(int num) {
        StringBuilder sb = new StringBuilder();
        sb.append("charge_threshold_tier_1=");
        sb.append(num);
        sb.append(", charge_threshold_tier_2=");
        sb.append(num * 2);
        sb.append(", charge_threshold_tier_3=");
        sb.append(num * 10);
        sb.append(", charge_threshold_tier_4=");
        sb.append(num * 20);
        sb.append(", charge_threshold_tier_5=");
        sb.append(num * 30);

        return new String(sb);
    }

    public static void main(String[] args) {
        //charge_threshold_tier_1
        int[] price1 =
            new int[]{100, 200, 30, 60, 30, 25, 15000, 55000, 175, 20, 15, 200, 30000, 100, 1545, 2550, 37500, 350, 100,
                      30, 75, 1200, 100, 100, 100, 175, 35, 60, 775, 25, 175, 527500, 275};

        String[] countries =
            new String[]{"AED", "ARS", "AUD", "BRL", "CAD", "CHF", "CLP", "COP", "EGP", "EUR", "GBP", "HKD", "IDR",
                         "ILS", "INR", "JPY", "LBP", "MXN", "MYR", "NZD", "PEN", "PHP", "QAR", "RON", "SAR", "SEK",
                         "SGD", "TRY", "TWD", "USD", "VEF", "VND", "ZAR"};

        int[] price2 =
            new int[]{175, 150, 5750, 225, 150, 1000, 250};

        String[] countries2 =
            new String[] {"CNY", "DKK", "HUF", "MAD", "NOK", "RUB", "UAH"};

        for (int n = 0; n < price2.length; n++) {
            String myString = getCurrencyList(price2[n]);
            System.out.println("UPDATE currency_settings");
            System.out.print("SET " + myString);
            System.out.println(", last_updated=SYSDATE");
            System.out.println("WHERE id=" + (n + 34) + " AND currency=\'" + countries2[n] + "\';");
            System.out.println();
        }

//        StringSelection stringSelection = new StringSelection(myString);
//        Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
//        clpbrd.setContents(stringSelection, null);
    }
}
