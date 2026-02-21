package com.example.pizzarecipes.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pizzarecipes.R;
import com.example.pizzarecipes.classes.Produit;

import java.util.List;

public class PizzaAdapter extends BaseAdapter {

    private final Context ctx;
    private final List<Produit> pizzas;

    public PizzaAdapter(Context ctx, List<Produit> pizzas) {
        this.ctx = ctx;
        this.pizzas = pizzas;
    }

    @Override
    public int getCount() { return pizzas.size(); }

    @Override
    public Object getItem(int i) { return pizzas.get(i); }

    @Override
    public long getItemId(int i) { return pizzas.get(i).getId(); }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent) {
        // ViewHolder pattern for smooth scrolling
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(ctx).inflate(R.layout.row_pizza, parent, false);
            holder = new ViewHolder();
            holder.img   = convertView.findViewById(R.id.imgPizza);
            holder.tvNom = convertView.findViewById(R.id.tvNom);
            holder.tvMeta = convertView.findViewById(R.id.tvMeta);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Produit p = pizzas.get(pos);
        holder.img.setImageResource(p.getImageRes());
        holder.tvNom.setText(p.getNom());
        holder.tvMeta.setText(p.getDuree() + " • " + p.getPrix() + " €");

        return convertView;
    }

    // ViewHolder avoids repeated findViewById calls on every scroll
    static class ViewHolder {
        ImageView img;
        TextView tvNom;
        TextView tvMeta;
    }
}
