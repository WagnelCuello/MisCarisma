package com.yowaelectronics.app.miscantos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.yowaelectronics.app.miscantos.Models.CantoModel;
import com.yowaelectronics.app.miscantos.Models.UserModel;

import java.util.ArrayList;

public class MiListadoActivity extends AppCompatActivity {
    private ArrayList<UserModel> usersList;
    private ArrayList<CantoModel> CantosList;
    private FirebaseFirestore db;
    private FirebaseAuth mAuth;
    private RecyclerView rc;
    private UserModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_listado);

        mAuth = FirebaseAuth.getInstance();
    }
}
