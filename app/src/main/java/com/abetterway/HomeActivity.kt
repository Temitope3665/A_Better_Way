package com.abetterway

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.GridLayout
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.view.get
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abetterway.databinding.ActivityHomeBinding
import com.abetterway.databinding.HomeScreenItemBinding
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), HomeScreenAdapter.OnClickListener {

    private lateinit var binding: ActivityHomeBinding
    //private val adapter = HomeScreenAdapter()
    private lateinit var adapter: HomeScreenAdapter
    private lateinit var list: List<HomeScreenModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpData(binding)

        loadList()

        adapter = HomeScreenAdapter(list, this@HomeActivity)

        binding.homeScreenRecyclerview.adapter = adapter



    }

    private fun loadList() {
        list = listOf(
            HomeScreenModel("Family Contact", R.drawable.familywhitecolor),
            HomeScreenModel("Friends Contact", R.drawable.friendswhitecolor),
            HomeScreenModel("Tutor Contact", R.drawable.tutorcolorwite),
            HomeScreenModel("Business Contact", R.drawable.businesspartnerwhite)
        )

    }

    fun setUpData(binding: ActivityHomeBinding) {

        binding.homeScreenRecyclerview.layoutManager = GridLayoutManager(this@HomeActivity, 2)

    }

    override fun onClick(position: Int) {
        //Toast.makeText(this, "${position}", Toast.LENGTH_SHORT).show()

        if (position == 0) {
            val familyIntent = Intent(this@HomeActivity, FamilyContactActivity::class.java)
            startActivity(familyIntent)
        }

        if (position == 1) {
            val friendsIntent = Intent(this@HomeActivity, FriendsContactActivity::class.java)
            startActivity(friendsIntent)
        }

        if (position == 2) {
            val tutorIntent = Intent(this@HomeActivity, TutorContactsActivity::class.java)
            startActivity(tutorIntent)
        }

        if (position == 3) {
            val businessIntent = Intent(this@HomeActivity, BusinessContactsActivity::class.java)
            startActivity(businessIntent)
        }
    }

}
