package sis.db;

import java.io.*;

import sis.util.IOUtil;

public class DataFile {
	private static final String DATA_EXT = ".db";
	private static final String KEY_EXT = ".idx";

	private String dataFilename;
	private String keyFilename;

	private RandomAccessFile db;
	private KeyFile keys;

	public static DataFile create(String filebase) throws Exception {
		return new DataFile(filebase, true);
	}

	public static DataFile open(String filebase) throws IOException {
		return new DataFile(filebase, false);
	}

	private DataFile(String filebase, boolean deleteFiles) throws IOException {
		dataFilename = filebase + DATA_EXT;
		keyFilename = filebase + KEY_EXT;

		if (deleteFiles){
			deleteFiles();
		}
		openFiles();
	}

	private void openFiles() throws IOException {
		keys = new KeyFile(keyFilename);
		db = new RandomAccessFile(new File(dataFilename), "rw");
	}


	public Object findBy(String id) throws IOException {
		if (!keys.containsKey(id)){
			return null;
		}
		long position = keys.getPosition(id);
		db.seek(position);

		int length = keys.getLength(id);
		return read(length);
	}

	public void add(String key, Object object) throws IOException {
		long position = db.length();

		byte[] bytes = getBytes(object);
		db.seek(position);
		db.write(bytes, 0, bytes.length);
		keys.add(key, position, bytes.length);
	}

	private byte[] getBytes(Object object) throws IOException {
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
		ObjectOutputStream outputStream = new ObjectOutputStream(byteStream);
		outputStream.writeObject(object);
		outputStream.flush();
		return byteStream.toByteArray();
	}

	private Object read(int length) throws IOException {
		byte[] bytes = new byte[length];
		db.readFully(bytes);
		return readObject(bytes);
	}

	private Object readObject(byte[] bytes) throws IOException {
		ObjectInputStream input =
				new ObjectInputStream(new ByteArrayInputStream(bytes));
		try {
			try {
				return input.readObject();
			}
			catch (ClassNotFoundException unlikely) {
				// but write a test for it if you must
				return null;
			}
		}
		finally {
			input.close();
		}
	}


	public void close() throws IOException {
		keys.close();
		db.close();
	}

	public void deleteFiles() {
		IOUtil.delete(dataFilename, keyFilename);
	}

	public int size() {
		return keys.size();
	}

}
