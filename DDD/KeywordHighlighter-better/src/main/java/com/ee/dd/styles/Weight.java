package com.ee.dd.styles;


enum Weight implements Style {
	normal {
		@Override
		public String applyTo(String keyword) {
			return keyword;
		}
	}, bold;
	
	public String applyTo(String keyword) {
		return wrapInTag(name(), keyword);
	}
	
	private String tag(String data) {
		return "[" + data + "]";
	}

	private String wrapInTag(String weight, String keyword) {
		return tag(weight) + keyword + tag(weight);
	}
}
