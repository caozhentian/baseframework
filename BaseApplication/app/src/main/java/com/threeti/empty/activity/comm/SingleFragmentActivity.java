package com.threeti.empty.activity.comm;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.threeti.empty.R;

/**
 * Created by Administrator on 2017/6/15.
 */

 public abstract class SingleFragmentActivity extends AppCompatActivity {

    public static final String ARGS_TITLE         =  "title"       ;

    private String     mTitle      ;

    protected abstract Fragment createFragment();

    protected int getLayoutResId() {
        return R.layout.act_single_fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        initTitle() ;
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fl_single_fragment_container);

        if (fragment == null) {
            fragment = createFragment();
            fm.beginTransaction().add(R.id.fl_single_fragment_container, fragment)
                    .commit();
        }
    }

    private void initTitle(){
        mTitle = getIntent().getStringExtra(ARGS_TITLE) ;
    }
}
