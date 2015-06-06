package io.github.bsara.android.tv.reboot;



import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;



public class AboutActivity extends Activity {

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    this.setContentView(R.layout.activity_about);

    try {
      TextView versionView = (TextView)this.findViewById(R.id.about_version);
      versionView.setText(String.format(versionView.getText().toString(), this.getPackageManager().getPackageInfo(this.getPackageName(), 0).versionName));
    } catch (PackageManager.NameNotFoundException e) {
      Log.e(AboutActivity.class.getName(), "Setting Version Number", e);
    }
  }


  public void showLicense(View v) {
    this.startActivity(new Intent(this, LicenseActivity.class));
  }
}
