package services;

import models.*;

import java.io.*;

public class LockerFileDataSource implements LockerDataSource{
    private String fileDirectoryName;
    private String fileName;
    private Locker locker;

    public LockerFileDataSource(String fileDirectoryName, String fileName) {
        this.fileDirectoryName = fileDirectoryName;
        this.fileName = fileName;
        checkFileIsExisted();
    }

    private void checkFileIsExisted() {
        File file = new File(fileDirectoryName);
        if (!file.exists()) {
            file.mkdirs();
        }
        String filePath = fileDirectoryName + File.separator + fileName;
        file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println("Cannot create " + filePath);
            }
        }
    }

    private void readData() throws IOException {
        String filePath = fileDirectoryName + File.separator + fileName;
        File file = new File(filePath);
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);
        String line = "";
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            if (data[0].equals("Letter")){
                Letter letter = new Letter(data[2].trim(), data[3].trim(), data[4].trim(), data[5].trim());
                letter.setTime(data[1].trim());
                locker.addItem(letter);
            }
            else if (data[0].trim().equals("Document")){
                Document document = new Document(data[2].trim(), data[3].trim(), data[4].trim(), data[5].trim(), data[6].trim());
                document.setTime(data[1].trim());
                locker.addItem(document);
            }
            else if (data[0].trim().equals("Parcel")){
                Parcel parcel = new Parcel(data[2].trim(), data[3].trim(), data[4].trim(), data[5].trim(), data[6].trim(), data[7].trim());
                parcel.setTime(data[1].trim());
                locker.addItem(parcel);
            }
        }
        reader.close();
    }

    @Override
    public Locker getLockerData() {
        try {
            locker = new Locker();
            readData();
        } catch (FileNotFoundException e) {
            System.err.println(this.fileName + " not found");
        } catch (IOException e) {
            System.err.println("IOException from reading " + this.fileName);
        }
        return locker;
    }

    @Override
    public void setLockerData(Locker locker) {
        String filePath = fileDirectoryName + File.separator + fileName;
        File file = new File(filePath);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            for (Letter l : locker.getLockers()) {
                writer.append(l.getFormat());
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.err.println("Cannot write " + filePath);
        }
    }
}
