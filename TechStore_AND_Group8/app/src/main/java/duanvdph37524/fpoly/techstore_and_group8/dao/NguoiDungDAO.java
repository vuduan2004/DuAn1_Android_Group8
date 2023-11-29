package duanvdph37524.fpoly.techstore_and_group8.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import duanvdph37524.fpoly.techstore_and_group8.Database.DBHelper;


public class NguoiDungDAO {
    private DBHelper dbHelper;
    public NguoiDungDAO(Context context){
        dbHelper = new DBHelper(context);
    }
    public boolean checkLogin(String username, String password){
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM NGUOIDUNG WHERE tendangnhap =? AND matkhau = ?", new String[]{username, password});
        if(cursor.getCount()>0){
            return true;
        }
        return false;
    }
    public boolean Register(String user, String hoten, String namsinh, String sdt, String diachi, String matkhau){
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("tendangnhap", user);
        contentValues.put("hoten", hoten);
        contentValues.put("namsinh", namsinh);
        contentValues.put("sodienthoai", sdt);
        contentValues.put("diachi", diachi);
        contentValues.put("matkhau", matkhau);
        long check = sqLiteDatabase.insert("NGUOIDUNG",null, contentValues);
        if (check!=-1){
            return true;
        }
        return false;
    }
}
