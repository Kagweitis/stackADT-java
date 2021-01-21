import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;


public class Display extends JPanel{

	public static void main(String[] args){
		JFrame frame = new JFrame();
        Display display=new Display();
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(display);
        display.setLayout(layout);
        frame.add(display);
        frame.setVisible(true);
	}

	protected static final int X = 30;
	protected  int y = 255;
	protected static final int I = 50; // increment
	protected int counter = 0;
	protected int temp;
	protected int stackSize=5;
	protected String arry[] = new String[stackSize];
	protected LinkedList<String> st = new LinkedList<>();
	
	public Display(){
		setLayout(null);
		
		JButton pubutton = new JButton("PUSH");
		JButton pobutton = new JButton("POP");
		JButton sbutton = new JButton("SIZE");
		JButton ebutton = new JButton("EMPTY");
		JButton tbutton = new JButton("TOP");

		
		pubutton.setBounds(400, 50, 120, 30);
		add(pubutton);
		
		pobutton.setBounds(400, 100, 120, 30);
		add(pobutton);

		sbutton.setBounds(400, 150, 120, 30);
		add(sbutton);

		ebutton.setBounds(400, 200, 120, 30);
		add(ebutton);

		tbutton.setBounds(400, 250, 120, 30);
		add(tbutton);


		puHandlerClass puhandler = new puHandlerClass();
		pubutton.addActionListener(puhandler);
		
	
		poHandlerClass pohandler = new poHandlerClass();
		pobutton.addActionListener(pohandler);

		sHandlerClass shandler = new sHandlerClass();
		sbutton.addActionListener(shandler);

		eHandlerClass ehandler = new eHandlerClass();
		ebutton.addActionListener(ehandler);

		tHandlerClass thandler = new tHandlerClass();
		tbutton.addActionListener(thandler);
		
	}

	public void paintComponent(Graphics g){

		super.paintComponent(g);
		
		temp = y;		


		for(int counter2=0; counter2 <counter; counter2++){
			
			g.setColor(Color.BLUE);
			g.fillRect(X , temp, 280, 40);
			
			g.setColor(Color.BLACK);
			g.drawString(String.valueOf(arry[counter2]), X + 140, temp+20);	
			temp -= I;
		}

		g.setColor(Color.RED);
		g.drawOval(20, (temp + I - 10), 300, 20);
		g.drawOval(20, 300, 300, 20);
		g.drawLine(20, (temp + I), 20, 310);
		g.drawLine(320, (temp + I), 320, 310);
		
	}
	
	//Push
	private class puHandlerClass implements ActionListener{
		public void actionPerformed(ActionEvent event){
			
			if(counter == stackSize){
					JOptionPane.showMessageDialog(null, "Stack is already full!!");				
			}
			else{

				String temp2 = JOptionPane.showInputDialog("Enter an object: ");
				arry[counter] = temp2;
				st.push(temp2);
				System.out.println(st);

				if(counter == 0){
					temp = y;
					counter += 1;
								
				
				}	
				else{
						temp = y;
						counter+=1;
						

					}
	
				repaint();
			}
		}
	}

	//Pop
	private class poHandlerClass implements ActionListener{
		public void actionPerformed(ActionEvent event){
			
			if(counter == 0){
				JOptionPane.showMessageDialog(null, "Stack is already empty!!");
			}
			else{ 
				JOptionPane.showMessageDialog(null, "The object popped is: " + st.pop());
				System.out.println(st);
				counter-=1;
				repaint();

			}
		}
	}
	
	//Size
	private class sHandlerClass implements ActionListener{
		public void actionPerformed(ActionEvent event){
			JOptionPane.showMessageDialog(null, "The size is: " + st.size());		
		}
	}

	//Empty
	private class eHandlerClass implements ActionListener{
		public void actionPerformed(ActionEvent event){
			JOptionPane.showMessageDialog(null, "The stack is empty: " + st.isEmpty());	
		}
	}

	//Top
	private class tHandlerClass implements ActionListener{
		public void actionPerformed(ActionEvent event){
			try{
				JOptionPane.showMessageDialog(null, "The top object is: " + st.peek());
			} catch (EmptyStackException e) {
         			JOptionPane.showMessageDialog(null, "empty stack!!!!!");
				
		}
	}

}
}
