package pmoschos.nicebottomnavbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationBarView;

import pmoschos.nicebottomnavbar.databinding.ActivityMainBinding;
import pmoschos.nicebottomnavbar.fragments.FavoriteFragment;
import pmoschos.nicebottomnavbar.fragments.ProfileFragment;
import pmoschos.nicebottomnavbar.fragments.SearchFragment;
import pmoschos.nicebottomnavbar.fragments.TranslateFragment;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        replaceFragment(new SearchFragment());

        activityMainBinding.bottomNavigationView.setOnItemSelectedListener(item -> {
           if (item.getItemId() == R.id.search) {
                replaceFragment(new SearchFragment());
           } else if (item.getItemId() == R.id.translate) {
               replaceFragment(new TranslateFragment());
           } else if (item.getItemId() == R.id.favorite) {
               replaceFragment(new FavoriteFragment());
           } else if (item.getItemId() == R.id.profile) {
               replaceFragment(new ProfileFragment());
           }

           return true;
        });

    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }
}