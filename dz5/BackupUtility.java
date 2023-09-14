package dz5;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class BackupUtility {

    public static void backupFiles(String sourceDirectory, String backupDirectory) throws IOException {
        File sourceDir = new File(sourceDirectory);
        File backupDir = new File(backupDirectory);

        if (!sourceDir.exists()) {
            System.err.println("Исходная директория не существует.");
            return;
        }

        if (!backupDir.exists()) {
            backupDir.mkdirs();
        }

        if (!backupDir.isDirectory()) {
            System.err.println("Путь к резервной директории указывает на файл, а не на директорию.");
            return;
        }

        File[] files = sourceDir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    File backupFile = new File(backupDir, file.getName() + ".bak");
                    if (!backupFile.exists()) {
                        Files.copy(file.toPath(), backupFile.toPath());
                    }
                }
            }
        }
    }
}