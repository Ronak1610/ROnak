package com.example.ronak

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.AbsoluteCutCornerShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp

import com.example.ronak.ui.theme.ROnakTheme
import androidx.compose.material3.Surface as Surface1

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ROnakTheme {
                // A surface container using the 'background' color from the theme
               Art_space_app()
            }
        }
    }
}

@Suppress("KotlinConstantConditions")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Art_space_app()
{
    var  state by remember {
        mutableIntStateOf(1)
    }
    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(
                title ={
                    Text(text = "Japan 日本 ")
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = colorScheme.primaryContainer,
                    titleContentColor = colorScheme.primary,
                    navigationIconContentColor = colorScheme.onSecondary,
                    actionIconContentColor = colorScheme.secondary
                )
            )

        }

    )

    {
            innerpadding ->
        Surface1(
            modifier = Modifier
                .padding(innerpadding)
                .fillMaxSize()
                .background(colorScheme.background)
                .verticalScroll(rememberScrollState())
        ){
//Logic

         when(state)

         {
             1 ->
             {
                 Layout(
                     ImageSource = R.drawable.tokyotower,
                     Name = R.string.tokyo_tower,
                     year = R.string.dob,
                     founder = R.string.crator,
                     onPrevCick = {  },
                     onNextCick = {state=2})


             }
             2 ->
             {
                 Layout(
                     ImageSource = R.drawable.skytree,
                     Name = R.string.skytree,
                     year = R.string.dob1,
                     founder = R.string.Creator,
                     onPrevCick = { state=1 },
                     onNextCick = {state=3 },
                     modifier = Modifier)
                     

             }
             3 ->
             {
                 Layout(
                     ImageSource = R.drawable.dottonobori,
                     Name = R.string.dottonobori,
                     year = R.string.dob2,
                     founder = R.string.founder,
                     onPrevCick = { state=2 },
                     onNextCick = {state=4})


             }
             else ->
             {
Layout(ImageSource = R.drawable.osakacastle,
    Name = R.string.Osaka_Castle,
    year = R.string.dob3, founder =R.string.cReatore
    , onPrevCick = {state=3},
    onNextCick = {state=1}
)


             }
         }

        }
    }
}
@Composable
fun Layout(modifier: Modifier=Modifier,ImageSource : Int,Name:Int,year:Int,founder :Int,onPrevCick :() -> Unit,onNextCick :() -> Unit)
{
Column (modifier= Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally)
{
   Surface(shadowElevation = 9.dp,
    modifier = Modifier.background(Color.Yellow)
) {
    Image(painter = painterResource(id = ImageSource),
        contentDescription = null ,
        modifier = Modifier
            .height(350.dp)
            .width(350.dp)
            .padding(10.dp))
    Spacer(modifier = Modifier.padding(20.dp))

}
    Spacer(modifier = Modifier.padding(20.dp))
    Column(horizontalAlignment = Alignment.CenterHorizontally
        ,modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(20.dp)
    ) {
Text(stringResource(id = Name))
        Text(text = stringResource(id = year))
        Text(text = stringResource(id = founder))
    }
    Spacer(modifier = Modifier.padding(20.dp))
    Row (verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween){
        Button(onClick = { onPrevCick },shape = CutCornerShape(10.dp), colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.onPrimaryContainer)) {
            Text(text = "Previous")
        }
        Spacer(modifier = Modifier.padding(20.dp))
        Button(onClick = { onNextCick}, shape = CutCornerShape(10.dp), colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.onPrimaryContainer)) {
            Text(text = "Next")
        }
    }
}
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ROnakTheme {
Art_space_app()
    }
}