package com.example.rommdemo.roomdatabase;


import com.example.rommdemo.tuples.EmpTuple;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import io.reactivex.Flowable;

@Dao
public abstract class EmpDatabaseDao {
    @Query( "SELECT * FROM employee "
                )
    abstract public LiveData<List<EmpTuple>> getAllEmployees();
    @Insert
    abstract public void addNewEmployee(Employee employee);


}
