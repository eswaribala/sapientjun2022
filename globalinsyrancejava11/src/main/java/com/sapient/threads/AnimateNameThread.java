package com.sapient.threads;

public class AnimateNameThread implements Runnable{

    private String name;
    public AnimateNameThread(String name) {
        this.name=name;
    }

    @Override
    public void run() {
      while(true) {
          for (char ch : this.name.toCharArray()) {
              System.out.print(ch);
              try {
                  Thread.sleep(1000);
              } catch (InterruptedException e) {
                  throw new RuntimeException(e);
              }
          }
          System.out.println("\n");
      }
    }
}
