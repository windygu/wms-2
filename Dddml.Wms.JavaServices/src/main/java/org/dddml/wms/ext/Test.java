package org.dddml.wms.ext;

import java.util.Date;

/**
 * Created by Li Yongchun on 2016/9/9.
 */
public class Test {
    private String field1;
    private int field2;
    private boolean filed3;
    private Integer filelds4;

    private Date filed5;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Test test = (Test) o;

        if (field2 != test.field2) return false;
        if (filed3 != test.filed3) return false;
        if (!field1.equals(test.field1)) return false;
        if (!filelds4.equals(test.filelds4)) return false;
        return filed5.equals(test.filed5);

    }

    @Override
    public int hashCode() {
        int result = field1.hashCode();
        result = 31 * result + field2;
        result = 31 * result + (filed3 ? 1 : 0);
        result = 31 * result + filelds4.hashCode();
        result = 31 * result + filed5.hashCode();
        return result;
    }
}
