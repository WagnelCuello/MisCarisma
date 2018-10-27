package com.yowaelectronics.app.miscantos.Config;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.yowaelectronics.app.miscantos.Constants.ConstantClass;
import com.yowaelectronics.app.miscantos.Models.CantoModel;
import com.yowaelectronics.app.miscantos.Models.UserModel;
import com.yowaelectronics.app.miscantos.R;

import java.util.ArrayList;

public class MiListadoActivity extends AppCompatActivity {
    private ArrayList<UserModel> usersList;
    private ArrayList<CantoModel> cantosList;
    private FirebaseFirestore db;
    private FirebaseAuth mAuth;
    private RecyclerView rc;
    private UserModel userModel;
    private CantoModel cantoModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_listado);

        rc = findViewById(R.id.myRecyclerView);
        rc.setHasFixedSize(true);
        mAuth = FirebaseAuth.getInstance();

        getUsersList();
    }

    private void getUsersList(){
        try {
            db = FirebaseFirestore.getInstance();
            db.collection("users")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                usersList = new ArrayList<>();
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    String id = document.getId();
                                    String nombre = (String) document.get("nombre");
                                    String apellido = (String) document.get("apellido");
                                    String email = (String) document.get("email");
                                    String password = (String) document.get("password");
                                    String foto = (String) document.get("urlfoto");

                                    userModel = new UserModel(nombre,apellido,email,password,foto);

                                    usersList.add(userModel);
                                }

                                rc.setLayoutManager(new LinearLayoutManager(MiListadoActivity.this,
                                        LinearLayoutManager.VERTICAL, false));
                                rc.setAdapter(new MyUserRecyclerAdapter(MiListadoActivity.this, usersList));
                            } else {
                                ConstantClass.showMessage("Error", "An error occurred while getting Firebase data", MiListadoActivity.this);
                            }
                        }
                    });
        }catch (Exception e){
            ConstantClass.showMessage("Exception", e.getMessage(), this);
        }
    }
}
