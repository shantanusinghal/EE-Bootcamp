package com.ee.dd;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ee.dd.styles.Stylist;


public class Highlighter {

	private Map<String, Stylist> keywordsInfo;

	public Highlighter(List<String> keywords) {
		keywordsInfo = new HashMap<>();
		for (String keyword : keywords) {
			String [] info = keyword.split(":");
			String aKeyword = info[0];
			keywordsInfo.put(aKeyword, Stylist.makeNew(info));
		}
	}

	public String highlight(String text) {
		StringBuilder highlightedText = new StringBuilder();
		String[] tokens = text.split(" ");
		for (String token : tokens) {
			Stylist stylist = stylistFor(token);
			highlightedText.append(stylist.style(token));
			highlightedText.append(" ");
		}
		return highlightedText.toString().trim();
	}

	private Stylist stylistFor(String token) {
		String lowerCaseToken = token.toLowerCase();
		if(keywordsInfo.keySet().contains(lowerCaseToken)) {
			return keywordsInfo.get(lowerCaseToken);
		}
		return Stylist.None;
	}
}
