insert into module(name) values ('usuario'),
                                ('rol'),
                                ('note_sale'),
                                ('detail_sale'),
                                ('repayment'),
                                ('batch'),
                                ('supplier'),
                                ('rol_module_operation'),
                                ('product');

insert into operation(name) values ('create'),
                                   ('delete'),
                                   ('update'),
                                   ('read');


insert into module_operation(module_id,operation_id) values (1,1),(1,2),(1,3),(1,4),
                                                            (2,1),(2,2),(2,3),(2,4),
                                                            (3,1),(3,2),(3,3),(3,4),
                                                            (4,1),(4,2),(4,3),(4,4),
                                                            (5,1),(5,2),(5,3),(5,4),
                                                            (6,1),(6,2),(6,3),(6,4),
                                                            (7,1),(7,2),(7,3),(7,4),
                                                            (8,1),(8,2),(8,3),(8,4),
                                                            (9,1),(9,2),(9,3),(9,4);

insert into rol(name,description) values ('admin','The person in charger of supervise all System');

insert into rol_module_operation(module_id,operation_id,rol_id) values (1,1,1),(1,2,1),(1,3,1),(1,4,1),
                                                                   (2,1,1),(2,2,1),(2,3,1),(2,4,1),
                                                                   (3,1,1),(3,2,1),(3,3,1),(3,4,1),
                                                                   (4,1,1),(4,2,1),(4,3,1),(4,4,1),
                                                                   (5,1,1),(5,2,1),(5,3,1),(5,4,1),
                                                                   (6,1,1),(6,2,1),(6,3,1),(6,4,1),
                                                                   (7,1,1),(7,2,1),(7,3,1),(7,4,1),
                                                                   (8,1,1),(8,2,1),(8,3,1),(8,4,1),
                                                                   (9,1,1),(9,2,1),(9,3,1),(9,4,1);

insert into usuario(ci,name,surname,file_name,email,password,rol_id) values('0000','solution','code','','admin@solutioncode.com','$2y$10$1Tkh8JM1SdM2hFIIWj4wQe0ifowdD4ONDblPhM5bbOTh78FDDJrJO',1);