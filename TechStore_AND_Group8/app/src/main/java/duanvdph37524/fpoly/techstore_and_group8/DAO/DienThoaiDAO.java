package duanvdph37524.fpoly.techstore_and_group8.DAO;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import duanvdph37524.fpoly.techstore_and_group8.Database.DBHelper;
import duanvdph37524.fpoly.techstore_and_group8.Model.DienThoai;

public class DienThoaiDAO {
    private SQLiteDatabase database;

    public DienThoaiDAO(Context context) {
        DBHelper dbHelper = new DBHelper(context);
        database = dbHelper.getReadableDatabase();
    }


    public ArrayList<DienThoai> getALL() {
        String sql = "SELECT * FROM DienThoai ";
        return getData(sql);
    }

    public DienThoai getID(String id) {
        String sql = "SELECT * FROM DienThoai WHERE maDT =?";
        ArrayList<DienThoai> list = getData(sql, id);
        return list.get(0);
    }

    @SuppressLint("Range")
    public ArrayList<DienThoai> getData(String sql, String... selectionArgs) {
        ArrayList<DienThoai> list = new ArrayList<>();
        Cursor cursor = database.rawQuery(sql, selectionArgs);
        while (cursor.moveToNext()) {
            DienThoai dienThoai = new DienThoai();
            dienThoai.setMaDT(Integer.parseInt(cursor.getString(cursor.getColumnIndex("maDT"))));
            dienThoai.setTenDienThoai(cursor.getString(cursor.getColumnIndex("tenDienThoai")));
            dienThoai.setHinhAnh(cursor.getString(cursor.getColumnIndex("hinhAnh")));
            dienThoai.setGiaTien(Integer.parseInt(cursor.getString(cursor.getColumnIndex("giaTien"))));
            list.add(dienThoai);
        }
        return list;
    }
}
