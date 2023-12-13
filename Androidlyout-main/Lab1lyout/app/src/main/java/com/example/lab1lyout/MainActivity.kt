package com.example.lab1lyout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab1lyout.ui.theme.Lab1lyoutTheme

data class  Person(val name:String,
                   val studentID:String,
                   val imageID:Int)



class MainActivity : ComponentActivity() {
    var persons: List<Person> = listOf<Person>(
        Person("นายก้องภพ ตาดี","643450321-2",R.drawable.model),
        Person("นายธนบดี สวัสดี","643450325-4",R.drawable.teammy),
        Person("นายปรเมศวร์ สิทธิมงคล","643450078-5",R.drawable.make),
        Person("นายอภิทุน ดวงจันทร์คล้อย","643450092-1",R.drawable.pond),
        Person("นายรัตพงษ์ ปานเจริญ","643450650-3",R.drawable.tey),
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab1lyoutTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background)
                {
                    LazyColumn(){
                        items(persons){
                            data -> PersonListItem(data)
                        }
                    }
                }
            }
        }
    }
}
@Composable
fun PersonListItem(data:Person){
    Row(){

        Image(
            painter = painterResource(data.imageID),
            contentDescription = data.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
        )

        Column(modifier = Modifier.padding(4.dp),
            verticalArrangement = Arrangement.Center){

            Text(data.name)
            Text(data.studentID)
        }
    }


}




