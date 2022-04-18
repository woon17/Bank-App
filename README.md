# Bank-App

The Bank App is an application where customers can perform banking activities on a regular basis 24/7. It consists of the front-end, which is built using html,css and jsp files where users interact with. The application interacts with the Oracle database via Java Servlets, which is mainly used for logic processing purposes such as performing CRUD operations. Main features of the application include registering and logging in of account, withdrawal of money, checking balance, applying for loan and viewing of statements. 

## Table of Contents

- [Bank-App](#bank-app)
	- [Table of Contents](#table-of-contents)
		- [Tools Required](#tools-required)
		- [MVC Design pattern:](#mvc-design-pattern)
		- [Frameworks:](#frameworks)
		- [Database setup](#database-setup)
		- [Feature 1: Registration](#feature-1-registration)
			- [Failure condition:](#failure-condition)
		- [Feature 2: Login](#feature-2-login)
			- [Failure condition:](#failure-condition-1)
		- [Feature 3: Change password](#feature-3-change-password)
			- [Failure condition:](#failure-condition-2)
		- [Feature 4: Check Account Balance](#feature-4-check-account-balance)
		- [Feature 5: View Transaction History](#feature-5-view-transaction-history)
			- [Failure condition:](#failure-condition-3)
		- [Feature 6: Apply Loan: (DEBIT)](#feature-6-apply-loan-debit)
			- [Validation:](#validation)
		- [Feature 7: Withdrawal (CREDIT)](#feature-7-withdrawal-credit)
			- [Validation:](#validation-1)
	- [Contributing](#contributing)
	- [Versioning](#versioning)
	- [Authors](#authors)
			- [Madhur Taneja](#madhur-taneja)
	- [License](#license)
	- [Acknowledgments](#acknowledgments)

### Tools Required

All tools required go here. You would require the following tools to develop and run the project:

- A text editor or an IDE (like Eclipse)
- Tomcat v7.0 Server

### MVC Design pattern:

- The Model defines the business layer of the application, the Controller manages the flow of the application, and the View defines the presentation layer of the application.

### Frameworks:

- Hibernate
  - used Hibernate Java-based configuration without using hibernate.cfg.xml to connect oracle database.
  - Reason to choose: Hibernate provides an implementation of the Java Persistence API, that makes it a great choice as an ORM tool with benefits of loose coupling.
- Annotation:

  - Eliminate the need to create mapping (hbm) file. Here, hibernate annotations are used to provide the meta data.
  - @Entity annotation marks this class as an entity.

    ```
    @Entity
    ```

  - @Table annotation specifies the table name where data of this entity is to be persisted. If you don't use @Table annotation, hibernate will use the class name as the table name by default.

    ```
    @Table(name = "CUSTOMERDB")
    ```

  - @Id annotation marks the identifier for this entity.

  ```
  @Id // primary key
  ```

  - @Column annotation specifies the details of the column for this property or field. If @Column annotation is not specified, property name will be used as the column name by default.

  ```
  @Column(name = "USERNAME ")
  private String cusUserName;
  ```

  ```
  @Column(name = "NAME")
  private String cusName;
  ```

### Database setup

- CUSTOMERDB
  - | NAME: varchar  | topic                          |
    | -------------- | ------------------------------------ |
    | _Java Section_ | `Scanner Class`             |
	
- TRANSACTIONDB

### Feature 1: Registration

> register a new customer and saved to CUSTOMERDB

#### Failure condition:

- Username exist
- Confirm password not match
- Empty fields

### Feature 2: Login

> customer login to choose further action

#### Failure condition:

- Non-existing username
- Invalid username
- Invalid password

### Feature 3: Change password

> customer can change password after login successfully

#### Failure condition:

- Confirm New password not matched
- Old password is wrong
- Old password and new password are the same

### Feature 4: Check Account Balance

>

### Feature 5: View Transaction History

> Show Transaction History within the selected Start/End, Date range (inclusive), including “Empty” Transaction History

#### Failure condition:

- Invalid Date Range (E.g. From 29/4/2022 to 1/4/2022)

### Feature 6: Apply Loan: (DEBIT)

> Show Transaction History within the selected Start/End, Date range (inclusive), including “Empty” Transaction History

#### Validation:

- Enter $1 and above as valid loan amount
- Handle negative & zero values

### Feature 7: Withdrawal (CREDIT)

#### Validation:

- Check withdraw amount less than bank balance
- Handle negative values and zero values

## Contributing


Mention what you expect from the people who want to contribute

We'd love to have your helping hand on `Project Title`! See [CONTRIBUTING.md] for more information on what we're looking for and how to get started.

## Versioning

If your project has multiple versions, include information about it here.

For the available versions, see the [tags on this repository][tags]

## Authors

#### Madhur Taneja

- [GitHub]
- [LinkedIn]

You can also see the complete [list of contributors][contributors] who participated in this project.

## License

`Project Title` is open source software [licensed as MIT][license].

## Acknowledgments

This section can also be called as `Resources` or `References`

- Code Honor if someone's work was referred to
- Tutorials followed
- Articles that helped
- Inspiration
- etc

[//]: # "HyperLinks"
[github repository]: https://github.com/madhur-taneja/README-Template
[github pages]: https://madhur-taneja.github.io/README-Template
[contributing.md]: https://github.com/madhur-taneja/README-template/blob/master/CONTRIBUTING.md
[tags]: https://github.com/madhur-taneja/README-template/tags
[github]: https://github.com/madhur-taneja
[linkedin]: https://www.linkedin.com/in/madhur-taneja/
[contributors]: https://github.com/madhur-taneja/README-template/contributors
[license]: https://github.com/madhur-taneja/README-template/blob/master/LICENSE.md
