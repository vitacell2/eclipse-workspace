import java.awt.*;

public class PongEnvironment
{
	// SCREEN RESOLUTION
	public static final int WIDTH = 256;
	public static final int HEIGHT = 240;

	// OBJECT ATTRIBUTES
	private Ball myBall;
	private Paddle myLeft, myRight;
	private int leftScore = 0, rightScore = 0;
	private boolean leftComputer, rightComputer;

	// CONSTRUCTOR
	public PongEnvironment() // The first ball spawn at game start
	{
		myBall = new Ball(Color.BLUE, WIDTH/2, HEIGHT/2);
		myLeft = new Paddle(10, HEIGHT/2);
		myRight = new Paddle(WIDTH-10, HEIGHT/2);
	}

	public void setComputer(boolean l, boolean r)
	{
		leftComputer = l;
		rightComputer = r;
	}

	public Paddle getLeft()
	{
		return myLeft;
	}

	public Paddle getRight()
	{
		return myRight;
	}

	private void leftScore() // call this, when computer player scores
	{
		leftScore++;

		try
		{
			Thread.sleep(1000);
		}
		catch(Exception ex)
		{
		}

		myBall = new Ball(Color.BLUE, WIDTH/2, HEIGHT/2);
		myLeft = new Paddle(10, HEIGHT/2);
		myRight = new Paddle(WIDTH-10, HEIGHT/2);
	}

	private void rightScore() // call this, when human player scores
	{
		rightScore++;

		try
		{
			Thread.sleep(1000);
		}
		catch(Exception ex)
		{
		}

		myBall = new Ball(Color.BLUE, WIDTH/2, HEIGHT/2);
		myLeft = new Paddle(10, HEIGHT/2);
		myRight = new Paddle(WIDTH-10, HEIGHT/2);
	}

	public void update()
	{
		myBall.move();
		if(myBall.getLocation().getY() - Ball.RADIUS <= 0)
			myBall.bounceTop();
		else if(myBall.getLocation().getY() + Ball.RADIUS >= HEIGHT)
			myBall.bounceTop();
		else if(myLeft.contains(myBall))
			myBall.bounceSide();
		else if(myRight.contains(myBall))
			myBall.bounceSide();
		else if(myBall.getLocation().getX() < 0)
			rightScore();
		else if(myBall.getLocation().getX() > WIDTH)
			leftScore();

		if(leftComputer)
			myLeft.moveTo((int)myBall.getLocation().getY());
		if(rightComputer)
			myRight.moveTo((int)myBall.getLocation().getY());

	}

	public void draw(Graphics g)
	{
		myBall.draw(g);
		myLeft.draw(g);
		myRight.draw(g);

		g.drawString("Score: "+ leftScore, 25, 12);
		g.drawString("Score: "+ rightScore, WIDTH-125, 12);
	}
}