package com.matictechnology.shrijagdishmandir.Utility;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.matictechnology.shrijagdishmandir.classes.Notifications;

import java.util.ArrayList;

/**
 * Created by maticd1 on 14/3/16.
 */
public class DbHelper extends SQLiteOpenHelper
{
    private SQLiteDatabase db;

    public DbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, name, factory, version);
    }

    public DbHelper(Context context)
    {
        super(context, "ShriJagdishMadir", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String user_query="create table User(id integer primary key autoincrement," +
                " name text, " +
                "email text, " +
                "blood text, " +
                "village text, " +
                "tehsil text, " +
                "district text, " +
                "gotra text, " +
                "mobile integer) ";

        String notification_query="create table Notifications(id integer primary key," +
                " head text, " +
                "body text, " +
                "date text);";

        try
        {

            db.execSQL(notification_query);
            db.execSQL(user_query);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }

    public long insertNotifications(SQLiteDatabase db,String id, String head, String body,String date)
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put("id", id);
        initialValues.put("head", head);
        initialValues.put("body", body);
        initialValues.put("date", date);
        return db.insert("Notifications", null, initialValues);
    }

    public long insertUser(SQLiteDatabase db,String name, String email, String pass, String blood,String village, String tehsil, String district, String gotra, String mobile)
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put("name", name);
        initialValues.put("email", email);
        initialValues.put("blood", blood);
        initialValues.put("village", village);
        initialValues.put("tehsil", tehsil);
        initialValues.put("district", district);
        initialValues.put("gotra", gotra);
        initialValues.put("mobile", mobile);
        return db.insert("User", null, initialValues);
    }

    public boolean checkNotification(SQLiteDatabase db,String id)
    {
        String select_Query="select * from Notifications where id='"+id+"'";
        try
        {
            Cursor c=db.rawQuery(select_Query,null);
            c.moveToFirst();
            if (c.getCount()>0)
            {
                return true;
            }
            else
                return false;
        }
        catch(SQLiteException e)
        {
            e.printStackTrace();
            return false;
        }

    }

    public ArrayList<Notifications> getNotification(SQLiteDatabase db, String date)
    {
        ArrayList<Notifications> temp = null;
        String select_Query="select * from Notifications where date='"+date+"'";
        Cursor c=db.rawQuery(select_Query,null);
        c.moveToFirst();
        if (c.getCount()>0)
        {
            temp=new ArrayList<>();
            Notifications n;//=new Notifications();
            for(int count=0;count<c.getCount();count++)
            {
                n=new Notifications();
                n.setId(c.getString(0));
                n.setHead(c.getString(1));
                n.setBody(c.getString(2));
                n.setDate(c.getString(3));
                c.moveToNext();
                temp.add(n);
            }
            return temp;
        }
        else
            return null;

    }
    public ArrayList<Notifications> getAllNotification(SQLiteDatabase db)
    {
        ArrayList<Notifications> temp = null;
        String select_Query="select * from Notifications";
        Cursor c=db.rawQuery(select_Query,null);
        c.moveToFirst();
        if (c.getCount()>0)
        {
            temp=new ArrayList<>();
            Notifications n;//=new Notifications();
            for(int count=0;count<c.getCount();count++)
            {
                n=new Notifications();
                n.setId(c.getString(0));
                n.setHead(c.getString(1));
                n.setBody(c.getString(2));
                n.setDate(c.getString(3));
                c.moveToNext();
                temp.add(n);
            }
            return temp;
        }
        else
            return null;

    }

    public boolean checkLogin(SQLiteDatabase db,String email)
    {

        String select_Query="select * from User where email='"+email+"'";
        Cursor c=db.rawQuery(select_Query,null);
        if (c.getCount()>0)
        {
            return false;
        }
        else
            return true;
    }

    public ArrayList<String> selectAll(SQLiteDatabase db)
    {
        String select_Query="select * from User";
        Cursor c=db.rawQuery(select_Query,null);
        String res="";
        c.moveToFirst();
        String name,email,blood,village,tehsil,district,gotra,mobile;
        name=c.getString(1);
        email=c.getString(2);
        blood=c.getString(3);
        village=c.getString(4);
        tehsil=c.getString(5);
        district=c.getString(6);
        gotra=c.getString(7);
        mobile=c.getString(8);

        ArrayList<String> user_data=new ArrayList<>();
        user_data.add(name);
        user_data.add(email);
        user_data.add(blood);
        user_data.add(village);
        user_data.add(tehsil);
        user_data.add(district);
        user_data.add(gotra);
        user_data.add(mobile);
        return user_data;
    }

    public boolean Login(SQLiteDatabase db)
    {
        String select_Query="select * from User";
        Cursor c=db.rawQuery(select_Query,null);
        String res="";
        c.moveToFirst();
        if(c.getCount()==1)
        {
            return true;
        }
        else
            return false;
    }

}
