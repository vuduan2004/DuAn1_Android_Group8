package duanvdph37524.fpoly.techstore_and_group8.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "TechStore", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableDienThoai = "CREATE TABLE DienThoai(maDT INTEGER PRIMARY KEY AUTOINCREMENT" +
                ", tenDienThoai STRING NOT NULL," +
                "hinhAnh STRING NOT NULL," +
                "giaTien INTEGER NOT NULL)";
        db.execSQL(createTableDienThoai);
        db.execSQL("insert into DienThoai values(1,'Realme 11 Pro 5G 8GB-256GB'," +
                "'https://cdn-amz.woka.io/images/I/71l0zudEC9L.SS400.jpg'" +
                ",11990000)," +
                "(2,'iPhone 15 Pro Max 256GB','https://firebasestorage.googleapis.com/v0/b/teststore-1660c.appspot.com/o/imageDienThoai%2Fdtiphone.png?alt=media&token=1eea6465-c85a-4f7a-b40b-33d70611eb8a',34990000)" +
                ",(3,'Samsung Galaaxy S20  FR 256GB','https://firebasestorage.googleapis.com/v0/b/teststore-1660c.appspot.com/o/imageDienThoai%2Fdtsamsung.png?alt=media&token=224b2707-eff3-4901-908a-424be2b9ca50',1449000)" +
                ",(4,'OPPO Find N3 Flip 5G 12GB-256GB','https://firebasestorage.googleapis.com/v0/b/teststore-1660c.appspot.com/o/imageDienThoai%2Fdtoppo.jpg?alt=media&token=00ee1a3c-2bd2-47ce-b2cb-ef5c07a07568',11990000)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion != newVersion){
            db.execSQL("drop table if exists DienThoai");
            onCreate(db);
        }
    }
}
