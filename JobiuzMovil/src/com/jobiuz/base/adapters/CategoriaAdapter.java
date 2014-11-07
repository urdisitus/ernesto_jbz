package com.jobiuz.base.adapters;

import java.util.List;

import com.jobiuz.R;
import com.jobiuz.entidades.Categoria;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.ToggleButton;

public class CategoriaAdapter extends ArrayAdapter<Categoria> implements
		OnCheckedChangeListener {
	private IToggleItemListListener listener;

	public CategoriaAdapter(Context context, List<Categoria> objects) {
		super(context, R.layout.item_categoria, objects);
	}

	public void setListener(IToggleItemListListener listener) {
		this.listener = listener;
	}

	class ViewHolder {
		ToggleButton toggle;
		TextView lblNombre;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = LayoutInflater.from(getContext()).inflate(
					R.layout.item_categoria, parent, false);
			holder.lblNombre = (TextView) convertView
					.findViewById(R.id.lbl_nombre_categoria);
			holder.toggle = (ToggleButton) convertView
					.findViewById(R.id.toggle_categoria);
			holder.toggle.setOnCheckedChangeListener(this);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		Categoria cat = getItem(position);
		holder.lblNombre.setText(cat.getNombre());
		holder.toggle.setTag(cat);
		return convertView;
	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		if (listener != null) {
			listener.onTogglePressed(buttonView, isChecked, buttonView.getTag());
		}
	}
}
