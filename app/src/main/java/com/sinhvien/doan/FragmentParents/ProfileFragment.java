package com.sinhvien.doan.FragmentParents;

import static android.content.ContentValues.TAG;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.sinhvien.doan.Activity.UserProfileActivity;
import com.sinhvien.doan.LoginNRegis.LoginWithEmail;
import com.sinhvien.doan.R;

public class ProfileFragment extends Fragment {
    Activity context;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_profile,container,false);
        Button btnLogout=(Button) view.findViewById(R.id.btnLogout);
        Button btnUser=(Button) view.findViewById(R.id.btnUser);
        Button btnNoti=(Button) view.findViewById(R.id.btnNoti);

        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference("User");
        DatabaseReference userRef = rootRef.child(FirebaseAuth.getInstance().getUid());

        userRef.addValueEventListener(new ValueEventListener() {
            String phonenumber,fullName,Email,birthday,profession,gender;
            @Override
            public void onDataChange(DataSnapshot keyId) {
                fullName = keyId.child("FullName").getValue(String.class);
                btnUser.setText(fullName);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "Failed to read value", databaseError.toException());
                // ...
            }
        });
        btnNoti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr= getFragmentManager().beginTransaction();
                fr.replace(R.id.frameLayout,new NotificationFragment());
                fr.commit();
            }
        });
        btnUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), UserProfileActivity.class);
                startActivity(intent);
            }
        });
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });

        // Inflate the layout for this fragment
        return view;
    }
    private void logout(){
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setTitle("Logout");
        builder.setMessage("Do you really want to log out");
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                FirebaseAuth.getInstance().signOut();
                Intent intent=new Intent(getActivity(), LoginWithEmail.class);
                intent.putExtra("some","somedata");
                startActivity(intent);
            }
        });
        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

}