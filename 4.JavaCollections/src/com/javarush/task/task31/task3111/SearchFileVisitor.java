package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;
    private List<Path> foundFiles = new ArrayList<>();

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file); // размер файла: content.length

        boolean containsName = true;
        if (partOfName != null && !file.getFileName().toString().contains(partOfName)) {
            containsName = false;
        }

        boolean containsContent = true;
        String stringContent = new String(content);
        if (partOfContent != null && !stringContent.contains(partOfContent)) {
            containsContent = false;
        }

        boolean matchMaxSize = true;
        if (maxSize != 0 && !(content.length <= maxSize)) matchMaxSize = false;

        boolean matchMinSize = true;
        if (!(content.length >= minSize)) matchMinSize = false;

        if (containsContent && containsName && matchMaxSize && matchMinSize) foundFiles.add(file);

        return super.visitFile(file, attrs);
    }
}
