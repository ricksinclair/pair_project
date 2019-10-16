CREATE SCHEMA IF NOT EXISTS shipments;

use shipments;

CREATE TABLE IF NOT EXISTS tracking(
id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
tracking_number VARCHAR(25) NOT NULL,
recipient_name VARCHAR(80) NOT NULL);



