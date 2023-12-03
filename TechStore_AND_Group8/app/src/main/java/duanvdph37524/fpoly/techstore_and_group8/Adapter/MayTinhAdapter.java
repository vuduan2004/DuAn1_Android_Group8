package duanvdph37524.fpoly.techstore_and_group8.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import duanvdph37524.fpoly.techstore_and_group8.R;
import duanvdph37524.fpoly.techstore_and_group8.dao.MayTinhDAO;
import duanvdph37524.fpoly.techstore_and_group8.model.MayTinhDTO;

public class MayTinhAdapter extends RecyclerView.Adapter<MayTinhAdapter.ViewHolder> {
    Context context;
    ArrayList<MayTinhDTO> list;
    MayTinhDAO mayTinhDAO;
    public MayTinhAdapter(Context context, ArrayList<MayTinhDTO> list){
        this.context = context;
        this.list = list;
        mayTinhDAO = new MayTinhDAO(context);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = ((Activity)context).getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.item_maytinh, parent, false);
        return new  ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MayTinhDTO mayTinhDTO = list.get(position);
        Picasso.get().load(mayTinhDTO.getHinhanh()).into(holder.hinhanh);
        holder.txtten.setText(mayTinhDTO.getTenmt());
        holder.txtgia.setText(String.valueOf(mayTinhDTO.getGiatien()) + "đ");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtten, txtgia;
        ImageView hinhanh;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtten = itemView.findViewById(R.id.tv_tenmaytinh);
            txtgia = itemView.findViewById(R.id.tv_giaTien);
            hinhanh = itemView.findViewById(R.id.img_maytinh);
        }
    }

}
