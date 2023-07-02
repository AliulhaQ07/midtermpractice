package com.example.midtermpractice;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link listfragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class listfragment extends ListFragment {

    public interface ContactSelected
    {
        public void contactClick(int index);
    }


    ContactSelected parent;

    public listfragment()
    {
    }




}