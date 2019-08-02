package com.example.rommdemo.roomdatabase;

import android.content.Context;

import androidx.annotation.NonNull;

import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

@Database(entities = Employee.class,version = 1,exportSchema = false)
public abstract class EmpDatabase extends RoomDatabase {

    public static EmpDatabase empDatabase;
    public abstract EmpDatabaseDao empDatabaseDao();
     public static EmpDatabase getInstance(Context context) {

         if(empDatabase == null)
         {
             empDatabase = Room.databaseBuilder(context.getApplicationContext(),EmpDatabase.class,"EMP_DATABASE").build();


         }
        return empDatabase;
    }

}
