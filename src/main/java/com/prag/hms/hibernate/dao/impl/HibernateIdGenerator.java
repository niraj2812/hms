/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prag.hms.hibernate.dao.impl;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.dialect.Dialect;

import org.hibernate.engine.SessionImplementor;
import org.hibernate.exception.JDBCExceptionHelper;
import org.hibernate.id.Configurable;

import org.hibernate.id.IdentifierGenerator;
import org.hibernate.type.Type;

/**
 *
 * This class will generate a random value which can be use as Hibernate mapping
 *
 * generator value. To use this class ,In the *.hbm.xml file's generator class
 *
 * need to change into this class fully qualified name.
 *
 *
 *
 * @author Niraj Singh.
 *
 *
 *
 */
public class HibernateIdGenerator implements IdentifierGenerator, Configurable {

    private String prefix;
    private String schemaName;
    private String tableName;
    private String columnName;

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

    public Serializable generate(SessionImplementor si, Object o) throws HibernateException {
        if (si != null) {
            System.out.println("si connected!!");
            System.out.println("prefix=" + prefix);
            System.out.println("schema=" + schemaName);
            System.out.println("table=" + tableName);
            System.out.println("column=" + columnName);

        } else {
            System.out.println("si not connected");
        }
        return new StringBuffer(prefix).append("-").append(getNextNumber(si)).toString();
        //return "contact";
    }

    private Long getNextNumber(SessionImplementor session) {
        Long index = 0L;
        Connection con = (Connection) session.getBatcher().openConnection();

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

    public void configure(Type type, Properties params, Dialect dlct) throws MappingException {

        this.setPrefix(params.getProperty("prefix"));
        this.setSchemaName(params.getProperty("schemaName"));
        this.setTableName(params.getProperty("tableName"));
        this.setColumnName(params.getProperty("columnName"));
//        params.getProperty(PersistentIdentifierGenerator.)


    }
}
