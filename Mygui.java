package Airtickets;
import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Mygui extends JFrame {

    private static final long serialVersionUID = 1L;
    private JButton btn1,btn2,btn3,btn4,savebtn;
    private JLabel ticketidlbl,datelbl,namelbl,itinenarylbl,pricelbl,companylbl,agelbl,weightlbl,heightlbl;
    private JTextField ticketidtf,datetf,nametf,itinenarytf,pricetf,companytf,agetf,weighttf,heighttf;
    private JMenuBar menubar;
    private JMenu filemenu;
    private JMenuItem newitem,listitem,aboutitem,exititem;
    private ArrayList<Tickets> ticketlist;
    private Set<Tickets> ticketsSet ;
    private JTextArea area;
    private JButton b1,b2,b3;
  
    public Mygui() {
        super();

     
        btn1=new JButton("New");
        btn2=new JButton("List");
        btn3=new JButton("About");
        btn4=new JButton("Exit");
        savebtn=new JButton("Save");

        b1=new JButton("New");
        b2=new JButton("Refresh");
        b3=new JButton("Exit");

        ticketidlbl=new JLabel("Ticket id:");
        datelbl=new JLabel("Issue date:");
        namelbl=new JLabel("Client name:");
        itinenarylbl=new JLabel("Itinenary:");
        pricelbl=new JLabel("Price:");
        companylbl=new JLabel("Company:");
        agelbl=new JLabel("Client age:");
        weightlbl=new JLabel("Luggage weight:");
        heightlbl=new JLabel("Height:");

        ticketidtf=new JTextField(10);
        datetf=new JTextField(10);
        nametf=new JTextField(10);
        itinenarytf=new JTextField(10);
        pricetf=new JTextField(8);
        companytf=new JTextField(10);
        agetf=new JTextField(3);
        weighttf=new JTextField(3);
        heighttf=new JTextField(3);

        menubar=new JMenuBar();
        filemenu=new JMenu("Options");
        newitem=new JMenuItem("New");
        listitem=new JMenuItem("List");
        aboutitem=new JMenuItem("About");
        exititem=new JMenuItem("Exit");
    

        ticketlist=new ArrayList();
        area=new JTextArea();
    }

  
    
    public void prepareui() {

        JPanel panel=new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.add(btn1);
        panel.add(btn2);
        panel.add(btn3);
        panel.add(btn4);

        filemenu.add(newitem);
        filemenu.add(listitem);
        filemenu.add(aboutitem);
        filemenu.add(exititem);

        menubar.add(filemenu);

        this.setJMenuBar(menubar);

        this.add(panel,BorderLayout.NORTH);
        this.setSize(400,300);
        this.setVisible(true);
        this.setResizable(true);
        this.setLocationRelativeTo(null);


     
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitApp();
            }
        });
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                exitApp();
            }
        });
        exititem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                exitApp();
            }

        });
        aboutitem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AboutFrame about = new AboutFrame();
                about.prepareui();

            }
        });
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AboutFrame about = new AboutFrame();
                about.prepareui();

            }
        });
        newitem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                newticket();

            }

        });
        listitem.addActionListener(new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent e) {
                startloadfromfile();
            }

        });

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newticket();
            }
        });
        btn2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                startloadfromfile();

            }

        });
        savebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a=ticketidtf.getText();
                String b=datetf.getText();
                String c=nametf.getText();
                String d=itinenarytf.getText();
                double i=0.0,h=0.0;
                int g=0,j=0;
                String f=companytf.getText();
                try {
                    i=Double.parseDouble(pricetf.getText());
                    g=Integer.parseInt(agetf.getText());
                    h=Double.parseDouble( weighttf.getText());
                    j=Integer.parseInt( heighttf.getText());
                    
                    Tickets ticket=new Tickets(a,b,c,d,i,f,g,h,j);
                   
                    

                    area.append(ticket.toString());
                    area.append("\n");
                    saveticket(ticket);
                }catch (NumberFormatException nfe){
                    System.out.println(nfe.fillInStackTrace());
                    JOptionPane.showMessageDialog(
                            Mygui.this,
                            "Nothing to save",
                            "Save error",
                            JOptionPane.WARNING_MESSAGE);
                }
            }});
        b1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                newticket();

            }

        });
        b2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                startloadfromfile();

            }

        });
        b3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                exitApp();

            }

        });


    }
  
    private void exitApp() {
        int i = JOptionPane.showConfirmDialog(this, "Do you want to exit the app?");
        if (i == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

  
    private void newticket() {
        JFrame frame=new JFrame("New ticket");
        JPanel top=new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel med=new JPanel(new FlowLayout(FlowLayout.LEFT));
      

        top.add(ticketidlbl);top.add(ticketidtf);
        top.add(datelbl);top.add(datetf);
        top.add(namelbl);top.add(nametf);
        top.add(itinenarylbl);top.add(itinenarytf);

        med.add(pricelbl);med.add(pricetf);
        med.add(companylbl);med.add(companytf);
        med.add(agelbl);med.add(agetf);
        med.add(weightlbl);med.add(weighttf);
        med.add(heightlbl);med.add(heighttf);


        frame.add(top,BorderLayout.NORTH);
        frame.add(med,BorderLayout.CENTER);

        frame.add(savebtn,BorderLayout.SOUTH);
        frame.setVisible(true);
        frame.setSize(800,400);
        frame.setLocationRelativeTo(null);


    }

   
    private void saveticket(Tickets ticket) {
         

        final JFileChooser fc = new JFileChooser();
        int returnVal = fc.showSaveDialog(Mygui.this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            String filename = fc.getSelectedFile().getPath();
            if (filename != null && !filename.isEmpty()) {
                ticketlist.add(ticket);
                saveticketlist(filename);
            }
        }
    }

   
    private void saveticketlist(String filename) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));

           
            for (Tickets ticket :ticketlist) {
                writer.write(ticket.toString());
                writer.newLine();
            }
            
            writer.close();

            JOptionPane.showMessageDialog(
                    Mygui.this,
                    ticketlist.size() + "  records saved to " + filename,
                    "Save completed",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(Mygui.this,
                    "Can't access " + filename,
                    "File access error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }


    private void startloadfromfile() {
        final JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(Mygui.this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            String filename = fc.getSelectedFile().getPath();

            if (filename != null && !filename.isEmpty()) {
                loadfromfile(filename);
            }
        }
    }

     
    private void loadfromfile(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            JFrame frame=new JFrame("list");
            JTextArea area=new JTextArea();
            JPanel pn=new JPanel();
            JLabel lbl=new JLabel();
            JLabel sumLbl=new JLabel();
            JLabel maxlbl=new JLabel();
            JLabel minlbl=new JLabel();
            JPanel midpanel=new JPanel();

            midpanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            midpanel.add(lbl);
            midpanel.add(sumLbl);
            midpanel.add(maxlbl);
            midpanel.add(minlbl);
            pn.setLayout(new FlowLayout(FlowLayout.LEFT));
            pn.add(b1);
            pn.add(b2);
            pn.add(b3);
            frame.add(pn,BorderLayout.SOUTH);
            frame.add(midpanel,BorderLayout.CENTER);
            frame.add(area,BorderLayout.NORTH);
            frame.setVisible(true);
            frame.setSize(500,500);

            
            String line = "";
            String[] token;
            int count=0;
            String a,sum,max,min;
            double sumprice=0.0;
            double minprice=0;
            double maxprice=0;
            Tickets ticket  ;
            
           
           ticketsSet = new HashSet<>();
            
            while (reader.ready()) {
            	
                line = reader.readLine();
                area.append(line);
                area.append("\n");
               
                token = line.split(",");
                if (token.length == 9) {
                    ticket = new Tickets(token[0], token[1], token[2],token[3],
                            Double.parseDouble(token[4]),token[5],Integer.parseInt(token[6]),
                            Double.parseDouble(token[7]),Integer.parseInt(token[8]));
                   
                  
                  
                    ticketlist.add(ticket);
                    
                /
                  
                    
                    sumprice+=ticket.getPrice();
                    maxprice=ticket.getPrice();
                   
            
                    
                }
                count++;
               
                
            }
            
           
            a=String.valueOf(count);
            lbl.setText("count:"+a);
        
            sum=String.valueOf(sumprice);
            sumLbl.setText("sum:"+sum);
           
              
            reader.close();
      
           
        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {
        } //catch (PrinterException e) {
        // TODO Auto-generated catch block
        //	e.printStackTrace();
        //}
    }
}
    





