package dietbisabesok.com.bukanitip.ui.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;

public abstract class ViewPresenter<V extends View> {
    private V view = null;


    /**
     * Load has been called for the current {@link #view}.
     */
    private boolean loaded;

    /**
     * Recommend to call in when activity reaches onStart()
     * @param view
     */
    public final void takeView(V view) {
        if (view == null) {
            throw new NullPointerException("new view must not be null");
        }

        if (this.view != view) {
            if (this.view != null) {
                dropView(this.view);
            }

            this.view = view;
            if (getView() != null && !loaded) {
                loaded = true;
                onLoad();
            }
        }
    }

    /**
     * Recommend to call in when activity reaches onDestroy()
     * @param view
     */
    public void dropView(V view) {
        if (view == null) {
            throw new NullPointerException("dropped view must not be null");
        }
        if (view == this.view) {
            loaded = false;
            this.view = null;
            onDestroy();
        }
    }

    public final V getView() {
        return view;
    }

   protected void onLoad(){

   }

    protected void onDestroy() {
    }

    protected void onRestore(@NonNull Bundle savedInstanceState) {
    }

    protected void onSave(@NonNull Bundle outState) {
    }

    public void onResume() {

    }

    public void onPause() {

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {

    }
}
