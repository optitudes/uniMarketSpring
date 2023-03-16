insert into admin_teatro values (1, "4587" , "admin1@gmail.com" ,1);
insert into admin_teatro values (2, "7854" , "admin2@gmail.com" ,2);
insert into admin_teatro values (3, "6941" , "admin3@gmail.com" ,3);
insert into admin_teatro values (4, "2151" , "admin4@gmail.com" ,4);
insert into admin_teatro values (5, "6341" , "admin5@gmail.com" ,5);

insert into administrator values (1, "7567", "administrador1@gmail.com");
insert into administrator values (2, "6544", "administrador2@gmail.com");
insert into administrator values (3, "5651", "administrador3@gmail.com");
insert into administrator values (4, "5641", "administrador4@gmail.com");
insert into administrator values (5, "5331", "administrador5@gmail.com");

insert into ciudad values (1, "Armenia");
insert into ciudad values (2, "Pereira");
insert into ciudad values (3, "Manizales");
insert into ciudad values (4, "Cali");
insert into ciudad values (5, "Cali");

insert into tarjeta (id_tarjeta,tipo_tarjeta)values (1,1);
insert into tarjeta (id_tarjeta,tipo_tarjeta)values (2,1);
insert into tarjeta (id_tarjeta,tipo_tarjeta)values (3,2);
insert into tarjeta (id_tarjeta,tipo_tarjeta)values (4,1);
insert into tarjeta (id_tarjeta,tipo_tarjeta)values (5,2);

insert into cliente  values (1, "1234", "jhon@gmail.com", 1, "Jhon.jpg", "Jhon gonzales orozco",1,1);
insert into cliente  values (2, "1234", "juan@gmail.com", 1, "Juan.jpg", "Juan gonzales orozco",1,1);
insert into cliente  values (3, "1234", "jairo@gmail.com", 1, "Jairo.jpg", "Jairo gonzales orozco",1,1);
insert into cliente  values (4, "1234", "jose@gmail.com", 1, "Jose.jpg", "Jose gonzales orozco",1,1);
insert into cliente  values (5, "1234", "julian@gmail.com", 1, "Julian.jpg", "Julian gonzales orozco",1,1);
insert into cliente  values (6, "1234", "jhonal@gmail.com", 1, "Jhonal.jpg", "Jhonal gonzales orozco",1,1);

insert into cliente_telefonos values (1, "123456");
insert into cliente_telefonos values (2, "123312");
insert into cliente_telefonos values (3, "173912");
insert into cliente_telefonos values (4, "123616");
insert into cliente_telefonos values (5, "167823");
insert into cliente_telefonos values (6, "123433");

insert into confiteria values(1,"url","galletas",2000);
insert into confiteria values(2,"url","papitas picantes",6000);
insert into confiteria values(3,"url","yupi",3000);
insert into confiteria values(4,"url","perro caliente",12000);
insert into confiteria values(5,"url","hamburguesa",23000);

insert into horario values(1,"24:10:10");
insert into horario values(2,"22:10:13");

insert into pelicula values(1,1,"url","la llorona","carlos y juan","una niña que llora mucho","terror","url");
insert into pelicula values(2,1,"url","la happy","laura y novio","una pareja muy feliz","diversion","url");
insert into pelicula values(3,0,"url","la tusa","frank y edison","una pareja gay con tusa","amor","url");
insert into pelicula values(4,1,"url","los jovenes que sacan 5","edison, frank, murcia y sebas","unos jovenes que sacan 5 en programacion","terror","url");
insert into pelicula values(5,0,"url","la tesis","jarol y angui","un paseo por la inversidad","terror","url");

insert into factura values(1,1);
insert into factura values(2,2);
insert into factura values(3,3);
insert into factura values(4,4);
insert into factura values(5,5);
insert into factura values(6,6);

insert into merchandising values (1,"url","juguete",20000);
insert into merchandising values (2,"url","juguete2",30000);
insert into merchandising values (3,"url","juguete3",60000);
insert into merchandising values (4,"url","juguete4",40000);
insert into merchandising values (5,"url","juguete5",20000);

insert into cliente_merchandising values(1,1,2);
insert into cliente_merchandising values(2,2,3);
insert into cliente_merchandising values(3,3,4);
insert into cliente_merchandising values(4,4,5);
insert into cliente_merchandising values(5,5,2);
insert into cliente_merchandising values(6,6,3);



insert into teatro values (1, "calle 20 # 2", "SAO local 101", 1, 1, 1);
insert into teatro values (2, "carrera 11 # 6", "Unicentro local 201", 1, 1,1);
insert into teatro values (3, "calle 15 # 10", "Parque Arboleda", 3, 2, 1);
insert into teatro values (4, "carrera 10 # 22", "Parque Lleras", 2, 3, 1);
insert into teatro values (5, "carrera 10 # 22", "Parque Lleras", 2, 3, 1);

insert  into sala values (1,1);
insert  into sala values (2,1);
insert  into sala values (3,2);
insert  into sala values (4,3);
insert  into sala values (5,4);
insert  into sala values (6,5);

insert into silla values (1,1);
insert into silla values (2,1);
insert into silla values (3,1);
insert into silla values (4,1);
insert into silla values (5,2);
insert into silla values (6,2);
insert into silla values (7,3);
insert into silla values (8,3);
insert into silla values (9,4);
insert into silla values (10,4);
insert into silla values (11,5);
insert into silla values (12,5);
insert into silla values (13,6);
insert into silla values (14,6);


insert into confiteria_cliente values(1,2000,1,1);
insert into confiteria_cliente values(2,2000,1,2);
insert into confiteria_cliente values(3,6000,2,3);
insert into confiteria_cliente values(4,6000,2,4);
insert into confiteria_cliente values(5,3000,3,5);
insert into confiteria_cliente values(6,3000,3,6);
insert into confiteria_cliente values(7,12000,4,6);
insert into confiteria_cliente values(8,12000,4,6);


insert into cupon values (1,"fidelidad",0,"2022-10-02",1000,1,6);
insert into cupon values (2,"fidelidad",1,"2022-10-10",1000,2,5);
insert into cupon values (3,"fidelidad",1,"2022-10-20",7000,3,4);
insert into cupon values (4,"fidelidad",0,"2022-10-10",4000,4,3);
insert into cupon values (5,"fidelidad",1,"2022-10-11",3000,5,2);
insert into cupon values (6,"fidelidad",0,"2022-10-05",2000,6,1);

insert into funcion values (1,1,1,1);
insert into funcion values (2,2,2,2);
insert into funcion values (3,1,3,3);
insert into funcion values (4,2,4,4);
insert into funcion values (5,1,5,5);

insert into ubica_silla values (13, 13);
insert into ubica_silla values (12,12);
insert into ubica_silla values (11,11);
insert into ubica_silla values (10,10);
insert into ubica_silla values (1,1);
insert into ubica_silla values (2,2);
insert into ubica_silla values (3,3);
insert into ubica_silla values (4,4);
insert into ubica_silla values (5,5);
insert into ubica_silla values (6,6);
insert into ubica_silla values (9,9);
insert into ubica_silla values (8,8);
insert into ubica_silla values (7,7);

insert into entrada values (1,2,1,1,1,1,1);
insert into entrada values (2,3,2,1,1,1,2);
insert into entrada values (3,2,3,1,1,4,3);
insert into entrada values (4,2,4,1,1,2,4);
insert into entrada values (5,1,5,1,1,1,5);

