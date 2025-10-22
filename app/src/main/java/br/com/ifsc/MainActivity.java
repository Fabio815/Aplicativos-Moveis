package br.com.ifsc;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    PackageManager pm;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);

        pm = getPackageManager();
        List<ApplicationInfo> apps = new ArrayList<>();//pm.getInstalledApplications(PackageManager.GET_META_DATA);
        Intent iquery = new Intent(Intent.ACTION_MAIN, null);
        iquery.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> listResolveInfo = pm.queryIntentActivities(iquery, PackageManager.GET_META_DATA);
        for (ResolveInfo resolveInfo : listResolveInfo) {
            apps.add(resolveInfo.activityInfo.applicationInfo);
        }

        //precisa do this(contexto) para acessar a skia.
        AppAdapter adapter = new AppAdapter(this, R.layout.app, apps);
        listView.setAdapter(adapter);

    }
}