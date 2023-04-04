# UwAmp installation and configuration

## UwAmp installation
To install UwAmp (http://www.uwamp.com/fr/), you must download a file which can be under three forms: exe, rar and zip.
- For Zip and Rar format, after downloading the file, you must decompress the archive. He should be noted that the Rar archive is of Solid type and some alternative decompressor does not arrive
to decompress it.
- For the Exe format it is an NSIS type installation with LZMA compression

## Server launch 
In the download folder there are different folders:
- bin: contains the web server, databases and PHP versions
- phpapps: contains preinstalled php applications such as phpmyadmin.
- utils: contains additional tools.
- www: the directory containing your websites.

To launch the server, you must launch the UwAmp.exe executable.

![image](https://user-images.githubusercontent.com/98736513/229745140-53e2a1ea-7d25-4bb5-bbb8-57bf7afdbd2b.png)

Here is the main window with the servers started, we used the PHPMyAdmin tool.

![image](https://user-images.githubusercontent.com/98736513/229745258-d60eb4b5-4d25-450f-94fa-2b35292255b2.png)


## Login to phpMyAdmin
A login window automatically opens in a browser. To log in, we used, for example, the default username “root” and password “root” of the MySQL account.

![image](https://user-images.githubusercontent.com/98736513/229745495-d1e18759-7aee-47b2-9263-ab730eabea95.png)


# Creation of the database
Once connected to our server we can create a database.

## Creation of the database
Click on New database and choose a name. In collation we put “utf8_general_ci”.

![image](https://user-images.githubusercontent.com/98736513/229745736-042b86bf-2b48-42da-a238-6dc3f12b754b.png)

## Adding a table
You must choose a table name and fill in the table. We have chosen to create a score table which includes a nickname and a score. The primary key is the nickname. It will therefore be necessary that the registered nickname
by our users are unique.

## Adding information to the table
There are two ways to add information to the table:
- Via phpMyAdmin.
- Via Eclipse.
Going through phpMyAdmin, click on Insert and add the information we want verifying that the nickname is a primary key.

![image](https://user-images.githubusercontent.com/98736513/229746687-3b56b161-c19b-4a97-a3bb-ab9758cfe0e6.png)

Going through Eclipse, you must first create a connection between the database and the project Java.

# Connecting the database to Eclipse
## Connector download
To connect the database to a java project, you must download a “mysql connector-java” connector. It is a jar file which allows to connect a database and Eclipse. We
found the connector on this site: https://mavenlibs.com/jar/file/mysql/mysql-connector-java. He lists all MySQL connectors and allows you to download only the one we had
need.

## Adding the connector to the Java project
You must then add this connector to the java project. To do this, you must open the desired java project and right-click on the project name. Then go to “Build Path” then to “Configure Build Path ».

![image](https://user-images.githubusercontent.com/98736513/229747015-33c6c79b-b356-4232-bebb-ba19554f9b24.png)

A second window opens, go to “Libraries”, “Add Library” and add the connector previously downloaded.

![image](https://user-images.githubusercontent.com/98736513/229747109-460ada0f-c43b-4de4-a718-2fc260113ea2.png)

## Adding the connector in the code
Finally, we need to add the connector to the code in the place where we need to access the database. To do this, you must create a connector here called "connector". It is important to create a
exception that will be displayed if the jar connector does not exist for example. In the getConnection function, you must put the link of the database, the identifier and the password.

![image](https://user-images.githubusercontent.com/98736513/229747514-a8afac94-6c49-4899-81cf-e772d7b84660.png)
