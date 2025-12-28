package id.antasari.p3_ui_logic_230104040222

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.annotation.SuppressLint
import android.graphics.Color
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.content.res.ColorStateList
import android.widget.*
import androidx.core.content.ContextCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    // List untuk menyimpan input hobi dinamis
    private val hobbyInputs = mutableListOf<TextInputEditText>()
    private var count = 0
    private var isDarkMode = false

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi View
        val mainLayoutRoot = findViewById<ScrollView>(R.id.mainLayoutRoot)
        val mainContainer = findViewById<ViewGroup>(R.id.mainContainer)
        val switchTheme = findViewById<CompoundButton>(R.id.switchTheme)

        val edtName = findViewById<TextInputEditText>(R.id.edtName)
        val edtEmail = findViewById<TextInputEditText>(R.id.edtEmail)
        val edtAge = findViewById<TextInputEditText>(R.id.edtAge)

        // Layout pembungkus untuk validasi error message
        val layoutName = findViewById<TextInputLayout>(R.id.layoutName)
        val layoutEmail = findViewById<TextInputLayout>(R.id.layoutEmail)
        val layoutAge = findViewById<TextInputLayout>(R.id.layoutAge)

        val containerHobbies = findViewById<LinearLayout>(R.id.containerHobbies)
        val btnAddHobby = findViewById<Button>(R.id.btnAddHobby)

        val txtCounter = findViewById<TextView>(R.id.txtCounter)
        val btnPlus = findViewById<Button>(R.id.btnPlus)
        val btnMinus = findViewById<Button>(R.id.btnMinus)

        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        val txtResult = findViewById<TextView>(R.id.txtResult)


        // --- 4. Switch Theme (Manual Logic) ---
        // Set warna awal berdasarkan layout XML
        updateThemeColors(mainLayoutRoot, mainContainer, false)

        switchTheme.setOnCheckedChangeListener { _, isChecked ->
            isDarkMode = isChecked
            updateThemeColors(mainLayoutRoot, mainContainer, isChecked)
        }


        // --- 3. Interactive Counter ---
        btnPlus.setOnClickListener {
            count++
            txtCounter.text = count.toString()
        }
        btnMinus.setOnClickListener {
            if (count > 0) {
                count--
                txtCounter.text = count.toString()
            }
        }


        // --- 1. Dynamic Form Challenge (Revised for TextInputLayout) ---
        btnAddHobby.setOnClickListener {
            val index = hobbyInputs.size + 1

            // 1. Buat TextInputLayout secara programmatical sebagai pembungkus
            val newTextInputLayout = TextInputLayout(this, null, com.google.android.material.R.style.Widget_MaterialComponents_TextInputLayout_OutlinedBox).apply {
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).also { it.setMargins(0, 16, 0, 0) } // Margin atas antar hobi
                hint = "Hobi ke-$index"
                boxStrokeColor = ContextCompat.getColor(context, R.color.purple_500)
                setHintTextColor(ColorStateList.valueOf(ContextCompat.getColor(context, R.color.purple_500)))
            }

            // 2. Buat TextInputEditText di dalamnya
            val newEditText = TextInputEditText(newTextInputLayout.context).apply {
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                // Set warna teks inputan sesuai tema saat ini
                val textColor = if(isDarkMode) R.color.text_light else R.color.text_dark
                setTextColor(ContextCompat.getColor(context, textColor))
            }

            // 3. Gabungkan dan tambahkan ke tampilan
            newTextInputLayout.addView(newEditText)
            containerHobbies.addView(newTextInputLayout)

            // Simpan referensi EditText-nya untuk diambil datanya nanti
            hobbyInputs.add(newEditText)

            // Update warna elemen dinamis jika dalam dark mode
            if(isDarkMode) {
                updateSingleTextInputLayoutColor(newTextInputLayout, true)
            }
        }


        // --- 2. Form Validasi Lanjutan ---
        // TextWatcher untuk memantau perubahan real-time
        val watcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val name = edtName.text.toString().trim()
                val email = edtEmail.text.toString().trim()
                val ageStr = edtAge.text.toString().trim()

                // Validasi Nama
                val isNameValid = name.isNotEmpty()
                layoutName.error = if (isNameValid) null else "Nama tidak boleh kosong"

                // Validasi Email
                val isEmailValid = Patterns.EMAIL_ADDRESS.matcher(email).matches()
                layoutEmail.error = if (isEmailValid && email.isNotEmpty()) null else "Format email salah"

                // Validasi Umur
                val age = ageStr.toIntOrNull() ?: 0
                val isAgeValid = age in 1..120
                layoutAge.error = if (isAgeValid) null else "Umur harus 1-120"

                // Aktifkan tombol jika semua valid
                btnSubmit.isEnabled = isNameValid && isEmailValid && isAgeValid
            }
            override fun afterTextChanged(s: Editable?) {}
        }

        // Pasang watcher ke semua input utama
        edtName.addTextChangedListener(watcher)
        edtEmail.addTextChangedListener(watcher)
        edtAge.addTextChangedListener(watcher)


        // --- Submit Button Action ---
        btnSubmit.setOnClickListener {
            // Kumpulkan data hobi dari list dynamic inputs
            val hobbyListString = hobbyInputs
                .filter { it.text.toString().isNotBlank() } // Ambil yang tidak kosong saja
                .joinToString(separator = ", ") { it.text.toString().trim() }

            val finalHobbies = if (hobbyListString.isEmpty()) "-" else hobbyListString

            val resultText = """
                Halo ${edtName.text}
                Umurmu ${edtAge.text}
                Email kamu ${edtEmail.text}
                Hobi: $finalHobbies
                Counter Saat Ini: $count
            """.trimIndent()

            txtResult.text = resultText
            Toast.makeText(this, "Data Berhasil Disubmit!", Toast.LENGTH_SHORT).show()
        }
    }


    // --- Helper Function untuk Mengubah Tema Secara Manual ---
    private fun updateThemeColors(root: ScrollView, container: ViewGroup, isDark: Boolean) {
        val bgColor = if (isDark) R.color.bg_dark else R.color.bg_light
        val textColor = if (isDark) R.color.text_light else R.color.text_dark

        // Ubah background root
        root.setBackgroundColor(ContextCompat.getColor(this, bgColor))

        // Fungsi rekursif untuk mengubah warna teks dan input di dalam container
        recursiveColorUpdate(container, textColor, isDark)
    }

    private fun recursiveColorUpdate(viewGroup: ViewGroup, textColorRes: Int, isDark: Boolean) {
        val color = ContextCompat.getColor(this, textColorRes)

        for (i in 0 until viewGroup.childCount) {
            when (val child = viewGroup.getChildAt(i)) {
                is TextView -> {
                    // Jangan ubah warna teks tombol (karena pakai style khusus)
                    if (child !is Button) {
                        child.setTextColor(color)
                    }
                }
                is TextInputLayout -> {
                    updateSingleTextInputLayoutColor(child, isDark)
                }
                is ViewGroup -> {
                    // Jika view adalah layout lain (misal LinearLayout hobbies), masuk ke dalamnya
                    recursiveColorUpdate(child, textColorRes, isDark)
                }
            }
        }
    }

    // Helper khusus untuk mewarnai TextInputLayout (Hint dan Box)
    private fun updateSingleTextInputLayoutColor(textInputLayout: TextInputLayout, isDark: Boolean) {
        val textColorRes = if (isDark) R.color.text_light else R.color.text_dark
        val hintColorRes = if (isDark) R.color.text_hint_light else R.color.text_hint_dark
        val boxColorRes = if (isDark) R.color.text_hint_light else R.color.text_hint_dark // Warna garis saat tidak fokus

        val color = ContextCompat.getColor(this, textColorRes)
        val hintColorStateList = ColorStateList.valueOf(ContextCompat.getColor(this, hintColorRes))
        val boxColorStateList = ColorStateList.valueOf(ContextCompat.getColor(this, boxColorRes))

        // Ubah warna teks input di dalamnya
        textInputLayout.editText?.setTextColor(color)
        // Ubah warna hint saat diam (sebelum diklik)
        textInputLayout.defaultHintTextColor = hintColorStateList
        // Ubah warna garis box saat diam
        textInputLayout.setBoxStrokeColorStateList(boxColorStateList)
    }
}