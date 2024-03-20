package com.sinhvien.doan.Activity;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;
import com.sinhvien.doan.Class.CaptureAct;
import com.sinhvien.doan.FragmentParents.HistoryFragment;
import com.sinhvien.doan.FragmentParents.HomeFragment;
import com.sinhvien.doan.FragmentParents.NotificationFragment;
import com.sinhvien.doan.FragmentParents.ProfileFragment;
import com.sinhvien.doan.R;

public class Index extends AppCompatActivity {
    FloatingActionButton btnScan;
    BottomNavigationView bottomNavigationView;
    FrameLayout frameLayout,frameLayout2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        bottomNavigationView=findViewById(R.id.bottomNavigationView);
        frameLayout=findViewById(R.id.frameLayout);
        frameLayout2=findViewById(R.id.frameLayout2);
        btnScan=findViewById(R.id.floatingActionButton);
        btnScan.setOnClickListener(v->{
            scanCode();
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId=item.getItemId();

                if(itemId==R.id.navHome){
                    loadFragment(new HomeFragment());

                }else if(itemId==R.id.navHistory){
                    loadFragment(new HistoryFragment());

                }else if(itemId==R.id.navNotifi){
                    loadFragment(new NotificationFragment());

                }else {
                    loadFragment(new ProfileFragment());

                }
                return false;
            }
        });
    }
    private void scanCode(){
        ScanOptions options=new ScanOptions();
        options.setPrompt("Volume up to flash on");
        options.setBeepEnabled(true);
        options.setOrientationLocked(true);
        options.setCaptureActivity(CaptureAct.class);
        barLaucher.launch(options);
    }
    private void loadFragment(Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }
    ActivityResultLauncher<ScanOptions>barLaucher=registerForActivityResult(new ScanContract(), result->{
        if(result.getContents()!=null){
            AlertDialog.Builder builder=new AlertDialog.Builder(Index.this);
            builder.setTitle("Result");
            builder.setMessage(result.getContents());
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            }).show();
        }
    });
}