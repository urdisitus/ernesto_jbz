package com.jobiuz.base.adapters;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.jobiuz.R;
import com.jobiuz.base.LetraUtils;
import com.jobiuz.base.interfaces.UserBase;
import com.jobiuz.base.listeners.IButtonClickItemList;

public abstract class UserBaseAdapter<T extends UserBase> extends
		ArrayAdapter<T> implements OnClickListener {

	private IButtonClickItemList listerner;

	public UserBaseAdapter(Context context, List<T> objects) {
		super(context, R.layout.item_home_list, objects);
	}

	protected static class ViewHolder {
		public ImageView imgLogo, btnFavoritos, btnMensaje, btnSolicitar,
				btnNews;
		public TextView lblNombre, lblDesc;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = LayoutInflater.from(getContext()).inflate(
					R.layout.item_home_list, parent, false);
			holder.lblDesc = (TextView) convertView
					.findViewById(R.id.lbl_desc_item);
			holder.lblNombre = (TextView) convertView
					.findViewById(R.id.lbl_nombre_item);
			holder.btnFavoritos = (ImageView) convertView
					.findViewById(R.id.btn_favorito_item);
			holder.imgLogo = (ImageView) convertView
					.findViewById(R.id.img_logo_item);
			holder.btnMensaje = (ImageView) convertView
					.findViewById(R.id.btn_chat_item);
			holder.btnNews = (ImageView) convertView
					.findViewById(R.id.btn_list_item);
			holder.btnSolicitar = (ImageView) convertView
					.findViewById(R.id.btn_contactar_item);
			holder.btnFavoritos.setOnClickListener(this);
			holder.btnNews.setOnClickListener(this);
			holder.btnMensaje.setOnClickListener(this);
			LetraUtils.setBoldHelveticaNeue(holder.lblNombre);
			LetraUtils.setRegularHelveticaNeue(holder.lblDesc);
			holder.btnSolicitar.setOnClickListener(this);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		T item = getItem(position);
		holder.btnFavoritos.setTag(item);
		holder.btnMensaje.setTag(item);
		holder.btnNews.setTag(item);
		holder.btnSolicitar.setTag(item);
		holder.lblDesc.setText(item.getDescripcion());
		holder.lblNombre.setText(item.getNombre());
		return convertView;
	}

	@Override
	public void onClick(View v) {
		if (listerner != null) {
			listerner.OnInfoButtonClick(v, v.getTag());
		}
	}

}
