package com.academy.library;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class ReportService {

    private final LibraryService libraryService;

    public ReportService(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    public void displaySummaryReport() {
        // TODO: compute totalBooks, borrowedBooks, availableBooks, totalMembers
        int totalBooks = libraryService.getBooks().size();
        int borrowedBooks = libraryService.getBorrowRecords().size();
        int availableBooks = totalBooks-borrowedBooks;
        int totalMembers = libraryService.getMembers().size();
        // TODO: findMostPopularCategory(); print Reports block matching solution format
        String category = findMostPopularCategory();
        System.out.println("Reports: \nBooks: "+totalBooks+"\nBorrowedBooks: "+borrowedBooks
        +"\nAvailable Books: "+availableBooks+"\nTotalMemebers: "+totalMembers+"\n" +
                "\nMost Popular Category: "+ category);
    }

    public Path exportReportToFile(String fileName) throws IOException {
        // TODO: build same summary + category breakdown; Files.writeString; return Path
        int totalBooks = libraryService.getBooks().size();
        int borrowedBooks = libraryService.getBorrowRecords().size();
        int availableBooks = totalBooks-borrowedBooks;
        int totalMembers = libraryService.getMembers().size();
        String category = findMostPopularCategory();
        StringBuilder report = new StringBuilder();

        report.append("Reports\n");
        report.append("Books : ").append(totalBooks).append('\n');
        report.append("Borrowed : ").append(borrowedBooks).append('\n');
        report.append("Available : ").append(availableBooks).append('\n');
        report.append("Members : ").append(totalMembers).append('\n');
        report.append("Most Popular Category : ").append(category).append('\n');
        report.append("\nBooks per Category:\n");

        for (Map.Entry<String, Integer> entry : libraryService.getCategoryBookCount().entrySet()) {
            report.append(entry.getKey()).append(" : ").append(entry.getValue()).append('\n');
        }

        Path outputPath = Path.of(fileName);

        Files.writeString(outputPath, report.toString());

        return outputPath;
    }

    private String findMostPopularCategory() {
        // TODO: max entry by value from getCategoryBookCount(); orElse "N/A"
        String mostPopularCategory = "N/A";
        int highestCount = 0;
        for (Map.Entry<String, Integer> entry : libraryService.getCategoryBookCount().entrySet()) {
            if (entry.getValue() > highestCount) {
                highestCount = entry.getValue();
                mostPopularCategory = entry.getKey();
            }
        }

        return mostPopularCategory;
    }
}