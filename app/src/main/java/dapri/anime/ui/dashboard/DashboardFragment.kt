package dapri.anime.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dapri.anime.R
import dapri.anime.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: DashboardAdapter // Replace with your adapter class

    private var isGridMode = false // Flag to track grid mode

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        recyclerView = binding.recyclerView  // Menggunakan binding untuk mengakses RecyclerView
        adapter = DashboardAdapter(requireContext()) // Menginisialisasi adapter
        recyclerView.adapter = adapter

        // Inisialisasi LayoutManager sesuai dengan mode saat ini (list atau grid)
        if (isGridMode) {
            recyclerView.layoutManager = GridLayoutManager(context, 2)
        } else {
            recyclerView.layoutManager = LinearLayoutManager(context)
        }

        setHasOptionsMenu(true) // Menyatakan bahwa fragment ini memiliki menu opsional

        return root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.list_menu, menu) // Inflasi menu yang sesuai
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_list -> {
                // Switch ke tampilan daftar saat opsi daftar dipilih
                recyclerView.layoutManager = LinearLayoutManager(context)
                isGridMode = false
                true
            }
            R.id.action_grid -> {
                // Switch ke tampilan grid saat opsi grid dipilih
                recyclerView.layoutManager = GridLayoutManager(context, 2)
                isGridMode = true
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}
