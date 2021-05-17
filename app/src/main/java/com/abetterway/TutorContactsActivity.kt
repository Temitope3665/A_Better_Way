package com.abetterway

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DividerItemDecoration
import com.abetterway.databinding.ActivityFriendsContactBinding
import com.abetterway.databinding.ActivityTutorContactsBinding
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class TutorContactsActivity : AppCompatActivity() {

    // create binding first
    private lateinit var binding: ActivityTutorContactsBinding
    // creating adapter
    private var adapter = ContactAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTutorContactsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpData(binding)

        // Action Bar
        actionBar?.title = "Tutor Contact Lists"
        supportActionBar?.title = "Tutor Contact Lists"

    }

    // Set up recyclerview
    fun setUpData(binding: ActivityTutorContactsBinding) {
        binding.tutorRecyclerView.adapter = adapter

        // item decoration
        binding.tutorRecyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayout.VERTICAL))

        // create alert dialog
        val builder = AlertDialog.Builder(this)
        //val inflater = this.layoutInflater
        val view = layoutInflater.inflate(R.layout.add_contact_dialog, null)
        builder.setView(view)

        val name = view.findViewById<TextInputEditText>(R.id.name_edit_text)
        val number = view.findViewById<TextInputEditText>(R.id.number_edit_text)
        val saveBtn = view.findViewById<MaterialButton>(R.id.save_btn)

        number.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(no: CharSequence?, p1: Int, p2: Int, p3: Int) {
                saveBtn.isEnabled = no?.length == 11
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })

        val alertDialog = builder.create()

        // save button on click listener
        saveBtn.setOnClickListener {
            // Adding to contact model
            val contact = ContactModel(name.text.toString(), number.text.toString())
            val contacts = mutableListOf(contact)
            adapter.setupContacts(contacts)
            alertDialog.dismiss()
        }

        // displays alert dialog when user click
        binding.fab.setOnClickListener {
            alertDialog.show()
        }
    }
}
