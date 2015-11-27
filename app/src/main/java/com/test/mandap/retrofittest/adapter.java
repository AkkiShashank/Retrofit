package com.test.mandap.retrofittest;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;
import com.test.mandap.retrofittest.model.Flower;

import java.util.List;

/**
 * Created by Shashank Gupta on 16-Aug-15.
 */
public class adapter extends ArrayAdapter<Flower> {

    String url="http://services.hanselandpetal.com/photos/";
    private Context context;
    private List<Flower> flowerList;
    public adapter(Context context, int resource, List<Flower> objects) {
        super(context, resource, objects);
        this.context = context;
        this.flowerList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_file,parent,false);
        Flower flower = flowerList.get(position);
        TextView tv = (TextView) view.findViewById(R.id.name);
        tv.setText(flower.getName());
        ImageView img = (ImageView) view.findViewById(R.id.img);
        Picasso.with(getContext()).load(url + flower.getPhoto()).networkPolicy(NetworkPolicy.OFFLINE).resize(100, 100).into(img);
        return view;
    }
}
