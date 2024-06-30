
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


//main menu class, this is the opening gui the user first sees
public class mainmenu extends JFrame implements ActionListener {
	public JButton startbutton, exitbutton;
	
	
	
	//Constructor to create the gui
	public mainmenu() {
		super("MainMenu");
		
		
		
		Container c =getContentPane();
		//adding background colour
		getContentPane().setBackground(Color.CYAN);
		 
		
	     c.setLayout(new FlowLayout());
	     
	     JLabel title = new JLabel("TICTACTOE");
	     //changing the "tic tac toe" font to a bigger and bolder title
	     title.setFont(new Font("Arial", Font.BOLD, 60));
		 
	     
	     c.add(title);
	     //positioning for the title
		 title.setBounds(200,300,20,20);
	     
		 //adding all the buttons to the gui along with setting the size
	     startbutton = new JButton("Start ");
	     c.add(startbutton);
	     startbutton.addActionListener(this);
	     exitbutton = new JButton("Exit");
	     c.add(exitbutton);
         exitbutton.addActionListener(this);
	     setSize(400,400); 
	     setVisible( true ); 
		
	}
	//if the start button is clicked then it disposes the main menu gui and displays the game gui
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == startbutton) {
			dispose();
			tictactoe app = new tictactoe();  
		    app.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );  
		//if the exit button is clicked then it just terminates the whole program and exits out the gui
		}else if (e.getSource() == exitbutton){
			 System.exit(0);
		}
	}
	
	
	//main class creating main object
	public static void main(String[] args) {
		mainmenu main = new mainmenu();  
	    main.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );  
	}
}

//this is the second second gui the actual game it self 
class tictactoe extends JFrame implements ActionListener {
	//creating all the attributes 
	 public JButton button1, button2, button3, button4, button5, button6, button7, button8, button9,mainmenu;
	 public JFrame frame;
	 public JTextField xField, oField;
	 final boolean[] isPlayer1Turn = {true};
	 public int Xcount = 0;
	 public int Ocount = 0;
	 
	 
	 
	//this when called sets all the buttons text from either "x" or "O" to nothing
	public void reset(){
		    button1.setText(" ");
			button2.setText(" ");
			button3.setText(" ");
			button4.setText(" ");
			button5.setText(" ");
			button6.setText(" ");
			button7.setText(" ");
			button8.setText(" ");
			button9.setText(" ");
	}
	
	//this is creating the tic tac toe gui
	 public tictactoe() {
		 super("Tic Tac Toe");
		 Container c =getContentPane();
		 c.setLayout(new BorderLayout());
		 //creating a 3 by 3 grid layout because there are 9 buttons in total
		 JPanel p1 = new JPanel(new GridLayout(3,3));
		 //flow flayout for adding other elements like the counters and main menu button
         JPanel p2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		 JPanel p3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		 p3.setBackground(Color.CYAN);
		 p2.setBackground(Color.CYAN);
		 p1.setBackground(Color.CYAN);
		 xField = new JTextField();
         xField.setText("X Wins: ");
         xField.setEditable(false);
         oField = new JTextField();
         oField.setText("O Wins: ");
         oField.setEditable(false);
		
		 mainmenu = new JButton("Main Menu");
		 mainmenu.addActionListener(this);
		 p2.add(xField);
         p2.add(oField);
		 p3.add(mainmenu);
		 //more positioning
	     c.add(p2,BorderLayout.SOUTH);
         c.add(p1,BorderLayout.CENTER);
		 c.add(p3,BorderLayout.NORTH);
	    
	     // the reason i put them in individually was so i can 
	     //interact with each button instead of going through a for loop
	     button1 = new JButton(" ");
	     p1.add(button1);
	     button1.addActionListener(this);
	     button2 = new JButton(" ");
	     p1.add(button2);
	     button2.addActionListener(this);
	     button3 = new JButton(" ");
	     p1.add(button3);
	     button3.addActionListener(this);
	     button4 = new JButton(" ");
	     p1.add(button4);
	     button4.addActionListener(this);
	     button5 = new JButton(" ");
	     p1.add(button5);
	     button5.addActionListener(this);
	     button6 = new JButton(" ");
	     p1.add(button6);
	     button6.addActionListener(this);
	     button7 = new JButton(" ");
	     p1.add(button7);
	     button7.addActionListener(this);
	     button8 = new JButton(" ");
	     p1.add(button8);
	     button8.addActionListener(this);
	     button9 = new JButton(" ");
	     p1.add(button9);
	     button9.addActionListener(this);
		 setSize(400,400); 
	     setVisible( true );  
	 }

	
	 
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		
			
		//if main menu is clicked then returns back to the main menu disposing the tic tac toe
		if(e.getSource() == mainmenu) {
			dispose();
			new mainmenu();
		}


		//this is the more important part where it determines the players turn and goes back and forth
		//checks the value of isplayer1turn if its true set the text to x if not then its players 2 turn changng it to O
        if (isPlayer1Turn[0]) {
            button.setText("X");
        } else {
            button.setText("O");
        }

        //if player1turn is true then player1turn will be false and 
        isPlayer1Turn[0] = !isPlayer1Turn[0];
        
        
		  
        
        //this is creating if statements for every possible outcome for both x and O
        //it checks to see which three buttons have the x or O in them
        
			if(button1.getText() == "X" && button2.getText() == "X" && button3.getText() == "X") {
				//once a condition is true a dialog frame comes letting you know who won
				JOptionPane.showMessageDialog(frame, "Team X wins!");
				//it adds 1 win to the counter for whoever won
				Xcount ++;
                xField.setText("X Wins: " + Xcount);
                //then resets the board so you can play again 
				reset();
			} else if(button1.getText() == "X" && button4.getText() == "X" && button7.getText() == "X"){
				JOptionPane.showMessageDialog(frame, "Team X wins!");
				Xcount ++;
                xField.setText("X Wins: " + Xcount);
				reset();
				
			}else if(button3.getText() == "X" && button6.getText() == "X" && button9.getText() == "X") {
				JOptionPane.showMessageDialog(frame, "Team X wins!");
				Xcount ++;
                xField.setText("X Wins: " + Xcount);
				reset();
				
			}else if(button7.getText() == "X" && button8.getText() == "X" && button9.getText() == "X"){
				JOptionPane.showMessageDialog(frame, "Team X wins!");
				Xcount ++;
                xField.setText("X Wins: " + Xcount);
				reset();
				
			}else if(button1.getText() == "X" && button5.getText() == "X" && button9.getText() == "X") {
				JOptionPane.showMessageDialog(frame, "Team X wins!");
				Xcount ++;
                xField.setText("X Wins: " + Xcount);
				reset();
				
			}else if(button2.getText() == "X" && button5.getText() == "X" && button8.getText() == "X") {
				JOptionPane.showMessageDialog(frame, "Team X wins!");
				Xcount ++;
                xField.setText("X Wins: " + Xcount);
				reset();
				
			}else if(button4.getText() == "X" && button5.getText() == "X" && button6.getText() == "X"){
				JOptionPane.showMessageDialog(frame, "Team X wins!");
				Xcount ++;
                xField.setText("X Wins: " + Xcount);
				reset();
				
			}else if(button3.getText() == "X" && button5.getText() == "X" && button7.getText() == "X") {
				JOptionPane.showMessageDialog(frame,"Team X wins!");
				Xcount ++;
                xField.setText("X Wins: " + Xcount);
				reset();
				
			}
			else if(button1.getText() == "O" && button2.getText() == "O" && button3.getText() == "O") {
				JOptionPane.showMessageDialog(frame, "Team O wins!");
				Ocount ++;
                oField.setText("O Wins: " + Ocount);
				reset();
				
			} else if(button1.getText() == "O" && button4.getText() == "O" && button7.getText() == "O"){
				JOptionPane.showMessageDialog(frame, "Team O wins!");
				Ocount ++;
                oField.setText("O Wins: " + Ocount);
				reset();
				
			}else if(button3.getText() == "O" && button6.getText() == "O" && button9.getText() == "O") {
				JOptionPane.showMessageDialog(frame, "Team O wins!");
				Ocount ++;
                oField.setText("O Wins: " + Ocount);
				reset();
				
			}else if(button7.getText() == "O" && button8.getText() == "O" && button9.getText() == "O"){
				JOptionPane.showMessageDialog(frame, "Team O wins!");
				Ocount ++;
                oField.setText("O Wins: " + Ocount);
				reset();
				
			}else if(button1.getText() == "O" && button5.getText() == "O" && button9.getText() == "O") {
				JOptionPane.showMessageDialog(frame, "Team O wins!");
				Ocount ++;
                oField.setText("O Wins: " + Ocount);
				reset();
				
			}else if(button2.getText() == "O" && button5.getText() == "O" && button8.getText() == "O") {
				JOptionPane.showMessageDialog(frame, "Team O wins!");
				Ocount ++;
                oField.setText("O Wins: " + Ocount);
				reset();
				
			}else if(button4.getText() == "O" && button5.getText() == "O" && button6.getText() == "O"){
				JOptionPane.showMessageDialog(frame, "Team O wins!");
				Ocount ++;
                oField.setText("O Wins: " + Ocount);
				reset();
				
			}else if(button3.getText() == "O" && button5.getText() == "O" && button7.getText() == "O") {
				JOptionPane.showMessageDialog(frame, "Team O wins!");
				Ocount ++;
                oField.setText("O Wins: " + Ocount);
				reset();
			//this is a draw statement if no one wins
			}else if(button1.getText() != " " && button2.getText() != " " && button3.getText() != " " && button4.getText() != " " && button5.getText() != " " && button6.getText() != " " && button7.getText() != " " && button8.getText() != " " && button9.getText() != " ") {
				JOptionPane.showMessageDialog(frame, "Draw!");
				reset();
				
			}			
	}
	
}