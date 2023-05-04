/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package Main;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author leyan
 */
public class VinylStorageSystem {
    public static void main(String[] args) {
        ArrayList<Record> records = new ArrayList<Record>();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (choice != 6) {
            System.out.println("Vinyl Record Storage System");
            System.out.println("---------------------------");
            System.out.println("1. Add record");
            System.out.println("2. View individual record");
            System.out.println("3. View all records");
            System.out.println("4. Update record value");
            System.out.println("5. Delete record");
            System.out.println("6. Quit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter album name: ");
                    String albumName = scanner.nextLine();
                    System.out.print("Enter artist name: ");
                    String artistName = scanner.nextLine();
                    System.out.print("Enter date released (mm/dd/yyyy): ");
                    String dateReleased = scanner.nextLine();
                    System.out.print("Enter value (USD): ");
                    double value = scanner.nextDouble();
                    scanner.nextLine();
                    records.add(new Record(albumName, artistName, dateReleased, value));
                    System.out.println("Record added successfully");
                    break;
                case 2:
                    System.out.print("Enter album name: ");
                    albumName = scanner.nextLine();
                    for (Record record : records) {
                        if (record.getAlbumName().equals(albumName)) {
                            System.out.println(record);
                            break;
                        }
                    }
                    break;
                case 3:
                    for (Record record : records) {
                        System.out.println( record);
                    }
                    break;
                case 4:
                    System.out.print("Enter album name: ");
                    albumName = scanner.nextLine();
                    for (Record record : records) {
                        if (record.getAlbumName().equals(albumName)) {
                            System.out.print("Enter new value (USD): ");
                            value = scanner.nextDouble();
                            scanner.nextLine();
                            record.setValue(value);
                            System.out.println("Value updated successfully");
                            break;
                        }
                    }
                    break;
                case 5:
                    System.out.print("Enter album name: ");
                    albumName = scanner.nextLine();
                    for (Record record : records) {
                        if (record.getAlbumName().equals(albumName)) {
                            records.remove(record);
                            System.out.println("Record deleted successfully");
                            break;
                        }
                    }
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        }
    }
}

class Record {
    private String albumName;
    private String artistName;
    private String dateReleased;
    private double value;

    public Record(String albumName, String artistName, String dateReleased, double value) {
        this.albumName = albumName;
        this.artistName = artistName;
        this.dateReleased = dateReleased;
        this.value = value;
    }

    public String getAlbumName() {
        return albumName;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getDateReleased() {
        return dateReleased;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Album name: " + albumName + "\n" +
                "Artist name: " + artistName + "\n"+ "Date Released: " + dateReleased + "\n" + "Value: $" + value;
    }
}