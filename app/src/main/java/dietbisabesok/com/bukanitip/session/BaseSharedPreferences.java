package dietbisabesok.com.bukanitip.session;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Ibnu Muzzakkir on 11/12/2016.
 * Contact ibnumuzzaakkir@gmail.com
 * scoproject
 */

public abstract class BaseSharedPreferences {

    protected SharedPreferences m_settings;

    protected abstract Context __getApplicationContext();


    public void check() {
        if (m_settings == null) {
            Context context = __getApplicationContext();
            m_settings = context.getSharedPreferences(_getUserProfileName(), 0);
        }
    }

    protected String _getUserProfileName() {
        return "";
    }

    public void _unset(String tag) {
        SharedPreferences.Editor editor = m_settings.edit();
        editor.remove(tag);
        editor.apply();
    }

    public boolean _getBoolean(String tag, boolean b) {
        return m_settings.getBoolean(tag, b);
    }

    public void _setBoolean(String tag, boolean b) {
        SharedPreferences.Editor editor = m_settings.edit();
        editor.putBoolean(tag, b);
        editor.apply();
    }

    public float _getFloat(String tag, float def) {
        return m_settings.getFloat(tag, def);
    }

    public void _setFloat(String tag, float f) {
        SharedPreferences.Editor editor = m_settings.edit();
        editor.putFloat(tag, f);
        editor.apply();
    }

    public String _getString(String tag, String defaultStr) {
        return m_settings.getString(tag, defaultStr);
    }

    public void _setString(String tag, String valueStr) {
        SharedPreferences.Editor editor = m_settings.edit();
        editor.putString(tag, valueStr);
        editor.apply();
    }

    public int _getInt(String tag, int defaultVal) {
        return m_settings.getInt(tag, defaultVal);
    }


    public void _setInt(String tag, int val) {
        SharedPreferences.Editor editor = m_settings.edit();
        editor.putInt(tag, val);
        editor.apply();
    }

    public long _getLong(String tag, long defaultVal) {
        return m_settings.getLong(tag, defaultVal);
    }


    public void _setLong(String tag, long val) {
        SharedPreferences.Editor editor = m_settings.edit();
        editor.putLong(tag, val);
        editor.apply();
    }

    public void _clear() {
        SharedPreferences.Editor editor = m_settings.edit();
        editor.clear();
        editor.apply();
    }

}
