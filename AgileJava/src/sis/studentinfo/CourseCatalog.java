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
		DataOutputStream output = null;
		try{
			FileOutputStream fileOutputStream = new FileOutputStream(filename);
			output = new DataOutputStream(fileOutputStream);
			output.writeInt(sessions.size());
			for(Session session:sessions){
				output.writeLong(session.getStartDate().getTime());
				output.writeInt(session.getNumberOfCredits());
				output.writeUTF(session.getCourse().getDepartment());
				output.writeUTF(session.getCourse().getNumber());
			}
		}
		finally{
			output.close();
		}
	}

	public void load(String filename) throws IOException {
		DataInputStream input = null;
		try{
			int count;
			FileInputStream fileInputStream = new FileInputStream(filename);
			input = new DataInputStream(fileInputStream);
			clearAll();
			count = input.readInt();
			for (int i = 0; i < count ; i++){
				long date = input.readLong();
				int credits = input.readInt();
				String department = input.readUTF();
				String number = input.readUTF();
				Session session;
				
				session = CourseSession.create(new Course(department, number), new Date(date));
				session.setNumberOfCredits(credits);
				sessions.add(session);
			}
		}
		finally{
			input.close();
		}

	}

}
