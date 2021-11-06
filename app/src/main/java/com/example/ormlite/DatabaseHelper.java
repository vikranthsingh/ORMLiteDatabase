package com.example.ormlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
    private static final String DATABASE_NAME = "notes.db";
    private static final int DATABASE_Version = 1;

    private Dao<Notes, Integer> noteDao = null;
    private RuntimeExceptionDao<Notes, Integer> noteRuntimeExceptionDao = null;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_Version, R.raw.ormlite_config);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Notes.class);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, Notes.class, true);
            onCreate(database, connectionSource);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Dao<Notes, Integer> getNoteDao() throws SQLException {
        if (noteDao == null) {
            noteDao = getDao(Notes.class);
        }
        return noteDao;
    }

    public RuntimeExceptionDao<Notes, Integer> getNoteRuntimeExceptionDao() {
        if (noteRuntimeExceptionDao == null) {
            noteRuntimeExceptionDao = getRuntimeExceptionDao(Notes.class);
        }
        return noteRuntimeExceptionDao;
    }
}
