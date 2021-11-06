package com.example.ormlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = OpenHelperManager.getHelper(this, DatabaseHelper.class);
        RuntimeExceptionDao<Notes, Integer> runtimeExceptionDao = dbHelper.getNoteRuntimeExceptionDao();
        runtimeExceptionDao.createOrUpdate(new Notes("Note 1", "Note 1 Text"));
        runtimeExceptionDao.createOrUpdate(new Notes("Note 2", "Note 2 Text"));

        List<Notes> notes = runtimeExceptionDao.queryForAll();
        Log.d("demo", notes.toString());

        List<Notes> note1 = runtimeExceptionDao.queryForEq("id", 1);
        Log.d("demo1", note1.toString());

        OpenHelperManager.releaseHelper();
    }
}