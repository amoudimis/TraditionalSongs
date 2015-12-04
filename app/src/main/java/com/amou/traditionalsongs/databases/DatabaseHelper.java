package com.amou.traditionalsongs.databases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DatabaseName = "TraDatabases";
    private static final int DatabaseVersion = 1;

    public static String DATABASE_REGIONS = "regions";
    public static String DATABASE_AREAS = "areas";
    public static String DATABASE_SONGS = "songs";
    public static String DATABASE_LAST_MODIFIED = "LAST_MODIFIED";

    public static String REGIONS_ID = "id";
    public static String REGIONS_NAME = "name";

    public static String AREAS_ID = "id";
    public static String AREAS_REGION_ID = "region_id";
    public static String AREAS_NAME = "name";

    public static String SONGS_ID = "id";
    public static String SONGS_AREA_ID = "area_id";
    public static String SONGS_REGION_ID = "region_id";
    public static String SONGS_TITLE = "title";
    public static String SONGS_DESCRIPTION = "description";
    public static String SONGS_LYRICS = "lyrics";

    public static String LAST_MODIFIED_TABLE = "table";
    public static String LAST_MODIFIED_DATE = "date";

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

        db.execSQL(String.format("CREATE TABLE IF NOT EXISTS `" + DATABASE_REGIONS + "` (" +
                        "%s INTEGER PRIMARY KEY ," +
                        "%s VARCHAR(100)" +
                        ");",
                REGIONS_ID,
                REGIONS_NAME));


        db.execSQL(String.format("CREATE TABLE IF NOT EXISTS `" + DATABASE_AREAS + "` (" +
                        "%s INTEGER PRIMARY KEY ," +
                        "%s INTEGER ," +
                        "%s VARCHAR(100)" +
                        ");",
                AREAS_ID,
                AREAS_REGION_ID,
                AREAS_NAME));


        db.execSQL(String.format("CREATE TABLE IF NOT EXISTS `" + DATABASE_SONGS + "` (" +
                        "%s INTEGER PRIMARY KEY ," +
                        "%s INTEGER ," +
                        "%s INTEGER ," +
                        "%s VARCHAR(100)," +
                        "%s TEXT," +
                        "%s TEXT" +
                        ");",
                SONGS_ID,
                SONGS_REGION_ID,
                SONGS_AREA_ID,
                SONGS_TITLE,
                SONGS_DESCRIPTION,
                SONGS_LYRICS));

        db.execSQL("INSERT INTO `traditional_regions` (`id`, `name`) VALUES\n" +
                "(1, 'Θράκη'),\n" +
                "(2, 'Κωνσταντινούπολη'),\n" +
                "(3, 'Ανατολική Ρωμυλία'),\n" +
                "(4, 'Ανατολικό Αιγαίο'),\n" +
                "(5, 'Αρβανίτικα'),\n" +
                "(6, 'Ήπειρος'),\n" +
                "(7, 'Θεσσαλία'),\n" +
                "(8, 'Καππαδοκία'),\n" +
                "(9, 'Κρήτη'),\n" +
                "(10, 'Κυκλάδες'),\n" +
                "(11, 'Μακεδονία'),\n" +
                "(12, 'Πόντος'),\n" +
                "(13, 'Ρούμελη'),\n" +
                "(14, 'Σαρακατσάνικα'),\n" +
                "(15, 'Μικρά Ασία - Ιωνία');");


//        db.execSQL(String.format("CREATE TABLE IF NOT EXISTS `" + DATABASE_LAST_MODIFIED + "` (" +
//                        "%s VARCHAR(100) PRIMARY KEY ," +
//                        "%s TIMESTAMP" +
//                        ");",
//                LAST_MODIFIED_TABLE,
//                LAST_MODIFIED_DATE));

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
