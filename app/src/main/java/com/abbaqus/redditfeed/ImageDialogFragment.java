package com.abbaqus.redditfeed;

import android.app.Dialog;
import android.app.DialogFragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

/**
 * Abbaqus
 * Created by Administrator on 22-07-2018.
 */
public class ImageDialogFragment extends android.support.v4.app.DialogFragment {

    private View view;
    private GestureDetector gestureDetector;

    /**
     * Create a new instance of MyDialogFragment, providing "num"
     * as an argument.
     * @param url
     */
    static ImageDialogFragment newInstance(String url) {
        ImageDialogFragment f = new ImageDialogFragment();

        // Supply num input as an argument.
        Bundle args = new Bundle();
        args.putString("URL",url);
        f.setArguments(args);
        return f;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        return super.onCreateDialog(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_image_dialog, container, false);

        return view;
    }


    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final ImageView imageView=view.findViewById(R.id.imgZoomImageView);
        if (getArguments() != null) {
            Glide.with(getActivity()).load(getArguments().getString("URL").replaceAll("&amp;","&")).listener(new RequestListener<Drawable>() {
                @Override
                public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                    view.findViewById(R.id.pbLoading).setVisibility(View.GONE);
                    Toast.makeText(getActivity(), "Image Loading Failed", Toast.LENGTH_SHORT).show();
                    return false;
                }

                @Override
                public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                    view.findViewById(R.id.pbLoading).setVisibility(View.GONE);
                    return false;
                }
            }).into(imageView);
        }
    }
}
