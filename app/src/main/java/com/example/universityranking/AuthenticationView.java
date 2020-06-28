package com.example.universityranking;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AuthenticationView extends Fragment {

    private FirebaseAuth mAuth;
    EditText login;
    EditText password;
    Button signIn;
    ImageView image;

    public AuthenticationView() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_authentication_view, container, false);
        FirebaseUser currentUser = mAuth.getCurrentUser();
        login = view.findViewById(R.id.loginSignIn);
        password = view.findViewById(R.id.passwordSignIn);
        signIn = view.findViewById(R.id.button_sign_in);
        image = view.findViewById(R.id.imageView_reg);

        Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.translate);

        image.startAnimation(animation);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn(login.getText().toString(), password.getText().toString());
            }
        });

        return view;
    }

    private void signIn(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d("SING_IN", "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                        } else {
                            Log.w("SIGN_IN", "signInWithEmail:failure", task.getException());
                            Toast.makeText(getActivity().getApplicationContext(), "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
    }
}
