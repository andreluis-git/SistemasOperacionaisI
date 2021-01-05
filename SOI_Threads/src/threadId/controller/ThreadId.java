package controller;

 

public class ThreadId extends Thread {
    
    private int idThread;
    
    public ThreadId(int idThread) {
        this.idThread = idThread;
    }
    
    public void run() {
        System.out.println(idThread);
//		  Mostrar usando getId
//        Thread currentThread = Thread.currentThread();
//        System.out.println("GetID: " + currentThread.getId());
    }
}