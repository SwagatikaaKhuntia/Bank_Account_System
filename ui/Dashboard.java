package ui;

import service.BankService;
import model.Account;

import javax.swing.*;

public class Dashboard extends JFrame{

    BankService service=new BankService();

    JTextArea area=new JTextArea();

    public Dashboard(){

        setTitle("Bank Dashboard");
        setSize(600,450);
        setLayout(null);

        JButton create=new JButton("Create");
        JButton deposit=new JButton("Deposit");
        JButton withdraw=new JButton("Withdraw");
        JButton transfer=new JButton("Transfer");
        JButton update=new JButton("Update Name");
        JButton delete=new JButton("Delete");
        JButton view=new JButton("View Accounts");

        create.setBounds(20,20,120,30);
        deposit.setBounds(160,20,120,30);
        withdraw.setBounds(300,20,120,30);
        transfer.setBounds(440,20,120,30);

        update.setBounds(100,70,150,30);
        delete.setBounds(270,70,120,30);
        view.setBounds(410,70,150,30);

        JScrollPane pane=new JScrollPane(area);
        pane.setBounds(20,120,540,270);

        add(create); add(deposit); add(withdraw);
        add(transfer); add(update); add(delete);
        add(view); add(pane);

        create.addActionListener(e->createAcc());
        deposit.addActionListener(e->deposit());
        withdraw.addActionListener(e->withdraw());
        transfer.addActionListener(e->transfer());
        update.addActionListener(e->update());
        delete.addActionListener(e->delete());
        view.addActionListener(e->showAcc());

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    void createAcc(){

        int acc=Integer.parseInt(JOptionPane.showInputDialog("Account No"));
        String name=JOptionPane.showInputDialog("Name");
        double bal=Double.parseDouble(JOptionPane.showInputDialog("Balance"));

        service.create(acc,name,bal);
    }

    void deposit(){

        int acc=Integer.parseInt(JOptionPane.showInputDialog("Account No"));
        double amt=Double.parseDouble(JOptionPane.showInputDialog("Amount"));

        service.deposit(acc,amt);
    }

    void withdraw(){

        int acc=Integer.parseInt(JOptionPane.showInputDialog("Account No"));
        double amt=Double.parseDouble(JOptionPane.showInputDialog("Amount"));

        service.withdraw(acc,amt);
    }

    void transfer(){

        int from=Integer.parseInt(JOptionPane.showInputDialog("From Account"));
        int to=Integer.parseInt(JOptionPane.showInputDialog("To Account"));
        double amt=Double.parseDouble(JOptionPane.showInputDialog("Amount"));

        service.transfer(from,to,amt);
    }

    void update(){

        int acc=Integer.parseInt(JOptionPane.showInputDialog("Account No"));
        String name=JOptionPane.showInputDialog("New Name");

        service.updateName(acc,name);
    }

    void delete(){

        int acc=Integer.parseInt(JOptionPane.showInputDialog("Account No"));
        service.delete(acc);
    }

    void showAcc(){

        area.setText("");

        for(Account a:service.getAll()){

            area.append(
                "Acc:"+a.getAccNo()+
                " | "+a.getName()+
                " | Balance:"+a.getBalance()+"\n"
            );

        }
    }
}