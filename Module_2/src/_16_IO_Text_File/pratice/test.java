package _16_IO_Text_File.pratice;

import _12_Java_Collection_Framework.practice.Student;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class test {
    public static void writeFile(Student student){
        try {
            FileWriter fileWriter = new FileWriter("student.csv",true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(student.toString());
            bufferedWriter.newLine();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
