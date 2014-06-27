package sis.db;

import java.io.*;

public class DataFile {
	private RandomAccessFile db;
	private KeyFile keys;

	public static DataFile open(String dirBasename) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object findBy(String id) {
		// TODO Auto-generated method stub
		return null;
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

	public void close() {
		// TODO Auto-generated method stub

	}

	public void deleteFiles() {
		// TODO Auto-generated method stub

	}

	public static DataFile create(String filebase) throws FileNotFoundException {
		DataFile dataFile = new DataFile();
		String dbFileName = filebase + ".db";
		String keyFileName = filebase + ".key";
		dataFile.db = new RandomAccessFile(new File(dbFileName), "rw");
		dataFile.keys = new KeyFile(keyFileName);
		return dataFile;
	}

	public long size() throws IOException {
		return keys.size();
	}

}
