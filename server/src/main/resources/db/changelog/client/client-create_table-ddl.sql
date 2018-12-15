CREATE TABLE client (
    client_id bigserial NOT NULL,
	risk_id int4 NOT NULL,
	tx_name VARCHAR(200) NOT NULL,
	dc_credit_limit DECIMAL(10,2) NOT NULL,
	dc_percentage_interest DECIMAL(5,2) NOT NULL,
	CONSTRAINT client_tx_name_uk UNIQUE(tx_name),
    PRIMARY KEY (client_id),
    FOREIGN KEY (risk_id) REFERENCES "risk"(risk_id)
)
