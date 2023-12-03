package duanvdph37524.fpoly.techstore_and_group8.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context){
        super(context, "TechStore", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String qNguoiDung = "CREATE TABLE NGUOIDUNG(tendangnhap text primary key, hoten text, namsinh text, sodienthoai text, diachi text, matkhau text)";
        sqLiteDatabase.execSQL(qNguoiDung);
        String dNguoiDung = "INSERT INTO NGUOIDUNG VALUES('vudinhduan', 'Vũ Đình Duẩn', '2004', '0988539548', 'Vân Canh Hà Nội', 'duan123')";
        sqLiteDatabase.execSQL(dNguoiDung);
        String qMayTinh = "CREATE TABLE MAYTINH(mamt INTEGER PRIMARY KEY AUTOINCREMENT, tenmaytinh text, hinhanh text, giatien integer)";
        sqLiteDatabase.execSQL(qMayTinh);
        String dMayTinh = "INSERT INTO MAYTINH VALUES(1, 'MacBook Pro 14 inch M1 Pro 2021', 'https://firebasestorage.googleapis.com/v0/b/teststore-1660c.appspot.com/o/imageDienThoai%2Fmacbook.jpg?alt=media&token=16490d01-a09c-4c61-9c6d-1b62bb5096cf', 12490000 ), " +
                "(2, 'Lenovo ideapad3 14LTL6 Core i5', 'https://firebasestorage.googleapis.com/v0/b/teststore-1660c.appspot.com/o/imageMayTinh%2Flt1%201.png?alt=media&token=cfa2d9a2-6010-42e5-b825-23e0ac127a90', 2000000)," +
                " (3, 'Dell Vostro 5510 corei5 1TG', 'https://firebasestorage.googleapis.com/v0/b/teststore-1660c.appspot.com/o/imageMayTinh%2Flt2%203.png?alt=media&token=ace1bbc4-7bae-4cb9-a47a-1afc9422dae1', 1230000)";
        sqLiteDatabase.execSQL(dMayTinh);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        if (i !=i1){
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS NGUOIDUNG");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS MAYTINH");
        }
    }
}
