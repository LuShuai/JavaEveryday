package string;

import java.util.ArrayList;

/**
 * Created by shuailu on 6/10/15.
 */
public class VersionComparer {

    public static int compareVersion(String version1, String version2) {
        ArrayList<Integer> version1List = tokenizeVersion(version1);
        ArrayList<Integer> version2List = tokenizeVersion(version2);

        int n = 0;
        while (true) {
            if (n < version1List.size() && n < version2List.size()) {
                int subVersion1 = version1List.get(n);
                int subVersion2 = version2List.get(n);
                if (subVersion1 > subVersion2) {
                    return 1;
                } else if (subVersion1 < subVersion2) {
                    return -1;
                }
            } else if (n == version1List.size() && n == version2List.size()) {
                return 0;
            } else {
                if (version1List.size() > version2List.size()) {
                    int sum = 0;
                    for (int m = n; m < version1List.size(); m++) {
                        sum += version1List.get(m);
                    }
                    return sum == 0 ? 0 : 1;
                } else {
                    int sum = 0;
                    for (int m = n; m < version2List.size(); m++) {
                        sum += version2List.get(m);
                    }
                    return sum == 0 ? 0 : -1;
                }
            }
            ++n;
        }
    }


    private static ArrayList<Integer> tokenizeVersion(String version) {
        ArrayList<Integer> versionList = new ArrayList<Integer>();
        String[] subNumber = version.split("\\.");
        if (subNumber.length == 0) {
            versionList.add(Integer.parseInt(version));
        }
        for (int n = 0; n < subNumber.length; n++) {
            versionList.add(Integer.parseInt(subNumber[n]));
        }
        return versionList;
    }

    public static void main(String[] args) {
        System.out.println(compareVersion("1.0", "1.1"));
    }

}
