package fr.kccorp.android;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "nope", Toast.LENGTH_SHORT).show();
    }

    private Button bouton1;
    private Button bouton2;
    private Button bouton3;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.bouton2 = findViewById(R.id.btn2);
        this.bouton1 = findViewById(R.id.btn1);
        this.editText = findViewById(R.id.editText);
        this.bouton3 = findViewById(R.id.btn3);
        this.bouton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Le bouton 1", Toast.LENGTH_SHORT).show();

            }
        });


        this.bouton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(false);
                builder.setTitle(getResources().getString(R.string.popup_title));
                builder.setMessage(getResources().getString(R.string.popup_message));
                builder.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Annulé", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setPositiveButton(getResources().getString(R.string.popup_btn_oui), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                builder.show();


            }
        });

        this.bouton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String contenu = editText.getText().toString();
                Intent i = new Intent(MainActivity.this, HelloActivity.class);
                i.putExtra("contenu", contenu);
                if (contenu.isEmpty()) {

                    editText.setError("Veuillez entrer un contenu");
                } else {
                    startActivity(i);
                }
            }
        });

    }
}