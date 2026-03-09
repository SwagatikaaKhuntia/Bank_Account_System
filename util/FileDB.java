package util;

import model.Account;

import java.io.*;
import java.util.*;

public class FileDB {

    static String FILE="accounts.txt";

    public static void save(List<Account> list){
        try(PrintWriter w=new PrintWriter(new FileWriter(FILE))){
            for(Account a:list){
                w.println(a.toFile());
            }
        }catch(Exception e){
            System.out.println("Save error");
        }
    }

    public static List<Account> load(){

        List<Account> list=new ArrayList<>();
        File f=new File(FILE);

        if(!f.exists()) return list;

        try(BufferedReader r=new BufferedReader(new FileReader(f))){

            String line;

            while((line=r.readLine())!=null){
                list.add(Account.fromFile(line));
            }

        }catch(Exception e){
            System.out.println("Load error");
        }

        return list;
    }
}