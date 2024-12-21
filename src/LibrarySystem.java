import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibrarySystem {
    List<Book> list=new ArrayList<>();
    public static int id=0;
    public static int count;
    private  boolean isAvailable=true;
    public void addBook(String name, String author, Genre genre,boolean isAvailable,int count) throws IOException {
        list.add(new Book(name,author,genre,id,isAvailable,count));
id++;
    }
    public void  writeToFile(String fileName) throws IOException {
      FileWriter fileWriter = new FileWriter(fileName);
       BufferedWriter bw=new BufferedWriter(fileWriter);
    for (int i=0;i<list.size();i++){
        bw.write(list.get(i).toString());
        bw.newLine();
    }
       bw.flush();
       bw.close();
    }
    public Book searchByID(int id){

        return list.get(id);
    }
    public boolean rentBook(int id){
       if (searchByID(id).getCount()>=1){
           System.out.println("successfully rented");
            count=searchByID(id).getCount();
           searchByID(id).setCount(count-1);
           System.out.println(searchByID(id));
           return true;
       }else {
           System.out.println("Unfortunately,that book is not longer available in our library");
           searchByID(id).setAvailable(false);
           return false;
       }


    }
    public List<Book> showAll(){
        return list;
    }
    public Book searchByName(String name){
        for (int i=0;i<list.size();i++){
            if (list.get(i).getName().equals(name)){
               return list.get(i);
            }
        }
        return null;
    }
    public void returnBook(int id){
        System.out.println("Thank you! Would you like to check out our other books?");
        searchByID(id).setCount(count++);

    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.addBook("the alchemist","Paulo Coelho",Genre.FICTION,true,3);
        librarySystem.addBook("sapiens"," Yuval Noah",Genre.NON_FICTION,true,5);
        librarySystem.addBook("harry potter","J.K.Rowling",Genre.FANTASY,true,4);
        librarySystem.addBook("the great gatsby","F.Scoot",Genre.CLASSIC,true,4);
        librarySystem.writeToFile("Books.txt");
        while (true) {
            System.out.println("Choose menu: 1 Show All 2 Rent Book 3 Return Book 4 Search Book 5 Exit System ");
            switch (sc.nextInt()) {
                case 1:
                    System.out.println( librarySystem.showAll());;

                    break;
                case 2:
                    System.out.println("Write ID of book");
                    librarySystem.rentBook(sc.nextInt());
                    break;
                case 3:
                    System.out.println("Write ID of book");
                    librarySystem.returnBook(sc.nextInt());
                    break;
                case 4:
                    System.out.println("Write name of book");
                    System.out.println(librarySystem.searchByName(sc.next().toLowerCase()));
                    break;
                case 5:
                    System.out.println("See you later");
                    System.exit(0);
                    break;
                default:
                    System.out.println("No such operation was found");
            }
        }

}}
