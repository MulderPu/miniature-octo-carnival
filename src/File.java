import java.io.*;
import java.util.ArrayList;

/**
 * Project Name : miniature-octo-carnival
 * Created by Mulder on 5/3/2016.
 */
public class File {



    public static void main(String[] args) throws IOException {
        try {
            readStudentFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //read student file
    private static void readStudentFile() throws IOException {
//        try {
//            FileInputStream fis = new FileInputStream("student.txt");
//            ObjectInputStream ois = new ObjectInputStream(fis);
//            studentList = (Array) ois.readObject();
//            ois.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        FileInputStream fis = null;
        int i = 0;
        char c;

        try{
            // create new file input stream
            fis = new FileInputStream("student.txt");

            // read till the end of the file
            while((i=fis.read())!=-1)
            {
                // converts integer to character
                c=(char)i;

                // prints character
                System.out.print(c);
            }
        }catch(Exception ex){
            // if any error occurs
            ex.printStackTrace();
        }finally{

            // releases all system resources from the streams
            if(fis!=null)
                fis.close();
        }
    }

    //write student file
    private static void writeStudentFile(){
//        try {
//            FileOutputStream fos = new FileOutputStream("student.txt");
//            ObjectOutputStream oos = new ObjectOutputStream(fos);
//            oos.writeObject(student);
//            oos.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
