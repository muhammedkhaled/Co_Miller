// Generated by view binder compiler. Do not edit!
package com.example.comiller.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.comiller.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentHomeBinding implements ViewBinding {
  @NonNull
  private final ScrollView rootView;

  @NonNull
  public final FloatingActionButton floatingActionButton;

  @NonNull
  public final FloatingActionButton floatingActionButton2;

  @NonNull
  public final FloatingActionButton floatingActionButton3;

  @NonNull
  public final Guideline guideline1;

  @NonNull
  public final Guideline guideline2;

  @NonNull
  public final TextView prog1BodyTv;

  @NonNull
  public final CardView prog1Cardv;

  @NonNull
  public final ImageView prog1Img;

  @NonNull
  public final TextView prog1TitleTv;

  @NonNull
  public final TextView prog2BodyTv;

  @NonNull
  public final CardView prog2Cardv;

  @NonNull
  public final ImageView prog2Img;

  @NonNull
  public final TextView prog2TitleTv;

  @NonNull
  public final TextView prog3BodyTv;

  @NonNull
  public final CardView prog3Cardv;

  @NonNull
  public final ImageView prog3Img;

  @NonNull
  public final TextView prog3TitleTv;

  private FragmentHomeBinding(@NonNull ScrollView rootView,
      @NonNull FloatingActionButton floatingActionButton,
      @NonNull FloatingActionButton floatingActionButton2,
      @NonNull FloatingActionButton floatingActionButton3, @NonNull Guideline guideline1,
      @NonNull Guideline guideline2, @NonNull TextView prog1BodyTv, @NonNull CardView prog1Cardv,
      @NonNull ImageView prog1Img, @NonNull TextView prog1TitleTv, @NonNull TextView prog2BodyTv,
      @NonNull CardView prog2Cardv, @NonNull ImageView prog2Img, @NonNull TextView prog2TitleTv,
      @NonNull TextView prog3BodyTv, @NonNull CardView prog3Cardv, @NonNull ImageView prog3Img,
      @NonNull TextView prog3TitleTv) {
    this.rootView = rootView;
    this.floatingActionButton = floatingActionButton;
    this.floatingActionButton2 = floatingActionButton2;
    this.floatingActionButton3 = floatingActionButton3;
    this.guideline1 = guideline1;
    this.guideline2 = guideline2;
    this.prog1BodyTv = prog1BodyTv;
    this.prog1Cardv = prog1Cardv;
    this.prog1Img = prog1Img;
    this.prog1TitleTv = prog1TitleTv;
    this.prog2BodyTv = prog2BodyTv;
    this.prog2Cardv = prog2Cardv;
    this.prog2Img = prog2Img;
    this.prog2TitleTv = prog2TitleTv;
    this.prog3BodyTv = prog3BodyTv;
    this.prog3Cardv = prog3Cardv;
    this.prog3Img = prog3Img;
    this.prog3TitleTv = prog3TitleTv;
  }

  @Override
  @NonNull
  public ScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_home, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentHomeBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.floatingActionButton;
      FloatingActionButton floatingActionButton = ViewBindings.findChildViewById(rootView, id);
      if (floatingActionButton == null) {
        break missingId;
      }

      id = R.id.floatingActionButton2;
      FloatingActionButton floatingActionButton2 = ViewBindings.findChildViewById(rootView, id);
      if (floatingActionButton2 == null) {
        break missingId;
      }

      id = R.id.floatingActionButton3;
      FloatingActionButton floatingActionButton3 = ViewBindings.findChildViewById(rootView, id);
      if (floatingActionButton3 == null) {
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

      id = R.id.prog1Body_tv;
      TextView prog1BodyTv = ViewBindings.findChildViewById(rootView, id);
      if (prog1BodyTv == null) {
        break missingId;
      }

      id = R.id.prog1_cardv;
      CardView prog1Cardv = ViewBindings.findChildViewById(rootView, id);
      if (prog1Cardv == null) {
        break missingId;
      }

      id = R.id.prog1_img;
      ImageView prog1Img = ViewBindings.findChildViewById(rootView, id);
      if (prog1Img == null) {
        break missingId;
      }

      id = R.id.prog1Title_tv;
      TextView prog1TitleTv = ViewBindings.findChildViewById(rootView, id);
      if (prog1TitleTv == null) {
        break missingId;
      }

      id = R.id.prog2Body_tv;
      TextView prog2BodyTv = ViewBindings.findChildViewById(rootView, id);
      if (prog2BodyTv == null) {
        break missingId;
      }

      id = R.id.prog2_cardv;
      CardView prog2Cardv = ViewBindings.findChildViewById(rootView, id);
      if (prog2Cardv == null) {
        break missingId;
      }

      id = R.id.prog2_img;
      ImageView prog2Img = ViewBindings.findChildViewById(rootView, id);
      if (prog2Img == null) {
        break missingId;
      }

      id = R.id.prog2Title_tv;
      TextView prog2TitleTv = ViewBindings.findChildViewById(rootView, id);
      if (prog2TitleTv == null) {
        break missingId;
      }

      id = R.id.prog3Body_tv;
      TextView prog3BodyTv = ViewBindings.findChildViewById(rootView, id);
      if (prog3BodyTv == null) {
        break missingId;
      }

      id = R.id.prog3_cardv;
      CardView prog3Cardv = ViewBindings.findChildViewById(rootView, id);
      if (prog3Cardv == null) {
        break missingId;
      }

      id = R.id.prog3_img;
      ImageView prog3Img = ViewBindings.findChildViewById(rootView, id);
      if (prog3Img == null) {
        break missingId;
      }

      id = R.id.prog3Title_tv;
      TextView prog3TitleTv = ViewBindings.findChildViewById(rootView, id);
      if (prog3TitleTv == null) {
        break missingId;
      }

      return new FragmentHomeBinding((ScrollView) rootView, floatingActionButton,
          floatingActionButton2, floatingActionButton3, guideline1, guideline2, prog1BodyTv,
          prog1Cardv, prog1Img, prog1TitleTv, prog2BodyTv, prog2Cardv, prog2Img, prog2TitleTv,
          prog3BodyTv, prog3Cardv, prog3Img, prog3TitleTv);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}