package com.jobiuz.base.adapters;

import com.jobiuz.base.listeners.IBaseActivity;

import android.widget.CompoundButton;

public interface IToggleItemListListener extends IBaseActivity {
	void onTogglePressed(CompoundButton buttonView, boolean isChecked,
			Object tag);
}
