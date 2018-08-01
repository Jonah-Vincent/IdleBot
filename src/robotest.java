import java.awt.Robot;
import java.awt.event.InputEvent;

public class robotest implements Runnable
{

	private Robot robot;
	private int left_button;
	private boolean runit;
	private int delay;
	
	public robotest(Robot r)
	{
		robot = r;
		int left_button_id = InputEvent.BUTTON1_MASK;
		left_button = left_button_id;
		runit = false;
		delay = 5000;
	}
	
	public void stop()
	{
		runit = false;
	}
	
	
	public void run()
	{
		runit = true;
		while(runit)
		{
			lookLeft();
			if(runit == false)
			{
				break;
			}
			lookRight();
			if(runit == false)
			{
				break;
			}
			moveLeft();
			if(runit == false)
			{
				break;
			}
			stopLeft();
			if(runit == false)
			{
				break;
			}
			moveRight();
			if(runit == false)
			{
				break;
			}
			stopRight();
			if(runit == false)
			{
				break;
			}
			moveFoward();
			if(runit == false)
			{
				break;
			}
			stopFoward();
			if(runit == false)
			{
				break;
			}
			moveBack();
			if(runit == false)
			{
				break;
			}
			stopBack();
			if(runit == false)
			{
				break;
			}
			startShoot();
			if(runit == false)
			{
				break;
			}
			stopShoot();
			if(runit == false)
			{
				break;
			}
		}
	}
	
	
	public void lookLeft()
	{
		robot.mouseMove(540,960);
		robot.delay(delay);
	}
	
	public void lookRight()
	{
		robot.mouseMove(1000,1000);
		robot.delay(delay);
	}
	
	public void moveLeft()
	{
		robot.keyPress(65);
		robot.delay(delay);
	}
	
	public void stopLeft()
	{
		robot.keyRelease(65);
		robot.delay(delay);
	}
	
	public void moveRight()
	{
		robot.keyPress(68);
		robot.delay(delay);
	}
	
	public void stopRight()
	{
		robot.keyRelease(68);
		robot.delay(delay);
	}
	
	public void moveFoward()
	{
		robot.keyPress(87);
		robot.delay(delay);
	}
	
	public void stopFoward()
	{
		robot.keyRelease(87);
		robot.delay(delay);
	}
	
	public void moveBack()
	{
		robot.keyPress(83);
		robot.delay(delay);
	}
	
	public void stopBack()
	{
		robot.keyRelease(83);
		robot.delay(delay);
	}
	
	public void startShoot()
	{
		robot.mousePress(left_button);
		robot.delay(delay);
	}
	
	public void stopShoot()
	{
		robot.mouseRelease(left_button);
		robot.delay(delay);
	}

	public void delayChange(int delay2) 
	{
		delay = delay2*1000;
	}

}
