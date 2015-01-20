package bsara.android.tv.reboot;



import android.os.Bundle;



public class QuickRebootActivity extends RebootBaseActivity {

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this.reboot();
  }
}