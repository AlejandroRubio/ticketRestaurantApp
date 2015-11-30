package com.example.tickets.database;

import java.util.LinkedList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {


	private static final int database_VERSION = 1;
	private static final String database_NAME = "CalculoDB";

	private static final String campoId = "configuracionID";
	private static final String campoGrande = "tamanoGrandes";
	private static final String campoPequeno = "tamanoPequenos";

	private static final String[] COLUMNS = { campoId, campoGrande, campoPequeno };
	public DatabaseHelper(Context context) {
		super(context, database_NAME, null, database_VERSION);
	}


	/**Creacion de la BBDD.*/
	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_TABLE = "CREATE TABLE "+database_NAME+" ( " + campoId+ " INTEGER PRIMARY KEY AUTOINCREMENT, " +campoGrande+ " FLOAT, " + campoPequeno+" FLOAT )";
		db.execSQL(CREATE_TABLE);
	}

	/**Actualización de la BBDD completa*/
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// drop books table if already exists
		db.execSQL("DROP TABLE IF EXISTS "+database_NAME);
		this.onCreate(db);
	}

	/**Inserción de elemento en BBDD.*/
	public void crearConfiguracion(TamanoConfiguracion configuracion) {
		// get reference of the BookDB database
		SQLiteDatabase db = this.getWritableDatabase();

		// make values to be inserted
		ContentValues values = new ContentValues();
		values.put(campoGrande, configuracion.getTamanoTicketsGrandes());
		values.put(campoPequeno, configuracion.getTamanoTicketsPequenos());

		// insert book
		db.insert(database_NAME, null, values);

		// close database transaction
		db.close();
	}


	public TamanoConfiguracion leerConfiguracion(int id) {
		// get reference of the BookDB database
		SQLiteDatabase db = this.getReadableDatabase();

		// get book query
		Cursor cursor = db.query(database_NAME, // a. table
				COLUMNS, " "+campoId+" = ?", new String[] { String.valueOf(id) }, null, null, null, null);

		// if results !=null, parse the first one
		if (cursor != null)
			cursor.moveToFirst();

		TamanoConfiguracion configuracion = new TamanoConfiguracion();
		configuracion.setTamanoTicketsGrandes(cursor.getFloat(0));
		configuracion.setTamanoTicketsGrandes(cursor.getFloat(1));

		return configuracion;
	}

	public List<TamanoConfiguracion> obtenerTodasConfiguraciones() {
		List<TamanoConfiguracion> books = new LinkedList<TamanoConfiguracion>();

		// select book query
		String query = "SELECT  * FROM " + database_NAME;

		// get reference of the BookDB database
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(query, null);

		// parse all results
		TamanoConfiguracion book = null;
		if (cursor.moveToFirst()) {
			do {
				book = new TamanoConfiguracion();
				book.setId(Integer.parseInt(cursor.getString(0)));
				book.setTamanoTicketsGrandes(cursor.getFloat(1));
				book.setTamanoTicketsPequenos(cursor.getFloat(2));

				// Add book to books
				books.add(book);
			} while (cursor.moveToNext());
		}
		return books;
	}

	public int actualizarConfiguracion(TamanoConfiguracion book) {

		// get reference of the BookDB database
		SQLiteDatabase db = this.getWritableDatabase();

		// make values to be inserted
		ContentValues values = new ContentValues();
		values.put(campoGrande, book.getTamanoTicketsGrandes()); // get title
		values.put(campoPequeno, book.getTamanoTicketsPequenos()); // get author

		// update
		int i = db.update(database_NAME, values, campoId + " = ?", new String[] { String.valueOf(book.getId()) });

		db.close();
		return i;
	}

	// Deleting single book
	public void borrarConfiguracion(TamanoConfiguracion book) {

		// get reference of the BookDB database
		SQLiteDatabase db = this.getWritableDatabase();

		// delete book
		db.delete(database_NAME, campoId + " = ?", new String[] { String.valueOf(book.getId()) });
		db.close();
	}
}
