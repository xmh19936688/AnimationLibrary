package com.xmh.animingoujianwithtransition;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by mengh on 2016/1/27 027.
 */
public class MainFragment extends Fragment{
    
    private Scene sceneOff;
    private Scene sceneOn;

    private boolean isOn=false;

    @Bind(R.id.fl_scene_root)ViewGroup viewSceneRoot;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main,container,false);
        assert view!=null;
        ButterKnife.bind(this, view);

        initScene();

        return view;
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    private void initScene() {
        sceneOff=Scene.getSceneForLayout(viewSceneRoot,R.layout.scene_off,getActivity());
        sceneOn=Scene.getSceneForLayout(viewSceneRoot,R.layout.scene_on,getActivity());
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @OnClick(R.id.btn_go)
    void onGoClick(View view){
        if(isOn){
            TransitionManager.go(sceneOff);
        }else {
            TransitionManager.go(sceneOn);
        }
        isOn=!isOn;
    }
}
