INSERT INTO "CK"."CONTACT_TEL_INFO"(
            contact_tel_id, tel_type, tel_number)
    VALUES (10, 'Mobile', '9000799287');
INSERT INTO "CK"."CONTACT"(
            contact_id, first_name, last_name, work_company, contact_tel_id)
    VALUES (100, 'Uday Shankar','Chejerla','Tech Mahindra', 10);
    
INSERT INTO "CK"."CONTACT_TEL_INFO"(
            contact_tel_id, tel_type, tel_number)
    VALUES (20, 'Mobile', '9000799359');
INSERT INTO "CK"."CONTACT"(
            contact_id, first_name, last_name, work_company, contact_tel_id)
    VALUES (200, 'Pranamya','Singh','Bank of Baroda', 20);

INSERT INTO "CK"."CONTACT_TEL_INFO"(
            contact_tel_id, tel_type, tel_number)
    VALUES (30, 'Landline', '4066672468');
INSERT INTO "CK"."CONTACT"(
            contact_id, first_name, last_name, work_company, contact_tel_id)
    VALUES (300, 'Manash','Kalita','Nissan', 30);
    
Select * from "CK"."CONTACT" c join "CK"."CONTACT_TEL_INFO" t on c.CONTACT_TEL_ID = t.CONTACT_TEL_ID;