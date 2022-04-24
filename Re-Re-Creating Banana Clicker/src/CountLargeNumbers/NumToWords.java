package CountLargeNumbers;

import java.text.DecimalFormat;

import objects.ScoreFont;

public class NumToWords {

	private static DecimalFormat df2 = new DecimalFormat("0.0");
	
	private static DecimalFormat df = new DecimalFormat("0");
	
	
	private static int screenWidth;
	
	public static void setScreenWidth(int width) {
		screenWidth = width;
	}
	
	public static void changeResolution(int width) {
		screenWidth = width;
	}
	
	
	public static String NumToWord(double floatNumber) {
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
		
	    
	    double number = floatNumber; //Math.round(floatNumber);
	    if ((number >= million) && (number < billion)) {
	    	double fraction = calculateFraction(number, million);
	    	
	        return df2.format(fraction) + " Million";
	        //return Double.toString(fraction) + "M";
	    }
	    else if ((number >= billion) && (number < trillion)) {
	    	double fraction = calculateFraction(number, billion);
	    	
	        return df2.format(fraction) + " Billion";
	        //return Double.toString(fraction) + "B";
	    }
	    else if ((number >= trillion) && (number < quadrillion)) {
	        double fraction = calculateFraction(number, trillion);
	       
	        return df2.format(fraction) + " Trillion";
	    }
	    else if ((number >= quadrillion) && (number < quintillion)) {
	        double fraction = calculateFraction(number, quadrillion);
	        return df2.format(fraction) + " Quadrillion";
	    }
	    else if ((number >= quintillion) && (number < sextillion)) {
	        double fraction = calculateFraction(number, quintillion);
	        return df2.format(fraction) + " Quintillion";
	    }
	    else if ((number >= sextillion) && (number < septillion)) {
	        double fraction = calculateFraction(number, sextillion);
	        //System.out.println(number + "C");
	        //System.out.println(number + "C");
	        return df2.format(fraction) + " Sextillion";
	    }
	    else if ((number >= septillion) && (number < octillion)) {
	        double fraction = calculateFraction(number, septillion);
	        //System.out.println(number + "C");
	        //System.out.println(number + "C");
	        return df2.format(fraction) + " Septillion";
	    }
	    else if ((number >= octillion) && (number < nonillion)) {
	        double fraction = calculateFraction(number, octillion);
	        //System.out.println(number + "C");
	        //System.out.println(number + "C");
	        return df2.format(fraction) + " Octillion";
	    }
	    else if ((number >= nonillion) && (number < decillion)) {
	        double fraction = calculateFraction(number, nonillion);
	        return df2.format(fraction) + " Nonillion";
	    }
	    else if ((number >= nonillion) && (number < decillion)) {
	        double fraction = calculateFraction(number, nonillion);
	        return df2.format(fraction) + " Nonillion";
	    }
	    else if ((number >= decillion) && (number < undecillion)) {
	        double fraction = calculateFraction(number, decillion);
	        return df2.format(fraction) + " Decillion";
	    }
	    else if ((number >= undecillion) && (number < duodecillion)) {
	        double fraction = calculateFraction(number, undecillion);
	        return df2.format(fraction) + " Undecillion";
	    }
	    else if ((number >= duodecillion) && (number < tredecillion)) {
	        double fraction = calculateFraction(number, duodecillion);
	        return df2.format(fraction) + " Duodecillion";
	    }
	    else if ((number >= tredecillion) && (number < quattuordecillion)) {
	        double fraction = calculateFraction(number, tredecillion);
	        return df2.format(fraction) + " Tredecillion";
	    }
	    else if ((number >= quattuordecillion) && (number < quindecillion)) {
	        double fraction = calculateFraction(number, quattuordecillion);
	        return df2.format(fraction) + " Quattuordecillion";
	    }
	    else if ((number >= quindecillion) && (number < sexdecillion)) {
	        double fraction = calculateFraction(number, quindecillion);
	        return df2.format(fraction) + " Quindecillion";
	    }
	    else if ((number >= sexdecillion) && (number < septendecillion)) {
	        double fraction = calculateFraction(number, sexdecillion);
	        return df2.format(fraction) + " Sexdecillion";
	    }
	    else if ((number >= septendecillion) && (number < octodecillion)) {
	        double fraction = calculateFraction(number, septendecillion);
	        return df2.format(fraction) + " Septendecillion";
	    }
	    else if ((number >= octodecillion) && (number < novemdecillion)) {
	        double fraction = calculateFraction(number, octodecillion);
	        return df2.format(fraction) + " Octodecillion";
	    }
	    else if ((number >= novemdecillion) && (number < vigintillion)) {
	        double fraction = calculateFraction(number, novemdecillion);
	        return df2.format(fraction) + " Novemdecillion";
	    }
	    else if ((number >= vigintillion) && (number < unvigintillion)) {
	        double fraction = calculateFraction(number, vigintillion);
	        //printPrice = df2.format(fraction);
	        
	        return df2.format(fraction) + " Vigintillion";
	    }
	    else if ((number >= unvigintillion) && (number < duovigintillion)) {
	        double fraction = calculateFraction(number, unvigintillion);
	        return df2.format(fraction) + " Unvigintillion";
	    }
	    else if ((number >= duovigintillion) && (number < trevigintillion)) {
	        double fraction = calculateFraction(number, duovigintillion);
	        return df2.format(fraction) + " Duovigintillion";
	    }
	    else if ((number >= trevigintillion) && (number < quattuorvigintillion)) {
	        double fraction = calculateFraction(number, trevigintillion);
	        return df2.format(fraction) + " Trevigintillion";
	    }
	    else if ((number >= quattuorvigintillion) && (number < quinvigintillion)) {
	        double fraction = calculateFraction(number, quattuorvigintillion);
	        return df2.format(fraction) + " Quattuorvigintillion";
	    }
	    else if ((number >= quinvigintillion) && (number < sexvigintillion)) {
	        double fraction = calculateFraction(number, quinvigintillion);
	        return df2.format(fraction) + " Quinvigintillion";
	    }
	    else if ((number >= sexvigintillion) && (number < septenvigintillion)) {
	        double fraction = calculateFraction(number, sexvigintillion);
	        return df2.format(fraction) + " Sexvigintillion";
	    }
	    else if ((number >= septenvigintillion) && (number < octovigintillion)) {
	        double fraction = calculateFraction(number, septenvigintillion);
	        return df2.format(fraction) + " Septenvigintillion";
	    }
	    else if ((number >= octovigintillion) && (number < novemvigintillion)) {
	        double fraction = calculateFraction(number, octovigintillion);
	        return df2.format(fraction) + " Octovigintillion";
	    }
	    else if ((number >= novemvigintillion) && (number < trigintillion)) {
	        double fraction = calculateFraction(number, novemvigintillion);
	        return df2.format(fraction) + " Novemvigintillion";
	    }
	    
	    //sf2 = new ScoreFont(16*screenWidth/1920);
	    //return Double.toString(number);
	    return df.format(number);
	}
	
	
	
	public static String truncateNumberThousands(double floatNumber) {
		int thousand = 1000;
		int million = 1_000_000;
		
		double number = floatNumber; //Math.round(floatNumber);
	    if ((number >= thousand) && (number < million)) {
	    	double fraction = calculateFraction(number, thousand);
	    	return df2.format(fraction) + "k";
	        //return Double.toString(fraction) + "M";
	    }
	    
		return df.format(number);
	
	}
	
	public static double calculateFraction(double number, double divisor) {
	    float truncate = (float) ((number * 10F + (divisor / 2F)) / divisor);
	    double fraction = truncate * 0.1D;
	    return fraction;
	}

	
}
