package com.ee.dd.styles;


public class Stylist {
	public static Stylist None = new Stylist();
	private Style[] styles;
	
	private Stylist(Style ...styles) {
		this.styles = styles;
	}

	public String style(String keyword) {
		for (Style style : styles) {
			keyword = style.applyTo(keyword);
		}
		return keyword;
	}

	public static Stylist makeNew(String[] info) {
		Color color = Color.blue;
		if(info.length > 1) {
			color = Color.valueOf(info[1]);
		}
		
		Case wordCase = Case.none;
		if(info.length > 2) {
			wordCase = Case.valueOf(info[2]);
		}
		
		Weight weight = Weight.normal;
		if(info.length > 3) {
			weight = Weight.valueOf(info[3]);
		}
		
		return new Stylist(wordCase, weight, color);
	}
}
