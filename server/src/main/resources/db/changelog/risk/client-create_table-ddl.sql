CREATE TABLE client (
    client_id serial NOT NULL,
	tx_name varchar(200) NOT NULL,
	dc_credit_limit decimal(10,2) NOT NULL,
	CONSTRAINT client_tx_name_uk UNIQUE(tx_name),
    PRIMARY KEY (client_id)
)
