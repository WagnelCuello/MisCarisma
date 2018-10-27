package com.yowaelectronics.app.miscantos.Config;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yowaelectronics.app.miscantos.Models.UserModel;
import com.yowaelectronics.app.miscantos.R;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class MyUserRecyclerAdapter extends RecyclerView.Adapter<MyUserRecyclerAdapter.MyRecycleItemViewHolder> {
    private final ArrayList<UserModel> items;
    private final Context context;

    public MyUserRecyclerAdapter(Context context , ArrayList<UserModel> items){
        this.context = context;
        this.items = items;
    }

    @Override public int getItemViewType(int position){ return R.layout.layout_user_list; }

    @Override public MyRecycleItemViewHolder onCreateViewHolder(ViewGroup parent, int layout) {
        View view = LayoutInflater.from(context).inflate(layout, parent, false);
        MyRecycleItemViewHolder holder = new MyRecycleItemViewHolder(view);
        return holder;
    }
    @Override public void onBindViewHolder(final MyUserRecyclerAdapter.MyRecycleItemViewHolder holder, int position) {
        final UserModel model = items.get(position);

        // this part of code find image inside FirebaseStorage and put it in an ImageView
        holder.nombreCompleto.setText(String.format("%s %s", model.getNombre(), model.getApellido()));
        Glide.with(context)
                .load(model.getFoto())
                .into(holder.imageView);

        // this part of code show options to share the image
        holder.compartir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.imageView.buildDrawingCache();
                Bitmap bitmap = holder.imageView.getDrawingCache();
                try {
                    File file = new File(context.getCacheDir(), bitmap + ".png");
                    FileOutputStream fOut = null;
                    fOut = new FileOutputStream(file);
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                    fOut.flush();
                    fOut.close();

                    file.setReadable(true, false);
                    final Intent intent = new Intent(android.content.Intent.ACTION_SEND);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
                    intent.setType("image/");
                    context.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override public int getItemCount() {
        return items.size();
    }

    // when MyUserRecyclerAdapter start, this class and inside method begin first
    public static class MyRecycleItemViewHolder extends RecyclerView.ViewHolder {
        public TextView nombreCompleto, compartir;
        public ImageView imageView;

        public MyRecycleItemViewHolder(View view) {
            super(view);
            nombreCompleto = view.findViewById(R.id.tvNombre);
            compartir = view.findViewById(R.id.tvCantos);
            imageView = view.findViewById(R.id.ivImgPost);
        }
    }
}
