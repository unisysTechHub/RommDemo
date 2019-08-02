package com.example.rommdemo.viewModels;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;


import com.example.rommdemo.roomdatabase.EmpDatabase;
import com.example.rommdemo.roomdatabase.EmpDatabaseDao;
import com.example.rommdemo.roomdatabase.Employee;
import com.example.rommdemo.tuples.EmpTuple;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.Flowable;

public class MainViewModel extends AndroidViewModel {
    Context context;
    EmpDatabase empDatabase;
    public LiveData<List<EmpTuple>> empListObservable;
    public MainViewModel( Application application) {
        super(application);
        this.context=application;
        empDatabase=EmpDatabase.getInstance(application);
        empListObservable=empDatabase.empDatabaseDao().getAllEmployees();

    }
//    void getAllEmployess()
//    {
//        new getAllEmployessAsync(empDatabase.empDatabaseDao()).execute();
//    }


   public void AddEmployee(EmpTuple empTuple)
    {
        Employee employee = new Employee();
        employee.setEmpNo(empTuple.getEmpNo());
        employee.setEmpName(empTuple.getEmpName());
        new insertAsync(empDatabase.empDatabaseDao()).execute(employee);


    }

    class insertAsync extends  AsyncTask<Employee,Void,Void> {
        EmpDatabaseDao empDatabaseDao;

        insertAsync(EmpDatabaseDao empDatabaseDao) {
            this.empDatabaseDao = empDatabaseDao;
        }

        @Override
        protected Void doInBackground(Employee... employees) {
            empDatabaseDao.addNewEmployee(employees[0]);


            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {

            //getAllEmployess();
        }
    }

//    class getAllEmployessAsync extends  AsyncTask<Void,Void,Flowable<List<EmpTuple>>>
//    {
//        EmpDatabaseDao empDatabaseDao;
//        getAllEmployessAsync(EmpDatabaseDao empDatabaseDao)
//        {
//
//            this.empDatabaseDao=empDatabaseDao;
//
//        }
//        @Override
//        protected Flowable<List<EmpTuple>> doInBackground(Void... voids) {
//
//            return  empDatabaseDao.getAllEmployees();
//
//        }
//
//        @Override
//        protected void onPostExecute(Flowable<List<EmpTuple>> employees) {
//            //System.out.println("@Ramesh" + "no of employees : " + employees.size() );
//            empListObservable=employees;
////            for (EmpTuple employee : employees
////                 ) {
////
////                System.out.println("@Ramesh :" + employee.getEmpNo() + "name :" + employee.getEmpName());
////            }
//
//        }
//    }


}
