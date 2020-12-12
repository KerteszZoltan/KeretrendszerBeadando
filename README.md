# Keretrendszer alapú programozás
## Program leírás
A programom autók kezelésére alkalmas.
Lehetőség van az autók kilistázására, törlésére és módosítására. Ezen kívül lehetséges új autót is felvinni az adatbázisba.
A szervert el lehet érni REST-en keresztül is. 

## Futtatási környezet
Felhasznált programok: IntelliJ, XAMPP, Microsoft Edge böngésző, Opera böngésző
Használt XAMPP modulok: Apache, MySQL, Tomcat
Operációs rendszer: Windows 10

## Adatbázisban nyilvántartott adatok
- Adatbázis: kocsiks
- Tábla: kocsidb
- Táblában nyilvántartott mezők(tipussal):\ 
id(varchar(255)), tipus(varchar(255)), keszult(date), keszultdb(int), telephe(varchar(255)), kategoria(varchar(255))
- Kulcs mező: id

## Config beállítások
- Tomcat verzió: 9.0.41
- Alapértelmezett böngésző: Microsoft Edge
- HTTP port: 8080
- JMX port: 1099
- Build Artifacts: web:war exploded
- JRE: 1.8
- Java verzió: 8
