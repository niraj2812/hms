/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prag.hms.hibernate.util;

import java.sql.Connection;
import com.prag.hms.hibernate.dao.impl.HibernateIdGenerator;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Admin
 */
public class UniqueKeyGenerator {

    private String prefix;
    private String schemaName;
    private String tableName;
    private String columnName;

    public UniqueKeyGenerator() {
    }

    public UniqueKeyGenerator(String prefix, String schemaName, String tableName, String columnName) {
        this.prefix = prefix;
        this.schemaName = schemaName;
        this.tableName = tableName;
        this.columnName = columnName;
    }

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String generate(Session session) {
        String key = null;
        try {
            if (session != null) {
                key = new StringBuffer(prefix).append("-").append(getNextNumber(session)).toString();
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            } catch (HibernateException e) {
                System.out.println(e);
            }

        }
        return key;
        //return "contact";
    }

    private Long getNextNumber(Session session) {


        Long index = 0L;
        Connection con = (Connection) session.connection();

        CallableStatement statement = null;
        try {
            if (con != null) {
                statement = con.prepareCall("CALL proc_get_next_key(?,?,?,?)");
                if (statement != null) {
                    statement.setString(2, schemaName);
                    statement.setString(3, tableName);
                    statement.setString(4, columnName);
                    statement.registerOutParameter(1, Types.BIGINT);

                    statement.execute();
                    System.out.println("Output=" + statement.getLong(1));
                    index = statement.getLong(1);
                    con.commit();

                    System.out.println("Connected identifier");
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(HibernateIdGenerator.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(HibernateIdGenerator.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(HibernateIdGenerator.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        return index;

    }
}
