package service;

import model.Account;
import util.FileDB;

import java.util.*;

public class BankService {

    private List<Account> accounts;

    public BankService(){
        accounts = FileDB.load();
    }

    public void create(int acc,String name,double bal){
        accounts.add(new Account(acc,name,bal));
        FileDB.save(accounts);
    }

    public Account find(int acc){
        for(Account a:accounts){
            if(a.getAccNo()==acc) return a;
        }
        return null;
    }

    public void delete(int acc){
        accounts.removeIf(a -> a.getAccNo()==acc);
        FileDB.save(accounts);
    }

    public void updateName(int acc,String newName){
        Account a=find(acc);
        if(a!=null){
            a.setName(newName);
            FileDB.save(accounts);
        }
    }

    public void deposit(int acc,double amt){
        Account a=find(acc);
        if(a!=null){
            a.deposit(amt);
            FileDB.save(accounts);
        }
    }

    public void withdraw(int acc,double amt){
        Account a=find(acc);
        if(a!=null && a.getBalance()>=amt){
            a.withdraw(amt);
            FileDB.save(accounts);
        }
    }

    public void transfer(int from,int to,double amt){
        Account a=find(from);
        Account b=find(to);

        if(a!=null && b!=null && a.getBalance()>=amt){
            a.withdraw(amt);
            b.deposit(amt);
            FileDB.save(accounts);
        }
    }

    public List<Account> getAll(){
        return accounts;
    }
}