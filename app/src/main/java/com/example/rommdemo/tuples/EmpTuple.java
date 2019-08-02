package com.example.rommdemo.tuples;

import androidx.room.ColumnInfo;

public class EmpTuple {

    @ColumnInfo(name = "EMP_NUM")
    int empNo;
    @ColumnInfo(name="EMP_NAME")
    String empName;
    public EmpTuple(int empNo, String empName)
    {
        this.empNo=empNo;
        this.empName=empName;
    }

    public int getEmpNo() {
        return empNo;
    }

    public String getEmpName() {
        return empName;
    }
}
