package org.dddml.wms.specialization;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by yangjiefeng on 2017/10/22.
 */
public class MD5Utils {

    private  MD5Utils() {
    }

    public static String md5(String sourceStr) throws RuntimeException {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            md.update(sourceStr.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            result = buf.toString();
            //System.out.println("md5(" + sourceStr + ",32) = " + result);
            //System.out.println("md5(" + sourceStr + ",16) = " + buf.toString().substring(8, 24));
        } catch (NoSuchAlgorithmException e) {
            //System.out.println(e);
            throw new RuntimeException("No md5 Algorithm.", e);
        }
        return result;
    }

    public static String shortMD5(String sourceStr) {
        String result = md5(sourceStr).substring(8, 24);
        return result;
    }

}
