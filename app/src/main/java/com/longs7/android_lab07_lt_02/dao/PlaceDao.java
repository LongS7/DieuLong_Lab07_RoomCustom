package com.longs7.android_lab07_lt_02.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.longs7.android_lab07_lt_02.entity.Place;

import java.util.List;

@Dao
public interface PlaceDao {
    @Query("select * from Place")
    List<Place> getAllPlace();

    @Query("select * from Place where id = :id")
    Place getPlaceById(int id);

    @Query("select * from Place order by id desc")
    Place getLastPlace();

    @Insert
    void insert(Place ...places);
}
