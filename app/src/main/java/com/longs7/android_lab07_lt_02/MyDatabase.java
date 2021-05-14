package com.longs7.android_lab07_lt_02;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.longs7.android_lab07_lt_02.dao.PlaceDao;
import com.longs7.android_lab07_lt_02.entity.Place;

@Database(entities = {Place.class}, version = 1)
public abstract class MyDatabase extends RoomDatabase {
    public abstract PlaceDao placeDao();

    @NonNull
    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @NonNull
    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

    @Override
    public void clearAllTables() {

    }
}
