package dz5;

import java.io.File;

public class Tree {

    public static void main(String[] args) {
        File rootDir = new File(".");
        print(rootDir, "", true, rootDir.getAbsolutePath());
    }

    public static void print(File file, String indent, boolean isLast, String rootPath) {
        String relativePath = file.getAbsolutePath().substring(rootPath.length());

        System.out.print(indent);
        if (isLast) {
            System.out.print("└─");
            indent += "  ";
        } else {
            System.out.print("├─");
            indent += "│ ";
        }
        System.out.println(relativePath);

        File[] files = file.listFiles();
        if (files == null)
            return;

        int subDirTotal = 0;
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory())
                subDirTotal++;
        }

        int subDirCounter = 0;
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                subDirCounter++;
                print(files[i], indent, subDirCounter == subDirTotal, rootPath);
            }
        }
    }
}