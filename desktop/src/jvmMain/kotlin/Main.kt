import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import io.chozzle.composemacostheme.MacDropdownMenu
import io.chozzle.composemacostheme.MacTheme

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "",
        state = rememberWindowState(width = 300.dp, height = 300.dp),) {


        // ----------------------------------------------------------------------------

        /**
         * Snippet for extending macOs window to fullwindow without titlebar and colored background
         */
        val dark = darkColors()
        this.window.background = java.awt.Color(dark.background.red, dark.background.green, dark.background.blue)

        if (System.getProperty("os.name", "").startsWith("Mac OS")) {
            this.window.rootPane.putClientProperty("apple.awt.fullWindowContent", true)
            this.window.rootPane.putClientProperty("apple.awt.transparentTitleBar", true)
        }

        // ----------------------------------------------------------------------------

        Column {
            Spacer(Modifier.height(10.dp))

            MacTheme(typography = Typography()) {

                val menuItems = listOf(
                    "Some options",
                    "Orange",
                    "Yellow",
                    "Green",
                    "Blue",
                    "Indigo",
                    "Kinda brownish gray",
                )

                var selectedIndex1 by remember { mutableStateOf(0) }

                MacDropdownMenu(
                    menuItems,
                    selectedIndex1,
                    onItemSelected = {
                        selectedIndex1 = it
                    },
                )

            }
        }


    }
}
