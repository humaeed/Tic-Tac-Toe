import java.io.*;
import java.awt.*;
import java.lang.*;
import java.util.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.*;
import java.awt.event.*;

public class TicTacFrame extends JFrame implements MouseListener, ActionListener {
	JComboBox p;
	boolean pflag=true;
	ButtonGroup choose;
	JPanel panel1, panel2;
	int score1, score2, count;
	String play1, play2, turn;
	JRadioButton player1, player2;
	JLabel xo, select, grid, logo, playerScore1, playerScore2, playerTurn, background, background2;
	JButton play, exit, replay, back, one, two, three, four, five, six, seven, eight, nine;
	
	public TicTacFrame() {
		// Frame properties
		super("Tic Tac Toe");
		this.setSize(600, 600);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addMouseListener(this); // Prints X and Y co-ordinates of mouse clicks on console
		
		panelOneInit(); // Initialize panel one
	}
	
	public void panelOneInit() {
		// 1. Creating Panel1
		panel1 = new JPanel();
		panel1.setLayout(null);
		
		// 2. Creating Labels
		try {
			logo = new JLabel(new ImageIcon("tictac.png"));
			logo.setBounds(200, 40, 200, 200);
			panel1.add(logo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		xo = new JLabel("TIC TAC TOE");
		xo.setBounds(210, 250, 300, 50);
		xo.setForeground(Color.BLACK);
		xo.setFont(new Font("Berlin Sans FB", Font.BOLD, 30));
		xo.setOpaque(false);
		panel1.add(xo);
		
		select = new JLabel("(Please select)");
		select.setBounds(250, 280, 250, 50);
		select.setForeground(Color.BLACK);
		select.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		select.setOpaque(false);
		panel1.add(select);
		
		// 3. Making comboboxes
		String[] temp = {"X", "O"};
		p = new JComboBox(temp);
		p.setBounds(270, 350, 50, 25);			
		panel1.add(p);
		
		// 4. Making radio buttons
		player1 = new JRadioButton("PLAYER-1");
		player1.setBounds(140, 310, 200, 50);
		player1.setForeground(Color.BLACK);
		player1.setFont(new Font("Berlin Sans FB", Font.BOLD, 20));
		player1.setOpaque(false);
		panel1.add(player1);
		
		player2 = new JRadioButton("PLAYER-2");
		player2.setBounds(330, 310, 200, 50);
		player2.setForeground(Color.BLACK);
		player2.setFont(new Font("Berlin Sans FB", Font.BOLD, 20));
		player2.setOpaque(false);
		panel1.add(player2);

		choose = new ButtonGroup();
		choose.add(player1);
		choose.add(player2);
		
		// 5. Making buttons
		play = new JButton("PLAY");
		play.addActionListener(this);
		play.setBorderPainted(false);
        play.setForeground(Color.BLACK);
        play.setContentAreaFilled(false);
        play.setBounds(220, 400, 150, 60);
		play.setFont(new Font("Berlin Sans FB", Font.BOLD, 30));
		panel1.add(play);
		
		exit = new JButton("EXIT");
		exit.addActionListener(this);
		exit.setBorderPainted(false);
        exit.setForeground(Color.BLACK);
        exit.setContentAreaFilled(false);
        exit.setBounds(220, 450, 150, 60);
		exit.setFont(new Font("Berlin Sans FB", Font.BOLD, 30));
		panel1.add(exit);
		
		// 6. Setting the Background Image
		try {
			BufferedImage img = ImageIO.read( new File("back.jpg") );
			background = new JLabel( new ImageIcon(img) );
			background.setBounds(0, 0, 600, 600);
			panel1.add(background);	
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		// Add panel to frame
		this.add(panel1);
	}
	
	public void panelTwoInit() {
		// * Deciding which player gets what (X or O) 
		setXandO();
		pflag=true;
		score1=score2=count=0;

		// 1. Creating Panel
		panel2 = new JPanel();
		panel2.setLayout(null);
		
		// 2. Making Buttons
		one = new JButton("");
	    one.addMouseListener(this);
		one.setContentAreaFilled(false);
		one.setBorderPainted(false);
		one.setBounds(150, 75, 85, 85);
		one.setForeground(Color.BLACK);
		one.setFont(new Font("Berlin Sans FB", Font.PLAIN, 70));
		panel2.add(one);
		
		two = new JButton("");
	    two.addMouseListener(this);
		two.setContentAreaFilled(false);
		two.setBorderPainted(false);
		two.setBounds(248, 75, 85, 85);
		two.setForeground(Color.BLACK);
		two.setFont(new Font("Berlin Sans FB", Font.PLAIN, 70));
		panel2.add(two);
		
		three = new JButton("");
	    three.addMouseListener(this);
		three.setContentAreaFilled(false);
		three.setBorderPainted(false);
		three.setBounds(345, 75, 85, 85);
		three.setForeground(Color.BLACK);
		three.setFont(new Font("Berlin Sans FB", Font.PLAIN, 70));
		panel2.add(three);
		
		four = new JButton("");
	    four.addMouseListener(this);
		four.setContentAreaFilled(false);
		four.setBorderPainted(false);
		four.setBounds(150, 170, 85, 85);
		four.setForeground(Color.BLACK);
		four.setFont(new Font("Berlin Sans FB", Font.PLAIN, 70));
		panel2.add(four);
		
		five = new JButton("");
	    five.addMouseListener(this);
		five.setContentAreaFilled(false);
		five.setBorderPainted(false);
		five.setBounds(248, 170, 85, 85);
		five.setForeground(Color.BLACK);
		five.setFont(new Font("Berlin Sans FB", Font.PLAIN, 70));
		panel2.add(five);
		
		six = new JButton("");
	    six.addMouseListener(this);
		six.setContentAreaFilled(false);
		six.setBorderPainted(false);
		six.setBounds(345, 170, 85, 85);
		six.setForeground(Color.BLACK);
		six.setFont(new Font("Berlin Sans FB", Font.PLAIN, 70));
		panel2.add(six);

		seven = new JButton("");
	    seven.addMouseListener(this);
		seven.setContentAreaFilled(false);
		seven.setBorderPainted(false);
		seven.setBounds(150, 265, 85, 85);
		seven.setForeground(Color.BLACK);
		seven.setFont(new Font("Berlin Sans FB", Font.PLAIN, 70));
		panel2.add(seven);

		eight = new JButton("");
	    eight.addMouseListener(this);
		eight.setContentAreaFilled(false);
		eight.setBorderPainted(false);
		eight.setBounds(248, 265, 85, 85);
		eight.setForeground(Color.BLACK);
		eight.setFont(new Font("Berlin Sans FB", Font.PLAIN, 70));
		panel2.add(eight);

		nine = new JButton("");
	    nine.addMouseListener(this);
		nine.setContentAreaFilled(false);
		nine.setBorderPainted(false);
		nine.setBounds(345, 265, 85, 85);
		nine.setForeground(Color.BLACK);
		nine.setFont(new Font("Berlin Sans FB", Font.PLAIN, 70));
		panel2.add(nine);
		
		replay = new JButton("REPLAY");
		replay.setVisible(false);
		replay.addActionListener(this);
		replay.setBorderPainted(false);
        replay.setForeground(Color.BLACK);
        replay.setContentAreaFilled(false);
		replay.setBounds(130, 450, 170, 40);
		replay.setFont(new Font("Berlin Sans FB", Font.BOLD, 30));
		panel2.add(replay);
		
		back = new JButton("BACK");
		back.addActionListener(this);
        back.setBorderPainted(false);
        back.setForeground(Color.BLACK);
        back.setContentAreaFilled(false);
        back.setBounds(290, 450, 170, 40);
		back.setFont(new Font("Berlin Sans FB", Font.BOLD, 30));
		back.setVisible(false);
		panel2.add(back);
		
		// 4. Creating Labels
		playerScore1 = new JLabel(String.valueOf(score1));
		playerScore1.setBounds(50, 10, 200, 80);
		playerScore1.setForeground(Color.GRAY);
		playerScore1.setFont(new Font("Verdana", Font.BOLD, 40));
		playerScore1.setOpaque(false);
		panel2.add(playerScore1);

		playerScore2 = new JLabel(String.valueOf(score2));
		playerScore2.setBounds(500, 10, 250, 80);
		playerScore2.setForeground(Color.GRAY);
		playerScore2.setFont(new Font("Verdana", Font.BOLD, 40));
		playerScore2.setOpaque(false);
		panel2.add(playerScore2);

		playerTurn = new JLabel(turn+" MOVE");
		playerTurn.setBounds(190, 380, 250, 50);
		playerTurn.setForeground(Color.BLACK);
		playerTurn.setFont(new Font("Berlin Sans FB", Font.BOLD, 25));
		playerTurn.setOpaque(false);
		panel2.add(playerTurn);

		try {
			grid = new JLabel(new ImageIcon("grid.png"));
			grid.setBounds(140, 60, 300, 300);
			grid.addMouseListener(this);
			panel2.add(grid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 5. Setting the Background Image
		try {
			BufferedImage img = ImageIO.read( new File("back.jpg") );
			background2 = new JLabel( new ImageIcon(img) );
			background2.setBounds(0, 0, 600, 600);
			panel2.add(background2);	
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		this.add(panel2);
	}

	public void setXandO() {
		if(player1.isSelected()) {
			if(p.getSelectedItem()=="X") {
				play1="X";
				play2="O";
			}
			else {
				play1="O";
				play2="X";
			}
			turn="PLAYER-1";			
		}
		else {
			if(p.getSelectedItem()=="X") {
				play1="O";
				play2="X";
			}
			else {
				play1="X";
				play2="O";
			}			
			turn="PLAYER-2";
		}
	}

	public void updateScore() {
		if(turn=="PLAYER-1") {
			score1++;
			playerScore1.setText(String.valueOf(score1));
		}
		else {
			score2++;
			playerScore2.setText(String.valueOf(score2));
		}
	}

	public boolean check(MouseEvent x) {
		if(x.getSource()==one) {
			if(one.getText().equals(two.getText()) && one.getText().equals(three.getText())) {
				updateScore();
				return true;
			}
			else if(one.getText().equals(four.getText()) && one.getText().equals(seven.getText())) {
				updateScore();
				return true;
			}
			else if(one.getText().equals(five.getText()) && one.getText().equals(nine.getText())) {
				updateScore();
				return true;
			}
			else 
				return false;
		}
		else if(x.getSource()==two) {
			if(two.getText().equals(one.getText()) && two.getText().equals(three.getText())) {
				updateScore();
				return true;
			}
			else if(two.getText().equals(five.getText()) && two.getText().equals(eight.getText())) {
				updateScore();
				return true;
			}
			else 
				return false;
		}
		else if(x.getSource()==three) {
			if(three.getText().equals(two.getText()) && three.getText().equals(one.getText())) {
				updateScore();
				return true;
			}
			else if(three.getText().equals(five.getText()) && three.getText().equals(seven.getText())) {
				updateScore();
				return true;
			}
			else if(three.getText().equals(six.getText()) && three.getText().equals(nine.getText())) {
				updateScore();
				return true;
			}
			else 
				return false;
		}
		else if(x.getSource()==four) {
			if(four.getText().equals(one.getText()) && four.getText().equals(seven.getText())) {
				updateScore();
				return true;
			}
			else if(four.getText().equals(five.getText()) && four.getText().equals(six.getText())) {
				updateScore();
				return true;
			}
			else 
				return false;
		}
		else if(x.getSource()==five) {
			if(five.getText().equals(one.getText()) && five.getText().equals(nine.getText())) {
				updateScore();
				return true;
			}
			else if(five.getText().equals(three.getText()) && five.getText().equals(seven.getText())) {
				updateScore();
				return true;
			}
			else if(five.getText().equals(four.getText()) && five.getText().equals(six.getText())) {
				updateScore();
				return true;
			}
			else if(five.getText().equals(two.getText()) && five.getText().equals(eight.getText())) {
				updateScore();
				return true;
			}
			else 
				return false;
		}
		else if(x.getSource()==six) {
			if(six.getText().equals(three.getText()) && six.getText().equals(nine.getText())) {
				updateScore();
				return true;
			}
			else if(six.getText().equals(five.getText()) && six.getText().equals(four.getText())) {
				updateScore();
				return true;
			}
			else 
				return false;
		}
		else if(x.getSource()==seven) {
			if(seven.getText().equals(one.getText()) && seven.getText().equals(four.getText())) {
				updateScore();
				return true;
			}
			else if(seven.getText().equals(five.getText()) && seven.getText().equals(three.getText())) {
				updateScore();
				return true;
			}
			else if(seven.getText().equals(eight.getText()) && seven.getText().equals(nine.getText())) {
				updateScore();
				return true;
			}
			else 
				return false;
		}
		else if(x.getSource()==eight) {
			if(eight.getText().equals(five.getText()) && eight.getText().equals(two.getText())) {
				updateScore();
				return true;
			}
			else if(eight.getText().equals(seven.getText()) && eight.getText().equals(nine.getText())) {
				updateScore();
				return true;
			}
			else 
				return false;
		}
		else if(x.getSource()==nine) {
			if(nine.getText().equals(one.getText()) && nine.getText().equals(five.getText())) {
				updateScore();
				return true;
			}
			else if(nine.getText().equals(three.getText()) && nine.getText().equals(six.getText())) {
				updateScore();
				return true;
			}
			else if(nine.getText().equals(eight.getText()) && seven.getText().equals(nine.getText())) {
				updateScore();
				return true;
			}
			else 
				return false;
		}
		else
			return false;
	}
	
	public void actionPerformed(ActionEvent ae) {
		String elementText = ae.getActionCommand();
		
		if(elementText.equals(exit.getText())) {
			System.exit(0);
		}
		else if(elementText.equals(play.getText())) { 
		
			if(player1.isSelected() || player2.isSelected()) {
				panel1.setVisible(false);
				panelTwoInit();
			} else {
				JOptionPane.showMessageDialog(this, "Please select player! ",
                                    "Warning", JOptionPane.YES_NO_CANCEL_OPTION);
			}
		} 
		else if(elementText.equals(replay.getText())) {
			count=0; pflag=true; 
			replay.setVisible(false); back.setVisible(false);

			one.setText(""); two.setText(""); three.setText(""); four.setText(""); five.setText("");
			six.setText(""); seven.setText(""); eight.setText(""); nine .setText("");
			
			if(turn.equals("PLAYER-1")) {
				turn="PLAYER-2";
				if(playerTurn.getText().equals("** DRAW **")) {
					playerTurn.setBounds(190, 380, 250, 50);
					playerTurn.setText(turn+" MOVE");
				}
				else
					playerTurn.setText(turn+" MOVE");
			}
			else {
				turn="PLAYER-1";
				if(playerTurn.getText().equals("** DRAW **")) {
					playerTurn.setBounds(190, 380, 250, 50);
					playerTurn.setText(turn+" MOVE");
				}
				else
					playerTurn.setText(turn+" MOVE");
			}
		}
		else if(elementText.equals(back.getText())) {
			panel2.setVisible(false);
			panel1.setVisible(true);
		}
	}	

	public void mouseClicked(MouseEvent e) {  
		System.out.println("X: "+e.getX()+"  Y: "+e.getY()); // Prints X & Y in console
		
		if(e.getSource()==one && pflag && one.getText().equals("")) {
			Sound.click.play();
			if(turn.equals("PLAYER-1")) one.setText(play1);
			else one.setText(play2);
			count++;

			if(check(e)) {
				pflag=false;
				Sound.finish.play();
				back.setVisible(true);
				replay.setVisible(true);
				playerTurn.setText(turn+" WINS");
			}
			else if(count==9) {
				pflag=false;
				Sound.finish.play();
				back.setVisible(true);
				replay.setVisible(true);
				playerTurn.setBounds(220, 380, 250, 50);
				playerTurn.setText("** DRAW **");
			}
			else {
				if(turn.equals("PLAYER-1")) {
					turn="PLAYER-2";
					playerTurn.setText(turn+" MOVE");
				} 
				else {
					turn="PLAYER-1";
					playerTurn.setText(turn+" MOVE");
				}
			}
		}
		else if(e.getSource()==two && pflag && two.getText().equals("")) {
			Sound.click.play();
			if(turn.equals("PLAYER-1")) two.setText(play1);
			else two.setText(play2);
			count++;

			if(check(e)) {
				pflag=false;
				Sound.finish.play();
				back.setVisible(true);
				replay.setVisible(true);
				playerTurn.setText(turn+" WINS");
			}
			else if(count==9) {
				pflag=false;
				Sound.finish.play();
				back.setVisible(true);
				replay.setVisible(true);
				playerTurn.setBounds(220, 380, 250, 50);
				playerTurn.setText("** DRAW **");
			}
			else {
				if(turn.equals("PLAYER-1")) {
					turn="PLAYER-2";
					playerTurn.setText(turn+" MOVE");
				} 
				else {
					turn="PLAYER-1";
					playerTurn.setText(turn+" MOVE");
				}
			}
		}
		else if(e.getSource()==three && pflag && three.getText().equals("")) {
			Sound.click.play();
			if(turn.equals("PLAYER-1")) three.setText(play1);
			else three.setText(play2);
			count++;

			if(check(e)) {
				pflag=false;
				Sound.finish.play();
				back.setVisible(true);
				replay.setVisible(true);
				playerTurn.setText(turn+" WINS");
			}
			else if(count==9) {
				pflag=false;
				Sound.finish.play();
				back.setVisible(true);
				replay.setVisible(true);
				playerTurn.setBounds(220, 380, 250, 50);
				playerTurn.setText("** DRAW **");
			}
			else {
				if(turn.equals("PLAYER-1")) {
					turn="PLAYER-2";
					playerTurn.setText(turn+" MOVE");
				} 
				else {
					turn="PLAYER-1";
					playerTurn.setText(turn+" MOVE");
				}
			}
		}
		else if(e.getSource()==four && pflag && four.getText().equals("")) {
			Sound.click.play();
			if(turn.equals("PLAYER-1")) four.setText(play1);
			else four.setText(play2);
			count++;

			if(check(e)) {
				pflag=false;
				Sound.finish.play();
				back.setVisible(true);
				replay.setVisible(true);
				playerTurn.setText(turn+" WINS");
			}
			else if(count==9) {
				pflag=false;
				Sound.finish.play();
				back.setVisible(true);
				replay.setVisible(true);
				playerTurn.setBounds(220, 380, 250, 50);
				playerTurn.setText("** DRAW **");
			}
			else {
				if(turn.equals("PLAYER-1")) {
					turn="PLAYER-2";
					playerTurn.setText(turn+" MOVE");
				} 
				else {
					turn="PLAYER-1";
					playerTurn.setText(turn+" MOVE");
				}
			}
		}
		else if(e.getSource()==five && pflag && five.getText().equals("")) {
			Sound.click.play();
			if(turn.equals("PLAYER-1")) five.setText(play1);
			else five.setText(play2);
			count++;

			if(check(e)) {
				pflag=false;
				Sound.finish.play();
				back.setVisible(true);
				replay.setVisible(true);
				playerTurn.setText(turn+" WINS");
			}
			else if(count==9) {
				pflag=false;
				Sound.finish.play();
				back.setVisible(true);
				replay.setVisible(true);
				playerTurn.setBounds(220, 380, 250, 50);
				playerTurn.setText("** DRAW **");
			}
			else {
				if(turn.equals("PLAYER-1")) {
					turn="PLAYER-2";
					playerTurn.setText(turn+" MOVE");
				} 
				else {
					turn="PLAYER-1";
					playerTurn.setText(turn+" MOVE");
				}
			}
		}
		else if(e.getSource()==six && pflag && six.getText().equals("")) {
			Sound.click.play();
			if(turn.equals("PLAYER-1")) six.setText(play1);
			else six.setText(play2);
			count++;
			
			if(check(e)) {
				pflag=false;
				Sound.finish.play();
				back.setVisible(true);
				replay.setVisible(true);
				playerTurn.setText(turn+" WINS");
			}
			else if(count==9) {
				pflag=false;
				Sound.finish.play();
				back.setVisible(true);
				replay.setVisible(true);
				playerTurn.setBounds(220, 380, 250, 50);
				playerTurn.setText("** DRAW **");
			}
			else {
				if(turn.equals("PLAYER-1")) {
					turn="PLAYER-2";
					playerTurn.setText(turn+" MOVE");
				} 
				else {
					turn="PLAYER-1";
					playerTurn.setText(turn+" MOVE");
				}
			}
		}
		else if(e.getSource()==seven && pflag && seven.getText().equals("")) {
			Sound.click.play();
			if(turn.equals("PLAYER-1")) seven.setText(play1);
			else seven.setText(play2);
			count++;
			
			if(check(e)) {
				pflag=false;
				Sound.finish.play();
				back.setVisible(true);
				replay.setVisible(true);
				playerTurn.setText(turn+" WINS");
			}
			else if(count==9) {
				pflag=false;
				Sound.finish.play();
				back.setVisible(true);
				replay.setVisible(true);
				playerTurn.setBounds(220, 380, 250, 50);
				playerTurn.setText("** DRAW **");
			}
			else {
				if(turn.equals("PLAYER-1")) {
					turn="PLAYER-2";
					playerTurn.setText(turn+" MOVE");
				} 
				else {
					turn="PLAYER-1";
					playerTurn.setText(turn+" MOVE");
				}
			}
		}
		else if(e.getSource()==eight && pflag && eight.getText().equals("")) {
			Sound.click.play();
			if(turn.equals("PLAYER-1")) eight.setText(play1);
			else eight.setText(play2);
			count++;

			if(check(e)) {
				pflag=false;
				Sound.finish.play();
				back.setVisible(true);
				replay.setVisible(true);
				playerTurn.setText(turn+" WINS");
			}
			else if(count==9) {
				pflag=false;
				Sound.finish.play();
				back.setVisible(true);
				replay.setVisible(true);
				playerTurn.setBounds(220, 380, 250, 50);
				playerTurn.setText("** DRAW **");
			}
			else {
				if(turn.equals("PLAYER-1")) {
					turn="PLAYER-2";
					playerTurn.setText(turn+" MOVE");
				} 
				else {
					turn="PLAYER-1";
					playerTurn.setText(turn+" MOVE");
				}
			}
		}
		else if(e.getSource()==nine && pflag && nine.getText().equals("")) {
			Sound.click.play();
			if(turn.equals("PLAYER-1")) nine.setText(play1);
			else nine.setText(play2);
			count++;

			if(check(e)) {
				pflag=false;
				Sound.finish.play();
				back.setVisible(true);
				replay.setVisible(true);
				playerTurn.setText(turn+" WINS");
			}
			else if(count==9) {
				pflag=false;
				Sound.finish.play();
				back.setVisible(true);
				replay.setVisible(true);
				playerTurn.setBounds(220, 380, 250, 50);
				playerTurn.setText("** DRAW **");
			}
			else {
				if(turn.equals("PLAYER-1")) {
					turn="PLAYER-2";
					playerTurn.setText(turn+" MOVE");
				} 
				else {
					turn="PLAYER-1";
					playerTurn.setText(turn+" MOVE");
				}
			}
		}
    }
	
    public void mouseExited(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}  
    public void mouseEntered(MouseEvent e) {}  
    public void mouseReleased(MouseEvent e) {} 
}