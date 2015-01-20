package bsara.android.tv.reboot;



import java.io.IOException;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;



public abstract class RebootBaseActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // TODO: Add check for super user privileges! Exit if none are found!!!
  }


  protected void reboot() {
    this.reboot(RebootType.NORMAL);
  }


  protected void rebootBootloader() {
    this.reboot(RebootType.BOOTLOADER);
  }


  protected void rebootRecovery() {
    this.reboot(RebootType.RECOVERY);
  }


  private void reboot(final RebootType type) {
    new AlertDialog.Builder(this)
        .setTitle(R.string.app_name)
        .setMessage(R.string.dialog_rebootVerification_msg)
        .setNegativeButton(R.string.dialog_rebootVerification_negativeButton, new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {
            RebootBaseActivity.this.finish();
          }
        })
        .setPositiveButton(R.string.dialog_rebootVerification_positiveButton, new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {
            RebootBaseActivity.this.execReboot(type);
          }
        })
        .create()
        .show();
  }


  private void execReboot(RebootType type) {
    String rebootCmd;

    switch (type) {
      case BOOTLOADER:
        rebootCmd = "bootloader";
        break;
      case RECOVERY:
        rebootCmd = "recovery";
        break;
      default:
        rebootCmd = "now";
        break;
    }

    try {
      Runtime.getRuntime().exec(new String[] { "su", "-c", String.format("reboot %s", rebootCmd) });
    } catch (IOException e) {
      Log.e(RebootBaseActivity.class.getName(), "Reboot Error!", e);
      Toast.makeText(this, R.string.errMsg_rebootError, Toast.LENGTH_SHORT).show();
    }

    this.finish();
  }



  private enum RebootType {
    NORMAL,
    BOOTLOADER,
    RECOVERY
  }
}