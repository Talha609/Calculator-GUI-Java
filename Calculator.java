import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
class Calculator implements ActionListener
{
    JFrame f;
    JPanel p;
    JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,ba,bs,bm,bd,bdt,bcl,be;
    JTextField tv1,tv2;
    Font fo;
    Border b;
    String chk1="",chk2="";
    public Calculator()
    {
        fo=new Font("Times New Roman",Font.BOLD,12);
        b=BorderFactory.createEmptyBorder();

        f=new JFrame();
        f.setSize(276,322);
        p=new JPanel();
        f.add(p);

        tv1=new JTextField(1);
        tv2=new JTextField(1);
        b0=new JButton("0");
        b1=new JButton("1");
        b2=new JButton("2");
        b3=new JButton("3");
        b4=new JButton("4");
        b5=new JButton("5");
        b6=new JButton("6");
        b7=new JButton("7");
        b8=new JButton("8");
        b9=new JButton("9");
        ba=new JButton("+");
        bs=new JButton("-");
        bm=new JButton("*");
        bd=new JButton("/");
        bdt=new JButton(".");
        be=new JButton("=");
        bcl=new JButton("C");

        tv1.setBounds(5,5,250,35);
        tv2.setBounds(5,40,250,30);
        b7.setBounds(5,80,50,50);
        b8.setBounds(55,80,50,50);
        b9.setBounds(105,80,50,50);
        b4.setBounds(5,130,50,50);
        b5.setBounds(55,130,50,50);
        b6.setBounds(105,130,50,50);
        b1.setBounds(5,180,50,50);
        b2.setBounds(55,180,50,50);
        b3.setBounds(105,180,50,50);
        b0.setBounds(5,230,100,50);
        bdt.setBounds(105,230,50,50);
        bd.setBounds(155,80,50,50);
        bm.setBounds(155,130,50,50);
        bs.setBounds(155,180,50,50);
        ba.setBounds(155,230,50,50);
        bcl.setBounds(205,80,50,100);
        be.setBounds(205,180,50,100);

        tv1.setBorder(b);
        tv2.setBorder(b);
        b0.setFont(fo);
        b1.setFont(fo);
        b2.setFont(fo);
        b3.setFont(fo);
        b4.setFont(fo);
        b5.setFont(fo);
        b6.setFont(fo);
        b7.setFont(fo);
        b8.setFont(fo);
        b9.setFont(fo);
        ba.setFont(fo);
        bs.setFont(fo);
        bm.setFont(fo);
        bd.setFont(fo);
        bdt.setFont(fo);
        be.setFont(fo);

        p.add(tv1);p.add(tv2);
        p.add(b0);p.add(b1);p.add(b2);
        p.add(b5);p.add(b4);p.add(b3);
        p.add(b6);p.add(b7);p.add(b8);
        p.add(bs);p.add(ba);p.add(b9);
        p.add(bm);p.add(bd);p.add(bdt);
        p.add(bcl);p.add(be);

        p.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(2);

        b0.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        ba.addActionListener(this);
        bs.addActionListener(this);
        bm.addActionListener(this);
        bd.addActionListener(this);
        bdt.addActionListener(this);
        bcl.addActionListener(this);
        be.addActionListener(this);
    }
    String r1="",r2="";
    char ch;
    double sum=0,n1=0,n2=0;
    public void actionPerformed(ActionEvent evt)
    {
        String str=evt.getActionCommand();
        if(str.matches("^[0-9]+"))
        {
            r1=r1+str;
            tv2.setHorizontalAlignment(JTextField.RIGHT);
            tv2.setText(r1);
        }
        if(evt.getSource()==ba)
        {
            r2=r2+r1;
            if(ch==2)
            {
                n1=n1-Double.parseDouble(tv2.getText().toString());
            }
            else if(ch==2)
            {
                n1=n1*Double.parseDouble(tv2.getText().toString());
            }
            else if(ch==4)
            {
                n1=n1/Double.parseDouble(tv2.getText().toString());
            }
            else
            {
                n1=Double.parseDouble(tv2.getText().toString())+n1;
            }
            ch=1;
            r2=r2+"+";
            tv1.setText(r2);
            chk1=tv1.getText().toString();
            chk2=tv2.getText().toString();
            if(chk1.contains(".") || chk2.contains("."))
                tv2.setText(String.valueOf(n1));
            else
                tv2.setText(String.valueOf((int)n1));
            r1="";
            chk1="";
            chk2="";
        }
        if(evt.getSource()==bs)
        {
            r2=r2+r1;
            if(n1==0)
                n1=Double.parseDouble(tv2.getText().toString())-n1;
            else if(ch==1)
                n1=n1+Double.parseDouble(tv2.getText().toString());
            else if(ch==3)
                n1=n1*Double.parseDouble(tv2.getText().toString());
            else if(ch==4)
                n1=n1/Double.parseDouble(tv2.getText().toString());
            else
            {
                n1=n1-Double.parseDouble(tv2.getText().toString());
            }
            ch=2;
            r2=r2+"-";
            tv1.setText(r2);
            chk1=tv1.getText().toString();
            chk2=tv2.getText().toString();
            if(chk1.contains(".") || chk2.contains("."))
                tv2.setText(String.valueOf(n1));
            else
                tv2.setText(String.valueOf((int)n1));
            r1="";
            chk1="";
            chk2="";
        }
        if(evt.getSource()==bm)
        {
            r2=r2+r1;
            if(n1==0)
            {
                n1=1;
            }
            if(ch==1)
                n1=n1+Double.parseDouble(tv2.getText().toString());
            else if(ch==2)
                n1=n1-Double.parseDouble(tv2.getText().toString());
            else if(ch==4)
                n1=n1/Double.parseDouble(tv2.getText().toString());
            else
                n1=Double.parseDouble(tv2.getText().toString())*n1;
            ch=3;
            r2=r2+"*";
            tv1.setText(r2);
            chk1=tv1.getText().toString();
            chk2=tv2.getText().toString();
            if(chk1.contains(".") || chk2.contains("."))
                tv2.setText(String.valueOf(n1));
            else
                tv2.setText(String.valueOf((int)n1));
            r1="";
            chk1="";
            chk2="";
        }
        if(evt.getSource()==bd)
        {
            r2=r2+r1;
            if(n1==0)
            {
                n1=1;
                n1=Double.parseDouble(tv2.getText().toString())/n1;
            }
            else if(ch==1)
                n1=n1+Double.parseDouble(tv2.getText().toString());
            else if(ch==2)
                n1=n1-Double.parseDouble(tv2.getText().toString());
            else if(ch==3)
                n1=n1*Double.parseDouble(tv2.getText().toString());
            else
            {
                n1=n1/Double.parseDouble(tv2.getText().toString());
            }
            ch=4;
            r2=r2+"/";
            tv1.setText(r2);
            chk1=tv1.getText().toString();
            chk2=tv2.getText().toString();
            if(chk1.contains(".") || chk2.contains("."))
                tv2.setText(String.valueOf(n1));
            else
                tv2.setText(String.valueOf((int)n1));
            r1="";
            chk1="";
            chk2="";
        }
        if(evt.getSource()==bdt)
        {
            r1=r1+".";
            tv2.setText(r1);
        }
        if(evt.getSource()==be)
        {
            try
            {
                n2=Double.parseDouble(tv2.getText().toString());
                switch(ch)
                {
                    case 1:
                    sum=n1+n2;
                    break;
                    case 2:
                    sum=n1-n2;
                    break;
                    case 3:
                    sum=n1*n2;
                    break;
                    case 4:
                    sum=n1/n2;
                    break;
                    default:
                    sum=0;
                }
            }
            catch(Exception e)
            {
            }
            chk1=tv1.getText().toString();
            chk2=tv2.getText().toString();
            if(chk1.contains(".") || chk2.contains("."))
                tv2.setText(String.valueOf(sum));
            else
                tv2.setText(String.valueOf((int)sum));
            tv1.setText("");
            chk1="";
            chk2="";
        }
        if(evt.getSource()==bcl)
        {
            tv2.setText("");
            tv1.setText("");
            r1="";
            r2="";
            sum=0;
            n1=0;
            n2=0;
            ch=Character.MIN_VALUE;
        }
    }

    public static void main(String args[])
    {
        new Calculator();
    }
}