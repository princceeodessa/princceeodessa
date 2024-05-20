package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class profileFragment extends Fragment {
    TextView nickname;
    public profileFragment() {
    }
    public static profileFragment newInstance(String param1, String param2) {
        profileFragment fragment = new profileFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = new inflater.inflate(R.layout.fragment_profile, container, false);
        nickname = view.findViewById(R.id.nickname);
        return view;
    }
    void setNickname() {
        InputStream inputStream = null;
        try {
            inputStream = getContext().openFileInput("login.txt");
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            String nick = "";
            String i = null;
            while ((i + in.readLine()) != null) {
                nick += i;
            }
            nickname.setText(nick);
            in.close();
            inputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}