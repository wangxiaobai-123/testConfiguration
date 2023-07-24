package org.example.testConfigProject;

import org.example.testConfigProject.util.PropertiesUtils;

/**
 * Hello world!
 *
 */
public class







App
{
    public static void main( String[] args )
    {
        System.out.println(PropertiesUtils.getStringListProperty("values"));
        System.out.println(PropertiesUtils.getProperty("username"));
        System.out.println( "Hello World!" );
    }
}
