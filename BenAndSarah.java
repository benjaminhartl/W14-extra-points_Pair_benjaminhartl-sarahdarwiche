import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

class BenAndSarah{
    
    JFrame jf; 
    JLabel jl;
    JButton jb1 = new JButton( "Button 1" );
    JButton jb2 = new JButton( "Button 2 and is much longer button" );
    JButton jb3 = new JButton( "small" );
    JButton jb4 = new JButton( "Button 4" );
    JPanel jp1 = new JPanel();
    JPanel jp2 = new JPanel();
    JTextArea jta = new JTextArea( 10,10 );

    public BenAndSarah()                           // No arg constructor 
    {
    }
    
    public void go()
    {
	Scanner scan = new Scanner( System.in );     
	int input = 0;
	while( ( input > 4 ) || ( input < 1 ) )    // Checks for valid input
	    {
		System.out.println( "Press 1 for a BorderLayout example" );
		System.out.println( "Press 2 for a FlowLayout example" );
		System.out.println( "Press 3 for a BoxLayout example" );
		System.out.println( "Press 4 for a NullLayout example" );
		
		input = scan.nextInt();            // Scans the next integer
	    }
	chooseTest( input );
    }

    public void chooseTest( int x )
    {
	jf = new JFrame();
       	// Opens the layout that the user has selected
	if( x == 1 )
	    testBorderLayout();
	else if( x == 2 )
	    testFlowLayout();	
	else if( x == 3 )
	    testBoxLayout();
	else if( x == 4 )
	    testNullLayout();
	jf.setSize( 900, 600 );
	jf.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	jf.setVisible( true );
    }
   
    public void testBorderLayout()              // USER input of 1
    {
       	jf.setTitle( "BorderLayout Example" );
	jl = new JLabel( "JLabel on JFrame at BorderLayout.NORTH " + 
				"and JLabels by default start to the far left");
	jp1.setBackground( Color.BLUE );        // Sets panel background

	jb1.setText("This button is BorderLayout.CENTER, takes leftover space");
	jb1.setLayout( new BorderLayout() );    // Button 1
	jb1.setBackground( Color.BLACK );
	
	jb2.setText( "This Button is is located at the BorderLayout.SOUTH " +
		     "of the Black Button");    // Button 2 
	jb2.setBackground( Color.GREEN ); 
	
	jb3.setText( "WEST" );                  // Button 3
	jb3.setBackground( Color.BLUE );  
	
	jb1.add( jb2, BorderLayout.SOUTH );     // Adds Button 2 onto Button 1
	
	jf.add( jl, BorderLayout.NORTH );       // Adds them all to the frame
	jf.add( jb3, BorderLayout.WEST );
	jf.add( jb1, BorderLayout.CENTER );
    }

    public void testFlowLayout()                // USER input of 2
    {
	jf.setTitle( "FlowLayout Example" );

	jp1.setBackground( Color.BLACK );

	jb3.setText( "This Button is much longer so this will end up " + 
		     "on the next line since this if a FlowLayout" );
	jp1.add( jb1 );                        
	jp1.add( jb2 );                         // Button 1 2, and 3 to panel
	jp1.add( jb3 );

	jp2.add( jb4 );                         // Puts Button 4 on panel 2
	jp2.add( jta );                         // puts Text area on panel 2

	jta.append( "  JPanels have a\n  FlowLayout as\n   thier default" );

	jb4.setText( "This Button is on the blue JPanel" );

	jp2.setBackground( Color.BLUE );

	jp1.add( jp2 );
	jf.add( jp1 );
    }

    public void testBoxLayout()                // USER input of 3
    {
	jp1.setLayout( new BoxLayout( jp1, BoxLayout.Y_AXIS ) );
	jf.setTitle( "BoxLayout Example" );

	jb3.setText( "This Button is even longer but this will always end "+
		     "up on the next line since this is a BoxLayout" );
	
	jp1.setBackground( Color.BLACK );
	jp1.add( jb1 );                        // Button all buttons to panel 1
	jp1.add( jb2 );
	jp1.add( jb3 );                        
	jp1.add( jb4 );

	jb4.setText( "This is also on a new line" );
	jf.add( jp1 );                         // Adds the panel to Frame
    }

    public void testNullLayout()               // USER input of 4
    {
	jf.setTitle( "NullLayout Example" );

	jp1.setLayout( null );                 // Disables the layout managers

	jf.add( jp1 );
	jp1.add( jb1 );

	jb1.setText( "(x,y)=(50,50)" );        // Button 1
	jb1.setBounds( 50, 50, 200, 200 );
	jb1.setBackground( Color.PINK );

	jl = new JLabel( "200 x 200" );        // Label 1
	jl.setBounds( 50, 20, 80, 40 );
	jp1.add( jl );
	
	jb2.setText( "(x,y)=(300,80)" );       // Button 2
	jb2.setBackground( Color.GREEN );
	jb2.setBounds( 300, 80, 150, 50 );
	jp1.add( jb2 );


	JLabel jl2 = new JLabel( "150 x 50" ); // Label 2
	jl2.setBounds( 300, 50, 80, 40 );
	jp1.add( jl2 );

	jb3.setText( "(500,50)" );             // Button 3
	jb3.setBounds( 500, 50, 100, 400 );
	jp1.add( jb3 );

	JLabel jl3 = new JLabel( "100 x 400" );// Label 3
	jl3.setBounds( 500, 20, 80, 40 );
	jp1.add( jl3 );
	
	

    }
    
    public static void main( String [] args )
    {
	BenAndSarah bas = new BenAndSarah();
	bas.go();
    }
}
