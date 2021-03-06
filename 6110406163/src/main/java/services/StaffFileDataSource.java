package services;

import models.StaffInformation;
import models.Staffs;

import java.io.*;

public class StaffFileDataSource implements StaffDataSource{
    private String fileDirectoryName;
    private String fileName;
    private Staffs staffs;

    public StaffFileDataSource(String fileDirectoryName, String fileName) {
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
            StaffInformation staffInformation = new StaffInformation(data[1].trim(), data[2].trim(), data[3].trim());
            staffInformation.setDate(data[0].trim());
            staffs.addStaff(staffInformation);
        }
        reader.close();
    }

    @Override
    public Staffs getStaffsData() {
        try {
            staffs = new Staffs();
            readData();
        } catch (FileNotFoundException e) {
            System.err.println(this.fileName + " not found");
        } catch (IOException e) {
            System.err.println("IOException from reading " + this.fileName);
        }
        return staffs;
    }

    @Override
    public void setStaffsData(Staffs staffs) {
        String filePath = fileDirectoryName + File.separator + fileName;
        File file = new File(filePath);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            for (StaffInformation s : staffs.toList()) {
                String line = s.getDate() + ","
                        + s.getName() + ","
                        + s.getUsername() + ","
                        + s.getPassword();
                writer.append(line);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.err.println("Cannot write " + filePath);
        }
    }
}
