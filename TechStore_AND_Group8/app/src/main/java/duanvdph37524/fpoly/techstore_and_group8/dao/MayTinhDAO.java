package duanvdph37524.fpoly.techstore_and_group8.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import duanvdph37524.fpoly.techstore_and_group8.Database.DBHelper;
import duanvdph37524.fpoly.techstore_and_group8.model.MayTinhDTO;

public class MayTinhDAO {
    private DBHelper dbHelper;
    public MayTinhDAO(Context context){
        dbHelper = new DBHelper(context);

    }
    public ArrayList<MayTinhDTO> getDSMayTinh(){
        ArrayList<MayTinhDTO> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM MAYTINH", null);
        if (cursor.getCount()!=0){
            cursor.moveToFirst();
            do {
                list.add(new MayTinhDTO(cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getInt(3)));
            } while (cursor.moveToNext());
        }
        return list;
    }
}
