package com.example.ormlite;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;
//@DatabaseTable(tableName = "myTable")
public class Notes {
    @DatabaseField(generatedId = true)
    int id;
    @DatabaseField
    String subject;
    @DatabaseField
    String text;
    @DatabaseField
    Date date;

    public Notes() {
    }

    public Notes(int id, String subject, String text, Date date) {
        this.id = id;
        this.subject = subject;
        this.text = text;
        this.date = date;
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
