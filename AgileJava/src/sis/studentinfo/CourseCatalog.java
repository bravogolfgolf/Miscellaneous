package sis.studentinfo;

import java.io.*;
import java.util.*;

public class CourseCatalog {
	List<Session> sessions = new ArrayList<Session>();

	public void add(Session session) {
		sessions.add(session);
	}

	public void clearAll() {
		sessions.clear();
	}

	public List<Session> getSessions() {
		return sessions;
	}

	public void store(String filename) throws IOException {
		ObjectOutputStream output = null;
		try{
			output = new ObjectOutputStream(new FileOutputStream(filename));
			output.writeObject(sessions);
		}
		finally{
			output.close();
		}
	}


	@SuppressWarnings("unchecked")
	public void load(String filename) throws Exception {
		ObjectInputStream input = null;
		try{
			input = new ObjectInputStream(new FileInputStream(filename));
			clearAll();
			sessions = (List<Session>)input.readObject();
		}
		finally{
			input.close();
		}

	}

}