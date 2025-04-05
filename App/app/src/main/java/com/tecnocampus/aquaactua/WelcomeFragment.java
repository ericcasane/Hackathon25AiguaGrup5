package com.tecnocampus.aquaactua;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class WelcomeFragment extends Fragment implements View.OnClickListener {

    public WelcomeFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_welcome, container, false);

        // Find the buttons and set the onClickListener
        Button btRegister = view.findViewById(R.id.btCreateAccount);
        Button btLogin = view.findViewById(R.id.btGoToLogin);
        Button btSkipNow = view.findViewById(R.id.btSkipNow);

        btRegister.setOnClickListener(this);
        btLogin.setOnClickListener(this);
        btSkipNow.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        Button b = (Button) v;
        MainActivity mainActivity = (MainActivity) getActivity();
        if (mainActivity != null) {
            if (b.getId() == R.id.btCreateAccount)
                mainActivity.loadRegisterFragment();
            if (b.getId() == R.id.btGoToLogin)
                mainActivity.loadSignInFragment();
            else if (b.getId() == R.id.btSkipNow)
                mainActivity.loadHomeFragment();
        }
    }
}