package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.data.local.UserPreferencesRepository
import com.example.notifications.NotificationHelper
import com.example.notifications.ReminderScheduler
import com.example.ui.DrawingAcademyApp
import com.example.viewmodel.AcademyViewModel
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val academyViewModel: AcademyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        NotificationHelper.createChannels(applicationContext)
        lifecycleScope.launch {
            val prefs = UserPreferencesRepository(applicationContext).getPreferencesOnce()
            ReminderScheduler.scheduleAll(applicationContext, prefs)
        }

        setContent {
            DrawingAcademyApp(viewModel = academyViewModel)
        }
    }
}
