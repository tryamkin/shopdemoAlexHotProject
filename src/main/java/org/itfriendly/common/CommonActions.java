package org.itfriendly.common;

public class CommonActions {

    public static boolean checkOsForGitHub() {
        // для запуска на GitHub CI
        System.out.println(Config.OS_NAME_FOR_GIT);
        if (!Config.OS_NAME_FOR_GIT.contains("Linux")) {
            return false;
        } else {
            return true;
        }
    }
}
