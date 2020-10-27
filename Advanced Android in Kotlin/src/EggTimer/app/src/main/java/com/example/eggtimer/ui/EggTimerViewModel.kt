package com.example.eggtimer.ui

import android.app.AlarmManager
import android.app.Application
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.eggtimer.R
import com.example.eggtimer.receiver.AlarmReceiver
import com.example.eggtimer.util.cancelNotifications
import com.example.eggtimer.util.sendNotification

class EggTimerViewModel(private val app: Application) : AndroidViewModel(app) {

    private val REQUEST_CODE = 0
    private val TRIGGER_TIME = "TRIGGER_AT"

    private val minute: Long = 60_000L
    private val second: Long = 1_000L

//    private val timerLengthOptions: IntArray
//    private val notifyPendingIntent: PendingIntent

    private val alarmManager = app.getSystemService(Context.ALARM_SERVICE) as AlarmManager
    private var prefs =
        app.getSharedPreferences("com.example.android.eggtimernotifications", Context.MODE_PRIVATE)
    private val notifyIntent = Intent(app, AlarmReceiver::class.java)

    // MutableLiveData: 변경할 수 있는 LiveData 형, 데이터를 UI Thread와 Background Thread에서 선택적으로 바꿀 수 있음.
    //일반적인 LiveData: 변경할 수 없고 오로지 데이터의 변경값만을 소비
    private val _timeSelection = MutableLiveData<Int>()
    val timeSelection: LiveData<Int>
        get() = _timeSelection

    private val _elapsedTime = MutableLiveData<Long>()
    val elapsedTime: LiveData<Long>
        get() = _elapsedTime

    private var _alarmOn = MutableLiveData<Boolean>()
    val isAlarmOn: LiveData<Boolean>
        get() = _alarmOn


    private fun startTimer(timerLengthSelection: Int) {
        // TODO: Step 1.5 get an instance of NotificationManager
        // and call sendNotification
        // 타이머를 시작하자마자 사용자에게 알림이 가게 함. -> 계란이 다 익으면 알림 주면되니 주석처리

//        val notificationManager = ContextCompat.getSystemService(
//            app,
//            NotificationManager::class.java
//        ) as NotificationManager
//        notificationManager.sendNotification(app.getString(R.string.timer_running), app)

        //TODO Step 1.15 call cancel notification
        val notificationManager =
            ContextCompat.getSystemService(
                app,
                NotificationManager::class.java
            ) as NotificationManager
        notificationManager.cancelNotifications()
    }



}