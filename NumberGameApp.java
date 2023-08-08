package com.codsoft;

import javax.swing.*;


import java.awt.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
class NumberGameApp extends JFrame
{
  private   JTextField guess,playerName;
  private  ButtonListener buttonListener;
  private   ButtonListener2 buttonListener2;
  private  ButtonListener3 buttonListener3;
  
  private JLabel inputlabel,guesslabel,imglabel,chancesMessage;

    int totalChances = 3;
   
    int rand=(int) (Math.random()*100);
    int count=0;
    public NumberGameApp()
    {
    	 
        Container c = getContentPane();
        c.setLayout(null);
        c.setBackground(new Color(255, 255, 255));
        
        
        playerName =
        		new JTextField();
        playerName.setBorder(new LineBorder(new Color(74, 165, 255), 1, true));
        playerName.setBackground(new Color(255, 255, 255));
        playerName.setForeground(new Color(0, 0, 0));
        playerName.setFont(new Font("Monospaced",Font.BOLD,24));
        playerName.setSize(270,35);
        playerName.setLocation(100,169);

        
        guesslabel = new JLabel("Number Guessing  The Challenging Game");
        guesslabel.setForeground(new Color(74, 165, 255));
        guesslabel.setFont(new Font("Monospaced",Font.BOLD,24));
        guesslabel.setSize(627,40);
        guesslabel.setLocation(85,34);

        inputlabel=new JLabel("Enter Player Name");
        inputlabel.setForeground(new Color(0, 0, 0));
        inputlabel.setFont(new Font("Monospaced", Font.PLAIN, 14));
        inputlabel.setSize(270,20);
        inputlabel.setLocation(100,138);
        
        
        chancesMessage=new JLabel("You've " + totalChances + "  Chance(s) only  ");
        chancesMessage.setForeground(new Color(255, 0, 0));
        chancesMessage.setFont(new Font("Monospaced", Font.BOLD, 15));
        chancesMessage.setSize(250,20);
        chancesMessage.setLocation(223,84);
        
        

        guess = new JTextField(10);
        guess.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
        guess.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyPressed(KeyEvent e) {
        	 char c=	e.getKeyChar();
        	 if(Character.isLetter(c))
        	 {
        		guess.setEditable(false);
        		 
        		  JOptionPane.showMessageDialog(null, "  Please ...Enter Integer Number only");
        	 }
        	 else {
        		 guess.setEditable(true);
        	 }
        	 
        	 guess.setEditable(true);
        	}
        });
        guess.setBorder(new LineBorder(new Color(74, 165, 255)));
        guess.setSize(270,35);
        guess.setLocation(100,269);

        imglabel = new JLabel("");
        imglabel.setIcon(new ImageIcon("C:\\Users\\Shivanand Mugale\\Downloads\\preview.png"));
        imglabel.setBounds(533,34,293,431);

        JButton guessbutton =new JButton("Guess");
        guessbutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        guessbutton.setBorderPainted(false);
        guessbutton.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 11));
        guessbutton.setSize(100,30);
        guessbutton.setLocation(204,383);
        guessbutton.setBackground(new Color(155, 205, 255));
        buttonListener = new ButtonListener();
        guessbutton.addActionListener(buttonListener);

        JButton seeButton = new JButton("Answer!");
        seeButton.setBorderPainted(false);
        seeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        seeButton.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 11));
        seeButton.setSize(169,30);
        seeButton.setLocation(10,383);
        seeButton.setBackground(new Color(155, 205, 255));
        buttonListener2 = new ButtonListener2();
        seeButton.addActionListener(buttonListener2);

        JButton playagainbutton = new JButton("Reset");
        playagainbutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        playagainbutton.setBorderPainted(false);
        playagainbutton.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 11));
        playagainbutton.setSize(169,30);
        playagainbutton.setLocation(333,383);
        playagainbutton.setBackground(new Color(155, 205, 255));
        buttonListener3 = new ButtonListener3();
        playagainbutton.addActionListener(buttonListener3);
        
        c.add(playerName);
        c.add(imglabel);
        c.add(guesslabel);
        c.add(inputlabel);
        c.add(guess);
        c.add(guessbutton);
        c.add(seeButton);
        c.add(playagainbutton);
        c.add(chancesMessage);
       
        
        JLabel inputlabel_1 = new JLabel("Enter a number between 1-100");
        inputlabel_1.setFont(new Font("Monospaced", Font.PLAIN, 14));
        inputlabel_1.setBounds(100, 238, 270, 20);
        getContentPane().add(inputlabel_1);
        
        
        
        
        setTitle(" Number  Guessing Game -The Chellenging Game");
        setSize(852,504);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }

    
    
    
    private class ButtonListener implements ActionListener
    {
    	
        public void actionPerformed(ActionEvent e)
        {
        	try {
        		
         	String plName = playerName.getText();
            int a = Integer.parseInt(guess.getText());
            count=count+1;
            
            	
            
             if (a> 100 || a<1  ) {
                    JOptionPane.showMessageDialog(null, plName + "  Please ...Try to guess between 1 to 100 only.");
              }
             
             else {
         	 if(rand == a)
            	 {
            		 JOptionPane.showMessageDialog(null, playerName.getText().toUpperCase() + " Congratulations " + ", !! You WIN ");
            		 totalChances=3;
            		 setChancesMessage();
            		 guess.setText("");
            	 }
            	 else if(a<rand)
            	 {
            		 JOptionPane.showMessageDialog(null, playerName.getText().toUpperCase()+" " + a + "  is low, try again!!");
            		 totalChances--;
            		 setChancesMessage();
            		 guess.setText("");
            	 }
            	 else
            	 {
            	
            		 JOptionPane.showMessageDialog(null, playerName.getText().toUpperCase() +" "+ a+ "  is High, try again!!");
            		 totalChances--;
            		 setChancesMessage();
            		 guess.setText("");
            		
            		 guess.setEditable(false);
            	 }
             }
             
            

            guess.requestFocus();
            guess.selectAll();
           // totalguess.setText(count+"");
        
        
            
        	}catch(Exception ex)
        	{
        		JOptionPane.showMessageDialog(null, "INVALID INPUT");
        	}
        	
        	
            if (totalChances == 0) {
                JOptionPane.showMessageDialog(null, playerName.getText() + "  Better luck Next Time!!! Correct Number was " + rand);
                totalChances = 3;
                
                setChancesMessage();
                
               
              
                rand=(int) (Math.random()*100);
                guess.setText("");
                playerName.setText("");		
                count=0;
                guess.setEditable(true);
                guess.requestFocus();
                
               
            }
        
       
        }
        public void setChancesMessage() {
        	chancesMessage.setText("You've " + totalChances + "  Chance(s) only...");
        }
        
    }

    private class ButtonListener2 implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
        	JOptionPane.showMessageDialog(null, playerName.getText().toUpperCase() +" "+ " Correct Number " + rand);

        }
    }

    private class ButtonListener3 implements ActionListener
    {
    	  
    	
        public void actionPerformed(ActionEvent e)
        {
            rand=(int) (Math.random()*100);
            guess.setText("");
            playerName.setText("");
            totalChances=0;
            count=0;
            guess.setEditable(true);
            guess.requestFocus();
            
        }
    }
 
    public static void main(String[] args)
    {
    	
        new NumberGameApp();
    }
}