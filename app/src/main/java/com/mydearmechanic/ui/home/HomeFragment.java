package com.mydearmechanic.ui.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.mydearmechanic.CustomerLogin;
import com.mydearmechanic.MainActivity;
import com.mydearmechanic.R;
import com.mydearmechanic.databinding.FragmentHomeBinding;
import com.mydearmechanic.ui.AboutUsFragment;

public class HomeFragment extends Fragment {
    Activity context;

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        context=getActivity();
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }
    public  void onStart()
    {
        super.onStart();
       /* Spinner spinner;*/

        Spinner spinner= context.findViewById(R.id.spinner);
        Spinner spinner1=context.findViewById(R.id.spinner1);
        Spinner spinner2=context.findViewById(R.id.spinner2);
        Spinner spinner3=context.findViewById(R.id.spinner3);
        ArrayAdapter<CharSequence> adapter1=ArrayAdapter.createFromResource(context,R.array.Dictrict, android.R.layout.simple_spinner_item );
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner1.setAdapter(adapter1);
        ArrayAdapter<CharSequence> adapter2=ArrayAdapter.createFromResource(context,R.array.State, android.R.layout.simple_spinner_item );
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner2.setAdapter(adapter2);
        ArrayAdapter<CharSequence> adapter3=ArrayAdapter.createFromResource(context,R.array.PinCode, android.R.layout.simple_spinner_item );
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner3.setAdapter(adapter3);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context, R.array.quantity, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);

       /* Button btn=(Button) context.findViewById(R.id.button);*/




        /*btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,CustomerLogin.class);
                startActivity(intent);
            }
        });*/
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;


    }
}