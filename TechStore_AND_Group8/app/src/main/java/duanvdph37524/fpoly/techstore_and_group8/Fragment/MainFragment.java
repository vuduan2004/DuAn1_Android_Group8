package duanvdph37524.fpoly.techstore_and_group8.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import duanvdph37524.fpoly.techstore_and_group8.Activity.ListDienThoai;
import duanvdph37524.fpoly.techstore_and_group8.R;


public class MainFragment extends Fragment {

    ImageView img_dienthoai;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        img_dienthoai = view.findViewById(R.id.imgDienThoai);
        img_dienthoai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ListDienThoai.class));
            }
        });

        return view;
    }
}