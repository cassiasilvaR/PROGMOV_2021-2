// Generated by view binder compiler. Do not edit!
package com.example.eshelf.databinding;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.viewbinding.ViewBindings;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.eshelf.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityIniciarBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final RelativeLayout bodyContainer;

  @NonNull
  public final BottomNavigationView bottomNavigation;

  @NonNull
  public final TextView txtNome;

  private ActivityIniciarBinding(@NonNull RelativeLayout rootView,
      @NonNull RelativeLayout bodyContainer, @NonNull BottomNavigationView bottomNavigation,
      @NonNull TextView txtNome) {
    this.rootView = rootView;
    this.bodyContainer = bodyContainer;
    this.bottomNavigation = bottomNavigation;
    this.txtNome = txtNome;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityIniciarBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityIniciarBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_iniciar, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityIniciarBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      RelativeLayout bodyContainer = (RelativeLayout) rootView;

      id = R.id.bottom_navigation;
      BottomNavigationView bottomNavigation = ViewBindings.findChildViewById(rootView, id);
      if (bottomNavigation == null) {
        break missingId;
      }

      id = R.id.txtNome;
      TextView txtNome = ViewBindings.findChildViewById(rootView, id);
      if (txtNome == null) {
        break missingId;
      }

      return new ActivityIniciarBinding((RelativeLayout) rootView, bodyContainer, bottomNavigation,
          txtNome);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
