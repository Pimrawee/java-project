package services;

import models.GuestInformation;
import models.Guests;

import java.io.*;

public class GuestFileDataSource implements GuestDataSource{
    private String fileDirectoryName;
    private String fileName;
    private Guests guests;

    public GuestFileDataSource(String fileDirectoryName, String fileName) {
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
            GuestInformation guestInformation = new GuestInformation(data[0].trim(), data[3].trim(), data[2].trim());
            guestInformation.setBuilding(data[1].trim());
            guestInformation.setType(data[4].trim());
            guestInformation.setRoomGuestCon(data[5].trim());
            guests.add(guestInformation);
        }
        reader.close();
    }

    @Override
    public Guests getGuestsData() {
        try {
            guests = new Guests();
            readData();
        } catch (FileNotFoundException e) {
            System.err.println(this.fileName + " not found");
        } catch (IOException e) {
            System.err.println("IOException from reading " + this.fileName);
        }
        return guests;
    }

    @Override
    public void setGuestsData(Guests guests) {
        String filePath = fileDirectoryName + File.separator + fileName;
        File file = new File(filePath);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            for (GuestInformation r : guests.toList()) {
                String line = r.getName() + ","
                        + r.getBuilding() + ","
                        + r.getFloor() + ","
                        + r.getRoom() + ","
                        + r.getType() + ","
                        + r.getRoomGuestCon();
                writer.append(line);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.err.println("Cannot write " + filePath);
        }
    }
}
