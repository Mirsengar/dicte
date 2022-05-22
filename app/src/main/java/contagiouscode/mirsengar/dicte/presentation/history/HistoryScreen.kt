package contagiouscode.mirsengar.dicte.presentation.history

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.dp
import contagiouscode.mirsengar.dicte.presentation.bookmark.BookmarkList

@ExperimentalUnitApi
@Composable
fun HistoryScreen(viewModel: HistoryViewModel , onItemClick: (Int) -> Unit) {
    val history by viewModel.history.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "History",
                style = MaterialTheme.typography.h6,
                color = MaterialTheme.colors.onBackground,
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 0.dp)
                    .align(Alignment.Start)
            )

            BookmarkList(list = history, onItemClick = onItemClick) {
                viewModel.deleteHistory(it)
            }
        }

        if (history.isEmpty()) {
            Text(
                text = "History is empty. Your search history will appear here",
                style = MaterialTheme.typography.subtitle2,
                fontWeight = FontWeight.ExtraLight,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colors.onBackground,
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.Center)
            )
        }
    }
}