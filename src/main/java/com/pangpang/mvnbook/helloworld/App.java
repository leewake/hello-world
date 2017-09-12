package com.pangpang.mvnbook.helloworld;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Hello world!
 *
 */
public class App 
{
/*    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );

        String email = "service@lvmama.org";

        *//*String regEx = "[a-zA-Z_]{1,}[0-9]{0,}@([a-zA-Z0-9]{1,}\\.){1,3}[a-zA-Z\\-]{1,}";

        Pattern pattern = Pattern.compile(regEx);

        Matcher matcher = pattern.matcher(email);

        System.out.println(matcher.find());*//*

        //String idCard = "[0-9]{6}(18|19|20)?([0-9]{2})([01][0-9])([01][0-9])([0-9]{3})([0-9]|X|x)?";

        String idCard = "(\\d{6})(18|19|20)?(\\d{2})([01]\\d)([0123]\\d)(\\d{3})(\\d|X|x)?";

        String test = "422155189006050009";

        Pattern pattern = Pattern.compile(idCard);

        Matcher matcher = pattern.matcher(test);

        System.out.print(matcher.find());
    }*/
}
