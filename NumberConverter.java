import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NumberConverter extends JFrame implements ActionListener
{
    public static final int WIDTH = 800;  // Window sized to program needs
    public static final int HEIGHT = 105;
    public static final int TEXTFIELDSPACE = 20;
    
    private JTextField decimalNumber, binaryNumber;  // 2 Text Fields: Decimal/Binary
    private String result;

    /*
     * MAIN Program    
     */
   	public static void main (String[] args){  
   		NumberConverter gui = new NumberConverter();
   		gui.setVisible(true);
	} // main
	
	public NumberConverter(){
	
		// Set general window attributes (title, size, close condition, layout)
		setTitle("Number Converter");  
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		// Set inputPanel (base 10 text, Textfield, base 2 text, & Textfield2)
		JPanel inputPanel = new JPanel();  
		inputPanel.setLayout(new FlowLayout());
		JLabel decimalNumberLabel = new JLabel ("Input a number in base ten: ");
		add(decimalNumberLabel);
		decimalNumber = new JTextField(TEXTFIELDSPACE);
		add(decimalNumber);
		JLabel BinaryNumberLabel = new JLabel ("Your number in base two: ");
		add(BinaryNumberLabel);
		binaryNumber = new JTextField(TEXTFIELDSPACE);
		add(binaryNumber);
		add(inputPanel);
		
		// Set buttonPanel (Convert Button, Clear Button)
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		JButton actionButton= new JButton("Convert");
		actionButton.addActionListener(this);
		buttonPanel.add(actionButton);
		JButton clearButton = new JButton("Clear");
		clearButton.addActionListener(this);
		buttonPanel.add(clearButton);
		add(buttonPanel);
	} //NumberConverter
	
	public void actionPerformed(ActionEvent e)
	{	
		try  //try and catch to get exceptions
		{
			assumingCorrectNumberFormats(e);
		}
		catch (NumberFormatException e2)
		{
			decimalNumber.setText("Error: Reenter Number");
		}
	} //actionPerformed
	
	//Action Events determine what will happen when each button is pressed
	public void assumingCorrectNumberFormats(ActionEvent e)
	{
		String actionCommand = e.getActionCommand();
		
		if (actionCommand.equals("Convert"))
		{
			result = baseTwo(decimalNumber.getText());
			binaryNumber.setText(result);
		}
		else if (actionCommand.equals("Clear"))
		{
			result = "";
			binaryNumber.setText("");
			decimalNumber.setText("");
		}
	} //assumingCorrectNumberFormats
	
	// Conversion of Base 10 to Base 2
	private String baseTwo(String inputNumber)
	{	//Parse String to integer
		int input = Integer.parseInt(inputNumber);
		
		if ( input == 0 )
		{
			return "" + 0;
		} // end of if ()
		if ( input < 0 )
		{
			return "error";
		} // end of if ()
		
		String result = "";
		while ( input != 0 )
		{
			result = "" + input % 2 + result;
			input /= 2;
		} // end of while ()
		
		return result;  // Return string version of integer
	}// baseTwo
}