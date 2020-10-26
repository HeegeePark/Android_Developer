package com.example.eggtimer.util

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import com.example.eggtimer.MainActivity
import com.example.eggtimer.R

//NotificationUtils.kt

// Notification ID.
private val NOTIFICATION_ID = 0
private val REQUEST_CODE = 0
private val FLAGS = 0

// TODO: Step 1.1 extension function to send messages (GIVEN)
/**
 * Builds and delivers a notification.
 *
 * @param messageBody, notification text.
 * @param context, activity context.
 */
fun NotificationManager.sendNotification(messageBody: String, applicationContext: Context) {
    // TODO: Step 1.2 get an instance of NotificationCompat.Builder
    val builder = NotificationCompat.Builder(
        applicationContext,
        applicationContext.getString(R.string.egg_notification_channel_id)
    )

     // TODO: Step 1.3 set title, text and icon to builder
     .setSmallIcon(R.drawable.cooked_egg)
     .setContentTitle(applicationContext.getString(R.string.notification_title))
     .setContentText(messageBody)

}

