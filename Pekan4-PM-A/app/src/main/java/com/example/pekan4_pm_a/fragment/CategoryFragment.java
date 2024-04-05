package com.example.pekan4_pm_a.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.pekan4_pm_a.R;
import com.example.pekan4_pm_a.model.Model;
import com.google.android.material.textfield.TextInputEditText;

public class CategoryFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        Button btnDetailCategory = view.findViewById(R.id.btn_detail_category);
        TextInputEditText usernameEt = view.findViewById(R.id.username_et);
        TextInputEditText descriptionEt = view.findViewById(R.id.description_et);


        btnDetailCategory.setOnClickListener(btn -> {
            DetailCategoryFragment detailCategoryFragment = new DetailCategoryFragment();
            Bundle bundle = new Bundle();
            String username = usernameEt.getText().toString();
            String description = descriptionEt.getText().toString();

//          Data Bundle tanpa Parcelable
            bundle.putString(DetailCategoryFragment.EXTRA_NAME, username);

//          Data Bundle dengan Parcelable
            Model model = new Model(username, description);
            bundle.putParcelable(DetailCategoryFragment.EXTRA_MODEL, model);

            detailCategoryFragment.setArguments(bundle);

            detailCategoryFragment.setDescription(description);

            FragmentManager fragmentManager = getParentFragmentManager();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_container, detailCategoryFragment,
                            DetailCategoryFragment.class.getSimpleName())
                    .addToBackStack(null)
                    .commit();
        });
    }
}
