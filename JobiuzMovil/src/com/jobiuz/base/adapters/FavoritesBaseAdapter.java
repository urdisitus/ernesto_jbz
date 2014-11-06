package com.jobiuz.base.adapters;

import java.util.List;

import com.jobiuz.R;
import com.jobiuz.base.LetraUtils;
import com.jobiuz.base.interfaces.UserBase;
import com.jobiuz.base.listeners.IButtonClickItemList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class FavoritesBaseAdapter<T extends UserBase> extends ArrayAdapter<T>
		implements OnClickListener {

	private IButtonClickItemList listerner;

	public FavoritesBaseAdapter(Context context, List<T> objects) {
		super(context, R.layout.item_favorito, objects);
	}

	class ViewHolder {
		ImageView imgLogo, btnEliminar;
		TextView lblNombre;
		TextView lblDesc;

	}

	@SuppressWarnings("unchecked")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = LayoutInflater.from(getContext()).inflate(
					R.layout.item_favorito, parent, false);
			holder.btnEliminar = (ImageView) convertView
					.findViewById(R.id.btn_eliminar_favorite);
			holder.btnEliminar.setOnClickListener(this);
			holder.imgLogo = (ImageView) convertView
					.findViewById(R.id.img_logo_favorite);
			holder.lblDesc = (TextView) convertView
					.findViewById(R.id.lbl_desc_favorite);
			holder.lblNombre = (TextView) convertView
					.findViewById(R.id.lbl_nombre_favorite);
			LetraUtils.setRegularHelveticaNeue(holder.lblDesc);
			LetraUtils.setBoldHelveticaNeue(holder.lblNombre);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		T item = getItem(position);
		holder.btnEliminar.setTag(item);
		holder.lblDesc.setText(item.getDescripcion());
		holder.lblNombre.setText(item.getNombre());
		return convertView;
	}

	public void setListerner(IButtonClickItemList listerner) {
		this.listerner = listerner;
	}

	@Override
	public void onClick(View v) {
		if (listerner != null) {
			listerner.OnInfoButtonClick(v, v.getTag());
		}
	}

}
