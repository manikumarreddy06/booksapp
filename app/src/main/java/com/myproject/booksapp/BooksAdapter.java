package com.myproject.booksapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.ColorSpace;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.BookViewHolder> {

    private ArrayList<BooksInfo> bookInfoArrayList;
    private Context mcontext;

    public BooksAdapter(ArrayList<BooksInfo> bookInfoArrayList, Context context) {
        this.bookInfoArrayList = bookInfoArrayList;
        mcontext=context;

    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
             View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.one_item,parent,false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        final BooksInfo temp;
        temp = bookInfoArrayList.get(position);
        BooksInfo booksInfo=bookInfoArrayList.get(position);
    holder.nameTV.setText(booksInfo.getTitle());
    holder.publisherTV.setText(booksInfo.getPublisher());
        String il= temp.getThumbnail();
        Picasso.get().load(il).into(holder.bookIV);

  holder.itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent=new Intent(mcontext,BookDetails.class);
        intent.putExtra("booktitle",temp.getTitle());
        intent.putExtra("booksubtitle",temp.getSubtitle());
        intent.putExtra("bookdes",temp.getDescription());
        intent.putExtra("bookpublisher",temp.getPublisher());
        intent.putExtra("bookpublisheddate",temp.getPublishedDate());
        intent.putExtra("bookimage",temp.getThumbnail());
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mcontext.startActivity(intent);
    }
});



    }

    @Override
    public int getItemCount() {
        return bookInfoArrayList.size();
    }

    public class BookViewHolder extends RecyclerView.ViewHolder {
        TextView nameTV, publisherTV;
        ImageView bookIV;
        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTV=itemView.findViewById(R.id.idTVBookTitle);
            publisherTV=itemView.findViewById(R.id.idTVpublisher);
            bookIV=itemView.findViewById(R.id.idIVbook);
        }
    }
}
