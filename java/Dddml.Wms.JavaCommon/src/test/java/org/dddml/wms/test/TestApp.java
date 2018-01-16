package org.dddml.wms.test;

import java.math.BigDecimal;

/**
 * Hello world!
 *
 */
public class TestApp
{
    public static void main( String[] args ) {

        //System.out.println(Boolean.FALSE == false);
        System.out.println(BigDecimal.ZERO);
        BigDecimal first = BigDecimal.valueOf(1L);
        System.out.println(first.add(BigDecimal.valueOf(0)));

    }
}
