package com.example.lutemonv10.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.example.lutemonv10.LutemonListAdapter;
import com.example.lutemonv10.R;
import com.example.lutemonv10.Storage;

public class EditLutemonFragment extends Fragment {



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_edit_lutemon, container, false);

        Button zero = view.findViewById(R.id.rbZeroRename);
        Button one = view.findViewById(R.id.rbOneRename);
        Button two = view.findViewById(R.id.rbTwoRename);
        Button three = view.findViewById(R.id.rbThreeRename);
        Button four = view.findViewById(R.id.rbFourRename);
        Button change = view.findViewById(R.id.btnChangeName);


        zero.setText(Storage.getInstance().getLutemons().get(0).getName().toString() + " (" + Storage.getInstance().getLutemons().get(0).getColor() + ")");
        one.setText(Storage.getInstance().getLutemons().get(1).getName().toString()  + " (" + Storage.getInstance().getLutemons().get(1).getColor() + ")");
        two.setText(Storage.getInstance().getLutemons().get(2).getName().toString() + " (" + Storage.getInstance().getLutemons().get(2).getColor() + ")");
        three.setText(Storage.getInstance().getLutemons().get(3).getName().toString() + " (" + Storage.getInstance().getLutemons().get(3).getColor() + ")");
        four.setText(Storage.getInstance().getLutemons().get(4).getName().toString() + " (" + Storage.getInstance().getLutemons().get(4).getColor() + ")");


        RadioGroup rg = view.findViewById(R.id.rgRename);

        EditText txtInput;

        txtInput = view.findViewById(R.id.editTxtName);

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (rg.getCheckedRadioButtonId()) {
                    case (R.id.rbZeroRename):
                        Storage.getInstance().getLutemons().get(0).setName(txtInput.getText().toString());
                        zero.setText(Storage.getInstance().getLutemons().get(0).getName().toString() + " (" + Storage.getInstance().getLutemons().get(0).getColor() + ")");
                        break;
                    case (R.id.rbOneRename):
                        Storage.getInstance().getLutemons().get(1).setName(txtInput.getText().toString());
                        one.setText(Storage.getInstance().getLutemons().get(1).getName().toString()  + " (" + Storage.getInstance().getLutemons().get(1).getColor() + ")");
                        break;
                    case (R.id.rbTwoRename):
                        Storage.getInstance().getLutemons().get(2).setName(txtInput.getText().toString());
                        two.setText(Storage.getInstance().getLutemons().get(2).getName().toString() + " (" + Storage.getInstance().getLutemons().get(2).getColor() + ")");
                        break;
                    case (R.id.rbThreeRename):
                        Storage.getInstance().getLutemons().get(3).setName(txtInput.getText().toString());
                        three.setText(Storage.getInstance().getLutemons().get(3).getName().toString() + " (" + Storage.getInstance().getLutemons().get(3).getColor() + ")");
                        break;
                    case (R.id.rbFourRename):
                        Storage.getInstance().getLutemons().get(4).setName(txtInput.getText().toString());
                        four.setText(Storage.getInstance().getLutemons().get(4).getName().toString() + " (" + Storage.getInstance().getLutemons().get(4).getColor() + ")");
                        break;
                }
                txtInput.setText("");

            }
        });

        return view;
    }





}