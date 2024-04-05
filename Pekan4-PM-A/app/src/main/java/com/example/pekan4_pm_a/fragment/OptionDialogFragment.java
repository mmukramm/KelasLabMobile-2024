package com.example.pekan4_pm_a.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.pekan4_pm_a.R;


public class OptionDialogFragment extends DialogFragment {
    private Button btnChoose, btnClose;
    private RadioGroup rgOptions;
    private RadioButton rbAns1, rbAns2, rbAns3, rbAns4;
    private OnOptionDialogListener optionDialogListener;


    public OptionDialogFragment() {
// empty constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
// Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_option_dialog, container, false);
    }




    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnChoose = view.findViewById(R.id.btn_choose);
        btnClose = view.findViewById(R.id.btn_close);
        rgOptions = view.findViewById(R.id.rg_options);
        rbAns1 = view.findViewById(R.id.rb_ans1);
        rbAns2 = view.findViewById(R.id.rb_ans2);
        rbAns3 = view.findViewById(R.id.rb_ans3);
        rbAns4 = view.findViewById(R.id.rb_ans4);
        btnChoose.setOnClickListener(v -> {
            int checkedRadioButtonId = rgOptions.getCheckedRadioButtonId();
            if (checkedRadioButtonId != -1) {
                String answer = null;
                if (checkedRadioButtonId == R.id.rb_ans1) {
                    answer = rbAns1.getText().toString().trim();
                } else if (checkedRadioButtonId == R.id.rb_ans2) {
                    answer = rbAns2.getText().toString().trim();
                } else if (checkedRadioButtonId == R.id.rb_ans3) {
                    answer = rbAns3.getText().toString().trim();
                } else if (checkedRadioButtonId == R.id.rb_ans4) {
                    answer = rbAns4.getText().toString().trim();
                }
                if (optionDialogListener != null) {
                    optionDialogListener.onOptionChosen(answer);
                }
                getDialog().dismiss();
            }
        });
        btnClose.setOnClickListener(v -> getDialog().cancel());
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Fragment fragment = getParentFragment();
        if (fragment instanceof DetailCategoryFragment) {
            DetailCategoryFragment detailCategoryFragment = (DetailCategoryFragment)
                    fragment;
            this.optionDialogListener = detailCategoryFragment.optionDialogListener;
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        this.optionDialogListener = null;
    }


    public interface OnOptionDialogListener {
        void onOptionChosen(String text);
    }
}
