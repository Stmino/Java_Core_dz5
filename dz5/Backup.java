package dz5;

import java.io.IOException;

public class Backup {

    public static void main(String[] args) {
        String sourceDirectory = "D:\\java\\dz5\\files"; // Укажите вашу исходную директорию
        String backupDirectory = "D:\\java\\dz5\\backup"; // Новая директория для резервных копий

        try {
            BackupUtility.backupFiles(sourceDirectory, backupDirectory);
            System.out.println("Резервные копии созданы успешно.");
        } catch (IOException e) {
            System.err.println("Произошла ошибка при создании резервных копий: " + e.getMessage());
        }
    }
}