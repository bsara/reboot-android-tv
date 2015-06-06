package io.github.bsara.android.tv.reboot;



import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;



public class LicenseActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);


    this.setContentView(R.layout.activity_license);


    WebView webView = (WebView)this.findViewById(R.id.license_webView);
    webView.getSettings().setJavaScriptEnabled(true);
    webView.setWebViewClient(new WebViewClient() {
      @Override
      public void onLoadResource(WebView view, String url) {
        if (!url.startsWith(LicenseActivity.this.getString(R.string.activity_license_url_domain))) {
          LicenseActivity.this.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
          return;
        }
        super.onLoadResource(view, url);
      }
    });
    webView.loadUrl(this.getString(R.string.activity_license_url));
  }
}
