package com.fauzana0133.assesmentmobpro3.screen

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.fauzana0133.assesmentmobpro3.viewmodel.UserSession
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(onLoginSuccess: () -> Unit) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val userSession = remember { UserSession(context) }

    val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        .requestEmail()
        .requestIdToken("900941361983-ospscnkqapd7g2nuhq3n2al85fdi1c3c.apps.googleusercontent.com")
        .build()

    val googleSignInClient = GoogleSignIn.getClient(context, gso)

    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
        try {
            val account = task.getResult(ApiException::class.java)
            account?.let {
                println("✅ Login Google sukses: ${it.displayName}")
                scope.launch {
                    userSession.saveUser(
                        it.displayName ?: "",
                        it.email ?: "",
                        it.photoUrl.toString()
                    )
                    kotlinx.coroutines.delay(200) // pastikan data tersimpan
                    onLoginSuccess()
                }
            }
        } catch (e: ApiException) {
            e.printStackTrace()
            println("❌ Gagal login: ${e.message}")
        }
    }

    Scaffold { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentAlignment = Alignment.Center
        ) {
            Button(onClick = {
                val signInIntent = googleSignInClient.signInIntent
                launcher.launch(signInIntent)
            }) {
                Text("Sign in with Google")
            }
        }
    }
}


