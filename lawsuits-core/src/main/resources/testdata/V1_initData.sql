
insert into address(id, city, post_code, street, street_number) VALUES (1, 'Warszawa', '02-350', 'Siewierska', '6/10');
insert into office(id, name, address_id) VALUES (1, 'Kancelaria', 1);
insert into court (id, name, address_id) VALUES (1, 'Sąd Rejonowy', 1);
insert into respondent(id, name, address_id) VALUES (1, 'mBank', 1);
insert into representative(id, name, representative_title, surname, office_id) VALUES (1, 'Marek', 'SOLICITOR', 'Żero', 1);
insert into plaintiff(id, name, surname, representative_id) VALUES (1, 'Beata', 'Humwniuk', 1);
insert into lawsuit(id, code, date, lawsuit_response, signature, court_id, respondent_id) VALUES (1, 'SENT', '2022-01-15 12:12:02.586000', 'Ala ma kota', 'ABC/123', 1, 1);
insert into lawsuit_plaintiffs(lawsuit_id, plaintiffs_id) VALUES (1,1);
