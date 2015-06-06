package io.github.bsara.android.tv.reboot;



import android.os.Bundle;
import android.preference.PreferenceActivity;



public class PreferencesActivity extends PreferenceActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this.addPreferencesFromResource(R.xml.preferences);
  }
}
