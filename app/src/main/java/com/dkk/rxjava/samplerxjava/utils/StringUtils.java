package com.dkk.rxjava.samplerxjava.utils;

/**
 * Created by deepak on 3/3/17.
 * String utils class handle all string related util operation
 */


public class StringUtils {

    /**
     *  isEmpty method will check whether input string is empty or not
     *  If input string empty it will return true otherwise false;
     * @param sourceString - input string
     * @return true or false
     */

    public static boolean isEmpty(String sourceString) {
        if(null == sourceString || sourceString.isEmpty()) {
            return true;
        }
        return !(sourceString.length()>0);

    }
}
