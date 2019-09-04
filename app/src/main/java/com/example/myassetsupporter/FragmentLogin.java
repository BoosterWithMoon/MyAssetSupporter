package com.example.myassetsupporter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FragmentLogin extends Fragment {
    private String ID="admin";
    private String Password="1111";

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        final View view = inflater.inflate(R.layout.fragment_login, container, false);
        Button btn_Login = (Button)view.findViewById(R.id.button_login);
        btn_Login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                EditText data = view.findViewById(R.id.editText2);
                String enteredID = data.getText().toString();

                data = view.findViewById(R.id.editText);
                String enteredPW = data.getText().toString();

                if(ID != enteredID || Password != enteredPW)    // ID or Password is not correct
                {

                }
                else{
                    // continue;

                }
            }
        });
        return view;
    }
}
