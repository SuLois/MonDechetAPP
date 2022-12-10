package com.example.mondechetapp;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.mondechetapp.Scan.CodeBarreFragment;
import com.example.mondechetapp.Scan.DetectionFragment;
import com.example.mondechetapp.Scan.ScanFragment;
import com.example.mondechetapp.Search.SearchFragment;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity implements NavBarFragment.OnButtonClickedListener, ScanFragment.OnButtonClickedListener {

    CodeBarreFragment codeBarreFragment = new CodeBarreFragment();
    SearchFragment searchFragment = new SearchFragment();
    ScanFragment scanFragment = new ScanFragment();
    AstuceFragment astuceFragment = new AstuceFragment();
    HelpFragment helpFragment = new HelpFragment();
    DetectionFragment detectionFragment = new DetectionFragment();
    NavBarFragment navBarFragment = new NavBarFragment();

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private DocumentReference dechetRef = db.document("Liste_Dechets/CB_Dechet");
    Map<String, Object> dechet = new HashMap<>();

    private static final String TAG = "MainActivity";
    private static final String KEY_CODEBARRE = "code barre";
    private static final String KEY_NAME = "name";
    private static final String KEY_BAC = "bac";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NavBarFragment navBarFragment = new NavBarFragment();


        getSupportFragmentManager().beginTransaction()
                .replace(R.id.second_placeholder, navBarFragment)
                .add(R.id.first_placeholder, searchFragment)
                .commit();
    }

    private final ActivityResultLauncher<ScanOptions> barcodeLauncher = registerForActivityResult(new ScanContract(),
            result -> {
                if (result.getContents() == null) {
                    Toast.makeText(MainActivity.this, "Cancelled", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
                    String valueCB = result.getContents();
                    find(valueCB);
                    // TODO : Mettre en place la fiche du dechet à partir d'ici ou bien appel fonction (meilleure solution)
                }
            });

    public void display(String CB, String name, String bac) {
        CodeBarreFragment frag = (CodeBarreFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment_code_barre);
        codeBarreFragment.changeText(CB, name, bac);
    }


    @Override
    public void onButtonClicked(int button) {
        Log.e(getClass().getSimpleName(), "Button " + Integer.toString(button) + " clicked !");
        SearchFragment searchFragment = new SearchFragment();
        ScanFragment scanFragment = new ScanFragment();
        AstuceFragment astuceFragment = new AstuceFragment();
        HelpFragment helpFragment = new HelpFragment();
        DetectionFragment detectionFragment = new DetectionFragment();


        if (button == 1) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.first_placeholder, searchFragment)
                    .commit();
        }

        if (button == 2) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.first_placeholder, scanFragment)
                    .commit();
        }

        if (button == 3) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.first_placeholder, astuceFragment)
                    .commit();
        }

        if (button == 4) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.first_placeholder, helpFragment)
                    .commit();
        }
        if (button == 5) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.first_placeholder, codeBarreFragment)
                    .commit();

            ScanOptions options = new ScanOptions();
            options.setTimeout(10000);
            options.setBeepEnabled(false);
            barcodeLauncher.launch(options);

        }
        if (button == 6) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.first_placeholder, detectionFragment)
                    .commit();
        }

    }


    public void find(String CB) {
        dechetRef.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if (documentSnapshot.exists()) {
                            String numCB = documentSnapshot.getString(KEY_CODEBARRE);
                            String name = documentSnapshot.getString(KEY_NAME);
                            String bac = documentSnapshot.getString(KEY_BAC);

                            //Map<String, Object> dechet = documentSnapshot.getData();
                            display(numCB, name, bac);
                        } else {
                            Toast.makeText(MainActivity.this, "Le déchet n'existe pas encore !", Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "Erreur !", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, e.toString());
                    }
                });
    }
}


    /* Ecriture dans Firebase
    public void save(){
        Map<String, Object> dechet = new HashMap<>();
        dechet.put(KEY_CODEBARRE, "123456789");
        dechet.put(KEY_NAME, "Test");
        dechet.put(KEY_BAC, "Test poubelle");
        db.collection("Liste_Dechets").document("CB_Dechet").set(dechet)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(MainActivity.this, "Succes !", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "Erreur !", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, e.toString());
                    }
                });


    }
*/
