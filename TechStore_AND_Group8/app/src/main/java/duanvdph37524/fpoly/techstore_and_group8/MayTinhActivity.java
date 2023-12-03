package duanvdph37524.fpoly.techstore_and_group8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
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

import duanvdph37524.fpoly.techstore_and_group8.Adapter.MayTinhAdapter;
import duanvdph37524.fpoly.techstore_and_group8.dao.MayTinhDAO;
import duanvdph37524.fpoly.techstore_and_group8.model.MayTinhDTO;

public class MayTinhActivity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView rcvMayTinh;
    TextView tvAll, tvHot, tvSapXep;
    MayTinhDAO mayTinhDAO;
    Context context = this;
    ArrayList<MayTinhDTO> list = new ArrayList<>();
    ArrayList<MayTinhDTO> newlist = new ArrayList<>();
    MayTinhAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_may_tinh);
        toolbar = findViewById(R.id.toolbar);
        rcvMayTinh = findViewById(R.id.rcv_MayTinh);
        tvAll = findViewById(R.id.tv_All);
        tvHot = findViewById(R.id.tv_hot);
        tvSapXep = findViewById(R.id.tv_sapxep);
        mayTinhDAO = new MayTinhDAO(context);
        list = mayTinhDAO.getDSMayTinh();
        adapter = new MayTinhAdapter(context, list);
        newlist = mayTinhDAO.getDSMayTinh();
        toolbar.setTitle("Danh sách máy tính");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        rcvMayTinh.setAdapter(adapter);
        rcvMayTinh.setLayoutManager(new GridLayoutManager(context, 2));
        tvSapXep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(context, view);
                MenuInflater inflater = popupMenu.getMenuInflater();
                inflater.inflate(R.menu.menu_pop, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        if (menuItem.getItemId() == R.id.it_nhoNhat){
                            Collections.sort(list, new Comparator<MayTinhDTO>() {
                                @Override
                                public int compare(MayTinhDTO mayTinhDTO, MayTinhDTO t1) {
                                    return mayTinhDTO.getGiatien() - t1.getGiatien();
                                }
                            });
                        } else if (menuItem.getItemId() == R.id.it_lonNhat) {
                            Collections.sort(list, new Comparator<MayTinhDTO>() {
                                @Override
                                public int compare(MayTinhDTO mayTinhDTO, MayTinhDTO t1) {
                                    return t1.getGiatien() - mayTinhDTO.getGiatien();
                                }
                            });
                        }
                        adapter.notifyDataSetChanged();
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
        MenuItem item = menu.findItem(R.id.it_search);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                list.clear();
                String timKiem = xoaDau(query).toLowerCase();
                for (MayTinhDTO mayTinh : newlist) {
                    String ten = xoaDau(mayTinh.getTenmt().toLowerCase());
                    if (ten.equals(timKiem)) {
                        list.add(mayTinh);
                    }
                    adapter.notifyDataSetChanged();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                list.clear();
                String timKiem = xoaDau(newText).toLowerCase();
                for (MayTinhDTO mayTinh : newlist) {
                    String ten = xoaDau(mayTinh.getTenmt().toLowerCase());
                    if (ten.contains(timKiem)) {
                        list.add(mayTinh);
                    }
                }
                adapter.notifyDataSetChanged();
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }


    private String xoaDau(String text) {
        return Normalizer.normalize(text, Normalizer.Form.NFD).replaceAll("\\p{M}", "");
    }
}