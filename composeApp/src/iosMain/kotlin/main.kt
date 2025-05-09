import androidx.compose.ui.window.ComposeUIViewController
import com.bharatmatrimony.App
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController { App() }
