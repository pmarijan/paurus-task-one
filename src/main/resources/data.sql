INSERT INTO taxation_rules (id, taxation_type, tax_calculation_type, tax_value) VALUES (1, 'GENERAL', 'RATE', '0.1');
INSERT INTO taxation_rules (id, taxation_type, tax_calculation_type, tax_value) VALUES (2, 'GENERAL', 'AMOUNT', '3');
INSERT INTO taxation_rules (id, taxation_type, tax_calculation_type, tax_value) VALUES (3, 'WINNINGS', 'RATE', '0.25');
INSERT INTO taxation_rules (id, taxation_type, tax_calculation_type, tax_value) VALUES (4, 'WINNINGS', 'AMOUNT', '2');

INSERT INTO location (id, name, taxation_rules_id) VALUES (1, 'Slovenia', 1);
INSERT INTO location (id, name, taxation_rules_id) VALUES (2, 'Italy', 2);
INSERT INTO location (id, name, taxation_rules_id) VALUES (3, 'Austria', 3);
INSERT INTO location (id, name, taxation_rules_id) VALUES (4, 'Croatia', 4);

INSERT INTO trader (id, location_id) VALUES (1, 1);
INSERT INTO trader (id, location_id) VALUES (2, 2);
INSERT INTO trader (id, location_id) VALUES (3, 3);
INSERT INTO trader (id, location_id) VALUES (4, 4);