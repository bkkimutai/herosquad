package org.bkkimutai.Config;

import org.sql2o.Sql2o;

public class Database {
    public static Sql2o getDatabase(){
        return new Sql2o("jdbc:postgresql://localhost:5432/herosquad", "postgres", "Msama@012023");
    }
}
