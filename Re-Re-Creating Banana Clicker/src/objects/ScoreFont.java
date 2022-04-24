package objects;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;

import javax.print.DocFlavor.URL;

import main.Main;






public class ScoreFont {

	
	
	private Font scoreFont; 
	
	
	
	public ScoreFont()
	{
		
		
		try {
//			String fName = "/Fonts/score.ttf";
//			InputStream is = Main.class.getResourceAsStream(fName);
//			
//			scoreFont = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(24f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/score.ttf")));
		}
		catch(IOException | FontFormatException e) {
			
		}
	}
	
	public ScoreFont(int size)
	{
		
		try {
//			String fName = "/Fonts/score.ttf";
//			InputStream is = Main.class.getResourceAsStream(fName);
//			scoreFont = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(Font.PLAIN, size);
//			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
//			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, is));
//			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
//			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/score.ttf")));
			
			// These two lines load it from the file instead of from inside the src
			scoreFont = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/score.ttf")).deriveFont(Font.PLAIN, size);
		    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		}
		catch(IOException | FontFormatException e) {
			
		}
	}
	
	public Font getScoreFont() {
		return scoreFont;
	}
	
	public void changeFontSize(int size) {
		try {
			scoreFont = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/score.ttf")).deriveFont(Font.PLAIN, size);
		    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		}
		catch(IOException | FontFormatException e) {
			
		}
	}
	
//	public Font getFont() throws Exception {
//		String fName = "/fonts/score.ttf";
//	    InputStream is = ScoreFont.class.getResourceAsStream(fName);
//	    Font font = Font.createFont(Font.TRUETYPE_FONT, is);
//	    return font;
//	}
	
	
//	public Font getFont(String fileName) throws FontFormatException, IOException, URISyntaxException  {
//	    String path = "/Fonts/" + fileName;
//	    URL url = getClass().getResource(path);
//	    return Font.createFont(Font.TRUETYPE_FONT, new File(url.toURI()));
//	}
	
	
//	private static Font getFont() {
//	    Font font = null;
//
//        String fName = "/Fonts";
//        File fontFile = new File(fName);
//        try {
//			font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
//		} catch (FontFormatException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        GraphicsEnvironment ge = GraphicsEnvironment
//                .getLocalGraphicsEnvironment();
//
//        ge.registerFont(font);
//
//	        
//	   
//	    return font;
//	}
//	
//	public void draw(Graphics g) {
//		g.drawString(p.getCount()+"", 0, 0);
//	}
}
