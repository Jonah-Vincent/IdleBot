import java.awt.Robot;

public class RunRobot 
{
	private Thread runBot;
	private Robot robot;
	private robotest robo;
	
	public RunRobot()
	{
		try
		{
			robot = new Robot();
			robo = new robotest(robot);
			runBot = new Thread(robo);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void startPressed()
	{
		runBot.start();
	}
	
	public void stopPressed()
	{
		robo.stop();
		runBot = new Thread(robo);
	}
	
	public void delayChange(int delay)
	{
		robo.delayChange(delay);
	}
}
