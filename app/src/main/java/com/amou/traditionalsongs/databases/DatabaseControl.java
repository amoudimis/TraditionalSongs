package com.amou.traditionalsongs.databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;

import com.amou.traditionalsongs.pojos.RegionPojo;

import java.util.ArrayList;

public class DatabaseControl {

    private Context context;
    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;

    public DatabaseControl(Context con) {
        context = con;

    }

    public DatabaseControl openGeneralDatabase() throws SQLiteException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();

        return this;
    }

    public DatabaseControl open() throws SQLiteException {
//		dbHelper = new DatabaseHelper(context);
//		database = dbHelper.getWritableDatabase();
        return null;
    }

    public void close() {
//		dbHelper.close();
    }

    public void closeGeneralDatabase() {
        dbHelper.close();
    }


    public void insertRegions() {

        database.execSQL("INSERT INTO `" + DatabaseHelper.DATABASE_REGIONS + "` (`id`, `name`, `name_c`) VALUES\n" +
                "(1, 'Θράκη', 'Θρακη'),\n" +
                "(2, 'Κωνσταντινούπολη','Κωνσταντινουπολη'),\n" +
                "(3, 'Ανατολική Ρωμυλία', 'Ανατολικη Ρωμυλια'),\n" +
                "(4, 'Ανατολικό Αιγαίο', 'Ανατολικο Αιγαιο'),\n" +
                "(5, 'Αρβανίτικα', 'Αρβανιτικα'),\n" +
                "(6, 'Ήπειρος', 'Ηπειρος'),\n" +
                "(7, 'Θεσσαλία', 'Θεσσαλια'),\n" +
                "(8, 'Καππαδοκία', 'Καππαδοκια'),\n" +
                "(9, 'Κρήτη', 'Κρητη'),\n" +
                "(10, 'Κυκλάδες', 'Κυκλαδες'),\n" +
                "(11, 'Μακεδονία', 'Μακεδονια'),\n" +
                "(12, 'Πόντος', 'Ποντος'),\n" +
                "(13, 'Ρούμελη', 'Ρουμελη'),\n" +
                "(14, 'Σαρακατσάνικα', 'Σαρακατσανικα'),\n" +
                "(15, 'Μικρά Ασία - Ιωνία', 'Μικρα Ασια - Ιωνια');");


    }

    public ArrayList<RegionPojo> getRegions() {
        ArrayList<RegionPojo> items = new ArrayList<>();

        Cursor cursor = database.query(DatabaseHelper.DATABASE_REGIONS, null, null, null, null, null, DatabaseHelper.REGIONS_NAME_C + " ASC");

        int index_id = cursor.getColumnIndex(DatabaseHelper.REGIONS_ID);
        int index_name = cursor.getColumnIndex(DatabaseHelper.REGIONS_NAME);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            RegionPojo region = new RegionPojo(cursor.getInt(index_id), cursor.getString(index_name));

            items.add(region);
            cursor.moveToNext();
        }
        cursor.close();
        return items;
    }


    public void count() {
        Cursor mCount = database.rawQuery("SELECT * FROM `"
                + DatabaseHelper.DATABASE_REGIONS + "`", null);

        Log.e("test", "test " + mCount.getCount());
    }
//	public long insertBrochureCategories(ArrayList<BrochureCategoryPojo> list) {
//		open();
//		long succed=0;
//		deleteBrochureCategories();
//		for (BrochureCategoryPojo item : list) {
//			ContentValues data = new ContentValues();
//			data.put(DatabaseHelper.BROCHURE_CATEGORIES_ID, item.getId());
//			data.put(DatabaseHelper.BROCHURE_CATEGORIES_NAME, item.getName());
//			data.put(DatabaseHelper.BROCHURE_CATEGORIES_FULLNAME,item.getFullName());
//			data.put(DatabaseHelper.BROCHURE_CATEGORIES_PHOTO_URL,item.getPhotoUrl());
//
//			long temp=database.insert(DatabaseHelper.DATABASE_BROCHURE_CATEGORIES, null,data);
//			if(temp==-1)
//				succed=-1;
//		}
//		close();
//		return succed;
//	}
//
//	public void deleteBrochureCategories() {
//		database.delete(DatabaseHelper.DATABASE_BROCHURE_CATEGORIES, null, null);
//	}
//
//	public ArrayList<BrochureCategoryPojo> getBrochureCategories() {
//		open();
//		Cursor mCount = database.rawQuery("SELECT * FROM `"
//				+ DatabaseHelper.DATABASE_BROCHURE_CATEGORIES + "`", null);
//
//		ArrayList<BrochureCategoryPojo> data = new ArrayList<BrochureCategoryPojo>();
//
//		mCount.moveToFirst();
//
//		if (mCount.getCount() > 0)
//			do {
//				BrochureCategoryPojo item = new BrochureCategoryPojo();
//				item.setId(mCount.getInt(0));
//				item.setName(mCount.getString(1));
//				item.setFullName(mCount.getString(2));
//				item.setPhotoUrl(mCount.getString(3));
//				data.add(item);
//			} while (mCount.moveToNext());
//
//		mCount.close();
//		close();
//		return data;
//	}
//
//
//	public long insertBrochureProductsFromCategory(ArrayList<BrochureProductPojo> list,int categoryID) {
//		open();
//		long succed=0;
//		deleteBrochureProductsFromCategory(categoryID);
//		for (BrochureProductPojo item : list) {
//			ContentValues data = new ContentValues();
//			data.put(DatabaseHelper.BROCHURE_PRODUCTS_CATEGORY_ID, item.getCategoryID());
//			data.put(DatabaseHelper.BROCHURE_PRODUCTS_NAME, item.getName());
//			data.put(DatabaseHelper.BROCHURE_PRODUCTS_PRICE,item.getPrice());
//			data.put(DatabaseHelper.BROCHURE_PRODUCTS_UNIT_TYPE, item.getUnitType());
//			data.put(DatabaseHelper.BROCHURE_PRODUCTS_UNIT_TEXT, item.getUnitText());
//			data.put(DatabaseHelper.BROCHURE_PRODUCTS_PHOTO_URL, item.getPhotoUrl());
//
//
//			long temp=database.insert(DatabaseHelper.DATABASE_BROCHURE_PRODUCTS, null,data);
//			if(temp==-1)
//				succed=-1;
//
//		}
//		close();
//		return succed;
//	}
//
//	public ArrayList<BrochureProductPojo> getBrochureProcuctsFromCategory(int categoryID) {
//		open();
//		Cursor mCount = database.rawQuery("SELECT * FROM `"
//				+ DatabaseHelper.DATABASE_BROCHURE_PRODUCTS + "` WHERE "+DatabaseHelper.BROCHURE_PRODUCTS_CATEGORY_ID +"="+categoryID, null);
//
//		ArrayList<BrochureProductPojo> data = new ArrayList<BrochureProductPojo>();
//
//		mCount.moveToFirst();
//
//		if (mCount.getCount() > 0)
//			do {
//				BrochureProductPojo item = new BrochureProductPojo();
//				item.setCategoryID(mCount.getInt(0));
//				item.setName(mCount.getString(1));
//				item.setPrice(mCount.getString(2));
//				item.setUnitType(mCount.getString(3));
//				item.setUnitText(mCount.getString(4));
//				item.setPhotoUrl(mCount.getString(5));
//
//				data.add(item);
//			} while (mCount.moveToNext());
//
//		mCount.close();
//		close();
//		return data;
//	}
//
//	public ArrayList<BrochureProductPojo> getBrochureProcucts() {
//		open();
//		Cursor mCount = database.rawQuery("SELECT * FROM `"
//				+ DatabaseHelper.DATABASE_BROCHURE_PRODUCTS + "`", null);
//
//		ArrayList<BrochureProductPojo> data = new ArrayList<BrochureProductPojo>();
//
//		mCount.moveToFirst();
//
//		if (mCount.getCount() > 0)
//			do {
//				BrochureProductPojo item = new BrochureProductPojo();
//				item.setCategoryID(mCount.getInt(0));
//				item.setName(mCount.getString(1));
//				item.setPrice(mCount.getString(2));
//				item.setUnitType(mCount.getString(3));
//				item.setUnitText(mCount.getString(4));
//				item.setPhotoUrl(mCount.getString(5));
//
//				data.add(item);
//			} while (mCount.moveToNext());
//
//		mCount.close();
//		close();
//		return data;
//	}
//
//	public void deleteBrochureProductsFromCategory(int categoryID) {
//
//		database.delete(DatabaseHelper.DATABASE_BROCHURE_PRODUCTS, DatabaseHelper.BROCHURE_PRODUCTS_CATEGORY_ID+"="+categoryID, null);
//
//	}
//	public void deleteAllBrochureProducts() {
//
//		database.delete(DatabaseHelper.DATABASE_BROCHURE_PRODUCTS,null, null);
//
//	}
//
//	public void insertMyLists(ArrayList<ListCartItemPojo> list) {
//		open();
//		deleteAllLists();
//		for (ListCartItemPojo item : list) {
//			ContentValues data = new ContentValues();
//			data.put(DatabaseHelper.LISTS_ID, item.getId());
//			data.put(DatabaseHelper.LISTS_NAME, item.getTitle());
//
//			database.insert(DatabaseHelper.DATABASE_LISTS, null,data);
//		}
//		close();
//	}
//
//	public void insertInLists(ListCartItemPojo item) {
//		open();
//			ContentValues data = new ContentValues();
//			data.put(DatabaseHelper.LISTS_ID, item.getId());
//			data.put(DatabaseHelper.LISTS_NAME, item.getTitle());
//
//			database.insert(DatabaseHelper.DATABASE_LISTS, null,data);
//		close();
//	}
//
//	public void updateList(ListCartItemPojo item) {
//		open();
//			ContentValues data = new ContentValues();
//			data.put(DatabaseHelper.LISTS_ID, item.getId());
//			data.put(DatabaseHelper.LISTS_NAME, item.getTitle());
//			Log.e("","length "+item.getTitle().length());
//
//			database.update(DatabaseHelper.DATABASE_LISTS, data, DatabaseHelper.LISTS_ID+"="+item.getId(), null);
//		close();
//	}
//
//	public void updateElementName(ElementPojo item) {
//		open();
//			ContentValues data = new ContentValues();
//			data.put(DatabaseHelper.LISTS_NAME, item.getName());
//			database.update(DatabaseHelper.DATABASE_LIST_ELEMENTS, data, DatabaseHelper.LIST_ELEMENTS_ID+"="+item.getId(), null);
//		close();
//	}
//
//	public void deleteFromLists(ListCartItemPojo item) {
//		open();
//			database.delete(DatabaseHelper.DATABASE_LISTS, DatabaseHelper.LISTS_ID+"="+item.getId(), null);
//		close();
//	}
//
//	public void deleteAllLists() {
//
//		database.delete(DatabaseHelper.DATABASE_LISTS, null, null);
//
//	}
//
//	public ArrayList<ListCartItemPojo> getFromLists() {
//		open();
//			Cursor mCount = database.rawQuery("SELECT * FROM `"
//					+ DatabaseHelper.DATABASE_LISTS + "`  ORDER BY ID DESC", null);
//	// ORDER BY ID DESC
//			ArrayList<ListCartItemPojo> data = new ArrayList<ListCartItemPojo>();
//
//			mCount.moveToFirst();
//
//			if (mCount.getCount() > 0)
//				do {
//					ListCartItemPojo item = new ListCartItemPojo();
//					item.setId(mCount.getInt(0));
//					item.setTitle(mCount.getString(1));
//
//					data.add(item);
//				} while (mCount.moveToNext());
//
//			mCount.close();
//		close();
//		return data;
//	}
//
//
//	public void insertElementsToList(ArrayList<ElementPojo> elements,int categoryID)
//	{
//		open();
//			deleteElementsFromList(categoryID);
//
//			for (ElementPojo item : elements) {
//				ContentValues data = new ContentValues();
//				data.put(DatabaseHelper.LIST_ELEMENTS_ID, item.getId());
//				Log.e("","item.getId() "+item.getId());
//				data.put(DatabaseHelper.LIST_ELEMENTS_LIST_ID, item.getListID());
//				Log.e("","item.getListID() "+item.getListID());
//				data.put(DatabaseHelper.LIST_ELEMENTS_NAME,item.getName());
//				Log.e("","item.getName() "+item.getName());
//
//				if(item.isChecked())
//					data.put(DatabaseHelper.LIST_ELEMENTS_STATUS, "true");
//				else
//					data.put(DatabaseHelper.LIST_ELEMENTS_STATUS, "false");
//
//
//				database.insert(DatabaseHelper.DATABASE_LIST_ELEMENTS, null,data);
//			}
//
//
//		close();
//	}
//
//	public void insertElementToList(ElementPojo elements)
//	{
//		open();
//
//			ContentValues data = new ContentValues();
//			data.put(DatabaseHelper.LIST_ELEMENTS_ID, elements.getId());
//			data.put(DatabaseHelper.LIST_ELEMENTS_LIST_ID, elements.getListID());
//			data.put(DatabaseHelper.LIST_ELEMENTS_NAME,elements.getName());
//
//			if(elements.isChecked())
//				data.put(DatabaseHelper.LIST_ELEMENTS_STATUS, "true");
//			else
//				data.put(DatabaseHelper.LIST_ELEMENTS_STATUS, "false");
//
//
//			database.insert(DatabaseHelper.DATABASE_LIST_ELEMENTS, null,data);
//
//		close();
//	}
//
//
//
//	public void deleteElementsFromList(int categoryID) {
//
//		database.delete(DatabaseHelper.DATABASE_LIST_ELEMENTS, DatabaseHelper.LIST_ELEMENTS_LIST_ID+"="+categoryID, null);
//
//	}
//
//	public void deleteAllElements() {
//
//		database.delete(DatabaseHelper.DATABASE_LIST_ELEMENTS, null, null);
//
//	}
//
//	public void deleteElementFromList(ElementPojo item) {
//		open();
//			database.delete(DatabaseHelper.DATABASE_LIST_ELEMENTS, DatabaseHelper.LIST_ELEMENTS_ID+"="+item.getId(), null);
//		close();
//	}
//
//
//	public ArrayList<ElementPojo> getElementsFromList(int categoryID)
//	{
//
//		open();
//			Cursor mCount = database.rawQuery("SELECT * FROM `"
//					+ DatabaseHelper.DATABASE_LIST_ELEMENTS + "` WHERE "+DatabaseHelper.LIST_ELEMENTS_LIST_ID+"="+categoryID +" ORDER BY "+DatabaseHelper.LIST_ELEMENTS_NAME+" ASC ", null);
//	// ORDER BY ID DESC
//			ArrayList<ElementPojo> data =new ArrayList<ElementPojo>();
//
//			mCount.moveToFirst();
//
//			if (mCount.getCount() > 0)
//				do {
//					ElementPojo item = new ElementPojo();
//					item.setId(mCount.getInt(0));
//					item.setListID(mCount.getInt(1));
//					item.setName(mCount.getString(2));
//					if(mCount.getString(3).equalsIgnoreCase("true"))
//						item.setChecked(true);
//					else
//						item.setChecked(false);
//
//					data.add(item);
//				} while (mCount.moveToNext());
//
//			mCount.close();
//			close();
//		return data;
//	}
//
//	public void updateElement(ElementPojo item) {
//		open();
//			ContentValues data = new ContentValues();
//			data.put(DatabaseHelper.LIST_ELEMENTS_STATUS, item.isChecked()+"");
//
//			database.update(DatabaseHelper.DATABASE_LIST_ELEMENTS, data, DatabaseHelper.LIST_ELEMENTS_ID+"="+item.getId(), null);
//		close();
//	}
//
//
//	public void insertDefaultItems(ArrayList<DefaultCategoriesPojo> items)
//	{
//		open();
//			//deleteElementsFromList(categoryID);
//
//			for (DefaultCategoriesPojo item : items) {
//				ContentValues data = new ContentValues();
//				data.put(DatabaseHelper.DEFAULT_ITEMS_MAIN_ID, item.getId());
//				data.put(DatabaseHelper.DEFAULT_ITEMS_ELEMENT_ID, item.getElementid());
//				data.put(DatabaseHelper.DEFAULT_ITEMS_PARENT_ID, item.getParentID());
//				data.put(DatabaseHelper.DEFAULT_ITEMS_NAME, item.getName());
//				data.put(DatabaseHelper.DEFAULT_PHOTO_URL, item.getImageUrl());
//
//				database.insert(DatabaseHelper.DATABASE_DEFAULT_ITEMS, null,data);
//			}
//
//
//		close();
//	}
//
//	public void insertDefaultItem(DefaultCategoriesPojo item)
//	{
//			ContentValues data = new ContentValues();
//			data.put(DatabaseHelper.DEFAULT_ITEMS_MAIN_ID, item.getId());
//			data.put(DatabaseHelper.DEFAULT_ITEMS_ELEMENT_ID, item.getElementid());
//			data.put(DatabaseHelper.DEFAULT_ITEMS_PARENT_ID, item.getParentID());
//			data.put(DatabaseHelper.DEFAULT_ITEMS_NAME, item.getName());
//			data.put(DatabaseHelper.DEFAULT_PHOTO_URL, item.getImageUrl());
//
//			database.insert(DatabaseHelper.DATABASE_DEFAULT_ITEMS, null,data);
//
//	}
//
//	public void deleteAllDefaultItems() {
//
//		database.delete(DatabaseHelper.DATABASE_DEFAULT_ITEMS, null, null);
//
//	}
//
//	public ArrayList<DefaultCategoriesPojo> getDefaultItems() {
//		open();
//		Cursor mCount = database.rawQuery("SELECT * FROM `"+ DatabaseHelper.DATABASE_DEFAULT_ITEMS + "`", null);
//
//		ArrayList<DefaultCategoriesPojo> data = new ArrayList<DefaultCategoriesPojo>();
//
//		mCount.moveToFirst();
//
//		if (mCount.getCount() > 0)
//			do {
//				DefaultCategoriesPojo item = new DefaultCategoriesPojo();
//				item.setId(mCount.getInt(0));
//				item.setElementid(mCount.getInt(1));
//				item.setParentID(mCount.getInt(2));
//				item.setName(mCount.getString(3));
//				item.setImageUrl(mCount.getString(4));
//
//				data.add(item);
//			} while (mCount.moveToNext());
//
//		mCount.close();
//		close();
//		return data;
//	}
//
//	public ArrayList<DefaultCategoriesPojo> getDefaultItemsCategires() {
//		open();
//		Cursor mCount = database.rawQuery("SELECT * FROM `"+ DatabaseHelper.DATABASE_DEFAULT_ITEMS + "` WHERE "+DatabaseHelper.DEFAULT_ITEMS_PARENT_ID+"=0", null);
//
//		ArrayList<DefaultCategoriesPojo> data = new ArrayList<DefaultCategoriesPojo>();
//
//		mCount.moveToFirst();
//
//		if (mCount.getCount() > 0)
//			do {
//				DefaultCategoriesPojo item = new DefaultCategoriesPojo();
//				item.setId(mCount.getInt(0));
//				item.setElementid(mCount.getInt(1));
//				item.setParentID(mCount.getInt(2));
//				item.setName(mCount.getString(3));
//				item.setImageUrl(mCount.getString(4));
//
//				data.add(item);
//			} while (mCount.moveToNext());
//
//		mCount.close();
//		close();
//		return data;
//	}
//
//
//	public void insertOffLineActions(String action,int listId,int elementId)
//	{
//		open();
//		ElementPojo element=new ElementPojo();
//		element.setName(action);
//		element.setId(elementId);
//		element.setListID(listId);
//
//		boolean carryOn=true;
//			if(action.equalsIgnoreCase("unCheck"))
//			{
//				Cursor mCount = database.rawQuery("SELECT * FROM `"+ DatabaseHelper.DATABASE_OFFLINE + "` WHERE " +
//						""+DatabaseHelper.OFFLINE_ACTION+"='check' AND " +
//						""+DatabaseHelper.OFFLINE_LIST_ID+"="+listId+" AND "
//						+DatabaseHelper.OFFLINE_ELEMENT_ID+"="+elementId, null);
//				if(mCount.getCount()>0)
//				{
//					database.delete(DatabaseHelper.DATABASE_OFFLINE, DatabaseHelper.OFFLINE_ACTION+"='check' AND " +
//							""+DatabaseHelper.OFFLINE_LIST_ID+"="+element.getListID()+" AND "
//							+DatabaseHelper.OFFLINE_ELEMENT_ID+"="+element.getId(), null);
//					carryOn=false;
//				}
//			}
//			else if (action.equalsIgnoreCase("check"))
//			{
//				Cursor mCount = database.rawQuery("SELECT * FROM `"+ DatabaseHelper.DATABASE_OFFLINE + "` WHERE " +
//						""+DatabaseHelper.OFFLINE_ACTION+"='unCheck' AND " +
//						""+DatabaseHelper.OFFLINE_LIST_ID+"="+listId+" AND "
//						+DatabaseHelper.OFFLINE_ELEMENT_ID+"="+elementId, null);
//				if(mCount.getCount()>0)
//				{
//					database.delete(DatabaseHelper.DATABASE_OFFLINE, DatabaseHelper.OFFLINE_ACTION+"='unCheck' AND " +
//							""+DatabaseHelper.OFFLINE_LIST_ID+"="+element.getListID()+" AND "
//							+DatabaseHelper.OFFLINE_ELEMENT_ID+"="+element.getId(), null);
//					carryOn=false;
//				}
//			}
//			else{
//
//			}
//
//
//
//			if(carryOn)
//			{
//				ContentValues data = new ContentValues();
//				data.put(DatabaseHelper.OFFLINE_ACTION, action);
//				data.put(DatabaseHelper.OFFLINE_LIST_ID, listId);
//				data.put(DatabaseHelper.OFFLINE_ELEMENT_ID, elementId);
//
//				database.insert(DatabaseHelper.DATABASE_OFFLINE, null,data);
//			}
//		close();
//	}
//
//	public void deleteOffLineActions(ElementPojo element) {
//		open();
//			database.delete(DatabaseHelper.DATABASE_OFFLINE, DatabaseHelper.OFFLINE_ACTION+"='"+element.getName()+"' AND " +
//					""+DatabaseHelper.OFFLINE_LIST_ID+"="+element.getListID()+" AND "
//					+DatabaseHelper.OFFLINE_ELEMENT_ID+"="+element.getId(), null);
//		close();
//	}
//
//	public ArrayList<ElementPojo> getOffLineActions() {
//		open();
//		Cursor mCount = database.rawQuery("SELECT * FROM `"
//				+ DatabaseHelper.DATABASE_OFFLINE + "`", null);
//
//		ArrayList<ElementPojo> data = new ArrayList<ElementPojo>();
//
//		Log.e("","size offline "+mCount.getCount());
//		mCount.moveToFirst();
//
//		if (mCount.getCount() > 0)
//			do {
//				ElementPojo item = new ElementPojo();
//				item.setName(mCount.getString(0));
//				item.setListID(mCount.getInt(1));
//				item.setId(mCount.getInt(2));
//
//
//				data.add(item);
//			} while (mCount.moveToNext());
//
//		mCount.close();
//		close();
//		return data;
//	}
//
//
//	public void insertEmail(String email) {
//		Cursor mCount = database.rawQuery("SELECT * FROM `"+ DatabaseHelper.DATABASE_EMAIL_HISTORY + "` WHERE "+DatabaseHelper.EMAIL_HISTORY +" = '"+email+"'", null);
//		if(mCount.getCount() == 0)
//		{
//			ContentValues data = new ContentValues();
//			data.put(DatabaseHelper.EMAIL_HISTORY, email);
//
//			database.insert(DatabaseHelper.DATABASE_EMAIL_HISTORY, null, data);
//		}
//
//		mCount.close();
//	}
//
//	public ArrayList<String> getEmail() {
//		Cursor mCount = database.rawQuery("SELECT * FROM `"+ DatabaseHelper.DATABASE_EMAIL_HISTORY + "` ", null);
//		ArrayList<String> list = new ArrayList<String>();
//		mCount.moveToFirst();
//		while (!mCount.isAfterLast()) {
//			list.add(mCount.getString(0));
//			mCount.moveToNext();
//		}
//
//		mCount.close();
//		return list;
//	}
}
