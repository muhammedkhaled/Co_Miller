// Generated by view binder compiler. Do not edit!
package com.example.comiller.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextClock;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.comiller.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentSignUpBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextClock conditionsCheckbox;

  @NonNull
  public final Guideline guideline1;

  @NonNull
  public final Guideline guideline2;

  @NonNull
  public final Guideline guideline3;

  @NonNull
  public final ProgressBar loadingProgress;

  @NonNull
  public final EditText regisEmailEt;

  @NonNull
  public final TextInputLayout regisEmailTil;

  @NonNull
  public final EditText regisVolNameEt;

  @NonNull
  public final TextInputLayout regisVolNameTil;

  @NonNull
  public final EditText regisVolPassEt;

  @NonNull
  public final TextInputLayout regisVolPassTil;

  @NonNull
  public final EditText regisVolPhoneEt;

  @NonNull
  public final TextInputLayout regisVolPhoneTil;

  @NonNull
  public final TextView regisVolTitleTv;

  @NonNull
  public final MaterialButton registerBtn;

  @NonNull
  public final TextView signInTv;

  private FragmentSignUpBinding(@NonNull ConstraintLayout rootView,
      @NonNull TextClock conditionsCheckbox, @NonNull Guideline guideline1,
      @NonNull Guideline guideline2, @NonNull Guideline guideline3,
      @NonNull ProgressBar loadingProgress, @NonNull EditText regisEmailEt,
      @NonNull TextInputLayout regisEmailTil, @NonNull EditText regisVolNameEt,
      @NonNull TextInputLayout regisVolNameTil, @NonNull EditText regisVolPassEt,
      @NonNull TextInputLayout regisVolPassTil, @NonNull EditText regisVolPhoneEt,
      @NonNull TextInputLayout regisVolPhoneTil, @NonNull TextView regisVolTitleTv,
      @NonNull MaterialButton registerBtn, @NonNull TextView signInTv) {
    this.rootView = rootView;
    this.conditionsCheckbox = conditionsCheckbox;
    this.guideline1 = guideline1;
    this.guideline2 = guideline2;
    this.guideline3 = guideline3;
    this.loadingProgress = loadingProgress;
    this.regisEmailEt = regisEmailEt;
    this.regisEmailTil = regisEmailTil;
    this.regisVolNameEt = regisVolNameEt;
    this.regisVolNameTil = regisVolNameTil;
    this.regisVolPassEt = regisVolPassEt;
    this.regisVolPassTil = regisVolPassTil;
    this.regisVolPhoneEt = regisVolPhoneEt;
    this.regisVolPhoneTil = regisVolPhoneTil;
    this.regisVolTitleTv = regisVolTitleTv;
    this.registerBtn = registerBtn;
    this.signInTv = signInTv;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentSignUpBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentSignUpBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_sign_up, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentSignUpBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.conditions_checkbox;
      TextClock conditionsCheckbox = ViewBindings.findChildViewById(rootView, id);
      if (conditionsCheckbox == null) {
        break missingId;
      }

      id = R.id.guideline1;
      Guideline guideline1 = ViewBindings.findChildViewById(rootView, id);
      if (guideline1 == null) {
        break missingId;
      }

      id = R.id.guideline2;
      Guideline guideline2 = ViewBindings.findChildViewById(rootView, id);
      if (guideline2 == null) {
        break missingId;
      }

      id = R.id.guideline3;
      Guideline guideline3 = ViewBindings.findChildViewById(rootView, id);
      if (guideline3 == null) {
        break missingId;
      }

      id = R.id.loadingProgress;
      ProgressBar loadingProgress = ViewBindings.findChildViewById(rootView, id);
      if (loadingProgress == null) {
        break missingId;
      }

      id = R.id.regisEmail_et;
      EditText regisEmailEt = ViewBindings.findChildViewById(rootView, id);
      if (regisEmailEt == null) {
        break missingId;
      }

      id = R.id.regisEmail_til;
      TextInputLayout regisEmailTil = ViewBindings.findChildViewById(rootView, id);
      if (regisEmailTil == null) {
        break missingId;
      }

      id = R.id.regisVolName_et;
      EditText regisVolNameEt = ViewBindings.findChildViewById(rootView, id);
      if (regisVolNameEt == null) {
        break missingId;
      }

      id = R.id.regisVolName_til;
      TextInputLayout regisVolNameTil = ViewBindings.findChildViewById(rootView, id);
      if (regisVolNameTil == null) {
        break missingId;
      }

      id = R.id.regisVolPass_et;
      EditText regisVolPassEt = ViewBindings.findChildViewById(rootView, id);
      if (regisVolPassEt == null) {
        break missingId;
      }

      id = R.id.regisVolPass_til;
      TextInputLayout regisVolPassTil = ViewBindings.findChildViewById(rootView, id);
      if (regisVolPassTil == null) {
        break missingId;
      }

      id = R.id.regisVolPhone_et;
      EditText regisVolPhoneEt = ViewBindings.findChildViewById(rootView, id);
      if (regisVolPhoneEt == null) {
        break missingId;
      }

      id = R.id.regisVolPhone_til;
      TextInputLayout regisVolPhoneTil = ViewBindings.findChildViewById(rootView, id);
      if (regisVolPhoneTil == null) {
        break missingId;
      }

      id = R.id.regisVolTitle_tv;
      TextView regisVolTitleTv = ViewBindings.findChildViewById(rootView, id);
      if (regisVolTitleTv == null) {
        break missingId;
      }

      id = R.id.register_btn;
      MaterialButton registerBtn = ViewBindings.findChildViewById(rootView, id);
      if (registerBtn == null) {
        break missingId;
      }

      id = R.id.signIn_tv;
      TextView signInTv = ViewBindings.findChildViewById(rootView, id);
      if (signInTv == null) {
        break missingId;
      }

      return new FragmentSignUpBinding((ConstraintLayout) rootView, conditionsCheckbox, guideline1,
          guideline2, guideline3, loadingProgress, regisEmailEt, regisEmailTil, regisVolNameEt,
          regisVolNameTil, regisVolPassEt, regisVolPassTil, regisVolPhoneEt, regisVolPhoneTil,
          regisVolTitleTv, registerBtn, signInTv);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
