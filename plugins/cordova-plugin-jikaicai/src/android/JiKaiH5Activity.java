/*
       Licensed to the Apache Software Foundation (ASF) under one
       or more contributor license agreements.  See the NOTICE file
       distributed with this work for additional information
       regarding copyright ownership.  The ASF licenses this file
       to you under the Apache License, Version 2.0 (the
       "License"); you may not use this file except in compliance
       with the License.  You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

       Unless required by applicable law or agreed to in writing,
       software distributed under the License is distributed on an
       "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
       KIND, either express or implied.  See the License for the
       specific language governing permissions and limitations
       under the License.
 */

package com.zhongti.h5;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

import org.apache.cordova.*;

public class JiKaiH5Activity extends CordovaActivity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();

        // enable Cordova apps to be started in the background
        Bundle extras = intent.getExtras();
        if (extras != null && extras.getBoolean("cdvStartInBackground", false)) {
            moveTaskToBack(true);
        }

        String userId = "";
        if (extras != null) {
            userId = extras.getString("userId", "");
        }
        String appKey = "";

        try {
            ApplicationInfo appInfo = this.getPackageManager()
              .getApplicationInfo(this.getPackageName(), 
                PackageManager.GET_META_DATA);
            appKey =  appInfo.metaData.getString("JIKAI_APPKEY");

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        String siteUrl = launchUrl + "?appkey=" + appKey + "&userid=" + userId;

        Log.e(TAG, "siteUrl=" + siteUrl);
        // Set by <content src="index.html" /> in config.xml
        loadUrl(siteUrl);
    }
}