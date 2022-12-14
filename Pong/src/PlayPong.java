import javax.swing.*;
import java.awt.*;

public class PlayPong extends JFrame
{
	private static final long serialVersionUID = 1L;

	public PlayPong()
	{
		getContentPane().setLayout(new FlowLayout());
		add(new PongComponent());
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args)
	{
		new PlayPong();
	}
}