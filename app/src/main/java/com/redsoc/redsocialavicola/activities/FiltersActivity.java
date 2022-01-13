package com.redsoc.redsocialavicola.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.Query;
import com.redsoc.redsocialavicola.R;
import com.redsoc.redsocialavicola.adapters.PostsAdapter;
import com.redsoc.redsocialavicola.models.Post;
import com.redsoc.redsocialavicola.providers.AuthProvider;
import com.redsoc.redsocialavicola.providers.PostProvider;

public class FiltersActivity extends AppCompatActivity {

    String mExtraCategory;

    AuthProvider mAuthProvider;
    RecyclerView mRecyclerView;
    PostProvider mPostProvider;
    PostsAdapter mPostsAdapter;


    TextView mTextViewNumberFilter;
    Toolbar mToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filters);
        mRecyclerView = findViewById(R.id.recyclerViewFilter);
        mToolbar= findViewById(R.id.toolbar);
        mTextViewNumberFilter= findViewById(R.id.textViewNumberFilter);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Filtros");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        mRecyclerView.setLayoutManager(new GridLayoutManager(FiltersActivity.this,2));

        mExtraCategory = getIntent().getStringExtra("category");

        mAuthProvider = new AuthProvider();
        mPostProvider = new PostProvider();

        //Toast.makeText(this, "La categoria que selecciono es " + mExtraCategory, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStart() {
        super.onStart();
        Query query = mPostProvider.getPostByCategoryAndTimestamp(mExtraCategory);
        FirestoreRecyclerOptions<Post> options =
                new FirestoreRecyclerOptions.Builder<Post>()
                        .setQuery(query,Post.class)
                        .build();

        mPostsAdapter = new PostsAdapter(options, FiltersActivity.this,mTextViewNumberFilter);
        mRecyclerView.setAdapter(mPostsAdapter);
        mPostsAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        mPostsAdapter.stopListening();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return true;
    }


}
