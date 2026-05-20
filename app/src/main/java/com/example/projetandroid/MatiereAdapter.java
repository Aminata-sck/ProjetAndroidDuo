package com.example.projetandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.projetandroid.data.entity.Matiere;

import java.util.List;

public class MatiereAdapter extends BaseAdapter {

    Context context;
    List<Matiere> list;

    public MatiereAdapter(Context context, List<Matiere> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {

        if (view == null) {
            view = LayoutInflater.from(context)
                    .inflate(android.R.layout.simple_list_item_2, parent, false);
        }

        TextView t1 = view.findViewById(android.R.id.text1);
        TextView t2 = view.findViewById(android.R.id.text2);

        Matiere m = list.get(i);

        t1.setText(m.getNom() + " - " + m.getUe());
        t2.setText("Prof: " + m.getProfesseur() +
                " | Volume: " + m.getVolumeHoraire());

        return view;
    }

    public void updateList(List<Matiere> newList) {
        this.list = newList;
        notifyDataSetChanged();
    }
}