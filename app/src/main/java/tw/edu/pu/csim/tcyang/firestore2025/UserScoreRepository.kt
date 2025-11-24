package tw.edu.pu.csim.tcyang.firestore2025

import com.google.firebase.Firebase

private val Firebase.firestore: Any

class UserScoreRepository {
    val db = Firebase.firestore

    suspend fun addUser(userScore: UserScoreModel): String {
        return try {
            val documentReference =
                db.collection("UserScore")
                    .add(userScore)
                    .await()
            "新增資料成功！Document ID:\n ${documentReference.id}"
        } catch (e: Exception) {
            // await() 失敗時會拋出例外，在這裡捕捉並處理
            "新增資料失敗：${e.message}"
        }
    }
}
