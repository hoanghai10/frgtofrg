package com.example.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class Fragment2 extends Fragment {

    private EditText edt2;
    private Button btn2;

    private View mView;

    private IUpdate iUpdate;

    public Fragment2() {
        // Required empty public constructor
    }

    public interface IUpdate{
        void updatedata(String email);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        iUpdate = (IUpdate) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_1, container, false);

        edt2 = mView.findViewById(R.id.edtMail2);
        btn2 = mView.findViewById(R.id.btnMail2);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updatedataFragment();
            }
        });

        return mView;
    }
    private void updatedataFragment() {
        String str2 = edt2.getText().toString().trim();
        iUpdate.updatedata(str2);
    }

    public void ConFimlData(String email){
        edt2.setText(email);
    }
}