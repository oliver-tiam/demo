--
-- Data insert for table `roles`
--
INSERT INTO `roles` (`name`)
VALUES
       ('ADMIN'),
       ('USER');

--
-- Data insert for table `users`
--
INSERT INTO `users` (`username`, `password`, `enabled`)
VALUES
       ('admin', '$2a$10$E4gAviXtbH8UguyxKtcah.dKlpBNBvB.tdNlBPaVHEwPJPIA.4SUS', '1'),
       ('user', '$2a$10$rpA0YoNbfyNRw4najHUC4OvqiF3pNSUq9YH8unmzHWndwDdmNnPfu', '1');

--
-- Data insert for table `users_roles`
--
INSERT INTO `users_roles` (`user_id`, `role_id`)
VALUES
       (1, 1),  -- user 'admin' has role ADMIN
       (2, 2);  -- user 'user' has role USER

--
-- Data insert for table `employees`
--
INSERT INTO `employees` (`first_name`, `middle_name`, `last_name`, `birth_date`, `gender`, `marital_status`, `position`, `date_hired`)
VALUES
       ('Alfred', 'William', 'David', '1955-03-02', 'M', 'Married', 'Finance Manager', '1970-04-20'),
       ('Jimmy', 'Hanford', 'Crawford', '1958-03-02', 'M', 'Single', 'Senior Accountant', '1989-06-28'),
       ('Steven', 'Sinatra', 'Ford', '1968-03-02', 'M', 'Divorced', 'Supervisor', '1989-06-28'),
       ('Ray', 'Shawn', 'Butler', '1980-04-18', 'M', 'Single', 'Marketing Executive', '1999-05-15');