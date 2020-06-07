package com.github.sep_android_app.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.sep_android_app.R;
import com.github.sep_android_app.data.model.Alert;

import java.util.List;

public class AlertAdapter extends RecyclerView.Adapter<AlertAdapter.ViewHolder> {

    private List<Alert> alerts;

    public AlertAdapter(List<Alert> alerts) {
        this.alerts = alerts;
    }

    //Sets up a viewholder which inflates the item template
    @NonNull
    @Override
    public AlertAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_alert, parent, false);
        Log.d("credit", "ViewHolder: " + R.string.r_credit);
        return new ViewHolder(view);
    }

    //Binding data passed into the adapter to each instance of the items
    @Override
    public void onBindViewHolder(@NonNull AlertAdapter.ViewHolder holder, int position) {
        holder.alert.setText(alerts.get(position).getAlert());
        holder.room.setText(alerts.get(position).getRoom());

    }

    public int getItemCount() {
        return alerts.size();
    }

    //Gets the id of the fields in the viewholder item to later be filled via the onBindViewholder
    class ViewHolder extends RecyclerView.ViewHolder {

        TextView alert;
        TextView room;

        ViewHolder(View itemView) {
            super(itemView);
            alert = itemView.findViewById(R.id.tv_alert);
            room = itemView.findViewById(R.id.tv_alert_room);
        }

    }
}
