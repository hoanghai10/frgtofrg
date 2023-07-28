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

public class Fragment1 extends Fragment {

    private EditText edt;
    private Button btn;

    private View mView;

    private ISend iSend;

    public interface ISend{
        void SendData(String email);
    }

    public Fragment1() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        iSend = (ISend) getActivity();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_1, container, false);

        edt = mView.findViewById(R.id.edtMail);
        btn = mView.findViewById(R.id.btnMail);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                senddataFragment();
            }
        });

        return mView;
    }
    private void senddataFragment() {
        String str = edt.getText().toString().trim();
        iSend.SendData(str);
    }
    public void ConFimlData(String email){
        edt.setText(email);
    }
}