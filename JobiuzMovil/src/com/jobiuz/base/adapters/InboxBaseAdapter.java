package com.jobiuz.base.adapters;

import java.util.List;

import com.jobiuz.R;
import com.jobiuz.Utils;
import com.jobiuz.base.LetraUtils;
import com.jobiuz.base.interfaces.UserBase;
import com.jobiuz.base.listeners.IButtonClickItemList;
import com.jobiuz.entidades.Message;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class InboxBaseAdapter<T extends UserBase> extends
		ArrayAdapter<Message<T>> implements OnClickListener {

	private IButtonClickItemList listener;

	public InboxBaseAdapter(Context context, List<Message<T>> objects) {
		super(context, R.layout.item_inbox, objects);
	}

	public void setListener(IButtonClickItemList listener) {
		this.listener = listener;
	}

	class ViewHolder {
		ImageView imgLogo, btnEliminar;
		TextView lblNombre, lblFecha, lblDesc;
	}

	@SuppressWarnings("unchecked")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = LayoutInflater.from(getContext()).inflate(
					R.layout.item_inbox, parent, false);
			holder.btnEliminar = (ImageView) convertView
					.findViewById(R.id.btn_eliminar_inbox);
			holder.btnEliminar.setOnClickListener(this);
			holder.imgLogo = (ImageView) convertView
					.findViewById(R.id.img_logo_inbox);
			holder.lblFecha = (TextView) convertView
					.findViewById(R.id.lbl_fecha_inbox);
			holder.lblNombre = (TextView) convertView
					.findViewById(R.id.lbl_nombre_inbox);
			holder.lblDesc = (TextView) convertView
					.findViewById(R.id.lbl_desc_inbox);
			LetraUtils.setBoldHelveticaNeue(holder.lblNombre);
			LetraUtils.setRegularHelveticaNeue(holder.lblDesc, holder.lblFecha);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		Message<T> m = getItem(position);
		holder.btnEliminar.setTag(m);
		holder.lblDesc.setText(m.getMensaje());
		holder.lblFecha.setText(Utils.getDate(m.getFecha()));
		holder.lblNombre.setText(m.getT().getNombre());
		if (m.isLeido()) {
			holder.lblDesc.setTextColor(getContext().getResources().getColor(
					R.color.plomo_obscuro));
			holder.lblNombre.setTextColor(getContext().getResources().getColor(
					R.color.plomo_obscuro));
			convertView.setBackgroundColor(getContext().getResources()
					.getColor(R.color.plomo_claro));
		} else {
			holder.lblDesc.setTextColor(getContext().getResources().getColor(
					android.R.color.black));
			holder.lblNombre.setTextColor(getContext().getResources().getColor(
					android.R.color.black));
			convertView.setBackgroundColor(getContext().getResources()
					.getColor(android.R.color.white));
		}
		return convertView;
	}

	@Override
	public void onClick(View v) {
		if (listener != null) {
			listener.OnInfoButtonClick(v, v.getTag());
		}
	}
}
