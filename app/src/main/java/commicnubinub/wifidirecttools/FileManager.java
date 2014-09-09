package commicnubinub.wifidirecttools;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by root on 31/07/14.
 */
public class FileManager {
    private static Context context;
    private static String currentDirectory = Environment.getExternalStorageDirectory().getPath();
    private static boolean isInFileManagerMode = false;
    private static ArrayList<File> currentTree;

    public FileManager(Context c) {
        context = c;
    }

    public static boolean isIsInFileManagerMode() {
        return isInFileManagerMode;
    }

    private static void setIsInFileManagerMode(boolean isInFileManagerMode) {
        FileManager.isInFileManagerMode = isInFileManagerMode;
    }

    public static String getCurrentDirectory() {
        if (!(new File(currentDirectory).isDirectory()) || currentDirectory.length() < 1) {
            return Environment.getExternalStorageDirectory().toString();
        }
        return currentDirectory;
    }

    private static void setCurrentDirectory(String currentDirectory) {
        FileManager.currentDirectory = currentDirectory;
    }

    private static void openFile(Context context, String path) {
        try {
            Intent share = new Intent(Intent.ACTION_SEND);
            share.setType("*/*");
            share.putExtra(Intent.EXTRA_STREAM, Uri.parse(path));
            context.startActivity(Intent.createChooser(share, "Share File"));
        } catch (Exception e) {
            print("Failed to open " + (new File(path).getName()));

        }
    }

    private static void openFile(File file) {
        openFile(context, file.getPath());
    }

    public static void showTree(File dir) {
        currentDirectory = dir.getPath();

        int i = 0;
        try {
            if (dir.listFiles() != null) {
                if (!(dir.listFiles().length < 1)) {
                    if (currentTree != null)
                        currentTree.clear();
                    else
                        currentTree = new ArrayList<File>();

                    Collections.addAll(currentTree, dir.listFiles());

                    sort(currentTree);
                    print(" File hierarchy " + dir.getAbsolutePath() + " >");

                    for (File file : currentTree) {
                        ++i;
                        if (file.isDirectory())
                            print("   " + i + ".  /" + file.getName() + "/");
                        else
                            print("   " + i + ".  " + file.getName());
                    }
                } else {
                    print("   Specified folder is empty.");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            print("Failed to show :" + dir.getPath());

        }
    }

    private static void showTree(String path) {
        showTree(new File(path));
    }

    public static void openFolder(String path) {
        try {
            openFolder(new File(path));
        } catch (Exception e) {
            if (path != null)
                print("   Failed to open :" + path);
            else
                print("   Failed to open folder");

        }
    }

    private static void openFolder(File file) {
        setCurrentDirectory(file.getPath());
        showTree(file);
    }

    public static void open(int path) {
        if (currentTree.get(path - 1).isDirectory())
            openFolder(currentTree.get(path - 1));
        else
            openFile(currentTree.get(path - 1));
    }

    public static void open(String path) {
        open(new File(path));
    }

    private static void open(File file) {

        if (file.isDirectory())
            openFolder(file);
        else
            openFile(file);
    }

    private static void showFileDetails(File file) {
        try {

            print("   Name : " + file.getName());
            print("   Size : " + Tools.fileSize(file.length()));


            print("   Modified : " + Tools.getDate(file.lastModified()));


        } catch (Exception e) {
            print("   Failed to show details of " + file.getPath());

        }
    }

    public static void showFileDetails(String path) {
        showFileDetails(new File(path));
    }

    public static void showFileDetails(int path) {
        showFileDetails(currentTree.get(path));
    }

    public static void createFolder(String path) {
        createFolder(new File(path));
    }

    public static void createFolder(File file) {
        print("creating : " + file.getPath());
        try {
            // file.createNewFile();
            file.mkdirs();
            showTree(getCurrentDirectory());
        } catch (Exception e) {
        }
    }

    public static void search(String name) {


    }

    public static void delete(int file) {
        delete(currentTree.get(file - 1));
    }

    public static void delete(String file) {
        delete(new File(getCurrentDirectory() + "/" + file));
    }

    private static void delete(File file) {

        file.delete();
        print(file.getName() + " deleted");

        showTree(currentDirectory);
    }

    public static void pop(Context context) {
    }


    public static long getFreeSpace(String path) {
        return (new File(path)).getFreeSpace();
    }

    public static long getTotalSpace(String path) {
        return (new File(path)).getTotalSpace();
    }

    public static long getSizeInBytes(String file) {

        return (new File(file)).length();
    }

    public static long getSizeInBytes(File file) {
        return file.length();
    }


    public static void createFile(String name) {
        createFile(new File(name));

    }

    public static void createFile(File file) {

        try {
            file.createNewFile();
        } catch (Exception e) {
        }
        showTree(getCurrentDirectory());
    }

    public static void startFilemanager() {
        //    help();
        setIsInFileManagerMode(true);
        //  showTree(Environment.getExternalStorageDirectory());
    }

    public static void exitFilemanager() {
        setIsInFileManagerMode(false);
        print("Exiting FileManager...");
        // currentTree.clear();
        currentTree = null;
    }

    private static void print(String string) {
        Log.e("wifidirecttools:", string);
    }

    public static void sort(ArrayList<File> list) {
        Collections.sort(list, new Comparator<File>() {
            @Override
            public int compare(File file, File file2) {
                return file.getName().compareToIgnoreCase(file2.getName());
            }
        });
    }

    public static ArrayList<File> getCurrentTree() {
        return currentTree;
    }
}
