package com.example.touchit;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    Context context;
    ArrayList<Model> model;

    public UserAdapter(Context context, ArrayList<Model> model) {
        this.context = context;
        this.model = model;
    }

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.unit, parent, false);
        return new ViewHolder(v);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Model Omodel = model.get(position);
        holder.tv1.setText(Omodel.getTv1());


        String imgUrl = Omodel.getImg1();
        Picasso.with(context).load(imgUrl).fit().centerInside().into(holder.getCtv1());


try {
    holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            buttonView.setChecked(isChecked);
        }
    });
}catch (NullPointerException error){}
    }
    @Override
    public int getItemCount() {
        return model.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView ctv1;
        TextView tv1;
        CheckBox checkBox;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ctv1 = (itemView.findViewById(R.id.imageview));
            tv1 = itemView.findViewById(R.id.textview);
            checkBox = itemView.findViewById(R.id.checkbox);
        }
        public CheckBox getCheckBox() {

            return checkBox;
        }

        public void setCheckBox(CheckBox checkBox) {
            this.checkBox = checkBox;
        }

        public ImageView getCtv1() {
            return ctv1;
        }

        public void setCtv1(ImageView ctv1) {
            this.ctv1 = ctv1;
        }
    }
}
