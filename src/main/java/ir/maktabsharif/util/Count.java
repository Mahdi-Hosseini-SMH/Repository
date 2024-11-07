package ir.maktabsharif.util;

import ir.maktabsharif.repository.impl.StudentRepositoryImpl;

import java.io.IOException;
import java.nio.CharBuffer;

public class Count extends Thread {
   StudentRepositoryImpl studentRepository = new StudentRepositoryImpl();
    @Override
    public void run() {
        while (true) {
            Long count = studentRepository.countStudents();
            System.out.println(count);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}