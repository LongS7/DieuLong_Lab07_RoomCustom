package com.longs7.android_lab07_lt_02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.room.Room;

import com.longs7.android_lab07_lt_02.dao.PlaceDao;
import com.longs7.android_lab07_lt_02.entity.Place;

import java.util.List;

public class CustomTravelAdapter extends BaseAdapter {
    private final PlaceDao placeDao;
    private final Context context;
    private final int layoutRes;
    private final List<Place> places;

    public CustomTravelAdapter(Context context, int layoutRes) {
        this.context = context;
        this.layoutRes = layoutRes;

        MyDatabase db = Room.databaseBuilder(context, MyDatabase.class, "travel-database")
                .allowMainThreadQueries()
                .build();

        placeDao = db.placeDao();

        this.places = placeDao.getAllPlace();
    }

    public void add(Place place){
        placeDao.insert(place);
        places.add(placeDao.getLastPlace());
        notifyDataSetChanged();
    }

    public void remove(Place place){
        placeDao.delete(place);
        places.remove(place);
        notifyDataSetChanged();
    }

    public void update(Place place){
        placeDao.update(place);
        places.set(places.indexOf(place), place);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return places.size();
    }

    @Override
    public Object getItem(int position) {
        return places.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(layoutRes, parent, false);

        TextView tvName = convertView.findViewById(R.id.tvName);
        tvName.setText(places.get(position).getId() + ". " + places.get(position).getName());

        convertView.findViewById(R.id.ivDelete).setOnClickListener(v -> {
            remove(places.get(position));
        });

        convertView.findViewById(R.id.ivModify).setOnClickListener(v -> {
            update(places.get(position));
        });

        return convertView;
    }
}
