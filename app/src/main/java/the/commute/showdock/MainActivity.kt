package the.commute.showdock

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dagger.hilt.android.AndroidEntryPoint
import the.commute.showdock.features.auth.login.LoginViewModel
import the.commute.showdock.features.homeMovieList.HomeViewModel
import the.commute.showdock.ui.theme.ShowDockTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val loginViewModel:LoginViewModel by viewModels()
    private val homeViewModel:HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeViewModel.getMovieList()
        loginViewModel.getTemporaryRequestToken()
        setContent {
            ShowDockTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}
