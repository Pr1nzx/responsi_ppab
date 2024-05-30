package dapri.anime.ui.dashboard


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import dapri.anime.R

class DashboardDetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        val detailTitle: TextView = findViewById(R.id.detail_title)
        val detailDescription: TextView = findViewById(R.id.detail_description)
        val detailImage: ImageView = findViewById(R.id.detail_image)
        val detailArc: TextView = findViewById(R.id.detail_arc)


        val title = intent.getStringExtra(EXTRA_TITLE)
        val description = intent.getStringExtra(EXTRA_DESCRIPTION)
        val imageResId = intent.getIntExtra(EXTRA_IMAGE, -1)
        val arc = intent.getStringExtra(EXTRA_ARC)


        detailTitle.text = title
        detailDescription.text = description
        detailImage.setImageResource(imageResId)
        detailArc.text = arc


        val backButton: Button = findViewById(R.id.detail_button)
        backButton.setOnClickListener {
            onBackPressed()
        }
    }

    companion object {
        private const val EXTRA_TITLE = "extra_title"
        private const val EXTRA_DESCRIPTION = "extra_description"
        private const val EXTRA_IMAGE = "extra_image"
        private const val EXTRA_ARC = "extra_arc"

        fun newIntent(context: Context, title: String, description: String, imageResId: Int, arc: String): Intent {
            return Intent(context, DashboardDetailActivity::class.java).apply {
                putExtra(EXTRA_TITLE, title)
                putExtra(EXTRA_DESCRIPTION, description)
                putExtra(EXTRA_IMAGE, imageResId)
                putExtra(EXTRA_ARC, arc)
            }
        }
    }
}
