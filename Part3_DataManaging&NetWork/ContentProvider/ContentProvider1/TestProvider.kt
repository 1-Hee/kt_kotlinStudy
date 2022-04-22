package co.kr.contentprovider

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.net.Uri

class TestProvider : ContentProvider() {

    var db:SQLiteDatabase? = null

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?): Int {
        val cnt = db?.delete("TestTable", selection, selectionArgs)
        return cnt!!
    }

    // 열의 데이터 타입을 MIME 타입 형태로 반환하는 메서드
    // 알려줄 필요가 없다면 null을 반환한다.
    override fun getType(uri: Uri): String? {
        return null
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        db?.insert("TestTable", null, values)
        return uri
    }


    // 컨텐트 프로바이더 객체가 생성되면 자동으로 호출되는 메서드
    // 데이터 베이스에 접근할 수 있는 객체를 생성하고
    // 접속에 성공하면 true, 실패하면 false를 반환한다.
    override fun onCreate(): Boolean {
        db = DBHelper(context!!).writableDatabase
        if(db==null) {
            return false
        }
        return true
    }

    // 셀렉트 용
    // uri : 프로바이더 요청시 사용할 uri 값
    // projection : 가져올 컬럼 목록, null 이면 전체선택
    // selection : 조건절, null 이면 무조건
    // selecttionArgs : 조건절의 ?에 바인딩될 값 배열
    // sortOrder : 정렬 기준이 되는 칼럼
    override fun query(
        uri: Uri, projection: Array<String>?, selection: String?,
        selectionArgs: Array<String>?, sortOrder: String?
    ): Cursor? {
        val c1 = db?.query("TestTable", projection, selection, selectionArgs, null, null, sortOrder)
        return c1
    }

    override fun update(
        uri: Uri, values: ContentValues?, selection: String?,
        selectionArgs: Array<String>?
    ): Int {
        val cnt =db?.update("TestTable", values, selection, selectionArgs)
        return cnt!!
    }
}