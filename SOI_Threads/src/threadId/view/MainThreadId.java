package view;

import controller.ThreadId;

public class MainThreadId{
	
	public static void main(String[] args) {
		for (int idThread = 0; idThread < 5; idThread++) {
			Thread threadId = new ThreadId(idThread);
			threadId.start();
		}
		
	}
}