package com.example.littlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.purvak.littlelemon.R

@Composable
fun LowerPanel() {
    Column {
        WeeklySpecial()
        MenuDish()
    }
}


@Composable
fun WeeklySpecial(){
    // to be defined
//    Inside the WeeklySpecial() composable, add a built-in Card composable. Let it cover the full available width.
//    Inside the Card, add a Text composable with the text "Weekly Special". The font size should be 26 sp and it should be bold. Add a padding of 8 dp.
    Card(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "Weekly Special",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(8.dp)
        )
    }
}


@Composable
fun MenuDish() {
    // to be defined
//    Inside the empty MenuDish() composable, define a Card.
//    Inside the card, add a Row. The Row should cover the full width. Apply a padding of 8 dp to it.
//    Inside the Row, add a Column and an Image.
//    Inside the Column, define the following 3 Text composables:
//    1.	The first text should be "Greek Salad", font size 18 and bold.
//    2.	The second text should be "The famous Greek salad of crispy lettuce, peppers, olives, our Chicago ...". Set the color to gray. Set the top and bottom padding to 5 dp. Set max width to .75f.
//    3.	The third text should be "$12.99". Set the color to gray and bold the font.
//    For the Image composable, load the image from the drawable using painterResource(). Set the content description to "Greek Salad Image".
    Card {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
        ){
            Column {
                Text(
                    text = "Greek Salad",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "The famous greek salad of " +
                            "crispy lettuce, peppers, olives, " +
                            "our Chicago ...",
                    color = Color.Gray,
                    modifier = Modifier
                        .padding(top = 5.dp, bottom = 5.dp)
                        .fillMaxWidth(.75f)
                )
                Text(
                    text = "$12.99",
                    color = Color.Gray,
                    fontWeight = FontWeight.Bold
                )
            }
            Image(
                painter = painterResource(
                    id = R.drawable.greeksalad),
                contentDescription = "",
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LowerPanelPreview(){
    LowerPanel()
}
