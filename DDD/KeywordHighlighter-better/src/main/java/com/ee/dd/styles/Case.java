package com.ee.dd.styles;


enum Case implements Style {
	none { 
		@Override
		public String applyTo(String keyword) {
			return keyword;
		}
	}, lower {

		@Override
		public String applyTo(String keyword) {
			return keyword.toLowerCase();
		}
		
	}, capital {

		@Override
		public String applyTo(String keyword) {
			return keyword.toUpperCase();
		}
	};
	
}