package com.example.myappportfolio;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView list = findViewById(R.id.recyclerView_projects);

//        Project project1 = new Project(
//                "Spotify Streamer",
//                "A music streaming app that allows users to search for artists, albums, and tracks.",
//                5);

        Project[] projects = {
                new Project("Spotify Streamer", "A music streaming app that allows users to search for artists, albums, and tracks.", R.drawable.getting_started),
                new Project("Super Duper Quiz", "A quiz app that tests your knowledge on various topics with multiple-choice questions.", R.drawable.quote),
                new Project("Library App", "An app that helps users manage their book collections, including borrowing and returning books.", R.drawable.calculator),
                new Project("Build It Bigger", "An app that provides users with construction challenges and allows them to build virtual structures.", R.drawable.tape),
                new Project("Capstone Project", "A comprehensive project that showcases all the skills learned in the course.", R.drawable.hungry_developer),
                new Project("XYZ Reader", "An app that allows users to read and manage their favorite articles and blogs.", R.drawable.xyz_reader)
        };

        ProjectsAdapter adapter = new ProjectsAdapter(projects);
        list.setAdapter(adapter);
    }
}