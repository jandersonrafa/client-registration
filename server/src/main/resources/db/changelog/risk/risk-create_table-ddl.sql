CREATE TABLE risk (
    risk_id serial NOT NULL,
	tx_name varchar(20) NOT NULL,
	dc_percentage_interest DECIMAL(5,2) NOT NULL,
	CONSTRAINT risk_tx_name_uk UNIQUE(tx_name),
    PRIMARY KEY (risk_id)
)
