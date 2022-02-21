#Work of Assignment_I

###-- Design --

1. LOGIN (API LOAD)
    - เช็ตว่า User นี้มีในตารางหรือเปล่า
    - ถ้าหาไม่มีก็ให้ไปสมัครใหม่

2. ค้นหาสินค้าด้วย Keyword "Adidas NMD" (API LOAD)
   - ในตารางมีสินค้าอยู่ 5 อย่าง
   - กำหนดตารางให้เป็น Product[ProductID, ProductName, ProductType, ProductPrice, Product Discount, ProductCount, ShopId]

3. ทำการเลือกสินค้ามา 1 อย่าง (API LOAD)
   - ส่ง ProductId ไปเพื่อเอาของ Data ของของชิ้นนั้นๆ มาแสดง

4. Add to Basket (API SAVE)
   - Save data to Table: Basket 

5. ดูของใน Basket (API LOAD)
   - แสดงรายการใน Table: Basket + ว่ามีสินค้าอะไรอยู่บ้าง

6. กดชำระเงินค้า
   
7. Shipping เลือกที่อยู่ (API LOAD)
   - ดึงที่อยุ่ของ User มาจากตาราง ที่อยู่

8. จ่ายเงิน (API SAVE) ส่ง Data ของการจ่ายเงินไปบันทึกไว้ที่ Table: Payment 
   - Visa
   - PayPal
   - LinePay
   - ปลายทาง
   
9. Confirm Order (API SAVE) บันทึกข้อมูลลง Table: Orders
   - เก็บข้อมูลของ Summary Datail ทั้งหมด
   - สถานะ

10. Summary Detail (API LOAD) 
    - Show data table: Orders


