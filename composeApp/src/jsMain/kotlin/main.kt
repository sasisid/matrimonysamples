import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import com.bharatmatrimony.App
import com.bharatmatrimony.core.di.initKoinJs
import org.jetbrains.skiko.wasm.onWasmReady
import kotlinx.browser.document
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    onWasmReady {
        val body = document.body ?: return@onWasmReady
        GlobalScope.launch {
            initKoinJs()
            ComposeViewport(body) {

                App()
            }
        }


    }
}
