package com.example.test.LoadingAnimations;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Animation;

import com.example.test.LotteiAnimation.AnimationTestFragment;

public class Utility {
    public static AnimatorSet generateAnimation(View v, Context context, AnimationType animationType, int duration, int dpSize) {

        if (v == null) {
            return null;
        }

        final AnimatorSet group = new AnimatorSet();
        final ObjectAnimator animator;
        final ObjectAnimator animator1;


        switch (animationType) {
            case SCALE_X:
                animator = ObjectAnimator.ofFloat(v, View.SCALE_X, 0, 1).setDuration(duration);
                animator1 = ObjectAnimator.ofFloat(v, View.SCALE_X, 1, 0).setDuration(duration);
                group.playSequentially(animator, animator1);
                group.start();
                break;
            case TRANSLATE_X:
                animator = ObjectAnimator.ofFloat(v, View.TRANSLATION_X, 0, getScreenWidth(context) - dpSize(context, dpSize)).setDuration(duration);
                animator1 = ObjectAnimator.ofFloat(v, View.TRANSLATION_X, getScreenWidth(context) - dpSize(context, dpSize), 0).setDuration(duration);
                group.playSequentially(animator, animator1);
                group.start();
                break;
        }

        group.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                group.start();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        return group;
    }

    public static int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int dpSize(Context context, int sizeInDp) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (sizeInDp * scale + 0.5f);
    }

    public static ViewPropertyAnimator putAnimation(View v){
        return v.animate().alpha(1f);
    }

}
