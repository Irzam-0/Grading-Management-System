package com.example.grading_management

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.app.GradeManagementSystem.bst

class DeleteStudent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_delete_student)
        // Get references to the UI elements
        val etStudentId = findViewById<EditText>(R.id.etStudentId)
        val deleteButton   = findViewById<Button>(R.id.btnDeleteStudent)


        deleteButton.setOnClickListener {
            val studentId = etStudentId.text.toString().toIntOrNull()

            if (studentId != null) {
                bst.delete(studentId)
                Toast.makeText(this, "Student Deleted!", Toast.LENGTH_SHORT).show()

                // Clear input field
                etStudentId.text.clear()
            } else {
                Toast.makeText(this, "Invalid Student ID.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}