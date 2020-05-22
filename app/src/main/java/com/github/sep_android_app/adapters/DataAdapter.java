package com.github.sep_android_app.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.sep_android_app.R;
import com.github.sep_android_app.data.model.RoomData;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private List<RoomData> RoomData;
    public DataAdapter(List<RoomData> RoomData) {
        this.RoomData = RoomData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_data_entry, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapter.ViewHolder holder, int position) {
        holder.date.setText(RoomData.get(position).getDate());
        holder.value.setText(RoomData.get(position).getValue());
    }

    @Override
    public int getItemCount() {
        return RoomData.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        TextView date;
        TextView value;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.tv_item_data_date);
            value = itemView.findViewById(R.id.tv_item_data_value);
        }
    }
}
