package com.amou.traditionalsongs.databases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DatabaseName = "TraDatabases";
    private static final int DatabaseVersion = 1;


    public static String DATABASE_AREAS = "areas";
    public static String DATABASE_BROCHURE_CATEGORIES = "brochureCategories";
    public static String DATABASE_BROCHURE_PRODUCTS = "brochureProducts";
    public static String DATABASE_DEFAULT_ITEMS = "defaultItems";
    public static String DATABASE_OFFLINE = "offLine";
    public static String DATABASE_EMAIL_HISTORY = "emailHistory";

    public static String EMAIL_HISTORY = "emails";
    public static String LISTS_ID = "ID";
    public static String LISTS_NAME = "Name";


    public static String LIST_ELEMENTS_ID = "ID";
    public static String LIST_ELEMENTS_LIST_ID = "ListID";
    public static String LIST_ELEMENTS_NAME = "Name";
    public static String LIST_ELEMENTS_STATUS = "Status";


    public static String BROCHURE_CATEGORIES_ID = "ID";
    public static String BROCHURE_CATEGORIES_NAME = "Name";
    public static String BROCHURE_CATEGORIES_FULLNAME = "FullName";
    public static String BROCHURE_CATEGORIES_PHOTO_URL = "Photo";

    public static String BROCHURE_PRODUCTS_ID = "ID";
    public static String BROCHURE_PRODUCTS_CATEGORY_ID = "CategoryID";
    public static String BROCHURE_PRODUCTS_NAME = "Name";
    public static String BROCHURE_PRODUCTS_PRICE = "Price";
    public static String BROCHURE_PRODUCTS_PHOTO_URL = "PhotoUrl";
    public static String BROCHURE_PRODUCTS_UNIT_TYPE = "Type";
    public static String BROCHURE_PRODUCTS_UNIT_TEXT = "Text";

    public static String DEFAULT_ITEMS_MAIN_ID = "MainID";
    public static String DEFAULT_ITEMS_ELEMENT_ID = "ElementID";
    public static String DEFAULT_ITEMS_PARENT_ID = "ParentID";
    public static String DEFAULT_ITEMS_NAME = "Name";
    public static String DEFAULT_PHOTO_URL = "Photo";

    public static String OFFLINE_ACTION = "Action";
    public static String OFFLINE_LIST_ID = "ListID";
    public static String OFFLINE_ELEMENT_ID = "ElementID";

	
	/*private static final String DatabaseCreate1="CREATE TABLE IF NOT EXISTS `mylist` (" +
			"  `ID` int(11) NOT NULL ," +
			"  PRIMARY KEY (`ID`)" +
			");";*/
	
	/*private static final String DatabaseCreate2="CREATE TABLE IF NOT EXISTS `reservations` (" +
			"`ID` int(11) NOT NULL ," +
			"`Date_In` date NOT NULL," +
			"`Date_Out` date NOT NULL," +
			"`Confirm` int(1) NOT NULL," +
			"PRIMARY KEY (`ID`)" +
			");";*/
	
	/*private static final String DatabaseCreate2="CREATE TABLE IF NOT EXISTS `reservations` (" +
			"`ID` int(11) NOT NULL ," +
			"`FullName` varchar(100) NOT NULL," +	
			"`Date_In` date NOT NULL," +
			"`Date_Out` date NOT NULL," +
			"`Confirm` int(1) NOT NULL," +
			"`Created` date NOT NULL," +
			"PRIMARY KEY (`ID`)" +
			");";
	
	private static final String DatabaseCreate3="CREATE TABLE IF NOT EXISTS `rooms` (" +
			"`ID` int(11) NOT NULL ," +
			"`Type` varchar(100) NOT NULL," +	
			"PRIMARY KEY (`ID`)" +
			");";*/

    public DatabaseHelper(Context context) {
        super(context, DatabaseName, null, DatabaseVersion);
        //DatabaseHelper.insertmeth= DatabaseHelper.db.compileStatement(INSERT);
        // TODO Auto-generated constructor stub


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub

//        db.execSQL(String.format("CREATE TABLE IF NOT EXISTS `" + DATABASE_EMAIL_HISTORY + "` (%s VARCHAR(100));",
//                EMAIL_HISTORY));
//
//        db.execSQL(String.format("CREATE TABLE IF NOT EXISTS `" + DATABASE_LISTS + "` (%s INTEGER PRIMARY KEY , %s char(50));",
//                LISTS_ID,
//                LISTS_NAME));
//        Log.e("", "create dataase");
//		/* db.execSQL(String.format("CREATE TABLE IF NOT EXISTS `" + DATABASE_CATEGORIES + "` (%s INTEGER PRIMARY KEY , %s varchar(40), %s varchar(40));",
//				 CATEGORIES_ID,
//				 CATEGORIES_NAME,
//				 CATEGORIES_FULLNAME));*/
//
//        db.execSQL(String.format("CREATE TABLE IF NOT EXISTS `" + DATABASE_BROCHURE_CATEGORIES + "` (%s INTEGER PRIMARY KEY , %s varchar(100), %s varchar(60), %s TEXT);",
//                BROCHURE_CATEGORIES_ID,
//                BROCHURE_CATEGORIES_NAME,
//                BROCHURE_CATEGORIES_FULLNAME,
//                BROCHURE_CATEGORIES_PHOTO_URL));
//
//        db.execSQL(String.format("CREATE TABLE IF NOT EXISTS `" + DATABASE_LIST_ELEMENTS + "` (%s INTEGER ,%s INTEGER, %s char(50), %s  char(10));",
//                LIST_ELEMENTS_ID,
//                LIST_ELEMENTS_LIST_ID,
//                LIST_ELEMENTS_NAME,
//                LIST_ELEMENTS_STATUS));
//
//        db.execSQL(String.format("CREATE TABLE IF NOT EXISTS `" + DATABASE_BROCHURE_PRODUCTS + "` (%s INTEGER , %s TEXT, %s varchar(20), %s INTEGER ,%s varchar(50),%s TEXT);",
//                BROCHURE_PRODUCTS_CATEGORY_ID,
//                BROCHURE_PRODUCTS_NAME,
//                BROCHURE_PRODUCTS_PRICE,
//                BROCHURE_PRODUCTS_UNIT_TYPE,
//                BROCHURE_PRODUCTS_UNIT_TEXT,
//                BROCHURE_PRODUCTS_PHOTO_URL));
//
//        db.execSQL(String.format("CREATE TABLE IF NOT EXISTS `" + DATABASE_DEFAULT_ITEMS + "` (%s INTEGER , %s INTEGER ,%s INTEGER ,%s varchar(60), %s TEXT);",
//                DEFAULT_ITEMS_MAIN_ID,
//                DEFAULT_ITEMS_ELEMENT_ID,
//                DEFAULT_ITEMS_PARENT_ID,
//                DEFAULT_ITEMS_NAME,
//                DEFAULT_PHOTO_URL));
//
//        db.execSQL(String.format("CREATE TABLE IF NOT EXISTS `" + DATABASE_OFFLINE + "` (%s varchar(60) , %s INTEGER ,%s INTEGER );",
//                OFFLINE_ACTION,
//                OFFLINE_LIST_ID,
//                OFFLINE_ELEMENT_ID));

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        //db.execSQL("DROP TABLE IF EXISTS `QuestionsTable`");
        //	db.execSQL("DROP TABLE IF EXISTS `QuestionsTableTest`");
        //onCreate(db);

    }
	
	

	/*private ContentValues createContentValues(int id, String que, String answ,int correct) 
	{
		ContentValues values =new ContentValues();
		values.put(RID,id);
		values.put(RQuestion,que);
		values.put(RAnswers,answ);
		values.put(RCorrectAnswer,correct);
		
		
		return values;
	}*/


}
