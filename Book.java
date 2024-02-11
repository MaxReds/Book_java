import java.util.*;

public class Book {
    private HashMap<String, TreeSet<String>> phoneBook;

    public Book() {
        phoneBook = new HashMap<>();
    }

    public void addContact(String name, String number) {
        TreeSet<String> phones = phoneBook.getOrDefault(name, new TreeSet<>());
        phones.add(number);
        phoneBook.put(name, phones);
       
        }

    public void printBook(){
        for (String name : phoneBook.keySet()) {
            TreeSet<String> phones = phoneBook.get(name);
            System.out.println(name + " : " + phones);
        }
    }

    public List<String> sortContactsByNumbers() {
        List<Map.Entry<String, TreeSet<String>>> sortedEntries = new ArrayList<>(phoneBook.entrySet());
        sortedEntries.sort((e1, e2) -> e2.getValue().size() - e1.getValue().size());
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, TreeSet<String>> entry : sortedEntries) {
            result.add(entry.getKey() + ": " + entry.getValue());

        }
        return result;

    }


    public static void main(String[] args) {
        Book pb = new Book();
        pb.addContact("Max", "+ 1 - 1234");
        pb.addContact("Kazuya Mishima", "+1 - 12334");
        pb.addContact("Paul Phoenix", "+1 - 1235534");
        pb.addContact("Jin Kazama", "+7 - 123455");
        pb.addContact("King", "+ 7 - 12346");
        pb.addContact("King", "+ 7 - 22346");
        pb.addContact("King", "+ 7 - 32346");
        pb.addContact("Jin Kazama", "+7 - 1234555");
        pb.addContact("Max", "+ 1 - 18234");
        

        System.out.println("All contacts is: ");
        pb.printBook();

        

        List<String> sortedContacts = pb.sortContactsByNumbers();
        System.out.println("Contacts sorted by numbers: ");
        for (String contact : sortedContacts) {
            System.out.println(contact);
        }

    }
    

}


    

