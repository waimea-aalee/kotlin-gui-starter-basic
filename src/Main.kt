/**
 * ===============================================================
 * Kotlin GUI Basic Starter
 * ===============================================================
 *
 * This is a starter project for a simple Kotlin GUI application.
 * The Java Swing library is used, plus the FlatLAF look-and-feel
 * for a reasonably modern look.
 */

import com.formdev.flatlaf.FlatDarkLaf
import java.awt.*
import java.awt.event.*
import javax.swing.*


/**
 * Launch the application
 */
fun main() {
    FlatDarkLaf.setup()     // Flat, dark look-and-feel
    MainWindow()            // Create and show the UI
}


/**
 * Main UI window (view)
 * Defines the UI and responds to events
 * The app model should be passwd as an argument
 */
class MainWindow : JFrame(), ActionListener, KeyListener {

    // Fields to hold the UI elements
    private lateinit var greetingLabel: JLabel

    private lateinit var helloButton: JButton
    private lateinit var goodbyeButton: JButton

    private lateinit var nameText: JTextField

    /**
     * Configure the UI and display it
     */
    init {
        configureWindow()               // Configure the window
        addControls()                   // Build the UI

        setLocationRelativeTo(null)     // Centre the window
        isVisible = true                // Make it visible
    }

    /**
     * Configure the main window
     */
    private fun configureWindow() {
        title = "Kotlin Swing GUI Demo"
        contentPane.preferredSize = Dimension(600, 350)
        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        isResizable = false
        layout = null
        contentPane.background = Color.BLACK

        pack()
    }

    /**
     * Populate the UI with UI controls
     */
    private fun addControls() {
        val defaultFont = Font(Font.SANS_SERIF, Font.BOLD, 36)

        greetingLabel = JLabel("Click a button...")
        greetingLabel.horizontalAlignment = SwingConstants.CENTER
        greetingLabel.bounds = Rectangle(50, 0, 500, 100)
        greetingLabel.font = defaultFont
        greetingLabel.foreground = Color(204,6,89)
        add(greetingLabel)

        nameText = JTextField()
        nameText.bounds = Rectangle(125,100,300,85)
        nameText.font = defaultFont
        nameText.background = Color(204,6,89)
        nameText.foreground = Color.BLACK
        nameText.addActionListener(this)
        nameText.addKeyListener(this)
        add(nameText)

        helloButton = JButton("Hello!")
        helloButton.bounds = Rectangle(50,200,200,100)
        helloButton.foreground = Color.BLACK
        helloButton.background = Color(204,6,89)
        helloButton.font = defaultFont
        helloButton.addActionListener(this)     // Handle any clicks
        add(helloButton)

        goodbyeButton = JButton("Goobye!")
        goodbyeButton.bounds = Rectangle(325,200,200,100)
        goodbyeButton.foreground = Color.BLACK
        goodbyeButton.background = Color(204,6,89)
        goodbyeButton.font = defaultFont
        goodbyeButton.addActionListener(this)     // Handle any clicks
        add(goodbyeButton)
    }


    /**
     * Handle any UI events (e.g. button clicks)
     */
    override fun actionPerformed(e: ActionEvent?) {
        when (e?.source) {

            nameText -> {
                println("Name text changed")
            }

            helloButton -> {
                println("Hello button pressed")
                greetingLabel.text = "Hello there, ${nameText.text}!"
                greetingLabel.foreground = Color.GREEN
            }
            goodbyeButton -> {
                println("Goodbye button pressed")
                greetingLabel.text = "Good bye, ${nameText.text}!"
                greetingLabel.foreground = Color.RED
                }
            }
        }

    override fun keyTyped(e: KeyEvent?) {
        println("Key TYPED: ${e?.keyChar}")
    }

    override fun keyPressed(e: KeyEvent?) {
        println("Key PRESSED: ${e?.keyCode}")

        if (e?.keyCode in KeyEvent.VK_A..KeyEvent.VK_Z) {
            println("Letter Key!")
        }
        else {
            e?.consume()
        }
    }

    override fun keyReleased(e: KeyEvent?) {
        println("Key RELEASED: ${e?.keyCode}")
    }
}


