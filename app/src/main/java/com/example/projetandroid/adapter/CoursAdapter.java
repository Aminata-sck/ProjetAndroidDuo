package com.example.projetandroid.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetandroid.R;
import com.example.projetandroid.data.entity.Cours;

import java.util.ArrayList;
import java.util.List;

public class CoursAdapter extends RecyclerView.Adapter<CoursAdapter.CoursViewHolder> {

    private List<Cours> coursList = new ArrayList<>();


    // Gestion clic long

    private OnItemLongClickListener listener;

    public interface OnItemLongClickListener {

        void onDelete(Cours cours);

    }

    public void setOnItemLongClickListener(
            OnItemLongClickListener listener) {

        this.listener = listener;
    }


    @NonNull
    @Override
    public CoursViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent,
            int viewType) {

        View view =
                LayoutInflater.from(parent.getContext())
                        .inflate(
                                R.layout.item_cours,
                                parent,
                                false
                        );

        return new CoursViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull CoursViewHolder holder,
            int position) {

        Cours cours = coursList.get(position);

        holder.txtDate.setText(
                cours.getDateCours());

        holder.txtHeure.setText(
                cours.getHeureDebut());

        holder.txtDuree.setText(
                cours.getDuree() + " h");

        holder.txtContenu.setText(
                cours.getContenu());


        // Suppression par clic long

        holder.itemView.setOnLongClickListener(v -> {

            if (listener != null) {

                listener.onDelete(cours);

            }

            return true;
        });

    }

    @Override
    public int getItemCount() {

        return coursList.size();
    }

    public void setCoursList(
            List<Cours> coursList) {

        this.coursList = coursList;

        notifyDataSetChanged();
    }


    static class CoursViewHolder
            extends RecyclerView.ViewHolder {

        TextView txtDate,
                txtHeure,
                txtDuree,
                txtContenu;

        public CoursViewHolder(
                @NonNull View itemView) {

            super(itemView);

            txtDate =
                    itemView.findViewById(
                            R.id.txtDate);

            txtHeure =
                    itemView.findViewById(
                            R.id.txtHeure);

            txtDuree =
                    itemView.findViewById(
                            R.id.txtDuree);

            txtContenu =
                    itemView.findViewById(
                            R.id.txtContenu);
        }
    }
}