## ผู้จัดทำ
นางสาวพิมพ์รวี ชนะศุภประกิต
6110406163

## วิธีติดตั้งโปรแกรม
* เปิด Command Prompt แล้วพิมพ์ git clone https://6110406163@bitbucket.org/6110406163/6110406163.git
* เปิดโปรแกรม IntelliJ IDEA แล้ว import โฟลเดอร์ที่มี src อยู่ข้างใน

## วิธีการติดตั้งและ run ไฟล์ jar
* กรณีที่ double click ได้ 
    - เปิด Folder ที่ clone โปรเจคมา แล้วเข้าไปที่ 6110406163\jar File and pdf จากนั้น double click ที่ jar file ชื่อว่า 6110406163.jar 
* กรณีที่ double click ไม่ได้
    - เปิด command ขึ้นมาแล้วเปลี่ยน directory ไปที่ Folder ที่มี jar file อยู่ และใช้คำสั่ง java -jar 6110406163.jar

## การวางโครงสร้าง
* controllers
    - ProfileController.java เป็น controller ใช้ควบคุม profile.fxml
    - WelcomeController.java เป็น controller ใช้ควบคุม welcome.fxml
    - LoginController.java เป็น controller ใช้ควบคุม login.fxml
    - AdministratorController.java เป็น controller ใช้ควบคุม administrator.fxml
    - StaffController.java เป็น controller ใช้ควบคุม staff.fxml
    - SetRoomInformationController.java เป็น controller ใช้ควบคุม set_room_information.fxml
    - ReceiveLetterController.java เป็น controller ใช้ควบคุม receive_letter.fxml
    - ReceiveDocumentController.java เป็น controller ใช้ควบคุม receive_document.fxml
    - ReceiveParcelController.java เป็น controller ใช้ควบคุม receive_parcel.fxml
* models
    - Document.java เก็บข้อมูลของเอกสาร
    - GuestInformation.java เก็บข้อมูลของผู้เข้าพัก
    - Guests.java เก็บ Object ของผู้เข้าพักใน ArrayList
    - Letter.java เก็บข้อมูลของจดหมาย
    - Locker.java เก็บ Object ของจดหมาย เอกสาร พัสดุใส่ใน ArrayList
    - Parcel.java เก็บข้อมูลของพัสดุ
    - RoomInformation.java เก็บข้อมูลของห้องพัก
    - Rooms.java เก็บ Object ของห้องพักใน ArrayList
    - StaffInformation.java เก็บข้อมูลของเจ้าหน้าที่ส่วนกลาง
    - Staffs.java เก็บ Object ของเจ้าหน้าที่ส่วนกลางใน ArrayList
* services
    - GuestDataSource.java เก็บ method ที่ใช้ใน GuestFileDataSource
    - GuestFileDataSource.java เป็น class ไว้สำหรับสร้าง อ่าน เขียน File ของผู้เข้าพัก
    - RoomDataSource.java เก็บ method ที่ใช้ใน RoomFileDataSource
    - RoomFileDataSource.java เป็น class ไว้สำหรับสร้าง อ่าน เขียน File ของการกำหนดข้อมูลห้อง
    - StaffDataSource.java เก็บ method ที่ใช้ใน StaffFileDataSource
    - StaffFileDataSource.java เป็น class ไว้สำหรับสร้าง อ่าน เขียน File ของเจ้าหน้าที่ส่วนกลาง
* resources
    - โฟลเดอร์ image
        - profile.jpg
    - profile.fxml แสดงหน้าข้อมูลผู้จัดทำ
    - welcome.fxml แสดงหน้าแรกของโปรแกรม
    - login.fxml แสดงหน้ากรอกรหัสผ่านเพื่อเข้าใช้ระบบ
    - administrator.fxml แสดงหน้าสมัครรหัสผ่านให้กับเจ้าหน้าที่ส่วนกลาง และตารางวันและเวลาที่เจ้าหน้าที่ส่วนกลางเข้าใชัระบบ
    - staff.fxml แสดงหน้าข้อมูลของผู้เข้าพัก
    - set_room_information.fxml แสดงหน้ากรอกข้อมูลของห้องพัก
    - receive_letter.fxml แสดงหน้ากรอกข้อมูลการรับจดหมาย
    - receive_document.fxml แสดงหน้ากรอกข้อมูลการรับเอกสาร
    - receive_parcel.fxml แสดงหน้ากรอกข้อมูลการรับพัสดุ

## สิ่งที่ทำในแต่ละสัปดาห์
* สัปดาห์ที่ 1
    - ออกแบบ GUI
* สัปดาห์ที่ 2
    - ติดตั้ง maven
* สัปดาห์ที่ 3
    - สร้าง GUI ตามที่ได้ออกแบบไว้ โดยให้ fxml อยู่ใน Package resources
    - สร้าง Package controllers
    - สร้าง class AddGuestController, AdministratorController, LoginController, ProfileController, ReceiveDocumentController,
    ReceiveLetterController, ReceiveParcelController, SetRoomInformationController, StaffController, StatusController, WelcomeController
    ใน Package controllers
    - เชื่อมปุ่มของทุกหน้า
* สัปดาห์ที่ 4
    - สร้าง Package models
    - สร้าง class Letter, Document, Parcel, Locker, StaffInformation, Staffs ใน Package models
* สัปดาห์ที่ 5
    - สร้าง Package services
    - สร้าง class StaffFileDataSource ใน Package services
    - สร้าง interface StaffDataSource ใน Package services
    - แก้ไข class StaffInformation, Staffs ใน Package models
    - แก้ไข class WelcomeController, LoginController, AdministratorController ใน Package controllers
    - แก้ไข GUI หน้า login, administrator
    - อ่านเขียนไฟล์ csv ที่เก็บข้อมูลการเข้าใช้ระบบของเจ้าหน้าที่ส่วนกลาง
    - แก้ไขไฟล์ README.md
* สัปดาห์ที่ 6
    - สร้าง interface RoomDataSource, GuestDataSource ใน Package services
    - สร้าง class RoomFileDataSource, GuestFileDataSource ใน Package services
    - สร้าง class RoomInformation, Rooms, GuestInformation, Guests ใน Package models
    - แก้ไข class AddGuestController, LoginController, ReceiveDocumentController, ReceiveLetterController, ReceiveParcelController,
    SetRoomInformationController, StaffController, WelcomeController ใน Package controllers
    - แก้ไข fxml add_guest, set_room_information ใน Package resources
    - อ่านเขียนไฟล์ csv ที่เก็บข้อมูลการตั้งค่าห้องพัก
    - อ่านเขียนไฟล์ csv ที่เก็บข้อมูลผู้เข้าพัก
    - แก้ไขไฟล์ README.md
* สัปดาห์ที่ 7
    - แก้ไข class AdministratorController, SetRoomInformationController, StaffController ใน Package controllers
    - แก้ไข class GuestInformation, RoomInformation, Rooms, StaffInformation ใน Package models
    - แก้ไข class GuestFileDataSource, RoomFileDataSource, StaffFileDataSource ใน Package services
    - แก้ไข fxml administrator, receive_document, receive_letter, receive_parcel, set_room_information, staff ใน Package resources
    - ลบ fxml add_guest, status ใน Package resources
    - ลบ class AddGuestController, StatusController ใน Package controllers
    - แสดงตารางการเข้าระบบของเจ้าหน้าที่ส่วนกลางและเรียงวันเวลาที่เจ้าหน้าที่ส่วนกลางเข้าระบบล่าสุดก่อน
    - แสดงตารางข้อมูลผู้เข้าพักและเรียงห้องพักจากน้อยไปมาก
    - เพิ่ม Folder ชื่อ jar File and pdf
    - ย้าย 6110406163.jar ไปไว้ในใน Folder jar File and pdf
    - เพิ่ม 6110406163.pdf (ยังไม่เสร็จเพราะโปรแกรมยังไม่สมบูรณ์) ใน Folder jar File and pdf
    - แก้ไขไฟล์ README.md