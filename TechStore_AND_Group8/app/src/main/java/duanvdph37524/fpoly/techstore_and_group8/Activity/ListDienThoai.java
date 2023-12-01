package duanvdph37524.fpoly.techstore_and_group8.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import duanvdph37524.fpoly.techstore_and_group8.Adapter.AdapterDienThoai;
import duanvdph37524.fpoly.techstore_and_group8.DAO.DienThoaiDAO;
import duanvdph37524.fpoly.techstore_and_group8.Model.DienThoai;
import duanvdph37524.fpoly.techstore_and_group8.R;

public class ListDienThoai extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView rcvDienThoai;
    TextView tvAll, tvHot, tvSapXep;
    AdapterDienThoai adapterDienThoai;
    DienThoaiDAO dienThoaiDAO;
    ArrayList<DienThoai> list = new ArrayList<>();
    ArrayList<DienThoai> newlist = new ArrayList<>();
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_dien_thoai);
        toolbar = findViewById(R.id.toolbarA);
        rcvDienThoai = findViewById(R.id.rcv_listDienThoai);
        tvSapXep = findViewById(R.id.tv_sapxep);

        dienThoaiDAO = new DienThoaiDAO(context);
        list = dienThoaiDAO.getALL();
        adapterDienThoai = new AdapterDienThoai(context, list);

        newlist = dienThoaiDAO.getALL();

        toolbar.setTitle("Danh sách điện thoại");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        rcvDienThoai.setAdapter(adapterDienThoai);
        rcvDienThoai.setLayoutManager(new GridLayoutManager(context, 2));


        tvSapXep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(context, v);
                MenuInflater inflater = popupMenu.getMenuInflater();
                inflater.inflate(R.menu.popup_menu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        int id = item.getItemId();
                        if (id == R.id.it_lonNhat) {
                            Collections.sort(list, new Comparator<DienThoai>() {
                                @Override
                                public int compare(DienThoai o1, DienThoai o2) {
                                    return (int) (o2.getGiaTien() - o1.getGiaTien());
                                }
                            });
                        }else if(id == R.id.it_nhoNhat){
                            Collections.sort(list, new Comparator<DienThoai>() {
                                @Override
                                public int compare(DienThoai o1, DienThoai o2) {
                                    return (int) (o1.getGiaTien() - o2.getGiaTien());
                                }
                            });
                        }
                        adapterDienThoai.notifyDataSetChanged();
                        return false;
                    }
                });
                popupMenu.show();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_item, menu);
        MenuItem item = menu.findItem(R.id.it_Search);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                list.clear();
                String timKiem = xoaDau(query).toLowerCase();
                for (DienThoai dienThoai : newlist) {
                    String ten = xoaDau(dienThoai.getTenDienThoai().toLowerCase());
                    if (ten.equals(timKiem)) {
                        list.add(dienThoai);
                    }
                    adapterDienThoai.notifyDataSetChanged();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                list.clear();
                String timKiem = xoaDau(newText).toLowerCase();
                for (DienThoai dienThoai : newlist) {
                    String ten = xoaDau(dienThoai.getTenDienThoai()).toLowerCase();
                    if (ten.contains(timKiem)) {
                        list.add(dienThoai);
                    }

                }
                adapterDienThoai.notifyDataSetChanged();
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
    private String xoaDau(String text) {
        return Normalizer.normalize(text, Normalizer.Form.NFD).replaceAll("\\p{M}", "");
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}