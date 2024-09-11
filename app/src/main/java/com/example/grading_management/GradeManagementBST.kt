package com.example.app


data class StudentRecord(
    var studentId: Int,
    var name: String,
    var grade: Int,
    var left: StudentRecord? = null,
    var right: StudentRecord? = null
)


object GradeManagementSystem {
    val bst: GradeManagementBST = GradeManagementBST()
}


class GradeManagementBST {
    var root: StudentRecord? = null

    // Insert method
    fun insert(studentId: Int, name: String, grade: Int) {
        val newRecord = StudentRecord(studentId, name, grade)
        if (root == null) {
            root = newRecord
        } else {
            insertRecursive(root!!, newRecord)
        }
    }

    private fun insertRecursive(currentNode: StudentRecord, newRecord: StudentRecord) {
        if (newRecord.studentId < currentNode.studentId) {
            if (currentNode.left == null) {
                currentNode.left = newRecord
            } else {
                insertRecursive(currentNode.left!!, newRecord)
            }
        } else if (newRecord.studentId > currentNode.studentId) {
            if (currentNode.right == null) {
                currentNode.right = newRecord
            } else {
                insertRecursive(currentNode.right!!, newRecord)
            }
        }
    }

    // Search method
    fun search(studentId: Int): StudentRecord? {
        return searchRecursive(root, studentId)
    }

    private fun searchRecursive(currentNode: StudentRecord?, studentId: Int): StudentRecord? {
        if (currentNode == null) return null
        return when {
            studentId == currentNode.studentId -> currentNode
            studentId < currentNode.studentId -> searchRecursive(currentNode.left, studentId)
            else -> searchRecursive(currentNode.right, studentId)
        }
    }

    // Delete method
    fun delete(studentId: Int) {
        root = deleteRecursive(root, studentId)
    }

    private fun deleteRecursive(root: StudentRecord?, studentId: Int): StudentRecord? {
        if (root == null) return null

        when {
            studentId < root.studentId -> root.left = deleteRecursive(root.left, studentId)
            studentId > root.studentId -> root.right = deleteRecursive(root.right, studentId)
            else -> {
                // Node with only one child or no child
                if (root.left == null) return root.right
                if (root.right == null) return root.left

                // Node with two children: Get the inorder successor (smallest in the right subtree)
                val successor = minValueNode(root.right!!)
                // Copy the successor's content to the current node
                val newNode = StudentRecord(successor.studentId, successor.name, successor.grade)
                newNode.left = root.left
                newNode.right = deleteRecursive(root.right, successor.studentId)
                return newNode
            }
        }
        return root
    }

    private fun minValueNode(node: StudentRecord): StudentRecord {
        var current = node
        while (current.left != null) {
            current = current.left!!
        }
        return current
    }
    fun getAllStudents(): List<StudentRecord> {
        val students = mutableListOf<StudentRecord>()
        inorderTraversal(root, students)
        return students
    }

    private fun inorderTraversal(node: StudentRecord?, list: MutableList<StudentRecord>) {
        if (node != null) {
            inorderTraversal(node.left, list)
            list.add(node)
            inorderTraversal(node.right, list)
        }
    }
}
