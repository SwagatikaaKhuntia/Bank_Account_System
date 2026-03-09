package model;

public class Account {

    private int accNo;
    private String name;
    private double balance;

    public Account(int accNo,String name,double balance){
        this.accNo=accNo;
        this.name=name;
        this.balance=balance;
    }

    public int getAccNo(){ return accNo; }
    public String getName(){ return name; }
    public double getBalance(){ return balance; }

    public void setName(String n){ name=n; }

    public void deposit(double amt){
        balance += amt;
    }

    public void withdraw(double amt){
        balance -= amt;
    }

    public String toFile(){
        return accNo + "," + name + "," + balance;
    }

    public static Account fromFile(String line){
        String[] d=line.split(",");
        return new Account(
            Integer.parseInt(d[0]),
            d[1],
            Double.parseDouble(d[2])
        );
    }
}