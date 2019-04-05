package com.example.test.LotteiAnimation;


import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.example.test.R;
import com.example.test.databinding.AnimationTest;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AnimationTestFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AnimationTestFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public AnimationTestFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AnimationTestFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AnimationTestFragment newInstance(String param1, String param2) {
        AnimationTestFragment fragment = new AnimationTestFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    AnimationTest animationTest;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        animationTest = DataBindingUtil.inflate(inflater, R.layout.fragment_animation_test, container, false);
        setUp();
        return animationTest.getRoot();
    }

    private void setUp() {
        animationTest.Button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NewApi")
            @Override
            public void onClick(View v) {
                animationTest.Button.animate()
                        .alpha(1f)
                        .scaleX(1f)
                        .scaleY(1f)
                        .translationZ(10f)
                        .setInterpolator(new FastOutSlowInInterpolator())
                        .setStartDelay(200)
                        .setListener(new Animator.AnimatorListener() {
                            @Override
                            public void onAnimationStart(Animator animation) { }
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                final ViewDialog dialog = new ViewDialog(getActivity());
                                dialog.showDialog();

                                Handler h = new Handler();
                                h.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        dialog.hideDialog();
                                    }
                                }, 4000);
                            }
                            @Override
                            public void onAnimationCancel(Animator animation) { }
                            @Override
                            public void onAnimationRepeat(Animator animation) { }
                        })
                        .start();

            }
        });
    }


    public class ViewDialog {
        Activity activity;
        Dialog dialog;

        public ViewDialog(Activity activity) {
            this.activity = activity;
            dialog = new Dialog(activity);
        }


        public void showDialog() {
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setCancelable(false);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.setContentView(R.layout.animation_layout);
            dialog.show();
        }

        public void hideDialog() {
            dialog.dismiss();
        }


    }

}
