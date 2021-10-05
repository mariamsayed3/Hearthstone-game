package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class ModernText2 extends JTextArea {
	private Font newFont;

	public ModernText2(String Text) {
		super(Text);
		setEditable(false);
		setOpaque(false);
		try {
			newFont = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/AbrilFatface.ttf")).deriveFont(30f);
			GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(newFont);
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
		setFont(newFont);
	}

	public void ChangeFontSize(float f) {
		newFont.deriveFont(f);
		setFont(newFont);
	}

	public void ChangeFontStyle(int x) {
		newFont.deriveFont(x);
		setFont(newFont);
	}

	public void ChangeColor(Color c) {
		this.setForeground(c);
	}

	public Font getNewFont() {
		return newFont;
	}

	public void setNewFont(Font newFont) {
		this.newFont = newFont;
	}
}
