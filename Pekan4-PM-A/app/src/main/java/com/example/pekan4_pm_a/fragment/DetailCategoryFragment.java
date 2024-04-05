package com.example.pekan4_pm_a.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pekan4_pm_a.ProfileActivity;
import com.example.pekan4_pm_a.R;
import com.example.pekan4_pm_a.model.Model;


public class DetailCategoryFragment extends Fragment {
    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_MODEL = "extra_model";
    private static final String EXTRA_DESCRIPTION = "extra_description";
    private TextView tvCategoryName, tvCategoryNameParc;
    private TextView tvCategoryDescription, tvCategoryDescriptionParc;
    private Button btnShowDialog;
    private Button btnProfile;
    private String description;


    public DetailCategoryFragment() {
// required empty public constructor
    }


    private String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
// Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_category, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvCategoryName = view.findViewById(R.id.tv_category_name);
        tvCategoryDescription = view.findViewById(R.id.tv_category_description);
        tvCategoryNameParc = view.findViewById(R.id.tv_category_name_parc);
        tvCategoryDescriptionParc = view.findViewById(R.id.tv_category_description_parc);
        btnShowDialog = view.findViewById(R.id.btn_show_dialog);
        btnProfile = view.findViewById(R.id.btn_profile);
        if (savedInstanceState != null) {
            String descFromBundle = savedInstanceState.getString(EXTRA_DESCRIPTION);
            setDescription(descFromBundle);
        }
        if (getArguments() != null) {
//          Get Data Non Parcelable
            String categoryName = getArguments().getString(EXTRA_NAME);

//          Get Data Parcelable
            Model model = getArguments().getParcelable(EXTRA_MODEL);

            tvCategoryNameParc.setText(model.getUsername());
            tvCategoryDescriptionParc.setText(model.getDescription());

            tvCategoryName.setText(categoryName);
            tvCategoryDescription.setText(getDescription());
        }
        btnShowDialog.setOnClickListener(v -> {
            OptionDialogFragment optionDialogFragment = new OptionDialogFragment();
            FragmentManager fragmentManager = getChildFragmentManager();
            optionDialogFragment.show(fragmentManager, OptionDialogFragment.class.getSimpleName());
        });
        btnProfile.setOnClickListener(view1 -> {
            Intent i = new Intent(getActivity(), ProfileActivity.class);
            startActivity(i);
        });
    }


    OptionDialogFragment.OnOptionDialogListener optionDialogListener = text -> {
        if (text.equals(getString(R.string.ans1))) {
            Toast.makeText(getActivity(), "Jawaban Kamu Benar", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), "Jawaban Kamu Salah", Toast.LENGTH_SHORT).show();
        }
    };
}

