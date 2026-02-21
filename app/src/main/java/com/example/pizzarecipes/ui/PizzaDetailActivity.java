package com.example.pizzarecipes.ui;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pizzarecipes.R;
import com.example.pizzarecipes.classes.Produit;
import com.example.pizzarecipes.service.ProduitService;

public class PizzaDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_detail);

        // Retrieve the pizza ID passed from ListPizzaActivity
        long id = getIntent().getLongExtra("pizza_id", -1);
        Produit p = ProduitService.getInstance().findById(id);

        ImageView img         = findViewById(R.id.img);
        TextView title        = findViewById(R.id.title);
        TextView meta         = findViewById(R.id.meta);
        TextView ingredients  = findViewById(R.id.ingredients);
        TextView desc         = findViewById(R.id.desc);
        TextView steps        = findViewById(R.id.steps);

        if (p != null) {
            // Populate ActionBar with pizza name
            if (getSupportActionBar() != null) {
                getSupportActionBar().setTitle(p.getNom());
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            }

            img.setImageResource(p.getImageRes());
            title.setText(p.getNom());
            meta.setText(p.getDuree() + " • " + p.getPrix() + " €");
            ingredients.setText(p.getIngredients());
            desc.setText(p.getDescription());
            steps.setText(p.getEtapes());
        } else {
            title.setText("Pizza introuvable !");
        }
    }

    // Back arrow in toolbar navigates back to list
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
