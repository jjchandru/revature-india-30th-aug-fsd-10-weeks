import javax.swing.JFrame;

public class SwingFrameExample {
	
	public static void main(String args[]) {
		JFrame frame = new JFrame("FrameDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		//System.out.println("test");
	}

}
