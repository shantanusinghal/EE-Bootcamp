package com.ee.dd.styles;


enum Color implements Style {
	blue,
	green,
	red;
	
	public String applyTo(String keyword) {
		return wrapInTag(name(), keyword);
	}
	
	private String tag(String data) {
		return "[" + data + "]";
	}

	private String wrapInTag(String color, String keyword) {
		return tag(color) + keyword + tag(color);
	}
}

