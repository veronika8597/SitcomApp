package com.example.sitcomapplication

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.sitcomapplication.ui.theme.SitcomApplicationTheme

val grouped = charactersList.groupBy { it.showName }

class MainActivity : ComponentActivity() {

    private val charactersList = mutableListOf<CharacterModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SitcomApplicationTheme{

                CharactersRows(charactersList)
                }

            }

        }
    }


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CharactersRows(charactersList: List<CharacterModel>){
    LazyColumn(){
        grouped.forEach{
            (year, charactersInYear) ->
            stickyHeader {
                Text(year,
                fontSize = 28.sp,
                color = colorResource(id = R.color.white),
                modifier = Modifier
                    .fillMaxSize()
                    .background(colorResource(id = R.color.purple_700))
                    .padding(all = 12.dp))
            }

            items(charactersInYear){character ->
                MyListItem(character)
            }
        }

    }
}


@Composable
fun MyListItem(model: CharacterModel) {

    val context = LocalContext.current
    val channelId = "Channel_1"

    CreateNotificationChannel(context, channelId)

    Card(
        Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable {
                ShowNotification(
                    context,
                    channelId,
                    title = "Item Clicked",
                    message = "You clicked on ${model.fullName}"
                )
            },
        shape = RoundedCornerShape(10.dp),
        elevation = 5.dp) {

        Row(verticalAlignment = Alignment.CenterVertically) {

            Image(painter = painterResource(id = model.image),
                contentDescription = "character image",
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(110.dp)
            )

            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = model.fullName,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}


@Composable
fun CreateNotificationChannel(context: Context, channelId: String){

    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
        val name = "Channel_1"
        val descriptionText = "Example notification channel"
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channel = NotificationChannel(channelId, name, importance).apply {
            description = descriptionText
            enableLights(true)
        }

        val notificationManager = context.getSystemService(NotificationManager::class.java)
        notificationManager.createNotificationChannel(channel)
    }
}


fun ShowNotification(context: Context, channelId: String, title: String, message: String){
    val builder = NotificationCompat.Builder(context, channelId)
        .setSmallIcon(R.drawable.ic_launcher_foreground)
        .setContentTitle(title)
        .setContentText(message)
        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        .setAutoCancel(true)

    with(NotificationManagerCompat.from(context)){
        notify(1, builder.build())
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SitcomApplicationTheme {
        CharactersRows(charactersList)
    }
}


