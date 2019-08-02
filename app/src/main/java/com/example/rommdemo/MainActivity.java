package com.example.rommdemo;


import android.os.Bundle;
import android.widget.Button;


import com.example.rommdemo.tuples.EmpTuple;
import com.example.rommdemo.viewModels.MainViewModel;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;


public class MainActivity extends AppCompatActivity {
    MainViewModel mainViewModel;
    Button addEmployee;
    int initialEMpNo=1003;
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        addEmployee=findViewById(R.id.addEmployee);
        addEmployee.setOnClickListener( view -> {
               // i=i+1;
            EmpTuple empTuple = new EmpTuple(initialEMpNo+i, "Ramesh1001");
            mainViewModel.AddEmployee(empTuple)
            ;
        });

//        mainViewModel.empListObservable.subscribe(new Subscriber<List<EmpTuple>>() {
//            @Override
//            public void onSubscribe(Subscription s) {
//
//            }
//
//            @Override
//            public void onNext(List<EmpTuple> empTuples) {
//                System.out.println("@Ramesh" + "no of employees :" +empTuples.size());
//
//            }
//
//            @Override
//            public void onError(Throwable t) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        });
        mainViewModel.empListObservable.observe(this, new Observer<List<EmpTuple>>() {
            @Override
            public void onChanged(List<EmpTuple> employees) {
                        initialEMpNo=employees.get(employees.size()-1).getEmpNo();
                            for (EmpTuple employee : employees
                 ) {

                System.out.println("@Ramesh :" + employee.getEmpNo() + "name :" + employee.getEmpName());
            }

            }
        });


    }
}