package com.example.test.ObjectAnimation;


import android.animation.Animator;
import android.animation.ValueAnimator;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.test.R;
import com.example.test.databinding.ObjectAnimationBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ObjectAnimationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ObjectAnimationFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ObjectAnimationBinding objectAnimationBinding;

    public ObjectAnimationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ObjectAnimationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ObjectAnimationFragment newInstance(String param1, String param2) {
        ObjectAnimationFragment fragment = new ObjectAnimationFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        objectAnimationBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_object_animation, container, false);

        //objectAnimationBinding.txtView

        final LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        objectAnimationBinding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                objectAnimationBinding.iview.setVisibility(View.VISIBLE);
                //ObjectAnimator iViewAnimator = ObjectAnimator.ofFloat(objectAnimationBinding.iview, "translationY", 800f, 0f);
                ValueAnimator iViewAnimator = ValueAnimator.ofFloat(0, 1);
                iViewAnimator.setDuration(1800);

                iViewAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        float value = (Float) (animation.getAnimatedValue());
                        objectAnimationBinding.iview.setTranslationX((float) (150.0 * Math.sin(value * Math.PI)));
                        objectAnimationBinding.iview.setTranslationY((float) (600 * Math.cos(value * Math.PI)));
                    }
                });

                iViewAnimator.start();

               /* objectAnimationBinding.iview.setScaleType(ImageView.ScaleType.CENTER);
                objectAnimationBinding.iview.animate().scaleX(0.5f).scaleY(0.5f).setDuration(5000).start();*/


                /*iViewAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
                iViewAnimator.start();*/

                params.setMargins(15, 10, 15, 10);

                iViewAnimator.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        objectAnimationBinding.iview.setVisibility(View.GONE);
                        ImageView imageView = new ImageView(getActivity());
                        imageView.setLayoutParams(params);
                        imageView.setImageResource(R.drawable.ic_check_mark_button);
                        imageView.setColorFilter(Color.parseColor("#80D61C"));

                        objectAnimationBinding.linearLayout.addView(imageView);

                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });

            }
        });


        return objectAnimationBinding.getRoot();
    }

}
