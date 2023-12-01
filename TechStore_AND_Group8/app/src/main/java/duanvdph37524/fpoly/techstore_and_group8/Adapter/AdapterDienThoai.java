package duanvdph37524.fpoly.techstore_and_group8.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import duanvdph37524.fpoly.techstore_and_group8.DAO.DienThoaiDAO;
import duanvdph37524.fpoly.techstore_and_group8.Model.DienThoai;
import duanvdph37524.fpoly.techstore_and_group8.R;

public class AdapterDienThoai extends RecyclerView.Adapter<AdapterDienThoai.viewHolep> {

    Context context;
    ArrayList<DienThoai> list;
    DienThoaiDAO dienThoaiDAO;

    public AdapterDienThoai(Context context, ArrayList<DienThoai> list) {
        this.context = context;
        this.list = list;
        dienThoaiDAO = new DienThoaiDAO(context);
    }

    @NonNull
    @Override
    public viewHolep onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list_dienthoai, null);
        return new viewHolep(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolep holder, int position) {
        DienThoai dienThoai = list.get(position);
        Picasso.get().load(dienThoai.getHinhAnh()).into(holder.imgAnh);
        holder.tvTen.setText(dienThoai.getTenDienThoai());
        holder.tvGia.setText(String.valueOf(dienThoai.getGiaTien()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class viewHolep extends RecyclerView.ViewHolder {
        ImageView imgAnh;
        TextView tvTen, tvGia, tvGiaKM;

        public viewHolep(@NonNull View itemView) {
            super(itemView);
            imgAnh = itemView.findViewById(R.id.img_sanpham);
            tvTen = itemView.findViewById(R.id.tv_tensanpham);
            tvGia = itemView.findViewById(R.id.tv_giaTien);
//            tvGiaKM = itemView.findViewById(R.id.tv_giaTienKM);
//            tvGia.setPaintFlags(tvGia.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }
    }
}
