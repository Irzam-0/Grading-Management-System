package com.example.grading_management

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.app.GradeManagementSystem

class AddStudentActivity : AppCompatActivity() {

    private val bst = GradeManagementSystem.bst
    private lateinit var deleteButton: Button
    private lateinit var etStudentId: EditText
    private lateinit var etName: EditText
    private lateinit var etGrade: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_student)

        // Find views
        etStudentId = findViewById(R.id.etStudentId)
        etName = findViewById(R.id.etName)
        etGrade = findViewById(R.id.etGrade)
        val btnAddStudent = findViewById<Button>(R.id.btnAddStudent)
        val btnGoToSearch = findViewById<Button>(R.id.btnGoToSearchStudent)
        deleteButton = findViewById(R.id.btnDeleteStudent)
        val btnViewStudents = findViewById<Button>(R.id.btnViewStudents)

        // Add student button click listener
        btnAddStudent.setOnClickListener {
            val studentId = etStudentId.text.toString().toIntOrNull()
            val name = etName.text.toString()
            val grade = etGrade.text.toString().toIntOrNull()

            if (studentId != null && grade != null) {
                bst.insert(studentId, name, grade)
                Toast.makeText(this, "Student Added!", Toast.LENGTH_SHORT).show()

                // Clear input fields
                etStudentId.text.clear()
                etName.text.clear()
                etGrade.text.clear()
            } else {
                Toast.makeText(this, "Invalid input. Please check your data.", Toast.LENGTH_SHORT).show()
            }
        }

        // Go to search student activity button click listener
        btnGoToSearch.setOnClickListener {
            val intent = Intent(this, SearchStudentActivity::class.java)
            startActivity(intent)
        }
       deleteButton.setOnClickListener {
            val intent = Intent(this, DeleteStudent::class.java)
            startActivity(intent)
        }
        btnViewStudents.setOnClickListener {
            val intent = Intent(this, DisplayStudentsActivity::class.java)
            startActivity(intent)
        }
    }
}


