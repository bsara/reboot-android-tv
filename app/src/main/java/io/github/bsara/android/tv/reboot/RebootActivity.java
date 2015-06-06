package io.github.bsara.android.tv.reboot;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;



public class RebootActivity extends RebootBaseActivity {

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this.setContentView(R.layout.activity_reboot);
  }


  public void execAction(View selectedView) {
    switch (selectedView.getId()) {
      case R.id.main_actionItem_reboot:
        this.reboot();
        break;
      case R.id.main_actionItem_rebootBootloader:
        this.rebootBootloader();
        break;
      case R.id.main_actionItem_rebootRecovery:
        this.rebootRecovery();
        break;
      case R.id.main_actionItem_settings:
        this.openSettings();
        break;
      case R.id.main_actionItem_about:
        this.openAbout();
        break;
      default:
        this.finish();
        break;
    }
  }


  private void openSettings() {
    //this.startActivity(new Intent(this, PreferencesActivity.class));
  }


  private void openAbout() {
    this.startActivity(new Intent(this, AboutActivity.class));
  }
}
