/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mydeposits;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Alex
 */
public class Logic {
    private String Input_City;
    private int Input_Time;
    private int Input_Money;
    double INF;
    LinkedList<Deposit> List = new LinkedList<Deposit>();
    
    Logic(int Time, String City, int Money)
    {
        this.INF = 0.03;
        this.Input_City=City;
        this.Input_Money=Money;
        this.Input_Time=Time;
    }
    void show()
    {
        System.out.println(Input_City);
        System.out.println(Input_Time);
        System.out.println(Input_Money);
    }
    int calculate_deposit(Deposit temp, boolean inflation)
    {
        int result = 0;
        int P=temp.getMoney();
        int T=temp.getTime();
        int K=temp.getPercent();
        System.out.print(P+" "+T+""+K);
        System.out.println();
        result=P+(P*T*K*30/36500);
        if (inflation) result=(int) (result-(result*INF));
        System.out.print(result);
        System.out.println();
        return result;
    }
    void calculating(boolean inflation)
    {
        int temp = 0;
        Iterator i = List.iterator();
        while(i.hasNext())
        {
            Deposit obj = (Deposit) i.next();
            temp = this.calculate_deposit(obj, inflation);
            obj.setResult(temp);            
        }
        
    }
    
    void Sort()
    {
        Collections.sort(List, new Comparator<Deposit>() {
        public int compare(Deposit o1, Deposit o2) {
                return o1.compareTo(o2);
        }
        });
    }
    
    
    
    void show_string(ResultSet rs) throws SQLException
    {
        String tmp;
        for(int i=1;i<6;i++)
        {
            tmp= rs.getString(i);
            System.out.print(tmp+" ");
        }
    }

    LinkedList getDeposits()
    {
        return this.List;
    }
    public void LoadData()
    {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/deposits_table";
            con = DriverManager.getConnection(url, "root", "root");
            stmt = con.createStatement();
            
            rs = stmt.executeQuery("SELECT * FROM deposits WHERE City = '" + Input_City +"' and Time ='"+ Input_Time +"'");
            System.out.println("lol");
            while (rs.next()) {
                //String str = rs.getString(2);
                //System.out.println(str);
                Deposit temp = new Deposit(rs,Input_Money);
                List.add(temp);
                List.getLast().ShowIntoTerminal();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Эта часть позволяет нам закрыть все открытые ресуры
            // В противном случае возмжожны проблемы. Поэтому будьте
            // всегда аккуратны при работе с коннектами
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.err.println("Error: " + ex.getMessage());
            }
       }
    }
    
    
}
