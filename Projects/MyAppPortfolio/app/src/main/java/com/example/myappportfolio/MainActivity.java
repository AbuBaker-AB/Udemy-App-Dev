package com.example.myappportfolio;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Project project1 = new Project(
                "Spotify Streamer",
                "A music streaming app that allows users to search for artists, albums, and tracks.",
                5);

        Project[] projects = {
                new Project("Spotify Streamer", "A music streaming app that allows users to search for artists, albums, and tracks.", 5),
                new Project("Super Duper Quiz", "A quiz app that tests your knowledge on various topics with multiple-choice questions.", 6),
                new Project("Library App", "An app that helps users manage their book collections, including borrowing and returning books.", 7),
                new Project("Build It Bigger", "An app that provides users with construction challenges and allows them to build virtual structures.", 8),
                new Project("XYZ Reader", "An e-book reader app that supports various formats and provides a smooth reading experience.", 9),
                new Project("Capstone Project", "A comprehensive project that showcases all the skills learned in the course.", 10)
        };
    }
}