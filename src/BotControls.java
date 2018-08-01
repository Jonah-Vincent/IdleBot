import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class BotControls {

	private JFrame frmIdlebot;
	
	private static RunRobot runner;
	private JTextField changeDelayField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BotControls window = new BotControls();
					window.frmIdlebot.setVisible(true);
					runner = new RunRobot();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BotControls() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frmIdlebot = new JFrame();
		frmIdlebot.setForeground(Color.BLACK);
		frmIdlebot.setBackground(Color.BLACK);
		frmIdlebot.setTitle("IdleBot");
		frmIdlebot.getContentPane().setLayout(new BorderLayout(0, 0));
		frmIdlebot.setSize(400,200);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		frmIdlebot.getContentPane().add(panel, BorderLayout.CENTER);
		
		
		JButton StartBot = new JButton("Start the bot");
		StartBot.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getActionCommand().equals("Start the bot"))
				{
					System.out.println("starting bot");
					runner.startPressed();
				}
			}
		});
		
		JButton StopBot = new JButton("Stop the bot");
		StopBot.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(e.getActionCommand().equals("Stop the bot"));
				{
					System.out.println("stopping bot");
					runner.stopPressed();
				}
			}
		});
		
		changeDelayField = new JTextField();
		changeDelayField.setColumns(10);
		
		JButton changeDelayButton = new JButton("Change Delay");
		changeDelayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String input = changeDelayField.getText();
				int userint = Integer.valueOf(input);
				runner.delayChange(userint);
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(120)
					.addComponent(StartBot)
					.addGap(5)
					.addComponent(StopBot))
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(171, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(changeDelayButton)
						.addComponent(changeDelayField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(124))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(StartBot)
						.addComponent(StopBot))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(changeDelayField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(changeDelayButton)
					.addContainerGap(78, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
	}
}
