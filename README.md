Team-CS509
==========

Design of software system
User Manual
<Web application for abuse report>
Course CS509-Design of Software Systems
Group 2:
Chengjiao Yang
Mohammed Ayub
Qiukun Lin
Rui Jin
Rundong Yu
Wenxin Zhao
Yichen Lin
User’s Manual Page ii
Revision Sheet
Release No. Date Revision Description
Rev. 0
4/27/14
User’s Manual Created
Rev. 1
4/30/14
Fixed MySQL commands realize additional function
User’s Manual Page iii
USER'S MANUAL
TABLE OF CONTENTS
Page #
1.0 GENERAL INFORMATION ...................................................................................................... 1-1
1.1 System Overview .................................................................................................................... 1-1
1.2 Acronyms and Abbreviations ................................................................................................ 1-1
2.0 SYSTEM SUMMARY .................................................................................................................. 2-1
2.1 System Configuration ............................................................................................................. 2-1
2.2 User Access Levels .................................................................................................................. 2-1
3.0 GETTING STARTED .................................................................................................................. 3-1
3.1 Setting up MySQL and Apache Tomcat ............................................................................... 3-1
3.2 Create the database ................................................................................................................ 3-1
3.3 Setting up database ................................................................................................................. 3-1
3.4 Setting up Database connection ............................................................................................. 3-1
3.5 Running Tomcat ..................................................................................................................... 3-2
3.6 Open web application ............................................................................................................. 3-3
4.0 USING THE WEB APPLICATION ........................................................................................... 4-1
4.1 Users Login .............................................................................................................................. 4-1
4.2 Staff users from healthcare agency ....................................................................................... 4-1
4.3 Supervisor users from healthcare agency ............................................................................. 4-2
4.4 HRC employee user ................................................................................................................ 4-4
4.5 Administrator ......................................................................................................................... 4-5
5.0 TROUBLESHOOT PROBLEMS AND GET SUPPORT .......................................................... 5-1
5.1 Troubleshoot ........................................................................................................................... 5-1
5.2 Support service ....................................................................................................................... 5-1
1.0 General Information
User’s Manual
1.0 GENERAL INFORMATION
1.0 General Information
User’s Manual Page 1-1
1.0 GENERAL INFORMATION GENERAL INFORMATIONGENERAL INFORMATION GENERAL INFORMATION GENERAL INFORMATION
1.1 System Overview
This software system will be a Web application which helps Group Home staff and supervisors to report incidents of abuse to the Disabled Persons Protection Commission (DPPC) and in turn report to Department of Developmental Services (DDS). This system will help the Health Organization efficiently manage and track all the abuse reports, smoothen the investigation process and also help the Human Rights Committee (HRC) in their decision to make appeals by providing them the details of initial report.
This application uses a client/server based model. The client is what the user uses to create and edit the abuse report. The client program will communicate with a MySQL server that saves all the information for each abuse report. The information saved in the database is about all the related files with the initial abuse report. It includes some personal information (i.e. name of victim, etc.)
1.2 Acronyms and Abbreviations
DPPC - Disabled Persons Protection Commission
DDS- Department of Developmental Services
HRC- Human Rights Committee
IP – Internet Protocol. A number address that is unique for every computer on a network.
LAN – Local Area Network. This is a network of computers that are located in close vicinity.
MySQL – This is a free SQL database used to store all information for each student.
2.0 System Summary
User’s Manual
2.0 SYSTEM SUMMARY
2.0 System Summary
User’s Manual Page 2-1
2.0 SYSTEM SUMMARY SYSTEM SUMMARY SYSTEM SUMMARYSYSTEM SUMMARY
2.1 System Configuration
Each user uses their own computer running Windows OS. On those computers users will open the application through internet browsers by typing the fixed URL. The web application will connect to a central database running Windows and MySQL database software. The healthcare agency users can either get access to the web application by internet or by LAN network with server in the same LAN. With all the computers connect to the LAN would help protect the sensitive information
2.2 User Access Levels
 Staff users are healthcare agency employees who have authority to create abuse report and edit report before submit to supervisor, the report would be store into database. Staff have no more authority to other stuff.
 Supervisor users are healthcare agency employees who have authority to modify the initial abuse report and deal with all the following stuff (i.e. attach disposition letter, decision letter, appeal, etc.)
 HRC users are Human Rights Committee employees who have authority to view all the initial abuse report but have no authority to modify them.
 Administrator are person who would maintain the using condition of web application and database.
Web server
Staff from healthcare agency
Supervisor from healthcare agency
HRC
DDS and DPPC
Administrator
Central database
3.0 Getting Started
User’s Manual
3.0 GETTING STARTED
3.0 Getting started
User’s Manual Page 3-1
3.0 GETTING STARTED GETTING STARTED GETTING STARTED
3.1 Setting up MySQL and Apache Tomcat
 MySQL is an open source relational database management system. It’s a popular choice of database for use in web applications.
 Apache Tomcat is an open source web server and servlet container. Tomcat implements the Java Servlet and the Java Server Pages (JSP) specifications from Sun Microsystems, and provides a "pure Java" HTTP web server environment for Java code to run in.
 MySQL Reference Manual https://dev.mysql.com/doc/index.html
 Apache Tomcat reference http://tomcat.apache.org/
3.2 Create the database
Run the command in MySQL Workbench:
CREATE DATABASE `51test` /*!40100 DEFAULT CHARACTER SET utf8 */;
3.3 Setting up database
A. Click the MySQL Workbench import function
3.0 Getting started
User’s Manual Page 3-2
B. Choose the "MySQL_DATA" fold in "Install Instruction" folder, Click the start import to input initial data
3.4 Setting up Database connection
A. Installing the MySQL Connector
database.driverClassName:
Change it if use other database, only accept MySQL now.
database.url:
Change it to database server address.
database.username:
The account name to access the database.
database.password:
The account password
B. Copy the "DOSS" folder to the tomcat path "..\webapps"
3.0 Getting started
User’s Manual Page 3-3
3.5 Running Tomcat
../apache-tomcat/bin/startup.bat
3.6 Open web application
Input the URL such as "127.0.0.1:8080/DOSS" to access the application
4.0 Using the web application
User’s Manual
4.0 USING THE WEB APPLICATION
4.0 Using the web application
User’s Manual Page 4-1
4.0 USING THE USING THE WEBWEB APPLICATION APPLICATION APPLICATION
4.1 Users Login
 Different users enter different ID and password
4.2 Staff users from healthcare agency
 Main menu of staff:
4.2.1 Create new report
 Click New report, there would be a form:
4.0 Using the web application
User’s Manual Page 4-2
(1) After typing all, click submit button, the report would be sent to supervisor
(2) After typing all, click save, the report would be saved to report list. Once staff wants to edit or delete the report before sent it to supervisor, staff could select edit or delete report in report list.
(3) Once staff click submit in the report form, staff can no longer edit the initial report.
(4) If the form is filled in with details missing, the page would automatically remind the user
4.3 Supervisor users from healthcare agency
 Main menu of supervisor:
(1) Modify initial report
4.0 Using the web application
User’s Manual Page 4-3
 Supervisor clicks waiting list, all the report submitted by staff would be in the list, click edit, supervisor could modify the initial report. After modify the report, click send, the report would be sent to the finish list and supervisor could no more modify it.
(2) Print and send the abuse report to DPPC or DDS
 Click Finish list
 Click view, the report would be displayed in PDF format. Print by right click the mouse. Send the printed report by fax or mail.
(3) Track report and attach files
 Click track investigation, the application would display a column requiring type in public log number of the report you want to track.
4.0 Using the web application
User’s Manual Page 4-4
 Type in the PLN and click check available
a) If there are already files you want to track, just click the file and download
b) If the supervisor got the files and want to attach the files into the application, just click choose the file and submit.
c) After tracking, click return to return to the main menu.
4.4 HRC employee user
 Main menu of HRC employee users
(1) View initial report
Click list report (all initial), HRC employee could view the initial report
(2) View investigation files
Click list investigation(all) , search the report id, the related files would be displayed, view by click view
(3) Create new appeal
4.0 Using the web application
User’s Manual Page 4-5
Click the New appeal, there would be an appeal form, create by typing in information
4.5 Administrator
 Main menu of administrator
(1) Manage Users of the system
Administrator could manage the user information of all the users
(2) Super administrator
Super administrator user could be the boss of Healthcare agency, who has the authority of viewing all the files related to any abuse report.
5.0 Troubleshoot problems and get support
User’s Manual
5.0 TROUBLESHOOT PROBLEMS AND GET SUPPORT
5.0 Troubleshoot problems and get support
User’s Manual Page 5-1
5.0 TROUBLESHOOT PROBLEM TROUBLESHOOT PROBLEM TROUBLESHOOT PROBLEM TROUBLESHOOT PROBLEM S AND GET SUPPORT S AND GET SUPPORTS AND GET SUPPORTS AND GET SUPPORT S AND GET SUPPORT
5.1 Troubleshoot
Problem
Cause
Solution
Unable to open the website
1. Not connect to the internet or bad condition of network
2. Server is broken down
1. Looking for a workplace with good network
2. Call administrator
Users could not login the app
1. Forgot username or password
2. The user is being blocked for some reason
1. Ask administrator for help
Unable to normally use the application
1. Users didn’t read the user guide and have no idea how to use the application
2. Software has some design flaws
1. Follow the instructions on the User guide
2. Call the developer of software for help
5.2 Support service
If you have a problem, follow these steps:
1. Check the documentation that came with the product.
2. Visit the online support Web site at https://github.com/ycj28c/Team-CS509 ). Online support is available to all customers.
3. Call support: 1-774-xxx-xxxx. Support options and availability vary by device, country/region, and language.
