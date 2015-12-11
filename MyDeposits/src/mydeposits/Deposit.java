/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mydeposits;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Alex
 */
public class Deposit 
{
    private String City;
    private String Bank;
    private int Time;
    private int Percent;
    private int Money;
    private int Result;
    Deposit(ResultSet rs, int Money) throws SQLException
    {
        this.Bank=rs.getString(3);
        this.City=rs.getString(2);
        this.Time=rs.getInt(4);
        this.Percent=rs.getInt(5);
        this.Money=Money;
        this.Result=0;
    }
    void ShowIntoTerminal()
    {
       System.out.println("City: "+City+"; Bank: "+Bank+"; Time: "+Time+" mounts; "+Percent+"%;");
    }
    public String getCity()
    {
        return this.City;
    }
    public String getBank()
    {
        return this.Bank;
    }
    public int getTime()
    {
        return this.Time;
    }
    public int getPercent()
    {
        return this.Percent;
    }
    public int getMoney()
    {
        return this.Money;
    }
    public float getResult()
    {
        return this.Result;
    }
    public void setResult(int Result)
    {
        this.Result=Result;
    }
    
}
