package com.example.c13103a1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.c13103a1.ui.theme.C13103A1Theme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.foundation.shape.RoundedCornerShape
import java.nio.file.WatchEvent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            C13103A1Theme {
                BakeryRevenueScreen()
            }
        }
    }
}

// Challenge 3 Session 1
@Composable
fun BakeryRevenueScreen() {
    val currencySymbol = "$"
    var cookiesSold by remember { mutableStateOf("") }
    var cookiePrice by remember { mutableStateOf("") }
    // Challenge 6 Session 1
    var muffinsSold by remember { mutableStateOf("") }
    var muffinPrice by remember { mutableStateOf("") }
    var cakesSold by remember { mutableStateOf("") }
    var cakePrice by remember { mutableStateOf("") }
    // DATA STRUCTURE
    val bakeryItems = remember { mutableStateListOf<BakeryItem>() }
    var totalRevenue by remember { mutableDoubleStateOf(0.0) }
    var bestSellingItem by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "\uD83E\uDDc1 Bakery Sales",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF30243f),
//            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(top = 16.dp)
        )

        Text(
            text = "Enter the sales information for each product.",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray,
            modifier = Modifier.padding(top = 8.dp, bottom = 16.dp)
        )

        // Challenge 7 Session 1
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFE5E9EE)
            ),
            elevation = CardDefaults.cardElevation(2.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "\uD83C\uDF6A Cookies",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF30243F)
                )

                Spacer(modifier = Modifier.height(6.dp))

                OutlinedTextField(
                    value = cookiesSold,
                    onValueChange = { cookiesSold = it },
                    label = { Text("Cookies sold") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = cookiePrice,
                    onValueChange = { cookiePrice = it },
                    label = { Text("Price per cookie") },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFE5E9EE)
            ),
            elevation = CardDefaults.cardElevation(2.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Muffins",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF30243F)
                )

                Spacer(modifier = Modifier.height(6.dp))

                // Challenge 8 Session 1
                OutlinedTextField(
                    value = muffinsSold,
                    onValueChange = { muffinsSold = it },
                    label = { Text("Muffins sold") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = muffinPrice,
                    onValueChange = { muffinPrice = it },
                    label = { Text("Price per muffin") },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFE5E9EE)
            ),
            elevation = CardDefaults.cardElevation(2.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Cakes",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF30243F)
                )

                Spacer(modifier = Modifier.height(6.dp))

                // Challenge 9 Session 1
                OutlinedTextField(
                    value = cakesSold,
                    onValueChange = { cakesSold = it },
                    label = { Text("Cakes sold") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = cakePrice,
                    onValueChange = { cakePrice = it },
                    label = { Text("Price per cake") },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    BakeryRevenueScreen()
}