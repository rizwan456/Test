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
        String img = getActivity().getResources().getString(R.string.image);

        //testImageBinding.iView.setImageURI(Uri.parse("data:image/jpeg;base64," + encodeImage(R.drawable.sample_1mb)));
        //testImageBinding.iView.setImageURI(Uri.parse("data:image/jpeg;base64," + encodeImage(R.drawable.sample_3mb)));
        testImageBinding.iView.setImageURI(Uri.parse("data:image/jpeg;base64," + encodeImage(R.drawable.sample_5mb)));
        //testImageBinding.iView.setImageURI(Uri.parse("data:image/jpeg;base64," + encodeImage(R.drawable.sample_10mb)));
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
