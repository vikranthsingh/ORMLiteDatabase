package com.example.ormlite;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;
//@DatabaseTable(tableName = "myTable")     //In case you want to change table name.
public class Notes {                        //this will create table called "Note".
    @DatabaseField(generatedId = true)
    int id;                                 //column name
    @DatabaseField
    String subject;                         //column name
    @DatabaseField
    String text;                            //column name
    @DatabaseField
    Date date;                              //column name

    public Notes() {
    }

    public Notes(String subject, String text) {
        this.subject = subject;
        this.text = text;
        this.date = new Date(System.currentTimeMillis());
    }

    @Override
    public String toString() {
        return "Notes{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", text='" + text + '\'' +
                ", date=" + date +
                '}';
    }
}
