package com.example.test.ImageTest;


import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.test.R;
import com.example.test.databinding.TestImageBinding;

import java.io.ByteArrayOutputStream;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TestFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TestFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public TestFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TestFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TestFragment newInstance(String param1, String param2) {
        TestFragment fragment = new TestFragment();
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

    TestImageBinding testImageBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        testImageBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_test, container, false);
        setup();
        return testImageBinding.getRoot();
    }

    private void setup() {
        String img = "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";

        testImageBinding.iView.setImageURI(Uri.parse("data:image/jpeg;base64," + encodeImage(R.drawable.sample_5mb)));
    }

    public String encodeImage(int img) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), img);

        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageBytes = baos.toByteArray();

        //decode base64 string to image
       /* imageBytes = Base64.decode(imageString, Base64.DEFAULT);
        Bitmap decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
        testImageBinding.iView.setImageBitmap(decodedImage);*/

        return Base64.encodeToString(imageBytes, Base64.DEFAULT);
    }


}
