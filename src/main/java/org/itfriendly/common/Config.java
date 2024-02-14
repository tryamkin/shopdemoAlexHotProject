package org.itfriendly.common;

public class Config {
    /**
     * Указываем имя браузера тут
     * CHROME
     * FIREFOX
     * ETC ...
     *
     */
    public static final String BROWSER_NAME="CHROME";
    /*
     for github action, он стартует на линуксе, и эта строка определяет операционку и далее хром запускается с ключём --headless (с запуском на вируальном мониторе)
     */
    public static final String OS_NAME_FOR_GIT=System.getProperty("os.name");
}
