package com.jobiuz.base;

import com.jobiuz.GlobalApp;

import android.content.Context;
import android.widget.TextView;

public class LetraUtils {
	public static void setBoldHelveticaNeue(TextView... lbl) {
		if (GlobalApp.getInstance() != null) {
			for (TextView textView : lbl) {
				GlobalApp.getInstance().setBoldHelveticaNeue(textView);
			}

		}
	}

	public static void setFontColor(Context context, int resColor,
			TextView... lbl) {
		for (TextView textView : lbl) {
			if (textView != null) {
				textView.setTextColor(context.getResources().getColor(resColor));
			}
		}
	}

	public static void setItalicHelveticaNeue(TextView... lbl) {
		if (GlobalApp.getInstance() != null) {
			for (TextView textView : lbl) {
				GlobalApp.getInstance().setItalicHelveticaNeue(textView);
			}
		}
	}

	public static void setUltraLigthHelveticaNeue(TextView... lbl) {
		if (GlobalApp.getInstance() != null) {
			for (TextView textView : lbl) {
				GlobalApp.getInstance().setUltraLigthHelveticaNeue(textView);
			}
		}
	}

	public static void setRegularHelveticaNeue(TextView... lbl) {
		if (GlobalApp.getInstance() != null) {
			for (TextView textView : lbl) {
				GlobalApp.getInstance().setRegularHelveticaNeue(textView);
			}
		}
	}
}
