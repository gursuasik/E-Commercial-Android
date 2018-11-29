package tr.com.rnd.master.Model.Config;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import tr.com.rnd.master.Model.Request.TokenRequest;

/**
 * Created by gursuasik on 11/11/2017.
 */

public class DBHelper extends SQLiteOpenHelper {
    private Context context;

    public static class Token implements BaseColumns {
        public static String TABLE_NAME = "token";
        public static String USERNAME = "username";
        public static String PASSWORD = "password";
    }

    public DBHelper(Context context) {
        super(context, "master", null, 1, null);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + Token.TABLE_NAME + "(" + Token.USERNAME + " TEXT, " + Token.PASSWORD + " TEXT)");
/*
        ContentValues contentValues = new ContentValues();
        contentValues.put(Token.USERNAME, new Init(context).baseUrl);
        contentValues.put(Token.PASSWORD, new Init(context).apiVersion);
        sqLiteDatabase.insert(Token.TABLE_NAME, null, contentValues);*/
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    public void insertToken(TokenRequest tokenRequest) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        sqLiteDatabase.delete(Token.TABLE_NAME, null, null);

        ContentValues contentValues = new ContentValues();

        contentValues.put(Token.USERNAME, tokenRequest.username);
        contentValues.put(Token.PASSWORD, tokenRequest.password);

        sqLiteDatabase.insert(Token.TABLE_NAME, null, contentValues);

        sqLiteDatabase.close();
    }

    public TokenRequest selectUser() {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        String[] columns = {Token.USERNAME, Token.PASSWORD};
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT " + Token.USERNAME + ", " + Token.PASSWORD + " FROM " + Token.TABLE_NAME, null);

        TokenRequest user = null;
        if (cursor.moveToFirst()) {
            user = new TokenRequest(cursor.getString(cursor.getColumnIndexOrThrow(Token.USERNAME)), cursor.getString(cursor.getColumnIndexOrThrow(Token.PASSWORD)));
        }
        cursor.close();

        sqLiteDatabase.close();

        return user;
    }

    public void deleteUser() {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        sqLiteDatabase.delete(Token.TABLE_NAME, null, null);

        sqLiteDatabase.close();
    }
}