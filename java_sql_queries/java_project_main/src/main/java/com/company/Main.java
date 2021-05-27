package com.company;
import com.mysql.cj.x.protobuf.MysqlxCrud;

import java.sql.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final String url = "jdbc:mysql://localhost:3306/db_films";
    private static final String user = "root";
    private static final String password = "1111";

    private static Connection con;
    private static Statement stmt;

    private static ResultSet rs;

    public static void main(String[] args) {
        while (true)
        {
            String input = StartStep();
            switch (input)
            {
                case ("1"):
                    ShowTable();
                    break;
                case ("2"):
                    DeleteRow();
                    break;
                case ("3"):
                    InsertRow();
                    break;
                case ("4"):
                    int tableIndex = TableChoising();
                    String tableName = "";
                    String query = "SHOW TABLES;";
                    try {
                        // opening database connection to MySQL server
                        con = DriverManager.getConnection(url, user, password);
                        // getting Statement object to execute query
                        stmt = con.createStatement();
                        // executing SELECT query
                        rs = stmt.executeQuery(query);
                        int index = 0;
                        while (rs.next())
                        {
                            index++;
                            if (index == tableIndex)
                            {
                                tableName = rs.getString(1);
                                break;
                            }

                        }
                        query = "select * from "+tableName;
                        rs = stmt.executeQuery(query);
                        Statement st=con.createStatement();
                        ResultSetMetaData rsmd = rs.getMetaData();
                        int NumOfCol=0;
                        NumOfCol=rsmd.getColumnCount();
                        //System.out.println("Query Executed!! No of Colm="+NumOfCol);]
                        ArrayList<String> insertedInfo = new ArrayList<String>();
                        String id;
                        System.out.print(rsmd.getColumnName(1)+"\n");
                        id = InputString();
                        boolean isContinue=false;
                        while (!isContinue) {
                            System.out.println("Что обновить?\n1. Выход.");

                            for (int i = 2; i <= NumOfCol; i++) {

                                System.out.println(i+". " + rsmd.getColumnName(i));
                            }
                            String updateChoice;
                            updateChoice = InputString();
                            //System.out.print(updateChoice);
                            if (updateChoice == "1")
                            {
                                isContinue = true;
                                break;
                            }

                            System.out.print(rsmd.getColumnName(Integer.parseInt(updateChoice))+" = ");
                            String newValue = InputString();
                            System.out.println();

                            query = "update " + tableName + " set "+rsmd.getColumnName(Integer.parseInt(updateChoice)) + " = \""+newValue + "\" where "+rsmd.getColumnName(1)+" = " + id;
                            System.out.println(query);
                            try {
                                stmt.executeUpdate(query);
                                System.out.println("Успешно.");
                            } catch (SQLException sqlEx) {
                                sqlEx.printStackTrace();
                                System.out.print("Введены неверные данные.");
                            }

                            System.out.println();
                        }



                    } catch (SQLException sqlEx) {
                        sqlEx.printStackTrace();
                    } finally {
                        //close connection ,stmt and resultset here
                        try { con.close(); } catch(SQLException se) { /*can't do anything */ }
                        try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
                        try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
                    }
                    break;
                default:
                    System.out.println("Неверная входная строка.");
                    break;
            }



        }
    }

    private static void DeleteRow() {
        int tableIndex = TableChoising();
        String tableName = "";
        String query = "SHOW TABLES;";
        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);
            // getting Statement object to execute query
            stmt = con.createStatement();
            // executing SELECT query
            rs = stmt.executeQuery(query);
            int index = 0;
            while (rs.next())
            {
                index++;
                if (index == tableIndex)
                {
                    tableName = rs.getString(1);
                    break;
                }

            }
            query = "select * from "+tableName;
            rs = stmt.executeQuery(query);
            Statement st=con.createStatement();
            ResultSetMetaData rsmd = rs.getMetaData();
            int NumOfCol=0;
            NumOfCol=rsmd.getColumnCount();
            //System.out.println("Query Executed!! No of Colm="+NumOfCol);]
            String id;

                System.out.print(rsmd.getColumnName(1)+"\n");
                id = InputString();



            query = "delete from "+tableName+" where "+rsmd.getColumnName(1)+" = "+id;
            System.out.print(query);
            try
            {stmt.executeUpdate(query);}
            catch(SQLException sqlEx)
            {
                sqlEx.printStackTrace();
                System.out.print("Введены неверные данные.");
            }

            System.out.println();




        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
            try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
        }
    }

    private static void InsertRow() {
        int tableIndex = TableChoising();
        String tableName = "";
        String query = "SHOW TABLES;";
        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);
            // getting Statement object to execute query
            stmt = con.createStatement();
            // executing SELECT query
            rs = stmt.executeQuery(query);
            int index = 0;
            while (rs.next())
            {
                index++;
                if (index == tableIndex)
                {
                    tableName = rs.getString(1);
                    break;
                }

            }
            query = "select * from "+tableName;
            rs = stmt.executeQuery(query);
            Statement st=con.createStatement();
            ResultSetMetaData rsmd = rs.getMetaData();
            int NumOfCol=0;
            NumOfCol=rsmd.getColumnCount();
            //System.out.println("Query Executed!! No of Colm="+NumOfCol);]
            ArrayList<String> insertedInfo = new ArrayList<String>();
            for (int i = 1;i<=NumOfCol;i++)
            {
                System.out.print(rsmd.getColumnName(i)+" type: "+rsmd.getColumnType(i)+"\n");
                insertedInfo.add(InputString());
            }
            query = "insert into "+ tableName + " values(";
            for( int i = 1;i<= insertedInfo.size();i++)
            {
                query+="\""+insertedInfo.get(i-1)+"\"";
                if (i != insertedInfo.size())
                {
                    query+=",";
                }
            }
            query+=");";
            System.out.print(query);
            try
            {stmt.executeUpdate(query);}
            catch(SQLException sqlEx)
            {
                sqlEx.printStackTrace();
                System.out.print("Введены неверные данные.");
            }

            System.out.println();




        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
            try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
        }
    }


    private static void ShowTable() {
        int tableIndex = TableChoising();
        String tableName = "";
        String query = "SHOW TABLES;";
        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);
            // getting Statement object to execute query
            stmt = con.createStatement();
            // executing SELECT query
            rs = stmt.executeQuery(query);
            int index = 0;
            while (rs.next())
            {
                index++;
                if (index == tableIndex)
                {
                    tableName = rs.getString(1);
                    break;
                }

            }
            query = "select * from "+tableName;
            rs = stmt.executeQuery(query);
            Statement st=con.createStatement();
            ResultSetMetaData rsmd = rs.getMetaData();
            int NumOfCol=0;
            NumOfCol=rsmd.getColumnCount();
            //System.out.println("Query Executed!! No of Colm="+NumOfCol);
            for (int i = 1;i<=NumOfCol;i++)
            {
               System.out.print(rsmd.getColumnName(i)+"\t\t");
            }
            System.out.println();
            while (rs.next())
            {
                for (int i = 1;i<=NumOfCol;i++)
                {
                   System.out.print(rs.getString(i)+"\t\t");
                }
                System.out.println();

            }


        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
            try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
        }
    }

    private static int TableChoising() {
        int tableIndex = 0;
        System.out.println("Выберите таблицу:\n");
        String query = "SHOW TABLES;";
        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);
            // getting Statement object to execute query
            stmt = con.createStatement();
            // executing SELECT query
            rs = stmt.executeQuery(query);
            int index = 0;
            while (rs.next()) {
                index++;
                String result = rs.getString(1);
                System.out.println(Integer.toString(index) +". "+ result);
            }
            tableIndex = Integer.valueOf(InputString());

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
            try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
        }
        return tableIndex;
    }

    private static String StartStep() {
        String baseString =
                     "1. Показать содержимое таблицы.\n" +
                     "2. Удалить запись.\n" +
                     "3. Добавить запись.\n" +
                     "4. Редактировать запись.\n";
        System.out.println(baseString);

        String input = InputString();
        return input;
    }

    private static String InputString() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }


}
