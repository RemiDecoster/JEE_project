package org.tutorial;

import java.util.Scanner;

public class Date {
    private int day, year, month;

    public Date(int day, int year, int month) throws GestionException {
        this.day = day;
        this.month = month;
        this.year = year;
        if (day > 31) throw new GestionException("Entrez un jour correct !"); //TODO bien gerer les dates
        if (month > 12) throw new GestionException("Entrez un mois correct !");
    }
    public String toString()
    {
        String str=this.day()+"/"+this.month()+"/"+this.year();
        return str;
    }
    public int day ()
    {
        return this.day;
    }
    public int month ()
    {
        return this.month;
    }
    public int year ()
    {
        return this.year;
    }
    public void  day (int d)
    {
        this.day=d;
    }
    public void  month (int m)
    {
        this.month=m;
    }
    public void  year (int y)
    {
        this.year=y;
    }
    public void change ()
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Jour :");
        this.day = scan.nextInt();
        System.out.print("Mois :");
        this.month = scan.nextInt();
        System.out.print("Année :");
        this.year = scan.nextInt();
        System.out.print("Heure :");
    }
    public boolean equals (Date d)
    {
        boolean res=false;
        if ((this.month==d.month()) && (this.year==d.year()) && (this.day==d.day()) )
        {
            res = true;
        }
        return res;
    }

    public boolean jour (Date d)
    {
        boolean res=false;
        if ( (this.month==d.month()) && (this.year==d.year()) && (this.day==d.day()) )
        {
            res = true;
        }
        return res;
    }
    public boolean apres (Date d){  //determine si la date en parametre est anterieur à la date receveuse 
    	boolean res = false;
    	if (this.year>d.year()) //&& (this.month>d.month()) && (this.day>d.day()) && (this.hour>d.hour()) && (this.min>d.minute()) ) 
    	{
    		res = true;
    	}else if (this.year()==d.year()){
    		if (this.month()>d.month()) res = true;
    		else if (this.month==d.month()){
    			if (this.day>d.day()) res = true;
    		}
    	}
    	return res;
    }

}

