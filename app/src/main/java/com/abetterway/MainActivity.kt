package com.abetterway

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.card.MaterialCardView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val familyContacts = findViewById<MaterialCardView>(R.id.family_category)
        val friendsContacts = findViewById<MaterialCardView>(R.id.friends_category)
        val tutorContacts = findViewById<MaterialCardView>(R.id.tutor_category)
        val businessContacts = findViewById<MaterialCardView>(R.id.business_category)

        // Action Bar
        actionBar?.title = "A Better Way Contact"
        supportActionBar?.title = "A Better Way Contact"

        // Family contact
        familyContacts.setOnClickListener {
            val familyIntent = Intent(this, FamilyContactActivity::class.java)
            startActivity(familyIntent)
        }

        // Friends contact
        friendsContacts.setOnClickListener {
            val friendsIntent = Intent(this, FriendsContactActivity::class.java)
            startActivity(friendsIntent)
        }

        // Tutor Contact
        tutorContacts.setOnClickListener {
            val tutorContactsIntent = Intent(this, TutorContactsActivity::class.java)
            startActivity(tutorContactsIntent)
        }

        // Business Contact
        businessContacts.setOnClickListener {
            val businessContactIntent = Intent(this, BusinessContactsActivity::class.java)
            startActivity(businessContactIntent)
        }
    }
}
