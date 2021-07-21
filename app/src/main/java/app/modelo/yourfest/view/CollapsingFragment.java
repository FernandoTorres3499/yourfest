package app.modelo.yourfest.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import app.modelo.yourfest.R;


public class CollapsingFragment extends Fragment {

    View view;

    public CollapsingFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view =  inflater.inflate(R.layout.fragment_collapsing, container, false);

/*
        TextView txtTitulo = view.findViewById(R.id.txtTitulo);
        txtTitulo.setText(R.string.modelo_fragment);


        txtTitulo.setTextColor(ColorStateList.valueOf(Color.WHITE));*/

        return view;
    }


}
