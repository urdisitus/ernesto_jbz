package com.jobiuz.base.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class TabView extends ImageView {

	private int resSelected;
	private int resNoSelected;

	public TabView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		setPadding(0, 5, 0, 5);
	}

	public TabView(Context context, AttributeSet attrs) {
		super(context, attrs);
		setPadding(0, 5, 0, 5);
	}

	public TabView(Context context) {
		super(context);
		setPadding(0, 5, 0, 5);
	}

	public TabView(Context context, int selected, int notSelected) {
		super(context);
		setPadding(0, 10, 0, 10);
		this.resNoSelected = notSelected;
		this.resSelected = selected;
		setImageResource(resNoSelected);
	}

	public void setResNoSelected(int resNoSelected) {
		this.resNoSelected = resNoSelected;
	}

	public void setResSelected(int resSelected) {
		this.resSelected = resSelected;
	}

	public int getResNoSelected() {
		return resNoSelected;
	}

	public int getResSelected() {
		return resSelected;
	}

	@Override
	public void setSelected(boolean selected) {
		super.setSelected(selected);
		if (selected) {
			setImageResource(resSelected);
		} else {
			setImageResource(resNoSelected);
		}
	}

}
