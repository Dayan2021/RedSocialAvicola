package com.redsoc.redsocialavicola.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.redsoc.redsocialavicola.R;
import com.redsoc.redsocialavicola.activities.FiltersActivity;

/**
 * A simple {@link Fragment} subclass.

 * create an instance of this fragment.
 */
public class FiltersFragment extends Fragment {

    View mView;
    CardView mCardViewAgr;
    CardView mCardViewAvi;
    CardView mCardViewPor;
    CardView mCardViewPis;


    public FiltersFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_filters, container, false);
        mCardViewAgr = mView.findViewById(R.id.cardViewAgr);
        mCardViewAvi = mView.findViewById(R.id.cardViewAvi);
        mCardViewPor = mView.findViewById(R.id.cardViewPor);
        mCardViewPis= mView.findViewById(R.id.cardViewPis);

        mCardViewAgr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToFilterActivity("AGRICOLA");
            }
        });

        mCardViewAvi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToFilterActivity("AVICOLA");
            }
        });

        mCardViewPor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToFilterActivity("PORCICOLA");
            }
        });

        mCardViewPis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToFilterActivity("PISCICOLA");
            }
        });

        return mView;
    }

    private void goToFilterActivity(String category) {
        Intent intent = new Intent(getContext(), FiltersActivity.class);
        intent.putExtra("category", category);
        startActivity(intent);
    }

    }
