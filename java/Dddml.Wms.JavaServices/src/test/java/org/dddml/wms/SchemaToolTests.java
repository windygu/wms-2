package org.dddml.wms;

import org.dddml.wms.tool.hibernate.SchemaTool;

/**
 * Created by yangjiefeng on 2018/2/4.
 */
public class SchemaToolTests {

    private static String _sqlDirectory = "..\\Dddml.Wms.JavaServices\\src\\generated\\resources\\script";
    private static String _connectionString = "jdbc:mysql://localhost/test?characterEncoding=utf8&serverTimezone=GMT%2b8";

    // //////////////////////////////////

    public static void main(final String[] args) throws Exception {
        SchemaTool t = new SchemaTool();

        t.setSqlDirectory(_sqlDirectory);
        t.setConnectionString(_connectionString);
        //t.setDatabasePassword("...");

        t.setUp();

        // //////////////////////////////////
        t.hbm2DdlOutput();
        System.out.println("hbm2DdlOutput ok.");
        t.copyAndFixHbm2DdlCreateSql();
        System.out.println("copyAndFixHbm2DdlCreateSql ok.");

        // /////////////////////////////////
        t.dropCreateDatabaseAndSeed();
        System.out.println("dropCreateDatabaseAndSeed ok.");

        System.exit(0);
    }

}
