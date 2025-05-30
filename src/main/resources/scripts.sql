CREATE DATABASE StudentSelfReflectionDB;
USE StudentSelfReflectionDB;
desc student_user;
desc roles;

-- Execute this whenever the new schema is created.
INSERT INTO roles(roles_name,created_at,created_by) VALUES
('ADMIN',curdate(),'DBA'),
('TEACHER',curdate(),'DBA'),
('STUDENT',curdate(),'DBA');
