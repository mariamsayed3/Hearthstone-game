package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Stroke;
import java.io.File;
import java.io.IOException;

import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class ModernText4 extends JTextArea {
	private Font newFont;
	Stroke stroke = new BasicStroke(3.0f);

	public ModernText4(String Text) {
		super(Text);
		setEditable(false);
		setOpaque(false);
		try {
			newFont = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/Up.otf")).deriveFont(15f);
			GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(newFont);
			// paint(getGraphics(), newFont, Text);

		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
		setFont(newFont);
	}

	/*
	 * public void paint(Graphics g1, Font f, String Text) { Graphics2D g =
	 * (Graphics2D) g1; // Get a shape to work with. Here we'll use the letter B
	 * GlyphVector gv = f.createGlyphVector(g.getFontRenderContext(), Text); Shape
	 * shape = gv.getOutline();
	 * 
	 * // Set drawing attributes and starting position g.setColor(Color.black);
	 * g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	 * RenderingHints.VALUE_ANTIALIAS_ON); g.translate(10, 175);
	 * 
	 * // Draw the shape once with each stroke g.setStroke(stroke); // set the
	 * stroke g.draw(shape); // draw the shape g.translate(140, 0); // move to the
	 * right }
	 */

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
