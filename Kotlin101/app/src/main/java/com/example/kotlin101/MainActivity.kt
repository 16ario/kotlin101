package com.example.kotlin101

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
//Main Activity appel les donnée et les affiches
class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_main)
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragment) as NavHostFragment
        navController = navHostFragment.navController

        setContent {
            Surface(color = MaterialTheme.colors.background) { PrincipalCard() }
        }
        @Composable
        fun CardBox() {
            val mainViewModel: MainViewModel by this.viewModels()
            mainViewModel.getCountryList()
            PrincipalCard()
        }

        @Composable
        fun Item(name: String) {
            Surface(
                color = MaterialTheme.colors.primary,
                modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
            ) {


                Column(
                    modifier = Modifier
                        .padding(24.dp)
                        .fillMaxWidth()
                ) {

                    Row {

                        Column(
                            modifier = Modifier
                                .weight(1f)
                        ) {
                            Text(text = "Course")
                            Text(
                                text = name, style = MaterialTheme.typography.h4.copy(
                                    fontWeight = FontWeight.ExtraBold
                                )
                            )
                        }

                        OutlinedButton(onClick = { /*TODO*/ }) {
                            Text(text = "Show more")
                        }
                    }

                }

            }
        }
    //Aurait du nous permettre de afficher les pays card par card
        @Composable
        fun RecyclerView(names: List<String> = List(10) { "$it" }) {
            LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {

                items(items = names) { name ->
                    Item(name = name)
                }
            }
        }
    }
//Fonction/composant permettant de faire l'affichage de notre page principale
    @Composable
    fun PrincipalCard() {
        val mainViewModel: MainViewModel by this.viewModels()
        mainViewModel.getCountryList()
        Card(
            modifier = Modifier.padding(16.dp),
            elevation = 5.dp,
            shape = RoundedCornerShape(corner = CornerSize(10.dp))
        ) {
            Row(
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                LazyColumn {
                    items(mainViewModel.countryListResponse.size) { index ->
                        val country: Country = mainViewModel.countryListResponse[index]
                        Row {
                            Text(text = country.flag, Modifier)
                            Text(text = country.name.common, style = MaterialTheme.typography.h5)
                            Text(text = country.continents.joinToString(separator = ", "))
                        }
                        OutlinedButton(onClick = {
                            val navigate = Intent(this@MainActivity, CountryActivity::class.java)
                            startActivity(navigate)
                        }) {
                            Text(text = "Voir plus")
                        }

                    }
                }
            }
        }
    }
}
