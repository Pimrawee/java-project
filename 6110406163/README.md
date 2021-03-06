## ผู้จัดทำ
นางสาวพิมพ์รวี ชนะศุภประกิต
6110406163

## วิธีติดตั้งโปรแกรม
* เปิด Command Prompt และเปลี่ยน directory ไปที่ Folder ที่ต้องการเก็บไฟล์ที่จะ clone
* พิมพ์ git clone https://6110406163@bitbucket.org/6110406163/6110406163.git แล้ว enter
* เปิดโปรแกรม IntelliJ IDEA แล้ว import Folder ที่มี src อยู่ข้างใน

## วิธีการ run ไฟล์ jar
* กรณีที่ double click ได้ 
    - เปิด Folder ที่ clone โปรเจคมา แล้วเข้าไปที่ ...\6110406163\jar file and pdf file จากนั้น double click ที่ jar file ที่ชื่อว่า 6110406163.jar 
* กรณีที่ double click ไม่ได้
    - เปิด command ขึ้นมาแล้วเปลี่ยน directory ไปที่ ...\6110406163\jar file and pdf file และใช้คำสั่ง java -jar 6110406163.jar

## การวางโครงสร้างไฟล์
* controllers
    - ProfileController.java เป็น controller ใช้ควบคุมการทำงานของ profile.fxml
    - ManualController.java เป็น controller ใช้ควบคุมการทำงานของ manual.fxml
    - WelcomeController.java เป็น controller ใช้ควบคุมการทำงานของ welcome.fxml
    - LoginController.java เป็น controller ใช้ควบคุมการทำงานของ login.fxml
    - ChangePasswordController.java เป็น controller ใช้ควบคุมการทำงานของ change_password.fxml
    - AdministratorController.java เป็น controller ใช้ควบคุมการทำงานของ administrator.fxml
    - StaffController.java เป็น controller ใช้ควบคุมการทำงานของ staff.fxml
    - RegisterForGuestController.java เป็น controller ใช้ควบคุมการทำงานของ register_for_guest.fxml
    - SetRoomInformationController.java เป็น controller ใช้ควบคุมการทำงานของ set_room_information.fxml
    - ReceiveLetterController.java เป็น controller ใช้ควบคุมการทำงานของ receive_letter.fxml
    - ReceiveDocumentController.java เป็น controller ใช้ควบคุมการทำงานของ receive_document.fxml
    - ReceiveParcelController.java เป็น controller ใช้ควบคุมการทำงานของ receive_parcel.fxml
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
    - GuestFileDataSource.java เป็น class ไว้สำหรับสร้างการอ่านและเขียนไฟล์ของผู้เข้าพัก
    - LockerDataSource.java เก็บ method ที่ใช้ใน LockerFileDataSource
    - LockerFileDataSource เป็น class ไว้สำหรับสร้างการอ่านและเขียนไฟล์ของตู้เก็บของ(เก็บจดหมาย/เอกสาร/พัสดุ)
    - RoomDataSource.java เก็บ method ที่ใช้ใน RoomFileDataSource
    - RoomFileDataSource.java เป็น class ไว้สำหรับสร้างการอ่านและเขียนไฟล์ของการกำหนดข้อมูลห้อง
    - StaffDataSource.java เก็บ method ที่ใช้ใน StaffFileDataSource
    - StaffFileDataSource.java เป็น class ไว้สำหรับสร้างการอ่านและเขียนไฟล์ของเจ้าหน้าที่ส่วนกลาง
* resources
    - โฟลเดอร์ image
        - profile.jpg
    - profile.fxml แสดงหน้าข้อมูลผู้จัดทำ
    - manual.fxml แสดงหน้าอธิบายการใช้งานโปรแกรม
    - welcome.fxml แสดงหน้าแรกของโปรแกรม
    - login.fxml แสดงหน้ากรอกรหัสผ่านเพื่อเข้าใช้ระบบ
    - change_password.fxml แสดงหน้าเปลี่ยนรหัสผ่าน
    - administrator.fxml แสดงหน้าสร้างบัญชีให้กับเจ้าหน้าที่ส่วนกลาง และตารางวันและเวลาที่เจ้าหน้าที่ส่วนกลางเข้าสู่ระบบ
    - staff.fxml แสดงหน้าข้อมูลของผู้เข้าพัก และเพิ่มผู้เข้าพัก
    - register_for_guest.fxml แสดงหน้าสร้างบัญชีให้กับผู้เข้าพัก
    - set_room_information.fxml แสดงหน้ากำหนดข้อมูลของห้องพัก
    - receive_letter.fxml แสดงหน้ากรอกข้อมูลจดหมายที่เจ้าหน้าที่ส่วนกลางได้รับ และตารางข้อมูลของจดหมาย
    - receive_document.fxml แสดงหน้ากรอกข้อมูลเอกสารที่เจ้าหน้าที่ส่วนกลางได้รับ และตารางข้อมูลของเอกสาร
    - receive_parcel.fxml แสดงหน้ากรอกข้อมูลพัสดุที่เจ้าหน้าที่ส่วนกลางได้รับ และตารางข้อมูลของพัสดุ

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
    - ย้าย 6110406163.jar ไปไว้ใน Folder jar File and pdf
    - เพิ่ม 6110406163.pdf (ยังไม่เสร็จเพราะโปรแกรมยังไม่สมบูรณ์) ใน Folder jar File and pdf
    - แก้ไขไฟล์ README.md
* สัปดาห์ที่ 8
    - clone project เข้าเครื่อง เพราะลงวินโดว์ใหม่
    - แก้ไข font ของ fxml ทุกหน้า
    - แก้ไข fxml receive_document, receive_letter, receive_parcel, staff, login ใน Package resources
    - แก้ไข class AdministratorController, LoginController, ReceiveDocumentController, ReceiveLetterController, ReceiveParcelController,
    StaffController, WelcomeController, ChangePassword ใน Package controllers
    - แก้ไข class Document, Guests, Letter, Locker, Parcel, Rooms, Staffs, GuestInformation ใน Package models
    - สร้าง interface LockerDataSource ใน Package services
    - สร้าง class LockerFileDataSource ใน Package services
    - อ่านเขียนไฟล์ csv ที่เก็บข้อมูลในตู้เก็บของ
    - แสดงตารางรายการจดหมาย/เอกสาร/พัสดุที่เจ้าหน้าที่ส่วนกลางได้รับและเรียงวันเวลาที่รับล่าสุดก่อน
    - ลบรายการจดหมาย/เอกสาร/พัสดุที่ผู้เข้าพักมารับแล้วออกจากตาราง
    - สร้าง class ManualController, ChangePasswordController ใน Package controllers
    - สร้าง fxml manual, change_password ใน Package resources
    - แก้ไข class GuestFileDataSource ใน Package services
    - ทำ 13.5 (extra 2 คะแนน) มีส่วนสําหรับการนําข้อมูลผู้เข้าพักออกจากห้องพัก โดยต้องมีการยืนยันก่อนที่จะนําออกจริง
    - ทำ 13.6 (5 คะแนน) เจ้าหน้าที่ส่วนกลางสามารถเปลี่ยนรหัสผ่านของตนเองได้ และรหัสผ่านใหม่ต้องใช้ได้
    - ทำ 16.1 (extra 4 คะแนน) มีระบบ register สําหรับผู้เข้าพักในคอนโด โดยผู้เข้าพักจะต้องกรอกข้อมูลที่ตรงกับข้อมูลในระบบเท่านั้นจึงจะสร้างเป็นบัญชีผู้ใช้ได้ และมีการแจ้งข้อความที่เป็นประโยชน์ต่อผู้ใช้หากข้อมูลที่กรอกนั้นไม่ถูกต้อง
    - ทำ 16.2 (extra 2 คะแนน) ผู้เข้าพักอาศัยสามารถเปลี่ยนรหัสผ่านของตนเองได้ และรหัสผ่านใหม่ต้องใช้ได้
    - แก้ไข 6110406163.pdf
    - install jar file และย้ายไปไว้ใน Folder jar File and pdf
    - แก้ไขไฟล์ README.md
    
## สิ่งที่แก้ไขในการส่งงานแก้ไขโปรเจครอบที่ 2
* แก้ไข 6110406163.pdf ใน Folder jar File and pdf
* install jar file และย้ายไปไว้ใน Folder jar File and pdf
* แก้ไขไฟล์ README.md
* ส่วนที่ขึ้นสีแดงและขึ้นคำว่า FAIL
    - เจ้าหน้าที่ส่วนกลาง - แสดงรายการหมายเลขห้องพัก ประเภทห้อง อยู่อาคารใด ชั้นใด มีใครเป็นผู้เข้าพักหรือไม่
        - แก้ไข fxml staff ใน Package resources
        - แก้ไข class StaffController ใน Package controllers
    - การโปรแกรมเชิงวัตถุขั้นสูง - โค้ดมี polymorphism ที่เหมาะสม ใช้ super/sub แทนกันได้
        - แก้ไข class ReceiveDocumentController, ReceiveLetterController, ReceiveParcelController ใน Package controllers
        - แก้ไข class Document, Letter, Locker, Parcel ใน Package models
        - แก้ไข class LockerFileDataSource ใน Package services
* ส่วนที่ขึ้นสีแดง แต่ไม่ขึ้นคำว่า FAIL
    - เจ้าหน้าที่ส่วนกลาง - เพิ่มห้องพักได้ มีการตรวจสอบรูปแบบหมายเลขห้อง ห้องพักในอาคารเดียวกันจะมีเลขซ้ำกันไม่ได้
    - เจ้าหน้าที่ส่วนกลาง - กรอกข้อมูลผู้เข้าพักไปในห้องได้
    - เจ้าหน้าที่ส่วนกลาง จัดการจดหมาย - แสดงรายการจดหมายที่ส่วนกลางได้รับ บอกข้อมูลจดหมาย วันเวลาที่รับไว้ เรียงตามวันเวลาที่รับล่าสุดก่อน
    - เจ้าหน้าที่ส่วนกลาง จัดการจดหมาย - เปลี่ยนสถานะการรับจดหมาย เมื่อผู้อาศัยมาขอรับ และเปลี่ยนกลับไม่ได้ จดหมายถูกนำออกจากรายการ
    - เจ้าหน้าที่ส่วนกลาง จัดการจดหมาย - เพิ่มข้อมูลจดหมายที่ส่วนกลางได้รับ และแสดงในรายการ
    - บันทึกและแสดงข้อมูลจาก CSV ได้ถูกต้อง
    - Graphic User Interface (GUI) ควรมีรูปแบบที่เข้าใจง่าย มีการแสดงข้อมูลที่ชัดเจน มี Label กำกับข้อมูลที่ชัดเจน ขนาดหน้าจอของโปรแกรมไม่ควรมีความสูงเกิน 1024 pixel
* ความคิดเห็นจากผู้ตรวจ
    - ควรมีไฟล์ data เริ่มต้นไว้ให้ด้วย จะได้ตรวจได้ค่ะ
        - เพิ่มข้อมูลเริ่มต้นทุกส่วนจำนวนหนึ่ง
        - push Folder data ที่เก็บไฟล์ csv

## สิ่งที่แก้ไขในการส่งงานแก้ไขโปรเจครอบที่ 3
* ยังไม่เป็น polymorphism ค่ะ ให้ยุบเมทอด toListLetter(), toListDocument(), toListParcel() ให้เหลือเมทอดเดียวค่ะ จะเห็นว่าสามเมทอดนี้โค้ดแทบจะเหมือนกันเลย และเราไม่ต้อง cast type หรือเช็ค type ก่อน add เข้า ArrayList ค่ะ add เข้าไปเฉย ๆ ได้เลย
    - แก้ไข class Document, Letter, Locker, Parcel ใน Package models
    - สร้าง interface Format ใน Package services
    - สร้าง class LetterFormat, DocumentFormat, ParcelFormat ใน Package services
    - แก้ไข class LockerFileDataSource ใน Package services
    - แก้ไข class ReceiveDocumentController, ReceiveLetterController, ReceiveParcelController ใน Package controllers
* install jar file และย้ายไปไว้ใน Folder jar File and pdf
* แก้ไขไฟล์ README.md