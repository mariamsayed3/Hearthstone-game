package view;

import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class modernJLabel extends JLabel {
	public modernJLabel() {
		super();
	}

	public void setBounds(int x, int y, int width, int height) {
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice device = env.getScreenDevices()[0];
		DisplayMode Mode = device.getDisplayMode();
		double modeWidth = Mode.getWidth();
		double modeHeight = Mode.getHeight();
		double horizontalRatio = (x * 1.0) / 1366.0;
		double verticalRatio = (y * 1.0) / 768.0;
		int newX = (int) (horizontalRatio * modeWidth);
		int newY = (int) (verticalRatio * modeHeight);
		super.setBounds(newX, newY, width, height);
	}

}
