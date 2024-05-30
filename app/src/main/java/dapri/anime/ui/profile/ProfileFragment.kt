package dapri.anime.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.content.Intent
import android.net.Uri
import android.widget.Button
import androidx.fragment.app.Fragment
import dapri.anime.R

class ProfileFragment : Fragment() {
    private lateinit var instagram: Button
    private lateinit var shareBtn: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        instagram = view.findViewById(R.id.btn_instagram)
        instagram.setOnClickListener {
            val goToInstagram =
                Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/qurick_"))
            startActivity(goToInstagram)
        }

        shareBtn = view.findViewById(R.id.btn_share)
        shareBtn.setOnClickListener {
            val shareIntent = Intent (Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(
                Intent.EXTRA_TEXT,
                    "INI TUGAS DANANG L0122043 RESPONSI"
            )
            startActivity(Intent.createChooser(shareIntent, "Share Profile Dapri"))
        }



    }
}