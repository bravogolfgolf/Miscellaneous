package sis.db;

import java.io.*;

public class KeyFile {
	private RandomAccessFile keys; 

	public KeyFile(String keyFileName) throws FileNotFoundException {
		keys = new RandomAccessFile(keyFileName,"rw");
	}

	public long size() throws IOException {
		return keys.length();
	}

	public void add(String key, long position, int length) throws IOException {
		keys.writeUTF(key);
		keys.writeLong(position);
		keys.writeInt(length);
	}

}
