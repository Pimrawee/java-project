package services;

import models.RoomInformation;
import models.Rooms;

import java.io.*;

public class RoomFileDataSource implements RoomDataSource{
    private String fileDirectoryName;
    private String fileName;
    private Rooms rooms;

    public RoomFileDataSource(String fileDirectoryName, String fileName) {
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
            RoomInformation roomInformation = new RoomInformation(data[2].trim(),
                    data[1].trim(), data[3].trim());
            roomInformation.setBuilding(data[0].trim());
            roomInformation.setMaxGuests(Integer.parseInt(data[4].trim()));
            roomInformation.setNumGuests(Integer.parseInt(data[5].trim()));
            roomInformation.setRoomCon(data[6].trim());
            rooms.add(roomInformation);
        }
        reader.close();
    }

    @Override
    public Rooms getRoomsData() {
        try {
            rooms = new Rooms();
            readData();
        } catch (FileNotFoundException e) {
            System.err.println(this.fileName + " not found");
        } catch (IOException e) {
            System.err.println("IOException from reading " + this.fileName);
        }
        return rooms;
    }

    @Override
    public void setRoomsData(Rooms rooms) {
        String filePath = fileDirectoryName + File.separator + fileName;
        File file = new File(filePath);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            for (RoomInformation r : rooms.toList()) {
                String line = r.getBuilding() + ","
                        + r.getFloor() + ","
                        + r.getRoom() + ","
                        + r.getType() + ","
                        + r.getMaxGuests() + ","
                        + r.getNumGuests() + ","
                        + r.getRoomCon();
                writer.append(line);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.err.println("Cannot write " + filePath);
        }
    }
}
