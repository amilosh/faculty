# Faculty
The goal of the project is to document the educational process at the faculty with grading students for each subject.

## Stack of technologies
1. Project: **three-layer** architecture.
2. Build automation tool: **Maven**.
3. Frameworks: **Hibernate, Spring (MVC, Security)**.
4. Database: **MySQL**.
5. Testing: **JUnit**.
6. Logging: **Log4j**.
7. Second layer cache: **EhCache**.
8. View: **JSP, HTML, CSS, i18n, l10n, JavaScript, JQuery, Ajax**.
9. Misc.: **POJO, HQL, Pagination, @Validator, Cobertura**.

## Description
1. **Admin** can add courses, add roles and browse all students and teachers. And expel student from faculty.
2. User can register like **Student** or **Teacher**.
    1. **Student** can enroll for several courses and see his grades.
    2. **Teacher** can choose one course for teaching; can see all student enrolled for this course; and can give grades to students.
3. **Security** settings: one user - one role.

## Project structure
Faculty is a multi-module  [Maven](http://maven.apache.org/download.cgi) project structured in the following way:
```
+---Faculty
|   +---entity
|   +---dao
|   +---service
|   +---web
```
* **Faculty** - the parent project
* **entity** - contains domain objects used by the other modules (dao, service, web)
* **dao** - code for database access
* **service** - businaess-logic of the project
* **web** - navigation by application through **Spring MVC**: and security by **Spring Security**

## Required environment
1. JDK 1.8
2. MySQL 5.7
3. Maven 3.3
4. Tomcat 8
5. (optonal) Git
6. (optional) IDE (Eclipse or IntelliJ IDEA)

## Deploying project
### Download project
```
git clone https://github.com/amilosh/faculty.git
```
or
```
Donwload ZIP
```
### Prepare MySql Database
Open **beans-dao.xml** in project:
```
{project classpath}\dao\src\main\resources\beans-dao.xml
```
Change the **username/password** corresponding to your **root** user, configured at installation time:
```
<bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource">
        <property name="url" value="jdbc:mysql://localhost:3306/Faculty?createDatabaseIfNotExist=true"/>
        <property name="driverClassName" value="com.mysql.jdbc.Driver"/>
        <property name="username" value="root"/><!-- use your installation admin user-->
        <property name="password" value="12345"/><!-- use your installation admin user's password-->
    </bean>
```
### Build project
```
{project classpath}> mvn clean install -Dmaven.test.skip=true
```
### Run Tomcat
```
{tomcat classpath}\bin> startup
```
### Deploy application
Copy **faculty.war** from
```
{project classpath}\web\target\faculty.war
```
to
```
{tomcat classpath}\webapps
```
### Setup
For creating **roles** and setup **username/password of admin** follow this link in **browser**:
```
http://localhost:8080/faculty/setup
```
and insert username and password.
