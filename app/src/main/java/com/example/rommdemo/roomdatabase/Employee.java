package com.example.rommdemo.roomdatabase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "EMPLOYEE")
public class Employee {


    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name="EMP_NUM")
    int  empNo;

    @ColumnInfo(name="EMP_NAME")
    String empName;

    public int getEmpNo() {
        return empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }
}
