package com.codeonwheels.loginapp.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavHostController
import com.codeonwheels.loginapp.Routes
import com.codeonwheels.loginapp.domain.model.SaltUserModel
import com.codeonwheels.loginapp.presentation.viewmodel.LoginViewModel
import kotlinx.coroutines.launch


@Composable
fun Home(
    navController: NavHostController,

) {
    Box(modifier = Modifier.fillMaxSize()){
        HomePage(navController)
    }
}

@Composable
fun HomePage(
    navController: NavHostController,
    viewModel: LoginViewModel = hiltViewModel(),
    ){
    val state = viewModel.state.value

    val lifecycle = LocalLifecycleOwner.current.lifecycle


    LaunchedEffect(key1 = Unit) {
        lifecycle.repeatOnLifecycle(state = Lifecycle.State.STARTED) {
            launch {
                viewModel.getUserLogin("eve.holt@reqres.in", "cityslicka")
            }
        }
    }

    when (state.success) {
        0 -> {}
        1 -> {

        }
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Home")
                }
            )
        }) {
        Box(modifier = Modifier.background(Color.White)) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                ItemList(items = state.loginList)
            }
        }
    }
}

@Composable
fun ItemList(items: List<SaltUserModel.Data>) {
    LazyColumn() {
        items(items) { item ->
            ItemCard(item)
        }
    }
}

@Composable
fun ItemCard(item: SaltUserModel.Data) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
        elevation = 10.dp
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = item.name,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(4.dp)
            )
            Text(
                text = item.color,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(4.dp)
            )
            Text(
                text = item.pantoneValue,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(4.dp)
            )
        }
    }
}


