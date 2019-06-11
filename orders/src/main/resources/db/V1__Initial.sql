CREATE TABLE IF NOT EXISTS product (
  	product_id INT NOT NULL AUTO_INCREMENT,
  	product_name VARCHAR(128) NULL,
  	unit_price DECIMAL(8,2) NULL,
  	PRIMARY KEY (product_id)
  	);

CREATE TABLE IF NOT EXISTS account (
	account_id INT NOT NULL AUTO_INCREMENT,
  	name VARCHAR(128) NULL,
   	email_id VARCHAR(128) NULL,
  	phone INT NULL,
  	PRIMARY KEY (account_id)
);
  
CREATE TABLE IF NOT EXISTS order_table (
  	order_id INT NOT NULL AUTO_INCREMENT,
  	account_id INT NOT NULL,
  	product_id INT NOT NULL,
  	quantity INT NOT NULL,
  	date DATE NOT NULL,
  	status VARCHAR(64) NOT NULL,
  	PRIMARY KEY (order_id)
);