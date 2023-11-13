package com.example.kotlin101

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.kotlin101.ui.theme.Kotlin101Theme
//Affichage de la deuxième page, bouton
class CountryActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OutlinedButton(onClick = {
                val navigate = Intent(this@CountryActivity, MainActivity::class.java)
                startActivity(navigate)
            }) {
                Text(text = "Retour")
            }
        }
    }
}

