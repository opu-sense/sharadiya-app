package com.sharadiya.app;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.getcapacitor.BridgeActivity;

public class MainActivity extends BridgeActivity {
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // Songs: allow next song to start automatically without a tap
    getBridge().getWebView().getSettings().setMediaPlaybackRequiresUserGesture(false);

    // Keep the app below the status bar and above the navigation bar
    View content = findViewById(android.R.id.content);
    content.setBackgroundColor(Color.parseColor("#120c11"));
    ViewCompat.setOnApplyWindowInsetsListener(content, (v, insets) -> {
      Insets bars = insets.getInsets(
          WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout());
      v.setPadding(bars.left, bars.top, bars.right, bars.bottom);
      return WindowInsetsCompat.CONSUMED;
    });
    ViewCompat.requestApplyInsets(content);
  }
}
