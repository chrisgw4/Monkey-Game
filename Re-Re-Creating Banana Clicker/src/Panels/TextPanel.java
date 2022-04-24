package Panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;

import javax.swing.JLabel;
import javax.swing.JPanel;

import main.Main;
import objects.Banana;
import objects.Player;
import objects.ScoreFont;

public class TextPanel extends JPanel{

	private JLabel textlabel = new JLabel(Player.getCount()+"");
	private ScoreFont sf;
	private ScoreFont sf2;
	
	private int bananapX, bananapY, bananapLength, bananapHeight;
	
	private int width;
	private int height;
	
	private DecimalFormat df = new DecimalFormat("0");
	
	private DecimalFormat df2 = new DecimalFormat("0.0");
	
	private DecimalFormat df3 = new DecimalFormat("0.000");

	
	public TextPanel(int BananaX, int BananaY, int BananaLength, int BananaHeight, int width, int height) {
		
		bananapX = BananaX;
		bananapY = BananaY;
		bananapLength = BananaLength;
		bananapHeight = BananaHeight;
		
		df.setGroupingUsed(true);
		df.setGroupingSize(3);
		
		this.width = width;
		this.height = height;
		
		//this.setBackground(Color.black);
		//textlabel.setBackground(Color.black);
		//textlabel.setForeground(Color.white);
		
		this.setBounds((int)(bananapX+bananapLength*.89),(int) (bananapY+bananapHeight*.80-bananapHeight*.25),400,400);
		this.setOpaque(false);
		
		
		//textlabel.setFont();
		
		sf = new ScoreFont(24*width/1920);
		sf2 = new ScoreFont(18*width/1920);
		

		
		
		
		//this.add(textlabel);
	}
	
	public void updateLabel(Graphics2D g2d) {
		//textlabel.setText(Player.getCount()+"");
		g2d.setFont(sf.getScoreFont());
		g2d.setColor(Color.white);
		g2d.drawString(df.format(Player.getCount()), 280, 150);
	}
	
	public void paintComponent(Graphics g) {
		
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setFont(sf.getScoreFont());
		g2d.setColor(Color.white);
		//g2d.drawString(df.format(Player.getCount()), 10, (int)(bananapHeight*.3));
		
		//if(Player.getCount() < 1_000_000)
		{
			//g2d.drawString(df2.format(Player.getCount()), 10, (int)(bananapHeight*.3));
		}
		//else
		
			//g2d.drawString(this.truncateNumber(Player.getPassiveCount()), 10, (int)(bananapHeight*.41));
		//g2d.drawString(this.truncateNumber((Player.getCount())), 10, (int)(bananapHeight*.3));
		
		g2d.drawString(this.truncateNumber((Player.getCount())), (int) (bananapLength/2-g2d.getFontMetrics().stringWidth(truncateNumber(Player.getCount()))/2.2), (int)(bananapHeight*.3));
		
		//g2d.drawString(this.truncateNumber((Double.MAX_VALUE)), 10, (int)(bananapHeight*.3));
		//g2d.drawString((Player.getCount()+""), 10, (int)(bananapHeight*.3));
		
		
		
		g2d.setColor(Color.black);
		//Player.setPassiveCount((double)10000000000000000000D);
		
		//System.out.println(Player.getCount());
		
		//System.out.println(Player.getPassiveCount());
		//System.out.println(Double.MAX_VALUE);
		//g2d.drawString(df2.format(Player.getPassiveCount()), 10, (int)(bananapHeight*.41));
		g2d.setFont(sf2.getScoreFont());
		if(Player.getPassiveCount() < 100)
		{
			g2d.drawString(df2.format(Player.getPassiveCount()) + " BPS", 70, (int)(bananapHeight*.41));
		}
		else
		{
			g2d.drawString(this.truncateNumber(Player.getPassiveCount()) + " BPS", 70, (int)(bananapHeight*.41));
		}
	}
	
	public void changeResolution(int width, int height, BananaPanel bp) {
		this.width = width;
		this.height = height;
		bananapX = bp.getX();
		bananapY = bp.getY();
		bananapLength = bp.getWidth();
		bananapHeight = bp.getHeight();
		//setBounds((int)(bananapX+bananapLength*.89),(int) (bananapY+bananapHeight*.80-bananapHeight*.25),800,400);
		
		setBounds((int)(bananapX*0.67+bananapLength*0),(int) (bananapY+bananapHeight*.80-bananapHeight*.01),800,400);
		
		
		
		sf = new ScoreFont(24*width/1920);
		sf2 = new ScoreFont(20*width/1920);
	}
	
	public String truncateDecimal(float floatNumber) {
	    long million = 1000000L;
	    long billion = 1000000000L;
	    long trillion = 1000000000000L;
	    long number = (long) floatNumber;
	    if ((number >= million) && (number < billion)) {
	        float fraction = calculateFractionDecimal(number, million);
	        return Float.toString(fraction) + "M";
	    } else if ((number >= billion) && (number < trillion)) {
	        float fraction = calculateFractionDecimal(number, billion);
	        return Float.toString(fraction) + "B";
	    }
	    return Long.toString(number);
	}
	
	public float calculateFractionDecimal(long number, long divisor) {
	    long truncate = (number * 10L + (divisor / 2L)) / divisor;
	    float fraction = (float) truncate * 0.10F;
	    return fraction;
	}
	
	
	public String truncateNumber(double floatNumber) {
		//System.out.println(floatNumber + "C");
		double million = 1000000L;
		double billion = 1000000000L;
		double trillion = 1_000_000_000_000L;
	    double quadrillion = 1_000_000_000_000_000L;
	    double quintillion = 1_000_000_000_000_000_000L;
	    double sextillion = 1_000_000_000_000_000_000_000D;
	    double septillion = 1_000_000_000_000_000_000_000_000D;
	    double octillion = 1_000_000_000_000_000_000_000_000_000D;
	    double nonillion = 1_000_000_000_000_000_000_000_000_000_000D;
	    double decillion = 1_000_000_000_000_000_000_000_000_000_000_000D;
	    double undecillion = 1_000_000_000_000_000_000_000_000_000_000_000_000D;
	    double duodecillion = 1_000_000_000_000_000_000_000_000_000_000_000_000_000D;
	    double tredecillion = 1_000_000_000_000_000_000_000_000_000_000_000_000_000_000D;
	    double quattuordecillion = 1_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000D;
	    double quindecillion = 1_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000D;
	    double sexdecillion = 1_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000D;//17 sets
	    double septendecillion = 1_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000D;//18 sets of 0s
	    double octodecillion = 1_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000D;// 19
	    double novemdecillion = 1_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000D;//20
	    double vigintillion = 1_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000D;
	    double unvigintillion = 1_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000D;
	    double duovigintillion = 1_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000D;
	    double trevigintillion = 1_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000D;
	    double quattuorvigintillion = 1_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000D;
	    double quinvigintillion = 1_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000D;
	    double sexvigintillion = 1_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000D;
	    double septenvigintillion = 1_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000D;
	    double octovigintillion = 1_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000D;
	    double novemvigintillion = 1_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000D;
	    double trigintillion = 1_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000_000D;
		
	    // changed type to double from long because double can store larger numbers, and fixed problem of getting
	    // stuck at 9.27 quintillion
	    double number = floatNumber;//Math.round(floatNumber);
	    if ((number >= million) && (number < billion)) {
	        double fraction = calculateFraction(number, million);
	        //System.out.println(df3.format(fraction));
	        return df3.format(fraction) + " Million";
	        //return Float.toString(fraction) + "M";
	    }
	    else if ((number >= billion) && (number < trillion)) {
	        double fraction = calculateFraction(number, billion);
	        return df3.format(fraction) + " Billion";
	        //return Float.toString(fraction) + "B";
	    }
	    else if ((number >= trillion) && (number < quadrillion)) {
	        double fraction = calculateFraction(number, trillion);
	        return df3.format(fraction) + " Trillion";
	    }
	    else if ((number >= quadrillion) && (number < quintillion)) {
	        double fraction = calculateFraction(number, quadrillion);
	        return df3.format(fraction) + " Quadrillion";
	    }
	    else if ((number >= quintillion) && (number < sextillion)) {
	        double fraction = calculateFraction(number, quintillion);
	        //System.out.println(number + "C");
	        //System.out.println(number + "C");
	        return df3.format(fraction) + " Quintillion";
	    }
	    else if ((number >= sextillion) && (number < septillion)) {
	        double fraction = calculateFraction(number, sextillion);
	        return df3.format(fraction) + " Sextillion";
	    }
	    else if ((number >= septillion) && (number < octillion)) {
	        double fraction = calculateFraction(number, septillion);
	        return df3.format(fraction) + " Septillion";
	    }
	    else if ((number >= octillion) && (number < nonillion)) {
	        double fraction = calculateFraction(number, octillion);
	        return df3.format(fraction) + " Octillion";
	    }
	    else if ((number >= nonillion) && (number < decillion)) {
	        double fraction = calculateFraction(number, nonillion);
	        return df3.format(fraction) + " Nonillion";
	    }
	    else if ((number >= decillion) && (number < undecillion)) {
	        double fraction = calculateFraction(number, decillion);
	        return df3.format(fraction) + " Decillion";
	    }
	    else if ((number >= undecillion) && (number < duodecillion)) {
	        double fraction = calculateFraction(number, undecillion);
	        return df3.format(fraction) + " Undecillion";
	    }
	    else if ((number >= duodecillion) && (number < tredecillion)) {
	        double fraction = calculateFraction(number, duodecillion);
	        sf = new ScoreFont(22);
	        return df3.format(fraction) + " Duodecillion";
	    }
	    else if ((number >= tredecillion) && (number < quattuordecillion)) {
	        double fraction = calculateFraction(number, tredecillion);
	        sf = new ScoreFont(22);
	        return df3.format(fraction) + " Tredecillion";
	    }
	    else if ((number >= quattuordecillion) && (number < quindecillion)) {
	        double fraction = calculateFraction(number, quattuordecillion);
	        sf = new ScoreFont(22);
	        return df3.format(fraction) + " Quattuordecillion";
	    }
	    else if ((number >= quindecillion) && (number < sexdecillion)) {
	        double fraction = calculateFraction(number, quindecillion);
	        sf = new ScoreFont(22);
	        return df3.format(fraction) + " Quindecillion";
	    }
	    else if ((number >= sexdecillion) && (number < septendecillion)) {
	    	sf = new ScoreFont(21);
	        double fraction = calculateFraction(number, sexdecillion);
	        return df3.format(fraction) + " Sexdecillion";
	    }
	    else if ((number >= septendecillion) && (number < octodecillion)) {
	        double fraction = calculateFraction(number, septendecillion);
	        sf = new ScoreFont(22);
	        return df3.format(fraction) + " Septendecillion";
	    }
	    else if ((number >= octodecillion) && (number < novemdecillion)) {
	        double fraction = calculateFraction(number, octodecillion);
	        sf = new ScoreFont(22);
	        return df3.format(fraction) + " Octodecillion";
	    }
	    else if ((number >= novemdecillion) && (number < vigintillion)) {
	        double fraction = calculateFraction(number, novemdecillion);
	        sf = new ScoreFont(22);
	        return df3.format(fraction) + " Novemdecillion";
	    }
	    else if ((number >= vigintillion) && (number < unvigintillion)) {
	        double fraction = calculateFraction(number, vigintillion);
	        
	        return df3.format(fraction) + " Vigintillion";
	    }
	    else if ((number >= unvigintillion) && (number < duovigintillion)) {
	        double fraction = calculateFraction(number, unvigintillion);
	        return df2.format(fraction) + " Unvigintillion";
	    }
	    else if ((number >= duovigintillion) && (number < trevigintillion)) {
	        double fraction = calculateFraction(number, duovigintillion);
	        sf = new ScoreFont(22);
	        return df2.format(fraction) + " Duovigintillion";
	    }
	    else if ((number >= trevigintillion) && (number < quattuorvigintillion)) {
	        double fraction = calculateFraction(number, trevigintillion);
	        sf = new ScoreFont(22);
	        return df2.format(fraction) + " Trevigintillion";
	    }
	    else if ((number >= quattuorvigintillion) && (number < quinvigintillion)) {
	        double fraction = calculateFraction(number, quattuorvigintillion);
	        sf = new ScoreFont(18);
	        return df2.format(fraction) + " Quattuorvigintillion";
	    }
	    else if ((number >= quinvigintillion) && (number < sexvigintillion)) {
	        double fraction = calculateFraction(number, quinvigintillion);
	        sf = new ScoreFont(22);
	        return df2.format(fraction) + " Quinvigintillion";
	    }
	    else if ((number >= sexvigintillion) && (number < septenvigintillion)) {
	        double fraction = calculateFraction(number, sexvigintillion);
	        sf = new ScoreFont(22);
	        return df2.format(fraction) + " Sexvigintillion";
	    }
	    else if ((number >= septenvigintillion) && (number < octovigintillion)) {
	        double fraction = calculateFraction(number, septenvigintillion);
	        sf = new ScoreFont(19);
	        return df2.format(fraction) + " Septenvigintillion";
	    }
	    else if ((number >= octovigintillion) && (number < novemvigintillion)) {
	        double fraction = calculateFraction(number, octovigintillion);
	        sf = new ScoreFont(22);
	        return df2.format(fraction) + " Octovigintillion";
	    }
	    else if ((number >= novemvigintillion) && (number < trigintillion)) {
	        double fraction = calculateFraction(number, novemvigintillion);
	        sf = new ScoreFont(20);
	        return df2.format(fraction) + " Novemvigintillion";
	    }
	    
	    
	    //return Double.toString(number);
	    
	    return df.format(number);
	}
	
	public double calculateFraction(double number, double divisor) {
	    float truncate = (float) ((number * 10F + (divisor / 2F)) / divisor);
	    double fraction = truncate * 0.1D;
	    //System.out.println(number + "C");
	    //System.out.println(((number * 10D + (divisor / 2D)) / divisor) + "C");
	    return fraction;
	}
	
//	public String truncateNumber(long floatNumber) {
//		long million = 1000000L;
//		long billion = 1000000000L;
//		long trillion = 1_000_000_000_000L;
//		long quadrillion = 1_000_000_000_000_000L;
//		long quintillion = 1_000_000_000_000_000_000L;
//		long sextillion = (long) 1_000_000_000_000_000_000_000D;
//	    long number = Math.round(floatNumber);
//	    if ((number >= million) && (number < billion)) {
//	        double fraction = calculateFraction(number, million);
//	        //System.out.println(df3.format(fraction));
//	        return df3.format(fraction) + " Million";
//	        //return Float.toString(fraction) + "M";
//	    }
//	    else if ((number >= billion) && (number < trillion)) {
//	        double fraction = calculateFraction(number, billion);
//	        return df3.format(fraction) + " Billion";
//	        //return Float.toString(fraction) + "B";
//	    }
//	    else if ((number >= trillion) && (number < quadrillion)) {
//	        double fraction = calculateFraction(number, trillion);
//	        return df3.format(fraction) + " Trillion";
//	    }
//	    else if ((number >= quadrillion) && (number < quintillion)) {
//	        double fraction = calculateFraction(number, quadrillion);
//	        return df3.format(fraction) + " Quadrillion";
//	    }
//	    else if ((number >= quintillion) && (number < sextillion)) {
//	        double fraction = calculateFraction(number, quintillion);
//	        return df3.format(fraction) + " Quintillion";
//	    }
//	    //return Double.toString(number);
//	    return df.format(number);
//	}
//	
//	public double calculateFraction(long number, double divisor) {
//	    float truncate = (float) ((number * 10F + (divisor / 2F)) / divisor);
//	    double fraction = truncate * 0.1D;
//	    return fraction;
//	}
//
}
