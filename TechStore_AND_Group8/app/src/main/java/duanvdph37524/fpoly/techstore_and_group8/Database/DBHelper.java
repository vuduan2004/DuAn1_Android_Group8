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
        String dNguoiDung = "INSERT INTO NGUOIDUNG VALUES('vudinhduan', 'Vũ Đình Duẩn', '2004', '0988539548', 'Vân Canh Hà Nội', 'duan1')";
        sqLiteDatabase.execSQL(dNguoiDung);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        if (i !=i1){
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS NGUOIDUNG");
        }
    }
}
