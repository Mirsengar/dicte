package contagiouscode.mirsengar.dicte.presentation.main

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import contagiouscode.mirsengar.dicte.presentation.bookmark.BookmarkScreen
import contagiouscode.mirsengar.dicte.presentation.bookmark.BookmarkViewModel
import contagiouscode.mirsengar.dicte.presentation.history.HistoryScreen
import contagiouscode.mirsengar.dicte.presentation.history.HistoryViewModel
import contagiouscode.mirsengar.dicte.presentation.home.HomeScreen
import contagiouscode.mirsengar.dicte.presentation.home.WordModelViewModel
import contagiouscode.mirsengar.dicte.presentation.navigation.NavScreen
import kotlinx.coroutines.InternalCoroutinesApi

@ExperimentalMaterialApi
@InternalCoroutinesApi
@ExperimentalUnitApi
@ExperimentalComposeUiApi
@Composable
fun MainScreen(
    navController: NavHostController,
    scaffoldState: ScaffoldState,
    toggleTheme: () -> Unit
) {
    val wordViewModel: WordModelViewModel = hiltViewModel()
    val bookmarkViewModel: BookmarkViewModel = hiltViewModel()
    val historyViewModel: HistoryViewModel = hiltViewModel()
    NavHost(
        navController = navController,
        startDestination = "${NavScreen.HomeScreen.route}?wordIndex={wordIndex}?bookmark={bookmark}"
    ) {
        composable(
                  route = "${NavScreen.HomeScreen.route}?wordIndex={wordIndex}?bookmark={bookmark}" ,
                  arguments = listOf(
                navArgument("wordIndex") {
                    type = NavType.IntType
                    defaultValue = -1
                },
                navArgument("bookmark") {
                    type = NavType.BoolType
                    defaultValue = true
                }
            )
        ) {
            HomeScreen(
                scaffoldState,
                it.arguments?.getInt("wordIndex", -1),
                it.arguments?.getBoolean("bookmark", true),
                wordViewModel, bookmarkViewModel, historyViewModel,
                onToggleTheme = toggleTheme
            )
        }

        composable(route = NavScreen.BookmarkScreen.route) {
            BookmarkScreen(bookmarkViewModel) { index ->
                navController.navigate("${NavScreen.HomeScreen.route}?wordIndex=$index?bookmark=${true}") {
                    launchSingleTop = true
                }
            }
        }

        composable(route = NavScreen.HistoryScreen.route) {
            HistoryScreen(historyViewModel) { index ->
                navController.navigate("${NavScreen.HomeScreen.route}?wordIndex=$index?bookmark=${false}") {
                    launchSingleTop = true
                }
            }
        }
    }
}
